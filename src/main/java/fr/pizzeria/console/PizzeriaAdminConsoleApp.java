package fr.pizzeria.console;

import fr.pizzeria.model.*;
import fr.pizzeria.dao.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;
import java.util.List;

public class 	PizzeriaAdminConsoleApp{
	
	public static void main(String[] args) {
		
		int nbChoice = 0;
		PizzaMemDao dao = new PizzaMemDao();
		List<Pizza> listePizza = dao.findAllPizzas();
		
		while(nbChoice != 99){
			System.out.println("** Pizzeria Administration **\n"
					+ "1. Lister les pizza\n"
					+ "2. Ajouter une nouvelle pizza\n"
					+ "3. Mette à jour une pizza\n"
					+ "4. Supprimer une pizza\n"
					+ "99. Sortir");
			Scanner choice = new Scanner(System.in);
			nbChoice = choice.nextInt();
			switch (nbChoice){
			case 1:
				System.out.println("Liste des pizzas");
				Iterator iterator = listePizza.iterator();
				while (iterator.hasNext()){
					Pizza pizza = (Pizza) iterator.next();
					System.out.println(pizza.getCode() + " -> "
							+ pizza.getLibelle() + " ("
							+ pizza.getPrix() + " €)");
				}
				break;
				
			case 2:
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
				break;
				
			case 3:
				System.out.println("Mise à jour d'une pizza");
				iterator = listePizza.iterator();
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
				
				break;
			case 4:
				System.out.println("Suppression d'une pizza");
				iterator = listePizza.iterator();
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
				break;
				
			case 99:
				System.out.println("Aurevoir ☹");
				break;
			default:
				continue;
			}
			
		}
		
	}
}
