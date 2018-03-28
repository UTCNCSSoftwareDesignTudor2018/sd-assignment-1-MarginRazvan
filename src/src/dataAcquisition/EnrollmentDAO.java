package dataAcquisition;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import connection.ConnectionFactory;
import model.Enrollment;
import model.Teacher;

public class EnrollmentDAO {
	
	
	
	public ArrayList<Enrollment> findAll()
	{
		List<Enrollment> enrollments=null;
		
		
		
		try {
		
			Connection connection=ConnectionFactory.getConnection();
			
			PreparedStatement ps= (PreparedStatement) connection.prepareStatement("SELECT * FROM enrollment");
			ResultSet rs = ps.executeQuery();
			
			enrollments = createEnrollments(rs);
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return (ArrayList<Enrollment>) enrollments;
	}
	
	
	public ArrayList<Enrollment> findAllByStudentId(int id)
	{
		List<Enrollment> enrollments=null;
		
		
		PreparedStatement ps;
		try {
			Connection connection=ConnectionFactory.getConnection();
			
			ps = (PreparedStatement) connection.prepareStatement("SELECT * FROM enrollment WHERE student_id = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			enrollments = createEnrollments(rs);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return (ArrayList<Enrollment>) enrollments;
	}
	
	public ArrayList<Enrollment> findAllByCourseId(int id)
	{
		List<Enrollment> enrollments=null;
		
		
		PreparedStatement ps;
		try {
			Connection connection=ConnectionFactory.getConnection();
			
			ps = (PreparedStatement) connection.prepareStatement("SELECT * FROM enrollment WHERE course_id = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			enrollments = createEnrollments(rs);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return (ArrayList<Enrollment>) enrollments;
	}
	
	public Enrollment findByCourseId(int id)
	{
		List<Enrollment> enrollments=null;
		
		
		PreparedStatement ps;
		try {
			Connection connection=ConnectionFactory.getConnection();
			
			ps = (PreparedStatement) connection.prepareStatement("SELECT * FROM enrollment WHERE course_id = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			enrollments = createEnrollments(rs);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (enrollments.size()==0) return null;
		return enrollments.get(0);
	}
	
	
	public void insertEnrollment(Enrollment enrollment)
	{
		PreparedStatement ps;
		try {
			Connection connection=ConnectionFactory.getConnection();
			
			ps = (PreparedStatement) connection.prepareStatement("INSERT INTO enrollment (student_id,course_id) VALUES (?,?)");
			ps.setInt(1, enrollment.getStudent_id());
			ps.setInt(2, enrollment.getCourse_id());
			
			 ps.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void delete(int student_id,int course_id)
	{
		PreparedStatement ps;
		try {
			Connection connection=ConnectionFactory.getConnection();
			
			ps = (PreparedStatement) connection.prepareStatement("DELETE FROM enrollment WHERE student_id=? and course_id=?");
			ps.setInt(1, student_id);
			ps.setInt(2, course_id);
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	private List<Enrollment> createEnrollments(ResultSet resultSet) {
		List<Enrollment> list = new ArrayList<Enrollment>();

			try {
				while (resultSet.next()) {
					Enrollment instance = new Enrollment();
					instance.setCourse_id(resultSet.getInt("course_id"));
					instance.setStudent_id(resultSet.getInt("student_id"));
					list.add(instance);
					
					}
			} catch (SQLException e) {

				e.printStackTrace();
			}				

			
		return list;
	}
	
	

}
