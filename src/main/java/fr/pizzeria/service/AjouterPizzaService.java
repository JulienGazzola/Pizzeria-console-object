package fr.pizzeria.service;

import java.util.List;
import java.util.Scanner;

import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.dao.*;
import fr.pizzeria.exception.*;

public class AjouterPizzaService extends MenuService{
	public void executeUC(List<Pizza> listePizza, PizzaMemDao dao, Scanner info) throws SavePizzaException{
		System.out.println("Ajout d'une nouvelle pizza\n"
				+ "Veuillez saisir le code : ");
		String nbCode = info.next();
		System.out.println("Veuillez saisir le nom (sans espace) : ");
		String nbNom = info.next();
		System.out.println("Veuillez saisir le prix : ");
		double nbPrix = info.nextDouble();
		System.out.println("Veuillez saisir la catégorie de la pizza");
		String categoriePizza = info.next();
		
		if (!CategoriePizza.exists(categoriePizza)){
			throw new SavePizzaException("Mauvais nom de catégorie : VIANDE | POISSON | SANS_VIANDE");
		}
		CategoriePizza categorie = CategoriePizza.valueOf(categoriePizza);
		
		if (nbPrix < 0){
			throw new SavePizzaException("Un prix ne peut pas etre inférieur ou égale à 0€");
		}
		if (dao.pizzaExists(nbCode) == true){
			throw new SavePizzaException("La pizza existe déjà");
		}
		
		Pizza newPizza = new Pizza(nbCode, nbNom, nbPrix, categorie);
		dao.saveNewPizza(newPizza);
	}
}
