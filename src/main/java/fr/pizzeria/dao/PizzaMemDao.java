package fr.pizzeria.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import fr.pizzeria.model.Pizza;
import fr.pizzeria.model.*;

public class PizzaMemDao implements IPizzaDao {
	
	private List<Pizza> listePizza = new ArrayList<Pizza>();
	
	public PizzaMemDao(){
		listePizza.add(new Pizza(0, "PEP", "Pépéroni", 12.50, CategoriePizza.VIANDE));
		listePizza.add(new Pizza(1, "MAR", "Margherita", 14.00, CategoriePizza.SANS_VIANDE));
		listePizza.add(new Pizza(2, "REIN", "La Reine", 11.50, CategoriePizza.VIANDE));
		listePizza.add(new Pizza(3, "FRO", "La 4 fromages", 12.00, CategoriePizza.SANS_VIANDE));
		listePizza.add(new Pizza(4, "CAN", "La cannibale", 12.50, CategoriePizza.VIANDE));
		listePizza.add(new Pizza(5, "SAV", "La savoyarde", 13.00, CategoriePizza.VIANDE));
		listePizza.add(new Pizza(6, "ORI", "L'orientale", 13.50, CategoriePizza.VIANDE));
		listePizza.add(new Pizza(7, "IND", "L'indienne", 14.00, CategoriePizza.VIANDE));
	}

	public List<Pizza> findAllPizzas() {
		return listePizza;
	}

	public void saveNewPizza(Pizza pizza) {
		if (pizza != null) {
			listePizza.add(pizza);
		}
	}

	public void updatePizza(String codePizza, Pizza pizza) {
		if (pizza != null) {
			Pizza newPizza = findPizzaByCode(codePizza);
			if (newPizza != null) {
				newPizza.setCode(pizza.getCode());
				newPizza.setLibelle(pizza.getLibelle());
				newPizza.setPrix(pizza.getPrix());
				newPizza.setCategoriePizza(pizza.getCategoriePizza());
			}
		}
	}

	public void deletePizza(String codePizza) {
		if (codePizza != null) {
			Pizza pizza = findPizzaByCode(codePizza);
			listePizza.remove(pizza);
		}
	}

	public Pizza findPizzaByCode(String codePizza) {
		if (codePizza == null) {
			return null;
		}
		Iterator iterator = listePizza.iterator();
		while (iterator.hasNext()) {
			Pizza pizza = (Pizza) iterator.next();
			if (pizza.getCode().equals(codePizza)) {
				return pizza;
			}
		}
		return null;
	}

	public boolean pizzaExists(String codePizza) {
		Pizza pizza = findPizzaByCode(codePizza);
		if (pizza != null) {
			return true;
		}
		return false;
	}

}
