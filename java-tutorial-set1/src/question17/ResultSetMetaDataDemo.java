package question17;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
 





public class ResultSetMetaDataDemo {
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/testDb";

	static final String USER = "root";
	static final String PASS = "system";
	
	
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement prepSt = null;
	    ResultSet rs = null;
		try {
			Class.forName(JDBC_DRIVER);
			con = DriverManager.getConnection(DB_URL, USER, PASS);
			PreparedStatement ps=con.prepareStatement("select * from player");  
            
		    rs=ps.executeQuery();  
			ResultSetMetaData rsmd=rs.getMetaData();  
			 int columnCount = rsmd.getColumnCount();
            System.out.println("Total columns: "+rsmd.getColumnCount());  
            System.out.println("Column Name of 1st column: "+rsmd.getColumnName(1));  
            System.out.println("Column Type Name of 1st column: "+rsmd.getColumnTypeName(1));  
		} catch (ClassNotFoundException exception) {
			exception.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (prepSt != null)
					prepSt.close();
				if (con != null)
					con.close();
			} catch (Exception ex) {
			}

		}
		
	}
}
