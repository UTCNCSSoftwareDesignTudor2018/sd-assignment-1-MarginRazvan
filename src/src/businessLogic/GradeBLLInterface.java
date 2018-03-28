package businessLogic;

import model.Grade;

public interface GradeBLLInterface {

	public Grade findByCourseStudentId(int course_id,int student_id);
	
	public void insertGrade(Grade grade);
	
	public void updateGrade(Grade grade);
	
}
