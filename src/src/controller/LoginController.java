package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import businessLogic.StudentBLL;
import businessLogic.TeacherBLL;
import model.Student;
import model.Teacher;
import view.LoginView;
import view.StudentMenuView;

public class LoginController {
	
	private LoginView loginView;
	private StudentBLL studentBLL;
	private TeacherBLL teacherBLL;
	
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
					StudentController studentController= new StudentController(studentBLL, student.getStudent_id());
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
					TeacherController teacherController= new TeacherController(teacherBLL, teacher.getTeacher_id());
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
