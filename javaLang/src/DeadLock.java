/*
java 死锁
*/

public class DeadLock {
    public final Object resourceA = new Object();
    public final Object resourceB = new Object();

    public static void main(String[] args) {
        DeadLock dl = new DeadLock();
        Runnable t1 = new Runnable() {
            @Override
            public void run() {
                synchronized (dl.resourceA) {
                    System.out.println("" + Thread.currentThread().getName() + "占有资源A");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println("" + Thread.currentThread().getName() + "尝试获取资源B");
                    synchronized (dl.resourceB) {
                        System.out.println("" + Thread.currentThread().getName() + "占有资源B");
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("" + Thread.currentThread().getName() + "结束退出");
                }
            }
        };

        Runnable t2 = new Runnable() {
            @Override
            public void run() {
                synchronized (dl.resourceB) {
                    System.out.println("" + Thread.currentThread().getName() + "占有资源B");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println("" + Thread.currentThread().getName() + "尝试获取资源A");
                    synchronized (dl.resourceA) {
                        System.out.println("" + Thread.currentThread().getName() + "占有资源A");
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("" + Thread.currentThread().getName() + "结束退出");
                }
            }
        };
        new Thread(t1).start();
        new Thread(t2).start();
    }
}