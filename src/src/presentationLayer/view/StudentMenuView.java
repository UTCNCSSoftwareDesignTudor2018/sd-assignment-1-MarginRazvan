package presentationLayer.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class StudentMenuView extends JFrame {

	private JLabel lblProfile;
	private JLabel lblName;
	private JLabel labelEmail;
	private JLabel labelcnp;
	private JLabel labelGroup;
	private JTextField textFieldName;
	private JTextField textFieldEmail;
	private JTextField textFieldCnp;
	private JTextField textFieldGroup;
	private JButton btnUpdateInfo;
	private JButton buttonLogOut;
	private JButton buttonChangePass;
	private JTextField textFieldPass;
	private JLabel labelPass;
	private JButton btnUpdatePassword;
	private JButton buttonViewCourses;
	
	public StudentMenuView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 830, 464);
		getContentPane().setLayout(null);
		
		this.setTitle("Student Menu");
		
		lblProfile = new JLabel("Profile");
		lblProfile.setHorizontalAlignment(SwingConstants.CENTER);
		lblProfile.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblProfile.setBounds(10, 46, 794, 54);
		getContentPane().add(lblProfile);
		
		lblName = new JLabel("Name: ");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblName.setBounds(271, 111, 61, 33);
		getContentPane().add(lblName);
		
		labelEmail = new JLabel("Email: ");
		labelEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelEmail.setBounds(271, 166, 61, 33);
		getContentPane().add(labelEmail);
		
		labelcnp = new JLabel("CNP: ");
		labelcnp.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelcnp.setBounds(271, 224, 61, 33);
		getContentPane().add(labelcnp);
		
		labelGroup = new JLabel("Group: ");
		labelGroup.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelGroup.setBounds(271, 293, 61, 33);
		getContentPane().add(labelGroup);
		
		textFieldName = new JTextField();
		textFieldName.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldName.setBounds(369, 117, 226, 25);
		getContentPane().add(textFieldName);
		textFieldName.setColumns(10);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(369, 170, 226, 25);
		getContentPane().add(textFieldEmail);
		
		textFieldCnp = new JTextField();
		textFieldCnp.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldCnp.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldCnp.setColumns(10);
		textFieldCnp.setBounds(369, 232, 226, 25);
		getContentPane().add(textFieldCnp);
		
		textFieldGroup = new JTextField();
		textFieldGroup.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldGroup.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldGroup.setColumns(10);
		textFieldGroup.setBounds(369, 301, 226, 25);
		getContentPane().add(textFieldGroup);
		
		btnUpdateInfo = new JButton("Update Profile");
		btnUpdateInfo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnUpdateInfo.setBounds(20, 111, 196, 33);
		getContentPane().add(btnUpdateInfo);
		
		buttonLogOut = new JButton("Logout");
		buttonLogOut.setBackground(Color.GRAY);
		buttonLogOut.setFont(new Font("Tahoma", Font.BOLD, 15));
		buttonLogOut.setBounds(0, 0, 150, 45);
		getContentPane().add(buttonLogOut);
		
		buttonChangePass = new JButton("Change Password");
		buttonChangePass.setFont(new Font("Tahoma", Font.PLAIN, 15));
		buttonChangePass.setBounds(20, 173, 196, 33);
		getContentPane().add(buttonChangePass);
		
		buttonViewCourses = new JButton("View Enrollments");
		buttonViewCourses.setFont(new Font("Tahoma", Font.PLAIN, 15));
		buttonViewCourses.setBounds(20, 235, 196, 33);
		getContentPane().add(buttonViewCourses);
		
		//for changing pass
		textFieldPass = new JTextField();
		textFieldPass.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldPass.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldPass.setColumns(10);
		textFieldPass.setBounds(369, 196, 226, 25);
		getContentPane().add(textFieldPass);
		textFieldPass.setVisible(false);
		
		labelPass = new JLabel("Pass:");
		labelPass.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelPass.setBounds(271, 192, 61, 33);
		getContentPane().add(labelPass);
		labelPass.setVisible(false);
		
		btnUpdatePassword = new JButton("Update");
		btnUpdatePassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnUpdatePassword.setBounds(379, 268, 196, 33);
		getContentPane().add(btnUpdatePassword);
		btnUpdatePassword.setEnabled(false);
		btnUpdatePassword.setVisible(false);
		

		
	}
	
	
	public void initializeProfile(String name,String email,String cnp,int group)
	{
		textFieldName.setText(name);
		
		textFieldEmail.setText(email);
		
		textFieldCnp.setText(cnp);
		
		textFieldGroup.setText(Integer.toString(group));

	}
	
	public void hideProfile()
	{
		textFieldName.setVisible(false);
		textFieldEmail.setVisible(false);
		textFieldCnp.setVisible(false);
		textFieldGroup.setVisible(false);
		btnUpdateInfo.setVisible(false);
		buttonChangePass.setVisible(false);
		lblName.setVisible(false);
		labelcnp.setVisible(false);
		labelEmail.setVisible(false);
		labelGroup.setVisible(false);
		buttonViewCourses.setVisible(false);
		buttonViewCourses.setEnabled(false);
		
		
		textFieldPass.setVisible(true);
		labelPass.setVisible(true);
		btnUpdatePassword.setVisible(true);
		btnUpdatePassword.setEnabled(true);
		
	}
	
	public void showProfile()
	{
		textFieldName.setVisible(true);
		textFieldEmail.setVisible(true);
		textFieldCnp.setVisible(true);
		textFieldGroup.setVisible(true);
		btnUpdateInfo.setVisible(true);
		buttonChangePass.setVisible(true);
		lblName.setVisible(true);
		labelcnp.setVisible(true);
		labelEmail.setVisible(true);
		labelGroup.setVisible(true);
		buttonViewCourses.setVisible(true);
		buttonViewCourses.setEnabled(true);
		
		
		textFieldPass.setVisible(false);
		labelPass.setVisible(false);
		btnUpdatePassword.setVisible(false);
		btnUpdatePassword.setEnabled(false);
	}
	
	public void addUpdateProfileButton(ActionListener e)
	{
		btnUpdateInfo.addActionListener(e);
	}
	
	public void addLogOutButton(ActionListener e)
	{
		buttonLogOut.addActionListener(e);
	}
	
	public void addChangePassButton(ActionListener e)
	{
		buttonChangePass.addActionListener(e);
	}
	
	public void addUpdatePassButton(ActionListener e)
	{
		btnUpdatePassword.addActionListener(e);
	}
	
	public void addViewCoursesButton(ActionListener e)
	{
		buttonViewCourses.addActionListener(e);
	}
	
	
	public String getName()
	{
		return textFieldName.getText();
	}
	
	public String getEmail()
	{
		return textFieldEmail.getText();
	}
	
	public String getCnp()
	{
		return textFieldCnp.getText();
	}
	
	public int getGroup()
	{
		return Integer.parseInt(textFieldGroup.getText());
	}
	
	public String getPass()
	{
		return textFieldPass.getText();
	}
	
	public void showErrorMessage(String text)
	{
		JOptionPane.showMessageDialog(null, text);
	}
	

}
