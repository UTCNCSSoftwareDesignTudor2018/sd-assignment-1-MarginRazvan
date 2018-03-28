package dataLayer.dataAcquisition.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dataLayer.model.Exam;

public class ExamCreator {
	
	public List<Exam> createExams(ResultSet resultSet) {
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
