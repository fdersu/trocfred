package fr.eni.ecole.dal;

import java.util.List;

import fr.eni.ecole.bo.Categorie;

public interface CategorieDAO extends CRUD<Categorie> {
	
	List<Categorie> selectAll();
	Categorie selectByName(String nom);
	Categorie selectById(int id);
	void insert(Categorie item);
	void update(Categorie item);
	void delete(Categorie item);

}
