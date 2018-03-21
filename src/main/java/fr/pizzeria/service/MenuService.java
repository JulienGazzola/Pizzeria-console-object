package fr.pizzeria.service;

import java.util.List;

import fr.pizzeria.dao.PizzaMemDao;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.Pizza;

public abstract class MenuService {
	public abstract void executeUC(List<Pizza> listePizza, PizzaMemDao dao) throws StockageException;
}
