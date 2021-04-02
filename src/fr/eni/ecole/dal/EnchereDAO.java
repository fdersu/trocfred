package fr.eni.ecole.dal;

import java.util.List;

import fr.eni.ecole.bo.Article;
import fr.eni.ecole.bo.Enchere;
import fr.eni.ecole.bo.Utilisateur;

public interface EnchereDAO extends CRUD<Enchere> {

	
	List<Enchere> selectByArticle(Article a);
	List<Enchere> selectByUser(Utilisateur util);
	void insert(Enchere item);
	List<Enchere> selectAll();
	Enchere selectById(int id);
	void update(Enchere item);
	void delete(Enchere item);
	
}
