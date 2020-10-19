package com.reggie.movie.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author yuncheng.xie
 * @date 10/19/20 6:59 PM
 * ticket: AMS-11595
 * description: TextUtil
 */
public class TextUtil {
    private static Pattern humpPattern = Pattern.compile("[A-Z]");

    public static String humpToLine(String str) {
        Matcher matcher = humpPattern.matcher(str);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, "_" + matcher.group(0).toLowerCase());
        }
        matcher.appendTail(sb);
        return sb.toString();
    }
}
