package com.ljh.password;

import java.util.Scanner;
/**
 * �ַ������ܡ�����
 * @author ljheee
 *ԭ���ַ���λ
 */
public class StringEncrypt {
	//���ܡ�������Կ
	private final static int miyao = 5;

/**
 * �ַ�������
 * @param srcString ��������[������]
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
 * �ַ�������
 * @param srcString ��������[������]
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
