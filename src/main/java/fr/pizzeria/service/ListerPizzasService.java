package fr.pizzeria.service;

import java.util.Iterator;
import java.util.List;

import fr.pizzeria.dao.PizzaMemDao;
import fr.pizzeria.model.Pizza;

public class ListerPizzasService {
	
	public void executeUC(List<Pizza> listePizza, PizzaMemDao dao){
		System.out.println("Liste des pizzas");
		Iterator iterator = listePizza.iterator();
		while (iterator.hasNext()){
			Pizza pizza = (Pizza) iterator.next();
			System.out.println(pizza.getCode() + " -> "
					+ pizza.getLibelle() + " ("
					+ pizza.getPrix() + " €)");
		}
	}
}
