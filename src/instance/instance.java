package instance;

import java.util.HashMap;
import java.util.Map;

import VO.classVO;
import VO.gradeVO;
import VO.professorVO;
import VO.studentVO;

public class instance {


	public static Map<String, studentVO> stdMap ;//학번, 학생VO
	public static Map<String, professorVO> proMap ;//직원번호, 교직원VO
	public static Map<String, classVO> classMap ;//수업키, 수업VO
	public static Map<String, gradeVO> gradeMap ;//성적키, 성적VO
	public static Map<String, Map<String, classVO>> findclassMap = new HashMap<String, Map<String, classVO>>(); //직원번호, 수업Map
	public static Map<String, Map<String, gradeVO>> findgradeMap = new HashMap<String, Map<String, gradeVO>>(); //학번, 성적Map
	public static Map<String, Map<String, gradeVO>> classgradeMap = new HashMap<String, Map<String, gradeVO>>(); //수업키, 성적Map 
	
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
