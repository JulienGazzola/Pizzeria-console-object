package fr.pizzeria.service;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import fr.pizzeria.dao.PizzaMemDao;
import fr.pizzeria.model.Pizza;

public class SupprimerPizzaService extends MenuService{
	public void executeUC(List<Pizza> listePizza, PizzaMemDao dao){
		System.out.println("Suppression d'une pizza");
		Iterator iterator = listePizza.iterator();
		while (iterator.hasNext()){
			Pizza pizza = (Pizza) iterator.next();
			System.out.println(pizza.getCode() + " -> "
					+ pizza.getLibelle() + " ("
					+ pizza.getPrix() + " €)");
		}
		System.out.println("Veuillez choisir le code de la pizza à supprimer");
		Scanner codePizzaSupp = new Scanner(System.in);
		String nbCodePizzaSupp = codePizzaSupp.next();
		dao.deletePizza(nbCodePizzaSupp);
	}
}