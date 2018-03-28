package dataLayer.dataAcquisition;

import dataLayer.model.Exam;

public interface ExamDAOInterface {
	
	public Exam findById(int course_id);
	
	public void insertExam(Exam exam);
	
	

}
