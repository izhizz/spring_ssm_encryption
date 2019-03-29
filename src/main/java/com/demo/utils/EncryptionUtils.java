package com.demo.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class EncryptionUtils {



    /**
     * 特性： 可逆
     * String 倒叙转 ASCII+某个数字 在转回 String
     */
//================================================start=================================================================
    /**
     * 加密
     * @param value
     * @param encrypteDigital
     * @return
     */
    public static String asciiToPassword(String value, Integer encrypteDigital) {
        String s = stringFlashBackASCII(value);
        String[] split = s.split(",");
        List<Integer> allFinger = new ArrayList<>();
        for (int i = split.length - 1; i >= 0; i--) {
            String v = split[i];
            allFinger.add(Integer.parseInt(v) + encrypteDigital);
        }
        String join = StringUtils.join(allFinger, ",");
        return asciiFlashBackString(join);
    }
    /**
     * 解密
     * @param value
     * @param encrypteDigital
     * @return
     */
    public static String asciiDecrPassword(String value, Integer encrypteDigital) {
        String s = stringFlashBackASCII(value);
        String[] split = s.split(",");
        List<Integer> allFinger = new ArrayList<>();
        for (int i = split.length - 1; i >= 0; i--) {
            String v = split[i];
            allFinger.add(Integer.parseInt(v) - encrypteDigital);
        }
        String join = StringUtils.join(allFinger, ",");
        String data = asciiFlashBackString(join);
        return data;
    }
    /**
     * String转Ascii
     *
     * @param value
     * @return
     */
    private static String stringFlashBackASCII(String value) {
        StringBuffer sbu = new StringBuffer();
        char[] chars = value.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (i != chars.length - 1) {
                sbu.append((int) chars[i]).append(",");
            } else {
                sbu.append((int) chars[i]);
            }
        }
        return sbu.toString();
    }

    /**
     * Ascii转String
     *
     * @param value
     * @return
     */
    private static String asciiFlashBackString(String value) {
        StringBuffer sbu = new StringBuffer();
        String[] chars = value.split(",");
        for (int i = 0; i < chars.length; i++) {
            sbu.append((char) Integer.parseInt(chars[i]));
        }
        return sbu.toString();
    }
    //================================================end=================================================================













    public static void main(String[] args) {
        System.out.println(asciiToPassword("aa", 1));
        System.out.println(asciiDecrPassword(asciiToPassword("aa", 1), 1));
    }
}
