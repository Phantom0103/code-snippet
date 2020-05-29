package com.wenxia.snippet.logback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author zhouw
 * @Description
 * @Date 2020-05-29
 */
public class CustomLogger {

    private static Logger logger = LoggerFactory.getLogger(CustomLogger.class);

    public void info() {
        logger.info("CustomLogger，当前时间：{}", System.nanoTime());
    }
}
