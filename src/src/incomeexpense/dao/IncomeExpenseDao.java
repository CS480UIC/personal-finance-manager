package incomeexpense.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import income.domain.Income;
import incomeexpense.domain.IncomeExpense;

public class IncomeExpenseDao {
	
	
	public List<IncomeExpense> IncomeExpenseDiff(String user_id) {
		
		List<IncomeExpense> list = new ArrayList<>();
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection connect = DriverManager
			          .getConnection("jdbc:mysql://localhost:3306/finance_manager?useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&"
			        		  + "user=root&password=RnS@66268");
			
			
			String sql = "drop view if exists t01";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			preparestatement.executeUpdate();
			
			sql = "create view t01 as select * from income where user_id=?";
			preparestatement = connect.prepareStatement(sql);
			preparestatement.setString(1,user_id);
			preparestatement.executeUpdate();
			
			sql = "drop view if exists t1";
			preparestatement = connect.prepareStatement(sql); 
			preparestatement.executeUpdate();
			
			sql = "create view t1 as select income_id,MONTH(in_date) as month from t01";
			preparestatement = connect.prepareStatement(sql);
			preparestatement.executeUpdate();
			
			sql = "drop view if exists t11";
			preparestatement = connect.prepareStatement(sql); 
			preparestatement.executeUpdate();
			
			sql = "create view t11 as select t01.income_id,t01.user_id,t01.in_date,t01.amount,t1.month from t01 join t1 on t01.income_id=t1.income_id";
			preparestatement = connect.prepareStatement(sql);
			preparestatement.executeUpdate();
			
			sql = "drop view if exists t111";
			preparestatement = connect.prepareStatement(sql); 
			preparestatement.executeUpdate();
			
			sql = "create view t111 as select sum(amount) as in_amt, month from t11 group by month";
			preparestatement = connect.prepareStatement(sql);
			preparestatement.executeUpdate();
			
			sql = "drop view if exists t02";
			preparestatement = connect.prepareStatement(sql); 
			preparestatement.executeUpdate();
			
			sql = "create view t02 as select * from expense where user_id=3";
			preparestatement = connect.prepareStatement(sql);
			preparestatement.executeUpdate();
			
			sql = "drop view if exists t2";
			preparestatement = connect.prepareStatement(sql); 
			preparestatement.executeUpdate();
			
			sql = "create view t2 as select expense_id,MONTH(ex_date) as month from t02";
			preparestatement = connect.prepareStatement(sql);
			preparestatement.executeUpdate();
			
			sql = "drop view if exists t22";
			preparestatement = connect.prepareStatement(sql); 
			preparestatement.executeUpdate();
			
			sql = "create view t22 as select t02.expense_id,t02.user_id,t02.ex_date,t02.amount,t2.month from t02 join t2 on t02.expense_id=t2.expense_id";
			preparestatement = connect.prepareStatement(sql);
			preparestatement.executeUpdate();
			
			sql = "drop view if exists t222";
			preparestatement = connect.prepareStatement(sql); 
			preparestatement.executeUpdate();
			
			sql = "create view t222 as select sum(amount) as ex_amt, month from t22 group by month";
			preparestatement = connect.prepareStatement(sql);
			preparestatement.executeUpdate();
			
			sql = "select t111.in_amt,t222.ex_amt,t111.in_amt-t222.ex_amt as diff, t111.month as month from t111 join t222 on t111.month=t222.month;";
			preparestatement = connect.prepareStatement(sql);
			ResultSet resultSet = preparestatement.executeQuery();
		
			
			while(resultSet.next()){
				IncomeExpense incomeexpense = new IncomeExpense();
				incomeexpense.setIn_amt(Float.toString(resultSet.getFloat("in_amt")));
				incomeexpense.setEx_amt(Float.toString(resultSet.getFloat("ex_amt")));
				incomeexpense.setDiff(Float.toString(resultSet.getFloat("diff")));
				incomeexpense.setMonth(Integer.toString(resultSet.getInt("month")));
	    		list.add(incomeexpense);
			 }
			 
		} catch(SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		return list;
	}


}
