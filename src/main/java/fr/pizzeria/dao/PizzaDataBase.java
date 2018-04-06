package fr.pizzeria.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.pizzeria.logger.AppService;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class PizzaDataBase implements IPizzaDao {
	Connection pizzaConnection;

	@Override
	public List<Pizza> findAllPizzas() {
		PizzaConnectDB connection = new PizzaConnectDB();
		
		this.pizzaConnection = connection.createConnexion();

		ResultSet resultats = null;
		List<Pizza> listePizza = new ArrayList<Pizza>();
		try {
			PreparedStatement findPizza = pizzaConnection.prepareStatement("SELECT * FROM pizza");
			resultats = findPizza.executeQuery();
			while (resultats.next()) {
				int id = resultats.getInt("ID");
				String code = resultats.getString("CODE");
				String name = resultats.getString("NOM");
				double price = resultats.getDouble("PRIX");
				CategoriePizza categorie = CategoriePizza.valueOf(resultats.getString("CATEGORIE"));
				listePizza.add(new Pizza(id, code, name, price, categorie));
			}
			resultats.close();
			return (listePizza);
		} catch (SQLException e) {
			new AppService().executer(e.getMessage());
		} finally {
			try {
				pizzaConnection.close();
			} catch (SQLException e) {
				new AppService().executer(e.getMessage());
			}
		}
		return null;
	}

	@Override
	public void saveNewPizza(Pizza pizza) {

		PizzaConnectDB connection = new PizzaConnectDB();
		
		this.pizzaConnection = connection.createConnexion();

		try {
			PreparedStatement savePizza = pizzaConnection
					.prepareStatement("INSERT INTO pizza (CODE, NOM, PRIX, CATEGORIE) VALUES(?,?,?,?)");
			savePizza.setString(1, pizza.getCode());
			savePizza.setString(2, pizza.getLibelle());
			savePizza.setDouble(3, pizza.getPrix());
			savePizza.setString(4, pizza.getCategoriePizza().name());
			savePizza.executeUpdate();
			pizzaConnection.commit();

		} catch (SQLException e) {
			try {
				pizzaConnection.rollback();
			} catch (SQLException e1) {
				new AppService().executer(e1.getMessage());
			}
			new AppService().executer(e.getMessage());
		} finally {
			try {
				pizzaConnection.close();
			} catch (SQLException e) {
				new AppService().executer(e.getMessage());
			}
		}
	}

	@Override
	public void updatePizza(String codePizza, Pizza pizza) {
		PizzaConnectDB connection = new PizzaConnectDB();
		
		this.pizzaConnection = connection.createConnexion();

		try {
			PreparedStatement updatePizza = pizzaConnection.prepareStatement(
					"" + "UPDATE pizza SET CODE = ?, NOM = ?, PRIX = ?, CATEGORIE = ? " + "WHERE CODE = ?");
			updatePizza.setString(1, pizza.getCode());
			updatePizza.setString(2, pizza.getLibelle());
			updatePizza.setDouble(3, pizza.getPrix());
			updatePizza.setString(4, pizza.getCategoriePizza().name());
			updatePizza.setString(5, codePizza);
			updatePizza.executeUpdate();
			pizzaConnection.commit();
		} catch (SQLException e) {
			new AppService().executer(e.getMessage());
		} finally {
			try {
				pizzaConnection.close();
			} catch (SQLException e) {
				new AppService().executer(e.getMessage());
			}
		}

	}

	@Override
	public void deletePizza(String codePizza) {
		PizzaConnectDB connection = new PizzaConnectDB();
		
		this.pizzaConnection = connection.createConnexion();

		try {
			PreparedStatement deletePizza = pizzaConnection.prepareStatement("DELETE FROM pizza WHERE CODE = ?");
			deletePizza.setString(1, codePizza);
			deletePizza.executeUpdate();
			pizzaConnection.commit();
		} catch (SQLException e) {
			new AppService().executer(e.getMessage());
		} finally {
			try {
				pizzaConnection.close();
			} catch (SQLException e) {
				new AppService().executer(e.getMessage());
			}
		}

	}

	@Override
	public Pizza findPizzaByCode(String codePizza) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean pizzaExists(String codePizza) {
		PizzaConnectDB connection = new PizzaConnectDB();
		
		this.pizzaConnection = connection.createConnexion();

		ResultSet resultats = null;
		try {
			PreparedStatement pizzaExist = pizzaConnection.prepareStatement("SELECT * FROM pizza WHERE CODE = ?");
			pizzaExist.setString(1, codePizza);
			resultats = pizzaExist.executeQuery();
			pizzaConnection.commit();

			if (resultats.next()) {
				return true;
			}

		} catch (SQLException e) {
			new AppService().executer(e.getMessage());
		} finally {
			try {
				resultats.close();
				pizzaConnection.close();
			} catch (SQLException e) {
				new AppService().executer(e.getMessage());
			}
		}
		return false;
	}

}
