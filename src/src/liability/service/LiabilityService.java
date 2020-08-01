package liability.service;

import java.util.List;

import income.dao.IncomeDao;
import income.domain.Income;
import liability.dao.LiabilityDao;
import liability.domain.Liability;
import user.service.UserException;

public class LiabilityService {
private LiabilityDao liabilityDao = new LiabilityDao();
private IncomeDao incomeDao = new IncomeDao();
	
	/**
	 * add an income
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void regist(Liability form) throws UserException, ClassNotFoundException, InstantiationException, IllegalAccessException{
			
//		if(user_id !=null) throw new UserException("This user name has been registered!");
		liabilityDao.add(form);
	}
	
	public List<Liability> findallLiability(String user_id) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return liabilityDao.findallLiability(user_id);
	}
	

}
