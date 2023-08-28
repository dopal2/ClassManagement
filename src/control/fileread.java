package control;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import Main.Main;
import VO.classVO;
import VO.gradeVO;
import VO.professorVO;
import VO.studentVO;

public class fileread {
	
	public static Map stdMap = Main.getstdMap();
	public static Map proMap = Main.getproMap();
	public static Map<String, classVO> classMap = Main.getclassMap();
	public static Map<String, gradeVO> gradeMap = Main.getgradeMap();
	
	public static void readstudent() throws NumberFormatException, IOException{
		File student = new File("src\data\student.txt");
		FileReader filereader = new FileReader(student);
        BufferedReader bufReader = new BufferedReader(filereader);
        String line = null;
        while((line = bufReader.readLine()) != null){
            String[] read = line.split("%%%%");
            studentVO stdVO = new studentVO();
            stdVO.setstdnum(read[0]);
            stdVO.setname(read[1]);
            stdVO.settel(read[2]);
            stdVO.setemail(read[3]);
            stdVO.setyear(Integer.parseInt(read[4]));
            stdMap.put(stdVO.getstdnum(), stdVO);
        }          
        bufReader.close();
	}
	
	public static void readprofessor() throws IOException {
		File professor = new File("src\data\professor.txt");
		FileReader filereader = new FileReader(professor);
        BufferedReader bufReader = new BufferedReader(filereader);
        String line = null;
        while((line = bufReader.readLine()) != null){
            String[] read = line.split("%%%%");
            professorVO proVO = new professorVO();
            proVO.setpronum(read[0]);
            proVO.setname(read[1]);
            proVO.settel(read[2]);
            proVO.setemail(read[3]);
            proMap.put(proVO.getpronum(), proVO);
        }
	}
	
	public void readclass() throws NumberFormatException, IOException {
		File classfile = new File("src\data\class.txt");
		FileReader filereader = new FileReader(classfile);
        BufferedReader bufReader = new BufferedReader(filereader);
        String line = null;
        while((line = bufReader.readLine()) != null){
            String[] read = line.split("%%%%");
            classVO classVO = new classVO();
            
            classVO.setclasskey(read[0]);
            classVO.setpronum(read[1]);
            classVO.setclassname(read[2]);
            classVO.setyear(Integer.parseInt(read[3]));
            classVO.setregister(Integer.parseInt(read[4]));
            classVO.settotal(Integer.parseInt(read[5]));
            classVO.setsemester(Boolean.parseBoolean(read[6]));
            classMap.put(classVO.getclasskey(), classVO);
        }
	}
	
	public void readgrade() throws NumberFormatException, IOException {
		File gradefile = new File("src\data\grade.txt");
		FileReader filereader = new FileReader(gradefile);
        BufferedReader bufReader = new BufferedReader(filereader);
        String line = null;
        while((line = bufReader.readLine()) != null){
            String[] read = line.split("%%%%");
            gradeVO gradeVO = new gradeVO();
            
            gradeVO.setgradekey(read[0]);
            gradeVO.setclassname(read[1]);
            gradeVO.setstdnum(read[2]);
            gradeVO.setgrade(Float.parseFloat(read[3]));
            
            gradeMap.put(gradeVO.getgradekey(), gradeVO);
        }
	}

	public void writestudent(String key) throws IOException {
		File student = new File("src\data\student.txt");
		FileWriter filewriter = new FileWriter(student, true);
		BufferedWriter bufwriter = new BufferedWriter(filewriter);
		studentVO stdVO = new studentVO();
		stdVO = (studentVO) stdMap.get(key);
		bufwriter.write(stdVO.getstdnum()+"%%%%"+stdVO.getname()+"%%%%"+stdVO.gettel()+"%%%%"+stdVO.getemail()+"%%%%"+String.valueOf(stdVO.getyear())+"%%%%"+stdVO.getgender());
		bufwriter.newLine();
		bufwriter.flush();
	}
	public void writeprofessor(String key) throws IOException {
		File professor = new File("src\data\professor.txt");
		FileWriter filewriter = new FileWriter(professor, true);
		BufferedWriter bufwriter = new BufferedWriter(filewriter);
		professorVO proVO = new professorVO();
		proVO = (professorVO) proMap.get(key);
		bufwriter.write(proVO.getpronum()+"%%%%"+proVO.getname()+"%%%%"+proVO.gettel()+"%%%%"+proVO.getemail());
		bufwriter.newLine();
		bufwriter.flush();
	}

