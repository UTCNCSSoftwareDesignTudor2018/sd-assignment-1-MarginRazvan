package businessLayer.businessLogic;

import dataLayer.model.Teacher;

public interface TeacherBLLInterface {
	
	public Teacher findById(int id);
	
	public boolean login(String email, String password);
	
	public Teacher findByEmail(String email);
	
	public void updateProfile(int id,String name,String email,String password);
	
	

}
