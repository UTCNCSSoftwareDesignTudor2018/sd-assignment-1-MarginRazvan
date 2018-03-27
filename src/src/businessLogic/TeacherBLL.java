package businessLogic;

import dataAcquisition.TeacherDAO;
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

}
