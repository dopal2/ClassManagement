package VO;


public class gradeVO {
	private String gradekey;
	private String stdnum;
	private String classname;
	private float grade;
	
	
	public String getgradekey() {
		return gradekey;
	}
	public String getstdnum() {
		return stdnum;
	}
	public String getclassname() {
		return classname;
	}
	public float getgrade() {
		return grade;
	}
	public void setgradekey(String gradekey) {
		this.gradekey = gradekey;
	}
	public void setstdnum(String string) {
		this.stdnum = string;
	}
	public void setclassname(String classname) {
		this.classname = classname;
	}
	public void setgrade(float grade) {
		this.grade = grade;
	}
	public void setnull() {
		// TODO Auto-generated method stub
		gradekey = null;
		stdnum = null;
		classname = null;
		grade = 0;
	}
}