	public void writeclass(String key) throws IOException {
		// TODO Auto-generated method stub
		File classdata = new File("src\data\class.txt");
		FileWriter filewriter = new FileWriter(classdata, true);
		BufferedWriter bufwriter = new BufferedWriter(filewriter);
		classVO classVO = new classVO();
		classVO = classMap.get(key);
		bufwriter.write(classVO.getclasskey()+"%%%%"+classVO.getpronum()+"%%%%"+classVO.getclassname()+"%%%%"+classVO.getyear()+"%%%%"+ classVO.getregister()+"%%%%"+classVO.gettotal()+"%%%%"+classVO.getsemester());
		bufwriter.newLine();
		bufwriter.flush();
	}

	
	public void writegrade(String key) throws IOException {
		// TODO Auto-generated method stub
		File grade = new File("src\data\grade.txt");
		FileWriter filewriter = new FileWriter(grade, true);
		BufferedWriter bufwriter = new BufferedWriter(filewriter);
		gradeVO gradeVO = new gradeVO();
		gradeVO = gradeMap.get(key);
		bufwriter.write(gradeVO.getgradekey()+"%%%%"+gradeVO.getclassname()+"%%%%"+gradeVO.getstdnum()+"%%%%"+gradeVO.getgrade());
		bufwriter.newLine();
		bufwriter.flush();
	}

	public void stdMapsave() throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		File student = new File("src\data\student.txt");
		FileWriter filewriter = new FileWriter(student);
		BufferedWriter bufwriter = new BufferedWriter(filewriter);
        String line = null;
        Iterator<String> a = stdMap.keySet().iterator();
        while(a.hasNext()) {
        	String key = a.next();
        	studentVO stdVO = new studentVO();
            stdVO = (studentVO) stdMap.get(key);
    		bufwriter.write(stdVO.getstdnum()+"%%%%"+stdVO.getname()+"%%%%"+stdVO.gettel()+"%%%%"+stdVO.getemail()+"%%%%"+String.valueOf(stdVO.getyear())+"%%%%"+stdVO.getgender());
    		bufwriter.newLine();
    		bufwriter.flush();
        }
	}

	public void proMapsave() throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		File professor = new File("src\data\professor.txt");
		FileWriter filewriter = new FileWriter(professor);
		BufferedWriter bufwriter = new BufferedWriter(filewriter);
        String line = null;
        Iterator<String> a = proMap.keySet().iterator();
        while(a.hasNext()) {
        	String key = a.next();
        	professorVO proVO = new professorVO();
            proVO = (professorVO) proMap.get(key);
    		bufwriter.write(proVO.getpronum()+"%%%%"+proVO.getname()+"%%%%"+proVO.gettel()+"%%%%"+proVO.getemail());
    		bufwriter.newLine();
    		bufwriter.flush();
        }
	}

	public void classMapsave() throws IOException {
		File classdata = new File("src\data\class.txt");
		FileWriter filewriter = new FileWriter(classdata);
		BufferedWriter bufwriter = new BufferedWriter(filewriter);
		String line = null;
		Iterator<String> a = classMap.keySet().iterator();
		while(a.hasNext()) {
			String key = a.next();
			classVO classVO = new classVO();
			classVO = classMap.get(key);
			bufwriter.write(classVO.getclasskey()+"%%%%"+classVO.getpronum()+"%%%%"+classVO.getclassname()+"%%%%"+classVO.getyear()+"%%%%"+ classVO.getregister()+"%%%%"+classVO.gettotal()+"%%%%"+classVO.getsemester());
			bufwriter.newLine();
			bufwriter.flush();

		}
	}
	public void gradeMapsave() throws IOException {
		File grade = new File("src\data\grade.txt");
		FileWriter filewriter = new FileWriter(grade);
		BufferedWriter bufwriter = new BufferedWriter(filewriter);
		String line = null;
		Iterator<String> a = gradeMap.keySet().iterator();
		while(a.hasNext()) {
			String key = a.next();
			gradeVO gradeVO = new gradeVO();
			gradeVO = gradeMap.get(key);
			bufwriter.write(gradeVO.getgradekey()+"%%%%"+gradeVO.getclassname()+"%%%%"+gradeVO.getstdnum()+"%%%%"+gradeVO.getgrade());
			bufwriter.newLine();
			bufwriter.flush();
		}
	}
}
