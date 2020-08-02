package balancesheet.service;

import java.util.List;

import balancesheet.dao.BalanceSheetDao;
import balancesheet.domain.LossMonths;
import income.domain.Income;

public class BalanceSheetService {
	BalanceSheetDao balancesheetDao = new BalanceSheetDao();
	
	public List<LossMonths> ViewLossMonths(String user_id) {
		// TODO Auto-generated method stub
		return balancesheetDao.ViewLossMonths(user_id);
	}


}
