package com.ljh.password;
/**
 * �򵥼���--���֡��ַ��ļ��ܽ���
 * ԭ�����
 * @author ljheee
 * ����--�ǡ������齨����װ����
 */
public class SimpleEncrypy extends Encryptor {
	//��Կ
	private  final static int unique = 3;
	
	/**
	 * ����
	 * @param text ��������
	 * @return	���ؼ��ܺ�� �ַ���
	 */
	public  String encrypt(String text) {
		
		char[] chars = text.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			chars[i] = (char)(chars[i]^unique);
		}
		return new String(chars);
	}
	/*����
	 * (non-Javadoc)
	 * @see com.ljh.password.Encryptor#deEncrypt(java.lang.String)
	 */
	@Override
	public String deEncrypt(String text) {
		
		char[] chars = text.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			chars[i] = (char)(chars[i]^unique);//���2�Σ��õ�ԭֵ
		}
		return new String(chars);
	}
	
	

}
