package com.github.loongchen.utils.crypto;

import java.security.DigestException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * 为验证微信签名定制的SHA1加密算法
 * @author loong
 *本类借鉴了 http://blog.csdn.net/u012105931/article/details/51088312#
 */
public class SHA1 {

	 /** 
     * SHA1 安全加密算法 
     * @param maps 参数key-value map集合 
     * @return 
     * @throws DigestException  
     */  
    public static String encode(Map<String,String> maps){  
        //获取信息摘要 - 参数字典排序后字符串  
        String decrypt = getOrderByLexicographic(maps); 
        StringBuffer hexString = new StringBuffer();  
        try {  
            //指定sha1算法  
            MessageDigest digest = MessageDigest.getInstance("SHA-1");  
            digest.update(decrypt.getBytes());  
            //获取字节数组  
            byte messageDigest[] = digest.digest();  
           
            // 字节数组转换为 十六进制 数  
            for (int i = 0; i < messageDigest.length; i++) {  
                String shaHex = Integer.toHexString(messageDigest[i] & 0xFF);  
                if (shaHex.length() < 2) {  
                    hexString.append(0);  
                }  
                hexString.append(shaHex);  
            }  
  
        } catch (NoSuchAlgorithmException e) {  
            e.printStackTrace();  
        }  
        return hexString.toString().toUpperCase();  
    }  
    
    /** 
     * 获取参数的字典排序 
     * @param maps 参数key-value map集合 
     * @return String 排序后的字符串 
     */  
    private static String getOrderByLexicographic(Map<String,String> maps){  
        return splitParams(lexicographicOrder(getParamsValue(maps)));  
    }  
    /** 
     * 获取参数 value 
     * @param maps 参数key-value map集合 
     * @return 
     */  
    private static List<String> getParamsValue(Map<String,String> maps){  
        List<String> paramValues = new ArrayList<String>();  
        for(Map.Entry<String,String> entry : maps.entrySet()){  
        	paramValues.add(entry.getValue());  
        }  
        return paramValues;  
    }  
    
    /** 
     * 参数名称按字典排序 
     * @param paramNames 参数名称List集合 
     * @return 排序后的参数名称List集合 
     */  
    private static List<String> lexicographicOrder(List<String> paramValues){  
        Collections.sort(paramValues);  
        return paramValues;  
    }  
    
    /** 
     * 拼接排序好的参数值 
     * @param paramNames 排序后的参数名称集合 
     * @param maps 参数key-value map集合 
     * @return String 拼接后的字符串 
     */  
    private static String splitParams(List<String> paramValues){  
        StringBuilder paramStr = new StringBuilder();  
        for(String paramValue : paramValues){  
        	paramStr.append(paramValue);
        }  
        return paramStr.toString();  
    }  

}
