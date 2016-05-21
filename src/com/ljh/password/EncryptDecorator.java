package com.ljh.password;

import java.security.InvalidKeyException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;

/**
 * ����--װ������
 * �Ǹ�������
 * @author ljheee
 *
 */
public abstract class EncryptDecorator extends Encryptor {
	//���һ���������齨��Encrypt������
	protected Encryptor encryptor;
	
	public EncryptDecorator() {
	}

	public EncryptDecorator(Encryptor encryptor) {
		this.encryptor = encryptor;
	}

	@Override
	public String encrypt(String text){
		
		return this.encryptor.encrypt(text);
	}

	@Override
	public String deEncrypt(String text) {
		return this.encryptor.deEncrypt(text);
	}
	
	

	
}
