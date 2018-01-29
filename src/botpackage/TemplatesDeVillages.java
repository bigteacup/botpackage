package botpackage;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.hamcrest.FeatureMatcher;

public  class   TemplatesDeVillages {
	int mode;
	String operateur1 = ">=";
	String operateur2 = "<=";
	int champMin1 = 0;
	int champMin2 = 10;
	boolean autoriserAPoserBatiment = true;
	Integer priorite = 0;
	/*
	batimentsALancer.add("Bâtiment principal");
	batimentsALancer.add("Dépôt de ressources");
	batimentsALancer.add("Silo de céréales");
	batimentsALancer.add("Place du marché");
	batimentsALancer.add("Moulin");
	batimentsALancer.add("Boulangerie");
	batimentsALancer.add("Académie");
	batimentsALancer.add("Caserne");Bûcheron écurie
	*///

	
	public Integer getPriorite() {
		return priorite;
	}




	public void setPriorite(Integer priorite) {
		this.priorite = priorite;
	}




	public boolean getAutoriserAPoserBatiment() {
		return autoriserAPoserBatiment;
	}




	public void setAutoriserAPoserBatiment(boolean autoriserAPoserBatiment) {
		this.autoriserAPoserBatiment = autoriserAPoserBatiment;
	}




	public int getChampMin1() {
		return champMin1;
	}




	public void setChampMin1(int champMin1) {
		this.champMin1 = champMin1;
	}




	public int getChampMin2() {
		return champMin2;
	}




	public void setChampMin2(int champMin2) {
		this.champMin2 = champMin2;
	}
	public String getOperateur1() {
		return operateur1;
	}




	public void setOperateur1(String operateur1) {
		this.operateur1 = operateur1;
	}




	public String getOperateur2() {
		return operateur2;
	}


public String mur(Travian t) {
	String  murRace = murGaulois;
	if(t.getCompte().getTribut() == "Romain") {
		murRace = murRomain;
	}
	if(t.getCompte().getTribut() == "Gaulois") {
		murRace = murGaulois;
	}
	if(t.getCompte().getTribut() == "Germain") {
		murRace = murGermain;
	}
	return murRace;
	
}

	public void setOperateur2(String operateur2) {
		this.operateur2 = operateur2;
	}

	//correspondances de noms
	static String bois ="Bûcheron";
	static String cereale = "Ferme";
	static String fer= "fer";
	static String terre= "argile";
	
	
	static String ChampsBucheron ="Bûcheron";
	static String ChampsFerme = "Ferme";
	static String ChampsMineDeFer= "Mine de fer";
	static String ChampsCarriereDArgile= "Carrière d'argile";
	
	static String grande_ecurie = "Grande écurie";
	static String ecurie = "Écurie";
	static String comptoir = "Comptoir de commerce";
	static String grande_caserne= "Grande caserne";
	static String place_tournoi= "Place du tournoi";
	static String place_rassemblement= "Place de rassemblement";
	static String boulangerie= "Boulangerie";
	static String moulin= "Moulin";
	static String scierie= "Scierie";
	static String poterie= "Usine de poterie"; 
	static String fonderie= "Fonderie";
	static String cachette= "Cachette";
	static String pieges = "Fabricant de piéges";
	static String residence = "Résidence";
	static String atelier= "Atelier";
	static String hotel_de_ville= "Hôtel de ville";//Hôtel de Ville Hôtel de ville Hôtel de ville
	static String ambassade = "Ambassade";
	static String murGaulois = "Palissade";
	
	static String palais = "Palais";
	static String silo ="Silo de céréales";
	static String depot ="Dépôt de ressources";
	static String batiment_principal ="Bâtiment principal"; //Bâtiment principal Bâtiment principal
	static String empty = "Site de construction";
	static String marche = "Place du marché";
	static String academie = "Académie";	
	static String caserne = "Caserne";
	static String tailleur = "Tailleur de pierre";
	static String grandSilo = "Grand silo de céréales";
	static String grandDepot = "Grand Dépôt de ressources";
	static String forge = "Forge";
	static String cdt = "Chambre aux trésors"; //Chambre aux trésors
	static String murRomain = "Mur d'enceinte"; //Mur d&#39;enceinte //Mur d' enceinte
	static String murGermain = "Mur de terre";
	String nomDuTemplate="";
 
