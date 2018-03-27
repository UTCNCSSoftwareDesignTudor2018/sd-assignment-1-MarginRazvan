package businessLogic;

import dataAcquisition.ExamDAO;
import model.Exam;

public class ExamBLL {
	
	private ExamDAO examDAO;
	
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
	
}
