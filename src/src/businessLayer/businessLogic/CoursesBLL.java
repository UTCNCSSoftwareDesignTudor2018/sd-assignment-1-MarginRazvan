package businessLayer.businessLogic;

import java.awt.List;
import java.util.ArrayList;

import com.sun.org.apache.bcel.internal.generic.NEW;

import dataLayer.dataAcquisition.CourseDAO;
import dataLayer.dataAcquisition.CourseDAOInterface;
import dataLayer.dataAcquisition.EnrollmentDAO;
import dataLayer.dataAcquisition.EnrollmentDAOInterface;
import dataLayer.dataAcquisition.StudentDAO;
import dataLayer.model.Course;
import dataLayer.model.Enrollment;

public class CoursesBLL implements CoursesBLLInterface {
	
	private CourseDAOInterface courseDAO;
	private EnrollmentDAOInterface enrollmentDAO;
	
	
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
	
	public ArrayList<Course> findAllByTeacherId(int id)
	{
		ArrayList<Course> courses = courseDAO.findAllByTeacherId(id);
		
		return courses;
	}
	
	public void enroll(int student_id,int course_id)
	{
		Enrollment enrollment=new Enrollment();
		enrollment.setStudent_id(student_id);
		enrollment.setCourse_id(course_id);
		enrollmentDAO.insertEnrollment(enrollment);
	}
	
	public void unEnroll(int student_id,int course_id)
	{
		enrollmentDAO.delete(student_id, course_id);
	}
	
	public ArrayList<Course> findAll()
	{
		return courseDAO.findAll();
	}

}
