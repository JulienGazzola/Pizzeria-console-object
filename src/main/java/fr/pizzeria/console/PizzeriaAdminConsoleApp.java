package fr.pizzeria.console;

import fr.pizzeria.model.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;
import java.util.List;

public class 	PizzeriaAdminConsoleApp {
	
	public static void main(String[] args) {
		
		List<Pizza> listePizza = new ArrayList<Pizza>();
		listePizza.add(new Pizza(0, "PEP", "Pépérono", 12.50));
		listePizza.add(new Pizza(1, "MAR", "Margherita", 14.00));
		listePizza.add(new Pizza(2, "REIN", "La Reine", 11.50));
		listePizza.add(new Pizza(3, "FRO", "La 4 fromages", 12.00));
		listePizza.add(new Pizza(4, "CAN", "La cannibale", 12.50));
		listePizza.add(new Pizza(5, "SAV", "La savoyarde", 13.00));
		listePizza.add(new Pizza(6, "ORI", "L'orientale", 13.50));
		listePizza.add(new Pizza(7, "IND", "L'indienne", 14.00));
		
		int nbChoice = 0;
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
				
				listePizza.add(new Pizza(nbCode, nbNom, nbPrix));
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
				
				iterator = listePizza.iterator();
				while (iterator.hasNext()){
					Pizza pizza = (Pizza) iterator.next();
					if (pizza.getCode().contentEquals(nbCodePizza)){
						pizza.setCode(newCodePizza2);
						pizza.setLibelle(newNomPizza2);
						pizza.setPrix(newPrixPizza2);
					}
				}
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
				
				iterator = listePizza.iterator();
				while (iterator.hasNext()){
					Pizza pizza = (Pizza) iterator.next();
					if (pizza.getCode().equals(nbCodePizzaSupp)){
						listePizza.remove(pizza);
						break;
					}
				}
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
