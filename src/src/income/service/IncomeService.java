package income.service;

import java.util.List;

import income.dao.IncomeDao;
import income.domain.Income;

import user.service.UserException;

public class IncomeService {
	private IncomeDao incomeDao = new IncomeDao();
	
	/**
	 * add an income
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void regist(Income form) throws UserException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		
		// check the user name
		int user_id = incomeDao.findUserId(form.getUsername());
		form.setUser_id(Integer.toString(user_id));		
		
//		if(user_id !=null) throw new UserException("This user name has been registered!");
		incomeDao.add(form);
	}
	
	public void update(Income form) throws UserException, ClassNotFoundException, InstantiationException, IllegalAccessException{

		incomeDao.update(form);
	}
	
	public void delete(Income form) throws UserException, ClassNotFoundException, InstantiationException, IllegalAccessException{

		incomeDao.delete(form);
	}
	
	public List<Income> findallIncome(String username) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		String user_id = Integer.toString(incomeDao.findUserId(username));
		return incomeDao.findallIncome(user_id);
		
	}

}
