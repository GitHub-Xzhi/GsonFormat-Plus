package org.gsonformat.intellij.common;

import org.apache.http.util.TextUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by dim on 16/11/5.
 */
public class StringUtils {

    /**
     * 转成驼峰
     *
     * @param text
     * @return
     */
    public static String captureStringLeaveUnderscore(String text) {
        if (TextUtils.isEmpty(text)) {
            return text;
        }
        String temp = text.replaceAll("^_+", "");

        if (!TextUtils.isEmpty(temp)) {
            text = temp;
        }
        String[] strings = text.split("_");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(strings[0]);
        for (int i = 1; i < strings.length; i++) {
            stringBuilder.append(captureName(strings[i]));
        }
        return stringBuilder.toString();
    }

    public static String captureName(String text) {

        if (text.length() > 0) {
            text = text.substring(0, 1).toUpperCase() + text.substring(1);
        }
        return text;
    }

    public static String getPackage(String generateClassName) {
        int index = generateClassName.lastIndexOf(".");
        if (index > 0) {
            return generateClassName.substring(0, index);
        }
        return null;
    }

    /**
     * 是否全是大写字母
     * @param word
     * @return true有，false没有
     */
    public static boolean allUpperCase(String word) {
        word = word.replaceAll("[_\\-]", "");
        Pattern pattern = Pattern.compile("^[A-Z]+$");
        Matcher matcher = pattern.matcher(word);
        return matcher.find();
    }

    public static String allUpperCase2LowerCase(String word) {
        if (allUpperCase(word)) {
            word = word.toLowerCase();
        }
        return word;
    }
}