	//liste de batimients
	public ArrayList<Batiment> listeDeBatimentDuJeu = new ArrayList<Batiment>();
	
	//liste par default
	public ArrayList<Batiment> listeDeBatimentsDuTemplateParDefault1 = new ArrayList<Batiment>();
	public ArrayList<Batiment> listeDeBatimentsDuTemplateParDefault2 = new ArrayList<Batiment>();
	public ArrayList<Batiment> listeDeBatimentsDuTemplateParDefault3 = new ArrayList<Batiment>();
	public ArrayList<Batiment> listeDeBatimentsDuTemplateParDefault4 = new ArrayList<Batiment>();
	
	ArrayList<ArrayList<Batiment>> listeDesTemplatesParDefault = new ArrayList<ArrayList<Batiment>>();
	

	ArrayList<Batiment> listeDeBatiments= new ArrayList<Batiment>();

	public TemplatesDeVillages() {

		listerBatimentDuJeu();
		prerequis();
		templatesDeVillagesTimTool();
	//	choisirModeTemplatesDeVillages(3); // mode forcé templatesDeVillagesTimTool();
	}
	

	
	

	
	
	
	


///////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void templatesDeVillagesTimTool() { //mode 3
		
		
		
		listeDeBatimentsDuTemplateParDefault1.clear();
		listeDeBatimentsDuTemplateParDefault2.clear();
		listeDeBatimentsDuTemplateParDefault3.clear();
		listeDeBatimentsDuTemplateParDefault4.clear();
		
		 listeDeBatimentsDuTemplateParDefault1.add(new Batiment(batiment_principal, 10) ); 
		 listeDeBatimentsDuTemplateParDefault1.add(new Batiment(depot, 6));
		 listeDeBatimentsDuTemplateParDefault1.add(new Batiment(silo, 6));
		 listeDeBatimentsDuTemplateParDefault1.add(new Batiment(residence, 10, batResidence));
		 listeDeBatimentsDuTemplateParDefault1.add(new Batiment(caserne, 3, batCaserne));
		 listeDeBatimentsDuTemplateParDefault1.add(new Batiment(place_rassemblement, 1));
		 listeDeBatimentsDuTemplateParDefault1.add(new Batiment(marche, 3, batMarche));
		 listeDeBatimentsDuTemplateParDefault1.add(new Batiment(moulin, 5, batMoulin));
		 listeDeBatimentsDuTemplateParDefault1.add(new Batiment(academie, 3, batAcademie));
		 listeDeBatimentsDuTemplateParDefault1.add(new Batiment(murRomain, 5));
		
		 
		 
