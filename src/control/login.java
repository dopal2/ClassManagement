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
		if(type.equals("�� �� ��")) {
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
				JOptionPane.showMessageDialog(null, stdnum+"��"+name+"�� �α��� �Ǿ����ϴ�");
				std_view.student_view(stdVO);
			}else {
				JOptionPane.showMessageDialog(null, "�̸��� Ʋ���� �Է���ϴ�");
				login_view.login_view();
			}
		}else {
			JOptionPane.showMessageDialog(null, "��ġ�ϴ� �й��� �����ϴ�");
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
				JOptionPane.showMessageDialog(null, pronum+"��"+name+"�� �α��� �Ǿ����ϴ�");
				professor_view.professor_view(proVO);
			}else {
				JOptionPane.showMessageDialog(null, "�̸��� Ʋ���� �Է���ϴ�");
				login_view.login_view();
			}
		}else {
			JOptionPane.showMessageDialog(null, "��ġ�ϴ� ������ȣ�� �����ϴ�");
			login_view.login_view();
		}
	}

}
