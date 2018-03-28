package businessLayer.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import dataLayer.model.Grade;
import dataLayer.model.Student;
import presentationLayer.view.TeacherCoursesView;
import presentationLayer.view.TeacherStudentsView;

public class TeacherCoursesController {

	
	private int id;
	private TeacherBLLInterface teacherBLL;
	private CoursesBLLInterface coursesBLL;
	private StudentBLLInterface studentBLL;
	private GradeBLLInterface gradeBLL;
	private ExamBLLInterface examBLL;
	
	private TeacherCoursesView teacherCoursesView ;
	private TeacherStudentsView teacherStudentsView;

	public TeacherCoursesController(int id,TeacherBLL teacherBLL)
	{
		this.id=id;
		this.teacherBLL=teacherBLL;
		this.coursesBLL=new CoursesBLL();
		this.studentBLL=new StudentBLL();
		this.examBLL=new ExamBLL();
		this.gradeBLL=new GradeBLL();
		
		
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
		this.addsetStudentGradeListener();
		this.addUnenrollListener();
		this.addGenReportListener();
		
		

		
		
		
		teacherCoursesView.setVisible(true);
		
		
	}
	
	private void setDataStudentsView()
	{
		int course_id = Integer.parseInt(teacherCoursesView.getCourseId());
		//{"Student_id","Student_name","Grade"};
		ArrayList<Student> students = studentBLL.findByCourseId(course_id); 
		
				
		Object[][] data1 = new Object[students.size()][3];
		
		for (int i=0; i<students.size();i++)
		{
			data1[i][0]=students.get(i).getStudent_id();
			data1[i][1]=students.get(i).getName();
			
			if (gradeBLL.findByCourseStudentId(course_id, students.get(i).getStudent_id())!=null)
			{
				data1[i][2]=gradeBLL.findByCourseStudentId(course_id,  students.get(i).getStudent_id()).getGrade();
			}
			else
			{
				data1[i][2]="Unmarked";
			}
		}
		
		teacherStudentsView= new TeacherStudentsView(data1);
		this.addBackListenerStudents();
	}
	
	public void addBackListener()
	{
		teacherCoursesView.addBackButton(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				teacherCoursesView.setVisible(false);
				TeacherController teacherController= new TeacherController((TeacherBLL)teacherBLL, id);
				
			}
		});
		
	}
	
	public void addUnenrollListener()
	{
		teacherCoursesView.addUnenrollButton(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			if (teacherCoursesView.getStudentId().equals("")||teacherCoursesView.getCourseId().equals(""))
			{
				teacherCoursesView.showErrorMessage("Fill boxes");
			}
			else
			{
				int course_id =Integer.parseInt( teacherCoursesView.getCourseId());
				int student_id = Integer.parseInt(teacherCoursesView.getStudentId());
				
				coursesBLL.unEnroll(student_id, course_id);
				teacherCoursesView.showErrorMessage("Student Unenrolled");
			}
				
			}
		});
	}
	
	public void addGenReportListener()
	{
		teacherCoursesView.addGenReportButton(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (teacherCoursesView.getStudentId().equals(""))
				{
					teacherCoursesView.showErrorMessage("Fill box");
				}
				else
				{
					int student_id = Integer.parseInt(teacherCoursesView.getStudentId());
					
					System.out.println("Student Profile: \n");
					System.out.println(studentBLL.findById(student_id).toString()+ "\n");
					System.out.println("Enrollments\n");
					
					ArrayList<Course> courses = coursesBLL.findByStudentId(student_id);
					for (int i=0;i<courses.size();i++)
					{
						System.out.println(courses.get(i).toString()+"\n");
					}
					
					System.out.println("Grades \n");
					
					for (int i=0;i<courses.size();i++)
					{
						System.out.println(gradeBLL.findByCourseStudentId(courses.get(i).getCourse_id(), student_id).toString());
					}
					
				}
				
				
			}
		});
	}
	
	public void addBackListenerStudents()
	{
		teacherStudentsView.addBackButton(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				teacherStudentsView.setVisible(false);
				
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
				
				if (teacherCoursesView.getCourseId().equals(""))
				{
					teacherCoursesView.showErrorMessage("Fill course_id");
					
				}
				else
				{
					setDataStudentsView();
					teacherStudentsView.setVisible(true);
				}
			}
		});
	}
	
	public void addsetStudentGradeListener()
	{
		teacherCoursesView.addSetGradeButton(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (teacherCoursesView.getGrade().equals("")||teacherCoursesView.getCourseId().equals("")||teacherCoursesView.getStudentId().equals(""))
				{
					teacherCoursesView.showErrorMessage("Fill all the fields");
				}
				else
				{
					int course_id = Integer.parseInt(teacherCoursesView.getCourseId());
					int grade = Integer.parseInt(teacherCoursesView.getGrade());
					int student_id = Integer.parseInt(teacherCoursesView.getStudentId());
					if (gradeBLL.findByCourseStudentId(course_id, student_id)!=null)
					{
						Grade gradeObj = new Grade(grade,course_id,student_id);
						gradeBLL.updateGrade(gradeObj);
					}
					else
					{
						Grade gradeObj= new Grade(grade,course_id,student_id);
						gradeBLL.insertGrade(gradeObj);
					}
					teacherCoursesView.showErrorMessage("Grade Updated for Student");
				}
				
			}
		});
	}
	
}
