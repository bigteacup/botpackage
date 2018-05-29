package botpackage;

public class RouteDeCommerce {

	public RouteDeCommerce() {

	}

	public static void main(String[] args) {


	}
	
	
	
	
	
	public int getHeureDepart() {
		return heureDepart;
	}

	public void setHeureDepart(int heureDepart) {
		this.heureDepart = heureDepart;
	}

	public String getCible() {
		return cible;
	}

	public void setCible(String cible) {
		this.cible = cible;
	}

	public Village getSource() {
		return source;
	}

	public void setSource(Village source) {
		this.source = source;
	}

	public int getNbreLivraison() {
		return nbreLivraison;
	}

	public void setNbreLivraison(int nbreLivraison) {
		this.nbreLivraison = nbreLivraison;
	}

	public int getBois() {
		return bois;
	}

	public void setBois(int bois) {
		this.bois = bois;
	}

	public int getArgile() {
		return argile;
	}

	public void setArgile(int argile) {
		this.argile = argile;
	}

	public int getFer() {
		return fer;
	}

	public void setFer(int fer) {
		this.fer = fer;
	}

	public int getCereales() {
		return cereales;
	}

	public void setCereales(int cereales) {
		this.cereales = cereales;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	public int getIncrement() {
		return increment;
	}

	public void setIncrement(int increment) {
		this.increment = increment;
	}



	public int getRepetition() {
		return repetition;
	}

	public void setRepetition(int repetition) {
		this.repetition = repetition;
	}

	int heureDepart = 0;
	int increment = 2;
	int repetition = 12 ;
	


	String cible = null;
	Village source = null;
	int nbreLivraison = 1;
	int bois = 0;
	int argile = 0;
	int fer = 0;
	int cereales = 0;
	
	boolean active = true;
	
}
