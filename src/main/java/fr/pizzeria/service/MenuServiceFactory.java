package fr.pizzeria.service;

public class MenuServiceFactory {
	public static MenuService getInstance(int i){
		switch (i){
		case 1 :
			return new ListerPizzasService();
		case 2 :
			return new AjouterPizzaService();
		case 3 :
			return new ModifierPizzaService();
		case 4 :
			return new SupprimerPizzaService();
		}
		return null;
	}
}
