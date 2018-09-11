package botpackage;

import java.util.ArrayList;

public class Batiment {
	
private String nomBatiment;
private int levelBatiment;
public int typeChampsOuBatiment; // 0 == champs    // 1== Batiments



private String slotBatiment;
private String lienBatiment;
private String alt;
private int nombrePresent = 0 ;
private boolean present = false ;
public ArrayList<Batiment> prerequisBatiment = new ArrayList<Batiment>();
public ArrayList<Boolean> prerequisBoolean = new ArrayList<Boolean>();
public boolean needCapitale = false;
public boolean needArtefact = false;
public int race = 0; //01234 race romains gaulois germains huns egyptien 


//cout niveau suivant

int boisPourNiveauSuivant = 0;
int argilePourNiveauSuivant = 0;
int ferPourNiveauSuivant = 0;
int cerealePourNiveauSuivant = 0;



public int getBoisPourNiveauSuivant() {
	return boisPourNiveauSuivant;
}
public void setBoisPourNiveauSuivant(int boisPourNiveauSuivant) {
	this.boisPourNiveauSuivant = boisPourNiveauSuivant;
}
public int getArgilePourNiveauSuivant() {
	return argilePourNiveauSuivant;
}
public void setArgilePourNiveauSuivant(int argilePourNiveauSuivant) {
	this.argilePourNiveauSuivant = argilePourNiveauSuivant;
}
public int getFerPourNiveauSuivant() {
	return ferPourNiveauSuivant;
}
public void setFerPourNiveauSuivant(int ferPourNiveauSuivant) {
	this.ferPourNiveauSuivant = ferPourNiveauSuivant;
}
public int getCerealePourNiveauSuivant() {
	return cerealePourNiveauSuivant;
}
public void setCerealePourNiveauSuivant(int cerealePourNiveauSuivant) {
	this.cerealePourNiveauSuivant = cerealePourNiveauSuivant;
}






public boolean getNeedCapitale() {
	return needCapitale;
}
public void setNeedCapitale(boolean needCapitale) {
	this.needCapitale = needCapitale;
}
public Boolean getNeedArtefact() {
	return needArtefact;
}
public void setNeedArtefact(Boolean needArtefact) {
	this.needArtefact = needArtefact;
}
public int getTypeChampsOuBatiment() {
	return typeChampsOuBatiment;
}
public void setTypeChampsOuBatiment(int typeChampsOuBatiment) {
	this.typeChampsOuBatiment = typeChampsOuBatiment;
}






public ArrayList<Batiment> getPrerequisBatiment() {
	return prerequisBatiment;
}
public void setPrerequisBatiment(ArrayList<Batiment> prerequisBatiment) {
	this.prerequisBatiment = prerequisBatiment;
}
public ArrayList<Boolean> getPrerequisBoolean() {
	return prerequisBoolean;
}
public void setPrerequisBoolean(ArrayList<Boolean> prerequisBoolean) {
	this.prerequisBoolean = prerequisBoolean;
}
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
public Batiment (String nomBatiment){
	this.nomBatiment = nomBatiment;
	
	//this.prerequisBatiment =  prerequisBatiment;
	
	this.setTypeChampsOuBatiment(determinerType(nomBatiment));
	
}







public Batiment(String nomBatiment, int levelBatiment, String slotBatiment, String alt) {
	this.nomBatiment = nomBatiment;
	this.levelBatiment = levelBatiment;
	this.slotBatiment = slotBatiment;
	this.alt = alt;
	this.setTypeChampsOuBatiment(determinerType(nomBatiment));
}


public Batiment(String nomBatiment, int levelBatiment, String slotBatiment) {
	this.nomBatiment = nomBatiment;
	this.levelBatiment = levelBatiment;
	this.slotBatiment = slotBatiment;
	this.setTypeChampsOuBatiment(determinerType(nomBatiment));
}



public Batiment (String nomBatiment, int levelBatiment){
	this.nomBatiment = nomBatiment;
	this.levelBatiment = levelBatiment;
	this.setTypeChampsOuBatiment(determinerType(nomBatiment));
	
}


public Batiment (String nomBatiment, int levelBatiment,  ArrayList<Batiment> prerequisBatiment){
	this.nomBatiment = nomBatiment;
	this.levelBatiment = levelBatiment;
	this.prerequisBatiment =  prerequisBatiment;
	this.setTypeChampsOuBatiment(determinerType(nomBatiment));
} 
public Batiment (String nomBatiment, int levelBatiment, Boolean needCapitale){
	this.nomBatiment = nomBatiment;
	this.levelBatiment = levelBatiment;
	this.needCapitale = needCapitale;
	this.setTypeChampsOuBatiment(determinerType(nomBatiment));
}

 

public Batiment (String nomBatiment, int levelBatiment, Boolean needCapitale, Boolean needArtefact){
	this.nomBatiment = nomBatiment;
	this.levelBatiment = levelBatiment;
	this.needCapitale = needCapitale;
	this.needArtefact = needArtefact;
	this.setTypeChampsOuBatiment(determinerType(nomBatiment));
}
public Batiment (String nomBatiment, int levelBatiment,  ArrayList<Batiment> prerequisBatiment, Boolean needCapitale ){
	this.nomBatiment = nomBatiment;
	this.levelBatiment = levelBatiment;
	this.prerequisBatiment =  prerequisBatiment;
	this.needCapitale = needCapitale;
	this.setTypeChampsOuBatiment(determinerType(nomBatiment));
	
}


public Batiment() {
	
	
	
}

public static int determinerType(String nomBatiment) { // un set pour la creation du constructeur et un return pour des test sur noms 
	int type = 1;
	if( nomBatiment.toLowerCase().contains(TemplatesDeVillages.ChampsBucheron.toLowerCase()) 
			|| nomBatiment.toLowerCase().contains(TemplatesDeVillages.ChampsCarriereDArgile.toLowerCase()) 
			|| nomBatiment.toLowerCase().contains(TemplatesDeVillages.ChampsFerme.toLowerCase()) 
			|| nomBatiment.toLowerCase().contains(TemplatesDeVillages.ChampsMineDeFer.toLowerCase()) ) {
		type = 0;
	}else {	
		type = 1;
	}
	
	return type;
}




}
