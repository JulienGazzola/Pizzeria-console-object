package fr.pizzeria.console;

import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.dao.PizzaDataBase;
import fr.pizzeria.dao.PizzaJpaBase;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.logger.AppService;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.service.MenuService;
import fr.pizzeria.service.MenuServiceFactory;

/** Représente l'executable de l'application */
public class PizzeriaAdminConsoleApp {
	
	/** Logger pour faire les affichages */
	private static final Logger LOG = LoggerFactory.getLogger(PizzeriaAdminConsoleApp.class);

	/** Main méthode
	 * 
	 * @param args
	 * Lance le scanner
	 * Quitte l'application
	 */
	public static void main(String[] args) {

		int nbChoice = 0;
		IPizzaDao dao = new PizzaJpaBase();
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
