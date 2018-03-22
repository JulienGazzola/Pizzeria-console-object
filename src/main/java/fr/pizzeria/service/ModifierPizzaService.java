package fr.pizzeria.service;

import fr.pizzeria.exception.*;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import fr.pizzeria.dao.PizzaMemDao;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class ModifierPizzaService extends MenuService{
	public void executeUC(List<Pizza> listePizza, PizzaMemDao dao, Scanner info) throws UpdatePizzaException{
		System.out.println("Mise à jour d'une pizza");
		Iterator iterator = listePizza.iterator();
		while (iterator.hasNext()){
			Pizza pizza = (Pizza) iterator.next();
			System.out.println(pizza.getCode() + " -> "
					+ pizza.getLibelle() + " ("
					+ pizza.getPrix() + " €)");
		}
		
		System.out.println("Veuillez saisir le code de la pizza à supprimer : ");
		String nbCodePizza = info.next();
		System.out.println("Veuillez saisir le nouveau code : ");
		String newCodePizza = info.next();
		System.out.println("Veuillez saisir le nouveau nom (sans espace) : ");
		String newNomPizza = info.next();
		System.out.println("Veuillez saisir le nouveau prix : ");
		double newPrixPizza = info.nextDouble();
		System.out.println("Veuillez saisir la catégorie de pizza : ");
		String newCategoriePizza = info.next();
		
		if (!CategoriePizza.exists(newCategoriePizza)){
			throw new UpdatePizzaException("Mauvais nom de catégorie : VIANDE | POISSON | SANS_VIANDE");
		}
		
		CategoriePizza categorie = CategoriePizza.valueOf(newCategoriePizza);
		
		if (dao.pizzaExists(nbCodePizza) != true){
			throw new UpdatePizzaException("Ce code n'existe pas");
		}
		Pizza modifPizza = new Pizza(newCodePizza, newNomPizza, newPrixPizza, categorie);
		
		try {
			modifPizza.rule();
		} catch (StockageException e) {
			throw new UpdatePizzaException("Un prix ne peut pas etre inférieur ou égale à 0€");
		}
		
		
		dao.updatePizza(nbCodePizza, modifPizza);
		
	}

}
