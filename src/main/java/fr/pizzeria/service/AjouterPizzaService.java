package fr.pizzeria.service;

import java.util.List;
import java.util.Scanner;

import fr.pizzeria.model.Pizza;
import fr.pizzeria.dao.*;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.UpdatePizzaException;

public class AjouterPizzaService extends MenuService{
	public void executeUC(List<Pizza> listePizza, PizzaMemDao dao) throws SavePizzaException{
		System.out.println("Ajout d'une nouvelle pizza\n"
				+ "Veuillez saisir le code : ");
		Scanner info = new Scanner(System.in);
		String nbCode = info.next();
		System.out.println("Veuillez saisir le nom (sans espace) : ");
		String nbNom = info.next();
		System.out.println("Veuillez saisir le prix : ");
		double nbPrix = info.nextDouble();
		
		if (nbPrix < 0){
			throw new SavePizzaException("Un prix ne peut pas etre inférieur ou égale à 0€");
		}
		if (dao.pizzaExists(nbCode) == true){
			throw new SavePizzaException("La pizza existe déjà");
		}
		
		Pizza newPizza = new Pizza(nbCode, nbNom, nbPrix);
		dao.saveNewPizza(newPizza);
	}
}
