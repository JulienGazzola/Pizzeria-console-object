package fr.pizzeria.console;

import fr.pizzeria.model.*;
import java.util.Scanner;

public class 	PizzeriaAdminConsoleApp {
	
	public static void main(String[] args) {
		
		
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
				break;
			case 2:
				System.out.println("Ajout d'une nouvelle pizza");
				break;
			case 3:
				System.out.println("Mise à jour d'une pizza");
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