	//	 listeDeBatimentsDuTemplateParDefault1.add(new Batiment(cachette, 10));
		 listeDeBatimentsDuTemplateParDefault2.add(new Batiment(place_rassemblement, 1));
		 listeDeBatimentsDuTemplateParDefault2.add(new Batiment(poterie, 4, batPoterie));
		 listeDeBatimentsDuTemplateParDefault2.add(new Batiment(scierie, 4, batScierie));
		 listeDeBatimentsDuTemplateParDefault2.add(new Batiment(fonderie, 4, batFonderie));
		 listeDeBatimentsDuTemplateParDefault2.add(new Batiment(batiment_principal, 15));
		 listeDeBatimentsDuTemplateParDefault2.add(new Batiment(depot, 14));
		 listeDeBatimentsDuTemplateParDefault2.add(new Batiment(silo, 14));
		 listeDeBatimentsDuTemplateParDefault2.add(new Batiment(moulin, 5, batMoulin));
		 listeDeBatimentsDuTemplateParDefault2.add(new Batiment(residence, 10, batResidence));
		 listeDeBatimentsDuTemplateParDefault2.add(new Batiment(marche, 12, batMarche));
		 listeDeBatimentsDuTemplateParDefault2.add(new Batiment(caserne, 10, batCaserne));
		 listeDeBatimentsDuTemplateParDefault2.add(new Batiment(palais, 10));
		 listeDeBatimentsDuTemplateParDefault2.add(new Batiment(tailleur, 5, batTailleur, true));
		 listeDeBatimentsDuTemplateParDefault2.add(new Batiment(academie, 5, batAcademie));
		 listeDeBatimentsDuTemplateParDefault2.add(new Batiment(murRomain, 10));
		// listeDeBatimentsDuTemplateParDefault2.add(new Batiment(cachette, 10));
		 
		 
		 listeDeBatimentsDuTemplateParDefault3.add(new Batiment(batiment_principal, 20));
		 listeDeBatimentsDuTemplateParDefault3.add(new Batiment(poterie, 5, batPoterie));
		 listeDeBatimentsDuTemplateParDefault3.add(new Batiment(scierie, 5, batScierie));
		 listeDeBatimentsDuTemplateParDefault3.add(new Batiment(fonderie, 5, batFonderie));
		 listeDeBatimentsDuTemplateParDefault3.add(new Batiment(silo, 15));
		 listeDeBatimentsDuTemplateParDefault3.add(new Batiment(depot, 15));
		 listeDeBatimentsDuTemplateParDefault3.add(new Batiment(residence, 10, batResidence));
		 listeDeBatimentsDuTemplateParDefault3.add(new Batiment(moulin, 5, batMoulin));
		 listeDeBatimentsDuTemplateParDefault3.add(new Batiment(marche, 15, batMarche));
		 listeDeBatimentsDuTemplateParDefault3.add(new Batiment(hotel_de_ville, 1, batHV) );
		 listeDeBatimentsDuTemplateParDefault3.add(new Batiment(caserne, 5, batCaserne));
		 listeDeBatimentsDuTemplateParDefault3.add(new Batiment(academie, 10, batAcademie));
		 listeDeBatimentsDuTemplateParDefault3.add(new Batiment(palais, 20));
		 listeDeBatimentsDuTemplateParDefault3.add(new Batiment(ecurie, 10, batEcurie));
		 listeDeBatimentsDuTemplateParDefault3.add(new Batiment(comptoir, 5, batComptoir ));
		 listeDeBatimentsDuTemplateParDefault3.add(new Batiment(tailleur, 12, batTailleur, true));
		 listeDeBatimentsDuTemplateParDefault3.add(new Batiment(place_rassemblement, 10));
		 listeDeBatimentsDuTemplateParDefault3.add(new Batiment(boulangerie, 5, batBoulangerie ));
		 listeDeBatimentsDuTemplateParDefault3.add(new Batiment(murRomain, 15));
		 // listeDeBatimentsDuTemplateParDefault3.add(new Batiment(cachette, 10)); Chambre aux trésors
		 		 

