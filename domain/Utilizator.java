package domain;

public class Utilizator {
	String username;
	String parola;
	String tipUtilizator;
	
	public String getTipUtilizator() {
		return tipUtilizator;
	}
	public void setTipUtilizator(String tipUtilizator) {
		this.tipUtilizator = tipUtilizator;
	}
	@Override
	public String toString() {
		return "Utilizator [username=" + username + ", parola=" + parola + "]";
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getParola() {
		return parola;
	}
	public void setParola(String parola) {
		this.parola = parola;
	}
}
