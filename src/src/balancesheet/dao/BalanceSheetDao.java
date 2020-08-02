package balancesheet.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import balancesheet.domain.LossMonths;
import incomeexpense.domain.IncomeExpense;

public class BalanceSheetDao {
	
	
	public List<LossMonths> ViewLossMonths(String user_id) {
		
		List<LossMonths> list = new ArrayList<>();
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection connect = DriverManager
			          .getConnection("jdbc:mysql://localhost:3306/finance_manager?useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&"
			        		  + "user=root&password=RnS@66268");
			
			
			String sql = "drop view if exists b1";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			preparestatement.executeUpdate();
			
			sql = "create view b1 as select * from balance_sheet where user_id=?";
			preparestatement = connect.prepareStatement(sql);
			preparestatement.setString(1,user_id);
			preparestatement.executeUpdate();
			
			sql = "drop view if exists b2";
			preparestatement = connect.prepareStatement(sql); 
			preparestatement.executeUpdate();
			
			sql = "create view b2 as select MONTH(date) as month, AVG(balance) as balance from b1 group by MONTH(date)";
			preparestatement = connect.prepareStatement(sql);
			preparestatement.executeUpdate();
			
			sql = "drop view if exists b3";
			preparestatement = connect.prepareStatement(sql); 
			preparestatement.executeUpdate();
			
			sql = "create view b3 as select month, month-1 as prev_month, balance from b2";
			preparestatement = connect.prepareStatement(sql);
			preparestatement.executeUpdate();
			
			sql = "select b31.month as curr_month, b31.balance as curr_balance, b32.month as prev_month, b32.balance as prev_balance, b32.balance-b31.balance as decrease from b3 as b31 join b3 as b32 on b31.prev_month=b32.month where b31.balance<b32.balance";
			preparestatement = connect.prepareStatement(sql);
			ResultSet resultSet = preparestatement.executeQuery();

			while(resultSet.next()){
				LossMonths lossmonth = new LossMonths();
				lossmonth.setCurr_month(Integer.toString(resultSet.getInt("curr_month")));
				lossmonth.setCurr_balance(Float.toString(resultSet.getFloat("curr_balance")));
				lossmonth.setPrev_month(Integer.toString(resultSet.getInt("prev_month")));
				lossmonth.setPrev_balance(Float.toString(resultSet.getFloat("prev_balance")));
				lossmonth.setDecrease(Float.toString(resultSet.getFloat("decrease")));
	    		list.add(lossmonth);
			 }
			 
		} catch(SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		return list;
	}
}
