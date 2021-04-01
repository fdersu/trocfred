package fr.eni.ecole.bll;


import fr.eni.ecole.bo.Article;
import fr.eni.ecole.bo.Retrait;
import fr.eni.ecole.dal.DAOFactory;
import fr.eni.ecole.dal.RetraitDAO;
import fr.eni.ecole.exception.BusinessException;
import fr.eni.ecole.exception.Errors;

public class BllRetrait {

	private static BllRetrait instance;
	private static RetraitDAO retrait;
	
	private BllRetrait() {
		retrait = DAOFactory.getRetraitDAO();
	}
	
	public static BllRetrait getBllRetrait() {
		if(instance == null) {
			instance = new BllRetrait();
		}
		return instance;
	}
	
	public void insert(Retrait item) throws BusinessException {
		if(item.getCodePostal().matches("^[0-9]{5}")) {
		retrait.insert(item);
		}
		else {
			BusinessException error = new BusinessException();
			error.addError(Errors.REGLE_CODE_POSTAL);
			throw error;
		}
	}
	
	public void update(Retrait item) {
		retrait.update(item);
	}
	
	public Retrait selectByArticle(Article a) {
		return retrait.selectByArticle(a);
	}
	
	
}
