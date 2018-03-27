import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import connection.ConnectionFactory;
import controller.LoginController;
import dataAcquisition.StudentDAO;
import model.Student;

public class Main {

	public static void main(String[] args) {
		
		LoginController controller=new LoginController();
		// TODO Auto-generated method stub
		
		//StudentDAO s=new StudentDAO();
		
		//ArrayList<Student> students= s.findAll();
		
		//Student student=s.findById(4);
		//Student student = s.findByEmail("dan@yahoo.com");
		//Student student1= new Student("adi", "adi@yahoo.com", "123123", 30423, "pass2");
		//s.insertStudent(student1);
		//System.out.println(student.toString());
		
		//Student student=s.findById(2);
		
		//student.setCnp("123131");
		//s.delete(5);
	}

}
