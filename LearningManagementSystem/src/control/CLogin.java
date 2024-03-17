package control;

import dao.DAOLogin;

public class CLogin {

	private DAOLogin daoLogin;
	
	public CLogin() {
		this.daoLogin = new DAOLogin();
	}
	
	public boolean authenticate(String userId, String password) {
		this.daoLogin.authenticate(userId, password);
		
		return false;
	}

}
