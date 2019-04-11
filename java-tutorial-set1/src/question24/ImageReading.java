package question24;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ImageReading {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/testDb";

	static final String USER = "root";
	static final String PASS = "system";

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement preparedStatement = null;

		try {
			Class.forName(JDBC_DRIVER);
			con = DriverManager.getConnection(DB_URL, USER, PASS);
			con.setAutoCommit(false);
			preparedStatement = con.prepareCall("select * from profile");

			ResultSet rs = preparedStatement.executeQuery();
			rs.next();

			Clob c = rs.getClob(2);
			Reader r = c.getCharacterStream();

			FileWriter fw = new FileWriter("D:\\javaimage.txt");

			int i;
			while ((i = r.read()) != -1)
				fw.write((char) i);

			fw.close();
			con.close();

			System.out.println("success");

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
		} catch (IOException e) {
			// TODO Auto-generated catch block
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
