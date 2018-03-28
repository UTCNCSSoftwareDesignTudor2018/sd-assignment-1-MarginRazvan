package presentationLayer.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

public class AllCoursesView extends JFrame {
	private JTable table;
	private Object[][] data;
	private JButton btnBack;

	public AllCoursesView(Object[][] data) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 454, 531);
		setTitle("All Courses");
		getContentPane().setLayout(null);
		
		this.data=data;
		String[] columnNames = {"Course_id","Course_name","Teacher"};
		
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
