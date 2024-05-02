package MVC;

public class AuthModel {
	
	public AuthModel() {
		
		
	}
	
	public boolean loginModel(String username, String password) {
		
		if(username.equals("Admin") && password.equals("123")) {
			return true;
		}
		
		return false;
	}
}
