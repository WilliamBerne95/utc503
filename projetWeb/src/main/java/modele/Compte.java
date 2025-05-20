package modele;

import java.io.Serializable;

public class Compte implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private int id;
    private String login;
    private String password;
    private String role;
    
    // Constructeur par défaut requis pour JavaBean
    public Compte() {
    }
    
    public Compte(int id, String login, String password, String role) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.role = role;
    }
    
    // Getters et Setters
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getLogin() {
        return login;
    }
    
    public void setLogin(String login) {
        this.login = login;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getRole() {
        return role;
    }
    
    public void setRole(String role) {
        this.role = role;
    }
}