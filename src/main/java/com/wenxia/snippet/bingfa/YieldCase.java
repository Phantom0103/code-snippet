package com.wenxia.snippet.bingfa;

/**
 * @Author zhouw
 * @Description
 * @Date 2020-08-14
 */
public class YieldCase {

    public static void main(String[] args) throws Exception {
        Thread t1 = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    System.out.println("a" + i);
                    Thread.sleep(400);
                    if (i == 4) {
                        Thread.yield();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    System.out.println("b" + i);
                    Thread.sleep(300);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        t1.setPriority(10);
        t2.setPriority(1);

        t1.start();
        t2.start();
    }
}
