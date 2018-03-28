package dataAcquisition;

import java.util.ArrayList;

import model.Student;

public interface StudentDAOInterface {
	public ArrayList<Student> findAll();
	
	public Student findById(int id);
	
	public Student findByEmail(String email);
	
	public void insertStudent(Student student);
	
	public void updateStudent(Student student);
	
	public void delete(int id);
	
	
	
	
}
