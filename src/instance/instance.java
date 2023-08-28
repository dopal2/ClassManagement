package instance;

import java.util.HashMap;
import java.util.Map;

import VO.classVO;
import VO.gradeVO;
import VO.professorVO;
import VO.studentVO;

public class instance {


	public static Map<String, studentVO> stdMap ;//�й�, �л�VO
	public static Map<String, professorVO> proMap ;//������ȣ, ������VO
	public static Map<String, classVO> classMap ;//����Ű, ����VO
	public static Map<String, gradeVO> gradeMap ;//����Ű, ����VO
	public static Map<String, Map<String, classVO>> findclassMap = new HashMap<String, Map<String, classVO>>(); //������ȣ, ����Map
	public static Map<String, Map<String, gradeVO>> findgradeMap = new HashMap<String, Map<String, gradeVO>>(); //�й�, ����Map
	public static Map<String, Map<String, gradeVO>> classgradeMap = new HashMap<String, Map<String, gradeVO>>(); //����Ű, ����Map 
	
	public static instance getstdMap() {
		if(stdMap == null) {
			stdMap = new HashMap<String, studentVO>();
		}
		return (instance) stdMap;
	}
	public static instance getproMap() {
		if(proMap == null) {
			proMap = new HashMap<String, professorVO>();
		}
		return (instance) proMap;
	}
	public static instance getclassMap() {
		if(classMap == null) {
			classMap = new HashMap<String, classVO>();
		}
		return (instance) classMap;
	}
	public static instance getgradeMap() {
		if(gradeMap == null) {
			gradeMap = new HashMap<String, gradeVO>();
		}
		return (instance) gradeMap;
	}
	
}
