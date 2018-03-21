package fr.pizzeria.console;

import fr.pizzeria.model.*;
import fr.pizzeria.dao.*;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.service.*;

import java.util.Scanner;
import java.util.List;

public class 	PizzeriaAdminConsoleApp{
	
	public static void main(String[] args) {
		
		int nbChoice = 0;
		PizzaMemDao dao = new PizzaMemDao();
		List<Pizza> listePizza = dao.findAllPizzas();
		Scanner info = new Scanner(System.in);
		
		while(nbChoice != 99){
			System.out.println("** Pizzeria Administration **\n"
					+ "1. Lister les pizza\n"
					+ "2. Ajouter une nouvelle pizza\n"
					+ "3. Mette à jour une pizza\n"
					+ "4. Supprimer une pizza\n"
					+ "99. Sortir");
			
			nbChoice = info.nextInt();
			if (nbChoice != 99){
				MenuService service = MenuServiceFactory.getInstance(nbChoice);
				try {
					service.executeUC(listePizza, dao, info);
				} catch (StockageException e1) {
					System.out.println(e1.getMessage());
				}
			}
			else{
				System.out.println("Aurevoir ☹");
			}
		}
		
	}
}
