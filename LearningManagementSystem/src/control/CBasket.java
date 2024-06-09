package control;

import java.util.Vector;

import dao.DAOBasket;
import domain.Path;
import entity.ELecture;

public class CBasket {
	
	private DAOBasket daoBasket;
	
	public CBasket() {
		this.daoBasket = new DAOBasket();
	}
	
	public Vector<ELecture> getItems(String path) {
		return this.daoBasket.getItems(Path.DATA_BASKET.getPath()+path+".txt");
	}
	
}
