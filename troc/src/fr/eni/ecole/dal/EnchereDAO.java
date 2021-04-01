package fr.eni.ecole.dal;

import java.util.List;

import fr.eni.ecole.bo.Article;
import fr.eni.ecole.bo.Enchere;
import fr.eni.ecole.bo.Utilisateur;

public interface EnchereDAO {

	void insert(Enchere ench);
	Enchere selectByArticle(Article a);
	List<Enchere> selectByUser(Utilisateur util);
	
}
