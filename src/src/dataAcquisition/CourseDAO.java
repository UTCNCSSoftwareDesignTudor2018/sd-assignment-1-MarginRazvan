package dataAcquisition;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import connection.ConnectionFactory;
import dataAcquisition.util.CourseCreator;
import model.Course;

public class CourseDAO implements CourseDAOInterface {

	
	public ArrayList<Course> findAll()
	{
		List<Course> courses=null;
		
		CourseCreator courseCreator= new CourseCreator();
		
		try {
		
			Connection connection=ConnectionFactory.getConnection();
			
			PreparedStatement ps= (PreparedStatement) connection.prepareStatement("SELECT * FROM course");
			ResultSet rs = ps.executeQuery();
			
			//courses = createCourses(rs);
			courses = courseCreator.createCourses(rs);
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return (ArrayList<Course>) courses;
	}
	
	public ArrayList<Course> findAllByTeacherId(int id)
	{
		List<Course> courses=null;
		CourseCreator courseCreator= new CourseCreator();
		
		PreparedStatement ps;
		try {
			Connection connection=ConnectionFactory.getConnection();
			
			ps = (PreparedStatement) connection.prepareStatement("SELECT * FROM course WHERE teacher_id = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			//courses = createCourses(rs);
			courses= courseCreator.createCourses(rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (courses.size()==0) return null;
		return (ArrayList<Course>) courses;
	}
	
	
	public Course findByCourseId(int id)
	{
		List<Course> courses=null;
		CourseCreator courseCreator= new CourseCreator();
		
		PreparedStatement ps;
		try {
			Connection connection=ConnectionFactory.getConnection();
			
			ps = (PreparedStatement) connection.prepareStatement("SELECT * FROM course WHERE course_id = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			//courses = createCourses(rs);
			courses = courseCreator.createCourses(rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (courses.size()==0) return null;
		return courses.get(0);
	}
	
	public Course findByTeacherId(int id)
	{
		List<Course> courses=null;
		CourseCreator courseCreator= new CourseCreator();
		
		PreparedStatement ps;
		try {
			Connection connection=ConnectionFactory.getConnection();
			
			ps = (PreparedStatement) connection.prepareStatement("SELECT * FROM course WHERE course_id = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			//courses = createCourses(rs);
			courses = courseCreator.createCourses(rs);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (courses.size()==0) return null;
		return courses.get(0);
	}
	
	
	public void insertCourse(Course course)
	{
		PreparedStatement ps;
		try {
			Connection connection=ConnectionFactory.getConnection();
			
			ps = (PreparedStatement) connection.prepareStatement("INSERT INTO enrollment (course_id,name,teacher_id) VALUES (?,?,?)");
			ps.setInt(1, course.getCourse_id());
			ps.setString(2, course.getName());
			ps.setInt(3, course.getTeacher_id());
			
			 ps.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
//	private List<Course> createCourses(ResultSet resultSet) {
//		List<Course> list = new ArrayList<Course>();
//
//			try {
//				while (resultSet.next()) {
//					Course instance = new Course();
//					instance.setCourse_id(resultSet.getInt("course_id"));
//					instance.setName(resultSet.getString("name"));
//					instance.setTeacher_id(resultSet.getInt("teacher_id"));
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
