package dataAcquisition;

import java.util.ArrayList;

import model.Enrollment;

public interface EnrollmentDAOInterface {
	public ArrayList<Enrollment> findAll();
	
	public ArrayList<Enrollment> findAllByStudentId(int id);
	
	public ArrayList<Enrollment> findAllByCourseId(int id);
	
	public Enrollment findByCourseId(int id);
	
	public void insertEnrollment(Enrollment enrollment);
	
	public void delete(int student_id,int course_id);
	
}
