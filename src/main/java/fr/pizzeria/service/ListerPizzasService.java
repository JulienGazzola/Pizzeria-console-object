package fr.pizzeria.service;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.pizzeria.console.PizzeriaAdminConsoleApp;
import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.dao.PizzaMemDao;
import fr.pizzeria.model.Pizza;

public class ListerPizzasService extends MenuService{
	private static final Logger LOG = LoggerFactory.getLogger(PizzeriaAdminConsoleApp.class);
	
	public void executeUC(List<Pizza> listePizza, IPizzaDao dao, Scanner info){
		LOG.info("Liste des pizzas");
		Iterator iterator = listePizza.iterator();
		while (iterator.hasNext()){
			Pizza pizza = (Pizza) iterator.next();
			LOG.info(pizza.toString());
		}
	}
}
