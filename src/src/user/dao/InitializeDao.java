package user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




import java.util.ArrayList;
import java.util.List;

import user.domain.User;
import java.sql.Statement;

import org.apache.ibatis.jdbc.ScriptRunner;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.Reader;
import java.io.FileReader;

public class InitializeDao {
	

	public void initDB( ) {
		Statement statement;
		try {
			
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection connect = DriverManager
			          .getConnection("jdbc:mysql://localhost:3306/finance_manager?useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&"
			        		  + "user=root&password=RnS@66268");
			
			
			//Statements to allow issuing queries to the database
			
			//Deleting existing tables
			statement = connect.createStatement();
			statement.executeUpdate("DROP TABLE IF EXISTS tb_user");
			statement.executeUpdate("DROP TABLE IF EXISTS income");
			statement.executeUpdate("DROP TABLE IF EXISTS expense");
			statement.executeUpdate("DROP TABLE IF EXISTS account");
			statement.executeUpdate("DROP TABLE IF EXISTS asset");
			statement.executeUpdate("DROP TABLE IF EXISTS liability");
			statement.executeUpdate("DROP TABLE IF EXISTS balance_sheet");
			statement.executeUpdate("DROP TABLE IF EXISTS stock");
			statement.executeUpdate("DROP TABLE IF EXISTS portfolio");
			statement.executeUpdate("DROP TABLE IF EXISTS transaction");
//			
//			String sqlstmt = "CREATE TABLE IF NOT EXISTS Student " +
//							"(id INTEGER not NULL AUTO_INCREMENT, " + 
//							"Name VARCHAR(20), " +
//							"Address VARCHAR(50), " +
//							"Status VARCHAR(10), " +
//							"PRIMARY KEY ( id ))";
//			
//			statement.executeUpdate(sqlstmt);
			
			//Initialize the script runner
		    ScriptRunner sr = new ScriptRunner(connect);
		    //Creating a reader object
		    Reader reader = new BufferedReader(new FileReader("/Users/rushit/eclipse-workspace/CS480Demo/WebContent/sql/initialize_db.sql"));
		    sr.runScript(reader);
		    
		} catch(SQLException e) {
			throw new RuntimeException(e);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
		
}
