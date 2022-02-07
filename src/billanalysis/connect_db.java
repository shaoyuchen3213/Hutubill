package billanalysis;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class connect_db {
	public static void main(String args[]) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");   //loading JDBC 
			System.out.println("Success loading Mysql Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.print("Error loading Mysql Driver");
			e.printStackTrace();
		}
		try {
			Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root","root");
			System.out.println("Success connect Mysql Server!");
			Statement stmt = connect.createStatement();
			ResultSet rs = stmt.executeQuery("select * from user");
			while(rs.next()) {
				System.out.println(rs.getString("name"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Get data error");
			e.printStackTrace();
		}
	}
}
