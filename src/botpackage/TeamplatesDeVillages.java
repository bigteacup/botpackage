package botpackage;


import java.util.ArrayList;
import java.util.List;

public  class   TeamplatesDeVillages {
	
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
	
	
	//correspondances de noms
	static	 String bois ="Bûcheron";
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
	static String poterie= "Usine de Poteries"; 
	static String fonderie= "Fonderie";
	static String cachette= "Cachette";
	static String pieges = "Fabricant de piéges";
	static String residence = "Résidence";
	static String atelier= "Atelier";
	static String hotel_de_ville= "Hôtel de ville";//Hôtel de Ville
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
	static String tailleur = "Tailleur de Pierres";
	static String grandSilo = "Grand silo de céréales";
	static String grandDepot = "Grand Dépôt de ressources";
	static String forge = "Forge";
	static String cdt = "Chambre aux trésors"; //Chambre aux trésors
 
 
	 List<Batiment> listeDeBatimentsDuTeamplate1 = new ArrayList<Batiment>();
	 List<Batiment> listeDeBatimentsDuTeamplate2 = new ArrayList<Batiment>();
	 List<Batiment> listeDeBatimentsDuTeamplate3 = new ArrayList<Batiment>();
	 List<Batiment> listeDeBatimentsDuTeamplate4 = new ArrayList<Batiment>();
	
	
	public TeamplatesDeVillages() {
	
		 listeDeBatimentsDuTeamplate1.add(new Batiment(batiment_principal, 5));
		 listeDeBatimentsDuTeamplate1.add(new Batiment(depot, 5));
		 listeDeBatimentsDuTeamplate1.add(new Batiment(silo, 5));
		 listeDeBatimentsDuTeamplate1.add(new Batiment(caserne, 3));
		 listeDeBatimentsDuTeamplate1.add(new Batiment(place_rassemblement, 1));
		 listeDeBatimentsDuTeamplate1.add(new Batiment(residence, 5));
		 listeDeBatimentsDuTeamplate1.add(new Batiment(marche, 3));
		 listeDeBatimentsDuTeamplate1.add(new Batiment(moulin, 5));
		 listeDeBatimentsDuTeamplate1.add(new Batiment(academie, 3));
		 
		 
		 
	//	 listeDeBatimentsDuTeamplate1.add(new Batiment(cachette, 10));
		 listeDeBatimentsDuTeamplate2.add(new Batiment(place_rassemblement, 1));
		 listeDeBatimentsDuTeamplate2.add(new Batiment(moulin, 3));
		 listeDeBatimentsDuTeamplate2.add(new Batiment(batiment_principal, 10));
		 listeDeBatimentsDuTeamplate2.add(new Batiment(depot, 11));
		 listeDeBatimentsDuTeamplate2.add(new Batiment(silo, 11));
		 listeDeBatimentsDuTeamplate2.add(new Batiment(moulin, 5));
		 listeDeBatimentsDuTeamplate2.add(new Batiment(residence, 10));
		 listeDeBatimentsDuTeamplate2.add(new Batiment(marche, 5));
		 listeDeBatimentsDuTeamplate2.add(new Batiment(caserne, 3));
		 listeDeBatimentsDuTeamplate2.add(new Batiment(palais, 10));
		 listeDeBatimentsDuTeamplate2.add(new Batiment(tailleur, 5));
		 listeDeBatimentsDuTeamplate2.add(new Batiment(academie, 5));
		// listeDeBatimentsDuTeamplate2.add(new Batiment(cachette, 10));
		 
		 
		 listeDeBatimentsDuTeamplate3.add(new Batiment(batiment_principal, 20));
		 listeDeBatimentsDuTeamplate3.add(new Batiment(poterie, 5));
		 listeDeBatimentsDuTeamplate3.add(new Batiment(scierie, 5));
		 listeDeBatimentsDuTeamplate3.add(new Batiment(fonderie, 5));
		 listeDeBatimentsDuTeamplate3.add(new Batiment(silo, 14));
		 listeDeBatimentsDuTeamplate3.add(new Batiment(depot, 14));
		 listeDeBatimentsDuTeamplate3.add(new Batiment(residence, 10));
		 listeDeBatimentsDuTeamplate3.add(new Batiment(moulin, 5));
		 listeDeBatimentsDuTeamplate3.add(new Batiment(marche, 15));
		 listeDeBatimentsDuTeamplate3.add(new Batiment(caserne, 5));
		 listeDeBatimentsDuTeamplate3.add(new Batiment(academie, 10));
		 listeDeBatimentsDuTeamplate3.add(new Batiment(palais, 20));
		 listeDeBatimentsDuTeamplate3.add(new Batiment(ecurie, 10));
		 listeDeBatimentsDuTeamplate3.add(new Batiment(comptoir, 5));
		 listeDeBatimentsDuTeamplate3.add(new Batiment(tailleur, 20));
		 listeDeBatimentsDuTeamplate3.add(new Batiment(place_rassemblement, 10));
		 listeDeBatimentsDuTeamplate3.add(new Batiment(boulangerie, 5));
		 // listeDeBatimentsDuTeamplate3.add(new Batiment(cachette, 10)); Chambre aux trésors
		 		 

		 listeDeBatimentsDuTeamplate4.add(new Batiment(poterie, 5));
		 listeDeBatimentsDuTeamplate4.add(new Batiment(scierie, 5));
		 listeDeBatimentsDuTeamplate4.add(new Batiment(fonderie, 5));
		 listeDeBatimentsDuTeamplate4.add(new Batiment(moulin, 5));
		 listeDeBatimentsDuTeamplate4.add(new Batiment(boulangerie, 5));
		 listeDeBatimentsDuTeamplate4.add(new Batiment(batiment_principal, 20));
		 listeDeBatimentsDuTeamplate4.add(new Batiment(silo, 20));
		 listeDeBatimentsDuTeamplate4.add(new Batiment(depot, 20));
		 listeDeBatimentsDuTeamplate4.add(new Batiment(marche, 20));
		 listeDeBatimentsDuTeamplate4.add(new Batiment(academie, 20));
		 listeDeBatimentsDuTeamplate4.add(new Batiment(hotel_de_ville, 15));
		 listeDeBatimentsDuTeamplate4.add(new Batiment(caserne, 16));
		 listeDeBatimentsDuTeamplate4.add(new Batiment(place_rassemblement, 15));
		 listeDeBatimentsDuTeamplate4.add(new Batiment(palais, 20));
		 listeDeBatimentsDuTeamplate4.add(new Batiment(residence, 20));
		 listeDeBatimentsDuTeamplate4.add(new Batiment(tailleur, 20));
		 listeDeBatimentsDuTeamplate4.add(new Batiment(grandSilo, 20));
		 listeDeBatimentsDuTeamplate4.add(new Batiment(grandDepot, 20));
		 listeDeBatimentsDuTeamplate4.add(new Batiment(forge, 20));
		 listeDeBatimentsDuTeamplate4.add(new Batiment(place_tournoi, 12));
		 listeDeBatimentsDuTeamplate4.add(new Batiment(cdt, 1));
		 listeDeBatimentsDuTeamplate4.add(new Batiment(ecurie, 10));
		 listeDeBatimentsDuTeamplate4.add(new Batiment(comptoir, 10));
		 // listeDeBatimentsDuTeamplate4.add(new Batiment(cachette, 10));
		 

	}



