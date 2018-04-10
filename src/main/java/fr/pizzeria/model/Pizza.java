package fr.pizzeria.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import fr.pizzeria.exception.StockageException;
import fr.pizzeria.utils.RuleUtils;
import fr.pizzeria.utils.StringUtils;
import fr.pizzeria.utils.ToString;

@Entity
@Table(name = "pizza")
public class Pizza {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "code", length = 10, nullable = false)
	@ToString(upperCase = true, separateCode = "-> ")
	private String code;

	@Column(name = "nom", length = 30, nullable = false)
	@ToString()
	private String libelle;

	@Column(name = "prix", nullable = false)
	@ToString(afterPrix = "€) ", beforePrix = "(")
	private double prix;

	@Enumerated(EnumType.STRING)
	@Column(name = "categorie", nullable = false)
	@ToString(beforeCategorie = ": ")
	private CategoriePizza categoriePizza;

	public Pizza(String code, String libelle, double prix, CategoriePizza categoriePizza) {
		this.code = code;
		this.libelle = libelle;
		this.prix = prix;
		this.categoriePizza = categoriePizza;
	}

	public Pizza(int id, String code, String libelle, double prix, CategoriePizza categoriePizza) {
		this.id = id;
		this.code = code;
		this.libelle = libelle;
		this.prix = prix;
		this.categoriePizza = categoriePizza;
	}
	
	public Pizza(){
		
	}

	public String toString() {
		StringUtils utils = new StringUtils();
		String chaine = utils.utils(this);
		return chaine;
	}

	public boolean rule() throws StockageException {
		RuleUtils utils = new RuleUtils();
		if (utils.ruleUtils(this)) {
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

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}

	/**
	 * @param libelle the libelle to set
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	/**
	 * @return the prix
	 */
	public double getPrix() {
		return prix;
	}

	/**
	 * @param prix the prix to set
	 */
	public void setPrix(double prix) {
		this.prix = prix;
	}

	/**
	 * @return the categoriePizza
	 */
	public CategoriePizza getCategoriePizza() {
		return categoriePizza;
	}

	/**
	 * @param categoriePizza the categoriePizza to set
	 */
	public void setCategoriePizza(CategoriePizza categoriePizza) {
		this.categoriePizza = categoriePizza;
	}


}
