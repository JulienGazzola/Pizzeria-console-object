package fr.pizzeria.dao;

import java.util.List;

import fr.pizzeria.model.Pizza;

/** Représente l'interface PizzaDao */
public interface IPizzaDao {
	/** Renvoi la liste des pizzas */
	List<Pizza> findAllPizzas();
	
	/** Ajoute une nouvelle pizza
	 * 
	 * @param pizza
	 */
	void saveNewPizza(Pizza pizza);
	
	/** Modifie une pizza
	 * 
	 * @param codePizza
	 * @param pizza
	 */
	void updatePizza(String codePizza, Pizza pizza);
	
	/** Supprime une pizza
	 * 
	 * @param codePizza
	 */
	void deletePizza(String codePizza);
	
	/** Renvoi une pizza grâce à son code
	 * 
	 * @param codePizza
	 * @return
	 */
	Pizza findPizzaByCode(String codePizza);
	
	/** Renvoi si une pizza existe par son code
	 * 
	 * @param codePizza
	 * @return
	 */
	boolean pizzaExists(String codePizza);
}