package businessLayer.businessLogic;

import dataLayer.model.Exam;

public interface ExamBLLInterface {
	
	public Exam findByCourseId(int id);
	
	public void updateExamDate(Exam exam);

}
