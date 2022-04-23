package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import common.TransmissionPack;

public class DBController {
	private static Connection con;

	public static void parsingToData(TransmissionPack obj) {
		MissionAnalyze.MissionsAnalyze(obj, con);
	}

	public static boolean connectToDB(List<String> data) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			System.out.println("Driver definition succeed");
		} catch (Exception ex) {
			/* handle the error */
			System.out.println("Driver definition failed");
		}

		try {
			con = DriverManager.getConnection(data.get(0), data.get(1), data.get(2));
			data.clear();
			System.out.println("SQL connection succeed");

		} catch (SQLException ex) {/* handle any errors */
			data.clear();
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
			return false;
		}
		return true;
	}

}
