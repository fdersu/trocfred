package fr.eni.ecole.dal;

import fr.eni.ecole.bo.Article;

public interface ArticleDAO {

	void insert(Article a);
	Article selectByNo(int no);
	
}
