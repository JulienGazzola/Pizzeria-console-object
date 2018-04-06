package fr.pizzeria.console;

import fr.pizzeria.model.*;
import fr.pizzeria.dao.*;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.service.*;

import fr.pizzeria.logger.AppService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;
import java.util.List;

public class PizzeriaAdminConsoleApp {
	private static final Logger LOG = LoggerFactory.getLogger(PizzeriaAdminConsoleApp.class);

	public static void main(String[] args) {

		int nbChoice = 0;
		IPizzaDao dao = new PizzaDataBase();
		Scanner info = new Scanner(System.in);

		while (nbChoice != 99) {
			LOG.info("** Pizzeria Administration **\n" + "1. Lister les pizza\n" + "2. Ajouter une nouvelle pizza\n"
					+ "3. Mette à jour une pizza\n" + "4. Supprimer une pizza\n" + "99. Sortir");
			nbChoice = info.nextInt();
			if (nbChoice != 99) {
				List<Pizza> listePizza = dao.findAllPizzas();
				MenuService service = MenuServiceFactory.getInstance(nbChoice);
				try {
					service.executeUC(listePizza, dao, info);
				} catch (StockageException e1) {
					e1.printStackTrace();
					new AppService().executer(e1.getMessage());
				}

			} else {
				LOG.info("Aurevoir ☹");
			}
		}
	}
}
