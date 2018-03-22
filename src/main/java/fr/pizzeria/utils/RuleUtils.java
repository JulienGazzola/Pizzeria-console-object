package fr.pizzeria.utils;

import java.lang.reflect.Field;

import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.Pizza;

public class RuleUtils {

	public boolean ruleUtils(Pizza cl) throws StockageException {

		// recupère la liste des attributs de la classe
		Field[] attributs = cl.getClass().getDeclaredFields();

		// boucle sur les attributs
		for (Field attr : attributs) {
			// autorise utilisation variable private
			attr.setAccessible(true);
			// vérifie si l'annotation est présente sur l'attribut
			if (attr.isAnnotationPresent(Rule.class)) {
				try {
					// récupère l'annotation rule
					Rule annotation = attr.getAnnotation(Rule.class);
					double prixMin = annotation.prixMin();

					// récupère la valeur de l'attribut pour l'instance courante
					Object value = attr.get(cl);

					if (value instanceof Double) {
						double prix = (Double)value;
						if (prix <= prixMin) {
							throw new StockageException("Error");
						}
					}

				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}

		return true;
	}
}
