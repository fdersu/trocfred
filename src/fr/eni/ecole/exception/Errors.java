package fr.eni.ecole.exception;

/**
 * Les codes disponibles sont entre 20000 et 29999
 */
public class Errors {
	
	public static final String REGLE_CODE_POSTAL = "Erreur: le code postal est incorrect";
	
	public static final String REGLE_ARTICLE = "Article contient 30 caract�res maximum";
	public static final String REGLE_DESCRIPTION = "Description contient 300 caract�res maximum";
	public static final String REGLE_DATE = "la date ne peut �tre ant�rieure � la date du jour";
	public static final String REGLE_DATE_MAX = "la date doit �tre comprise entre 2021 et 2029";
	public static final String MONTANT_ENTIER = "Le montant doit �tre un entier";
	

}