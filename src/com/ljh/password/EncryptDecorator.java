package com.ljh.password;

import java.security.InvalidKeyException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;

/**
 * 加密--装饰器类
 * 是个抽象类
 * @author ljheee
 *
 */
public abstract class EncryptDecorator extends Encryptor {
	//组合一个“抽象组建”Encrypt的引用
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
