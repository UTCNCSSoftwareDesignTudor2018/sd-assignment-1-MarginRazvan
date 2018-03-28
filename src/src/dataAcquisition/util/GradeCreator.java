package dataAcquisition.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Grade;

public class GradeCreator {

	public List<Grade> createGrades(ResultSet resultSet) {
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
