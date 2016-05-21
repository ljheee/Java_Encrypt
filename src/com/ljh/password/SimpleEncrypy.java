package com.ljh.password;
/**
 * 简单加密--数字、字符的加密解密
 * 原理：异或
 * @author ljheee
 * 此类--是“具体组建”被装饰者
 */
public class SimpleEncrypy extends Encryptor {
	//秘钥
	private  final static int unique = 3;
	
	/**
	 * 加密
	 * @param text 明文密码
	 * @return	返回加密后的 字符串
	 */
	public  String encrypt(String text) {
		
		char[] chars = text.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			chars[i] = (char)(chars[i]^unique);
		}
		return new String(chars);
	}
	/*解密
	 * (non-Javadoc)
	 * @see com.ljh.password.Encryptor#deEncrypt(java.lang.String)
	 */
	@Override
	public String deEncrypt(String text) {
		
		char[] chars = text.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			chars[i] = (char)(chars[i]^unique);//异或2次，得到原值
		}
		return new String(chars);
	}
	
	

}