		 listeDeBatimentsDuTemplateParDefault4.add(new Batiment(poterie, 5, batPoterie));
		 listeDeBatimentsDuTemplateParDefault4.add(new Batiment(scierie, 5, batScierie));
		 listeDeBatimentsDuTemplateParDefault4.add(new Batiment(fonderie, 5, batFonderie));
		 listeDeBatimentsDuTemplateParDefault4.add(new Batiment(moulin, 5, batMoulin));
		 listeDeBatimentsDuTemplateParDefault4.add(new Batiment(boulangerie, 5, batBoulangerie ));
		 listeDeBatimentsDuTemplateParDefault4.add(new Batiment(batiment_principal, 20));
		 listeDeBatimentsDuTemplateParDefault4.add(new Batiment(silo, 20));
		 listeDeBatimentsDuTemplateParDefault4.add(new Batiment(depot, 20));
		 listeDeBatimentsDuTemplateParDefault4.add(new Batiment(marche, 20, batMarche));
		 listeDeBatimentsDuTemplateParDefault4.add(new Batiment(academie, 20, batAcademie));
		 listeDeBatimentsDuTemplateParDefault4.add(new Batiment(hotel_de_ville, 15, batHV));
		 listeDeBatimentsDuTemplateParDefault4.add(new Batiment(caserne, 20, batCaserne));
		 listeDeBatimentsDuTemplateParDefault4.add(new Batiment(place_rassemblement, 15));
		 listeDeBatimentsDuTemplateParDefault4.add(new Batiment(palais, 20));
		 listeDeBatimentsDuTemplateParDefault4.add(new Batiment(residence, 20, batResidence));
		 listeDeBatimentsDuTemplateParDefault4.add(new Batiment(tailleur, 20, batTailleur, true));
		 listeDeBatimentsDuTemplateParDefault4.add(new Batiment(grandSilo, 20 , false, true));
		 listeDeBatimentsDuTemplateParDefault4.add(new Batiment(grandDepot, 20, false, true));
		 listeDeBatimentsDuTemplateParDefault4.add(new Batiment(forge, 20, batForge));
		 listeDeBatimentsDuTemplateParDefault4.add(new Batiment(place_tournoi, 14, batPlaceDeTournoi));
		// listeDeBatimentsDuTemplateParDefault4.add(new Batiment(cdt, 1));
		 listeDeBatimentsDuTemplateParDefault4.add(new Batiment(ecurie, 12, batEcurie));
		 listeDeBatimentsDuTemplateParDefault4.add(new Batiment(comptoir, 12, batComptoir));
		 listeDeBatimentsDuTemplateParDefault4.add(new Batiment(murRomain, 20));
		 // listeDeBatimentsDuTemplateParDefault4.add(new Batiment(cachette, 10));
		 

