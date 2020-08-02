package incomeexpense.service;

import java.util.List;

import income.dao.IncomeDao;
import income.domain.Income;
import incomeexpense.dao.IncomeExpenseDao;
import incomeexpense.domain.IncomeExpense;
import user.service.UserException;

public class IncomeExpenseService {
	private IncomeExpenseDao incomeexpenseDao = new IncomeExpenseDao();
	
	public List<IncomeExpense> IncomeExpenseDiff(String user_id) {
		// TODO Auto-generated method stub
		return incomeexpenseDao.IncomeExpenseDiff(user_id);
	}
	
	
	

}
