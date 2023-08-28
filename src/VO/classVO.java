package VO;


public class classVO {
	private static String classkey;
	private String classname;
	private int year;
	private String pronum;
	private int register;
	private int total;
	private boolean semester = true;
	
	public static String getclasskey() {
		return classkey;
	}
	public String getclassname() {
		return classname;
	}
	public int getyear() {
		return year;
	}
	public String getpronum() {
		return pronum;
	}
	public int getregister() {
		return register;
	}
	public int gettotal() {
		return total;
	}
	public boolean getsemester() {
		return semester;
	}
	public void setclasskey(String classkey) {
		this.classkey = classkey;
	}
	public void setclassname(String classname) {
		this.classname = classname;
	}
	public void setyear(int year) {
		this.year = year;
	}
	public void setpronum(String pronum) {
		this.pronum = pronum;
	}
	public void setregister(int register) {
		this.register = register;
	}
	public void settotal(int total) {
		this.total = total;
	}
	public void setsemester(boolean semester) {
		this.semester = semester;
	}
	public void set() {
		classkey = null;
		classname = null;
		year = 0;
		pronum = null;
		register = 0;
		total = 0;
		semester = false;
	}
}
