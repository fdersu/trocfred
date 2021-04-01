package fr.eni.ecole.dal;

import java.util.List;

import fr.eni.ecole.bo.Article;
import fr.eni.ecole.bo.Utilisateur;

public interface ArticleDAO extends CRUD<Article>{

	void insert(Article a);
	Article selectById(int no);
	List<Article> selectByUser(Utilisateur utilisateur);
}
