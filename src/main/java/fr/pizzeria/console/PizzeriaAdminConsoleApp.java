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
		MenuService lister = new ListerPizzasService();
		MenuService ajout = new AjouterPizzaService();
		MenuService modif = new ModifierPizzaService();
		MenuService supp = new SupprimerPizzaService();
		Scanner choice = new Scanner(System.in);
		
		while(nbChoice != 99){
			System.out.println("** Pizzeria Administration **\n"
					+ "1. Lister les pizza\n"
					+ "2. Ajouter une nouvelle pizza\n"
					+ "3. Mette à jour une pizza\n"
					+ "4. Supprimer une pizza\n"
					+ "99. Sortir");
			
			nbChoice = choice.nextInt();
			switch (nbChoice){
			case 1:
				lister.executeUC(listePizza, dao);
				break;
			case 2:
				ajout.executeUC(listePizza, dao);
				break;
			case 3:
				modif.executeUC(listePizza, dao);
				break;
			case 4:
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
