package fr.pizzeria.service;

import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.console.PizzeriaAdminConsoleApp;
import fr.pizzeria.dao.*;
import fr.pizzeria.exception.*;
import fr.pizzeria.logger.AppService;

public class AjouterPizzaService extends MenuService{
	private static final Logger LOG = LoggerFactory.getLogger(PizzeriaAdminConsoleApp.class);
	
	public void executeUC(List<Pizza> listePizza, PizzaMemDao dao, Scanner info) throws SavePizzaException{
		LOG.info("Ajout d'une nouvelle pizza\n" + "Veuillez saisir le code : ");
		String nbCode = info.next();
		LOG.info("Veuillez saisir le nom (sans espace) : ");
		String nbNom = info.next();
		LOG.info("Veuillez saisir le prix : ");
		double nbPrix = info.nextDouble();
		LOG.info("Veuillez saisir la catégorie de la pizza");
		String categoriePizza = info.next();
		
		if (!CategoriePizza.exists(categoriePizza)){
			throw new SavePizzaException("Mauvais nom de catégorie : VIANDE | POISSON | SANS_VIANDE");
		}
		CategoriePizza categorie = CategoriePizza.valueOf(categoriePizza);
		
		
		if (dao.pizzaExists(nbCode) == true){
			throw new SavePizzaException("La pizza existe déjà");
		}
		
		Pizza newPizza = new Pizza(nbCode, nbNom, nbPrix, categorie);
		try {
			newPizza.rule();
		} catch (StockageException e) {
			new AppService().executer(e.getMessage());
		}
		dao.saveNewPizza(newPizza);
	}
}
