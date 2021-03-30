package fr.eni.ecole.bll;

import java.util.List;

import fr.eni.ecole.bo.Article;
import fr.eni.ecole.bo.Categorie;
import fr.eni.ecole.bo.Enchere;
import fr.eni.ecole.bo.Retrait;
import fr.eni.ecole.bo.Utilisateur;
import fr.eni.ecole.dal.ArticleDAO;
import fr.eni.ecole.dal.CategorieDAO;
import fr.eni.ecole.dal.DAOFactory;
import fr.eni.ecole.dal.EnchereDAO;
import fr.eni.ecole.dal.RetraitDAO;
import fr.eni.ecole.dal.UtilisateurDAO;

public class Bll {
	
	private static Bll instance;
	private static ArticleDAO article;
	private static CategorieDAO categorie;
	private static EnchereDAO enchere;
	private static RetraitDAO retrait;
	private static UtilisateurDAO utilisateur;
	public Bll() {
		article = DAOFactory.getArticleDAO();
		categorie = DAOFactory.getCategorieDAO();
		enchere = DAOFactory.getEnchereDAO();
		retrait = DAOFactory.getRetraitDAO();
		utilisateur = DAOFactory.getUtilisateurDAO();
	}
	
	public static Bll getBll() {
		if(instance == null) {
			instance= new Bll();
		}
		return instance;
	}
	
	public void insertArticle(Article a) {
		article.insert(a);
	}
	
	public Article selectArticleByNo(int no) {
		return article.selectByNo(no);
	}
	
	public List<Categorie> selectAllCategories(){
		return categorie.selectAll();
	}
	
	public Categorie selectCategorieByName(String nom) {
		return categorie.selectByName(nom);
	}
	
	public Categorie selectCategorieByNo(int no) {
		return categorie.selectByNo(no);
	}
	
	public void insertEnchere(Enchere ench) {
		enchere.insert(ench);
	}
	
	public Enchere selectEnchereByArticle(Article a) {
		return enchere.selectByArticle(a);
	}
	
	public List<Enchere> selectEnchereByUser(Utilisateur util) {
		return enchere.selectByUser(util);
	}
	
	public void insertRetrait(Retrait ret) {
		retrait.insert(ret);
	}
	
	public Retrait selectRetraitByArticle(Article art) {
		return retrait.selectByArticle(art);
	}
	
	public Utilisateur selectUserByNo(int no) {
		return utilisateur.selectByNo(no);
	}

}
