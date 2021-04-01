package fr.eni.ecole.bll;


import java.util.List;

import fr.eni.ecole.bo.Article;
import fr.eni.ecole.bo.Enchere;
import fr.eni.ecole.bo.Utilisateur;
import fr.eni.ecole.dal.DAOFactory;
import fr.eni.ecole.dal.EnchereDAO;

public class BllEnchere {

	private static BllEnchere instance;
	private static EnchereDAO enchere;
	
	private BllEnchere() {
		enchere = DAOFactory.getEnchereDAO();
	}
	
	public static BllEnchere getBllEnchere() {
		if(instance == null) {
			instance = new BllEnchere();
		}
		return instance;
	}
	
	public void insert(Enchere item) {
		enchere.insert(item);
	}
	
	public Enchere selectByArticle(Article a) {
		return enchere.selectByArticle(a);
	}
	
	public List<Enchere> selectByUser(Utilisateur util){
		return enchere.selectByUser(util);
	}
	
	
}
