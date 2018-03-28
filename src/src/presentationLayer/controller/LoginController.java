package presentationLayer.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import businessLayer.businessLogic.StudentBLL;
import businessLayer.businessLogic.StudentBLLInterface;
import businessLayer.businessLogic.TeacherBLL;
import businessLayer.businessLogic.TeacherBLLInterface;
import dataLayer.model.Student;
import dataLayer.model.Teacher;
import presentationLayer.view.LoginView;
import presentationLayer.view.StudentMenuView;

public class LoginController {
	
	private LoginView loginView;
	private StudentBLLInterface studentBLL;
	private TeacherBLLInterface teacherBLL;
	
	public LoginController()
	{
		this.studentBLL = new StudentBLL();
		this.teacherBLL = new TeacherBLL();
		this.loginView=new LoginView();
		loginView.setVisible(true);
		this.addStudentLoginListener();
		this.addTeacherLoginListener();
	}
	
	
	
	
	
	
	private void addStudentLoginListener()
	{
		loginView.addLoginStudentButton(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String email=loginView.getEmail();
				String pass=loginView.getPassword();
				
				if (studentBLL.login(email, pass))
				{
					Student student=studentBLL.findByEmail(email);
					loginView.setVisible(false);
					StudentController studentController= new StudentController((StudentBLL)studentBLL, student.getStudent_id());
					System.out.println("OK");
				}
				else
				{
					loginView.showErrorMessage("Incorrect data inserted");
				}
				
			}
		});
	}
	
	private void addTeacherLoginListener()
	{
		loginView.addLoginTeacherButton(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String email=loginView.getEmail();
				String pass=loginView.getPassword();
				
				if (teacherBLL.login(email, pass))
				{
					Teacher teacher=teacherBLL.findByEmail(email);
					loginView.setVisible(false);
					TeacherController teacherController= new TeacherController((TeacherBLL)teacherBLL, teacher.getTeacher_id());
					System.out.println("OK");
				}
				else
				{
					loginView.showErrorMessage("Incorrect data inserted");
				}
				
			}
		});
	}
	
	
	
	

}
