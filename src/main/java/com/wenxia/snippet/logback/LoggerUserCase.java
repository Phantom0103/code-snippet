package com.wenxia.snippet.logback;

/**
 * @Author zhouw
 * @Description
 * @Date 2020-05-29
 */
public class LoggerUserCase {

    public static void main(String[] args) {
        CustomLogger customLogger = new CustomLogger();
        customLogger.info();

        BasicLogger basicLogger = new BasicLogger();
        basicLogger.info();
    }
}
