package businessLogic;

import dataAcquisition.ExamDAO;
import dataAcquisition.ExamDAOInterface;
import model.Exam;

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
	
	public void updateExamDate(Exam exam)
	{
		examDAO.insertExam(exam);
	}
	
}
