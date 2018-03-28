package businessLogic;

import dataAcquisition.GradeDAO;
import model.Exam;
import model.Grade;

public class GradeBLL {
	
	private GradeDAO gradeDAO;
	
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

}