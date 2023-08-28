package VO;


public class studentVO extends nomalVO{
	
	private  String stdnum;
	private int year;
	private String gender;
	
	public String getstdnum() {
		return stdnum;
	}
	public int getyear() {
		return year;
	}
	public String getgender() {
		return gender;
	}
	public void setstdnum(String stdnum) {
		this.stdnum = stdnum;
	}
	public void setyear(int year) {
		this.year = year;
	}
	public void setgender(String gender) {
		this.gender = gender;
	}
}
