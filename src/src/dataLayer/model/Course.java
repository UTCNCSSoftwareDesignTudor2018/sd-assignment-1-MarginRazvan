package dataLayer.model;

public class Course {
	
	private String name;
	private int course_id;
	private int teacher_id;
	
	
	public Course(String name) {
		this.name = name;
	}
	
	
	public Course() {
		// TODO Auto-generated constructor stub
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCourse_id() {
		return course_id;
	}
	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}
	public int getTeacher_id() {
		return teacher_id;
	}
	public void setTeacher_id(int teacher_id) {
		this.teacher_id = teacher_id;
	}


	@Override
	public String toString() {
		return "Course [name=" + name + ", course_id=" + course_id + ", teacher_id=" + teacher_id + "]";
	}
	
	
	
}
