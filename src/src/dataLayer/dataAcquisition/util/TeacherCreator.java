package dataLayer.dataAcquisition.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dataLayer.model.Teacher;

public class TeacherCreator {
	
	public List<Teacher> createTeachers(ResultSet resultSet) {
		List<Teacher> list = new ArrayList<Teacher>();

			try {
				while (resultSet.next()) {
					Teacher instance = new Teacher();
					instance.setName(resultSet.getString("name"));
					instance.setEmail(resultSet.getString("email"));
					instance.setPassword(resultSet.getString("password"));
					instance.setTeacher_id(resultSet.getInt("teacher_id"));
					
					list.add(instance);
					
					}
			} catch (SQLException e) {

				e.printStackTrace();
			}				

			
		return list;
	}

}
