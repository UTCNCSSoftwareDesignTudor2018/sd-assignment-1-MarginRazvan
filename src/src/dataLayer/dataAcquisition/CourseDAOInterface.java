package dataLayer.dataAcquisition;

import java.util.ArrayList;

import dataLayer.model.Course;

public interface CourseDAOInterface {

	public ArrayList<Course> findAll();
	
	public ArrayList<Course> findAllByTeacherId(int id);
	
	public Course findByCourseId(int id);
	
	public Course findByTeacherId(int id);
	
	public void insertCourse(Course course);
	
	
}
