package del2;

import java.sql.*;
import java.util.Properties;

	public abstract class DBConnector {
		protected static Connection conn;
		public DBConnector() {
		}
		public void connect() {
			try {
					// Class.forName("com.mysql.jdbc.Driver").newInstance(); when you are using MySQL 5.7
				    Class.forName("com.mysql.cj.jdbc.Driver"); 
			            // Properties for user and password.
			            Properties p = new Properties();
			            p.put("user", "myuser");
			            p.put("password", "mypassword");           
				    //            conn = DriverManager.getConnection("jdbc:mysql://mysql.ansatt.ntnu.no/sveinbra_ektdb?autoReconnect=true&useSSL=false",p);
			            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/piazza?allowPublicKeyRetrieval=true&autoReconnect=true&useSSL=false",p);
			        } catch (Exception e)
			    	{
				}
			}
	public static void disconnect() {
		try {
			DBConnector.conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	}

