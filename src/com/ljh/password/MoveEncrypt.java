package com.ljh.password;
/**
 * “∆Œªº”√‹
 * @author ljheee
 *
 */
public class MoveEncrypt extends EncryptDecorator {

	private final int miyao = 15;
	
	public MoveEncrypt() {
	}

	public MoveEncrypt(Encryptor encryptor) {
		super(encryptor);
	}

	@Override
	public String encrypt(String text) {

		String result = null;
		result = this.rightMove(super.deEncrypt(text));
		
		return result;
	}

	@Override
	public String deEncrypt(String text) {

		String result = null;
		result = this.leftMove(super.deEncrypt(text));
		
		return result;
	}
	
	public String rightMove(String text){
		
		String result = null;
		char[] charArray = text.toCharArray();
		char[] newChar = new char[charArray.length];
		int i=0;
		for (char c : charArray) {
			newChar[i++] = (char) (c+miyao);
		}
		result = new String(newChar);
		return result;
		
	}
	
	public String leftMove(String text){
		
		String result = null;
		char[] charArray = text.toCharArray();
		char[] newChar = new char[charArray.length];
		int i=0;
		for (char c : charArray) {
			newChar[i++] = (char) (c-miyao);
		}
		result = new String(newChar);
		return result;
	}

	
}
