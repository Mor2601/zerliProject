package DataBase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import usersType.Login;

public class Query {
	public static ResultSet getUserLoginDetailQuery(Connection con,Login login) throws SQLException {
		String userName = login.getUserName();
		String password = login.getPassword();
		Statement stmt;
		stmt = con.createStatement();
		String query="SELECT *"+ "FROM login WHERE"+ "username="+login.getUserName()+"password="+login.getPassword();
		ResultSet rs = stmt.executeQuery(query);
		return rs;
	}
}
