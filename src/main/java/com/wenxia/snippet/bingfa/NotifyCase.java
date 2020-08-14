package com.wenxia.snippet.bingfa;

/**
 * @Author zhouw
 * @Description
 * @Date 2020-08-14
 */
public class NotifyCase {

    public static void main(String[] args) throws Exception {
        Object lock = new Object();

        Thread t1 = new Thread(() -> {
            try {
                synchronized (lock) {
                    for (int i = 0; i < 6; i++) {
                        System.out.println("a");
                        if (i == 2) {
                            lock.wait();
                        }
                        Thread.sleep(100);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                synchronized (lock) {
                    for (int i = 0; i < 6; i++) {
                        System.out.println("A");
                        if (i == 2) {
                            lock.wait();
                        }
                        Thread.sleep(100);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();
        Thread.sleep(3000);

        synchronized (lock) {
            lock.notifyAll();
            System.out.println("notify all");
        }
    }
}
