package Model.DAO;

import java.sql.Statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class AdminDAO {
	public static boolean isExistAccount(String user_input, String pass_input) {
		boolean existAccount = false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/laptopstore";
			Connection con = DriverManager.getConnection(url, "root", "");
			Statement stmt = con.createStatement();

			String sql = "Select * from admin";
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {

				String username = rs.getString("username");
				String password = rs.getString("password");
				if (user_input.equals(username) && pass_input.equals(password)) {
					existAccount = true;
				}
			}

		} catch (Exception e) {
			System.out.println("Error:  " + e);
		}
		return existAccount;
	}
}
