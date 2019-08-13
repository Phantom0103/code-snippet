package com.wenxia.snippet.city;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import org.apache.commons.io.IOUtils;
import org.springframework.core.io.ClassPathResource;

import java.io.InputStreamReader;

/**
 * @Author zhouw
 * @Description
 * @Date 2019-08-13
 */
public class ProvinceCity {

    public static void main(String[] args) throws Exception {
        ClassPathResource resource = new ClassPathResource("province-city.json");
        String json = IOUtils.toString(new InputStreamReader(resource.getInputStream()));
        JSONArray array = JSON.parseArray(json);
        System.out.println(array);
    }
}
