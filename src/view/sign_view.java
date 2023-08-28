package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import control.sign;

public class sign_view {
	private static JFrame frame, stdframe, proframe;
	private static JButton btnProfessor, btnStudent, btnCancle, btnInput;
	private static JLabel lblSign, lblStdnum, lblName, lblTel, lblEmail, lblYear, lblGender;
	private static JTextField setStdnum, setPronum, setName, setTel, setEmail, setYear, setGender;
	private static JButton btnNewButton;
	
	public static void signview() {
		frame = new JFrame();
		frame.setBounds(300, 300, 364, 152);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		lblSign = new JLabel("등록");
		lblSign.setFont(new Font("굴림", Font.PLAIN, 20));
		lblSign.setBounds(141, 10, 54, 30);
		frame.getContentPane().add(lblSign);
		
		btnProfessor = new JButton("교수");
		btnProfessor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
			frame.setVisible(false);
			professorsignview();
			}
		});
		btnProfessor.setBounds(121, 72, 97, 23);
		frame.getContentPane().add(btnProfessor);
		
		btnStudent = new JButton("학생");
		btnStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				studentsignview();
			}
		});
		btnStudent.setBounds(230, 72, 97, 23);
		frame.getContentPane().add(btnStudent);
		
		btnNewButton = new JButton("취소");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				login_view.login_view();
			}
		});
		btnNewButton.setBounds(12, 72, 97, 23);
		frame.getContentPane().add(btnNewButton);
		
	}
	private static void studentsignview() {
		// TODO Auto-generated method stub
		stdframe = new JFrame();
		stdframe.setBounds(300, 300, 358, 482);
		stdframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		stdframe.getContentPane().setLayout(null);
		stdframe.setVisible(true);
		
		lblSign = new JLabel("학생 등록");
		lblSign.setFont(new Font("굴림", Font.PLAIN, 20));
		lblSign.setBounds(100, 28, 109, 33);
		stdframe.getContentPane().add(lblSign);
		
		lblStdnum = new JLabel("학번");
		lblStdnum.setBounds(44, 98, 57, 15);
		stdframe.getContentPane().add(lblStdnum);
		
		setStdnum = new JTextField();
		setStdnum.setBounds(165, 95, 116, 21);
		stdframe.getContentPane().add(setStdnum);
		setStdnum.setColumns(10);
		
		lblName = new JLabel("이름");
		lblName.setBounds(44, 138, 57, 15);
		stdframe.getContentPane().add(lblName);
		
		setName = new JTextField();
		setName.setBounds(165, 135, 116, 21);
		stdframe.getContentPane().add(setName);
		setName.setColumns(10);
		
		lblTel = new JLabel("tel");
		lblTel.setBounds(44, 180, 57, 15);
		stdframe.getContentPane().add(lblTel);
		
		setTel = new JTextField();
		setTel.setBounds(165, 177, 116, 21);
		stdframe.getContentPane().add(setTel);
		setTel.setColumns(10);
		
		lblEmail = new JLabel("e-mail");
		lblEmail.setBounds(44, 218, 57, 15);
		stdframe.getContentPane().add(lblEmail);
		
		setEmail = new JTextField();
		setEmail.setBounds(165, 215, 116, 21);
		stdframe.getContentPane().add(setEmail);
		setEmail.setColumns(10);
		
		lblYear = new JLabel("학년");
		lblYear.setBounds(44, 256, 57, 15);
		stdframe.getContentPane().add(lblYear);
		
		setYear = new JTextField();
		setYear.setBounds(165, 253, 116, 21);
		stdframe.getContentPane().add(setYear);
		setYear.setColumns(10);
		
		lblGender = new JLabel("성별");
		lblGender.setBounds(44, 303, 57, 15);
		stdframe.getContentPane().add(lblGender);
		
		setGender = new JTextField();
		setGender.setBounds(165, 300, 116, 21);
		stdframe.getContentPane().add(setGender);
		setGender.setColumns(10);
		
		btnCancle = new JButton("취소");
		btnCancle.setBounds(44, 364, 97, 23);
		stdframe.getContentPane().add(btnCancle);
		btnCancle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stdframe.setVisible(false);
				signview();
			}
		});
		
		btnInput = new JButton("등록");
		btnInput.setBounds(184, 364, 97, 23);
		stdframe.getContentPane().add(btnInput);
		btnInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stdframe.setVisible(false);
				try {
					sign.studentsign(setStdnum.getText(), setName.getText(), setTel.getText(), setEmail.getText(), setYear.getText(), setGender.getText());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}

	private static void professorsignview() {
		// TODO Auto-generated method stub\
		proframe = new JFrame();
		proframe.setBounds(300, 300, 339, 342);
		proframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		proframe.getContentPane().setLayout(null);
		proframe.setVisible(true);

		lblSign = new JLabel("교직원 등록");
		lblSign.setFont(new Font("굴림", Font.PLAIN, 20));
		lblSign.setBounds(100, 28, 109, 33);
		proframe.getContentPane().add(lblSign);
		
		lblStdnum = new JLabel("직원번호");
		lblStdnum.setBounds(44, 98, 57, 15);
		proframe.getContentPane().add(lblStdnum);
		
		setPronum = new JTextField();
		setPronum.setBounds(165, 95, 116, 21);
		proframe.getContentPane().add(setPronum);
		setPronum.setColumns(10);
		
		lblName = new JLabel("이름");
		lblName.setBounds(44, 138, 57, 15);
		proframe.getContentPane().add(lblName);
		
		setName = new JTextField();
		setName.setBounds(165, 135, 116, 21);
		proframe.getContentPane().add(setName);
		setName.setColumns(10);
		
		lblTel = new JLabel("tel");
		lblTel.setBounds(44, 180, 57, 15);
		proframe.getContentPane().add(lblTel);
		
		setTel = new JTextField();
		setTel.setBounds(165, 177, 116, 21);
		proframe.getContentPane().add(setTel);
		setTel.setColumns(10);
		
		lblEmail = new JLabel("e-mail");
		lblEmail.setBounds(44, 218, 57, 15);
		proframe.getContentPane().add(lblEmail);
		
		setEmail = new JTextField();
		setEmail.setBounds(165, 215, 116, 21);
		proframe.getContentPane().add(setEmail);
		setEmail.setColumns(10);
		
		btnCancle = new JButton("취소");
		btnCancle.setBounds(44, 255, 97, 23);
		proframe.getContentPane().add(btnCancle);
		btnCancle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				proframe.setVisible(false);
				signview();
			}
		});
		
		
		btnInput = new JButton("등록");
		btnInput.setBounds(184, 255, 97, 23);
		proframe.getContentPane().add(btnInput);
		btnInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				proframe.setVisible(false);
				try {
					sign.professorsign(setPronum.getText(), setName.getText(), setTel.getText(), setEmail.getText());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}

}
