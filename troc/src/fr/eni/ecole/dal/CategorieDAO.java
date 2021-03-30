package fr.eni.ecole.dal;

import java.util.List;

import fr.eni.ecole.bo.Categorie;

public interface CategorieDAO {
	
	List<Categorie> selectAll();
	Categorie selectByName(String nom);
	Categorie selectByNo(int no);

}
