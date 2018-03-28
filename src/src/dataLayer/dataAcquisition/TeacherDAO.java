package dataLayer.dataAcquisition;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import dataLayer.connection.ConnectionFactory;
import dataLayer.dataAcquisition.util.TeacherCreator;
import dataLayer.model.Teacher;


public class TeacherDAO implements TeacherDAOInterface {
	
	
	public ArrayList<Teacher> findAll()
	{
		List<Teacher> teachers=null;
		
		TeacherCreator teacherCreator=new TeacherCreator();
		
		try {
		
			Connection connection=ConnectionFactory.getConnection();
			
			PreparedStatement ps= (PreparedStatement) connection.prepareStatement("SELECT * FROM teacher");
			ResultSet rs = ps.executeQuery();
			
			//teachers = createTeachers(rs);
			teachers = teacherCreator.createTeachers(rs);
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return (ArrayList<Teacher>) teachers;
	}
	
	
	public Teacher findById(int id)
	{
		List<Teacher> teachers=null;
		TeacherCreator teacherCreator=new TeacherCreator();
		
		PreparedStatement ps;
		try {
			Connection connection=ConnectionFactory.getConnection();
			
			ps = (PreparedStatement) connection.prepareStatement("SELECT * FROM teacher WHERE teacher_id = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			//teachers = createTeachers(rs);
			teachers= teacherCreator.createTeachers(rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (teachers.size()==0) return null;
		return teachers.get(0);
	}
	
	public Teacher findByEmail(String email)
	{
		List<Teacher> teachers=null;
		TeacherCreator teacherCreator=new TeacherCreator();
		
		PreparedStatement ps;
		try {
			Connection connection=ConnectionFactory.getConnection();
			
			ps = (PreparedStatement) connection.prepareStatement("SELECT * FROM teacher WHERE email = ?");
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			//teachers = createTeachers(rs);
			teachers = teacherCreator.createTeachers(rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (teachers.size()==0) return null;
		return teachers.get(0);
	}
	
	public void insertTeacher(Teacher teacher)
	{
		PreparedStatement ps;
		try {
			Connection connection=ConnectionFactory.getConnection();
			
			ps = (PreparedStatement) connection.prepareStatement("INSERT INTO teacher (name,email,password) VALUES (?,?,?)");
			ps.setString(1, teacher.getName());
			ps.setString(2, teacher.getEmail());
			ps.setString(3, teacher.getPassword());
			
			 ps.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void updateTeacher(Teacher teacher)
	{
		PreparedStatement ps;
		try {
			Connection connection=ConnectionFactory.getConnection();
			
			ps = (PreparedStatement) connection.prepareStatement("UPDATE teacher SET name=? ,email=?,password=? WHERE teacher_id=?");
			ps.setString(1, teacher.getName());
			ps.setString(2, teacher.getEmail());
			ps.setString(3, teacher.getPassword());
			ps.setInt(4,teacher.getTeacher_id());
			
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
			
			ps = (PreparedStatement) connection.prepareStatement("DELETE FROM teacher WHERE teacher_id=?");
			ps.setInt(1, id);
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
//	private List<Teacher> createTeachers(ResultSet resultSet) {
//		List<Teacher> list = new ArrayList<Teacher>();
//
//			try {
//				while (resultSet.next()) {
//					Teacher instance = new Teacher();
//					instance.setName(resultSet.getString("name"));
//					instance.setEmail(resultSet.getString("email"));
//					instance.setPassword(resultSet.getString("password"));
//					instance.setTeacher_id(resultSet.getInt("teacher_id"));
//					
//					list.add(instance);
//					
//					}
//			} catch (SQLException e) {
//
//				e.printStackTrace();
//			}				
//
//			
//		return list;
//	}

}
