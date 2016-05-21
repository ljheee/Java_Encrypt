package com.ljh.password;

import java.util.Scanner;
/**
 * 字符串加密、解密
 * @author ljheee
 *原理：字符移位
 */
public class StringEncrypt {
	//加密、解密密钥
	private final static int miyao = 5;

/**
 * 字符串加密
 * @param srcString 明文密码[待加密]
 */
public static String encrypt(String srcString) {
		
		char[] src = srcString.toCharArray();
		int srcLen = src.length;
		
		for (int i = 0; i < srcLen; i++) {
			src[i] = (char)(src[i]+miyao);
		}
		
		return new String(src);
}

/**
 * 字符串解密
 * @param srcString 暗文密码[待解密]
 */
public static String deEncrypt(String srcString) {
	
	char[] src = srcString.toCharArray();
	int srcLen = src.length;
	
	for (int i = 0; i < srcLen; i++) {
		src[i] = (char)(src[i]-miyao);
	}
	
	return new String(src);
}

}
