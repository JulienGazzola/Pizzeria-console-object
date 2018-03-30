package fr.pizzeria.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class PizzaMemDaoTest {

	@Test
	public void testFindAllPizzas(){
		PizzaMemDao pmd = new PizzaMemDao();
		List<Pizza> listPizza = new ArrayList<Pizza>();
		
		listPizza = pmd.findAllPizzas();
		assertNotNull(listPizza);
	}
	
	@Test
	public void testSaveNewPizza() {
		PizzaMemDao pmd = new PizzaMemDao();
		Pizza pizza = new Pizza(1, "TEST", "Test", 10.0, CategoriePizza.VIANDE);
		List<Pizza> listePizza = new ArrayList<Pizza>();

		listePizza = pmd.findAllPizzas();
		int size = listePizza.size();
		pmd.saveNewPizza(pizza);
		int newSize = listePizza.size();
		assertTrue(size == newSize - 1);
	}

	@Test
	public void testSaveNewPizza2() {
		PizzaMemDao pmd = new PizzaMemDao();
		Pizza pizza = new Pizza(0, null, null, 0, null);
		List<Pizza> listePizza = new ArrayList<Pizza>();

		listePizza = pmd.findAllPizzas();
		int size = listePizza.size();
		pmd.saveNewPizza(pizza);
		int newSize = listePizza.size();
		assertTrue(size == newSize - 1);
	}

	@Test
	public void testSaveNewPizza3() {
		PizzaMemDao pmd = new PizzaMemDao();
		Pizza pizza = null;
		List<Pizza> listePizza = new ArrayList<Pizza>();

		listePizza = pmd.findAllPizzas();
		int size = listePizza.size();
		pmd.saveNewPizza(pizza);
		int newSize = listePizza.size();
		assertTrue(size == newSize);
	}

	@Test
	public void testFindPizzaByCode() {
		PizzaMemDao pmd = new PizzaMemDao();
		
		Pizza pizza = pmd.findPizzaByCode("PEP");
		assertEquals("PEP", pizza.getCode());
	}
	
	@Test
	public void testFindPizzaByCode2() {
		PizzaMemDao pmd = new PizzaMemDao();
		
		Pizza pizza = pmd.findPizzaByCode(null);
		assertTrue(pizza == null);
	}
	
	@Test
	public void testPizzaExists(){
		PizzaMemDao pmd = new PizzaMemDao();
		
		boolean test = pmd.pizzaExists("PEP");
		assertTrue(test);
	}
	
	@Test
	public void testPizzaExists2(){
		PizzaMemDao pmd = new PizzaMemDao();
		
		boolean test = pmd.pizzaExists(null);
		assertFalse(test);
	}
	
	@Test
	public void testDeletePizza(){
		PizzaMemDao pmd = new PizzaMemDao();
		List<Pizza> listePizza = new ArrayList<Pizza>();
		
		listePizza = pmd.findAllPizzas();
		int size = listePizza.size();
		pmd.deletePizza("MAR");
		int newSize = listePizza.size();
		assertTrue(size - 1 == newSize);
	}
	
	@Test
	public void testDeletePizza2(){
		PizzaMemDao pmd = new PizzaMemDao();
		List<Pizza> listePizza = new ArrayList<Pizza>();
		
		listePizza = pmd.findAllPizzas();
		int size = listePizza.size();
		pmd.deletePizza(null);
		int newSize = listePizza.size();
		assertTrue(size == newSize);
	}
	
	@Test
	public void testUpdatePizza(){
		PizzaMemDao pmd = new PizzaMemDao();
		List<Pizza> listePizza = new ArrayList<Pizza>();
		Pizza pizza = new Pizza(1, "TEST", "Test", 10.0, CategoriePizza.VIANDE);
		
		listePizza = pmd.findAllPizzas();
		int size = listePizza.size();
		pmd.updatePizza("FRO", pizza);
		int newSize = listePizza.size();
		Pizza pizza2 = pmd.findPizzaByCode("TEST");
		
		assertTrue(size == newSize);
		assertEquals("TEST", pizza2.getCode());
		assertEquals("Test", pizza2.getLibelle());
		assertTrue(10.0 == pizza2.getPrix());
		assertEquals(CategoriePizza.VIANDE, pizza2.getCategoriePizza());
	}
	
	@Test
	public void testUpdatePizza2(){
		PizzaMemDao pmd = new PizzaMemDao();
		List<Pizza> listePizza = new ArrayList<Pizza>();
		Pizza pizza = null;
		
		listePizza = pmd.findAllPizzas();
		int size = listePizza.size();
		Pizza pizza2 = pmd.findPizzaByCode("CAN");
		pmd.updatePizza("CAN", pizza);
		int newSize = listePizza.size();
		Pizza pizza3 = pmd.findPizzaByCode("CAN");
		
		assertTrue(size == newSize);
		assertTrue(pizza2.getCode() == pizza3.getCode());
		assertTrue(pizza2.getLibelle() == pizza3.getLibelle());
		assertTrue(pizza2.getPrix() == pizza3.getPrix());
		assertTrue(pizza2.getCategoriePizza() == pizza3.getCategoriePizza());
	}
	
	@Test
	public void testUpdatePizza3(){
		PizzaMemDao pmd = new PizzaMemDao();
		List<Pizza> listePizza = new ArrayList<Pizza>();
		Pizza pizza = new Pizza(1, "TEST", "Test", 10.0, CategoriePizza.VIANDE);
		
		listePizza = pmd.findAllPizzas();
		int size = listePizza.size();
		pmd.updatePizza("TOTO", pizza);
		int newSize = listePizza.size();
		Pizza pizza2 = pmd.findPizzaByCode("TEST");
		
		assertTrue(size == newSize);
		assertTrue(pizza2 == null);
	}
}
