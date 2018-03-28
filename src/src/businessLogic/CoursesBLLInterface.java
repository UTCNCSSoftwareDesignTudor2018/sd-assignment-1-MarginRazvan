package businessLogic;

import java.util.ArrayList;

import model.Course;

public interface CoursesBLLInterface {

	public ArrayList<Course> findByStudentId(int id);
	
	public ArrayList<Course> findAllByTeacherId(int id);
	
	public void enroll(int student_id,int course_id);
	
	public void unEnroll(int student_id,int course_id);
	
	public ArrayList<Course> findAll();
	
	
}
