package businessLayer.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import businessLayer.businessLogic.CoursesBLL;
import businessLayer.businessLogic.CoursesBLLInterface;
import businessLayer.businessLogic.ExamBLL;
import businessLayer.businessLogic.ExamBLLInterface;
import businessLayer.businessLogic.GradeBLL;
import businessLayer.businessLogic.GradeBLLInterface;
import businessLayer.businessLogic.StudentBLL;
import businessLayer.businessLogic.StudentBLLInterface;
import businessLayer.businessLogic.TeacherBLL;
import businessLayer.businessLogic.TeacherBLLInterface;
import dataLayer.model.Course;
import dataLayer.model.Exam;
import dataLayer.model.Student;
import presentationLayer.view.AllCoursesView;
import presentationLayer.view.StudentCoursesView;
import presentationLayer.view.StudentGradesExamsView;

public class StudentCoursesController {
	
	
	private StudentCoursesView studentCoursesView;
	private AllCoursesView allCoursesView;
	private StudentGradesExamsView studentGradesExamsView;
	private int id;
	private StudentBLLInterface studentBLL;
	private CoursesBLLInterface coursesBLL;
	private TeacherBLLInterface teacherBLL;
	private ExamBLLInterface examBLL;
	private GradeBLLInterface gradeBLL;
	
	public StudentCoursesController(int id,StudentBLL studentBLL)
	{
		this.coursesBLL=new CoursesBLL();
		this.teacherBLL=new TeacherBLL();
		this.examBLL=new ExamBLL();
		this.gradeBLL=new GradeBLL();
		this.studentBLL = studentBLL;
		this.id=id;
		
		
		ArrayList<Course> courses=coursesBLL.findByStudentId(id);
		Object[][] data = new Object[courses.size()][3];
		
		for (int i=0; i<courses.size();i++)
		{
			data[i][0]=courses.get(i).getCourse_id();
			data[i][1]=courses.get(i).getName();
			data[i][2]=teacherBLL.findById(courses.get(i).getCourse_id()).getName();
		}
		
		this.studentCoursesView = new StudentCoursesView(data);
		this.addBackListener();
		this.addEnrollListener();
		this.addAllCoursesListener();
		this.addGradesExamsListener();
		
		studentCoursesView.setVisible(true);
		
		
		ArrayList<Course> courses1=coursesBLL.findAll();
		Object[][] data1 = new Object[courses1.size()][3];
		
		for (int i=0; i<courses1.size();i++)
		{
			data1[i][0]=courses1.get(i).getCourse_id();
			data1[i][1]=courses1.get(i).getName();
			data1[i][2]=teacherBLL.findById(courses1.get(i).getTeacher_id()).getName();
		}
		
		this.allCoursesView = new AllCoursesView(data1);
		this.addBackListenerView();
		
		
		
		//aici punem data {"Course_name","Teacher","Exam_date","Grade"};
		
		ArrayList<Course> courses2=coursesBLL.findByStudentId(id);
		Object[][] data2 = new Object[courses.size()][4];
		
		for (int i=0; i<courses2.size();i++)
		{
			data2[i][0]=courses2.get(i).getName();
			data2[i][1]=teacherBLL.findById(courses2.get(i).getCourse_id()).getName();
			if (examBLL.findByCourseId(courses2.get(i).getCourse_id())!=null)
			{
				data2[i][2]=examBLL.findByCourseId(courses2.get(i).getCourse_id()).getDate();
			}else
			{
				data2[i][2]="No date";
			}
			
			if (gradeBLL.findByCourseStudentId(courses2.get(i).getCourse_id(), this.id)!=null)
			{
				data2[i][3]=gradeBLL.findByCourseStudentId(courses2.get(i).getCourse_id(), this.id).getGrade();
			}else
			{
				data2[i][3]="Unmarked";
			}
		}
		
		
		this.studentGradesExamsView= new StudentGradesExamsView(data2);
		this.addBackListenerExams();
		
	}
	
	
	
	public void addBackListener()
	{
		studentCoursesView.addBackButton(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				studentCoursesView.setVisible(false);
				StudentController studentController= new StudentController((StudentBLL)studentBLL, id);
				
			}
		});
		
	}
	
	public void addBackListenerView()
	{
		allCoursesView.addBackButton(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				allCoursesView.setVisible(false);
				
			}
		});
	}
	
	public void addBackListenerExams()
	{
		studentGradesExamsView.addBackButton(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				studentGradesExamsView.setVisible(false);
				
			}
		});
	}
	
	public void addEnrollListener()
	{
		studentCoursesView.addEnrollButton(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("asdf");
				if (studentCoursesView.getCourseId().equals(""))
				{
					studentCoursesView.showErrorMessage("Fill the box");
				}
				else
				{
					int course_id = Integer.parseInt(studentCoursesView.getCourseId());
					coursesBLL.enroll(id, course_id);
					
				}
			}
		});
	}
	
	public void addAllCoursesListener()
	{
		studentCoursesView.addAllCoursesButton(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				allCoursesView.setVisible(true);
			}
		});
	}
	
	public void addGradesExamsListener()
	{
		studentCoursesView.addViewGradesButton(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				studentGradesExamsView.setVisible(true);
				
			}
		});
	}

}
