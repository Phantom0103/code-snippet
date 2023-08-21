package com.wenxia.snippet.callpy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.springframework.core.io.ClassPathResource;

/**
 * @Author Zhouw
 * @Date 2023/8/21
 */
public final class TokenCounter {

    public static int count(String content, String model) {
        try {
            ClassPathResource classPathResource = new ClassPathResource("python/TokenCounter.py");
            String pyScript = classPathResource.getFile().getCanonicalPath();
            String[] command = {"python", pyScript, content, model};
            Process process = Runtime.getRuntime().exec(command);
            BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));

            int result = 0;
            String line;
            if ((line = in.readLine()) != null) {
                result = Integer.parseInt(line);
            }

            in.close();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
