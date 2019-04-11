package question23;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ImageInsertDemo {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/testDb";

	static final String USER = "root";
	static final String PASS = "system";
	
	float average[];

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement preparedStatement = null;
	    InputStream is = null;

		
		try {
			Class.forName(JDBC_DRIVER);
			con = DriverManager.getConnection(DB_URL, USER, PASS);
			con.setAutoCommit(false);
			preparedStatement =   con.prepareCall("insert into profile values (?,?)");
			
			preparedStatement.setString(1, "pic_1");
			is  = new FileInputStream(new File("C:\\Users\\VI20047816\\Desktop\\java.jpg"));
			preparedStatement.setBinaryStream(2, is);
	            int count = preparedStatement.executeUpdate();
	            System.out.println("Count: "+count);
			
		
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
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
				if (con != null)
					con.close();
			} catch (Exception ex) {
			}
		}
	}
}
