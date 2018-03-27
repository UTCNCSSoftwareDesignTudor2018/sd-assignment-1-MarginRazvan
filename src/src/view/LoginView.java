package view;



import javax.swing.JFrame;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;

public class LoginView extends JFrame {
	
	
	private JTextField textFieldUsername;
	private JTextField textFieldPassword;
	private JLabel lblUsername;
	private JLabel lblPassword;
	private JButton btnLoginStudent;
	private JButton buttonLoginTeacher;


	public LoginView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 453, 398);
		getContentPane().setLayout(null);
		
		textFieldUsername = new JTextField();
		textFieldUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldUsername.setBounds(130, 83, 167, 20);
		getContentPane().add(textFieldUsername);
		textFieldUsername.setColumns(10);
		
		lblUsername = new JLabel("Username");
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUsername.setBounds(130, 58, 167, 14);
		getContentPane().add(lblUsername);
		
		lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPassword.setBounds(130, 124, 167, 14);
		getContentPane().add(lblPassword);
		
		textFieldPassword = new JTextField();
		textFieldPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldPassword.setColumns(10);
		textFieldPassword.setBounds(130, 149, 167, 20);
		getContentPane().add(textFieldPassword);
		
		btnLoginStudent = new JButton("Login Student");
		btnLoginStudent.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLoginStudent.setBounds(43, 221, 140, 52);
		getContentPane().add(btnLoginStudent);
		
		JButton buttonLoginTeacher = new JButton("Login Teacher");
		buttonLoginTeacher.setFont(new Font("Tahoma", Font.PLAIN, 15));
		buttonLoginTeacher.setBounds(228, 221, 140, 52);
		getContentPane().add(buttonLoginTeacher);
		
		
	}
	
	public void addLoginStudentButton(ActionListener e)
	{
		btnLoginStudent.addActionListener(e);
	}
	
	public void addLoginTeacherButton(ActionListener e)
	{
		buttonLoginTeacher.addActionListener(e);
	}
	
	public String getEmail()
	{
		return textFieldUsername.getText();
	}
	
	public String getPassword()
	{
		return textFieldPassword.getText();
	}
	public void showErrorMessage(String text)
	{
		JOptionPane.showMessageDialog(null, text);
	}
	

	
}
