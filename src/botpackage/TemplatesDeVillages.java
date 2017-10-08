package botpackage;


import java.util.ArrayList;
import java.util.List;

public  class   TemplatesDeVillages {
	int mode;
	String operateur1 = ">=";
	String operateur2 = "<=";
	int champMin1 = 0;
	int champMin2 = 10;
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




	public void setOperateur2(String operateur2) {
		this.operateur2 = operateur2;
	}

	//correspondances de noms
	static String bois ="Bûcheron";
	static String cereale = "Ferme";
	static String fer= "fer";
	static String terre= "argile";
	static String grande_ecurie = "Grande écurie";
	static String ecurie = "écurie";
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
	static String mur = "Palissade";
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
		templatesDeVillagesTimTool();
	//	choisirModeTemplatesDeVillages(3); // mode forcé templatesDeVillagesTimTool();
	}
	

	
	
	public void choisirModeTemplatesDeVillages(int mode) { //0=editeur 1=normal 2=default 3=TimTool
		this.mode = mode;
		
		if (mode == 0) { 
			templateInterface();	
		}
		if (mode == 1) { 
			templateClassique();	
		}
		if (mode == 2) { 
			;	
		}
		if (mode == 3) { 
			templatesDeVillagesTimTool();	
		}

	}
	
	
	
	

	public void templateInterface() {
		nomDuTemplate = "Edition";
		listerBatimentDuJeu();
	}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void templatesDeVillagesTimTool() { //mode 3
		
		
		
		listeDeBatimentsDuTemplateParDefault1.clear();
		listeDeBatimentsDuTemplateParDefault2.clear();
		listeDeBatimentsDuTemplateParDefault3.clear();
		listeDeBatimentsDuTemplateParDefault4.clear();
		
		 listeDeBatimentsDuTemplateParDefault1.add(new Batiment(batiment_principal, 5));
		 listeDeBatimentsDuTemplateParDefault1.add(new Batiment(depot, 6));
		 listeDeBatimentsDuTemplateParDefault1.add(new Batiment(silo, 6));
		 listeDeBatimentsDuTemplateParDefault1.add(new Batiment(caserne, 3));
		 listeDeBatimentsDuTemplateParDefault1.add(new Batiment(place_rassemblement, 1));
		 listeDeBatimentsDuTemplateParDefault1.add(new Batiment(residence, 10));
		 listeDeBatimentsDuTemplateParDefault1.add(new Batiment(marche, 3));
		 listeDeBatimentsDuTemplateParDefault1.add(new Batiment(moulin, 5));
		 listeDeBatimentsDuTemplateParDefault1.add(new Batiment(academie, 3));
		
		 
		 
	//	 listeDeBatimentsDuTemplateParDefault1.add(new Batiment(cachette, 10));
		 listeDeBatimentsDuTemplateParDefault2.add(new Batiment(place_rassemblement, 1));
		 listeDeBatimentsDuTemplateParDefault2.add(new Batiment(moulin, 3));
		 listeDeBatimentsDuTemplateParDefault2.add(new Batiment(batiment_principal, 10));
		 listeDeBatimentsDuTemplateParDefault2.add(new Batiment(depot, 12));
		 listeDeBatimentsDuTemplateParDefault2.add(new Batiment(silo, 12));
		 listeDeBatimentsDuTemplateParDefault2.add(new Batiment(moulin, 5));
		 listeDeBatimentsDuTemplateParDefault2.add(new Batiment(residence, 10));
		 listeDeBatimentsDuTemplateParDefault2.add(new Batiment(marche, 8));
		 listeDeBatimentsDuTemplateParDefault2.add(new Batiment(caserne, 5));
		 listeDeBatimentsDuTemplateParDefault2.add(new Batiment(palais, 10));
		 listeDeBatimentsDuTemplateParDefault2.add(new Batiment(tailleur, 5));
		 listeDeBatimentsDuTemplateParDefault2.add(new Batiment(academie, 5));
		// listeDeBatimentsDuTemplateParDefault2.add(new Batiment(cachette, 10));
		 
		 
		 listeDeBatimentsDuTemplateParDefault3.add(new Batiment(batiment_principal, 20));
		 listeDeBatimentsDuTemplateParDefault3.add(new Batiment(poterie, 5));
		 listeDeBatimentsDuTemplateParDefault3.add(new Batiment(scierie, 5));
		 listeDeBatimentsDuTemplateParDefault3.add(new Batiment(fonderie, 5));
		 listeDeBatimentsDuTemplateParDefault3.add(new Batiment(silo, 15));
		 listeDeBatimentsDuTemplateParDefault3.add(new Batiment(depot, 15));
		 listeDeBatimentsDuTemplateParDefault3.add(new Batiment(residence, 10));
		 listeDeBatimentsDuTemplateParDefault3.add(new Batiment(moulin, 5));
		 listeDeBatimentsDuTemplateParDefault3.add(new Batiment(marche, 15));
		 listeDeBatimentsDuTemplateParDefault3.add(new Batiment(hotel_de_ville, 1));
		 listeDeBatimentsDuTemplateParDefault3.add(new Batiment(caserne, 5));
		 listeDeBatimentsDuTemplateParDefault3.add(new Batiment(academie, 10));
		 listeDeBatimentsDuTemplateParDefault3.add(new Batiment(palais, 20));
		 listeDeBatimentsDuTemplateParDefault3.add(new Batiment(ecurie, 10));
		 listeDeBatimentsDuTemplateParDefault3.add(new Batiment(comptoir, 5));
		 listeDeBatimentsDuTemplateParDefault3.add(new Batiment(tailleur, 12));
		 listeDeBatimentsDuTemplateParDefault3.add(new Batiment(place_rassemblement, 10));
		 listeDeBatimentsDuTemplateParDefault3.add(new Batiment(boulangerie, 5));
		 // listeDeBatimentsDuTemplateParDefault3.add(new Batiment(cachette, 10)); Chambre aux trésors
		 		 

		 listeDeBatimentsDuTemplateParDefault4.add(new Batiment(poterie, 5));
		 listeDeBatimentsDuTemplateParDefault4.add(new Batiment(scierie, 5));
		 listeDeBatimentsDuTemplateParDefault4.add(new Batiment(fonderie, 5));
		 listeDeBatimentsDuTemplateParDefault4.add(new Batiment(moulin, 5));
		 listeDeBatimentsDuTemplateParDefault4.add(new Batiment(boulangerie, 5));
		 listeDeBatimentsDuTemplateParDefault4.add(new Batiment(batiment_principal, 20));
		 listeDeBatimentsDuTemplateParDefault4.add(new Batiment(silo, 20));
		 listeDeBatimentsDuTemplateParDefault4.add(new Batiment(depot, 20));
		 listeDeBatimentsDuTemplateParDefault4.add(new Batiment(marche, 20));
		 listeDeBatimentsDuTemplateParDefault4.add(new Batiment(academie, 20));
		 listeDeBatimentsDuTemplateParDefault4.add(new Batiment(hotel_de_ville, 15));
		 listeDeBatimentsDuTemplateParDefault4.add(new Batiment(caserne, 16));
		 listeDeBatimentsDuTemplateParDefault4.add(new Batiment(place_rassemblement, 15));
		 listeDeBatimentsDuTemplateParDefault4.add(new Batiment(palais, 20));
		 listeDeBatimentsDuTemplateParDefault4.add(new Batiment(residence, 20));
		 listeDeBatimentsDuTemplateParDefault4.add(new Batiment(tailleur, 20));
		 listeDeBatimentsDuTemplateParDefault4.add(new Batiment(grandSilo, 20));
		 listeDeBatimentsDuTemplateParDefault4.add(new Batiment(grandDepot, 20));
		 listeDeBatimentsDuTemplateParDefault4.add(new Batiment(forge, 20));
		 listeDeBatimentsDuTemplateParDefault4.add(new Batiment(place_tournoi, 12));
		 listeDeBatimentsDuTemplateParDefault4.add(new Batiment(cdt, 1));
		 listeDeBatimentsDuTemplateParDefault4.add(new Batiment(ecurie, 10));
		 listeDeBatimentsDuTemplateParDefault4.add(new Batiment(comptoir, 10));
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
	
	public ArrayList<Batiment> etablirTemplatePourUnVillage(Village village, int champMin) {
	
		for(TemplatesDeVillages temp : village.getListeDeTemplates()) {
			if(!temp.getNomDuTemplate().equals("")) {
		if(comparer(champMin, temp.operateur1, temp.champMin1 ) == true && comparer(champMin, temp.operateur2, temp.champMin2 ) == true)  {
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
		
		listeDeBatimentDuJeu.add(new Batiment(poterie, 0));
		listeDeBatimentDuJeu.add(new Batiment (grande_ecurie , 0));
		listeDeBatimentDuJeu.add(new Batiment (ecurie, 0));
		listeDeBatimentDuJeu.add(new Batiment (comptoir , 0));
		listeDeBatimentDuJeu.add(new Batiment (grande_caserne, 0));
		listeDeBatimentDuJeu.add(new Batiment (place_tournoi, 0));
		listeDeBatimentDuJeu.add(new Batiment (place_rassemblement, 0));
		listeDeBatimentDuJeu.add(new Batiment (boulangerie, 0));
		listeDeBatimentDuJeu.add(new Batiment (moulin, 0));
		listeDeBatimentDuJeu.add(new Batiment (scierie, 0));
		listeDeBatimentDuJeu.add(new Batiment (poterie, 0));
		listeDeBatimentDuJeu.add(new Batiment (fonderie, 0));
		listeDeBatimentDuJeu.add(new Batiment (cachette, 0));
		listeDeBatimentDuJeu.add(new Batiment (pieges, 0));
		listeDeBatimentDuJeu.add(new Batiment (residence, 0));
		listeDeBatimentDuJeu.add(new Batiment (atelier, 0));
		listeDeBatimentDuJeu.add(new Batiment (hotel_de_ville, 0));
		listeDeBatimentDuJeu.add(new Batiment (ambassade, 0));
		listeDeBatimentDuJeu.add(new Batiment (mur, 0));
		listeDeBatimentDuJeu.add(new Batiment (palais, 0));
		listeDeBatimentDuJeu.add(new Batiment (silo, 0));
		listeDeBatimentDuJeu.add(new Batiment (depot, 0));
		listeDeBatimentDuJeu.add(new Batiment (batiment_principal , 0));
		listeDeBatimentDuJeu.add(new Batiment (empty , 0));
		listeDeBatimentDuJeu.add(new Batiment (marche , 0));
		listeDeBatimentDuJeu.add(new Batiment (academie , 0));
		listeDeBatimentDuJeu.add(new Batiment (caserne , 0));
		listeDeBatimentDuJeu.add(new Batiment (tailleur , 0));
		listeDeBatimentDuJeu.add(new Batiment (grandSilo , 0));
		listeDeBatimentDuJeu.add(new Batiment (grandDepot , 0));
		listeDeBatimentDuJeu.add(new Batiment (forge , 0));
		listeDeBatimentDuJeu.add(new Batiment (cdt, 0)); //Chambre aux trésors
	
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void templateClassique() {
		nomDuTemplate = "Classique";
		listerBatimentDuJeu();
	}
	
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
