package question22;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdatableResultSet {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/testDb";

	static final String USER = "root";
	static final String PASS = "system";

	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;

		try {
			Class.forName(JDBC_DRIVER);
			con = DriverManager.getConnection(DB_URL, USER, PASS);
			 
			st =con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
			  con.setAutoCommit(false);
			rs = st.executeQuery("select id ,name from player");
			
			while(rs.next()){
				
				 int tt = rs.getInt("id");
                
				
				 if(tt == 1){
					 System.out.println("ID-----"+tt);
					 System.out.println("name--"+rs.getString(2));
                	  rs.updateString(2, "RAJA");
                     // rs.updateInt(2, 45);
                   
                    rs.updateRow();
                    System.out.println("name--"+rs.getString(2));
                    
                    System.out.println("Record updated!!!");
				 }
                
            }
			con.commit();

		} catch (ClassNotFoundException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				if (st != null)
					st.close();
				if (con != null)
					con.close();
			} catch (Exception ex) {
			}
		}

	}
}
