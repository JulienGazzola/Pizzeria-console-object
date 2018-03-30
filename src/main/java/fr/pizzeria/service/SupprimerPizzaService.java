package fr.pizzeria.service;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.pizzeria.console.PizzeriaAdminConsoleApp;
import fr.pizzeria.dao.PizzaMemDao;
import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.Pizza;

public class SupprimerPizzaService extends MenuService{
	private static final Logger LOG = LoggerFactory.getLogger(PizzeriaAdminConsoleApp.class);
	
	public void executeUC(List<Pizza> listePizza, PizzaMemDao dao, Scanner info) throws DeletePizzaException{
		LOG.info("Suppression d'une pizza");
		Iterator iterator = listePizza.iterator();
		while (iterator.hasNext()){
			Pizza pizza = (Pizza) iterator.next();
			LOG.info(pizza.getCode() + " -> "
					+ pizza.getLibelle() + " ("
					+ pizza.getPrix() + " €)");
		}
		LOG.info("Veuillez choisir le code de la pizza à supprimer");
		String nbCodePizza = info.next();
		
		if (dao.pizzaExists(nbCodePizza) != true){
			throw new DeletePizzaException("Ce code n'existe pas");
		}
		
		dao.deletePizza(nbCodePizza);
	}
}
