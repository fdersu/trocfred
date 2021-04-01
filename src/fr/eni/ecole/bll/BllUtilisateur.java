package fr.eni.ecole.bll;


import fr.eni.ecole.bo.Utilisateur;
import fr.eni.ecole.dal.DAOFactory;
import fr.eni.ecole.dal.UtilisateurDAO;

public class BllUtilisateur {

	private static BllUtilisateur instance;
	private static UtilisateurDAO utilisateur;
	
	private BllUtilisateur() {
		utilisateur = DAOFactory.getUtilisateurDAO();
	}
	
	public static BllUtilisateur getBllUtilisateur() {
		if(instance == null) {
			instance = new BllUtilisateur();
		}
		return instance;
	}
	
	public Utilisateur selectById(int id) {
		return utilisateur.selectById(id);
	}
	
	
}
