package com.ljh.password;
/**
 * 逆向加密、加密
 * 原理：字符串逆向返回
 * 此类--是具体装饰器
 * @author ljheee
 *
 */
public class ReverseEncrypt extends EncryptDecorator {
	
	//如果要单独使用此加密算法，new一个空的，调用reverse()即可
	public ReverseEncrypt() {
	}

	
	/**
	 * 构造方法：
	 * @param encryptor  从父类继承来的Encryptor encryptor
	 */
	public ReverseEncrypt(Encryptor encryptor) {
		super(encryptor);
	}



	@Override
	public String deEncrypt(String text) {
		
		String result = null;
		result = this.reverse(super.deEncrypt(text));//逆向两次，得原字符串
		
		return result;
	}

	@Override
	public String encrypt(String text) {
		String result = null;
		result = this.reverse(super.encrypt(text));
		return result;
	}
	
	/**
	 * 动态新增的方法--单独使用时直接用对象调用
	 * 逆向：返回字符串
	 * 两次逆向  得原字符
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
