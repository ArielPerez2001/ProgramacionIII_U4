package MVC;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Usuario {
	@JsonProperty("usuario")
    private String username;
	@JsonProperty("contraseña")
    private String password;

    public Usuario() {
        
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}