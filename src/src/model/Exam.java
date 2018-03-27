package model;
import java.sql.Date;

public class Exam {

	private int course__id;
	private Date date;
	
	public Exam(int course__id, Date date) {
		this.course__id = course__id;
		this.date = date;
	}

	public Exam() {
		// TODO Auto-generated constructor stub
	}

	public int getCourse__id() {
		return course__id;
	}

	public void setCourse__id(int course__id) {
		this.course__id = course__id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
}
