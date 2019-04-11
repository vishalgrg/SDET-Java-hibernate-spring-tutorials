package question25;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseMetaDataDemo {
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/testDb";

	static final String USER = "root";
	static final String PASS = "system";
public static void main(String a[]){
		
		Connection con = null;
		try {
			Class.forName(JDBC_DRIVER);
			con = DriverManager.getConnection(DB_URL, USER, PASS);
			DatabaseMetaData dm = con.getMetaData();
			System.out.println(dm.getDriverVersion());
			System.out.println(dm.getDriverName());
			System.out.println(dm.getDatabaseProductName());
			System.out.println(dm.getDatabaseProductVersion());
		} catch (SQLException e) {
		
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} finally{
			if(con != null){}
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}


