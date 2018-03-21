package fr.pizzeria.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import fr.pizzeria.model.Pizza;

public class PizzaMemDao implements PizzaDao{
	static List<Pizza> listePizza = new ArrayList<Pizza>();
	static {
		listePizza.add(new Pizza(0, "PEP", "Pépéroni", 12.50));
		listePizza.add(new Pizza(1, "MAR", "Margherita", 14.00));
		listePizza.add(new Pizza(2, "REIN", "La Reine", 11.50));
		listePizza.add(new Pizza(3, "FRO", "La 4 fromages", 12.00));
		listePizza.add(new Pizza(4, "CAN", "La cannibale", 12.50));
		listePizza.add(new Pizza(5, "SAV", "La savoyarde", 13.00));
		listePizza.add(new Pizza(6, "ORI", "L'orientale", 13.50));
		listePizza.add(new Pizza(7, "IND", "L'indienne", 14.00));
	}


	public List<Pizza> findAllPizzas() {
		return listePizza;
	}

	public void saveNewPizza(Pizza pizza) {
		listePizza.add(pizza);
	}

	public void updatePizza(String codePizza, Pizza pizza) {
		Pizza newPizza = findPizzaByCode(codePizza);
		newPizza.setCode(pizza.getCode());
		newPizza.setLibelle(pizza.getLibelle());
		newPizza.setPrix(pizza.getPrix());
	}

	public void deletePizza(String codePizza) {
		Pizza pizza = findPizzaByCode(codePizza);
		listePizza.remove(pizza);
	}

	public Pizza findPizzaByCode(String codePizza) {
		Iterator iterator = listePizza.iterator();
		while (iterator.hasNext()){
			Pizza pizza = (Pizza) iterator.next();
			if (pizza.getCode().equals(codePizza)){
				return pizza;
			}
		}
		return null;
	}

	public boolean pizzaExists(String codePizza) {
		Pizza pizza = findPizzaByCode(codePizza);
		if (pizza != null){
			return true;
		}
		return false;
	}
	

}
