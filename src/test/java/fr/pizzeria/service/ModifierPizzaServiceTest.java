package fr.pizzeria.service;

import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;
import org.mockito.Mockito;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.Pizza;


public class ModifierPizzaServiceTest {
	
	@Rule
	public TextFromStandardInputStream systemInMock = emptyStandardInputStream();
	
	@Test(expected=UpdatePizzaException.class)
	public void testModifierPizzaService() throws UpdatePizzaException{
		
		IPizzaDao mockedDao = Mockito.mock(IPizzaDao.class);
		List<Pizza> listePizza = new ArrayList<Pizza>();
		Scanner info = new Scanner(System.in);

		Mockito.when(mockedDao.pizzaExists(Mockito.anyString())).thenReturn(false);
		systemInMock.provideLines("PEP", "test", "test", "10.0", "VIANDE");
		
		ModifierPizzaService mps = new ModifierPizzaService();
		mps.executeUC(listePizza, mockedDao, info);
	}

}
