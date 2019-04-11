package question19;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;
import java.sql.Statement;

public class BatchUpdateStatementDemo {
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/testDb";

	static final String USER = "root";
	static final String PASS = "system";
	public static void main(String[] args) {
		Connection con = null;
		 Statement st = null;
		try {
            Class.forName(JDBC_DRIVER);
            con = DriverManager.
                getConnection(DB_URL,USER,PASS);
            con.setAutoCommit(false);
            st = con.createStatement();
            
            
            
            st.addBatch("update player "+"SET name = 'Ramesh' WHERE id = 1");
            st.addBatch("insert into player values (5,'RAM',35,9000)");
          
           
            int count[] = st.executeBatch();
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
                if(st != null) st.close();
                if(con != null) con.close();
            } catch(Exception ex){}
        }
         
	}
}
