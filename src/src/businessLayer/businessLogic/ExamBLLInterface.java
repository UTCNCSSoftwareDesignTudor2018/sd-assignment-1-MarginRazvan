package businessLayer.businessLogic;

import dataLayer.model.Exam;

public interface ExamBLLInterface {
	
	public Exam findByCourseId(int id);
	
	public void insertExam(Exam exam);
	
	public void updateExam(Exam exam);

}
