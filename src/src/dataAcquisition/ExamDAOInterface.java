package dataAcquisition;

import model.Exam;

public interface ExamDAOInterface {
	
	public Exam findById(int course_id);
	
	public void insertExam(Exam exam);
	
	

}
