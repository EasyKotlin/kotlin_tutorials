package com.easy.kotlin;

import static java.lang.System.out;

public class StringUtil {

    /**
     * 获取str的第一个字符值
     *
     * @param str
     * @return
     */
    public static String firstChar(String str) {
        if (str != null && str.length() > 0) {
            return str.charAt(0) + "";
        }
        return "";
    }

    /**
     * 获取str的最后一个字符值
     *
     * @param str
     * @return
     */
    public static String lastChar(String str) {
        if (str != null && str.length() > 0) {
            return str.charAt(str.length() - 1) + "";
        }
        return "";
    }

    public static void main(String[] args) {
        String str = "abc";
        out.println(StringUtil.firstChar(str)); // a
        out.println(StringUtil.lastChar(str)); // c
    }
}
