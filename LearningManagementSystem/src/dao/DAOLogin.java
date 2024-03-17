package dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DAOLogin {
	
	public void authenticate(String userId, String password) {
		
		try {
			Scanner scanner = new Scanner(new File("data\\user\\login.txt"));
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}

}
