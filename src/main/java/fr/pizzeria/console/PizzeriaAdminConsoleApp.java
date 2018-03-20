package fr.pizzeria.console;

import fr.pizzeria.model.*;

import java.util.Arrays;
import java.util.Scanner;

public class 	PizzeriaAdminConsoleApp {
	
	public static void main(String[] args) {
		/*Pizza pépé = new Pizza(0, "PEP", "Pépérono", 12.50);*/
		Pizza[] arrayPizza = {
				new Pizza(0, "PEP", "Pépérono", 12.50),
				new Pizza(1, "MAR", "Margherita", 14.00),
				new Pizza(2, "REIN", "La Reine", 11.50),
				new Pizza(3, "FRO", "La 4 fromages", 12.00),
				new Pizza(4, "CAN", "La cannibale", 12.50),
				new Pizza(5, "SAV", "La savoyarde", 13.00),
				new Pizza(6, "ORI", "L'orientale", 13.50),
				new Pizza(7, "IND", "L'indienne", 14.00)
		};
		
		int tmp = 8;
		int nbChoice = 0;
		while(nbChoice != 99){
			System.out.println("** Pizzeria Administration\n"
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
				for (int i = 0; i < arrayPizza.length ;i++){
					System.out.println(arrayPizza[i].getCode() + " -> " 
				+ arrayPizza[i].getLibelle() + " ("
				+ arrayPizza[i].getPrix() + " €)");
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
				
				if (tmp < arrayPizza.length){
					arrayPizza[tmp] = new Pizza(nbCode, nbNom, nbPrix);
				}
				else {
					arrayPizza = Arrays.copyOf(arrayPizza, arrayPizza.length + 1);
					arrayPizza[tmp] = arrayPizza[tmp] = new Pizza(nbCode, nbNom, nbPrix);
				}
				tmp++;
				
				break;
			case 3:
				System.out.println("Mise à jour d'une pizza");
				for (int i = 0; i < arrayPizza.length ;i++){
					System.out.println(arrayPizza[i].getCode() + " -> " 
				+ arrayPizza[i].getLibelle() + " ("
				+ arrayPizza[i].getPrix() + " €)");
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
				
				for (int i = 0; i < arrayPizza.length ;i++){
					if (arrayPizza[i].getCode().contentEquals(nbCodePizza)){
						arrayPizza[i].setCode(newCodePizza2);
						arrayPizza[i].setLibelle(newNomPizza2);
						arrayPizza[i].setPrix(newPrixPizza2);
					}
				}
				break;
			case 4:
				
				System.out.println("Suppression d'une pizza");
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
