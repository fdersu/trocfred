package fr.eni.ecole.dal;


import fr.eni.ecole.bo.Article;
import fr.eni.ecole.bo.Retrait;


public interface RetraitDAO {
	
	void insert(Retrait r);
	Retrait selectByArticle(Article a);

}
