package fr.pizzeria.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import fr.pizzeria.model.Pizza;

public class PizzaJpaBase implements IPizzaDao {
	static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pizza");

	@Override
	public List<Pizza> findAllPizzas() {
		EntityManager em = entityManagerFactory.createEntityManager();

		TypedQuery<Pizza> query = em.createQuery("SELECT p FROM Pizza p", Pizza.class);
		List<Pizza> pizza = query.getResultList();
		if (pizza.isEmpty()) {
			em.close();
			return null;
		}
		em.close();
		return pizza;
	}

	@Override
	public void saveNewPizza(Pizza pizza) {
		EntityManager em = entityManagerFactory.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();

		em.persist(pizza);

		et.commit();
		em.close();
	}

	@Override
	public void updatePizza(String codePizza, Pizza pizza) {
		EntityManager em = entityManagerFactory.createEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();

		Pizza pizza2 = findPizzaByCode(codePizza);
		pizza2.setCode(pizza.getCode());
		pizza2.setLibelle(pizza.getLibelle());
		pizza2.setPrix(pizza.getPrix());
		pizza2.setCategoriePizza(pizza.getCategoriePizza());

		et.commit();
		em.close();
	}

	@Override
	public void deletePizza(String codePizza) {
		EntityManager em = entityManagerFactory.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Pizza pizza = findPizzaByCode(codePizza);

		et.begin();
		em.remove(pizza);
		et.commit();
		em.close();
	}

	@Override
	public Pizza findPizzaByCode(String codePizza) {
		EntityManager em = entityManagerFactory.createEntityManager();

		TypedQuery<Pizza> query = em.createQuery("SELECT p FROM Pizza p WHERE p.code = :code", Pizza.class);
		query.setParameter("code", codePizza);

		Pizza pizza = query.getSingleResult();

		em.close();
		return pizza;
	}

	@Override
	public boolean pizzaExists(String codePizza) {
		EntityManager em = entityManagerFactory.createEntityManager();

		TypedQuery<Pizza> query = em.createQuery("SELECT p FROM Pizza p WHERE p.code = :code",
				Pizza.class);
		query.setParameter("code", codePizza);
		List<Pizza> pizza = query.getResultList();
		if (pizza.isEmpty()) {
			em.close();
			return false;
		}
		em.close();
		return true;
	}

}
