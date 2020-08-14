package com.wenxia.snippet.jol;

import org.openjdk.jol.info.ClassLayout;

/**
 * @Author zhouw
 * @Description
 * @Date 2020-08-12
 */
public class JolMain {

    public static void main(String[] args) throws Exception {
        // JVM延迟加载偏向锁
        Thread.sleep(5000);
        Apple apple = new Apple();
        //System.out.println(apple.hashCode());
        synchronized (apple) {
            System.out.println(ClassLayout.parseInstance(apple).toPrintable());
        }

        Thread t1 = new Thread(() -> {
            synchronized (apple) {
                System.out.println(">>>>>>>>>1");
                System.out.println(ClassLayout.parseInstance(apple).toPrintable());
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (apple) {
                System.out.println(">>>>>>>>>2");
                System.out.println(ClassLayout.parseInstance(apple).toPrintable());
            }
        });

        t1.start();
        t2.start();
    }
}
