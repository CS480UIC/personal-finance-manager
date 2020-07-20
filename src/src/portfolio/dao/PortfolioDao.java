package portfolio.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import income.domain.Income;
import portfolio.domain.Portfolio;

public class PortfolioDao {
	
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
	}
		
	public void add(Portfolio portfolio) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection connect = DriverManager
			          .getConnection("jdbc:mysql://localhost:3306/finance_manager?useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&"
			        		  + "user=root&password=RnS@66268");
			
			String sql = "select * from stock where symbol=?";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,portfolio.getSymbol());
		    preparestatement.executeQuery();
		    
		    ResultSet rs = preparestatement.getResultSet();
		   if(rs.next()==false) {
			   sql = "insert into stock values (?,?)";
			   preparestatement = connect.prepareStatement(sql); 
			   preparestatement.setString(1,portfolio.getSymbol());
			   preparestatement.setString(2,portfolio.getCurrent_price());
			   preparestatement.executeUpdate();
		   }
			
			sql = "insert into portfolio (user_id,symbol,quantity,buy_price,current_price) values(?,?,?,?,?)";
			preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,portfolio.getUser_id());
		    preparestatement.setString(2,portfolio.getSymbol());
		    preparestatement.setString(3,portfolio.getQuantity());
		    preparestatement.setString(4,portfolio.getBuy_price());
		    preparestatement.setString(5,portfolio.getCurrent_price());
		    preparestatement.executeUpdate();
		    
		    sql = "UPDATE portfolio SET investment = buy_price * quantity";
		    preparestatement = connect.prepareStatement(sql);
		    preparestatement.executeUpdate();
		    
		    sql = "UPDATE portfolio SET equity = current_price * quantity";
		    preparestatement = connect.prepareStatement(sql);
		    preparestatement.executeUpdate();
		    
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	public void update(Portfolio portfolio) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection connect = DriverManager
			          .getConnection("jdbc:mysql://localhost:3306/finance_manager?useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&"
			        		  + "user=root&password=RnS@66268");
			
			
			String sql = "UPDATE portfolio SET quantity=?,buy_price=?,current_price=? WHERE user_id=? AND symbol=?";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,portfolio.getQuantity());
		    preparestatement.setString(2,portfolio.getBuy_price());
		    preparestatement.setString(3,portfolio.getCurrent_price());
		    preparestatement.setString(4,portfolio.getUser_id());
		    preparestatement.setString(5,portfolio.getSymbol());
		    preparestatement.executeUpdate();
		    
		    sql = "UPDATE portfolio SET investment = buy_price * quantity";
		    preparestatement = connect.prepareStatement(sql);
		    preparestatement.executeUpdate();
		    
		    sql = "UPDATE portfolio SET equity = current_price * quantity";
		    preparestatement = connect.prepareStatement(sql);
		    preparestatement.executeUpdate();
		    
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void delete(Portfolio portfolio, String user_id) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection connect = DriverManager
			          .getConnection("jdbc:mysql://localhost:3306/finance_manager?useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&"
			        		  + "user=root&password=RnS@66268");
			
			
			String sql = "DELETE FROM portfolio WHERE user_id=? AND symbol=?";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			preparestatement.setString(1,user_id);
			preparestatement.setString(2,portfolio.getSymbol());
		    preparestatement.executeUpdate();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	public List<Portfolio> findallPortfolio(String user_id) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Portfolio> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection connect = DriverManager
			          .getConnection("jdbc:mysql://localhost:3306/finance_manager?useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&"
			        		  + "user=root&password=RnS@66268");
			
			
			String sql = "select * from portfolio where user_id=?";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			preparestatement.setString(1,user_id);
			ResultSet resultSet = preparestatement.executeQuery();
			
			while(resultSet.next()){
				Portfolio portfolio = new Portfolio();
				portfolio.setUser_id(Integer.toString(resultSet.getInt("user_id")));
				portfolio.setSymbol(resultSet.getString("symbol"));
				portfolio.setQuantity(Integer.toString(resultSet.getInt("quantity")));
				portfolio.setBuy_price(Float.toString(resultSet.getFloat("buy_price")));
				portfolio.setInvestment(Float.toString(resultSet.getFloat("investment")));
				portfolio.setCurrent_price(Float.toString(resultSet.getFloat("current_price")));
				portfolio.setEquity(Float.toString(resultSet.getFloat("equity")));
	    		list.add(portfolio);
			 }
			 
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;

	}

}
