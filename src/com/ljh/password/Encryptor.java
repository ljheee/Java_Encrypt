package com.ljh.password;

import java.security.InvalidKeyException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;

/**
 * 加密器类---抽象类
 * 
 * @author ljheee 此类--是“抽象组建”=定义了“具体组建”被装饰者 需要进行“修饰”的方法
 */
public abstract class Encryptor {
	/**
	 * 加密方法
	 * @param text	String参数[待加密字符串]
	 * @return	加密后的字符串
	 * @throws BadPaddingException 
	 * @throws IllegalBlockSizeException 
	 * @throws InvalidKeyException 
	 */
	public abstract String encrypt(String text);
	/**
	 * 解密方法
	 * @param text	String参数[待解密字符串]
	 * @return	解密后的字符串
	 */
	public abstract String deEncrypt(String text);

}
