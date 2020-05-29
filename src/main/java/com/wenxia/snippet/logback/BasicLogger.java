package com.wenxia.snippet.logback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author zhouw
 * @Description
 * @Date 2020-05-29
 */
public class BasicLogger {

    private static Logger logger = LoggerFactory.getLogger(BasicLogger.class);

    public void info() {
        logger.info("BasicLogger，一般常用的，当前时间：{}", System.nanoTime());
    }
}
