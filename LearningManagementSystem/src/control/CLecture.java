package control;

import java.util.Vector;

import dao.DAOLecture;
import domain.Path;
import entity.ELecture;

public class CLecture {

	private DAOLecture daoLecture;

	public CLecture() {
		this.daoLecture = new DAOLecture();
	}

	public Vector<ELecture> getItems(String path) {
		return this.daoLecture.getItems(Path.DATA_LECTURE.getPath()+path+".txt");
	}

}
