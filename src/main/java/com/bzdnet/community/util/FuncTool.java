package com.bzdnet.community.util;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Base64;
import org.springframework.util.DigestUtils;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.spec.InvalidParameterSpecException;
import java.util.Arrays;
import java.util.Collection;
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

    public static String decodeEncryptedData(String encryptedData, String sessionKey, String iv) {
        // 被加密的数据
        byte[] dataByte = Base64.decode(encryptedData);
        // 加密秘钥
        byte[] keyByte = Base64.decode(sessionKey);
        // 偏移量
        byte[] ivByte = Base64.decode(iv);
        try {
            // 如果密钥不足16位，那么就补足.  这个if 中的内容很重要
            int base = 16;
            if (keyByte.length % base != 0) {
                int groups = keyByte.length / base + (keyByte.length % base != 0 ? 1 : 0);
                byte[] temp = new byte[groups * base];
                Arrays.fill(temp, (byte) 0);
                System.arraycopy(keyByte, 0, temp, 0, keyByte.length);
                keyByte = temp;
            }
            // 初始化
            Security.addProvider(new BouncyCastleProvider());
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding", "BC");
            SecretKeySpec spec = new SecretKeySpec(keyByte, "AES");
            AlgorithmParameters parameters = AlgorithmParameters.getInstance("AES");
            parameters.init(new IvParameterSpec(ivByte));
            cipher.init(Cipher.DECRYPT_MODE, spec, parameters);// 初始化
            byte[] resultByte = cipher.doFinal(dataByte);
            if (null != resultByte && resultByte.length > 0) {
                String result = new String(resultByte, "UTF-8");
                return result;
            }
        } catch (NoSuchAlgorithmException e) {
        } catch (NoSuchPaddingException e) {
        } catch (InvalidParameterSpecException e) {
        } catch (IllegalBlockSizeException e) {
        } catch (BadPaddingException e) {
        } catch (UnsupportedEncodingException e) {
        } catch (InvalidKeyException e) {
        } catch (InvalidAlgorithmParameterException e) {
        } catch (NoSuchProviderException e) {
        }
        return null;
    }


}
