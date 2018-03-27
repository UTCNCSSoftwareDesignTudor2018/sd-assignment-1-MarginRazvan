package dataAcquisition;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import connection.ConnectionFactory;
import model.Exam;
import model.Grade;

public class GradeDAO {
	
	public Grade findById(int course_id,int student_id)
	{
		List<Grade> grades=null;
		
		
		PreparedStatement ps;
		try {
			Connection connection=ConnectionFactory.getConnection();
			
			ps = (PreparedStatement) connection.prepareStatement("SELECT * FROM grade WHERE course___id = ? AND student___id=?");
			ps.setInt(1, course_id);
			ps.setInt(2,student_id);
			ResultSet rs = ps.executeQuery();
			grades = createGrades(rs);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (grades.size()==0) return null;
		return grades.get(0);
	}
	
	private List<Grade> createGrades(ResultSet resultSet) {
		List<Grade> list = new ArrayList<Grade>();

			try {
				while (resultSet.next()) {
					Grade instance = new Grade();
					instance.setCourse___id(resultSet.getInt("course___id"));
					instance.setGrade(resultSet.getInt("grade"));
					instance.setStudent___id(resultSet.getInt("student___id"));
					list.add(instance);
					
					}
			} catch (SQLException e) {

				e.printStackTrace();
			}				

			
		return list;
	}

}
