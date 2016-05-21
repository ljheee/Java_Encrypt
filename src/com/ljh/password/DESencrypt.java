package com.ljh.password;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

/**
 * DES[数据加密标准]--对称加密
 * 只有一个密钥
 * @author ljheee
 *
 */
public class DESencrypt extends EncryptDecorator{

	static String ALGORITHM = "DES";
	static SecretKey secretKey = null;
	static Cipher cipher = null;
	
	public DESencrypt() {//空构造方法--为了单独  使用类自身的方法
	}

	public DESencrypt(Encryptor encryptor) {
		super(encryptor);
	}
	
	static{//生成密钥
		try {
			KeyGenerator keyGenerator = KeyGenerator.getInstance(ALGORITHM);
			keyGenerator.init(new SecureRandom());
			secretKey = keyGenerator.generateKey();//生成密钥
			
			cipher = Cipher.getInstance(ALGORITHM);
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	@Override
	public String deEncrypt(String text) {
		// TODO Auto-generated method stub
		return super.deEncrypt(text);
	}

	@Override
	public String encrypt(String text) {
		// TODO Auto-generated method stub
		return super.encrypt(text);
	}
	/**
	 * DES--加密
	 * @param data
	 * @return
	 */
	public byte[] desEncrypt(byte[] data){
		byte[] result = null;
		try {
			cipher.init(Cipher.ENCRYPT_MODE, secretKey);
			result = cipher.doFinal(data);
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}
		return result;
		
	}
	
	/**
	 * DES--解密
	 * @param data
	 * @return
	 */
	public byte[] desDeEncrypt(byte[] data){
		byte[] result = null;
		try {
			cipher.init(Cipher.DECRYPT_MODE, secretKey);
			result = cipher.doFinal(data);
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public static void main(String[] args) {
		DESencrypt des = new DESencrypt();
		
		byte[] str = null;
		str = des.desEncrypt("123456".getBytes());
		System.out.println("加密后的 数据:"+str);//输出加密后的   数据
	
		System.out.println(new String(des.desDeEncrypt(str)));//输出解密后的数据
	}
	
	
}
