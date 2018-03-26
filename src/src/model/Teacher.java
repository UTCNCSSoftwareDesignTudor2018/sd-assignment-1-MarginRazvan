package model;

public class Teacher {
	
	private int teacher_id;
	private String name;
	private String email;
	private String password;
	
	
	
	public Teacher(String name, String email, String password) {
		this.name = name;
		this.email = email;
		this.password = password;
	}
	
	public Teacher() {
		// TODO Auto-generated constructor stub
	}

	public int getTeacher_id() {
		return teacher_id;
	}
	public void setTeacher_id(int teacher_id) {
		this.teacher_id = teacher_id;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	

}
