package income.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import income.domain.Income;
import user.domain.User;

public class IncomeDao {
	
	
	public int findUserId(String username)throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		int u_id = 0;
		try {
			
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection connect = DriverManager
			          .getConnection("jdbc:mysql://localhost:3306/finance_manager?useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&"
			        		  + "user=root&password=RnS@66268");
			System.out.println("Succesfully connect to database");
		    String sql = "select user_id from tb_user where username=?";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,username);
		    ResultSet resultSet = preparestatement.executeQuery();
		    while(resultSet.next()){
		    	u_id = resultSet.getInt("user_id");

		    }
		    
		    return u_id;
		
		    
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		
//		return null;
	};
	/**
	 * insert income
	 * @param user
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void add(Income income) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection connect = DriverManager
			          .getConnection("jdbc:mysql://localhost:3306/finance_manager?useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&"
			        		  + "user=root&password=RnS@66268");
			
			
			String sql = "insert into income (user_id,in_date,description,amount,tags) values(?,?,?,?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,income.getUser_id());
		    preparestatement.setString(2,income.getIn_date());
		    preparestatement.setString(3,income.getDescription());
		    preparestatement.setString(4,income.getAmount());
		    preparestatement.setString(5,income.getTags());
		    preparestatement.executeUpdate();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void update(Income income) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection connect = DriverManager
			          .getConnection("jdbc:mysql://localhost:3306/finance_manager?useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&"
			        		  + "user=root&password=RnS@66268");
			
			
			String sql = "UPDATE income SET in_date=?,description=?,amount=?,tags=? WHERE income_id=?";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,income.getIn_date());
		    preparestatement.setString(2,income.getDescription());
		    preparestatement.setString(3,income.getAmount());
		    preparestatement.setString(4,income.getTags());
		    preparestatement.setString(5,income.getIncome_id());
		    preparestatement.executeUpdate();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void delete(Income income) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection connect = DriverManager
			          .getConnection("jdbc:mysql://localhost:3306/finance_manager?useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&"
			        		  + "user=root&password=RnS@66268");
			
			
			String sql = "DELETE FROM income WHERE income_id=?";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,income.getIncome_id());
		    preparestatement.executeUpdate();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Income> findallIncome(String user_id) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Income> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection connect = DriverManager
			          .getConnection("jdbc:mysql://localhost:3306/finance_manager?useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&"
			        		  + "user=root&password=RnS@66268");
			
			
			String sql = "select * from income where user_id=?";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			preparestatement.setString(1,user_id);
			ResultSet resultSet = preparestatement.executeQuery();
			
			while(resultSet.next()){
				Income income = new Income();
				income.setIncome_id(Integer.toString(resultSet.getInt("income_id")));
				income.setUser_id(Integer.toString(resultSet.getInt("user_id")));
				income.setIn_date(resultSet.getString("in_date"));
				income.setDescription(resultSet.getString("description"));
	    		income.setAmount(Float.toString(resultSet.getFloat("amount")));
	    		income.setTags(resultSet.getString("tags"));
	    		list.add(income);
			 }
			 
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;

	}
}
