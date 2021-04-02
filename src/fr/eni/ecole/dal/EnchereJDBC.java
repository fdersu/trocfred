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
			request.setTimestamp(1, ench.getDate());
			request.setInt(2, ench.getMontant());
			request.setInt(3, ench.getArticle().getNumero());
			request.setInt(4, ench.getUtilisateur().getNumero());
			request.executeUpdate();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public List<Enchere> selectByArticle(Article a) {
		List<Enchere> liste = new ArrayList<Enchere>();
		
		try(Connection cx = Connect.getConnection()){
			PreparedStatement request = cx.prepareStatement("SELECT no_enchere, date_enchere, montant_enchere, no_article, no_utilisateur"
					+ " FROM encheres WHERE no_article = ?");
			request.setInt(1, a.getNumero());
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
	
	public List<Enchere> selectByUser(Utilisateur util){
		List<Enchere> liste = new ArrayList<Enchere>();
		try(Connection cx = Connect.getConnection()){
			PreparedStatement request = cx.prepareStatement("SELECT no_enchere, date_enchere, montant_enchere, no_article, no_utilisateur "
					+ "FROM encheres WHERE no_utilisateur = ?");
			request.setInt(1, util.getNumero());
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
			ench.setNumero(rs.getInt("no_enchere"));
			ench.setDate(rs.getTimestamp("date_enchere"));
			ench.setMontant(rs.getInt("montant_enchere"));
			ench.setArticle(art.selectById(rs.getInt("no_article")));
			ench.setUtilisateur(util.selectById(rs.getInt("no_utilisateur")));	
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return ench;
	}

	@Override
	public List<Enchere> selectAll() {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public Enchere selectById(int id) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public void update(Enchere item) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public void delete(Enchere item) {
		throw new UnsupportedOperationException("Not supported yet.");
	}
	
}
