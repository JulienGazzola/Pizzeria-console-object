package fr.pizzeria.service;

import fr.pizzeria.exception.*;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import fr.pizzeria.dao.PizzaMemDao;
import fr.pizzeria.model.Pizza;

public class ModifierPizzaService extends MenuService{
	public void executeUC(List<Pizza> listePizza, PizzaMemDao dao) throws UpdatePizzaException{
		System.out.println("Mise à jour d'une pizza");
		Iterator iterator = listePizza.iterator();
		while (iterator.hasNext()){
			Pizza pizza = (Pizza) iterator.next();
			System.out.println(pizza.getCode() + " -> "
					+ pizza.getLibelle() + " ("
					+ pizza.getPrix() + " €)");
		}
		
		System.out.println("Veuillez saisir le code de la pizza à supprimer : ");
		Scanner info = new Scanner(System.in);
		String nbCodePizza = info.next();
		System.out.println("Veuillez saisir le nouveau code : ");
		String newCodePizza = info.next();
		System.out.println("Veuillez saisir le nouveau nom (sans espace) : ");
		String newNomPizza = info.next();
		System.out.println("Veuillez saisir le nouveau prix : ");
		double newPrixPizza = info.nextDouble();
		
		if (dao.pizzaExists(nbCodePizza) != true){
			throw new UpdatePizzaException("Ce code n'existe pas");
		}
		if (newPrixPizza < 0){
			throw new UpdatePizzaException("Un prix ne peut pas etre inférieur ou égale à 0€");
		}
		
		Pizza modifPizza = new Pizza(newCodePizza, newNomPizza, newPrixPizza);
		
		dao.updatePizza(nbCodePizza, modifPizza);
		
	}

}
