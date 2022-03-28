import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Tacket {
    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            new Thread(new Person()).start();
        }
    }
}

class Person implements Runnable {
    static int tickets = 10;
    private static final int RETRY = 10;
    private static final Lock lock = new ReentrantLock();
    private static final Condition isEmty = lock.newCondition();
    private static final Random rd = new Random();

    private boolean isHeld = false;

    @Override
    public void run() {
        for (int i = 0; i < RETRY; i++) {
            if (isHeld) {
                if (rd.nextBoolean()) {
                    refund();
                }
                break;
            } else {
                buy();
            }
        }

    }

    private void refund() {
        lock.lock();
        try {
            tickets ++;
            isHeld = false;
            isEmty.signalAll();
            System.out.println(Thread.currentThread().getName() + " 退票，余票" + tickets);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    private void buy() {
        lock.lock();
        try {
            if (tickets == 0) {
                isEmty.await(10, TimeUnit.SECONDS);
            } else {
                tickets --;
                isHeld = true;
                System.out.println(Thread.currentThread().getName() + " 购票，余票" + tickets);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
