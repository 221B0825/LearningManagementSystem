package dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DAOLogin {
	
	public String authenticate(String inputUserId, String inputPassword) {
		
		try {
			Scanner scanner = new Scanner(new File("data\\user\\login.txt"));
			while(scanner.hasNext()) {
				String userId = scanner.next();
				String password = scanner.next();
				if(inputUserId.equals(userId) && inputPassword.equals(password)) {
					return inputUserId;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		//User Not Founded
		return null;
		
	}

}
