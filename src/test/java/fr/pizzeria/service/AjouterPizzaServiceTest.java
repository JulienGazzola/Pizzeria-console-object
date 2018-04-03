package fr.pizzeria.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;
import org.mockito.Mockito;

import static org.junit.Assert.assertTrue;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.*;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.dao.PizzaMemDao;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.model.Pizza;

public class AjouterPizzaServiceTest {
	
	@Rule
	public TextFromStandardInputStream systemInMock = emptyStandardInputStream();
	
	@Test
	public void testExecuteUC() throws SavePizzaException{
		
		AjouterPizzaService aps = new AjouterPizzaService();
		List<Pizza> listePizza = new ArrayList<Pizza>();
		IPizzaDao mockedDao = Mockito.mock(IPizzaDao.class);
		
		Mockito.when(mockedDao.pizzaExists(Mockito.anyString())).thenReturn(false);
		systemInMock.provideLines("TEST", "test", "10.0", "VIANDE");
		Scanner info = new Scanner(System.in);
		
		aps.executeUC(listePizza, mockedDao, info);
		
	}
	
	@Test
	public void testExecuteUC2() throws SavePizzaException{
		AjouterPizzaService aps = new AjouterPizzaService();
		List<Pizza> listePizza = new ArrayList<Pizza>();
		PizzaMemDao dao = new PizzaMemDao();
		
		systemInMock.provideLines("TEST", "test", "10.0", "VIANDE");
		Scanner info = new Scanner(System.in);

		int size = dao.findAllPizzas().size();
		aps.executeUC(listePizza, dao, info);
		assertTrue(size == dao.findAllPizzas().size() - 1);
		
	}

}
