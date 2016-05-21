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
 * DES[���ݼ��ܱ�׼]--�ԳƼ���
 * ֻ��һ����Կ
 * @author ljheee
 *
 */
public class DESencrypt extends EncryptDecorator{

	static String ALGORITHM = "DES";
	static SecretKey secretKey = null;
	static Cipher cipher = null;
	
	public DESencrypt() {//�չ��췽��--Ϊ�˵���  ʹ��������ķ���
	}

	public DESencrypt(Encryptor encryptor) {
		super(encryptor);
	}
	
	static{//������Կ
		try {
			KeyGenerator keyGenerator = KeyGenerator.getInstance(ALGORITHM);
			keyGenerator.init(new SecureRandom());
			secretKey = keyGenerator.generateKey();//������Կ
			
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
	 * DES--����
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
	 * DES--����
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
		System.out.println("���ܺ�� ����:"+str);//������ܺ��   ����
	
		System.out.println(new String(des.desDeEncrypt(str)));//������ܺ������
	}
	
	
}
