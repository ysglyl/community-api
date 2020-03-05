package com.bzdnet.community.util;

import org.springframework.util.DigestUtils;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

public class FuncTool {

    public static final String uuid() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    /**
     * 判断空列表
     *
     * @param list
     * @param <T>
     * @return
     */
    public static final <T> boolean isEmptyList(Collection<T> list) {
        if (list == null || list.size() == 0) {
            return true;
        }
        return false;
    }

    /**
     * 判断非空列表
     *
     * @param list
     * @param <T>
     * @return
     */
    public static final <T> boolean isNotEmptyList(Collection<T> list) {
        return !isEmptyList(list);
    }

    /**
     * 判断空字符串
     *
     * @param str
     * @return
     */
    public static final boolean isEmptyString(String str) {
        if (str == null || "".equals(str.trim())) {
            return true;
        }
        return false;
    }

    /**
     * 判断非空字符串
     *
     * @param str
     * @return
     */
    public static final boolean isNotEmptyString(String str) {
        return !isEmptyString(str);
    }

    /**
     * 不为空
     *
     * @param t
     * @param <T>
     * @return
     */
    public static final <T> boolean isNotNull(T t) {
        if (t != null) {
            return true;
        }
        return false;
    }

    public static final boolean equals(String val1, String val2) {
        if (val1 == null) {
            if (val2 == null) {
                return true;
            }
            return false;
        }
        return val1.equals(val2);
    }

    /**
     * 不相等
     *
     * @param val1
     * @param val2
     * @return
     */
    public static final boolean notEquals(String val1, String val2) {
        return !equals(val1, val2);
    }

    /**
     * URL编码
     *
     * @param str
     * @return
     */
    public static final String UrlEncode(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (Exception e) {
            return str;
        }
    }

    /**
     * URL解码
     *
     * @param str
     * @return
     */
    public static final String UrlDecode(String str) {
        try {
            return URLDecoder.decode(str, "UTF-8");
        } catch (Exception e) {
            return str;
        }
    }

    /**
     * md5加密
     *
     * @param str
     * @return
     * @throws Exception
     */
    public static String md5(String str) {
        try {
            return DigestUtils.md5DigestAsHex(str.getBytes(StandardCharsets.UTF_8));
        } catch (Exception ex) {
            return null;
        }
    }

}
