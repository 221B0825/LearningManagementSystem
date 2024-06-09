package control;

import java.util.Vector;

import dao.DAODirectory;
import domain.Path;
import entity.EDirectory;

public class CDirectory {

	private DAODirectory daoDirectory;
	
	public CDirectory() {
		this.daoDirectory = new DAODirectory();
	}
	
	public Vector<EDirectory> getItems(String path) {
		return this.daoDirectory.getItems(Path.DATA_LECTURE.getPath()+path+".txt");
	}
	

}
