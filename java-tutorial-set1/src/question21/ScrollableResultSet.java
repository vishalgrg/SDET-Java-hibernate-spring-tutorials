package question21;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ScrollableResultSet {
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
			  con.setAutoCommit(false);
			st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = st.executeQuery("select id, name, age from player");
			System.out.println("ResultSet Curson is at before first: " + rs.isBeforeFirst());

			while (rs.next()) {
				System.out.println("ID: "+rs.getInt(1)+"  Name: " +rs.getString(2) + "   AGE: " + rs.getInt(3));
			}
			// now result set cursor reached the last position
			System.out.println("");
			System.out.println("Is After Last: " + rs.isAfterLast());
			while (rs.previous()) {
				System.out.println("ID: "+rs.getInt(1)+"  Name: " +rs.getString(2) + "   AGE: " + rs.getInt(3));
			}

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
