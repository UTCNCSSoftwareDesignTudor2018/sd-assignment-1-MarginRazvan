package businessLogic;

import dataAcquisition.TeacherDAO;
import model.Student;
import model.Teacher;

public class TeacherBLL {
	
	private TeacherDAO teacherDAO;
	
	public TeacherBLL()
	{
		this.teacherDAO=new TeacherDAO();
	}
	
	
	public Teacher findById(int id)
	{
		return teacherDAO.findById(id);
	}
	
	
	public boolean login(String email, String password)
	{
		Teacher teacher= teacherDAO.findByEmail(email);
		
		if (teacher!=null&&teacher.getPassword().equals(password))
		{
			return true;
		}
		return false;
		
	}
	
	public Teacher findByEmail(String email)
	{
		return teacherDAO.findByEmail(email);
	}
	
	public void updateProfile(int id,String name,String email,String password)
	{
		Teacher teacher = new Teacher(name,email,password);
		teacher.setTeacher_id(id);
		
		teacherDAO.updateTeacher(teacher);
	}

}