			// on liste les liste par commodité pour plus tard
		 	listeDesTemplatesParDefault.clear();
			listeDesTemplatesParDefault.add(listeDeBatimentsDuTemplateParDefault1);
			listeDesTemplatesParDefault.add(listeDeBatimentsDuTemplateParDefault2);
			listeDesTemplatesParDefault.add(listeDeBatimentsDuTemplateParDefault3);
			listeDesTemplatesParDefault.add(listeDeBatimentsDuTemplateParDefault4);
	}





	public ArrayList<Batiment> etablirTemplatePourUnVillage(int champMin) {
		if(mode==3) {
		if (champMin <= 4 ){return listeDeBatimentsDuTemplateParDefault1;}
		if (champMin <= 8 && champMin >4){return listeDeBatimentsDuTemplateParDefault2;}
		if (champMin < 10 && champMin > 7){return listeDeBatimentsDuTemplateParDefault3;}
		if (champMin == 10){return listeDeBatimentsDuTemplateParDefault4;}
		if (champMin > 10){return listeDeBatimentsDuTemplateParDefault4;}
		}
		
		
	//	if(mode==1) {
		if (champMin <= 4 ){return listeDeBatimentsDuTemplateParDefault1;}
		if (champMin <= 8 && champMin >4){return listeDeBatimentsDuTemplateParDefault2;}
		if (champMin < 10 && champMin > 7){return listeDeBatimentsDuTemplateParDefault3;}
		if (champMin == 10){return listeDeBatimentsDuTemplateParDefault4;}
		if (champMin > 10){return listeDeBatimentsDuTemplateParDefault4;}
	//	}
		
		return null;

	}
	
	
	
	
	
	
	public ArrayList<TemplatesDeVillages> trierListe(ArrayList<TemplatesDeVillages> liste){

		// Sort
		Collections.sort(liste, new Comparator<TemplatesDeVillages>() {
		        @Override
		        public int compare(TemplatesDeVillages temp1, TemplatesDeVillages temp2)
		        {

		            return temp1.getPriorite().compareTo(temp2.getPriorite());
		        }
		    });
		
		return liste;
		
		
	}
	
	
	public ArrayList<Batiment> etablirTemplatePourUnVillage(Village village, int champMin) {
		trierListe(village.getListeDeTemplates());
		for(TemplatesDeVillages temp : village.getListeDeTemplates()) {
			if(!temp.getNomDuTemplate().equals("")) {
		if(comparer(champMin, temp.operateur1, temp.champMin1 ) == true && comparer(champMin, temp.operateur2, temp.champMin2 ) == true)  {
			village.setTemplate(temp);
			return temp.getListeDeBatiments();
			
		}
		}
		}
		
		return null;

	}
	
	public boolean comparer(int champMin, String signe, int level) {
		boolean b = false;
		if(signe.equals("")) {b = true;} //
		
		if(signe.equals("<")) {if(champMin<level) { b = true;}}
		if(signe.equals("<=")) {if(champMin<=level) { b = true;}}
		if(signe.equals("=")) {if(champMin==level) { b = true;}}
		if(signe.equals(">=")) {if(champMin>=level) { b = true;}}
		if(signe.equals(">")) {if(champMin>level) { b = true;}}
		
		return b;
		
	}

	
	public void listerBatimentDuJeu() {
		listeDeBatimentDuJeu.clear();
		
		
		listeDeBatimentDuJeu.add(new Batiment (grande_ecurie , 0));
		listeDeBatimentDuJeu.add(new Batiment (ecurie, 0, batEcurie));
		listeDeBatimentDuJeu.add(new Batiment (comptoir , 0, batComptoir));
		listeDeBatimentDuJeu.add(new Batiment (grande_caserne, 0));
		listeDeBatimentDuJeu.add(new Batiment (place_tournoi, 0, batPlaceDeTournoi));
		listeDeBatimentDuJeu.add(new Batiment (place_rassemblement, 0));
		listeDeBatimentDuJeu.add(new Batiment (boulangerie, 0, batBoulangerie));
		listeDeBatimentDuJeu.add(new Batiment (moulin, 0, batMoulin));
		listeDeBatimentDuJeu.add(new Batiment (scierie, 0, batScierie));
		listeDeBatimentDuJeu.add(new Batiment (poterie, 0, batPoterie));
		listeDeBatimentDuJeu.add(new Batiment (fonderie, 0, batFonderie));
		listeDeBatimentDuJeu.add(new Batiment (cachette, 0));
		listeDeBatimentDuJeu.add(new Batiment (pieges, 0));
		listeDeBatimentDuJeu.add(new Batiment (residence, 0, batResidence));
		listeDeBatimentDuJeu.add(new Batiment (atelier, 0, batAtelier));
		listeDeBatimentDuJeu.add(new Batiment (hotel_de_ville, 0, batHV));
		listeDeBatimentDuJeu.add(new Batiment (ambassade, 0));
		listeDeBatimentDuJeu.add(new Batiment (murGaulois, 0));
		listeDeBatimentDuJeu.add(new Batiment (murRomain, 0));
		listeDeBatimentDuJeu.add(new Batiment (palais, 0));
		listeDeBatimentDuJeu.add(new Batiment (silo, 0));
		listeDeBatimentDuJeu.add(new Batiment (depot, 0));
		listeDeBatimentDuJeu.add(new Batiment (batiment_principal , 0));
		listeDeBatimentDuJeu.add(new Batiment (empty , 0));
		listeDeBatimentDuJeu.add(new Batiment (marche , 0, batMarche));
		listeDeBatimentDuJeu.add(new Batiment (academie , 0, batAcademie));
		listeDeBatimentDuJeu.add(new Batiment (caserne , 0, batCaserne));
		listeDeBatimentDuJeu.add(new Batiment (tailleur , 0, batTailleur, true));
		listeDeBatimentDuJeu.add(new Batiment (grandSilo , 0, false, true));
		listeDeBatimentDuJeu.add(new Batiment (grandDepot , 0, false, true));
		listeDeBatimentDuJeu.add(new Batiment (forge , 0, batForge));
		listeDeBatimentDuJeu.add(new Batiment (cdt, 0, batCDT)); //Chambre aux trésors 	static String murGaulois = "Palissade";
		listeDeBatimentDuJeu.add(new Batiment (murGermain, 0));
	
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////A deplacer dans une autre classe///////////////////////////////////////////////////////////////////////////////////////
//Prerequis :
	//civil
	 ArrayList<Batiment> batHV = new ArrayList<Batiment>();
	 ArrayList<Batiment> batMarche = new ArrayList<Batiment>();
	 ArrayList<Batiment> batComptoir = new ArrayList<Batiment>();
	 ArrayList<Batiment> batResidence = new ArrayList<Batiment>();
	 ArrayList<Batiment> batCDT = new ArrayList<Batiment>();
	 ArrayList<Batiment> batTailleur = new ArrayList<Batiment>();
	 
	 //militaire
	 ArrayList<Batiment> batForge = new ArrayList<Batiment>();
	 ArrayList<Batiment> batEcurie = new ArrayList<Batiment>();
	 ArrayList<Batiment> batAcademie = new ArrayList<Batiment>();
	 ArrayList<Batiment> batPlaceDeTournoi = new ArrayList<Batiment>();
	 ArrayList<Batiment> batCaserne = new ArrayList<Batiment>();
	 ArrayList<Batiment> batAtelier = new ArrayList<Batiment>();
	 ArrayList<Batiment> batManoir = new ArrayList<Batiment>();
	 
	 // ressource
	 ArrayList<Batiment> batBoulangerie = new ArrayList<Batiment>();
	 ArrayList<Batiment> batFonderie = new ArrayList<Batiment>();
	 ArrayList<Batiment> batScierie = new ArrayList<Batiment>();
	 ArrayList<Batiment> batPoterie = new ArrayList<Batiment>();
	 ArrayList<Batiment> batMoulin = new ArrayList<Batiment>();

public void prerequis() {	
	//civil

	 batHV.add( (new Batiment(batiment_principal, 10) )) ;
	 batHV.add( (new Batiment(academie, 10) )) ;


	 batMarche.add( (new Batiment(batiment_principal, 3) )) ;
	 batMarche.add( (new Batiment(depot, 1) )) ;
	 batMarche.add( (new Batiment(silo, 1) )) ;


	 batComptoir.add( (new Batiment(marche,20) )) ;
	 batComptoir.add( (new Batiment(ecurie, 10) )) ;


	 batResidence.add( (new Batiment(batiment_principal, 5) )) ;
	 


	 batCDT.add( (new Batiment(batiment_principal, 10) )) ;
	 


	 batTailleur.add( (new Batiment(batiment_principal, 10, true) )) ;
	 
	 
	 //militaire
	 
	 batForge.add( (new Batiment(batiment_principal, 3) )) ;
	 batForge.add( (new Batiment(academie, 1) )) ;


	 batEcurie.add( (new Batiment(forge, 3) )) ;
	 batEcurie.add( (new Batiment(academie, 5) )) ;
	 

	 batAcademie.add( (new Batiment(batiment_principal, 3) )) ;
	 batAcademie.add( (new Batiment(caserne, 3) )) ;
	 

	 batPlaceDeTournoi.add( (new Batiment(place_rassemblement, 15) )) ;
	 
	 

	 batCaserne.add( (new Batiment(batiment_principal, 3) )) ;
	 batCaserne.add( (new Batiment(place_rassemblement, 1) )) ;
	 

	 batAtelier.add( (new Batiment(batiment_principal, 5) )) ;
	 batAtelier.add( (new Batiment(academie, 10) )) ;
	 

	 batManoir.add( (new Batiment(batiment_principal, 3) )) ;
	 batManoir.add( (new Batiment(place_rassemblement, 1) )) ;
	 
	 
	 
	 
	 // ressource
	
	 batBoulangerie.add( (new Batiment(batiment_principal, 5) )) ;
	 batBoulangerie.add( (new Batiment(moulin, 5) )) ;
	 batBoulangerie.add( (new Batiment(cereale, 10) )) ;
	 

	 batFonderie.add( (new Batiment(batiment_principal, 5) )) ;
	 batFonderie.add( (new Batiment(fer, 10) )) ;
	 

	 batScierie.add( (new Batiment(batiment_principal, 5) )) ;
	 batScierie.add( (new Batiment(bois, 10) )) ;
	 

	 batPoterie.add( (new Batiment(batiment_principal, 5) )) ;
	 batPoterie.add( (new Batiment(terre, 10) )) ;
	 

	 batMoulin.add( (new Batiment(cereale, 5) )) ;
	 
	 //ArrayList<Batiment> hv = new ArrayList<Batiment>();
	 //hv.add( (new Batiment(batiment_principal, 10) )) ;
	 //hv.add( (new Batiment(academie, 10) )) ;
	 
	 //ArrayList<Batiment> hv = new ArrayList<Batiment>();
	 //hv.add( (new Batiment(batiment_principal, 10) )) ;
	 //hv.add( (new Batiment(academie, 10) )) ;

}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	//public void setNomDuTemplate(String nomDuTemplate) {
	//	this.nomDuTemplate = nomDuTemplate;
	//	}
	
	
	
	public String getNomDuTemplate() {
		return nomDuTemplate;
	}
	public void setNomDuTemplate(String nomDuTemplate) {
		this.nomDuTemplate = nomDuTemplate;
	}
	
	
	public ArrayList<Batiment> getlisteDeBatimentsDuTemplateParDefault1() {
		return listeDeBatimentsDuTemplateParDefault1;
	}
	public void setlisteDeBatimentsDuTemplateParDefault1(ArrayList<Batiment> listeDeBatimentsDuTemplateParDefault1) {
		this.listeDeBatimentsDuTemplateParDefault1 = listeDeBatimentsDuTemplateParDefault1;
	}
	
	
	
	
	
	
	public ArrayList<Batiment> getlisteDeBatimentsDuTemplateParDefault2() {
		return listeDeBatimentsDuTemplateParDefault2;
	}
	public void setlisteDeBatimentsDuTemplateParDefault2(ArrayList<Batiment> listeDeBatimentsDuTemplateParDefault2) {
		this.listeDeBatimentsDuTemplateParDefault2 = listeDeBatimentsDuTemplateParDefault2;
	}
	
	
	
	
	
	
	public ArrayList<Batiment> getlisteDeBatimentsDuTemplateParDefault3() {
		return listeDeBatimentsDuTemplateParDefault3;
	}
	public void setlisteDeBatimentsDuTemplateParDefault3(
			ArrayList<Batiment> listeDeBatimentsDuTemplateParDefault3) {
		this.listeDeBatimentsDuTemplateParDefault3 = listeDeBatimentsDuTemplateParDefault3;
	}

	
	
	
	
	
	public ArrayList<Batiment> getlisteDeBatimentsDuTemplateParDefault4() {
		return listeDeBatimentsDuTemplateParDefault4;
	}
	public void setlisteDeBatimentsDuTemplateParDefault4(
			ArrayList<Batiment> listeDeBatimentsDuTemplateParDefault4) {
		this.listeDeBatimentsDuTemplateParDefault4 = listeDeBatimentsDuTemplateParDefault4;
	}
	
	
	
	
	


	
	public ArrayList<Batiment> getListeDeBatiments() {
		return listeDeBatiments;
	}

	public void setListeDeBatiments(ArrayList<Batiment> listeDeBatiments) {
		this.listeDeBatiments = listeDeBatiments;
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/*	public TemplatesDeVillages trouverTemplate(String nomTemplate) {
		for(TemplatesDeVillages t : t.bot.listeDeTemplatePersonnalises) {
			if() {
				
			}
		}
		return null;
		
		
	}
	*/
}
