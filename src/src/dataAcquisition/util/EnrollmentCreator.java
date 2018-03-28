package dataAcquisition.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Enrollment;

public class EnrollmentCreator {

	public List<Enrollment> createEnrollments(ResultSet resultSet) {
		List<Enrollment> list = new ArrayList<Enrollment>();

			try {
				while (resultSet.next()) {
					Enrollment instance = new Enrollment();
					instance.setCourse_id(resultSet.getInt("course_id"));
					instance.setStudent_id(resultSet.getInt("student_id"));
					list.add(instance);
					
					}
			} catch (SQLException e) {

				e.printStackTrace();
			}				

			
		return list;
	}
}
