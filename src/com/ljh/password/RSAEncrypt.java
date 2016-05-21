package com.ljh.password;

import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/**
 * RSA--非对称加密
 * 采用--公钥加密、私钥解密
 * @author ljheee
 *
 */
public class RSAEncrypt extends EncryptDecorator {
	
	static RSAPublicKey publicKey = null;
	static RSAPrivateKey privateKey = null;
	static Cipher cipher = null;
	
	//初始化--密钥对
	static {
		try {
			KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
			keyPairGenerator.initialize(1024);
			
			KeyPair keyPair = keyPairGenerator.generateKeyPair();
			
			publicKey = (RSAPublicKey) keyPair.getPublic();//公钥
			privateKey = (RSAPrivateKey) keyPair.getPrivate();//私钥
			
			cipher = Cipher.getInstance("RSA");//执行  加密、解密
			
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	//如果要单独使用此加密算法，new一个空的，调用方法即可
	public RSAEncrypt() {
	}
	
	/**
	 * 构造方法：
	 * @param encryptor  从父类继承来的Encryptor encryptor
	 */
	public RSAEncrypt(Encryptor encryptor) {
		super(encryptor);
	}


	@Override
	public String deEncrypt(String text) {
		String result = null;
		byte[] srcData = super.deEncrypt(text).getBytes();
		result = new String(deEncryptByPrivateKey(srcData));
		
		return result;
	}


	@Override
	public String encrypt(String text) {
		String result = null;
		byte[] srcData = super.encrypt(text).getBytes();
		result = new String(encryptByPublicKey(srcData));
		
		return result;
	}
	
	/**
	 * 公钥--加密
	 * @param data   源数据[待加密]
	 *  publickey 加密所用的 公钥,--是类的--静态属性，拿来直接用
	 * @return
	 * @throws InvalidKeyException 
	 * @throws BadPaddingException 
	 * @throws IllegalBlockSizeException 
	 */
	public byte[] encryptByPublicKey(byte[] data ) {
		byte[] result = null;
		
		try {
			cipher.init(Cipher.ENCRYPT_MODE, publicKey);
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
	 * 私钥--解密
	 * @param data 源数据[待加密]
	 * @return
	 * @throws InvalidKeyException 
	 * @throws BadPaddingException 
	 * @throws IllegalBlockSizeException 
	 */
	private  byte[] deEncryptByPrivateKey(byte[] data) {
		byte[] result = null;
		
		try {
			cipher.init(Cipher.DECRYPT_MODE, privateKey);
			result = cipher.doFinal(data);
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		}
		return result;
		
	}
	public static void main(String[] args) {
		RSAEncrypt rsa = new RSAEncrypt();
		byte[] str = null;
			str = rsa.encryptByPublicKey("123456".getBytes());
			System.out.println(str);
			System.out.println(new String(rsa.deEncryptByPrivateKey(str)));
		
	}
	
}
