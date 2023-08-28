package view;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import control.login;

public class login_view {
	private static JFrame frame;
	private static JTextField ID;
	private static JTextField Name;
	private static JComboBox type;
	static String typevalue[] = {"교 직 원"," 학 생 "};

	public static void login_view() {
		frame = new JFrame();
		frame.setBounds(100, 100, 386, 272);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JLabel lblLogin = new JLabel("로그인");
		lblLogin.setBounds(171, 10, 57, 15);
		frame.getContentPane().add(lblLogin);
		
		JLabel lblId = new JLabel("id");
		lblId.setBounds(39, 90, 57, 15);
		frame.getContentPane().add(lblId);
		
		JLabel lblName = new JLabel("name");
		lblName.setBounds(39, 141, 57, 15);
		frame.getContentPane().add(lblName);
		
		ID = new JTextField();
		ID.setBounds(112, 87, 172, 21);
		frame.getContentPane().add(ID);
		ID.setColumns(10);
		
		Name = new JTextField();
		Name.setBounds(112, 138, 172, 21);
		frame.getContentPane().add(Name);
		Name.setColumns(10);
		
		JLabel lblType = new JLabel("type");
		lblType.setBounds(39, 46, 57, 15);
		frame.getContentPane().add(lblType);
		
		JButton btnSign = new JButton("sign");
		btnSign.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				sign_view.signview();
			}
		});
		btnSign.setBounds(39, 188, 97, 23);
		frame.getContentPane().add(btnSign);
		
		JButton btnLogin = new JButton("login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				login.login((String) type.getSelectedItem(), ID.getText(), Name.getText());
			}
		});
		btnLogin.setBounds(198, 188, 97, 23);
		frame.getContentPane().add(btnLogin);
		
		type = new JComboBox(typevalue);
		type.setBounds(108, 43, 176, 21);
		frame.getContentPane().add(type);
	}
}
