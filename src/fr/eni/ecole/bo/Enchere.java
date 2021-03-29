package fr.eni.ecole.bo;

import java.time.LocalDate;
/**
 * 
 * Classe représente les enchères
 *
 */
public class Enchere {
	private int dateEnchère;
	private LocalDate montant_enchere;
	private Utilisateur util;
	private Article art;
	
	public Enchere() {
		
	}

	public int getDateEnchère() {
		return dateEnchère;
	}

	public void setDateEnchère(int dateEnchère) {
		this.dateEnchère = dateEnchère;
	}

	public LocalDate getMontant_enchere() {
		return montant_enchere;
	}

	public void setMontant_enchere(LocalDate montant_enchere) {
		this.montant_enchere = montant_enchere;
	}

	public Utilisateur getUtil() {
		return util;
	}

	public void setUtil(Utilisateur util) {
		this.util = util;
	}

	public Article getArt() {
		return art;
	}

	public void setArt(Article art) {
		this.art = art;
	}

	@Override
	public String toString() {
		return "Enchere [dateEnchère=" + dateEnchère + ", montant_enchere=" + montant_enchere + ", util=" + util
				+ ", art=" + art + "]";
	}
	
	
}
