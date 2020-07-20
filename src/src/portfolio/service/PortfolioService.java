package portfolio.service;

import java.util.List;

import income.domain.Income;
import portfolio.dao.PortfolioDao;
import portfolio.domain.Portfolio;
import user.service.UserException;

public class PortfolioService {
	private PortfolioDao portfolioDao = new PortfolioDao();
	
	/**
	 * add an income
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void regist(Portfolio form) throws UserException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		
		// check the user name
//		int user_id = incomeDao.findUserId(form.getUsername());
//		form.setUser_id(Integer.toString(user_id));		
		
//		if(user_id !=null) throw new UserException("This user name has been registered!");
		portfolioDao.add(form);
	}
	
	public List<Portfolio> findallPortfolio(String username) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		String user_id = Integer.toString(portfolioDao.findUserId(username));
		return portfolioDao.findallPortfolio(user_id);
		
	}
	
	public void update(Portfolio form) throws UserException, ClassNotFoundException, InstantiationException, IllegalAccessException{

		portfolioDao.update(form);
	}
	
	public void delete(Portfolio form, String username) throws UserException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		String user_id = Integer.toString(portfolioDao.findUserId(username));
		portfolioDao.delete(form,user_id);
	}

}
