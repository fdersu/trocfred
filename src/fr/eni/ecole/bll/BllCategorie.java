package fr.eni.ecole.bll;


import java.util.List;

import fr.eni.ecole.bo.Categorie;
import fr.eni.ecole.dal.CategorieDAO;
import fr.eni.ecole.dal.DAOFactory;

public class BllCategorie {
	
	private static BllCategorie instance;
	private static CategorieDAO categorie;
	
	private BllCategorie() {
		categorie = DAOFactory.getCategorieDAO();
	}
	
	public static BllCategorie getBllCategorie() {
		if(instance == null) {
			instance = new BllCategorie();
		}
		return instance;
	}
	
	public List<Categorie> selectAll(){
		return categorie.selectAll();
	}
	
	public Categorie selectByName(String nom) {
		return categorie.selectByName(nom);
	}
	
	public Categorie selectById(int id) {
		return categorie.selectById(id);
	}
	
	
}
