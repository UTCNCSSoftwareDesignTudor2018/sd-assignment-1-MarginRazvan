package dataAcquisition;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import connection.ConnectionFactory;
import model.Course;
import model.Exam;

public class ExamDAO {
	
	
	public Exam findById(int course_id)
	{
		List<Exam> exams=null;
		
		
		PreparedStatement ps;
		try {
			Connection connection=ConnectionFactory.getConnection();
			
			ps = (PreparedStatement) connection.prepareStatement("SELECT * FROM exam WHERE course__id = ?");
			ps.setInt(1, course_id);
			ResultSet rs = ps.executeQuery();
			exams = createExams(rs);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (exams.size()==0) return null;
		return exams.get(0);
	}
	
	
	private List<Exam> createExams(ResultSet resultSet) {
		List<Exam> list = new ArrayList<Exam>();

			try {
				while (resultSet.next()) {
					Exam instance = new Exam();
					instance.setCourse__id(resultSet.getInt("course__id"));
					instance.setDate(resultSet.getDate("date"));
					list.add(instance);
					
					}
			} catch (SQLException e) {

				e.printStackTrace();
			}				

			
		return list;
	}

}
