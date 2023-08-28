package control;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Main.Main;
import VO.classVO;
import VO.gradeVO;
import VO.professorVO;
import VO.studentVO;
import view.login_view;
import view.professor_view;

public class professor {

	public static Map stdMap = Main.getstdMap();
	public static Map proMap = Main.getproMap();
	public static Map<String, classVO> classMap = Main.getclassMap();
	public static Map<String, gradeVO> gradeMap = Main.getgradeMap();
	public static Map findgradeMap = Main.getfindgradeMap();
	public static Map classgradeMap = Main.getclassgradeMap();
	public static Map<String, Map<String, classVO>> findclassMap = Main.getfindclassMap();
	public static professorVO proVO = new professorVO();
	public static String[] settitle = {null,null,null,null,null,null,null};
	public static float total = 0;
	public static float avg = 0;
	
	private static void getVO(professorVO proVO2) {
		// TODO Auto-generated method stub
		proVO = proVO2;
	}
	
	public static void classinput(String classname, String classyear, String classtotal, String pronum) throws IOException {
		// TODO Auto-generated method stub
		int n = (int) (Math.random() * 1000)+1;
		String classkey = Integer.toString(Calendar.getInstance().get(Calendar.YEAR))+Integer.toString(n);
		System.out.println(classkey);
		if(classMap.containsKey(classkey)) {
			classinput(classname, classyear, classtotal, pronum);
		}else {
			classVO classVO = new classVO();
			classVO.setclasskey(classkey);
			classVO.setclassname(classname);
			classVO.setyear(Integer.parseInt(classyear));
			classVO.setregister(0);
			classVO.settotal(Integer.parseInt(classtotal));
			classVO.setpronum(pronum);
			classVO.setsemester(true);	
			classMap.put(classkey, classVO);
			classgradeMap.put(classkey, gradeMap);
			fileread fr = new fileread();
			fr.writeclass(classkey);
			professor_view.class_view();
		}		
	}
	
	public static void classdel(String delclass, String pronum) throws IOException {
		// TODO Auto-generated method stub
		
		Iterator<String> l  = classMap.keySet().iterator();
		while(l.hasNext()) {
			classVO classVO = new classVO();
			String key = l.next();
			classVO = classMap.get(key);
			if((delclass == classVO.getclassname()) && pronum == classVO.getpronum()) {
				classMap.remove(classVO.getclasskey());			
			}
		}
		Iterator<String> I = gradeMap.keySet().iterator();
		while(I.hasNext()) {
			String key = I.next();
			gradeVO gradeVO = new gradeVO();
			gradeVO = gradeMap.get(key);
			if(delclass.equals(gradeVO.getclassname())) {
				gradeMap.remove(key);
			}
		}
		fileread fr = new fileread();
		fr.gradeMapsave();
		fr.classMapsave();
		professor_view.class_view();
		
	}

	public static void classfix(String fixclass, String classname, String classyear, String total, String pronum) throws IOException {
		// TODO Auto-generated method stub
		classVO classVO = null;
		String chname;
		Iterator<String> l  = classMap.keySet().iterator();
		while(l.hasNext()) {
			classVO = new classVO();
			String key = l.next();
			classVO = classMap.get(key);
			if(fixclass.equals(classVO.getclassname()) && pronum.equals(classVO.getpronum())) {
				break;				
			}
		}
		chname = classVO.getclassname();
		classVO.setclassname(classname);
		classVO.setyear(Integer.parseInt(classyear));
		classVO.settotal(Integer.parseInt(total));
		classMap.put(classVO.getclasskey(), classVO);
		
		Iterator<String> i = gradeMap.keySet().iterator();
		while(i.hasNext()) {
			gradeVO gradeVO = new gradeVO();
			String key = i.next();
			gradeVO = gradeMap.get(key);
			if(chname.equals(gradeVO.getclassname())) {
				gradeVO.setclassname(classname);
				gradeMap.put(key, gradeVO);	
			}
		}
		fileread fr = new fileread();
		fr.classMapsave();
		fr.gradeMapsave();
		
		professor_view.class_view();
	}

