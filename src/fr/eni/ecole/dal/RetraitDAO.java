package fr.eni.ecole.dal;


import java.util.List;

import fr.eni.ecole.bo.Article;
import fr.eni.ecole.bo.Retrait;


public interface RetraitDAO extends CRUD<Retrait> {
	
	
	Retrait selectByArticle(Article a);
	void insert(Retrait item);
	List<Retrait> selectAll();
	Retrait selectById(int id);
	void update(Retrait item);
	void delete(Retrait item);

}
