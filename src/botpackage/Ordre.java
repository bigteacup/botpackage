package botpackage;



public class Ordre {
	
	private String nomOrdre;
	private int levelOrdre;
	private int nombreDemande;
	private int nombreDeClic;
	private String villageCible = "nompardefault";
	private String villageSource;
	private boolean vivant = true;
	private int totalRessourcesEnvoyees;
	int x = 0;
	int y = 0;



	public boolean getVivant() {
		return vivant;
	}


	public void setVivant(boolean vivant) {
		this.vivant = vivant;
	}


	public Ordre(String nomOrdre,int marchandsAlloues) {
		
	}
	public Ordre(int x ,int y) {
		this.x = x;
		this.y = y;
	}


	public Ordre() {
		
	}

	/*

		
	*/
	
	
	public int getX(){
		return x;
	}
	
	public void setX(int x){
		this.x = x; 
	}
	public int getY(){
		return y;
	}
	
	public void setY(int y){
		this.y = y; 
	}
	
	
	

	public int getTotalRessourcesEnvoyees(){
		return totalRessourcesEnvoyees;
	}
	
	public void setTotalRessourcesEnvoyees(int total){
		this.totalRessourcesEnvoyees = total; 
	}
	public void AjouterAuTotalDeRessourcesEnvoyees(int aAjouter){
		this.totalRessourcesEnvoyees = totalRessourcesEnvoyees+aAjouter;
		
	}
	public void SoustraireAuTotalDeRessourcesEnvoyees(int aSoustraire){
		this.totalRessourcesEnvoyees = totalRessourcesEnvoyees-aSoustraire;
	}
	
	
	public String getNomOrdre() {
		return nomOrdre;
	}


	public void setNomOrdre(String nomOrdre) {
		this.nomOrdre = nomOrdre;
	}


	public int getLevelOrdre() {
		return levelOrdre;
	}


	public void setLevelOrdre(int levelOrdre) {
		this.levelOrdre = levelOrdre;
	}


	public int getNombreDemande() {
		return nombreDemande;
	}


	public void setNombreDemande(int nombreDemande) {
		this.nombreDemande = nombreDemande;
	}


	public int getNombreDeClic() {
		return nombreDeClic;
	}


	public void setNombreDeClic(int nombreDeClic) {
		this.nombreDeClic = nombreDeClic;
	}


	public String getVillageCible() {
		return villageCible;
	}


	public void setVillageCible(String villageCible) {
		this.villageCible = villageCible;
	}


	public String getVillageSource() {
		return villageSource;
	}


	public void setVillageSource(String villageSource) {
		this.villageSource = villageSource;
	}



}