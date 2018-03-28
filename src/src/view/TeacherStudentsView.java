package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

public class TeacherStudentsView extends JFrame {

	private JTable table;
	private Object[][] data;
	private JButton btnBack;
	
	
	public TeacherStudentsView(Object[][] data) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 454, 531);
		setTitle("Students");
		getContentPane().setLayout(null);
		
		this.data=data;
		String[] columnNames = {"Student_id","Student_name","Grade"};
		
		table = new JTable(data,columnNames);
		table.setFillsViewportHeight(true);
		table.setBounds(0, 49, 438, 443);
		getContentPane().add(table);
		
		btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnBack.setBackground(Color.GRAY);
		btnBack.setBounds(0, 0, 100, 46);
		getContentPane().add(btnBack);
	}
	
	public void addBackButton(ActionListener e)
	{
		btnBack.addActionListener(e);
	}

}
