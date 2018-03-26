package model;

public class Student {
	
	private int student_id;
	private String name;
	private String email;
	private String cnp;
	private int student_group;
	private String password;
	
	
	
	public Student(String name,String email, String cnp, int group,String password)
	{
		this.cnp=cnp;
		this.email=email;
		this.name=name;
		this.student_group=group;
		this.password=password;
		
	}



	public Student() {
		// TODO Auto-generated constructor stub
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public int getStudent_id() {
		return student_id;
	}



	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getCnp() {
		return cnp;
	}



	public void setCnp(String cnp) {
		this.cnp = cnp;
	}



	public int getGroup() {
		return student_group;
	}



	public void setGroup(int group) {
		this.student_group = group;
	}



	@Override
	public String toString() {
		return "Student [student_id=" + student_id + ", name=" + name + ", email=" + email + ", cnp=" + cnp + ", group="
				+ student_group + ", password=" + password + "]";
	}

	
	
}
