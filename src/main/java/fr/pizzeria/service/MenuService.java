package fr.pizzeria.service;

import java.util.List;
import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.dao.PizzaMemDao;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.Pizza;

public abstract class MenuService {
	public abstract void executeUC(List<Pizza> listePizza, IPizzaDao dao, Scanner info) throws StockageException;
}
