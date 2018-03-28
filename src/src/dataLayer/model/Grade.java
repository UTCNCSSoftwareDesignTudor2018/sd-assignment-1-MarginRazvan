package dataLayer.model;

public class Grade {
	
	private int grade;
	private int course___id;
	private int student___id;
	
	
	
	public Grade(int grade, int course___id, int student___id) {
		this.grade = grade;
		this.course___id = course___id;
		this.student___id = student___id;
	}



	public Grade() {
		// TODO Auto-generated constructor stub
	}



	public int getGrade() {
		return grade;
	}



	public void setGrade(int grade) {
		this.grade = grade;
	}



	public int getCourse___id() {
		return course___id;
	}



	public void setCourse___id(int course___id) {
		this.course___id = course___id;
	}



	public int getStudent___id() {
		return student___id;
	}



	public void setStudent___id(int student___id) {
		this.student___id = student___id;
	}



	@Override
	public String toString() {
		return "Grade [grade=" + grade + ", course___id=" + course___id + ", student___id=" + student___id + "]";
	}
	
	
	
	
}
