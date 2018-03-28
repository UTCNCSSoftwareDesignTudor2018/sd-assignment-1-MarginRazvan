package businessLogic;

import java.util.ArrayList;

import dataAcquisition.EnrollmentDAO;
import dataAcquisition.StudentDAO;
import dataAcquisition.StudentDAOInterface;
import model.Course;
import model.Enrollment;
import model.Student;

public class StudentBLL implements StudentBLLInterface {
	
	
	private StudentDAOInterface studentdao;
	private EnrollmentDAO enrollmentDAO;
	
	
	public StudentBLL()
	{
		studentdao = new StudentDAO();
		enrollmentDAO= new EnrollmentDAO();
	}
	
	public ArrayList<Student> findByCourseId(int id)
	{
		ArrayList<Student> students = new ArrayList<Student>();
		ArrayList<Enrollment> enrollments =  enrollmentDAO.findAllByCourseId(id);
		
		for (int i=0; i<enrollments.size();i++)
		{
			Student s = studentdao.findById(enrollments.get(i).getStudent_id()); 
			students.add(s);
		}
		
		return students;
	}
	
	
	public boolean login(String email, String password)
	{
		Student student= studentdao.findByEmail(email);
		
		if (student!=null&&student.getPassword().equals(password))
		{
			return true;
		}
		return false;
		
	}
	
	public Student findByEmail(String email)
	{
		return studentdao.findByEmail(email);
	}
	
	public Student findById(int id)
	{
		return studentdao.findById(id);
	}
	
	public void updateProfile(int id,String name,String email, String cnp, int group,String password)
	{
		Student student = new Student(name,email,cnp,group,password);
		student.setStudent_id(id);
		
		studentdao.updateStudent(student);
	}

}
