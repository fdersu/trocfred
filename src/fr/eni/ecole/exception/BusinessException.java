package fr.eni.ecole.exception;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Administrator
 *
 *         Cette classe permet de recenser l'ensemble des erreurs (par leur
 *         code) pouvant survenir lors d'un traitement quel que soit la couche à
 *         l'origine.
 */
public class BusinessException extends Exception {
	private static final long serialVersionUID = -8104368022479472121L;
	private String message;
	// Ensemble des messages d'erreur de l'affichage
	
	
	
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


	private List<String> errors = new ArrayList<String>();

	public void addError(String error) {
		errors.add(error);
	}

	public List<String> getErrors() {
		return errors;
	}

	public boolean hasErreurs() {
		return this.errors.size() > 0;
	}

}