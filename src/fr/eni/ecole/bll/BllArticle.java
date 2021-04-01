package fr.eni.ecole.bll;

import java.util.List;

import fr.eni.ecole.bo.Article;
import fr.eni.ecole.bo.Utilisateur;
import fr.eni.ecole.dal.ArticleDAO;
import fr.eni.ecole.dal.DAOFactory;

public class BllArticle {
	
	private static BllArticle instance;
	private static ArticleDAO article;
	
	private BllArticle() {
		article = DAOFactory.getArticleDAO();
	}
	
	public static BllArticle getBllArticle() {
		if(instance == null) {
			instance = new BllArticle();
		}
		return instance;
	}
	
	public void insert(Article a) {
		article.insert(a);
	}
	
	public void update(Article a) {
		article.update(a);
	}
	
	public void delete(Article a) {
		article.delete(a);
	}
	
	public Article selectById(int id) {
		return article.selectById(id);
	}
	
	public List<Article> selectByUser(Utilisateur utilisateur){
		return article.selectByUser(utilisateur);
	}
}
