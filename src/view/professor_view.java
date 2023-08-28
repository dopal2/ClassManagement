package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
import VO.professorVO;
import VO.studentVO;
import control.professor;

public class professor_view {

	private static JFrame proframe, fixframe, delframe, findframe,classframe, classinputframe, classfixframe, classdelframe, gradeframe, gradeframe_1, finishframe;
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
	public static void class_view() {
		// TODO Auto-generated method stub
		classframe = new JFrame();
		classframe.setBounds(300, 300, 420, 230);
		classframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		classframe.getContentPane().setLayout(null);
		classframe.setVisible(true);
	
		JLabel lblSign = new JLabel("수업 관리");
		lblSign.setFont(new Font("굴림", Font.PLAIN, 20));
		lblSign.setBounds(149, 28, 109, 33);
		classframe.getContentPane().add(lblSign);
		
		JButton btnInput = new JButton("input");
		btnInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				classframe.setVisible(false);
				classinput_view();
			}
		});
		btnInput.setBounds(33, 80, 97, 23);
		classframe.getContentPane().add(btnInput);
		
		JButton btnFix = new JButton("fix");
		btnFix.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				classframe.setVisible(false);
				classfix_view();
			}
		});
		btnFix.setBounds(149, 80, 97, 23);
		classframe.getContentPane().add(btnFix);
		
		JButton btnDel = new JButton("del");
		btnDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				classframe.setVisible(false);
				classdel_view();
			}
		});
		btnDel.setBounds(267, 80, 97, 23);
		classframe.getContentPane().add(btnDel);
		
		JButton btnGrade = new JButton("grade");
		btnGrade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				classframe.setVisible(false);
				grade_view();
			}
		});
		btnGrade.setBounds(33, 130, 97, 23);
		classframe.getContentPane().add(btnGrade);
		
		JButton btnFinish = new JButton("finish");
		btnFinish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finish_view(null, 0 , 0);
				classframe.setVisible(false);
			}
		});
		btnFinish.setBounds(149, 130, 97, 23);
		classframe.getContentPane().add(btnFinish);
		
		JButton btnCancle = new JButton("cancle");
		btnCancle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				classframe.setVisible(false);
				professor_view(proVO);
			}
		});
		btnCancle.setBounds(267, 130, 97, 23);
		classframe.getContentPane().add(btnCancle);
	}
	
	public static void finish_view(DefaultTableModel inputmodel, float total, float avg) {
		// TODO Auto-generated method stub
		Vector list = new Vector();
		Iterator<String> a  = classMap.keySet().iterator();
		while(a.hasNext()) {
			String key = a.next();
			classVO classVO = classMap.get(key);
			if(classVO.getpronum().equals(proVO.getpronum())) {
				list.addElement(classVO.getclassname());				
			}
		}
		String[] title = {"성적키","수업명","학번","성적","등수"};
		DefaultTableModel model = new DefaultTableModel(title, 0){
			public boolean isCellEditable(int rowIndex, int mColIndex) {
                return false;
            }
        };
		
        if(inputmodel != null) {
        	model = inputmodel;
        }
        
		finishframe = new JFrame();
		finishframe.setBounds(300, 300, 673, 379);
		finishframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		finishframe.setVisible(true);
		finishframe.getContentPane().setLayout(null);
	
		JLabel lblSign = new JLabel("학기마감");
		lblSign.setBounds(272, 10, 109, 33);
		lblSign.setFont(new Font("굴림", Font.PLAIN, 20));
		finishframe.getContentPane().add(lblSign);
		final JTable table = new JTable(model);	
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(12, 98, 491, 211);
		finishframe.getContentPane().add(scrollPane);
		
		scrollPane.setViewportView(table);
        table.getTableHeader().setReorderingAllowed(false); // 컬럼들 이동 불가
        table.getTableHeader().setResizingAllowed(false); // 컬럼 크기 조절 불가
        
		JButton btnCancle = new JButton("cancle");
		btnCancle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishframe.setVisible(false);
				class_view();
			}
		});
		btnCancle.setBounds(532, 98, 97, 23);
		finishframe.getContentPane().add(btnCancle);
		
		JLabel lblSelectclass = new JLabel("수 업");
		lblSelectclass.setBounds(23, 62, 97, 15);
		finishframe.getContentPane().add(lblSelectclass);
		
		JComboBox find = new JComboBox(list);
		find.setBounds(78, 59, 425, 21);
		finishframe.getContentPane().add(find);
		
		JButton btnDeadline = new JButton("deadline");
		btnDeadline.setBounds(532, 58, 97, 23);
		finishframe.getContentPane().add(btnDeadline);
		btnDeadline.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishframe.setVisible(false);
				String findclass = (String) find.getSelectedItem();
				professor.finish(findclass);
			}
		});
		
		

		JLabel lblTotalval = new JLabel(String.valueOf(total));
		lblTotalval.setBounds(568, 158, 57, 15);
		finishframe.getContentPane().add(lblTotalval);	
		
		JLabel lblAvgval = new JLabel(String.valueOf(avg));
		lblAvgval.setBounds(568, 208, 57, 15);
		finishframe.getContentPane().add(lblAvgval);
		JLabel lblTotal = new JLabel("total");
		lblTotal.setBounds(515, 158, 41, 15);
		finishframe.getContentPane().add(lblTotal);
		
		
		JLabel lblAvg = new JLabel("avg");
		lblAvg.setBounds(515, 208, 33, 15);
		finishframe.getContentPane().add(lblAvg);
		
	}

	
	public static void grade_view() {
		// TODO Auto-generated method stub
		Vector list = new Vector();
		Iterator<String> a  = classMap.keySet().iterator();
		while(a.hasNext()) {
			String key = a.next();
			classVO classVO = classMap.get(key);
			if(classVO.getpronum().equals(proVO.getpronum())) {
				list.addElement(classVO.getclassname());				
			}
		}
		String[] title = {"성적키","수업명","학번","성적"};
		DefaultTableModel model = new DefaultTableModel(title, 0){
			public boolean isCellEditable(int rowIndex, int mColIndex) {
                return false;
            }
        };
		
		gradeframe = new JFrame();
		gradeframe.setBounds(300, 300, 673, 379);
		gradeframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gradeframe.setVisible(true);
		gradeframe.getContentPane().setLayout(null);
	
		JLabel lblSign = new JLabel("성적평가");
		lblSign.setBounds(272, 10, 109, 33);
		lblSign.setFont(new Font("굴림", Font.PLAIN, 20));
		gradeframe.getContentPane().add(lblSign);
		
		final JTable table = new JTable(model);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(12, 98, 491, 211);
		gradeframe.getContentPane().add(scrollPane);
		
		scrollPane.setViewportView(table);
        
        table.getTableHeader().setReorderingAllowed(false); // 컬럼들 이동 불가
        table.getTableHeader().setResizingAllowed(false);
		table.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if(e.getClickCount() == 2) {
					int row = table.getSelectedRow();
					String gradekey = (String) table.getValueAt(row, 0);
					String classname = (String) table.getValueAt(row, 1);
					String stdnum = (String) table.getValueAt(row, 2);
					gradeframe_1 = new JFrame();
					gradeframe_1.setBounds(300, 300, 290, 353);
					gradeframe_1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					gradeframe_1.setVisible(true);
					gradeframe_1.getContentPane().setLayout(null);
				
					JLabel lblSign = new JLabel("성적평가");
					lblSign.setBounds(95, 10, 109, 33);
					lblSign.setFont(new Font("굴림", Font.PLAIN, 20));
					gradeframe_1.getContentPane().add(lblSign);
					
					JLabel lblClass = new JLabel("class");
					lblClass.setBounds(34, 134, 57, 15);
					gradeframe_1.getContentPane().add(lblClass);
					
					JLabel lblStdnum = new JLabel("stdnum");
					lblStdnum.setBounds(34, 174, 57, 15);
					gradeframe_1.getContentPane().add(lblStdnum);
					
					JLabel lblGrade = new JLabel("grade");
					lblGrade.setBounds(34, 209, 57, 15);
					gradeframe_1.getContentPane().add(lblGrade);
					
					JLabel lblSelectclass = new JLabel(classname);
					lblSelectclass.setBounds(121, 134, 116, 15);
					gradeframe_1.getContentPane().add(lblSelectclass);
					
					JLabel lblGradekey = new JLabel("gradekey");
					lblGradekey.setBounds(34, 83, 57, 15);
					gradeframe_1.getContentPane().add(lblGradekey);
					
					JLabel lblSelectkey = new JLabel(gradekey);
					lblSelectkey.setBounds(121, 83, 116, 15);
					gradeframe_1.getContentPane().add(lblSelectkey);
					
					JLabel lblSelectstdnum = new JLabel(stdnum);
					lblSelectstdnum.setBounds(121, 174, 116, 15);
					gradeframe_1.getContentPane().add(lblSelectstdnum);
					
					JTextField txtSelectgrade = new JTextField();
					txtSelectgrade.setBounds(121, 206, 116, 21);
					gradeframe_1.getContentPane().add(txtSelectgrade);
					txtSelectgrade.setColumns(10);
					
					JButton btnCancle = new JButton("cancle");
					btnCancle.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							gradeframe_1.setVisible(false);
						}
					});
					btnCancle.setBounds(31, 256, 97, 23);
					gradeframe_1.getContentPane().add(btnCancle);
					
					JButton btnInput = new JButton("input");
					btnInput.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							float grade = Float.parseFloat(txtSelectgrade.getText());
							table.setValueAt(grade, row, 3);
							gradeframe_1.setVisible(false);
						}
					});
					btnInput.setBounds(140, 256, 97, 23);
					gradeframe_1.getContentPane().add(btnInput);
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
			}
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
			}
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
			}
		});
        
		JButton btnCancle = new JButton("cancle");
		btnCancle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gradeframe.setVisible(false);
				class_view();
			}
		});
		btnCancle.setBounds(532, 145, 97, 23);
		gradeframe.getContentPane().add(btnCancle);
		
		JLabel lblSelectclass = new JLabel("수 업");
		lblSelectclass.setBounds(146, 62, 97, 15);
		gradeframe.getContentPane().add(lblSelectclass);
		
		JComboBox find = new JComboBox(list);
		find.setBounds(275, 59, 228, 21);
		gradeframe.getContentPane().add(find);
		
		JButton btnSelect = new JButton("검색");
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.setNumRows(0);
				String findclass = (String) find.getSelectedItem();
				Iterator<String> a = gradeMap.keySet().iterator();
				while(a.hasNext()) {
					String key = a.next();
					gradeVO gradeVO = gradeMap.get(key);
					//if(gradeVO.get)
					if(gradeVO.getclassname().equals(findclass)) {
						Object[] stddata = {gradeVO.getgradekey(),gradeVO.getclassname(), gradeVO.getstdnum(), gradeVO.getgrade()};
						model.addRow(stddata);						
					}
				}
			}
		});
		btnSelect.setBounds(532, 58, 97, 23);
		gradeframe.getContentPane().add(btnSelect);
		
		JButton btnGrade = new JButton("평가");
		btnGrade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gradeframe.setVisible(false);
				try {
					professor.grade(table);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
			
		});
		btnGrade.setBounds(532, 101, 97, 23);
		gradeframe.getContentPane().add(btnGrade);
	}

	protected static void classdel_view() {
		// TODO Auto-generated method stub

		
		classdelframe = new JFrame();
		classdelframe.setBounds(300, 300, 316, 219);
		classdelframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		classdelframe.getContentPane().setLayout(null);
		classdelframe.setVisible(true);
	
		JLabel lblSign = new JLabel("수업 삭제");
		lblSign.setFont(new Font("굴림", Font.PLAIN, 20));
		lblSign.setBounds(101, 10, 109, 33);
		classdelframe.getContentPane().add(lblSign);
		
		JLabel lblDelclass = new JLabel("fixclass");
		lblDelclass.setBounds(29, 67, 57, 15);
		classdelframe.getContentPane().add(lblDelclass);
		
		Vector list = new Vector();
		Iterator<String> a  = classMap.keySet().iterator();
		while(a.hasNext()) {
			String key = a.next();
			classVO classVO = classMap.get(key);
			if(classVO.getpronum().equals(proVO.getpronum())) {
				list.addElement(classVO.getclassname());				
			}
		}
		
		
		JComboBox delclass = new JComboBox(list);
		delclass.setBounds(164, 64, 116, 21);
		classdelframe.getContentPane().add(delclass);
		
		JButton btnCancle = new JButton("취소");
		btnCancle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				classdelframe.setVisible(false);
				class_view();
			}
		});
		btnCancle.setBounds(29, 133, 97, 23);
		classdelframe.getContentPane().add(btnCancle);
		
		JButton btnDel = new JButton("삭제");
		btnDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				classdelframe.setVisible(false);
				try {
					professor.classdel((String) delclass.getSelectedItem(), proVO.getpronum());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnDel.setBounds(183, 133, 97, 23);
		classdelframe.getContentPane().add(btnDel);
	}

	protected static void classinput_view() {
		// TODO Auto-generated method stub
		classinputframe = new JFrame();
		classinputframe.setBounds(300, 300, 355, 431);
		classinputframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		classinputframe.getContentPane().setLayout(null);
		classinputframe.setVisible(true);
	
		JLabel lblSign = new JLabel("수업 등록");
		lblSign.setFont(new Font("굴림", Font.PLAIN, 20));
		lblSign.setBounds(110, 28, 109, 33);
		classinputframe.getContentPane().add(lblSign);
		
		JLabel lblClassname = new JLabel("classname");
		lblClassname.setBounds(49, 93, 88, 15);
		classinputframe.getContentPane().add(lblClassname);
		
		JTextField classname = new JTextField();
		classname.setBounds(149, 90, 151, 21);
		classinputframe.getContentPane().add(classname);
		classname.setColumns(10);
		
		JLabel lblYear = new JLabel("year");
		lblYear.setBounds(49, 151, 57, 15);
		classinputframe.getContentPane().add(lblYear);
		
		JTextField classyear = new JTextField();
		classyear.setBounds(149, 148, 151, 21);
		classinputframe.getContentPane().add(classyear);
		classyear.setColumns(10);
		
		JLabel lblTotal = new JLabel("total");
		lblTotal.setBounds(49, 214, 57, 15);
		classinputframe.getContentPane().add(lblTotal);
		
		JTextField classtotal = new JTextField();
		classtotal.setBounds(149, 211, 151, 21);
		classinputframe.getContentPane().add(classtotal);
		classtotal.setColumns(10);
		
		JLabel lblManager = new JLabel("manager");
		lblManager.setBounds(49, 273, 57, 15);
		classinputframe.getContentPane().add(lblManager);
		
		JLabel lblPronum = new JLabel(proVO.getpronum());
		lblPronum.setBounds(149, 273, 57, 15);
		classinputframe.getContentPane().add(lblPronum);
		
		JButton btnCancle = new JButton("cancle");
		btnCancle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				classinputframe.setVisible(false);
				class_view();
			}
		});
		btnCancle.setBounds(49, 341, 97, 23);
		classinputframe.getContentPane().add(btnCancle);
		
		JButton btnInput = new JButton("input");
		btnInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				classinputframe.setVisible(false);
				try {
					professor.classinput(classname.getText(), classyear.getText(), classtotal.getText(), proVO.getpronum());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnInput.setBounds(203, 341, 97, 23);
		classinputframe.getContentPane().add(btnInput);
	}
	
	protected static void classfix_view() {
		Vector list = new Vector();
		Iterator<String> a  = classMap.keySet().iterator();
		while(a.hasNext()) {
			String key = a.next();
			classVO classVO = classMap.get(key);
			if(classVO.getpronum().equals(proVO.getpronum())) {
				list.addElement(classVO.getclassname());				
			}
		}	
		
		classfixframe = new JFrame();
		classfixframe.setBounds(300, 300, 316, 386);
		classfixframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		classfixframe.getContentPane().setLayout(null);
		classfixframe.setVisible(true);
	
		JLabel lblSign = new JLabel("수업 수정");
		lblSign.setFont(new Font("굴림", Font.PLAIN, 20));
		lblSign.setBounds(101, 10, 109, 33);
		classfixframe.getContentPane().add(lblSign);
		
		JLabel lblFixclass = new JLabel("fixclass");
		lblFixclass.setBounds(29, 67, 57, 15);
		classfixframe.getContentPane().add(lblFixclass);
		
		JComboBox fixclass = new JComboBox(list);
		fixclass.setBounds(164, 64, 116, 21);
		classfixframe.getContentPane().add(fixclass);
		
		JLabel lblClassname = new JLabel("classname");
		lblClassname.setBounds(29, 124, 57, 15);
		classfixframe.getContentPane().add(lblClassname);
		
		JLabel lblClassyear = new JLabel("classyear");
		lblClassyear.setBounds(29, 174, 57, 15);
		classfixframe.getContentPane().add(lblClassyear);
		
		JLabel lblClasstotal = new JLabel("classtotal");
		lblClasstotal.setBounds(29, 219, 57, 15);
		classfixframe.getContentPane().add(lblClasstotal);
		
		
		JTextField classname = new JTextField();
		classname.setBounds(164, 121, 116, 21);
		classfixframe.getContentPane().add(classname);
		classname.setColumns(10);
		
		JTextField classyear = new JTextField();
		classyear.setBounds(164, 171, 116, 21);
		classfixframe.getContentPane().add(classyear);
		classyear.setColumns(10);
		
		JTextField classtotal = new JTextField();
		classtotal.setBounds(164, 216, 116, 21);
		classfixframe.getContentPane().add(classtotal);
		classtotal.setColumns(10);
		
		JButton btnCancle = new JButton("cancle");
		btnCancle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				classfixframe.setVisible(false);
				class_view();
			}
		});
		btnCancle.setBounds(29, 279, 97, 23);
		classfixframe.getContentPane().add(btnCancle);
		
		JButton btnFix = new JButton("fix");
		btnFix.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				classfixframe.setVisible(false);
				try {
					professor.classfix((String) fixclass.getSelectedItem(), classname.getText(), classyear.getText(), classtotal.getText(), proVO.getpronum());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnFix.setBounds(183, 279, 97, 23);
		classfixframe.getContentPane().add(btnFix);
	}
	
	protected static void del_view() {
		// TODO Auto-generated method stub
		delframe = new JFrame();
		delframe.setBounds(300, 300, 440, 249);
		delframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		delframe.getContentPane().setLayout(null);
		delframe.setVisible(true);
	
		JLabel lblSign = new JLabel("교직원 삭제");
		lblSign.setFont(new Font("굴림", Font.PLAIN, 20));
		lblSign.setBounds(165, 31, 109, 33);
		delframe.getContentPane().add(lblSign);
	
		JLabel lblStdnum = new JLabel("직원번호");
		lblStdnum.setBounds(44, 98, 57, 15);
		delframe.getContentPane().add(lblStdnum);
	
		JLabel lblName = new JLabel("이름");
		lblName.setBounds(224, 98, 57, 15);
		delframe.getContentPane().add(lblName);
		
		JLabel lblUsernum = new JLabel(proVO.getpronum());
		lblUsernum.setBounds(101, 98, 57, 15);
		delframe.getContentPane().add(lblUsernum);
		
		JLabel lblUsername = new JLabel(proVO.getname());
		lblUsername.setBounds(293, 98, 57, 15);
		delframe.getContentPane().add(lblUsername);
		
		JButton btnCancle = new JButton("cancle");
		btnCancle.setBounds(44, 160, 97, 23);
		delframe.getContentPane().add(btnCancle);
		btnCancle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delframe.setVisible(false);
				professor_view(proVO);
			}
		});
		
		JButton btnDel = new JButton("del");
		btnDel.setBounds(253, 160, 97, 23);
		delframe.getContentPane().add(btnDel);
		btnDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delframe.setVisible(false);
				try {
					professor.del(proVO);
				} catch (NumberFormatException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}

	protected static void fix_view() {
		// TODO Auto-generated method stub
		fixframe = new JFrame();
		fixframe.setBounds(300, 300, 339, 342);
		fixframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fixframe.getContentPane().setLayout(null);
		fixframe.setVisible(true);

		JLabel lblSign = new JLabel("교직원 등록");
		lblSign.setFont(new Font("굴림", Font.PLAIN, 20));
		lblSign.setBounds(100, 28, 109, 33);
		fixframe.getContentPane().add(lblSign);
		
		JLabel lblStdnum = new JLabel("직원번호");
		lblStdnum.setBounds(44, 98, 57, 15);
		fixframe.getContentPane().add(lblStdnum);
		
		JLabel setPronum = new JLabel(proVO.getpronum());
		setPronum.setBounds(165, 95, 116, 21);
		fixframe.getContentPane().add(setPronum);
		
		JLabel lblName = new JLabel("이름");
		lblName.setBounds(44, 138, 57, 15);
		fixframe.getContentPane().add(lblName);
		
		JTextField setName = new JTextField();
		setName.setBounds(165, 135, 116, 21);
		fixframe.getContentPane().add(setName);
		setName.setColumns(10);
		
		JLabel lblTel = new JLabel("tel");
		lblTel.setBounds(44, 180, 57, 15);
		fixframe.getContentPane().add(lblTel);
		
		JTextField setTel = new JTextField();
		setTel.setBounds(165, 177, 116, 21);
		fixframe.getContentPane().add(setTel);
		setTel.setColumns(10);
		
		JLabel lblEmail = new JLabel("e-mail");
		lblEmail.setBounds(44, 218, 57, 15);
		fixframe.getContentPane().add(lblEmail);
		
		JTextField setEmail = new JTextField();
		setEmail.setBounds(165, 215, 116, 21);
		fixframe.getContentPane().add(setEmail);
		setEmail.setColumns(10);
		
		JButton btnCancle = new JButton("취소");
		btnCancle.setBounds(44, 255, 97, 23);
		fixframe.getContentPane().add(btnCancle);
		btnCancle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fixframe.setVisible(false);
				professor_view(proVO);
			}
		});
		
		
		JButton btnInput = new JButton("등록");
		btnInput.setBounds(184, 255, 97, 23);
		fixframe.getContentPane().add(btnInput);
		btnInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fixframe.setVisible(false);
				try {
					professor.fix(setName.getText(), setTel.getText(), setEmail.getText(), proVO);
				} catch (NumberFormatException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
	}

	public static void professor_view(professorVO proVO) {
		getVO(proVO);
		proframe = new JFrame();
		proframe.setBounds(100, 100, 472, 232);
		proframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		proframe.getContentPane().setLayout(null);
		proframe.setVisible(true);
		
		JLabel lblTitle = new JLabel("교수용 학사 관리 프로그램");
		lblTitle.setFont(new Font("굴림", Font.PLAIN, 20));
		lblTitle.setBounds(81, 10, 261, 34);
		proframe.getContentPane().add(lblTitle);
		
		JLabel lblNum = new JLabel("직원번호");
		lblNum.setBounds(12, 54, 57, 15);
		proframe.getContentPane().add(lblNum);
		
		JLabel lblUsernum = new JLabel(proVO.getpronum());
		lblUsernum.setBounds(81, 54, 85, 15);
		proframe.getContentPane().add(lblUsernum);
		
		JLabel lblName = new JLabel("이  름");
		lblName.setBounds(182, 54, 57, 15);
		proframe.getContentPane().add(lblName);
		
		JLabel lblUsername = new JLabel(proVO.getname());
		lblUsername.setBounds(251, 54, 91, 15);
		proframe.getContentPane().add(lblUsername);
		
		JButton btnLogout = new JButton("logout");
		btnLogout.setBounds(337, 50, 97, 23);
		proframe.getContentPane().add(btnLogout);
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				proframe.setVisible(false);
				login_view.login_view();
			}
		});
		
		JButton btnFix = new JButton("fix");
		btnFix.setBounds(12, 150, 97, 23);
		proframe.getContentPane().add(btnFix);
		btnFix.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				proframe.setVisible(false);
				fix_view();
			}
		});
		JButton btnDel = new JButton("del");
		btnDel.setBounds(121, 150, 97, 23);
		proframe.getContentPane().add(btnDel);
		btnDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				proframe.setVisible(false);
				del_view();
			}
		});
		
		JButton btnFid = new JButton("fid");
		btnFid.setBounds(230, 150, 97, 23);
		proframe.getContentPane().add(btnFid);
		btnFid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				proframe.setVisible(false);
				find_view(null);
			}
		});
		
		JButton btnClass = new JButton("class");
		btnClass.setBounds(337, 150, 97, 23);
		proframe.getContentPane().add(btnClass);
		btnClass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				proframe.setVisible(false);
				class_view();
			}
		});
	}

	public static void find_view(DefaultTableModel a) {
		// TODO Auto-generated method stub
		String[] type = {"학생정보", "학생성적", "수업별 성적"};
		DefaultTableModel model = new DefaultTableModel(settitle, 0){
			public boolean isCellEditable(int rowIndex, int mColIndex) {
                return false;
            }
        };
        
        if(a != null) {
        	model = a;
        }
		
		findframe = new JFrame();
		findframe.setBounds(300, 300, 646, 300);
		findframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		findframe.setVisible(true);
		findframe.getContentPane().setLayout(null);
	
		JLabel lblSign = new JLabel("교직원 검색");
		lblSign.setBounds(275, 10, 109, 33);
		lblSign.setFont(new Font("굴림", Font.PLAIN, 20));
		findframe.getContentPane().add(lblSign);
		
		JLabel lblTpye = new JLabel("tpye");
		lblTpye.setBounds(12, 64, 57, 15);
		findframe.getContentPane().add(lblTpye);
		
		JComboBox searchtype = new JComboBox(type);
		searchtype.setBounds(57, 61, 140, 21);
		findframe.getContentPane().add(searchtype);
		
		JTextField find = new JTextField();
		find.setBounds(207, 61, 194, 21);
		findframe.getContentPane().add(find);
		find.setColumns(10);
		
		final JTable table = new JTable(model);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(12, 98, 607, 156);
		findframe.getContentPane().add(scrollPane);
		scrollPane.setViewportView(table);
        table.getTableHeader().setReorderingAllowed(false); // 컬럼들 이동 불가
        table.getTableHeader().setResizingAllowed(false); // 컬럼 크기 조절 불가
		

		JButton btnSearch = new JButton("search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String type = (String) searchtype.getSelectedItem();
				String findword = find.getText();
				findframe.setVisible(false);
				professor.find(type, findword, table);
				
			}
		});
		btnSearch.setBounds(413, 60, 97, 23);
		findframe.getContentPane().add(btnSearch);
		
        
		JButton btnCancle = new JButton("cancle");
		btnCancle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				findframe.setVisible(false);
				professor_view(proVO);
			}
		});
		btnCancle.setBounds(522, 60, 97, 23);
		findframe.getContentPane().add(btnCancle);
	}
	
}
