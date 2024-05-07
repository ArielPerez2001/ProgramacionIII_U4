package MVC;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class AuthModel {
	private Usuario[] usuarios;
	
	public AuthModel() {
		leerUsuarios();
	}
	
	private void leerUsuarios() {
        try {
            
            File file = new File("src/recursos/usuario.json");

            ObjectMapper objectMapper = new ObjectMapper();

            usuarios = objectMapper.readValue(file, Usuario[].class);
            
        } catch (IOException e) {
        	
            e.printStackTrace();
        }
    }
	
	public boolean loginModel(String username, String password) {
		
		for (Usuario usuario : usuarios) {
			
            if (usuario.getUsername().equals(username) && usuario.getPassword().equals(password)) {
            	
                return true; 
            }
        }
        return false;
    }
}
