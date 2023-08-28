package control;



import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Main.Main;
import VO.professorVO;
import VO.studentVO;
import view.login_view;

public class sign implements ActionListener{

	private static JFrame frame, stdframe, proframe;
	private static JButton btnProfessor, btnStudent, btnCancle, btnInput;
	private static JLabel lblSign, lblStdnum, lblName, lblTel, lblEmail, lblYear, lblGender;
	private static JTextField setStdnum, setPronum, setName, setTel, setEmail, setYear, setGender;
	private static JButton btnNewButton;
	public static Map stdMap = Main.getstdMap();
	public static Map proMap = Main.getproMap();
	public static Map gradeMap = Main.getgradeMap();
	public static Map classMap = Main.getclassMap();
	public static Map findclassMap = Main.getfindclassMap();
	public static Map findgradeMap = Main.getfindgradeMap();
	public static Map classgradeMap = Main.getclassgradeMap();
	
	/**
	 * Launch the application.
	 * @param stdnum 
	 */
	public static boolean stdsigncheck(String stdnum) {
		boolean a;
		a = stdMap.containsKey(stdnum);
		return a;
	}
	public static boolean prosigncheck(String pronum) {
		boolean a;
		a = proMap.containsKey(pronum);
		return a;
	}
	public static void studentsign(String stdnum, String name, String tel, String email, String year, String gender) throws IOException {
		if(stdsigncheck(stdnum) == true) {
			JOptionPane.showMessageDialog(null, "이미 등록된 학번입니다");
		}else {
			studentVO stdVO =new studentVO();
			stdVO.setstdnum(stdnum);
			stdVO.setname(name);
			stdVO.settel(tel);
			stdVO.setemail(email);
			stdVO.setyear(Integer.parseInt(year));
			stdVO.setgender(gender);
			stdMap.put(stdnum, stdVO);
			findgradeMap.put(stdnum, gradeMap);
			fileread fr = new fileread();
			fr.writestudent(stdnum);
			JOptionPane.showMessageDialog(null, stdnum+"번"+name+"님 등록되었습니다");			
		}
		login_view.login_view();
	}
	public static void professorsign(String pronum, String name, String tel, String email) throws IOException {
		if(prosigncheck(pronum) == true) {
			JOptionPane.showMessageDialog(null, "이미 등록된 직원번호입니다");
		}else {
			professorVO proVO =new professorVO();
			proVO.setpronum(pronum);
			proVO.setname(name);
			proVO.settel(tel);
			proVO.setemail(email);
			proMap.put(pronum, proVO);
			findclassMap.put(pronum, classMap);
			fileread fr = new fileread();
			fr.writeprofessor(pronum);
			JOptionPane.showMessageDialog(null, pronum+"번"+name+"님 등록되었습니다");
		}
		login_view.login_view();
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
