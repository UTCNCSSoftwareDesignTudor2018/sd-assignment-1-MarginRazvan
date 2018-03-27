package businessLogic;

import java.awt.List;
import java.util.ArrayList;

import com.sun.org.apache.bcel.internal.generic.NEW;

import dataAcquisition.CourseDAO;
import dataAcquisition.EnrollmentDAO;
import dataAcquisition.StudentDAO;
import model.Course;
import model.Enrollment;

public class CoursesBLL {
	
	private CourseDAO courseDAO;
	private EnrollmentDAO enrollmentDAO;
	
	public CoursesBLL()
	{
		this.courseDAO = new CourseDAO();
		this.enrollmentDAO =new EnrollmentDAO();
	}
	
	public ArrayList<Course> findByStudentId(int id)
	{
		ArrayList<Course> courses = new ArrayList<Course>();
		ArrayList<Enrollment> enrollments =  enrollmentDAO.findAllByStudentId(id);
		
		for (int i=0; i<enrollments.size();i++)
		{
			Course c = courseDAO.findByCourseId(enrollments.get(i).getCourse_id());
			courses.add(c);
		}
		
		return courses;
	}
	
	public void enroll(int student_id,int course_id)
	{
		Enrollment enrollment=new Enrollment();
		enrollment.setStudent_id(student_id);
		enrollment.setCourse_id(course_id);
		enrollmentDAO.insertEnrollment(enrollment);
	}
	
	public ArrayList<Course> findAll()
	{
		return courseDAO.findAll();
	}

}
