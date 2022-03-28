/*
三个线程轮流输出ABC10次
*/

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadOnSerial {
    public static void main(String[] args) {
        UseNotify.run();
    }

    static class UseNotify {
        private static int flag = 1;
        final private static Object lock = new Object();

        final static Thread t1 = new Thread(() -> {
            synchronized (lock) {
                for (int i = 0; i < 10; i++) {
                    while (flag != 1) {
                        lock.notifyAll();
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println('A');
                    flag = 2;
                    lock.notifyAll();
                }
            }
        });

        final static Thread t2 = new Thread(() -> {
            synchronized (lock) {
                for (int i = 0; i < 10; i++) {
                    while (flag != 2) {
                        lock.notifyAll();
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println('B');
                    flag = 3;
                    lock.notifyAll();
                }
            }
        });

        final static Thread t3 = new Thread(() -> {
            synchronized (lock) {
                for (int i = 0; i < 10; i++) {
                    while (flag != 3) {
                        lock.notifyAll();
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println('C');
                    flag = 1;
                    lock.notifyAll();
                }
            }
        });

        public static void run() {
            t1.start();
            t2.start();
            t3.start();
        }
    }
}
