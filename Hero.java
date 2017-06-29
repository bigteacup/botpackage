package botpackage;

public class Hero {
	public int getVie() {
		return vie;
	}
	public String getModeProduction() {
		return modeProduction;
	}
	public String getVillageAffecte() {
		return villageAffecte;
	}
	public void setVie(int vie) {
		this.vie = vie;
	}
	public void setModeProduction(String modeProduction) {
		this.modeProduction = modeProduction;
	}
	public void setVillageAffecte(String villageAffecte) {
		this.villageAffecte = villageAffecte;
	}
	private int vie;
	private String modeProduction="reglagepardefault"; //bug si je le laisse en vide, NULL fait buguer le if
	private String villageAffecte;
	

}
