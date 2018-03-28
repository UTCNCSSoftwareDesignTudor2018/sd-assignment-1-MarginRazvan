package businessLayer.businessLogic;

import dataLayer.dataAcquisition.GradeDAO;
import dataLayer.dataAcquisition.GradeDAOInterface;
import dataLayer.model.Exam;
import dataLayer.model.Grade;

public class GradeBLL implements GradeBLLInterface{
	
	private GradeDAOInterface gradeDAO;
	
	public GradeBLL()
	{
		this.gradeDAO=new GradeDAO();
	}
	
	
	public Grade findByCourseStudentId(int course_id,int student_id)
	{
		Grade grade=gradeDAO.findById(course_id,student_id);
		
		if (grade!=null)
		{
			return grade;
		}else
			return null;
	}
	
	public void insertGrade(Grade grade)
	{
		gradeDAO.insertGrade(grade);
	}
	
	public void updateGrade(Grade grade)
	{
		gradeDAO.updateGrade(grade);
	}

}
