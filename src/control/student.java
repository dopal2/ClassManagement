package control;


import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Iterator;
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
import VO.studentVO;
import view.login_view;
import view.std_view;

public class student {
	public static Map stdMap = Main.getstdMap();
	public static Map proMap = Main.getproMap();
	public static Map<String, classVO> classMap = Main.getclassMap();
	public static Map<String, gradeVO> gradeMap = Main.getgradeMap();
	public static Map findclassMap = Main.getfindclassMap();
	public static Map findgradeMap = Main.getfindgradeMap();
	public static Map classgradeMap = Main.getclassgradeMap();
	public static String[] settitle = {null,null,null,null,null,null};
	public static studentVO stdVO = new studentVO();
	private static DefaultTableModel a;
	
	private static void getVO (studentVO stdVO2) {
		stdVO = stdVO2;
	}


	public static void find(String type, String findword, studentVO stdVO_1) {
		// TODO Auto-generated method stub
		getVO(stdVO_1);
		DefaultTableModel model = new DefaultTableModel(settitle, 0){
			public boolean isCellEditable(int rowIndex, int mColIndex) {
                return false;
            }
        };
        
		if(type.equals("�����˻�")) {
			String[] b = {"����Ű", "������", "��米����", "��û�ο�", "�ѿ�", "�г�", "�б�"};
			settitle = b;
			Iterator<String> a = classMap.keySet().iterator();
			while(a.hasNext()) {
				classVO classVO = new classVO();
				String key = a.next();
				classVO = classMap.get(key);
				if((classVO.getclassname().equals(findword))) {
					String[] rowData = {key, classVO.getclassname(), classVO.getpronum(), String.valueOf(classVO.getregister()), String.valueOf(classVO.gettotal()), String.valueOf(classVO.getyear()), String.valueOf(classVO.getsemester())};
					model.addRow(rowData);
				}else {
					if((String.valueOf(classVO.getyear()).equals(findword))) {
						String[] rowData = {key, classVO.getclassname(), classVO.getpronum(), String.valueOf(classVO.getregister()), String.valueOf(classVO.gettotal()), String.valueOf(classVO.getyear()), String.valueOf(classVO.getsemester())};
						model.addRow(rowData);
					}else{
						if((String.valueOf(classVO.getpronum()).equals(findword))) {
							String[] rowData = {key, classVO.getclassname(), classVO.getpronum(), String.valueOf(classVO.getregister()), String.valueOf(classVO.gettotal()), String.valueOf(classVO.getyear()), String.valueOf(classVO.getsemester())};
							model.addRow(rowData);
						}
					}
				}
			}
		}
		if(type.equals("����")) {
			String[] b = {"����Ű", "������", "�й�", "����"};
			settitle = b;
			Iterator<String> a = gradeMap.keySet().iterator();
			if(a != null) {
				while(a.hasNext()) {
					gradeVO gradeVO = new gradeVO();
					String key = a.next();
					gradeVO = gradeMap.get(key);
					if(gradeVO.getstdnum().equals(stdVO.getstdnum())) {
						String[] rowData = {gradeVO.getgradekey(), gradeVO.getclassname(), gradeVO.getstdnum(), String.valueOf(gradeVO.getgrade())};
						model.addRow(rowData);						
					}
				}
			}
		}
		if(type.equals("�г⺰ ����")) {
			String[] b = {"����Ű", "������", "�й�","����"};
			settitle = b;
			Iterator<String> a = classMap.keySet().iterator();
			while(a.hasNext()) {
				classVO classVO = new classVO();
				String key = a.next();
				classVO = classMap.get(key);
				if(findword.equals(String.valueOf(classVO.getyear()))) {
					Iterator<String> s = gradeMap.keySet().iterator();
					while(s.hasNext()) {
						gradeVO gradeVO = new gradeVO();
						String k = s.next();
						gradeVO = gradeMap.get(k);
						if(classVO.getclassname().equals(gradeVO.getclassname())) {
							String[] rowData = {gradeVO.getgradekey(), gradeVO.getclassname(), gradeVO.getstdnum(),String.valueOf(gradeVO.getgrade())};
							model.addRow(rowData);
						}
					}
				}
			}
		}
		std_view.find_view(model);
	}
	
	public static void regist(String value, studentVO stdVO_1) throws IOException {
		// TODO Auto-generated method stub
		getVO(stdVO_1);
		classVO classVO = classMap.get(value);
		String gradekey = value+stdVO.getstdnum();
		System.out.println("�˻��� ����Map"+classVO.getclasskey()+" ������"+classVO.getclassname()+" ��û�ο�"+classVO.getregister()+" �ѿ�"+classVO.gettotal()+" ���"+classVO.getpronum());
		
		if(classVO.gettotal() <= classVO.getregister() ) {
			JOptionPane.showMessageDialog(null, "��û�ο��� �ʰ��Ǿ����ϴ�.");
			std_view.regist_view();
		}else {
			if(gradeMap.containsKey(gradekey) == false) {
				gradeVO gradeVO = new gradeVO();
				gradeVO.setgradekey(gradekey);
				gradeVO.setstdnum(stdVO.getstdnum());
				gradeVO.setclassname(classVO.getclassname());
				gradeVO.setgrade(0);
				classVO.setregister(classVO.getregister()+1);
				System.out.println("����Map"+gradeVO.getgradekey()+ " �й�" +gradeVO.getstdnum()+" ������"+gradeVO.getclassname()+" ����"+gradeVO.getgrade());
				System.out.println("����Map"+value+" ������"+classVO.getclassname()+" ��û�ο�"+classVO.getregister()+" �ѿ�"+classVO.gettotal()+" ���"+classVO.getpronum());
				gradeMap.put(gradeVO.getgradekey(), gradeVO);
				classMap.put(value, classVO);
				findgradeMap.put(stdVO, gradeMap);
				fileread fr = new fileread();
				fr.writegrade(gradekey);
				JOptionPane.showMessageDialog(null, "��û�� �Ϸ�Ǿ����ϴ�.");
				std_view.regist_view();
			}else {
				JOptionPane.showMessageDialog(null, "�̹� ��ϵ� ���� �Դϴ�.");
				std_view.regist_view();
			}
		}
	}
	
	public static void del(studentVO stdVO_1) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		getVO(stdVO_1);
		stdMap.remove(stdVO.getstdnum());
		Iterator<String> a = gradeMap.keySet().iterator();
		while(a.hasNext()) {
			String key = a.next();
			gradeVO gradeVO = new gradeVO();
			gradeVO = gradeMap.get(key);
			if(stdVO.getstdnum().equals(gradeVO.getstdnum())) {
				stdMap.remove(key);
			}
		}
		fileread fr = new fileread();
		fr.stdMapsave();
		fr.gradeMapsave();
		JOptionPane.showMessageDialog(null, "���� �Ǿ����ϴ�");
		login_view.login_view();		
		
	}
	
	public static void fix(String name, String tel, String email, String year, String gender, studentVO stdVO_1) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		getVO(stdVO_1);
		stdVO.setname(name);
		stdVO.settel(tel);
		stdVO.setemail(email);
		stdVO.setyear(Integer.parseInt(year));
		stdVO.setgender(gender);
		stdMap.put(stdVO.getstdnum(), stdVO);
		fileread fr = new fileread();
		fr.stdMapsave();
		JOptionPane.showMessageDialog(null, "������ �Ϸ�Ǿ����ϴ�");
		std_view.student_view(stdVO);
	}
}
