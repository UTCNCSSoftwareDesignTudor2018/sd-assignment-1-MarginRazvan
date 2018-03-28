package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import businessLogic.CoursesBLL;
import businessLogic.ExamBLL;
import businessLogic.StudentBLL;
import businessLogic.TeacherBLL;
import model.Course;
import model.Exam;
import model.Student;
import view.TeacherCoursesView;
import view.TeacherStudentsView;

public class TeacherCoursesController {

	
	private int id;
	private TeacherBLL teacherBLL;
	private CoursesBLL coursesBLL;
	private StudentBLL studentBLL;
	private ExamBLL examBLL;
	
	private TeacherCoursesView teacherCoursesView ;
	private TeacherStudentsView teacherStudentsView;

	public TeacherCoursesController(int id,TeacherBLL teacherBLL)
	{
		this.id=id;
		this.teacherBLL=teacherBLL;
		this.coursesBLL=new CoursesBLL();
		this.studentBLL=new StudentBLL();
		this.examBLL=new ExamBLL();
		
		
		//{"Course_id","Course_name","Exam_Date"};
		ArrayList<Course> courses=coursesBLL.findAllByTeacherId(id);
		
		Object[][] data = new Object[courses.size()][3];
		
		for (int i=0; i<courses.size();i++)
		{
			data[i][0]=courses.get(i).getCourse_id();
			data[i][1]=courses.get(i).getName();
			if (examBLL.findByCourseId(courses.get(i).getCourse_id())!=null)
			{
				data[i][2]=examBLL.findByCourseId(courses.get(i).getCourse_id()).getDate();
			}else
			{
				data[i][2]="No date";
			}
		}
		
		this.teacherCoursesView=new TeacherCoursesView(data);
		this.addBackListener();
		this.addSetExamDateListener();
		this.addViewStudentsListener();
		
		teacherCoursesView.setVisible(true);
		
		
	}
	
	public void addBackListener()
	{
		teacherCoursesView.addBackButton(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				teacherCoursesView.setVisible(false);
				TeacherController teacherController= new TeacherController(teacherBLL, id);
				
			}
		});
		
	}
	
	public void addSetExamDateListener()
	{
		teacherCoursesView.addSetExamDateButton(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String examDate = teacherCoursesView.getDate();
				String course_id= teacherCoursesView.getCourseId();
				
				if (examDate.equals("")||course_id.equals(""))
				{
					teacherCoursesView.showErrorMessage("Please fill boxes");
				}
				else
				{
					SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
					try {
						java.util.Date date= sdf.parse(examDate);
						Date sqlDate = new Date(date.getTime());
						
						Exam exam =new Exam();
						exam.setCourse__id(Integer.parseInt(course_id));
						exam.setDate(sqlDate);
						
						examBLL.updateExamDate(exam);
						
						teacherCoursesView.showErrorMessage("Exam Date Updated");
						
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
					
				}
				
			}
		});
	}
	
	public void addViewStudentsListener()
	{
		teacherCoursesView.addStudentsButton(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int course_id = Integer.parseInt(teacherCoursesView.getCourseId());
				//{"Student_id","Student_name","Grade"};
				ArrayList<Student> students = studentBLL.findByCourseId(course_id); 
				
						
				Object[][] data = new Object[students.size()][2];
				
				for (int i=0; i<students.size();i++)
				{
					data[i][0]=students.get(i).getStudent_id();
					data[i][1]=students.get(i).getName();
//					if (examBLL.findByCourseId(courses.get(i).getCourse_id())!=null)
//					{
//						data[i][2]=examBLL.findByCourseId(courses.get(i).getCourse_id()).getDate();
//					}else
//					{
//						data[i][2]="No date";
//					}
				}
				
				teacherStudentsView= new TeacherStudentsView(data);
				teacherStudentsView.setVisible(true);
			}
		});
	}
	
}
