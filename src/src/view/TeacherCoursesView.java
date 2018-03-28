package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class TeacherCoursesView extends JFrame {

	private JButton btnBack;
	private JTable table;
	private Object[][] data;
	private JTextField textFieldCourseId;
	private JLabel labelExam;
	private JTextField textFieldExamDate;
	private JButton btnSetExamDat;
	private JButton btnViewStudents;
	private JLabel lblStudentId;
	private JTextField textFieldStudentId;
	private JButton btnUnEnroll;
	private JButton btnSetGrade;
	private JLabel lblGrade;
	private JTextField textFieldGrade;
	private JButton btnGenReport ;
	
	
	public TeacherCoursesView(Object[][] data) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 792, 472);
		setTitle("Courses");
		getContentPane().setLayout(null);
		this.data=data;
		
		btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnBack.setBackground(Color.GRAY);
		btnBack.setBounds(0, 0, 140, 59);
		getContentPane().add(btnBack);
		
		String[] columnNames = {"Course_id","Course_name","Exam_Date"};
		
		table = new JTable(data,columnNames);
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table.setBounds(10, 70, 424, 352);
		getContentPane().add(table);
		
		table.setFillsViewportHeight(true);
		
		JLabel lblCourseid = new JLabel("Course ID");
		lblCourseid.setHorizontalAlignment(SwingConstants.CENTER);
		lblCourseid.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCourseid.setBounds(444, 27, 163, 44);
		getContentPane().add(lblCourseid);
		
		textFieldCourseId = new JTextField();
		textFieldCourseId.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldCourseId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldCourseId.setBounds(484, 82, 86, 37);
		getContentPane().add(textFieldCourseId);
		textFieldCourseId.setColumns(10);
		
		labelExam = new JLabel("Exam Date");
		labelExam.setHorizontalAlignment(SwingConstants.CENTER);
		labelExam.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelExam.setBounds(603, 27, 163, 44);
		getContentPane().add(labelExam);
		
		textFieldExamDate = new JTextField();
		textFieldExamDate.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldExamDate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldExamDate.setColumns(10);
		textFieldExamDate.setBounds(613, 82, 153, 37);
		getContentPane().add(textFieldExamDate);
		
		btnSetExamDat = new JButton("Set Exam Date");
		btnSetExamDat.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSetExamDat.setBounds(530, 130, 153, 44);
		getContentPane().add(btnSetExamDat);
		
		btnViewStudents = new JButton("View Students");
		btnViewStudents.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnViewStudents.setBounds(530, 185, 153, 44);
		getContentPane().add(btnViewStudents);
		
		lblStudentId = new JLabel("Student Id");
		lblStudentId.setHorizontalAlignment(SwingConstants.CENTER);
		lblStudentId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblStudentId.setBounds(444, 258, 163, 44);
		getContentPane().add(lblStudentId);
		
		textFieldStudentId = new JTextField();
		textFieldStudentId.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldStudentId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldStudentId.setColumns(10);
		textFieldStudentId.setBounds(644, 262, 86, 37);
		getContentPane().add(textFieldStudentId);
		
		btnUnEnroll = new JButton("Unenroll");
		btnUnEnroll.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnUnEnroll.setBounds(454, 371, 153, 44);
		getContentPane().add(btnUnEnroll);
		
		btnSetGrade = new JButton("Set Grade");
		btnSetGrade.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSetGrade.setBounds(613, 371, 153, 44);
		getContentPane().add(btnSetGrade);
		
		lblGrade = new JLabel("Grade");
		lblGrade.setHorizontalAlignment(SwingConstants.CENTER);
		lblGrade.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGrade.setBounds(444, 316, 163, 44);
		getContentPane().add(lblGrade);
		
		textFieldGrade = new JTextField();
		textFieldGrade.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldGrade.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldGrade.setColumns(10);
		textFieldGrade.setBounds(644, 323, 86, 37);
		getContentPane().add(textFieldGrade);
		
		btnGenReport = new JButton("Generate Report");
		btnGenReport.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnGenReport.setBounds(281, 20, 153, 44);
		getContentPane().add(btnGenReport);
		
		
		
	}
	
	public void addBackButton(ActionListener e)
	{
		btnBack.addActionListener(e);
	}
	
	public void addStudentsButton(ActionListener e)
	{
		btnViewStudents.addActionListener(e);
	}
	
	public void addSetExamDateButton(ActionListener e)
	{
		btnSetExamDat.addActionListener(e);
	}
	
	public void addSetGradeButton(ActionListener e)
	{
		btnSetGrade.addActionListener(e);
	}
	
	public void addUnenrollButton(ActionListener e)
	{
		btnUnEnroll.addActionListener(e);
	}
	
	public void addGenReportButton(ActionListener e)
	{
		btnGenReport.addActionListener(e);
	}
	
	public String getCourseId()
	{
		return textFieldCourseId.getText();
	}
	
	public String getDate()
	{
		return textFieldExamDate.getText();
	}
	
	public String getGrade()
	{
		return textFieldGrade.getText();
	}
	
	public String getStudentId()
	{
		return textFieldStudentId.getText();
	}
	
	public void showErrorMessage(String text)
	{
		JOptionPane.showMessageDialog(null, text);
	}
}
