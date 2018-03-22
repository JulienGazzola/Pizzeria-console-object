package fr.pizzeria.utils;

import java.lang.reflect.Field;

import fr.pizzeria.model.Pizza;


public class StringUtils {
	
	public String utils(Pizza cl){
		String chaine = "";
		
		// recupère la liste des attributs de la classe
				Field[] attributs = cl.getClass().getDeclaredFields();
				
				// boucle sur les attributs
				for (Field attr: attributs){
					attr.setAccessible(true);
					// vérifie si l'annotation est présente sur l'attribut
					if (attr.isAnnotationPresent(ToString.class)){
						try {
							// récupère l'annotation toString
								ToString annotation = attr.getAnnotation(ToString.class);
									
							// récupère la valeur de la propriété toUpperCase de l'annotation
								boolean uppercase = annotation.upperCase();
								
							// récupère la valeur de la propriété prix de l'annotation
								String afterPrix = annotation.afterPrix();
								String beforePrix = annotation.beforePrix();
								
							String code = annotation.separateCode();
							String beforeCategorie = annotation.beforeCategorie();
							String afterCategorie = annotation.afterCategorie();

							// récupère la valeur de l'attribut pour l'instance courante
								Object value = attr.get(cl);
							
							
								
							String valueStr  = value.toString();
							if (uppercase){
								valueStr = valueStr.toUpperCase();
							}
								
							chaine += beforePrix + beforeCategorie + valueStr + " " 
							+ afterPrix + code + afterCategorie;
						} catch (IllegalArgumentException e) {
							e.printStackTrace();
						} catch (IllegalAccessException e) {
							e.printStackTrace();
						}
					}
				}
		
		return chaine; 
	}

}
