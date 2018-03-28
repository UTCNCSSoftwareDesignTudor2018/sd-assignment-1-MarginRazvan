package dataAcquisition;

import java.util.ArrayList;

import model.Teacher;

public interface TeacherDAOInterface {
	
	public ArrayList<Teacher> findAll();
	
	public Teacher findById(int id);
	
	public Teacher findByEmail(String email);
	
	public void insertTeacher(Teacher teacher);
	
	public void updateTeacher(Teacher teacher);
	
	public void delete(int id);
	
	

}
