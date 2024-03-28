package control;

import dao.DAOLogin;

public class CLogin {

	private DAOLogin daoLogin;
	
	public CLogin() {
		this.daoLogin = new DAOLogin();
	}
			
	public String authenticate(String userId, String password) {
		return this.daoLogin.authenticate(userId, password);
	}
}
