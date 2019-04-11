package question16;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.MySQLConnection;

public class CursorsCallableStatement {
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/testDb";

	static final String USER = "root";
	static final String PASS = "system";
	
	public static void main(String[] args) {
		Connection con = null;
		CallableStatement callSt = null;
		
		try{
			Class.forName(JDBC_DRIVER);
			
				con = DriverManager.getConnection(DB_URL, USER, PASS);
				 callSt = con.prepareCall("{call spGetPlayerRecord(?,?)}");
				 callSt.setInt(1,1);
				 ResultSet rs = null;
				
				 System.out.println("FDSgfs");
				 
				callSt.registerOutParameter(2, java.sql.Types.VARCHAR);
				System.out.println("FDSgfs");
		
	             boolean rss= callSt.execute();
	           
	              rs = callSt.getResultSet();
	             
	            // System.out.println(callSt.getString(2));
	           System.out.println(rs.getFetchSize()+""+rss);
	            while(rs.next()){
	                System.out.println(rs.getString(1));
	            }
			
			
		} catch (ClassNotFoundException exception) {
			exception.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (callSt != null)
					callSt.close();
				if (con != null)
					con.close();
			} catch (Exception ex) {
			}

		}
		
		

}
}
