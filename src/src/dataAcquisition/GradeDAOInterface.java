package dataAcquisition;

import model.Grade;

public interface GradeDAOInterface {

	public Grade findById(int course_id,int student_id);
	
	public void insertGrade(Grade grade);
	
	public void updateGrade(Grade grade);
	
	
}
