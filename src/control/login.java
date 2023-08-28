package control;



import java.io.IOException;
import java.util.Map;

import javax.swing.JOptionPane;

import Main.Main;
import VO.professorVO;
import VO.studentVO;
import view.login_view;
import view.professor_view;
import view.std_view;

public class login{
	public static Map stdMap = Main.getstdMap();
	public static Map proMap = Main.getproMap();
	
	public static void login(String type, String ID, String Name) {
		if(type.equals("교 직 원")) {
			prologincheck(ID, Name);
		}else {
			stdlogincheck(ID, Name);
		}
	}
	private static void stdlogincheck(String stdnum, String name){
		// TODO Auto-generated method stub
		boolean a = stdMap.containsKey(stdnum);
		if (a == true) {
			studentVO stdVO = new studentVO();
			stdVO = (studentVO) stdMap.get(stdnum);
			if (stdVO.getname().equals(name)) {
				JOptionPane.showMessageDialog(null, stdnum+"번"+name+"님 로그인 되었습니다");
				std_view.student_view(stdVO);
			}else {
				JOptionPane.showMessageDialog(null, "이름이 틀리게 입력됬습니다");
				login_view.login_view();
			}
		}else {
			JOptionPane.showMessageDialog(null, "일치하는 학번이 없습니다");
			login_view.login_view();
		}
	}
	private static void prologincheck(String pronum, String name) {
		// TODO Auto-generated method stub
		boolean a = proMap.containsKey(pronum);
		if (a == true) {
			professorVO proVO = new professorVO();
			proVO = (professorVO) proMap.get(pronum);
			if (proVO.getname().equals(name)) {
				JOptionPane.showMessageDialog(null, pronum+"번"+name+"님 로그인 되었습니다");
				professor_view.professor_view(proVO);
			}else {
				JOptionPane.showMessageDialog(null, "이름이 틀리게 입력됬습니다");
				login_view.login_view();
			}
		}else {
			JOptionPane.showMessageDialog(null, "일치하는 직원번호가 없습니다");
			login_view.login_view();
		}
	}

}
