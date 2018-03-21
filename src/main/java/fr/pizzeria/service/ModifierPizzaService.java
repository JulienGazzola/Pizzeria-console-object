package fr.pizzeria.service;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import fr.pizzeria.dao.PizzaMemDao;
import fr.pizzeria.model.Pizza;

public class ModifierPizzaService {
	public void executeUC(List<Pizza> listePizza, PizzaMemDao dao){
		System.out.println("Mise à jour d'une pizza");
		Iterator iterator = listePizza.iterator();
		while (iterator.hasNext()){
			Pizza pizza = (Pizza) iterator.next();
			System.out.println(pizza.getCode() + " -> "
					+ pizza.getLibelle() + " ("
					+ pizza.getPrix() + " €)");
		}
		
		System.out.println("Veuillez saisir le code de la pizza à supprimer : ");
		Scanner codePizza = new Scanner(System.in);
		String nbCodePizza = codePizza.next();
		
		System.out.println("Veuillez saisir le nouveau code : ");
		Scanner newCodePizza = new Scanner(System.in);
		String newCodePizza2 = newCodePizza.next();
		
		System.out.println("Veuillez saisir le nouveau nom (sans espace) : ");
		Scanner newNomPizza = new Scanner(System.in);
		String newNomPizza2 = newNomPizza.next();
		
		System.out.println("Veuillez saisir le nouveau prix : ");
		Scanner newPrixPizza = new Scanner(System.in);
		double newPrixPizza2 = newPrixPizza.nextDouble();
		
		Pizza modifPizza = new Pizza(newCodePizza2, newNomPizza2, newPrixPizza2);
		dao.updatePizza(nbCodePizza, modifPizza);
		
	}

}
