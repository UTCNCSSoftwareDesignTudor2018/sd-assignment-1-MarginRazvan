package businessLayer.businessLogic;

import dataLayer.dataAcquisition.ExamDAO;
import dataLayer.dataAcquisition.ExamDAOInterface;
import dataLayer.model.Exam;
import dataLayer.model.Grade;

public class ExamBLL implements ExamBLLInterface {
	
	private ExamDAOInterface examDAO;
	
	public ExamBLL()
	{
		this.examDAO=new ExamDAO();
	}
	
	
	public Exam findByCourseId(int id)
	{
		Exam exam=examDAO.findById(id);
		
		if (exam!=null)
		{
			return exam;
		}else
			return null;
	}
	
	public void insertExam(Exam exam)
	{
		examDAO.insertExam(exam);
	}
	
	public void updateExam(Exam exam)
	{
		examDAO.updateExam(exam);
	}
	
}
