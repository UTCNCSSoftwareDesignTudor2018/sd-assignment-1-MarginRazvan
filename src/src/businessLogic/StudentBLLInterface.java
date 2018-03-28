package businessLogic;

import java.util.ArrayList;

import model.Student;

public interface StudentBLLInterface {
	
	public ArrayList<Student> findByCourseId(int id);
	
	public boolean login(String email, String password);
	
	public Student findByEmail(String email);
	
	public Student findById(int id);
	
	public void updateProfile(int id,String name,String email, String cnp, int group,String password);
	
}
