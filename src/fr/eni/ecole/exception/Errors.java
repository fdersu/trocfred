package fr.eni.ecole.exception;

/**
 * Les codes disponibles sont entre 20000 et 29999
 */
public class Errors {
	
	public static final String REGLE_CODE_POSTAL = "Erreur: le code postal est incorrect";
	
	public static final String REGLE_ARTICLE = "Article contient 30 caractères maximum";
	public static final String REGLE_DESCRIPTION = "Description contient 300 caractères maximum";
	public static final String REGLE_DATE = "la date ne peut être antérieure à la date du jour";
	public static final String REGLE_DATE_MAX = "la date doit être comprise entre 2021 et 2029";
	public static final String MONTANT_ENTIER = "Le montant doit être un entier";
	

}