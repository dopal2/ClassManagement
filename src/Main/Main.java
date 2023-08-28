package Main;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import VO.classVO;
import VO.gradeVO;
import VO.professorVO;
import VO.studentVO;
import control.fileread;
import view.login_view;

public class Main {

	public static Map<String, studentVO> stdMap = new HashMap<String, studentVO>();//�й�, �л�VO
	public static Map<String, professorVO> proMap = new HashMap<String, professorVO>();//������ȣ, ������VO
	public static Map<String, classVO> classMap = new HashMap<String, classVO>();//����Ű, ����VO
	public static Map<String, gradeVO> gradeMap = new HashMap<String, gradeVO>();//����Ű, ����VO
	public static Map<String, Map<String, classVO>> findclassMap = new HashMap<String, Map<String, classVO>>(); //������ȣ, ����Map
	public static Map<String, Map<String, gradeVO>> findgradeMap = new HashMap<String, Map<String, gradeVO>>(); //�й�, ����Map
	public static Map<String, Map<String, gradeVO>> classgradeMap = new HashMap<String, Map<String, gradeVO>>(); //����Ű, ����Map 
	
	

	public static Map getstdMap() {
		return stdMap;
	}
	public static Map getproMap() {
		return proMap;
	}
	public static Map getclassMap() {
		return classMap;
	}
	public static Map getgradeMap() {
		return gradeMap;
	}
	public static Map getfindclassMap() {
		return findclassMap;
	}
	public static Map getfindgradeMap() {
		return findgradeMap;
	}
	public static Map getclassgradeMap() {
		return classgradeMap;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		/*
		fileread fr = new fileread();
		fr.readstudent();
		fr.readprofessor();
		fr.readclass();
		fr.readgrade();
		*/
		login_view.login_view();
	}
}
