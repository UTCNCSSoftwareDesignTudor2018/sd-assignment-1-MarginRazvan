package dataLayer.dataAcquisition;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import dataLayer.connection.ConnectionFactory;
import dataLayer.dataAcquisition.util.GradeCreator;
import dataLayer.model.Exam;
import dataLayer.model.Grade;
import dataLayer.model.Student;

public class GradeDAO implements GradeDAOInterface {
	
	public Grade findById(int course_id,int student_id)
	{
		List<Grade> grades=null;
		GradeCreator gradeCreator = new GradeCreator();
		
		PreparedStatement ps;
		try {
			Connection connection=ConnectionFactory.getConnection();
			
			ps = (PreparedStatement) connection.prepareStatement("SELECT * FROM grade WHERE course___id = ? AND student___id=?");
			ps.setInt(1, course_id);
			ps.setInt(2,student_id);
			ResultSet rs = ps.executeQuery();
			//grades = createGrades(rs);
			grades = gradeCreator.createGrades(rs);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (grades.size()==0) return null;
		return grades.get(0);
	}
	
	public void insertGrade(Grade grade)
	{
		PreparedStatement ps;
		try {
			Connection connection=ConnectionFactory.getConnection();
			
			ps = (PreparedStatement) connection.prepareStatement("INSERT INTO grade (grade,course___id,student___id) VALUES (?,?,?)");
			ps.setInt(1, grade.getGrade());
			ps.setInt(2, grade.getCourse___id());
			ps.setInt(3, grade.getStudent___id());
			
			 ps.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void updateGrade(Grade grade)
	{
		PreparedStatement ps;
		try {
			Connection connection=ConnectionFactory.getConnection();
			
			ps = (PreparedStatement) connection.prepareStatement("UPDATE grade SET grade=? WHERE student___id=? and course___id=?");
			ps.setInt(1, grade.getGrade());
			ps.setInt(2, grade.getStudent___id());
			ps.setInt(3, grade.getCourse___id());
					
			 ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
//	private List<Grade> createGrades(ResultSet resultSet) {
//		List<Grade> list = new ArrayList<Grade>();
//
//			try {
//				while (resultSet.next()) {
//					Grade instance = new Grade();
//					instance.setCourse___id(resultSet.getInt("course___id"));
//					instance.setGrade(resultSet.getInt("grade"));
//					instance.setStudent___id(resultSet.getInt("student___id"));
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
