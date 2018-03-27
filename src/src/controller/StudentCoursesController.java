package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import businessLogic.StudentBLL;
import model.Student;
import view.StudentCoursesView;

public class StudentCoursesController {
	
	
	private StudentCoursesView studentCoursesView;
	private int id;
	private StudentBLL studentBLL;
	
	public StudentCoursesController(int id,StudentBLL studentBLL)
	{
		this.studentBLL = studentBLL;
		this.id=id;
		this.studentCoursesView = new StudentCoursesView();
		this.addBackListener();
		
		studentCoursesView.setVisible(true);
		
	}
	
	
	
	public void addBackListener()
	{
		studentCoursesView.addBackButton(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				studentCoursesView.setVisible(false);
				StudentController studentController= new StudentController(studentBLL, id);
				
			}
		});
	}

}
