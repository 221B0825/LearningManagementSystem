package dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

import entity.EDirectory;

public class DAODirectory {

	public Vector<EDirectory> getItems(String path) {
		Vector<EDirectory> items = new Vector<EDirectory>();
		File file = new File(path);
		try {
			Scanner scanner = new Scanner(file);
			while(scanner.hasNext()) {
				EDirectory eDirectory = new EDirectory();
				eDirectory.setNumber(scanner.next());
				eDirectory.setName(scanner.next());
				eDirectory.setHyperLink(scanner.next());
				items.add(eDirectory);
			}
			return items;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
}
