package com.wenxia.snippet.snowflake;

/**
 * @Author zhouw
 * @Description
 * @Date 2020-01-07
 */
public class SnowflakeIdWorker {

    /**
     * 开始时间：2020-01-01 00:00:00
     */
    private static final long BEGIN_TS = 1577808000000L;

    private static final long WORKER_ID_BITS = 10;

    /**
     * 2^10 - 1 = 1023
     */
    private static final long MAX_WORKER_ID = ~(-1L << WORKER_ID_BITS);

    private static final long SEQUENCE_BITS = 12;

    /**
     * 2^12 - 1 = 4095
     */
    private static final long MAX_SEQUENCE = ~(-1L << SEQUENCE_BITS);

    /**
     * 时间戳左移22位
     */
    private static final long TIMESTAMP_LEFT_OFFSET = WORKER_ID_BITS + SEQUENCE_BITS;

    /**
     * 业务ID左移12位
     */
    private static final long WORKER_ID_LEFT_OFFSET = SEQUENCE_BITS;

    /**
     * 合并了机器ID和数据标示ID，统称业务ID，10位
     */
    private final long workerId;

    /**
     * 毫秒内序列，12位，2^12 = 4096个数字
     */
    private long sequence = 0L;

    /**
     * 上一次生成的ID的时间戳，同一个worker中
     */
    private long lastTimestamp = -1L;

    public SnowflakeIdWorker(long workerId) {
        if (workerId > MAX_WORKER_ID || workerId < 0) {
            throw new IllegalArgumentException(String.format("WorkerId必须大于或等于0且小于或等于%d", MAX_WORKER_ID));
        }

        this.workerId = workerId;
    }

    public synchronized long nextId() {
        long ts = System.currentTimeMillis();
        if (ts < lastTimestamp) {
            throw new RuntimeException(String.format("系统时钟回退了%d毫秒", (lastTimestamp - ts)));
        }

        // 同一时间内，则计算序列号
        if (ts == lastTimestamp) {
            // 序列号溢出
            if (++sequence > MAX_SEQUENCE) {
                ts = tilNextMillis(lastTimestamp);
                sequence = 0L;
            }
        } else {
            // 时间戳改变，重置序列号
            sequence = 0L;
        }

        lastTimestamp = ts;

        // 0 - 00000000 00000000 00000000 00000000 00000000 0 - 00000000 00 - 00000000 0000
        // 左移后，低位补0，进行按位或运算相当于二进制拼接
        // 本来高位还有个0<<63，0与任何数字按位或都是本身，所以写不写效果一样
        return (ts - BEGIN_TS) << TIMESTAMP_LEFT_OFFSET | workerId << WORKER_ID_LEFT_OFFSET | sequence;
    }

    /**
     * 阻塞到下一个毫秒
     *
     * @param lastTimestamp
     * @return
     */
    private long tilNextMillis(long lastTimestamp) {
        long ts = System.currentTimeMillis();
        while (ts <= lastTimestamp) {
            ts = System.currentTimeMillis();
        }

        return ts;
    }
}
