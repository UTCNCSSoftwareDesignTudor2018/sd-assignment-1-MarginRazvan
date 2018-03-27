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
	
//	public ArrayList<Course> findByStudentId(int id)
//	{
//		//ArrayList<Enrollment> enrollments =  enrollmentDAO.findByStudentId(id);
//		
//	}
	

}
