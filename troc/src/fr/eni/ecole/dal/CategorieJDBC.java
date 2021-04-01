package fr.eni.ecole.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import fr.eni.ecole.bo.Categorie;

public class CategorieJDBC implements CategorieDAO {
	
	public List<Categorie> selectAll(){
		List<Categorie> liste = new ArrayList<Categorie>();
		try(Connection cx = Connect.getConnection()){
			PreparedStatement request = cx.prepareStatement("SELECT no_categorie, libelle from categories");
			ResultSet rs = request.executeQuery();
			while(rs.next()) {
			Categorie c = new Categorie();
			c.setNoCategorie(rs.getInt("no_categorie"));
			c.setLibelle(rs.getString("libelle"));
			liste.add(c);
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return liste;
	}
	
	public Categorie selectByName(String nom) {
		Categorie cat = new Categorie();
		try(Connection cx = Connect.getConnection()){
			PreparedStatement request = cx.prepareStatement("SELECT no_categorie, libelle WHERE libelle = ?");
			request.setString(1, nom);
			ResultSet rs = request.executeQuery();
			cat.setNoCategorie(rs.getInt("no_categorie"));
			cat.setLibelle(rs.getString("libelle"));
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return cat;
	}
	
	public Categorie selectByNo(int no) {
		Categorie cat = new Categorie();
		try(Connection cx = Connect.getConnection()){
			PreparedStatement request = cx.prepareStatement("SELECT no_categorie, libelle WHERE no_categorie = ?");
			request.setInt(1, no);;
			ResultSet rs = request.executeQuery();
			rs.next();
			cat.setNoCategorie(rs.getInt("no_categorie"));
			cat.setLibelle(rs.getString("libelle"));
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return cat;
	}

}
