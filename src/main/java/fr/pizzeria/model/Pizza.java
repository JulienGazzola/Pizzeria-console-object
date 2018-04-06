package fr.pizzeria.model;

import fr.pizzeria.exception.StockageException;
import fr.pizzeria.utils.RuleUtils;
import fr.pizzeria.utils.StringUtils;
import fr.pizzeria.utils.ToString;

public class		Pizza {
	private int 	id;
	
	@ToString(upperCase=true, separateCode = "-> ")
	private String	code;
	
	@ToString()
	private String 	libelle;
	
	@ToString(afterPrix = "€) ", beforePrix = "(")
	private double	prix;
	
	@ToString(beforeCategorie = ": ")
	private CategoriePizza categoriePizza;
	
	public Pizza(String code, String libelle, double prix, CategoriePizza categoriePizza){
		this.code = code;
		this.libelle = libelle;
		this.prix = prix;
		this.categoriePizza = categoriePizza;
	}
	public Pizza(int id, String code, String libelle, double prix, CategoriePizza categoriePizza){
		this.id = id;
		this.code = code;
		this.libelle = libelle;
		this.prix = prix;
		this.categoriePizza = categoriePizza;
	}
	
	public String toString() {
		StringUtils utils = new StringUtils();
		String chaine = utils.utils(this);
		return chaine;
	}
	
	public boolean rule() throws StockageException{
		RuleUtils utils = new RuleUtils();
		if (utils.ruleUtils(this)){
			return true;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((libelle == null) ? 0 : libelle.hashCode());
		long temp;
		temp = Double.doubleToLongBits(prix);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pizza other = (Pizza) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (libelle == null) {
			if (other.libelle != null)
				return false;
		} else if (!libelle.equals(other.libelle))
			return false;
		if (Double.doubleToLongBits(prix) != Double.doubleToLongBits(other.prix))
			return false;
		return true;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public CategoriePizza getCategoriePizza() {
		return categoriePizza;
	}
	public void setCategoriePizza(CategoriePizza categoriePizza) {
		this.categoriePizza = categoriePizza;
	}
}
