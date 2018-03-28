package dataAcquisition.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Course;

public class CourseCreator {
	
	public List<Course> createCourses(ResultSet resultSet) {
		List<Course> list = new ArrayList<Course>();

			try {
				while (resultSet.next()) {
					Course instance = new Course();
					instance.setCourse_id(resultSet.getInt("course_id"));
					instance.setName(resultSet.getString("name"));
					instance.setTeacher_id(resultSet.getInt("teacher_id"));
					list.add(instance);
					
					}
			} catch (SQLException e) {

				e.printStackTrace();
			}				

			
		return list;
	}

}
