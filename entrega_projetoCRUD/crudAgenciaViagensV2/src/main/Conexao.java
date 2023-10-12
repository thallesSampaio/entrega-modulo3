package main;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
	
	private static final String USERNAME = "root";
	private static final String PASSWORD = "";
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/entrega3";
	public static Connection createConnectionToMYSQL() throws Exception{
		Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
		return connection;
		
	}
}
