package view;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

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
import control.student;

public class std_view {
	private static JFrame stdframe, fixframe, delframe, findframe, registframe;
	public static studentVO stdVO = new studentVO();
	public static String[] settitle = {null,null,null,null,null,null};
	public static Map<String, classVO> classMap = Main.getclassMap();
	public static Map<String, gradeVO> gradeMap = Main.getgradeMap();
	
	private static void getVO (studentVO stdVO2) {
		stdVO = stdVO2;
	}

	public static void student_view(studentVO stdVO) {

		
		getVO(stdVO);
		stdframe = new JFrame();
		stdframe.setBounds(100, 100, 460, 221);
		stdframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		stdframe.getContentPane().setLayout(null);
		stdframe.setVisible(true);
		
		JLabel lblTitle = new JLabel("학생용 학사 관리 프로그램");
		lblTitle.setFont(new Font("굴림", Font.PLAIN, 20));
		lblTitle.setBounds(105, 10, 268, 42);
		stdframe.getContentPane().add(lblTitle);
		
		JLabel lblNum = new JLabel("학 번");
		lblNum.setBounds(12, 62, 57, 15);
		stdframe.getContentPane().add(lblNum);
		
		JLabel lblUsernum = new JLabel(stdVO.getstdnum());
		lblUsernum.setBounds(69, 62, 125, 15);
		stdframe.getContentPane().add(lblUsernum);
		
		JLabel lblName = new JLabel("이 름");
		lblName.setBounds(206, 62, 57, 15);
		stdframe.getContentPane().add(lblName);
		
		JLabel lblUsername = new JLabel(stdVO.getname());
		lblUsername.setBounds(287, 62, 125, 15);
		stdframe.getContentPane().add(lblUsername);
		

		JButton btnLogout = new JButton("logout");
		btnLogout.setBounds(337, 50, 97, 23);
		stdframe.getContentPane().add(btnLogout);
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stdframe.setVisible(false);
				login_view.login_view();
			}
		});
		
		JButton btnFix = new JButton("fix");
		btnFix.setBounds(12, 146, 97, 23);
		stdframe.getContentPane().add(btnFix);
		btnFix.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stdframe.setVisible(false);
				fix_view();
			}
		});
		
		JButton btnDel = new JButton("del");
		btnDel.setBounds(116, 146, 97, 23);
		stdframe.getContentPane().add(btnDel);
		btnDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stdframe.setVisible(false);
				del_view();
			}
		});
		
		JButton btnFind = new JButton("find");
		btnFind.setBounds(225, 146, 97, 23);
		stdframe.getContentPane().add(btnFind);
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stdframe.setVisible(false);
				find_view(null);
			}
		});
		
		JButton btnRegist = new JButton("regist");
		btnRegist.setBounds(334, 146, 97, 23);
		stdframe.getContentPane().add(btnRegist);
		btnRegist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stdframe.setVisible(false);
				regist_view();
			}
		});
		
	}

	public static void find_view(DefaultTableModel a) {
		// TODO Auto-generated method stub

		String[] type = {"수업검색", "성적", "학년별 성적"};
		

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
	
		JLabel lblSign = new JLabel("학생 검색");
		lblSign.setBounds(275, 10, 109, 33);
		lblSign.setFont(new Font("굴림", Font.PLAIN, 20));
		findframe.getContentPane().add(lblSign);
		
		JLabel lblTpye = new JLabel("tpye");
		lblTpye.setBounds(12, 64, 57, 15);
		findframe.getContentPane().add(lblTpye);
		
		JComboBox<Object> searchtype = new JComboBox<Object>(type);
		searchtype.setBounds(57, 61, 140, 21);
		findframe.getContentPane().add(searchtype);
		
		JTextField find = new JTextField();
		find.setBounds(207, 61, 194, 21);
		findframe.getContentPane().add(find);
		find.setColumns(10);
		
		JButton btnSearch = new JButton("search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String type = (String) searchtype.getSelectedItem();
				String findword = find.getText();
				findframe.setVisible(false);
				student.find(type, findword, stdVO);
			}
		});
		btnSearch.setBounds(413, 60, 97, 23);
		findframe.getContentPane().add(btnSearch);
		
		final JTable table = new JTable(model);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(12, 98, 607, 156);
		findframe.getContentPane().add(scrollPane);
		scrollPane.setViewportView(table);
        table.getTableHeader().setReorderingAllowed(false); // 컬럼들 이동 불가
        table.getTableHeader().setResizingAllowed(false); // 컬럼 크기 조절 불가
		
		JButton btnCancle = new JButton("cancle");
		btnCancle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				findframe.setVisible(false);
				student_view(stdVO);
			}
		});
		btnCancle.setBounds(522, 60, 97, 23);
		findframe.getContentPane().add(btnCancle);
	}

	public static void regist_view() {
		// TODO Auto-generated method stub
		String[] row = {"수업코드","수업명","학년","신청인원", "총원", "담당교수"};
		DefaultTableModel model = new DefaultTableModel(row, 0) {
			public boolean isCellEditable(int rowIndex, int mColIndex) {
                return false;
            }
        };
		
		registframe = new JFrame();
		registframe.setBounds(300, 300, 673, 353);
		registframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		registframe.setVisible(true);
		registframe.getContentPane().setLayout(null);
	
		JLabel lblSign = new JLabel("수업 신청");
		lblSign.setBounds(272, 10, 109, 33);
		lblSign.setFont(new Font("굴림", Font.PLAIN, 20));
		registframe.getContentPane().add(lblSign);
		
		final JTable table = new JTable(model);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(28, 64, 491, 211);
		registframe.getContentPane().add(scrollPane);
		
		Iterator<String> l = classMap.keySet().iterator();
		classVO classVO = null;
		while(l.hasNext()) {
			String key = l.next();
			classVO = classMap.get(key);
			if(stdVO.getyear() == classVO.getyear() && classVO.getsemester() == true) {
				Object[] data = { key, classVO.getclassname(), classVO.getyear(), classVO.getregister(), classVO.gettotal(), classVO.getpronum()};
				model.addRow(data);
			}
		}
		
		scrollPane.setViewportView(table);
		

        table.getTableHeader().setReorderingAllowed(false); // 컬럼들 이동 불가
        table.getTableHeader().setResizingAllowed(false); // 컬럼 크기 조절 불가
		
		JButton btnRegist = new JButton("regist");
		btnRegist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				
				String value = (String) table.getValueAt(row, 0);
				System.out.println(value);
				if (value != null) {
					registframe.setVisible(false);
					try {
						student.regist(value, stdVO);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btnRegist.setBounds(531, 67, 97, 23);
		registframe.getContentPane().add(btnRegist);
		
		JButton btnCancle = new JButton("cancle");
		btnCancle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registframe.setVisible(false);
				student_view(stdVO);
			}
		});
		btnCancle.setBounds(531, 136, 97, 23);
		registframe.getContentPane().add(btnCancle);
	}

	protected static void del_view() {
		// TODO Auto-generated method stub
		delframe = new JFrame();
		delframe.setBounds(300, 300, 440, 249);
		delframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		delframe.getContentPane().setLayout(null);
		delframe.setVisible(true);
	
		JLabel lblSign = new JLabel("학생 삭제");
		lblSign.setFont(new Font("굴림", Font.PLAIN, 20));
		lblSign.setBounds(165, 31, 109, 33);
		delframe.getContentPane().add(lblSign);
	
		JLabel lblStdnum = new JLabel("학번");
		lblStdnum.setBounds(44, 98, 57, 15);
		delframe.getContentPane().add(lblStdnum);
	
		JLabel lblName = new JLabel("이름");
		lblName.setBounds(224, 98, 57, 15);
		delframe.getContentPane().add(lblName);
		
		JLabel lblUsernum = new JLabel(stdVO.getstdnum());
		lblUsernum.setBounds(101, 98, 57, 15);
		delframe.getContentPane().add(lblUsernum);
		
		JLabel lblUsername = new JLabel(stdVO.getname());
		lblUsername.setBounds(293, 98, 57, 15);
		delframe.getContentPane().add(lblUsername);
		
		JButton btnCancle = new JButton("cancle");
		btnCancle.setBounds(44, 160, 97, 23);
		delframe.getContentPane().add(btnCancle);
		btnCancle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delframe.setVisible(false);
				student_view(stdVO);
			}
		});
		
		JButton btnDel = new JButton("del");
		btnDel.setBounds(253, 160, 97, 23);
		delframe.getContentPane().add(btnDel);
		btnDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delframe.setVisible(false);
				try {
					student.del(stdVO);
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
		fixframe.setBounds(300, 300, 358, 482);
		fixframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fixframe.getContentPane().setLayout(null);
		fixframe.setVisible(true);
	
		JLabel lblSign = new JLabel("학생 수정");
		lblSign.setFont(new Font("굴림", Font.PLAIN, 20));
		lblSign.setBounds(100, 28, 109, 33);
		fixframe.getContentPane().add(lblSign);
	
		JLabel lblStdnum = new JLabel("학번");
		lblStdnum.setBounds(44, 98, 57, 15);
		fixframe.getContentPane().add(lblStdnum);

		JLabel lblStdnum1 = new JLabel(stdVO.getstdnum());
		lblStdnum1.setBounds(165, 98, 57, 15);
		fixframe.getContentPane().add(lblStdnum1);
	
		Component lblName = new JLabel("이름");
		lblName.setBounds(44, 138, 57, 15);
		fixframe.getContentPane().add(lblName);
	
		JTextField setName = new JTextField(stdVO.getname());
		setName.setBounds(165, 135, 116, 21);
		fixframe.getContentPane().add(setName);
		setName.setColumns(10);
	
		JLabel lblTel = new JLabel("tel");
		lblTel.setBounds(44, 180, 57, 15);
		fixframe.getContentPane().add(lblTel);
	
		JTextField setTel = new JTextField(stdVO.gettel());
		setTel.setBounds(165, 177, 116, 21);
		fixframe.getContentPane().add(setTel);
		setTel.setColumns(10);
	
		JLabel lblEmail = new JLabel("e-mail");
		lblEmail.setBounds(44, 218, 57, 15);
		fixframe.getContentPane().add(lblEmail);
	
		JTextField setEmail = new JTextField(stdVO.getemail());
		setEmail.setBounds(165, 215, 116, 21);
		fixframe.getContentPane().add(setEmail);
		setEmail.setColumns(10);
	
		JLabel lblYear = new JLabel("학년");
		lblYear.setBounds(44, 256, 57, 15);
		fixframe.getContentPane().add(lblYear);
	
		JTextField setYear = new JTextField(Integer.toString(stdVO.getyear()));
		setYear.setBounds(165, 253, 116, 21);
		fixframe.getContentPane().add(setYear);
	
		JLabel lblGender = new JLabel("성별");
		lblGender.setBounds(44, 303, 57, 15);
		fixframe.getContentPane().add(lblGender);
		
		JTextField setGender = new JTextField(stdVO.getgender());
		setGender.setBounds(165, 300, 116, 21);
		fixframe.getContentPane().add(setGender);
		setGender.setColumns(10);
	
		JButton btnCancle = new JButton("취소");
		btnCancle.setBounds(44, 364, 97, 23);
		fixframe.getContentPane().add(btnCancle);
		btnCancle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fixframe.setVisible(false);
				student_view(stdVO);
			}
		});
	
		JButton btnInput = new JButton("등록");
		btnInput.setBounds(184, 364, 97, 23);
		fixframe.getContentPane().add(btnInput);
		btnInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fixframe.setVisible(false);
				try {
					student.fix(setName.getText(), setTel.getText(), setEmail.getText(), setYear.getText(), setGender.getText(), stdVO);
				} catch (NumberFormatException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}
	
}
