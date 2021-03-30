package fr.eni.ecole.dal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import fr.eni.ecole.bo.Article;
import fr.eni.ecole.bo.Enchere;
import fr.eni.ecole.bo.Utilisateur;

public class EnchereJDBC implements EnchereDAO {
	
	private ArticleDAO art = DAOFactory.getArticleDAO();
	private UtilisateurDAO util = DAOFactory.getUtilisateurDAO();
	
	public void insert(Enchere ench) {
		try(Connection cx = Connect.getConnection()){
			PreparedStatement request = cx.prepareStatement("INSERT INTO encheres "
					+ "(date_enchere, montant_enchere, no_article, no_utilisateur) VALUES(?,?,?,?)");
			request.setDate(1, Date.valueOf(ench.getDateEnchere()));
			request.setInt(2, ench.getMontant_enchere());
			request.setInt(3, ench.getArticle().getNoArticle());
			request.setInt(4, ench.getUtilisateur().getNoUtilisateur());
			request.executeUpdate();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public Enchere selectByArticle(Article a) {
		Enchere ench = new Enchere();
		
		try(Connection cx = Connect.getConnection()){
			PreparedStatement request = cx.prepareStatement("SELECT no_enchere, date_enchere, montant_enchere, no_article, no_utilisateur"
					+ " WHERE no_article = ?");
			request.setInt(1, a.getNoArticle());
			ResultSet rs = request.executeQuery();
			rs.next();
			ench = enchereBuilder(rs);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return ench;
	}
	
	public List<Enchere> selectByUser(Utilisateur util){
		List<Enchere> liste = new ArrayList<Enchere>();
		try(Connection cx = Connect.getConnection()){
			PreparedStatement request = cx.prepareStatement("SELECT no_enchere, date_enchere, montant_enchere, no_article, no_utilisateur "
					+ "FROM encheres WHERE no_utilisateur = ?");
			request.setInt(1, util.getNoUtilisateur());
			ResultSet rs = request.executeQuery();
			while(rs.next()) {
				Enchere ench = enchereBuilder(rs);
				liste.add(ench);
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return liste;
	}
	
	public Enchere enchereBuilder(ResultSet rs) {
		Enchere ench = new Enchere();
		try {
			ench.setNo_enchere(rs.getInt("no_enchere"));
			ench.setDateEnchere(rs.getDate("date_enchere").toLocalDate());
			ench.setMontant_enchere(rs.getInt("montant_enchere"));
			ench.setArticle(art.selectByNo(rs.getInt("no_article")));
			ench.setUtilisateur(util.selectByNo(rs.getInt("no_utilisateur")));	
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return ench;
	}

}
