package expense.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import expense.domain.Expense;
import portfolio.domain.Portfolio;

public class ExpenseDao {

	public List<Expense> MonthsWithoutExpense(String user_id, String tag) {
		List<Expense> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection connect = DriverManager
			          .getConnection("jdbc:mysql://localhost:3306/finance_manager?useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&"
			        		  + "user=root&password=RnS@66268");
			
			
			String sql = "drop view if exists e1";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			preparestatement.executeUpdate();
			
			sql = "create view e1 as select expense_id,user_id, MONTH(ex_date) as month, description,amount,tags from expense where user_id = ?";
			preparestatement = connect.prepareStatement(sql);
			preparestatement.setString(1,user_id);
			preparestatement.executeUpdate();
			
			sql = "drop view if exists e2";
			preparestatement = connect.prepareStatement(sql); 
			preparestatement.executeUpdate();
			
			sql = "create view e2 as select month from e1 where tags like ?";
			preparestatement = connect.prepareStatement(sql);
			preparestatement.setString(1,"%"+tag+"%");
			preparestatement.executeUpdate();
			
			sql = "select * from e1 where e1.month NOT IN(select month from e1 where tags like ?);";
			preparestatement = connect.prepareStatement(sql);
			preparestatement.setString(1,"%"+tag+"%");
			ResultSet resultSet = preparestatement.executeQuery();
			
			while(resultSet.next()){
				Expense expense = new Expense();
				expense.setExpense_id(Integer.toString(resultSet.getInt("expense_id")));
				expense.setUser_id(Integer.toString(resultSet.getInt("user_id")));
				expense.setMonth(Integer.toString(resultSet.getInt("month")));
				expense.setDescription(resultSet.getString("description"));
				expense.setAmount(Float.toString(resultSet.getFloat("amount")));
				expense.setTags(resultSet.getString("tags"));
	    		list.add(expense);
			 }
			 
		} catch(SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		return list;
	}

}