	public static void del(professorVO proVO1) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		getVO(proVO1);
		proMap.remove(proVO.getpronum());
		fileread fr = new fileread();
		fr.proMapsave();
		JOptionPane.showMessageDialog(null, "삭제 되었습니다");
		login_view.login_view();		
	}
	
	public static void fix(String name, String tel, String email, professorVO proVO1) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		getVO(proVO1);
		proVO.setname(name);
		proVO.settel(tel);
		proVO.setemail(email);

		proMap.put(proVO.getpronum(), proVO);
		fileread fr = new fileread();
		fr.proMapsave();
		JOptionPane.showMessageDialog(null, "수정이 완료되었습니다");
		professor_view.professor_view(proVO);
	}


	public static void finish(String findclass) {
		// TODO Auto-generated method stub
		String[] title = {"성적키","수업명","학번","성적","등수"};
		DefaultTableModel model = new DefaultTableModel(title, 0);
		DefaultTableModel inputmodel = new DefaultTableModel(title, 0){
			public boolean isCellEditable(int rowIndex, int mColIndex) {
                return false;
            }
        };
        final JTable table = new JTable(model);
		float after;
		float before;
		gradeVO gradeVO = new gradeVO();
		total =0;
		avg = 0;
		Iterator<String> a = gradeMap.keySet().iterator();
		while(a.hasNext()) {
			String key = a.next();
			gradeVO = gradeMap.get(key);
			if(findclass.equals(gradeVO.getclassname())) {
				String[] rows = {key, gradeVO.getclassname(),gradeVO.getstdnum(),String.valueOf(gradeVO.getgrade())};
				model.addRow(rows);
				total += gradeVO.getgrade(); 
			}
			gradeVO = null;
		}
		avg = total/table.getRowCount();
		
		int row = table.getRowCount();
		for(int i = 0; i<row; i++) {
			for(int j =0; j<row; j++) {
				String be = (String) table.getValueAt(i, 3);
				String af = (String) table.getValueAt(j, 3);
				before = Float.parseFloat(be);
				after = Float.parseFloat(af);
				if(before>after) {
					String[] beforerow = {(String) table.getValueAt(i, 0), (String) table.getValueAt(i, 1), (String) table.getValueAt(i, 2), be};
					String[] afterrow = {(String) table.getValueAt(j, 0), (String) table.getValueAt(j, 1), (String) table.getValueAt(j, 2), af};
					String[] temp = beforerow;
					beforerow = afterrow;
					afterrow = temp;
					table.setValueAt(beforerow[0], i, 0);
					table.setValueAt(beforerow[1], i, 1);
					table.setValueAt(beforerow[2], i, 2);
					table.setValueAt(beforerow[3], i, 3);
					table.setValueAt(i+1, i, 4);
					table.setValueAt(afterrow[0], j, 0);
					table.setValueAt(afterrow[1], j, 1);
					table.setValueAt(afterrow[2], j, 2);
					table.setValueAt(afterrow[3], j, 3);
					table.setValueAt(j+1, j, 4);
				}
			}
		}
		
		for(int i = 0; i<row; i++) {
			String[] tablerow = { (String) table.getValueAt(i, 0), (String) table.getValueAt(i, 1), (String) table.getValueAt(i, 2), (String) table.getValueAt(i, 3), String.valueOf(table.getValueAt(i, 4))};
			inputmodel.addRow(tablerow);
		}
		JOptionPane.showMessageDialog(null, "총점 "+total+"\n 평균 "+avg);
		professor_view.finish_view(inputmodel, total, avg);
	}

	public static void grade(JTable table) throws IOException {
		// TODO Auto-generated method stub
		int row = table.getRowCount();
		for(int n = 0; n<row; n++) {
			gradeVO gradeVO = new gradeVO();
			String key = (String) table.getValueAt(n, 0);
			String classname = (String) table.getValueAt(n, 1);
			String stdnum = (String) table.getValueAt(n, 2);
			float grade = (float) table.getValueAt(n, 3);
			gradeVO.setgradekey(key);
			gradeVO.setclassname(classname);
			gradeVO.setstdnum(stdnum);
			gradeVO.setgrade(grade);
			gradeMap.put(key, gradeVO);
		}
		fileread fr = new fileread();
		fr.gradeMapsave();
		professor_view.grade_view();
	}

	public static void find(String type, String findword, JTable table) {
		// TODO Auto-generated method stub
		classVO classVO = new classVO();
		gradeVO gradeVO = new gradeVO();
		studentVO stdVO = new studentVO();
		DefaultTableModel model = new DefaultTableModel(settitle, 0){
			public boolean isCellEditable(int rowIndex, int mColIndex) {
                return false;
            }
        };
		
		if(type.equals("학생정보")) {
			String[] title = {"학번", "이름", "전화", "이메일","학년", "성별"};
			settitle = title;
			if(stdMap.containsKey(findword)) {
				stdVO = (studentVO) stdMap.get(findword);
				String[] rowData = {stdVO.getstdnum(), stdVO.getname(), stdVO.gettel(), stdVO.getemail(), String.valueOf(stdVO.getyear()), stdVO.getgender()};
				model.addRow(rowData);
			}else {
				Iterator<String> a = stdMap.keySet().iterator();
				while(a.hasNext()) {
					String key = a.next();
					stdVO = (studentVO) stdMap.get(key);
					if(stdVO.getname().equals(findword)) {
						String[] rowData = {stdVO.getstdnum(), stdVO.getname(), stdVO.gettel(), stdVO.getemail(), String.valueOf(stdVO.getyear()), stdVO.getgender()};
						model.addRow(rowData);
					}
				}
			}
		}
		if(type.equals("학생성적")) {
			String[] title = {"수업키","학번", "수업명","점수"};
			settitle = title;
			Iterator<String> a = gradeMap.keySet().iterator();
			while(a.hasNext()) {
				String key = a.next();
				gradeVO = gradeMap.get(key);
				if(gradeVO.getstdnum().equals(findword)) {
					String[] rowData = {gradeVO.getgradekey(), gradeVO.getstdnum(),gradeVO.getclassname(), String.valueOf(gradeVO.getgrade())};
					model.addRow(rowData);
				}
			}
		}else if(type.equals("수업별 성적")) {
			String[] title = {"수업키","학번", "수업명","점수"};
			settitle = title;
			Iterator<String> a = gradeMap.keySet().iterator();
			while(a.hasNext()) {
				String key = a.next();
				gradeVO = gradeMap.get(key);
				if(gradeVO.getclassname().equals(findword)) {
					String[] rowData = {gradeVO.getgradekey(), gradeVO.getstdnum(),gradeVO.getclassname(), String.valueOf(gradeVO.getgrade())};
					model.addRow(rowData);
				}
			}
			
		}
		professor_view.find_view(model);
	}	
}
