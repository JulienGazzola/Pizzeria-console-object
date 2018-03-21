package fr.pizzeria.console;

import fr.pizzeria.model.*;
import fr.pizzeria.dao.*;
import fr.pizzeria.service.*;

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
				ListerPizzasService lister = new ListerPizzasService();
				lister.executeUC(listePizza, dao);
				break;
				
			case 2:
				AjouterPizzaService ajout = new AjouterPizzaService();
				ajout.executeUC(listePizza, dao);
				break;
				
			case 3:
				ModifierPizzaService modif = new ModifierPizzaService();
				modif.executeUC(listePizza, dao);
				break;
				
			case 4:
				SupprimerPizzaService supp = new SupprimerPizzaService();
				supp.executeUC(listePizza, dao);
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
