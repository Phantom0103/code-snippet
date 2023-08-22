package com.wenxia.snippet.snowflake;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author Zhouw
 * @Date 2023/8/22
 */
public class IdGeneraterTest {

    public static void main(String[] args) {
        SnowflakeIdWorker worker = new SnowflakeIdWorker(1L);
        ExecutorService es = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            es.execute(() -> {
                for (int j = 0; j < 10; j++) {
                    System.out.println(worker.nextId());
                }
            });
        }
        es.shutdown();
    }
}
