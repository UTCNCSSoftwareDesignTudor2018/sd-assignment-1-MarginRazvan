package businessLayer.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import businessLayer.businessLogic.StudentBLL;
import businessLayer.businessLogic.TeacherBLL;
import businessLayer.businessLogic.TeacherBLLInterface;
import dataLayer.model.Student;
import dataLayer.model.Teacher;
import presentationLayer.view.StudentMenuView;
import presentationLayer.view.TeacherMenuView;

public class TeacherController {
	
	private TeacherMenuView teacherMenuView;
	private TeacherBLLInterface teacherBLL;
	private Teacher teacher;
	
	public TeacherController(TeacherBLL teacherBLL,int id)
	{
		this.teacherBLL=teacherBLL;
		
		this.teacher= teacherBLL.findById(id);
		
		this.teacherMenuView=new TeacherMenuView();
		
		this.teacherMenuView.initializeProfile(teacher.getName(),teacher.getEmail());
		this.addUpdateProfileListener();
		this.addLogoutListener();
		this.addChangePassListener();
		this.addUpdatePassListener();
		this.addViewCoursesListener();
		teacherMenuView.setVisible(true);
		
	}
	
	
	public void addUpdateProfileListener()
	{
		teacherMenuView.addUpdateProfileButton(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				teacherBLL.updateProfile(teacher.getTeacher_id(), teacherMenuView.getName(), teacherMenuView.getEmail(), teacher.getPassword());
				teacherMenuView.showErrorMessage("Update has been made");
			}
		});
	}
	
	public void addLogoutListener()
	{
		teacherMenuView.addLogOutButton(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				teacherMenuView.setVisible(false);
				LoginController controller=new LoginController();		
			}
		});
	}
	
	public void addChangePassListener()
	{
		teacherMenuView.addChangePassButton(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				teacherMenuView.hideProfile();				
			}
		});
	}
	
	public void addUpdatePassListener()
	{
		teacherMenuView.addUpdatePassButton(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Teacher teacherAux= teacherBLL.findById(teacher.getTeacher_id());
				teacherAux.setPassword(teacherMenuView.getPass());
				teacherBLL.updateProfile(teacherAux.getTeacher_id(), teacherAux.getName(), teacherAux.getEmail(),teacherAux.getPassword() );
				teacherMenuView.showErrorMessage("Password changed");
				teacherMenuView.showProfile();
				
			}
		});
	}
	
	public void addViewCoursesListener()
	{
		teacherMenuView.addViewCoursesButton(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				teacherMenuView.setVisible(false);
				TeacherCoursesController teacherCoursesController = new TeacherCoursesController(teacher.getTeacher_id(),(TeacherBLL) teacherBLL);

				
			}
		});
	}

}
