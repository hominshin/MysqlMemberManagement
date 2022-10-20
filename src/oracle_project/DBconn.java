package oracle_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconn {
	
	public static Connection getConnection(){
		
	    Connection conn = null;
		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		 
		 
		 try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","madang","madang");
			
		} catch (SQLException e) {
			System.out.println("DB연결 실패");
			e.printStackTrace();
		}
		 
	  
		 return conn;
	}
	
	public static void close(Connection conn) {
		
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
