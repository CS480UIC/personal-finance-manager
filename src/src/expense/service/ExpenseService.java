package expense.service;

import expense.dao.ExpenseDao;
import expense.domain.Expense;
import java.util.List;

public class ExpenseService {
	ExpenseDao expenseDao = new ExpenseDao();

	public List<Expense> MonthsWithoutExpense(String user_id, String tag) {
		return expenseDao.MonthsWithoutExpense(user_id,tag);
	}
	
	

}
