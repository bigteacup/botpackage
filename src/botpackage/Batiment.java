package botpackage;

import java.util.ArrayList;

public class Batiment {
	
private String nomBatiment;
private int levelBatiment;
private String slotBatiment;
private String lienBatiment;
private String alt;
private int nombrePresent = 0 ;
private boolean present = false ;
public ArrayList<Batiment> prerequisBatiment = new ArrayList<Batiment>();
public ArrayList<Boolean> prerequisBoolean = new ArrayList<Boolean>();
public boolean needCapitale = false;
public boolean needArtefact = false;

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


public Batiment (String nomBatiment, int levelBatiment,  ArrayList<Batiment> prerequisBatiment){
	this.nomBatiment = nomBatiment;
	this.levelBatiment = levelBatiment;
	this.prerequisBatiment =  prerequisBatiment;
	
} 
public Batiment (String nomBatiment, int levelBatiment, Boolean needCapitale){
	this.nomBatiment = nomBatiment;
	this.levelBatiment = levelBatiment;
	this.needCapitale = needCapitale;
	
}

 

public Batiment (String nomBatiment, int levelBatiment, Boolean needCapitale, Boolean needArtefact){
	this.nomBatiment = nomBatiment;
	this.levelBatiment = levelBatiment;
	this.needCapitale = needCapitale;
	this.needArtefact = needArtefact;
	
}
public Batiment (String nomBatiment, int levelBatiment,  ArrayList<Batiment> prerequisBatiment, Boolean needCapitale ){
	this.nomBatiment = nomBatiment;
	this.levelBatiment = levelBatiment;
	this.prerequisBatiment =  prerequisBatiment;
	this.needCapitale = needCapitale;
	
	
}


public Batiment() {
	
	
	
}






}
