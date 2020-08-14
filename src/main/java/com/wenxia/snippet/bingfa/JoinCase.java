package com.wenxia.snippet.bingfa;

/**
 * @Author zhouw
 * @Description
 * @Date 2020-08-14
 */
public class JoinCase {

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    System.out.println(1);
                    Thread.sleep(500);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                System.out.println("t1 start");
                // 相当于t2获取t1的锁，t1执行wait方法挂起t2
                // t1执行完结束前，隐式的会调用notifyAll（native方法，jvm实现），唤醒t2
                t1.join(2000);
                System.out.println("t1 end");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();
    }
}
