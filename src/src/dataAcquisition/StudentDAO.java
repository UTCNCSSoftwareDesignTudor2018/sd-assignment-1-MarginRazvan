package dataAcquisition;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import connection.ConnectionFactory;
import model.Student;

public class StudentDAO {
	

	
	public ArrayList<Student> findAll()
	{
		List<Student> students=null;
		
		
		
		try {
		
			Connection connection=ConnectionFactory.getConnection();
			
			PreparedStatement ps= (PreparedStatement) connection.prepareStatement("SELECT * FROM student");
			ResultSet rs = ps.executeQuery();
			
			students = createStudents(rs);
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return (ArrayList<Student>) students;
	}
	
	
	public Student findById(int id)
	{
		List<Student> students=null;
		
		
		PreparedStatement ps;
		try {
			Connection connection=ConnectionFactory.getConnection();
			
			ps = (PreparedStatement) connection.prepareStatement("SELECT * FROM student WHERE student_id = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			students = createStudents(rs);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (students.size()==0) return null;
		return students.get(0);
	}
	
	public Student findByEmail(String email)
	{
		List<Student> students=null;
		
		
		PreparedStatement ps;
		try {
			Connection connection=ConnectionFactory.getConnection();
			
			ps = (PreparedStatement) connection.prepareStatement("SELECT * FROM student WHERE email = ?");
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			students = createStudents(rs);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (students.size()==0) return null;
		return students.get(0);
	}
	
	public void insertStudent(Student student)
	{
		PreparedStatement ps;
		try {
			Connection connection=ConnectionFactory.getConnection();
			
			ps = (PreparedStatement) connection.prepareStatement("INSERT INTO student (name,email,cnp,password,student_group) VALUES (?,?,?,?,?)");
			ps.setString(1, student.getName());
			ps.setString(2, student.getEmail());
			ps.setString(3, student.getCnp());
			ps.setString(4, student.getPassword());
			ps.setInt(5, student.getGroup());
			
			 ps.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void updateStudent(Student student)
	{
		PreparedStatement ps;
		try {
			Connection connection=ConnectionFactory.getConnection();
			
			ps = (PreparedStatement) connection.prepareStatement("UPDATE student SET name=? ,email=?,cnp=?,password=?,student_group=? WHERE student_id=?");
			ps.setString(1, student.getName());
			ps.setString(2, student.getEmail());
			ps.setString(3, student.getCnp());
			ps.setString(4, student.getPassword());
			ps.setInt(5, student.getGroup());
			ps.setInt(6, student.getStudent_id());
			
			 ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public void delete(int id)
	{
		PreparedStatement ps;
		try {
			Connection connection=ConnectionFactory.getConnection();
			
			ps = (PreparedStatement) connection.prepareStatement("DELETE FROM student WHERE student_id=?");
			ps.setInt(1, id);
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	private List<Student> createStudents(ResultSet resultSet) {
		List<Student> list = new ArrayList<Student>();

			try {
				while (resultSet.next()) {
					Student instance = new Student();
					instance.setName(resultSet.getString("name"));
					instance.setEmail(resultSet.getString("email"));
					instance.setCnp(resultSet.getString("cnp"));
					instance.setPassword(resultSet.getString("password"));
					instance.setGroup(resultSet.getInt("student_group"));
					instance.setStudent_id(resultSet.getInt("student_id"));
					
					list.add(instance);
					
					}
			} catch (SQLException e) {

				e.printStackTrace();
			}				

			
		return list;
	}

}
