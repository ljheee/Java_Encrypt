package com.ljh.ui;

import javax.swing.*;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import com.ljh.password.MoveEncrypt;
import com.ljh.password.ReverseEncrypt;
import com.ljh.password.SimpleEncrypy;

import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UIFrame {
	private JFrame jf = null ;
	private JTextField textField_text;
	private JTextField textField_pass;
	
	JButton btnSimpleencrypt,btnReverseencrypt,btnMoveencrypt;
	JButton btnSimpleencrypt_1,btnReverseencrypt_1,btnMoveencrypt_1;
	private JButton btnSimpledeencrypt;
	private JButton btnReversedeencrypt;
	private JButton btnMovedeencrypt;
	private JButton btnSimpledeencrypt_1;
	private JButton btnReversedeencrypt_1;
	private JButton btnMovedeencrypt_1;
	
	public UIFrame() {
		jf = new JFrame();
		jf.setTitle("Encryptor"+"           "+"李建华  20144619");
		jf.setSize(540, 350);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setLocationRelativeTo(null);
		jf.setResizable(false);
		
		EncryptHandle handle = new EncryptHandle();
		
		JLabel label = new JLabel("\u660E\u6587\u5BC6\u7801:");
		
		textField_text = new JTextField();
		textField_text.setColumns(18);
		
		JLabel label_1 = new JLabel("\u52A0\u5BC6\u5904\u7406:");
		
		textField_pass = new JTextField();
		textField_pass.setColumns(18);
		textField_pass.setEditable(false);
		
		JLabel label_2 = new JLabel("\u5355\u72EC\u5904\u7406\u65B9\u5F0F:");
		//单独加密方式
		btnSimpleencrypt = new JButton("Simple-encrypt");
		btnSimpleencrypt.addActionListener(handle);
		
		btnReverseencrypt = new JButton("Reverse-encrypt");
		btnReverseencrypt.addActionListener(handle);
		
		btnMoveencrypt = new JButton("Move-encrypt");
		btnMoveencrypt.addActionListener(handle);
		
		//组合加密方式
		JLabel label_3 = new JLabel("\u7EC4\u5408\u7EC4\u5408\u65B9\u5F0F:");
		
		btnSimpleencrypt_1 = new JButton("SimpleEncrypt");
		btnSimpleencrypt_1.addActionListener(handle);
		
		btnReverseencrypt_1 = new JButton("ReverseEncrypt");
		btnReverseencrypt_1.addActionListener(handle);
		
		btnMoveencrypt_1 = new JButton("MoveEncrypt");
		btnMoveencrypt_1.addActionListener(handle);
		
		
		//单独--解密
		btnSimpledeencrypt = new JButton("Simple-deEncrypt");
		btnSimpledeencrypt.addActionListener(handle);
		
		btnReversedeencrypt = new JButton("Reverse-deEncrypt");
		btnReversedeencrypt.addActionListener(handle);
		
		btnMovedeencrypt = new JButton("Move-deEncrypt");
		btnMovedeencrypt.addActionListener(handle);
		
		//组合-解密
		btnSimpledeencrypt_1 = new JButton("Simple-deEncrypt");
		btnSimpledeencrypt_1.addActionListener(handle);
		
		btnReversedeencrypt_1 = new JButton("Reverse-deEncrypt");
		btnReversedeencrypt_1.addActionListener(handle);
		
		btnMovedeencrypt_1 = new JButton("Move-deEncrypt");
		btnMovedeencrypt_1.addActionListener(handle);
		
		GroupLayout groupLayout = new GroupLayout(jf.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_pass, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label_2)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnSimpledeencrypt)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnReversedeencrypt)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnMovedeencrypt))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnSimpleencrypt)
									.addGap(18)
									.addComponent(btnReverseencrypt)
									.addGap(18)
									.addComponent(btnMoveencrypt))))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label_3)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnSimpledeencrypt_1)
								.addComponent(btnSimpleencrypt_1))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnReverseencrypt_1)
								.addComponent(btnReversedeencrypt_1))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnMoveencrypt_1)
								.addComponent(btnMovedeencrypt_1))))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(21)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(textField_text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(textField_pass, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(40)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(btnSimpleencrypt)
						.addComponent(btnReverseencrypt)
						.addComponent(btnMoveencrypt))
					.addGap(3)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSimpledeencrypt)
						.addComponent(btnReversedeencrypt)
						.addComponent(btnMovedeencrypt))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(label_3)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnSimpleencrypt_1)
							.addComponent(btnMoveencrypt_1)
							.addComponent(btnReverseencrypt_1)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSimpledeencrypt_1)
						.addComponent(btnReversedeencrypt_1)
						.addComponent(btnMovedeencrypt_1))
					.addContainerGap(76, Short.MAX_VALUE))
		);
		jf.getContentPane().setLayout(groupLayout);
		
		
		
		
		jf.setVisible(true);
	}
		
	class EncryptHandle implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			textField_pass.setText("");
			if(textField_text.getText().equals("")){
				JOptionPane.showMessageDialog(null, "明文密码为空.....请输入---");
				return;
			}
			//单独加密方式
			if(e.getSource()==btnSimpleencrypt){
				SimpleEncrypy se = new SimpleEncrypy();
				String pass = se.encrypt(textField_text.getText().trim());
				textField_pass.setText(pass);
			}
			
			if(e.getSource()==btnReverseencrypt){
				ReverseEncrypt re = new ReverseEncrypt();
				String pass = re.reverse(textField_text.getText().trim());
				textField_pass.setText(pass);
				
			}
			if(e.getSource()==btnMoveencrypt){
				MoveEncrypt me = new MoveEncrypt();
				String pass = me.rightMove(textField_text.getText().trim());
				textField_pass.setText(pass);
			}
			//组合加密方式
			if(e.getSource()==btnSimpleencrypt_1){
				SimpleEncrypy se = new SimpleEncrypy();
				String pass = se.encrypt(textField_text.getText().trim());
				textField_pass.setText(pass);
				JOptionPane.showMessageDialog(null, "此加密算法是基础版本，请点击其他---实现嵌套多层加密");
			}
			
			if(e.getSource()==btnReverseencrypt_1){
				ReverseEncrypt re = new ReverseEncrypt(new SimpleEncrypy());
				String pass = re.encrypt(textField_text.getText().trim());
				textField_pass.setText(pass);
				
			}
			if(e.getSource()==btnMoveencrypt_1){
				MoveEncrypt me = new MoveEncrypt(new SimpleEncrypy());
				String pass = me.encrypt(textField_text.getText().trim());
				textField_pass.setText(pass);
			}
			//单独解密方式
			if(e.getSource()==btnSimpledeencrypt){
				SimpleEncrypy se = new SimpleEncrypy();
				String pass = se.deEncrypt(textField_text.getText().trim());
				textField_pass.setText(pass);
			}
			
			if(e.getSource()==btnReversedeencrypt){
				ReverseEncrypt re = new ReverseEncrypt();
				String pass = re.reverse(textField_text.getText().trim());
				textField_pass.setText(pass);
			}
			if(e.getSource()==btnMovedeencrypt){
				MoveEncrypt me = new MoveEncrypt();
				String pass = me.leftMove(textField_text.getText().trim());
				textField_pass.setText(pass);
			}
			//组合解密方式
			if(e.getSource()==btnSimpledeencrypt_1){
				SimpleEncrypy se = new SimpleEncrypy();
				String pass = se.deEncrypt(textField_text.getText().trim());
				textField_pass.setText(pass);
				JOptionPane.showMessageDialog(null, "此加密算法是基础版本，请点击其他---实现嵌套多层加密");
			}
			
			if(e.getSource()==btnReversedeencrypt_1){
				ReverseEncrypt re = new ReverseEncrypt(new SimpleEncrypy());
				String pass = re.deEncrypt(textField_text.getText().trim());
				textField_pass.setText(pass);
				
			}
			if(e.getSource()==btnMovedeencrypt_1){
				MoveEncrypt me = new MoveEncrypt(new SimpleEncrypy());
				String pass = me.deEncrypt(textField_text.getText().trim());
				textField_pass.setText(pass);
			}
			
		}
		
	}
	
	
	public static void main(String[] args) {
		new UIFrame();
	}
}
