package by.htp.bean;

public class User {
	private String login;
	private String password;
	private String Role;
	private int editId;
	

	public User() {
		super();		
	}
	
	public User(String login, String password) {
		super();
		this.login = login;
		this.password = password;
	}
	
	
	
	public String getRole() {
		return Role;
	}

	public void setRole(String role) {
		Role = role;
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
	
	public int getEditId() {
		return editId;
	}

	public void setEditId(int editId) {
		this.editId = editId;
	}
	
	
}
