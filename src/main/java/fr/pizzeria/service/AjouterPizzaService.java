package fr.pizzeria.service;

import java.util.List;
import java.util.Scanner;

import fr.pizzeria.model.Pizza;
import fr.pizzeria.dao.*;

public class AjouterPizzaService {
	public void executeUC(List<Pizza> listePizza, PizzaMemDao dao){
		System.out.println("Ajout d'une nouvelle pizza\n"
				+ "Veuillez saisir le code : ");
		Scanner newCode = new Scanner(System.in);
		String nbCode = newCode.next();
		System.out.println("Veuillez saisir le nom (sans espace) : ");
		Scanner newNom = new Scanner(System.in);
		String nbNom = newNom.next();
		System.out.println("Veuillez saisir le prix : ");
		Scanner newPrix = new Scanner(System.in);
		double nbPrix = newPrix.nextDouble();
		
		Pizza newPizza = new Pizza(nbCode, nbNom, nbPrix);
		dao.saveNewPizza(newPizza);
	}

}
