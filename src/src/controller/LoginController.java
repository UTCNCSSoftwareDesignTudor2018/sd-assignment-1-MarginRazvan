package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import businessLogic.StudentBLL;
import model.Student;
import view.LoginView;
import view.StudentMenuView;

public class LoginController {
	
	private LoginView loginView;
	private StudentBLL studentBLL;
	
	public LoginController()
	{
		this.studentBLL = new StudentBLL();
		this.loginView=new LoginView();
		loginView.setVisible(true);
		this.addStudentLoginListener();
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
	
	

}
