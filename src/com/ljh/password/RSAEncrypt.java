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
 * RSA--�ǶԳƼ���
 * ����--��Կ���ܡ�˽Կ����
 * @author ljheee
 *
 */
public class RSAEncrypt extends EncryptDecorator {
	
	static RSAPublicKey publicKey = null;
	static RSAPrivateKey privateKey = null;
	static Cipher cipher = null;
	
	//��ʼ��--��Կ��
	static {
		try {
			KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
			keyPairGenerator.initialize(1024);
			
			KeyPair keyPair = keyPairGenerator.generateKeyPair();
			
			publicKey = (RSAPublicKey) keyPair.getPublic();//��Կ
			privateKey = (RSAPrivateKey) keyPair.getPrivate();//˽Կ
			
			cipher = Cipher.getInstance("RSA");//ִ��  ���ܡ�����
			
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	//���Ҫ����ʹ�ô˼����㷨��newһ���յģ����÷�������
	public RSAEncrypt() {
	}
	
	/**
	 * ���췽����
	 * @param encryptor  �Ӹ���̳�����Encryptor encryptor
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
	 * ��Կ--����
	 * @param data   Դ����[������]
	 *  publickey �������õ� ��Կ,--�����--��̬���ԣ�����ֱ����
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
	 * ˽Կ--����
	 * @param data Դ����[������]
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
