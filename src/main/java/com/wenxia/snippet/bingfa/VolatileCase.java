package com.wenxia.snippet.bingfa;

/**
 * @Author zhouw
 * @Description
 * @Date 2020-08-14
 */
public class VolatileCase {

    private static volatile boolean notice = false;
    private static volatile int number = 0;

    public static void main(String[] args) throws Exception {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("hello");
                if (i == 4) {
                    notice = true;
                }

                try {
                    Thread.sleep(300);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(() -> {
            while (true) {
                if (notice) {
                    System.out.println("收到通知，开始工作");
                    break;
                }
            }
        });

        t1.start();
        t2.start();

        // volatile 不保证原子性
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                for (int j = 0; j < 10000; j++) {
                    number++;
                }
            }).start();
        }

        while (Thread.activeCount() > 2) {
            // 只要有存活的线程，主线程一直让步
            Thread.yield();
        }

        System.out.println("number: " + number);
    }
}
