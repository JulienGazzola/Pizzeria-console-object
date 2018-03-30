package fr.pizzeria.service;

import fr.pizzeria.exception.*;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.pizzeria.console.PizzeriaAdminConsoleApp;
import fr.pizzeria.dao.PizzaMemDao;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class ModifierPizzaService extends MenuService{
	private static final Logger LOG = LoggerFactory.getLogger(PizzeriaAdminConsoleApp.class);
	
	public void executeUC(List<Pizza> listePizza, PizzaMemDao dao, Scanner info) throws UpdatePizzaException{
		LOG.info("Mise à jour d'une pizza");
		Iterator iterator = listePizza.iterator();
		while (iterator.hasNext()){
			Pizza pizza = (Pizza) iterator.next();
			LOG.info(pizza.getCode() + " -> "
					+ pizza.getLibelle() + " ("
					+ pizza.getPrix() + " €)");
		}
		
		LOG.info("Veuillez saisir le code de la pizza à modifier : ");
		String nbCodePizza = info.next();
		LOG.info("Veuillez saisir le nouveau code : ");
		String newCodePizza = info.next();
		LOG.info("Veuillez saisir le nouveau nom (sans espace) : ");
		String newNomPizza = info.next();
		LOG.info("Veuillez saisir le nouveau prix : ");
		double newPrixPizza = info.nextDouble();
		LOG.info("Veuillez saisir la catégorie de pizza : ");
		String newCategoriePizza = info.next();
		
		if (!CategoriePizza.exists(newCategoriePizza)){
			throw new UpdatePizzaException("Mauvais nom de catégorie : VIANDE | POISSON | SANS_VIANDE");
		}
		
		CategoriePizza categorie = CategoriePizza.valueOf(newCategoriePizza);
		
		if (dao.pizzaExists(nbCodePizza) != true){
			throw new UpdatePizzaException("Ce code n'existe pas");
		}
		Pizza modifPizza = new Pizza(newCodePizza, newNomPizza, newPrixPizza, categorie);
		
		try {
			modifPizza.rule();
		} catch (StockageException e) {
			LOG.info(e.getMessage());
		}
		
		
		dao.updatePizza(nbCodePizza, modifPizza);
		
	}

}
