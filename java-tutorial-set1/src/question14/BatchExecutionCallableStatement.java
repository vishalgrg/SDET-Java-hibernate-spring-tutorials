package question14;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BatchExecutionCallableStatement {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/testDb";

	static final String USER = "root";
	static final String PASS = "system";

	public static void main(String[] args) {
		Connection con = null;
		CallableStatement callSt = null;
		try {
			Class.forName(JDBC_DRIVER);
			con = DriverManager.getConnection(DB_URL, USER, PASS);

			callSt = con.prepareCall("{call spInsertNewPlayerRecord(?,?,?)}");

			callSt.setString(1, "Vishal");
			callSt.setInt(2, 25);
			callSt.setInt(3, 100);
			callSt.addBatch();

			callSt.setString(1, "Rahul");
			callSt.setInt(2, 26);
			callSt.setInt(3, 200);
			callSt.addBatch();

			int[] updateCounts = callSt.executeBatch();

			// retrieving result and checking
			for (int result : updateCounts) {
				System.out.println(result + " indicates updateCounts is successful");
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
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
