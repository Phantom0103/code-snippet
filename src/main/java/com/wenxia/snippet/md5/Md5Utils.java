package com.wenxia.snippet.md5;

import java.security.MessageDigest;

/**
 * @Author zhouw
 * @Description
 * @Date 2019-09-03
 */
public class Md5Utils {

    private Md5Utils() {

    }

    /**
     * 生成32位md5
     *
     * @param str
     * @return
     */
    public static String string2Md5(String str) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");

            char[] charArray = str.toCharArray();
            byte[] byteArray = new byte[charArray.length];

            for (int i = 0; i < charArray.length; i++) {
                byteArray[i] = (byte) charArray[i];
            }
            byte[] md5Bytes = md5.digest(byteArray);

            StringBuffer hexValue = new StringBuffer();
            for (int i = 0; i < md5Bytes.length; i++) {
                int val = ((int) md5Bytes[i]) & 0xff;
                if (val < 16) {
                    hexValue.append("0");
                }
                hexValue.append(Integer.toHexString(val));
            }

            return hexValue.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }

    }

    /**
     * 生成16位md5
     *
     * @param str
     * @return
     */
    public static String string2Md5_16(String str) {
        String md5 = string2Md5(str);
        return md5.substring(8, 24);
    }
}
