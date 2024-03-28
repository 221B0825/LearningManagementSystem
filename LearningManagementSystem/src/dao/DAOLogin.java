package dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DAOLogin {
	
	public boolean authenticate(String inputUserId, String inputPassword) {
		
		try {
			Scanner scanner = new Scanner(new File("data\\user\\login.txt"));
			while(scanner.hasNext()) {
				String userId = scanner.next();
				String userPassword = scanner.next();
				if(userId.equals(inputUserId) &&  userPassword.equals(inputPassword)) {
					return true;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}
}
