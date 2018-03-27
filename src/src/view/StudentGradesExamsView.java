package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.Color;

public class StudentGradesExamsView extends JFrame {
	private JTable table;
	private JButton btnBack;
	private Object[][] data;


	public StudentGradesExamsView(Object[][] data) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 487, 519);
		setTitle("Grades&Exams");
		getContentPane().setLayout(null);
		
		this.data=data;
		String[] columnNames = {"Course_name","Teacher","Exam_date","Grade"};
		
		table = new JTable(data,columnNames);
		table.setBounds(0, 49, 471, 431);
		getContentPane().add(table);
		
		btnBack = new JButton("Back");
		btnBack.setBackground(Color.GRAY);
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnBack.setBounds(0, 0, 107, 48);
		getContentPane().add(btnBack);

	}
	
	public void addBackButton(ActionListener e)
	{
		btnBack.addActionListener(e);
	}

}