	public List<Batiment> getListeDeBatimentsDuTeamplate1() {
		return listeDeBatimentsDuTeamplate1;
	}
	public void setListeDeBatimentsDuTeamplate1(List<Batiment> listeDeBatimentsDuTeamplate1) {
		this.listeDeBatimentsDuTeamplate1 = listeDeBatimentsDuTeamplate1;
	}
	
	
	
	
	
	
	public List<Batiment> getListeDeBatimentsDuTeamplate2() {
		return listeDeBatimentsDuTeamplate2;
	}
	public void setListeDeBatimentsDuTeamplate2(List<Batiment> listeDeBatimentsDuTeamplate2) {
		this.listeDeBatimentsDuTeamplate2 = listeDeBatimentsDuTeamplate2;
	}
	
	
	
	
	
	
	public List<Batiment> getListeDeBatimentsDuTeamplate3() {
		return listeDeBatimentsDuTeamplate3;
	}
	public void setListeDeBatimentsDuTeamplate3(
			List<Batiment> listeDeBatimentsDuTeamplate3) {
		this.listeDeBatimentsDuTeamplate3 = listeDeBatimentsDuTeamplate3;
	}

	
	
	
	
	
	public List<Batiment> getListeDeBatimentsDuTeamplate4() {
		return listeDeBatimentsDuTeamplate4;
	}
	public void setListeDeBatimentsDuTeamplate4(
			List<Batiment> listeDeBatimentsDuTeamplate4) {
		this.listeDeBatimentsDuTeamplate4 = listeDeBatimentsDuTeamplate4;
	}



	public List<Batiment> etablirTeamplatePourUnVillage(int champMin) {
		if (champMin <= 4 ){return listeDeBatimentsDuTeamplate1;}
		if (champMin <= 8 && champMin >4){return listeDeBatimentsDuTeamplate2;}
		if (champMin < 10 && champMin > 7){return listeDeBatimentsDuTeamplate3;}
		if (champMin == 10){return listeDeBatimentsDuTeamplate4;}
		if (champMin > 10){return listeDeBatimentsDuTeamplate4;}
		return null;


	
	
	
	
	
	
	}
}
