package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class StudentCoursesView extends JFrame {

	JButton btnBack;
	private JTable table;
	
	
	public StudentCoursesView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 792, 472);
		setTitle("Courses");
		getContentPane().setLayout(null);
		
		btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnBack.setBackground(Color.GRAY);
		btnBack.setBounds(0, 0, 140, 59);
		getContentPane().add(btnBack);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table.setBounds(10, 70, 424, 352);
		getContentPane().add(table);

	}
	
	
	public void addBackButton(ActionListener e)
	{
		btnBack.addActionListener(e);
	}
}
