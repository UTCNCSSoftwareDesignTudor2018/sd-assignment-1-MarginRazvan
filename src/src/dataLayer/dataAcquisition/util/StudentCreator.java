package dataLayer.dataAcquisition.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dataLayer.model.Student;

public class StudentCreator {

	public List<Student> createStudents(ResultSet resultSet) {
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
