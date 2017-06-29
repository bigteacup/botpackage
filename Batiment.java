package botpackage;

public class Batiment {
	
private String nomBatiment;
private int levelBatiment;
private String slotBatiment;
private String lienBatiment;
private String alt;
private int nombrePresent = 0 ;
private boolean present = false ;


public boolean getPresent() {
	return present;
}
public void setPresent(boolean present) {
	this.present = present;
}
public int getNombrePresent() {
	return nombrePresent;
}
public void setNombrePresent(int nombrePresent) {
	this.nombrePresent = nombrePresent;
}
public String getNomBatiment() {
	return nomBatiment;
}
public void setNomBatiment(String nomBatiment) {
	this.nomBatiment = nomBatiment ;
}



public int getLevelBatiment() {
	return levelBatiment;
}
public void setLevelBatiment(int levelBatiment){
	this.levelBatiment = levelBatiment;
}

public String getSlotBatiment() {
	return slotBatiment;
}
public void setSlotBatiment(String slotBatiment){
	this.slotBatiment = slotBatiment;
}

public String getAlt() {
	return alt;
}
public void setAlt(String alt) {
	this.alt = alt;
}




public String getLienBatiment() {
	return lienBatiment;
}
public void setLienBatiment(String lienBatiment) {
	this.lienBatiment = lienBatiment;
}





//// Les constructeurs
public Batiment(String nomBatiment, int levelBatiment, String slotBatiment, String alt) {
	this.nomBatiment = nomBatiment;
	this.levelBatiment = levelBatiment;
	this.slotBatiment = slotBatiment;
	this.alt = alt;
}


public Batiment(String nomBatiment, int levelBatiment, String slotBatiment) {
	this.nomBatiment = nomBatiment;
	this.levelBatiment = levelBatiment;
	this.slotBatiment = slotBatiment;
}



public Batiment (String nomBatiment, int levelBatiment){
	this.nomBatiment = nomBatiment;
	this.levelBatiment = levelBatiment;
	
	
}




public Batiment() {
	
	
	
}






}
