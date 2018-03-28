package presentationLayer.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class StudentCoursesView extends JFrame {

	private JButton btnBack;
	private JTable table;
	private Object[][] data;
	private JTextField textFieldCourseId;
	private JButton btnEnroll;
	private JButton btnViewGrades;
	private JButton btnViewAllCourses;
	
	
	public StudentCoursesView(Object[][] data) {
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
		String[] columnNames = {"Course_id","Course_name","Teacher"};
		
		table = new JTable(data,columnNames);
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table.setBounds(10, 70, 424, 352);
		getContentPane().add(table);
		
		table.setFillsViewportHeight(true);
		
		JLabel lblCourseid = new JLabel("Course ID");
		lblCourseid.setHorizontalAlignment(SwingConstants.CENTER);
		lblCourseid.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCourseid.setBounds(444, 72, 322, 44);
		getContentPane().add(lblCourseid);
		
		textFieldCourseId = new JTextField();
		textFieldCourseId.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldCourseId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldCourseId.setBounds(563, 127, 86, 37);
		getContentPane().add(textFieldCourseId);
		textFieldCourseId.setColumns(10);
		
		btnEnroll = new JButton("Enroll");
		btnEnroll.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnEnroll.setBounds(523, 175, 165, 44);
		getContentPane().add(btnEnroll);
		
		btnViewGrades = new JButton("View Grades");
		btnViewGrades.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnViewGrades.setBounds(523, 242, 165, 44);
		getContentPane().add(btnViewGrades);
		
		btnViewAllCourses = new JButton("View All Courses");
		btnViewAllCourses.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnViewAllCourses.setBounds(523, 365, 165, 44);
		getContentPane().add(btnViewAllCourses);

	}
	
	
	public void addBackButton(ActionListener e)
	{
		btnBack.addActionListener(e);
	}
	
	public void addEnrollButton(ActionListener e)
	{
		btnEnroll.addActionListener(e);
	}
	
	public void addAllCoursesButton(ActionListener e)
	{
		btnViewAllCourses.addActionListener(e);
	}
	
	public void addViewGradesButton(ActionListener e)
	{
		btnViewGrades.addActionListener(e);
	}
	
	public String getCourseId()
	{
		return textFieldCourseId.getText();
	}
	
	public void showErrorMessage(String text)
	{
		JOptionPane.showMessageDialog(null, text);
	}
}
