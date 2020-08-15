package com.wenxia.snippet.bingfa;

/**
 * @Author zhouw
 * @Description
 * @Date 2020-08-15
 */
public class ThreadLocalCase {

    public static void main(String[] args) {
        ThreadLocal<String> a = new ThreadLocal<>();
        ThreadLocal<String> b = new ThreadLocal<>();

        Thread t1 = new Thread(() -> {
            try {
                a.set("abc");
                b.set("apple");
                Thread.sleep(2000);
                System.out.println("t1: " + a.get() + "-" + b.get());
                a.remove();
                b.remove();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                //a.set("def");
                b.set("banana");
                Thread.sleep(2000);
                System.out.println("t2: " + a.get() + "-" + b.get());
                a.remove();
                b.remove();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();
    }
}
