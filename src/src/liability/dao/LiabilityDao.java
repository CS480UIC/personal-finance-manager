package liability.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import income.domain.Income;
import liability.domain.Liability;

public class LiabilityDao {
	
	
	public void add(Liability liability) {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection connect = DriverManager
			          .getConnection("jdbc:mysql://localhost:3306/finance_manager?useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&"
			        		  + "user=root&password=RnS@66268");
			
			
			String sql = "insert into liability (user_id,liability_name,value) values(?,?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,liability.getUser_id());
		    preparestatement.setString(2,liability.getLiability_name());
		    preparestatement.setString(3,liability.getValue());
		    preparestatement.executeUpdate();
		} catch(SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	};
	
	public List<Liability> findallLiability(String user_id) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Liability> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection connect = DriverManager
			          .getConnection("jdbc:mysql://localhost:3306/finance_manager?useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&"
			        		  + "user=root&password=RnS@66268");
			
			
			String sql = "select * from liability where user_id=?";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			preparestatement.setString(1,user_id);
			ResultSet resultSet = preparestatement.executeQuery();
			
			while(resultSet.next()){
				Liability liability = new Liability();
				liability.setUser_id(Integer.toString(resultSet.getInt("user_id")));
				liability.setLiability_name(resultSet.getString("liability_name"));
				liability.setValue(resultSet.getString("value"));
	    		list.add(liability);
			 }
			 
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;

	}

}
