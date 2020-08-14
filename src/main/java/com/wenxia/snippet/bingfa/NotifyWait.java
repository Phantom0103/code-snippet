package com.wenxia.snippet.bingfa;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author zhouw
 * @Description
 * @Date 2020-08-14
 */
public class NotifyWait {

    private static List<String> list = new ArrayList<>();

    public static void main(String[] args) {

        Object lock = new Object();

        Thread t1 = new Thread(() -> {
            try {
                synchronized (lock) {
                    if (list.size() != 5) {
                        System.out.println("Wait begin " + System.currentTimeMillis());
                        // 释放cpu，进入阻塞
                        lock.wait();
                        System.out.println("Wait end " + System.currentTimeMillis());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                synchronized (lock) {
                    for (int i = 0; i < 10; i++) {
                        list.add("hello");
                        if (list.size() == 5) {
                            // 唤醒这个锁的wait set的线程，继续执行
                            lock.notify();
                            System.out.println("notice");
                        }
                        System.out.println(list.size());
                        Thread.sleep(1000);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();
    }
}
