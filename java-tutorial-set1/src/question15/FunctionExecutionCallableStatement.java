package question15;

import java.awt.Window.Type;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class FunctionExecutionCallableStatement {
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
			callSt = con.prepareCall("{?= call sum4(?,?)}");
			callSt.setInt(2, 25);
			callSt.setInt(3, 25);
			callSt.registerOutParameter(1, Types.INTEGER);
			callSt.execute();
			System.out.println("SUM IS: "+callSt.getInt(1));

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
