package businessLayer.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import businessLayer.businessLogic.StudentBLL;
import businessLayer.businessLogic.StudentBLLInterface;
import dataLayer.model.Student;
import presentationLayer.view.StudentMenuView;

public class StudentController {
	
	private StudentMenuView studentMenuView;
	private StudentBLLInterface studentBLL;
	private Student student;
	
	public StudentController(StudentBLL studentBLL,int id)
	{
		//this.student_id=id;
		this.studentBLL=studentBLL;
		
		this.student= studentBLL.findById(id);
		
		this.studentMenuView=new StudentMenuView();
		
		this.studentMenuView.initializeProfile(student.getName(), student.getEmail(),student.getCnp(), student.getGroup());
		this.addUpdateProfileListener();
		this.addLogoutListener();
		this.addChangePassListener();
		this.addUpdatePassListener();
		this.addViewCoursesListener();
		
		studentMenuView.setVisible(true);
		
	}
	
	
	public void addUpdateProfileListener()
	{
		studentMenuView.addUpdateProfileButton(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				studentBLL.updateProfile(student.getStudent_id(), studentMenuView.getName(), studentMenuView.getEmail(), studentMenuView.getCnp(), studentMenuView.getGroup(), student.getPassword());
				studentMenuView.showErrorMessage("Update has been made");
			}
		});
	}
	
	public void addLogoutListener()
	{
		studentMenuView.addLogOutButton(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				studentMenuView.setVisible(false);
				LoginController controller=new LoginController();		
			}
		});
	}
	
	public void addChangePassListener()
	{
		studentMenuView.addChangePassButton(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				studentMenuView.hideProfile();				
			}
		});
	}
	
	public void addUpdatePassListener()
	{
		studentMenuView.addUpdatePassButton(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Student studentAux= studentBLL.findById(student.getStudent_id());
				studentAux.setPassword(studentMenuView.getPass());
				studentBLL.updateProfile(studentAux.getStudent_id(), studentAux.getName(), studentAux.getEmail(), studentAux.getCnp(), studentAux.getGroup(),studentAux.getPassword() );
				studentMenuView.showErrorMessage("Password changed");
				studentMenuView.showProfile();
				
			}
		});
	}
	
	public void addViewCoursesListener()
	{
		studentMenuView.addViewCoursesButton(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				studentMenuView.setVisible(false);
				StudentCoursesController studentCoursesController=new StudentCoursesController(student.getStudent_id(),(StudentBLL) studentBLL);
				
			}
		});
	}


}
