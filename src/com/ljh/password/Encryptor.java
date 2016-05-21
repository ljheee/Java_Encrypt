package com.ljh.password;

import java.security.InvalidKeyException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;

/**
 * ��������---������
 * 
 * @author ljheee ����--�ǡ������齨��=�����ˡ������齨����װ���� ��Ҫ���С����Ρ��ķ���
 */
public abstract class Encryptor {
	/**
	 * ���ܷ���
	 * @param text	String����[�������ַ���]
	 * @return	���ܺ���ַ���
	 * @throws BadPaddingException 
	 * @throws IllegalBlockSizeException 
	 * @throws InvalidKeyException 
	 */
	public abstract String encrypt(String text);
	/**
	 * ���ܷ���
	 * @param text	String����[�������ַ���]
	 * @return	���ܺ���ַ���
	 */
	public abstract String deEncrypt(String text);

}
