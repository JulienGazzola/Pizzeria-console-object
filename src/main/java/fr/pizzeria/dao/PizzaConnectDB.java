package fr.pizzeria.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import fr.pizzeria.logger.AppService;

public class PizzaConnectDB {
	
	Connection createConnexion(){
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			Connection pizzaConnection = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/pizzadb", "root", "");
			pizzaConnection.setAutoCommit(false);
			return pizzaConnection;
		} catch (ClassNotFoundException | SQLException e) {
			new AppService().executer(e.getMessage());
			throw new RuntimeException("DataBase connection failed");
		}
	}
}
