package entity;


public class Log {

	private String user;
	private String password;
	private String usuario;
	private String cargo;
	private Integer type;
	
	
	public Log() {
		super();
	}

	public Log(String user, String password, String usuario, String cargo, Integer type) {
		this.setUser(user);
		this.setPassword(password);
		this.setUsuario(usuario);
		this.setCargo(cargo);
		this.setType(type);
	}

	//getters  setters
	public String getUser() {
		return user;
	}
	public String getPassword() {
		return password;
	}
	public String getUsuario() {
		return usuario;
	}
	public String getCargo() {
		return cargo;
	}
	public Integer getType() {
		return type;
	}

	public void setUser(String user) {
		this.user = user;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public void setType(Integer type) {
		this.type = type;
	}
}
