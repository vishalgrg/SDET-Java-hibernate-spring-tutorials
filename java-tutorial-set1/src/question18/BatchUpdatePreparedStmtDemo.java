package question18;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchUpdatePreparedStmtDemo {
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/testDb";

	static final String USER = "root";
	static final String PASS = "system";
	public static void main(String[] args) {
		Connection con = null;
		 PreparedStatement preparedStatement = null;
		 
		 String sqlUpdate = "UPDATE player "
	                + "SET name = ? "
	                + "WHERE id = ?";
		try {
            Class.forName(JDBC_DRIVER);
            con = DriverManager.
                getConnection(DB_URL,USER,PASS);
            con.setAutoCommit(false);
            preparedStatement = con.prepareStatement(sqlUpdate);
            
            
            preparedStatement.setString(1, "RAGHAV");
            preparedStatement.setInt (2, 1);
            preparedStatement.addBatch();

            
            preparedStatement.setString(1, "AMIT");
            preparedStatement.setInt (2, 3);
            preparedStatement.addBatch();

    
           
            int count[] = preparedStatement.executeBatch();
            for(int i=0;i<count.length;i++){
                System.out.println("Query "+i+" has effected "+count[i]+" times");
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
        } finally{
            try{
                if(preparedStatement != null) preparedStatement.close();
                if(con != null) con.close();
            } catch(Exception ex){}
        }
         
	}
}
