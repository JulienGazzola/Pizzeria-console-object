package fr.pizzeria.service;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import fr.pizzeria.dao.PizzaMemDao;
import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.Pizza;

public class SupprimerPizzaService extends MenuService{
	public void executeUC(List<Pizza> listePizza, PizzaMemDao dao, Scanner info) throws DeletePizzaException{
		System.out.println("Suppression d'une pizza");
		Iterator iterator = listePizza.iterator();
		while (iterator.hasNext()){
			Pizza pizza = (Pizza) iterator.next();
			System.out.println(pizza.getCode() + " -> "
					+ pizza.getLibelle() + " ("
					+ pizza.getPrix() + " €)");
		}
		System.out.println("Veuillez choisir le code de la pizza à supprimer");
		String nbCodePizza = info.next();
		
		if (dao.pizzaExists(nbCodePizza) != true){
			throw new DeletePizzaException("Ce code n'existe pas");
		}
		
		dao.deletePizza(nbCodePizza);
	}
}
