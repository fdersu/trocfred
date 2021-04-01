package fr.eni.ecole.dal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import fr.eni.ecole.bo.Article;

public class ArticleJDBC implements ArticleDAO {
	
	private CategorieDAO cat = DAOFactory.getCategorieDAO();
	private UtilisateurDAO util = DAOFactory.getUtilisateurDAO();

	public void insert(Article a) {
		try(Connection cx = Connect.getConnection()){
			PreparedStatement request = cx.prepareStatement("INSERT INTO articles (nom_article, description, date_debut_encheres, "
					+ "date_fin_encheres, prix_initial, no_utilisateur, no_categorie) "
					+ "VALUES(?,?,?,?,?,?,?)");
			request.setString(1, a.getNomArticle());
			request.setString(2, a.getDescription());
			request.setDate(3, Date.valueOf(a.getDateDebutEncheres()));
			request.setDate(4, Date.valueOf(a.getDateFinEncheres()));
			request.setInt(5, a.getPrixInitial());
			request.setInt(6, a.getUtilisateur().getNoUtilisateur());
			request.setInt(7, a.getCategorie().getNoCategorie());
			request.executeUpdate();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public Article selectByNo(int no) {
		Article art = new Article();
		try(Connection cx = Connect.getConnection()){
			PreparedStatement request = cx.prepareStatement("SELECT no_article, nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie "
					+ "FROM articles WHERE no_article = ?");
			request.setInt(1, no);
			ResultSet rs = request.executeQuery();
			rs.next();
			art = articleBuilder(rs);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return art;
	}
	
	public Article articleBuilder(ResultSet rs) {
		Article art = new Article();
		try {
			art.setNoArticle(rs.getInt("no_article"));
			art.setNomArticle(rs.getString("nom_article"));
			art.setDescription(rs.getString("desciption"));
			art.setDateDebutEncheres(rs.getDate("date_debut_encheres").toLocalDate());
			art.setDateFinEncheres(rs.getDate("date_fin_encheres").toLocalDate());
			art.setPrixInitial(rs.getInt("prix_initial"));
			art.setPrixVente(rs.getInt("prix_vente"));
			art.setUtilisateur(util.selectByNo(rs.getInt("no_utilisateur")));
			art.setCategorie(cat.selectByNo(rs.getInt("no_categorie")));
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return art;
	}
	
}
