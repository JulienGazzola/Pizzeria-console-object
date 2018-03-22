package fr.pizzeria.model;

public enum CategoriePizza {
	VIANDE("Viande"),
	POISSON("Poisson"),
	SANS_VIANDE("SansViande");
	
	private String categorie;

	private CategoriePizza(String categorie) {
		this.categorie = categorie;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	
	public static boolean exists(String chaine){
		CategoriePizza[] categs = values();
		
		for(int i = 0; i < categs.length; i++){
			if (categs[i].name().equals(chaine)){
				return true;
			}
		}
		return false;
	}
	
	public String toString(){
		return categorie;
	}
	
}
