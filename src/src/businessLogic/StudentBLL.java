package businessLogic;

import dataAcquisition.StudentDAO;
import model.Student;

public class StudentBLL {
	
	
	private StudentDAO studentdao;
	
	
	public StudentBLL()
	{
		studentdao = new StudentDAO();
	}
	
	
	public boolean login(String email, String password)
	{
		Student student= studentdao.findByEmail(email);
		
		if (student!=null&&student.getPassword().equals(password))
		{
			return true;
		}
		return false;
		
	}
	
	public Student findByEmail(String email)
	{
		return studentdao.findByEmail(email);
	}
	
	public Student findById(int id)
	{
		return studentdao.findById(id);
	}
	
	public void updateProfile(int id,String name,String email, String cnp, int group,String password)
	{
		Student student = new Student(name,email,cnp,group,password);
		student.setStudent_id(id);
		
		studentdao.updateStudent(student);
	}

}
