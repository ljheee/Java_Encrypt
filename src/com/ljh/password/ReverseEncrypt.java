package com.ljh.password;
/**
 * ������ܡ�����
 * ԭ���ַ������򷵻�
 * ����--�Ǿ���װ����
 * @author ljheee
 *
 */
public class ReverseEncrypt extends EncryptDecorator {
	
	//���Ҫ����ʹ�ô˼����㷨��newһ���յģ�����reverse()����
	public ReverseEncrypt() {
	}

	
	/**
	 * ���췽����
	 * @param encryptor  �Ӹ���̳�����Encryptor encryptor
	 */
	public ReverseEncrypt(Encryptor encryptor) {
		super(encryptor);
	}



	@Override
	public String deEncrypt(String text) {
		
		String result = null;
		result = this.reverse(super.deEncrypt(text));//�������Σ���ԭ�ַ���
		
		return result;
	}

	@Override
	public String encrypt(String text) {
		String result = null;
		result = this.reverse(super.encrypt(text));
		return result;
	}
	
	/**
	 * ��̬�����ķ���--����ʹ��ʱֱ���ö������
	 * ���򣺷����ַ���
	 * ��������  ��ԭ�ַ�
	 */
	public String reverse(String text){
		
		String result = null;
		char[] charArray = text.toCharArray();
		int length = charArray.length;
		char[] newChar = new char[length];
		int i = 0;
		for (int j = length-1; j >=0; j--) {
			newChar[i++] = charArray[j];
		}
		result = new String(newChar);
		return result;
		
	}
	

}
