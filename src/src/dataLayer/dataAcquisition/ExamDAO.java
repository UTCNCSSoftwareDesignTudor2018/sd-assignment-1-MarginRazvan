package dataLayer.dataAcquisition;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import dataLayer.connection.ConnectionFactory;
import dataLayer.dataAcquisition.util.ExamCreator;
import dataLayer.model.Course;
import dataLayer.model.Exam;
import dataLayer.model.Student;
import sun.font.CreatedFontTracker;

public class ExamDAO implements ExamDAOInterface {
	
	
	public Exam findById(int course_id)
	{
		List<Exam> exams=null;
		
		ExamCreator examCreator= new ExamCreator();
		PreparedStatement ps;
		try {
			Connection connection=ConnectionFactory.getConnection();
			
			ps = (PreparedStatement) connection.prepareStatement("SELECT * FROM exam WHERE course__id = ?");
			ps.setInt(1, course_id);
			ResultSet rs = ps.executeQuery();
			//exams = createExams(rs);
			exams = examCreator.createExams(rs);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (exams.size()==0) return null;
		return exams.get(0);
	}
	
	public void insertExam(Exam exam)
	{
		PreparedStatement ps;
		try {
			Connection connection=ConnectionFactory.getConnection();
			
			ps = (PreparedStatement) connection.prepareStatement("INSERT INTO exam (course__id,date) VALUES (?,?)");
			ps.setInt(1, exam.getCourse__id());
			ps.setDate(2, exam.getDate());
			
			 ps.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
//	private List<Exam> createExams(ResultSet resultSet) {
//		List<Exam> list = new ArrayList<Exam>();
//
//			try {
//				while (resultSet.next()) {
//					Exam instance = new Exam();
//					instance.setCourse__id(resultSet.getInt("course__id"));
//					instance.setDate(resultSet.getDate("date"));
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
