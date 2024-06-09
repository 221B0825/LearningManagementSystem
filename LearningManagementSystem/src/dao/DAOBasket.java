package dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

import entity.ELecture;

public class DAOBasket {

	public Vector<ELecture> getItems(String path) {
		Vector<ELecture> items = new Vector<ELecture>();
		
		File file = new File(path);
		
		try {
			Scanner scanner = new Scanner(file);
			while(scanner.hasNext()) {
				ELecture eLecture = new ELecture();
				eLecture.setNumber(scanner.next());
				eLecture.setName(scanner.next());
				eLecture.setProfessorName(scanner.next());
				eLecture.setCredit(scanner.next());
				eLecture.setTime(scanner.next());
				items.add(eLecture);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

}
