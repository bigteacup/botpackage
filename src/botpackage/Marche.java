package botpackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class Marche {
	//	CalculsTravian calculs = new CalculsTravian();

	public Marche() {

	}

	public static void main(String[] args) {


	}


	int totalRessourcesEnvoyees;
	int compteurDeBootMemoire = 0;

	
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	//TODO faire cette analyse pour tout les village en meme temps par le compte +
	public void etablirBesoinEnRessources(Travian t, Village village, ArrayList<Village> listeDeVillages) {
		String nouveauVillage = "Nouveau village";
		//for village :listedDeVillage 
		//if (village.getChampsFinis() == false){
		boolean manqueB = village.getBois() <= village.getMaxStockDepot()/100*30;
		int manqueBois = village.getMaxStockDepot() - village.getBois() ;
		village.setManqueDeBois(manqueBois);

		boolean manqueA = village.getArgile() <= village.getMaxStockDepot()/100*30;
		int manqueArgile = village.getMaxStockDepot() - village.getArgile() ;
		village.setManqueDeArgile(manqueArgile);

		boolean manqueF = village.getFer() <= village.getMaxStockDepot()/100*30;
		int manqueFer = village.getMaxStockDepot() - village.getFer() ;
		village.setManqueDeFer(manqueFer);

		boolean manqueC = village.getCereales() <= village.getMaxStockSilo()/100*30;
		int manqueCereales = village.getMaxStockSilo() - village.getCereales() ;
		village.setManqueDeCereales(manqueCereales);

		/*	if(manqueB || manqueA || manqueF || manqueC){

				int pourcentage = 90 ;
				boolean continuer = true;

				//	if (listeDeVillages.size() > 1 ){
				while (continuer == true){
					if (listeDeVillages.size() <= 1 ){continuer=false;break;}
					for(Village villageBis : listeDeVillages){

						if(villageBis.getChampsFinis() == true){
							boolean tropBois = villageBis.getBois() >= villageBis.getMaxStockDepot()/100*pourcentage;
							boolean tropArgile = villageBis.getArgile() >= villageBis.getMaxStockDepot()/100*pourcentage;
							boolean tropFer = villageBis.getFer() >= villageBis.getMaxStockDepot()/100*pourcentage;
							boolean tropCereales = villageBis.getCereales() >= villageBis.getMaxStockSilo()/100*pourcentage;	

							if (tropBois && tropArgile && tropFer && tropCereales){
								//marche2(t, village, listeDeVillages);
								continuer = false;
								break;
							}

						}
					}

					pourcentage = pourcentage-10;
					if (pourcentage <= 10 ) {continuer =false; break;}
				}

			}
			//	}	
		 */
	}



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////




	////iunutilise
	public void marche2(Travian t, Village village, ArrayList<Village> listeVillage) {

		try {
			if (((village.getCereales() >= village.getMaxStockSilo()/100*90))&&(village.getVillageCapitale()==false)) {
				t.getCompte().getDriver().findElement(By.xpath("//*[contains(@class, 'marketWhite')]")).click();
				t.randomsleep.court();
				/*	try {	if (!t.getCompte().getDriver().getCurrentUrl().equals(t.getCompte().getServer()+"build.php?t=5&id=32")){
					t.getCompte().getDriver().findElement(By.xpath("//*[contains(@href, 'build.php?t=5&id=32')]")).click();
					t.randomsleep.court();
					}}catch(Exception e){t.ecrireDansConsole("Echec selection tab du marche ");}*/
				//t.getCompte().getDriver().findElement(By.xpath("//*[@id=\"r4\"]")).clear();
				t.getCompte().getDriver().findElement(By.xpath("//*[@id=\"r4\"]")).sendKeys("99999");
				t.randomsleep.court();
				t.getCompte().getDriver().findElement(By.xpath("//*[@id=\"addRessourcesLink4\"]")).click();
				t.randomsleep.court();
				t.getCompte().getDriver().findElement(By.xpath("//*[@id=\"x2\"]/option[3]")).click();
				t.randomsleep.court();
				t.getCompte().getDriver().findElement(By.xpath("//*[@id=\"enterVillageName\"]")).sendKeys("1 Village");
				t.getCompte().getDriver().findElement(By.xpath("//*[@id=\"enabledButton\"]/div/div[2]")).click();
				t.randomsleep.court();
				t.getCompte().getDriver().findElement(By.xpath("//*[@id=\"enabledButton\"]/div/div[2]")).click();

			}		
		}catch(Exception e){t.ecrireDansConsole("Echec evacuation cereales marche : marche2 ", true);}
	}





/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	//ne pas utiliser code faux
	//definir longlet favori  //*[contains(@class, 'favorActive')] https://ts4.travian.fr/build.php?t=5&id=37 //*[not(contains(@class,'Active'))] //*[contains(@class, 'container')] //*[contains(@class, 'tabItem')]
	public void allerSurPageEnvoi(Travian t) {
		try {
			if (!t.getCompte().getDriver().getCurrentUrl().contains("t=5") || !t.getCompte().getDriver().getCurrentUrl().contains("t=1") || !t.getCompte().getDriver().getCurrentUrl().contains("t=2") ) {




				List<WebElement> listeDesTabs = t.getCompte().getDriver().findElements(By.xpath("//*[contains(@class, 'container')] //*[contains(@class, 'tabItem')]"));  //*[@class=\"tabItem\"]
				for (WebElement tabGestion : listeDesTabs) {

					if (tabGestion.getText().contains("Envoi")) {      
						tabGestion.click();
						t.randomsleep.court();
						break;
					}

				}
			}
		} catch (Exception e) {
			t.ecrireDansConsole("bug :)", true);
		}
	}


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	////////dans la page marche  try{ allerSurPageEnvoi(t);}catch(Exception e) {t.ecrireDansConsole("Echec aller sur la page envoi du marché  :)");}
	public int updateNombreDeMarchandsDispo(Travian t, Village village){ 

		//TODO gerer la quantité en cas d'echec de prise de la valeur
		WebElement webElementmarchandDispo;
		String nombreMarchandDispoString;
		int nombreMarchandDispoInteger = 20;
		try {
			village = t.villageEnCours();
			webElementmarchandDispo = t.getCompte().getDriver().findElement(By.xpath("//*[@id=\"build\"]/div[2]/div[10]/span"));
			nombreMarchandDispoString = webElementmarchandDispo.getText().replaceAll("\\W", "");
			nombreMarchandDispoInteger = Integer.valueOf(nombreMarchandDispoString); 
			village.setNombreDeMarchands(nombreMarchandDispoInteger);
		} catch (Exception e) {
			try {
				village = t.villageEnCours();
				webElementmarchandDispo = t.getCompte().getDriver().findElement(By.xpath("//*[@id=\"build\"]/div[4]")); //*[@id="build"]/div[4]/text()[1]
				nombreMarchandDispoString = webElementmarchandDispo.getText().split("\n")[0].split("/")[0].split(": ‭")[1];
				nombreMarchandDispoString = nombreMarchandDispoString.replaceAll("\\W", "").replaceAll("[\\u202D\\u202C.]", "").replace(".", "").replace(" ", "");
				nombreMarchandDispoInteger = Integer.valueOf(nombreMarchandDispoString); 
				village.setNombreDeMarchands(nombreMarchandDispoInteger);
			}catch(Exception e1) {
				t.ecrireDansConsole("echec updateNombreDeMarchandsDispo valeur par default : " + nombreMarchandDispoInteger, true );}

		}
		return nombreMarchandDispoInteger;
	}

	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public int updateQuantiteMaxTransporteParMarchand(Travian t, Village village, int token){
		//TODO gerer la quantité en cas d'echec de prise de la valeur
		String quantiteMaxParMarchandString;
		int quantiteMaxParMarchandInteger = 750;
		token = token + 1;

		try {
			village = t.villageEnCours();
			quantiteMaxParMarchandString = t.getCompte().getDriver().findElement(By.xpath("//*[@id=\"addRessourcesLink4\"]")).getText().replaceAll("\\W", "");
			quantiteMaxParMarchandInteger = Integer.valueOf(quantiteMaxParMarchandString);
			village.setQuantiteMaxTransporteeParMarchands(quantiteMaxParMarchandInteger);
			t.ecrireDansConsole("reussite updateQuantiteMaxTransporteParMarchand valeur : " + quantiteMaxParMarchandInteger, true ); 
		} catch (Exception e) {
			if(token <= 6) {
				village = t.villageEnCours();
				changementOngletMarche(t, village, token, "Envoi");
				quantiteMaxParMarchandInteger = updateQuantiteMaxTransporteParMarchand(t, village, token);
			}else {
				t.ecrireDansConsole("echec [On change d'onglet] " + token, true );


			}//t.ecrireDansConsole("echec updateQuantiteMaxTransporteParMarchand valeur : " + quantiteMaxParMarchandInteger +" " + token); 
		}
		return quantiteMaxParMarchandInteger;

	}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


	public void changementOngletMarche(Travian t,Village village, int token, String titreOnglet) {
		try {
			t.ecrireDansConsole("ChangementOnglet " + token, true );
			List<WebElement> listeDesTabs = t.getCompte().getDriver().findElements(By.xpath("//*[contains(@class, 'container')] //*[contains(@class, 'tabItem')]"));  //*[@class=\"tabItem\"]
			
			try {
				WebElement ongletActuel = t.getCompte().getDriver().findElement(By.xpath("//*[contains(@class, 'container active')]")) ;
				if(ongletActuel.getText().toLowerCase().trim().contains(titreOnglet.toLowerCase())) {
					t.ecrireDansConsole("Nous somme deja sur le bon onglet : "  + titreOnglet, true);
				} else {
					
					for (WebElement tabGestion : listeDesTabs) {
						if (tabGestion.getText().contains(titreOnglet)) { 

							tabGestion.click();
							t.randomsleep.court();
							break;
						}

					}
					
					
				}
				
			
					 
				
				
			}catch(Exception e3) {
				for (WebElement tabGestion : listeDesTabs) {
					if (tabGestion.getText().contains(titreOnglet)) { 

						tabGestion.click();
						t.randomsleep.court();
						break;
					}

				}
				
				
			}
			


		}catch (Exception e1) {
			t.ecrireDansConsole("echec changementOngletMarche  "  + token, true); 
		}

	}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



	///////////////////////////////////////////////efficace en serveur vitesse 1, pour village sources dont les depots sont superieurs a 4000 en germain, 3100 en gaulois, 2000 en romains sans comptoir du commerce.   
	public void evacuerSurplusRessources(Travian t, Village village, ArrayList<Village> listeDeVillages ) {

		t.ecrireDansConsole("[Marché] evacuerSurPlusRessources Début", true);


		try {
			//Maj  TODO mettre les valuer de la fenetreJAvafx des ressource mini a 20. Comprenne qui pourra Olgogol
			village.updateRessources(t);
			//test des ressources
			int pourcentageRegimeGeneral = t.bot.evacuerAPartirDe; //pourcentage de remplissage au dela duquel s'executer
			int pourcentageBois = t.bot.evacuerAPartirDe;
			int pourcentageArgile = t.bot.evacuerAPartirDe;
			int pourcentageFer = t.bot.evacuerAPartirDe;
			int pourcentageCereales = t.bot.evacuerAPartirDe;
			int	pourcentageBoisMin = t.bot.pourcentageNePasLaisserLeVillageSourceEnDessousDe;
			int pourcentageArgileMin = t.bot.pourcentageNePasLaisserLeVillageSourceEnDessousDe;
			int pourcentageFerMin = t.bot.pourcentageNePasLaisserLeVillageSourceEnDessousDe;
			int pourcentageCerealesMin = t.bot.pourcentageNePasLaisserLeVillageSourceEnDessousDe;
			int pourcentageDepotSiloMaxPonctionnable = t.bot.pourcentageDepotSiloMaxPonctionnable;
			if (village.regimeGeneral == false){
				//max vider quand
				pourcentageBois = village.getRegimeMarcheBoisMax();
				pourcentageArgile = village.getRegimeMarcheArgileMax();
				pourcentageFer = village.getRegimeMarcheFerMax();
				pourcentageCereales = village.getRegimeMarcheCerealesMax();
				//min ne pas vider en dessous de
				pourcentageBoisMin = village.getRegimeMarcheBoisMin();
				pourcentageArgileMin = village.getRegimeMarcheArgileMin();
				pourcentageFerMin = village.getRegimeMarcheFerMin();
				pourcentageCerealesMin = village.getRegimeMarcheCerealesMin();
				t.ecrireDansConsole("[Marché] Prise des valeurs personnalisées", true);
			}
			t.ecrireDansConsole(" Pourcentage de Vidage Marché en cours --> Regime General (par default) : "+pourcentageRegimeGeneral+" |Bois : "+pourcentageBois+" | Argile : "+pourcentageArgile+" |Fer : "+pourcentageFer+" |Cereales : "+pourcentageCereales+"", true);
			int pourcentageNePasLaisserLeVillageSourceEnDessousDe = t.bot.pourcentageNePasLaisserLeVillageSourceEnDessousDe;
			t.ecrireDansConsole("pourcentageNePasLaisserLeVillageSourceEnDessousDe en cours --> Regime General (par default) : "+pourcentageNePasLaisserLeVillageSourceEnDessousDe +" |Bois : "+pourcentageBoisMin+" | Argile : "+pourcentageArgileMin+" |Fer : "+pourcentageFerMin+" |Cereales : "+pourcentageCerealesMin+"", true);
			boolean tropBois = village.getBois() >= village.getMaxStockDepot()/100*pourcentageBois;
			boolean tropArgile = village.getArgile() >= village.getMaxStockDepot()/100*pourcentageArgile;
			boolean tropFer = village.getFer() >= village.getMaxStockDepot()/100*pourcentageFer;
			boolean tropCereales = village.getCereales() >= village.getMaxStockSilo()/100*pourcentageCereales;
			//on trouve combien de ressources necessite d'etre evacuee
			int nombreDeBesoin = 0 ; // on remet a zero //par default
			if (tropBois){nombreDeBesoin++;}
			if (tropArgile){nombreDeBesoin++;}
			if (tropFer){nombreDeBesoin++;}
			if (tropCereales){nombreDeBesoin++;}

			if(nombreDeBesoin >= 1 ){
				allerDansLeMarché(t);
				//maj
				int marchandsDisponibles = updateNombreDeMarchandsDispo(t, village);
				int quantite = updateQuantiteMaxTransporteParMarchand(t, village, 0);
				//	village.setQuantiteMaxTransporteParMarchand

				if (marchandsDisponibles > 0 ){

					//On alloue le nombre de marchands par type de ressources
					int marchandsAllouesParRessource = marchandsDisponibles/nombreDeBesoin;

					//on fait une liste//////////////////////////////////////////////////////////////////////////////////////////////////////////////
					if(tropBois){
				//		t.randomsleep.tcourt(); //test
						int i=0;
						//on s'assure de ne pas envoyer plus de tant de pourcents d'une ressources
						int marchandsAllouesPourBois = marchandsAllouesParRessource;
						
						while (village.getBois() - (marchandsAllouesPourBois*quantite) <   village.getMaxStockDepot()/100*pourcentageBoisMin){
							marchandsAllouesPourBois--;
						}
						while ( marchandsAllouesPourBois*quantite > (village.getMaxStockDepot()/100*pourcentageDepotSiloMaxPonctionnable) ){
							marchandsAllouesPourBois--;
									}
						//
						String nomOrdre = "Bois";
						Ordre ordreDeBois = new Ordre(); 
						village.listeOrdresMarcheDeLaRotation.add(ordreDeBois);
						ordreDeBois.setNomOrdre(nomOrdre);
						ordreDeBois.setNombreDeClic(marchandsAllouesPourBois);

					}

					if(tropArgile){
				//		t.randomsleep.tcourt(); //test
						int i=0;
						//on s'assure de ne pas envoyer plus de tant de pourcents d'une ressources //TODO reflechir a cela
						int marchandsAllouesPourArgile = marchandsAllouesParRessource;
						while (village.getArgile() - (marchandsAllouesPourArgile*quantite) < village.getMaxStockDepot()/100*pourcentageArgileMin){
							marchandsAllouesPourArgile--;
						}
						while (marchandsAllouesPourArgile*quantite > (village.getMaxStockDepot()/100*pourcentageDepotSiloMaxPonctionnable) ){
							marchandsAllouesPourArgile--;
						}
						//
						String nomOrdre = "Argile";
						Ordre ordreDeArgile = new Ordre(); 
						village.listeOrdresMarcheDeLaRotation.add(ordreDeArgile);
						ordreDeArgile.setNomOrdre(nomOrdre);
						ordreDeArgile.setNombreDeClic(marchandsAllouesPourArgile);

					}

					if(tropFer){
					//	t.randomsleep.tcourt(); //test
						int i=0;
						//on s'assure de ne pas envoyer plus de tant de pourcents d'une ressources
						int marchandsAllouesPourFer = marchandsAllouesParRessource;
						while (village.getFer() - (marchandsAllouesPourFer*quantite) < village.getMaxStockDepot()/100*pourcentageFerMin){
							marchandsAllouesPourFer--;
						}
						while (marchandsAllouesPourFer*quantite > (village.getMaxStockDepot()/100*pourcentageDepotSiloMaxPonctionnable) ){
							marchandsAllouesPourFer--;
						}
						//
						String nomOrdre = "Fer";
						Ordre ordreDeFer = new Ordre(); 
						village.listeOrdresMarcheDeLaRotation.add(ordreDeFer);
						ordreDeFer.setNomOrdre(nomOrdre);
						ordreDeFer.setNombreDeClic(marchandsAllouesPourFer);


					}

					if(tropCereales){
					//	t.randomsleep.tcourt(); //test
						int i=0;
						//on s'assure de ne pas envoyer plus de tant de pourcents d'une ressources
						int marchandsAllouesPourCereales = marchandsAllouesParRessource;
						while (village.getCereales() - (marchandsAllouesPourCereales*quantite) < village.getMaxStockSilo()/100*pourcentageCerealesMin){
							marchandsAllouesPourCereales--;
						}
						while (marchandsAllouesPourCereales*quantite > (village.getMaxStockDepot()/100*pourcentageDepotSiloMaxPonctionnable) ){
							marchandsAllouesPourCereales--;
						}
						//
						String nomOrdre = "Cereales";
						Ordre ordreDeCereales = new Ordre(); 
						village.listeOrdresMarcheDeLaRotation.add(ordreDeCereales);
						ordreDeCereales.setNomOrdre(nomOrdre);
						ordreDeCereales.setNombreDeClic(marchandsAllouesPourCereales);

					}

					envoyerMarchandsSelectionDuVillageCible(t, village, listeDeVillages, quantite);


				}
			}

		}catch(Exception e){t.ecrireDansConsole("Echec evacuation cereales marche, Pas de marche ?  Ou pas de compte + ? Bug general", true);}
		t.ecrireDansConsole("[Marché] evacuerSurPlusRessources Fin", true);
	}

///////////////////////////////////////////////////////
	//////////////////////////////////////////////////
	/////////////////////////////////////////////////
	
	
	
	//////////////////////////////////////////////////
	/////////////////////////////////////////////////
	//////////////////////////////////////////////////
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	
	
	
	
	

	//TODO revoir la facon de placer les calculs et les indication de temps et distance et sur calculsTravian
	//Selection du village cible pour chaque ordre
	public void envoyerMarchandsSelectionDuVillageCible(Travian t, Village village, ArrayList<Village> listeDeVillages, int quantite) {
		//if (cap en neg){ village a envoyer}
		//else { 
		int pourcentage = 10; //on par du bas, ne pas toucher svp
		boolean continuer = true;
		String villageCibleNom = "nompardefault";
		String savePourFin = villageCibleNom;



		//

		try {
			for(Ordre ordre : village.listeOrdresMarcheDeLaRotation){
				continuer = true; //on remet par default
				pourcentage = 10; //on remet par default
				int nbrVillageTropLoin = 0;




				while (continuer == true){			
					int ressource = 0;
					int maxDepotSilo = 0; 
					int manqueDeCetteRessource =0;


					for (Village villageCible : listeDeVillages) {

						double distance ;
						double temps ;
						int distanceMax;
						int vitesseMarchands = t.bot.vitesseMarchands  ; //gaulois = 24 romains = 16 germains = 12
						distanceMax = t.bot.distanceMaxPourMarchands; //en cases
						distance = t.calculs.calculDeDistance(village.getX(), village.getY(), villageCible.getX(), villageCible.getY(),false);
						temps = t.calculs.tempsDeTrajet(distance, vitesseMarchands, 0, 0, 0, false);
						int memRot = 0;

						if(distance < distanceMax && distance > 0.0  ){ //&& pourcentage < 100





							// TODO  premier tour -> ca ne prends pas de villages -> manquederessource basé sur silo par default = 800 
							if (!villageCible.getNom().equals(village.getNom())){

								//on selctionne l'ordre et on rempli en consequence les variables
								if(ordre.getNomOrdre() == "Bois"){
									ressource = villageCible.getBois();
									maxDepotSilo = villageCible.getMaxStockDepot(); 
									manqueDeCetteRessource = villageCible.getMaxStockDepot()- villageCible.getBois() - villageCible.memoireMarcheDeLaRotation[0];
									memRot = villageCible.memoireMarcheDeLaRotation[0];
								}

								if(ordre.getNomOrdre() == "Argile"){
									ressource = villageCible.getArgile();
									maxDepotSilo = villageCible.getMaxStockDepot();
									manqueDeCetteRessource =villageCible.getMaxStockDepot()- villageCible.getArgile()- villageCible.memoireMarcheDeLaRotation[1];
									memRot = villageCible.memoireMarcheDeLaRotation[1];
								}

								if(ordre.getNomOrdre() == "Fer"){
									ressource = villageCible.getFer();maxDepotSilo = villageCible.getMaxStockDepot();

									manqueDeCetteRessource = villageCible.getMaxStockDepot()- villageCible.getFer()- villageCible.memoireMarcheDeLaRotation[2];
									memRot = villageCible.memoireMarcheDeLaRotation[2];
								}

								if(ordre.getNomOrdre() == "Cereales"){
									ressource = villageCible.getCereales();
									maxDepotSilo = villageCible.getMaxStockSilo();
									manqueDeCetteRessource = villageCible.getMaxStockSilo()- villageCible.getCereales()- villageCible.memoireMarcheDeLaRotation[3];
									memRot = villageCible.memoireMarcheDeLaRotation[3];
								}

								//on y go //TODO tester memRot
								if (ressource + memRot  <= maxDepotSilo/100*pourcentage &&  manqueDeCetteRessource > ordre.getNombreDeClic()*quantite ){// village.getMaxStockDepot()- Village.getFer(); 
									villageCibleNom = villageCible.getNom();
									ordre.setVillageCible(villageCibleNom);
									continuer = false;
									t.ecrireDansConsole("[Ordre]"+village.getNom()+" enverra sur "+villageCibleNom, true );
									t.calculs.calculDeDistance(village.getX(), village.getY(), villageCible.getX(), villageCible.getY(),true);
									t.calculs.tempsDeTrajet(distance, vitesseMarchands, 0, 0,0, true);
									break;
								}

								if (pourcentage == 100){
									continuer=false;	
									t.ecrireDansConsole("[Marché]Pas de villages ayant la capacitée pour evacuer cette ressource : " +ordre.getNomOrdre(), true);
									break;}


							}



						}else {
							if(distance == 0.0) {
								t.ecrireDansConsole("[Marché] " + villageCible.getNom() + " ne peut pas s'envoyer a lui meme. Pourcentage actuel : " + pourcentage, true);
								if (pourcentage >= 100){
									continuer=false;	
									t.ecrireDansConsole("[Marché]Pas de villages é portée pour evacuer cette ressource : " +ordre.getNomOrdre(), true);
									break;
								}

							}
							//	nbrVillageTropLoin++;
							if(distance > 0.0) {
								t.ecrireDansConsole("[Marché] " + villageCible.getNom() + " est trop eloigné. Pourcentage actuel : " + pourcentage, true);
								if (pourcentage >= 100){
									continuer=false;	
									t.ecrireDansConsole("[Marché]Pas de villages à portée pour evacuer cette ressource : " +ordre.getNomOrdre(), true);
									break;
								}
								//	if (nbrVillageTropLoin >= listeDeVillages.size() && pourcentage >= 100 ){
								//		continuer = false;
								//		t.ecrireDansConsole("[Marché] Pas de village a proximité suffisante");
								//		nbrVillageTropLoin=0;	
								//	}
							}
						}

					}
					//apres avoir parcouru tous les village avec une valur donnée, on incremente pour recommencer avec une valeur plus elevée
					pourcentage = pourcentage+10;

				}
			}

			if(!villageCibleNom.equals(savePourFin)){
				envoyerMarchandsCliquage(t, village, listeDeVillages, quantite);
			}

		} catch (Exception e) {
			t.ecrireDansConsole("echec envoyerMarchandSelectionDuVillageCible", true);
		}	

	}

	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


	// cliquer en regroupant les Ordre ayant la meme cible
	public void envoyerMarchandsCliquage(Travian t, Village village, ArrayList<Village> listeDeVillages, int quantite) {
		//TODO En cas d'un seul marchand et de plusieur ressources a effectuer, il faut detecter l'erreure (le bot essaye d'envoyer 0 de ressource et donc ne clique pas...)
		int typeDeRessource =0; 
		String cible = "null";
		try {
			for (Village villageCiblebis : listeDeVillages){

				for(Ordre ordre : village.listeOrdresMarcheDeLaRotation){

					if(ordre.getVillageCible().equals(villageCiblebis.getNom()) && ordre.getVivant() == true && ordre.getNombreDeClic()>0){ //test correction de tentatvie de clic a 0
						cible = ordre.getVillageCible();

						if (ordre.getNomOrdre().equals("Bois")){ typeDeRessource = 1;   }
						if (ordre.getNomOrdre().equals("Argile")){ typeDeRessource = 2; }
						if (ordre.getNomOrdre().equals("Fer")){ typeDeRessource = 3; }
						if (ordre.getNomOrdre().equals("Cereales")){ typeDeRessource = 4; }
						//on clic autant de fois que de marchands attribués
						int i = 0;
						while( i < ordre.getNombreDeClic()){
							t.getCompte().getDriver().findElement(By.xpath("//*[@id=\"addRessourcesLink"+typeDeRessource +"\"]")).click();
							i++;

							t.randomsleep.tcourt();
						}

						ordre.setVivant(false);
						totalRessourcesEnvoyees =ordre.getNombreDeClic()*quantite;
						ordre.AjouterAuTotalDeRessourcesEnvoyees(totalRessourcesEnvoyees); //donnee inutilisee pour le moment


					}
				}
				if (!cible.equals("null")){
					if (envoyerMarchands(t, cible)){

						//
						// TODO Iterator : cest fait, mais penser a l'utiliser plus souvent
						Iterator<Ordre> ordreEnvoyesIter = village.listeOrdresMarcheDeLaRotation.iterator();
						while ( ordreEnvoyesIter.hasNext() ) {
							Ordre ordreEnvoyes = ordreEnvoyesIter.next();
							if (ordreEnvoyes.getVivant() == false) {

								int	ressourcesEnvoyees	= ordreEnvoyes.getNombreDeClic()*quantite;

								if (ordreEnvoyes.getNomOrdre().equals("Bois")){ typeDeRessource = 1; 
								villageCiblebis.memoireMarcheDeLaRotation[0] = villageCiblebis.memoireMarcheDeLaRotation[0]+ ressourcesEnvoyees;  }
								if (ordreEnvoyes.getNomOrdre().equals("Argile")){ typeDeRessource = 2;
								villageCiblebis.memoireMarcheDeLaRotation[1] = villageCiblebis.memoireMarcheDeLaRotation[1]+ ressourcesEnvoyees;  }
								if (ordreEnvoyes.getNomOrdre().equals("Fer")){ typeDeRessource = 3;
								villageCiblebis.memoireMarcheDeLaRotation[2] = villageCiblebis.memoireMarcheDeLaRotation[2]+ ressourcesEnvoyees;  }
								if (ordreEnvoyes.getNomOrdre().equals("Cereales")){ typeDeRessource = 4;
								villageCiblebis.memoireMarcheDeLaRotation[3] = villageCiblebis.memoireMarcheDeLaRotation[3]+ ressourcesEnvoyees;  }

								t.ecrireDansConsole("[Marché] " +village.getNom()+ " envoi " + ressourcesEnvoyees +  " de " +ordreEnvoyes.getNomOrdre()+" sur " + cible, true);
								// On supprime l'élément courant de la liste
								ordreEnvoyesIter.remove(); // 
							}
						}
						// on peut pas remove un truc avec for, faut faire un iterator...	
						/*		for(Ordre ordreEnvoyes : village.listeOrdresMarcheDeLaRotation){

							if (ordreEnvoyes.getVivant() == false){
							int	ressourcesEnvoyees	= ordreEnvoyes.getNombreDeClic()*quantite;
								if (ordreEnvoyes.getNomOrdre().equals("Bois")){ typeDeRessource = 1; villageCiblebis.memoireMarcheDeLaRotation[0] = villageCiblebis.memoireMarcheDeLaRotation[0]+ ressourcesEnvoyees;  }
								if (ordreEnvoyes.getNomOrdre().equals("Argile")){ typeDeRessource = 2; villageCiblebis.memoireMarcheDeLaRotation[1] = villageCiblebis.memoireMarcheDeLaRotation[0]+ ressourcesEnvoyees;  }
								if (ordreEnvoyes.getNomOrdre().equals("Fer")){ typeDeRessource = 3; villageCiblebis.memoireMarcheDeLaRotation[2] = villageCiblebis.memoireMarcheDeLaRotation[0]+ ressourcesEnvoyees;  }
								if (ordreEnvoyes.getNomOrdre().equals("Cereales")){ typeDeRessource = 4; villageCiblebis.memoireMarcheDeLaRotation[3] = villageCiblebis.memoireMarcheDeLaRotation[0]+ ressourcesEnvoyees;  }
							t.ecrireDansConsole("[Marché] " +village.getNom()+ " envoi " + ressourcesEnvoyees +  " de " +ordreEnvoyes.getNomOrdre()+" sur " + cible);
							village.listeOrdresMarcheDeLaRotation.remove(ordreEnvoyes); // ou modifer cette fonction pour juste ne pas repeter les anciens ordres
							}
						}*/
					}
					cible = "null";
				}
			}

		} catch (Exception e) {
			t.ecrireDansConsole("echec envoyerMarchandCliquage : Probable changement de village ou marche lvl 0 (en construction ver lvl 1)", true);
		}	

	}



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	//fonction envoyer sur une cible
	public boolean envoyerMarchands(Travian t, String villageCibleNom) {
		String savePourFin = "nompardefault";
		boolean ok = false;

		if(!villageCibleNom.equals(savePourFin)){
			try {

				/////mode envoyer en plusieur fois
				try {
					t.getCompte().getDriver().findElement(By.xpath("//*[@id='x2']/option[1]")).click(); //*[@id='x2']/option[1] | //*[@id='x2']
				}catch (Exception e){t.ecrireDansConsole("Pas de club Gold ou echec", true);}
				t.randomsleep.tcourt();
				//nom du village receveur
				WebElement enterVillageName = t.getCompte().getDriver().findElement(By.xpath("//*[@id='enterVillageName']"));
				enterVillageName.clear();
				t.randomsleep.tcourt();
				t.getCompte().getDriver().findElement(By.xpath("//*[@id='enterVillageName']")).sendKeys(villageCibleNom);
				t.randomsleep.tcourt();
				t.getCompte().getDriver().findElement(By.xpath("//*[@id='enabledButton']/div/div[2]")).click();
				t.randomsleep.court();
				t.getCompte().getDriver().findElement(By.xpath("//*[@id='enabledButton']/div/div[2]")).click();
				t.randomsleep.court();
				Village village = t.villageEnCours();
				updateNombreDeMarchandsDispo(t, village);
				village.updateRessources(t);
				//	t.ecrireDansConsole("[Marché]"+ t.villageEnCours().getNom() + " envoi : "+totalRessourcesEnvoyees+ " de type "+ " sur "  +villageCibleNom);
				ok = true;

			} catch (Exception e) {
				Village village = t.villageEnCours();
				t.ecrireDansConsole("echec envoyerMarchand", true);
				village.updateRessources(t);
			}	
		}
		return ok;

	}









	/*
	//	

	public void approPetitVillage(Travian t, Village village, ArrayList<Village> listeDeVillages){
		try {
			if (village.getChampMin() <= t.bot.champMinFx){
				totalRessourcesEnvoyees = 0; // TODO attention bug par default pour pas reprendre l'ancienne valeur sil y a eu un echec
				int pourcentageApproPetitVillage = t.bot.pourcentageApproPetitVillageFx;
				int ressourcesMiniSurVillageSource = t.bot.ressourcesMiniSurVillageSourceFx;
				int DepotMiniPourAider = 9600;
				boolean continuer = true;
				boolean manqueB = village.getBois() <= village.getMaxStockDepot()/100*pourcentageApproPetitVillage;
				boolean manqueA = village.getArgile() <= village.getMaxStockDepot()/100*pourcentageApproPetitVillage;
				boolean manqueF = village.getFer() <= village.getMaxStockDepot()/100*pourcentageApproPetitVillage;
				boolean manqueC = village.getCereales() <= village.getMaxStockSilo()/100*pourcentageApproPetitVillage;

				int manqB =village.getMaxStockDepot() - village.getBois();
				int manqA =village.getMaxStockDepot() - village.getArgile();
				int manqF =village.getMaxStockDepot() - village.getFer();
				int manqC =village.getMaxStockSilo() - village.getCereales();

				int nombreDeBesoin = 0 ; // on remet a zero //par default
				if (manqueB){nombreDeBesoin++;}
				if (manqueA){nombreDeBesoin++;}
				if (manqueF){nombreDeBesoin++;}
				if (manqueC){nombreDeBesoin++;}

				//TODO//reactualiser le nombre marchands pour eviter de tout verifier ?
				if(nombreDeBesoin >= 1){
					for (Village villageCandidat : listeDeVillages) {
					int vilNombrMarch =villageCandidat.getNombreDeMarchands();
					//On alloue le nombre de marchands max par type de ressources : methode a changer
					 int marchandsMaxAllouesParRessource = villageCandidat.getNombreDeMarchands()/nombreDeBesoin;

					if(manqueB == true){
								////////////////////////////////////////////bois //TODO
								if (villageCandidat.getBois() > manqB && manqB <=(villageCandidat.getNombreDeMarchands() * villageCandidat.getQuantiteMaxTransporteeParMarchands())){
									//calcul nombre de marchands
									int m = marchandsMaxAllouesParRessource;
									while (village.getBois() + (marchandsMaxAllouesParRessource*villageCandidat.QuantiteMaxTransporteeParMarchands) > village.getMaxStockDepot()){ //villageCandidat.getNombreDeMarchands()
									m--;		
									}
									// ordre
								String nomOrdre = "miniBois";
								Ordre ordreMiniBois = new Ordre(); 
								villageCandidat.listeOrdresMarcheDeLaRotation.add(ordreMiniBois);
								//ordreMiniBois.set
								ordreMiniBois.setNomOrdre(nomOrdre);
								ordreMiniBois.setNombreDeClic(m);
								ordreMiniBois.setVillageCible(village.getNom());
								ordreMiniBois.setVillageSource(villageCandidat.getNom());
								manqueB = false;

								}
				}				
					if(manqueA == true){				
								///////////////////////////////////////argile 
						if (villageCandidat.getArgile() > manqA && manqA <=(villageCandidat.getNombreDeMarchands() * villageCandidat.getQuantiteMaxTransporteeParMarchands())){
							//calcul nombre de marchands
							int m = marchandsMaxAllouesParRessource;
							while (village.getArgile() + (marchandsMaxAllouesParRessource*villageCandidat.QuantiteMaxTransporteeParMarchands) > village.getMaxStockDepot()){ //villageCandidat.getNombreDeMarchands()
							m--;

							}
									// ordre
								String nomOrdre = "miniArgile";
								Ordre ordreMiniArgile = new Ordre(); 
								villageCandidat.listeOrdresMarcheDeLaRotation.add(ordreMiniArgile);
								ordreMiniArgile.setNomOrdre(nomOrdre);
								ordreMiniArgile.setNombreDeClic(m);
								ordreMiniArgile.setVillageCible(village.getNom());
								ordreMiniArgile.setVillageSource(villageCandidat.getNom());
								manqueA = false;
								}
					}						
					if(manqueF == true){							
								///////////////////////////////////////////////////////fer
						if (villageCandidat.getFer() > manqF && manqF <=(villageCandidat.getNombreDeMarchands() * villageCandidat.getQuantiteMaxTransporteeParMarchands())){
							//calcul nombre de marchands
							int m = marchandsMaxAllouesParRessource;
							while (village.getFer() + (marchandsMaxAllouesParRessource*villageCandidat.QuantiteMaxTransporteeParMarchands) > village.getMaxStockDepot()){ //villageCandidat.getNombreDeMarchands()
							m--;		
							}
									// ordre
								String nomOrdre = "miniFer";
								Ordre ordreMiniFer = new Ordre(); 
								villageCandidat.listeOrdresMarcheDeLaRotation.add(ordreMiniFer);
								ordreMiniFer.setNomOrdre(nomOrdre);
								ordreMiniFer.setNombreDeClic(m);
								ordreMiniFer.setVillageCible(village.getNom());
								ordreMiniFer.setVillageSource(villageCandidat.getNom());
								manqueF = false;
								}
					}
					if(manqueC == true){		
								////////////////////////////////////////////cereales
						if (villageCandidat.getCereales() > manqC && manqC <=(villageCandidat.getNombreDeMarchands() * villageCandidat.getQuantiteMaxTransporteeParMarchands())){
							//calcul nombre de marchands
							int m = marchandsMaxAllouesParRessource;
							while (village.getCereales() + (marchandsMaxAllouesParRessource*villageCandidat.QuantiteMaxTransporteeParMarchands) > village.getMaxStockSilo()){ //villageCandidat.getNombreDeMarchands()
							m--;		
							}
									// ordre
								String nomOrdre = "miniCereales";
								Ordre ordreMiniCereales = new Ordre(); 
								villageCandidat.listeOrdresMarcheDeLaRotation.add(ordreMiniCereales);
								ordreMiniCereales.setNomOrdre(nomOrdre);
								ordreMiniCereales.setNombreDeClic(m);
								ordreMiniCereales.setVillageCible(village.getNom());
								ordreMiniCereales.setVillageSource(villageCandidat.getNom());
								manqueC = false;
						}
					}
				}					
								t.randomsleep.court();
							//	t.getCompte().getDriver().get(villageCandidat.getUrl());
								t.randomsleep.court();
								t.getCompte().getDriver().findElement(By.xpath("//*[contains(@class, 'marketWhite')]")).click();
								t.randomsleep.court();
								t.getCompte().getDriver().findElement(By.xpath("//*[@id=\"addRessourcesLink1\"]")).click();
								t.randomsleep.tcourt();
								t.getCompte().getDriver().findElement(By.xpath("//*[@id=\"addRessourcesLink2\"]")).click();
								t.randomsleep.tcourt();
								t.getCompte().getDriver().findElement(By.xpath("//*[@id=\"addRessourcesLink3\"]")).click();
								t.randomsleep.tcourt();
								t.getCompte().getDriver().findElement(By.xpath("//*[@id=\"addRessourcesLink4\"]")).click();
								t.randomsleep.tcourt();
								t.ecrireDansConsole("[Marché] ApproPetitVillage");
								if(envoyerMarchands(t, village.getNom())){
									t.ecrireDansConsole("[Marché][Appro Petits Villages]"+ t.villageEnCours().getNom() + " envoi : "+totalRessourcesEnvoyees+ " de type "+ " sur "  +village.getNom());
								}
								t.randomsleep.court();
								t.getCompte().getDriver().get(village.getUrl());
								t.randomsleep.court();

								//TODO Changement de page a changer en mode secure et non en get
				//				break;
				}	
			//	envoyerMarchandsCliquage(t, village, listeDeVillages, quantite);
			}	
		}catch (Exception e){t.ecrireDansConsole("echec approPetitVillage");}
	//}



	 */
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void allerDansLeMarché(Travian t){
		try {// on vas sur le marché
			WebElement titre;
			String titreString = "";
			try {
			titre = t.getCompte().getDriver().findElement(By.xpath("//*[@id=\"content\"]/h1"));
			titreString = titre.getText().trim();
			}catch (Exception ea) {
				
			}
			if(!titreString.toLowerCase().contains(TemplatesDeVillages.marche.toLowerCase())) {
				t.ecrireDansConsole("Nous ne sommes pas déja dans le marché --> on y va...", true);
				t.getCompte().getDriver().findElement(By.xpath("//*[contains(@class, 'marketWhite')]")).click();
				t.randomsleep.court();
				}else {
					t.ecrireDansConsole("Nous sommes déja dans le marché ", true);
				}
			
		
		} catch (Exception eb) {
			t.ecrireDansConsole("Pas de compte + ou pas de marché Passage en force", true);

			try{
				t.getCompte().getDriver().findElement(By.xpath("//*[@id='dialogCancelButton']")).click();	//*[@id="dialogCancelButton"]

			}catch (Exception e1) {t.ecrireDansConsole("echec evitement de la pub Travian+ ---> normal code mort  mais laisser pour garder le code pour autre chose", true);}

			try {//bon bah on va sur une page contenant le marché
				if (!t.getCompte().getDriver().getCurrentUrl().contains("dorf2.php")) {
					t.randomsleep.court();
					t.getCompte().getDriver().get(t.getCompte().getServer() + "dorf2.php");
					t.randomsleep.court();
				}
				WebElement boutton = t.getCompte().getDriver().findElement(By.xpath("//area[@alt[contains(.,'marché')]]"));
				boutton.click();
				t.randomsleep.court();
			}catch (Exception e3){
				t.ecrireDansConsole("Pas de marché :(", true);
			}
		}	





	}
	
	 

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//TODO REafctorer pour utiliser le systeme d'ordre plutot que cela // Modifier Appro Petit Village pour envoyer le max de resources possibles plutot que tant de marchands de chaque par ressource
	//Ici les village en negatif peuvent etre prit dans certaine conditions
	public void approPetitVillage(Travian t, Village village, ArrayList<Village> listeDeVillages){
		t.ecrireDansConsole("[Marché] ApproPetitVillage Début", true);
		village = t.villageEnCours();
		village.updateRessources(t);
		try {
			if (village.getChampMin() <= t.bot.champMinFx){
				
				totalRessourcesEnvoyees = 0; // TODO attention bug par default pour pas reprendre l'ancienne valeur sil y a eu un echec
				int pourcentageApproPetitVillage = t.bot.pourcentageApproPetitVillageFx;
				int ressourcesMiniSurVillageSource = t.bot.ressourcesMiniSurVillageSourceFx;
				int DepotMiniPourAider = t.bot.DepotMiniPourAiderFx;
				//en cas de negatif : parametres
				int pourcentageSiloMiniPourAutoriserAAider = t.bot.pourcentageSiloMiniPourAutoriserAAider; // doit avoir au moins 50% de remplissage
				int pourcentageSiloMaxPonctionnable = t.bot.pourcentageSiloMaxPonctionnable ; // prend 10% de ressources
				
				boolean continuer = true;
				boolean manqueB = village.getBois() <= village.getMaxStockDepot()/100*pourcentageApproPetitVillage;
				boolean manqueA = village.getArgile() <= village.getMaxStockDepot()/100*pourcentageApproPetitVillage;
				boolean manqueF = village.getFer() <= village.getMaxStockDepot()/100*pourcentageApproPetitVillage;
				boolean manqueC = village.getCereales() <= village.getMaxStockSilo()/100*pourcentageApproPetitVillage;

				int manqB =village.getMaxStockDepot() - village.getBois();
				int manqA =village.getMaxStockDepot() - village.getArgile();
				int manqF =village.getMaxStockDepot() - village.getFer();
				int manqC =village.getMaxStockSilo() - village.getCereales();


				if(manqueB || manqueA || manqueF ||manqueC){
			
					int arrivageIntBois = 0;
					int arrivageIntArgile = 0;
					int arrivageIntFer =  0;
					int arrivageIntCereales =  0;

					
			//		if(village.trouverBatiment(t, village, TemplatesDeVillages.marche) == true || village.getNombreDeMarchandsMax() > 0 || village.getNombreDeMarchands() > 0 ) {
						
					
					t.randomsleep.court();
					allerDansLeMarché(t);
					t.randomsleep.court();
					changementOngletMarche(t, village, 0, "Envoi");
					t.randomsleep.court();
					arrivageIntBois = lireArrivageMarche(t, village, 0, 15900, 0); //cereales 1h59minutes entrant 
					arrivageIntArgile = lireArrivageMarche(t, village, 1, 15900, 0);
					arrivageIntFer = lireArrivageMarche(t, village, 2, 15900, 0);
					arrivageIntCereales = lireArrivageMarche(t, village, 3, 15900, 0);
					//manqC =  manqC - arrivageInt;
				//	} 
					 
					for (Village villageCandidat : listeDeVillages) {
						if(villageCandidat.getNom().equals(village.getNom()) || (villageCandidat.getEnNegatif() == true && (villageCandidat.getCereales() <= villageCandidat.getMaxStockSilo()/100*pourcentageSiloMiniPourAutoriserAAider))  ) { //|| villageCandidat.getCereales() <= villageCandidat.getMaxStockSilo()/100*pourcentage
							continue;
						}

						//Check de la distance 
						double distance = t.calculs.calculDeDistance(villageCandidat.getX(), villageCandidat.getY(), village.getX(), village.getY(),false);
						double	distanceMax = t.bot.distanceMaxPourMarchands; //en cases
						if(distance < distanceMax ){

							if (villageCandidat.getMaxStockDepot() > DepotMiniPourAider && villageCandidat.getNombreDeMarchands() > 4 ){ 

								if(villageCandidat.getBois() > ressourcesMiniSurVillageSource 
										&& villageCandidat.getArgile() > ressourcesMiniSurVillageSource 
										&& villageCandidat.getFer() > ressourcesMiniSurVillageSource 
										&& villageCandidat.getCereales() > ressourcesMiniSurVillageSource 
										){


									

									t.randomsleep.court();
									t.getCompte().getDriver().findElement(By.xpath("//*[contains(@href,'?" + villageCandidat.getId() + "&')]")).click();
								//	t.getCompte().getDriver().get(villageCandidat.getUrl());
									t.randomsleep.court();
									//on va sur le marché
									allerDansLeMarché(t);
									changementOngletMarche(t, villageCandidat, 0, "Envoi");
									t.randomsleep.court();
									
									updateQuantiteMaxTransporteParMarchand(t, villageCandidat, 0);
									villageCandidat.updateRessources(t);
							/*		
									int dureeALire = 15900;
									int arrivageBoisInt = lireArrivageMarche(t, village, 0, dureeALire, 0); // 1h59minutes entrant 
									int arrivageArgileInt = lireArrivageMarche(t, village, 1, dureeALire, 0);
									int arrivageFerInt = lireArrivageMarche(t, village, 2, dureeALire, 0);
									int arrivageCerealesInt = lireArrivageMarche(t, village, 3, dureeALire, 0);
									*/
									
									int nombreDeBesoin = 0 ; // on remet a zero //par default
									if (manqueB){nombreDeBesoin++;}
									if (manqueA){nombreDeBesoin++;}
									if (manqueF){nombreDeBesoin++;}
									if (manqueC){nombreDeBesoin++;}	

									int marchandsMaxAllouesParRessource = villageCandidat.getNombreDeMarchands()/nombreDeBesoin;

									int mB = marchandsMaxAllouesParRessource;
									int mA = marchandsMaxAllouesParRessource;
									int mF = marchandsMaxAllouesParRessource;
									int mC = marchandsMaxAllouesParRessource;

									//Bois
									if(manqueB){

										while(mB*villageCandidat.getQuantiteMaxTransporteeParMarchands() > manqB - arrivageIntBois){
											mB--;

										}
										if(mB < marchandsMaxAllouesParRessource && arrivageIntBois == 0 && mB < 1){ // si on envoi zero marchand et qu'aucun arrivage de la ressource arrive alors on ajoute un marchand pour remplir un eventuel depot silo de bas niveau
											mB++;
											} 
										}

									///Argile
									if(manqueA){
										while(mA*villageCandidat.getQuantiteMaxTransporteeParMarchands() > manqA - arrivageIntArgile){
											mA--;
										}
										if(mA < marchandsMaxAllouesParRessource && arrivageIntArgile == 0 && mA < 1){
											mA++;
											}
										}
									
									///Fer
									if(manqueF){
										while(mF*villageCandidat.getQuantiteMaxTransporteeParMarchands() > manqF - arrivageIntFer){
											mF--;
										}
										if(mF < marchandsMaxAllouesParRessource && arrivageIntFer == 0 && mF < 1){
											mF++;
											}
									}

									////Cereales
									if(manqueC){
										while(mC*villageCandidat.getQuantiteMaxTransporteeParMarchands() > manqC - arrivageIntCereales  ){
											mC--;								
										}
										//Correcteur en cas de negatif
										if(villageCandidat.getEnNegatif()== true) {
											while(mC*villageCandidat.getQuantiteMaxTransporteeParMarchands() > villageCandidat.getMaxStockSilo()/100*pourcentageSiloMaxPonctionnable) {
												mC--;
											}
										}
										if(mC < marchandsMaxAllouesParRessource && arrivageIntCereales == 0 && mC < 1){
											mC++;
											}
									}
									
									
									//re test des manquant apres observation
									 manqueB = village.getBois() + arrivageIntBois <= village.getMaxStockDepot()/100*pourcentageApproPetitVillage;
									 manqueA = village.getArgile() + arrivageIntArgile <= village.getMaxStockDepot()/100*pourcentageApproPetitVillage;
									 manqueF = village.getFer() + arrivageIntFer <= village.getMaxStockDepot()/100*pourcentageApproPetitVillage;
									 manqueC = village.getCereales() + arrivageIntCereales <= village.getMaxStockSilo()/100*pourcentageApproPetitVillage;
									
									int compteurBois = 0;
									int compteurArgile = 0;
									int compteurFer = 0;
									int compteurCereales = 0;
									//bois
									if(manqueB){
										for( int clic=0; clic < mB; clic++){
											t.getCompte().getDriver().findElement(By.xpath("//*[@id=\"addRessourcesLink1\"]")).click();
											compteurBois =  mB*villageCandidat.getQuantiteMaxTransporteeParMarchands();
											t.randomsleep.tcourt();
										}}
									//argile
									if(manqueA){
										for( int clic=0; clic < mA; clic++){
											t.getCompte().getDriver().findElement(By.xpath("//*[@id=\"addRessourcesLink2\"]")).click();
											compteurArgile =  mA*villageCandidat.getQuantiteMaxTransporteeParMarchands();
											t.randomsleep.tcourt();
										}}
									//Fer
									if(manqueF){
										for( int clic=0; clic < mF; clic++){
											t.getCompte().getDriver().findElement(By.xpath("//*[@id=\"addRessourcesLink3\"]")).click();
											compteurFer =  mF *villageCandidat.getQuantiteMaxTransporteeParMarchands();
											t.randomsleep.tcourt();
										}}
									//Cereales
									if(manqueC){
										for(int clic=0; clic < mC; clic++){
											t.getCompte().getDriver().findElement(By.xpath("//*[@id=\"addRessourcesLink4\"]")).click();
											compteurCereales =  mC*villageCandidat.getQuantiteMaxTransporteeParMarchands();
											t.randomsleep.tcourt();
										}}
									//	t.ecrireDansConsole("[Marché] ApproPetitVillage");
									if(manqueB == true || manqueA == true || manqueF== true || manqueC== true) {
									if(envoyerMarchands(t, village.getNom())){
										t.ecrireDansConsole("[Marché][Appro Petits Villages]"+ t.villageEnCours().getNom() + " envoi : "+compteurBois + " Bois "+compteurArgile + " Argile "+compteurFer + " Fer "+compteurCereales + " Cereales "+ " sur "  +village.getNom(), true);
									}
									}else {
										t.ecrireDansConsole("[Marché][Appro Petits Villages]"+ t.villageEnCours().getNom() + " devait envoyer sur "  +village.getNom() + " mais ceci est annulé apres analyse précise", true);
									}
									t.randomsleep.court();
									//t.getCompte().getDriver().get(village.getUrl());
									t.getCompte().getDriver().findElement(By.xpath("//*[contains(@href,'?" + village.getId() + "&')]")).click();
									t.randomsleep.court();

									//TODO Changement de page a changer en mode secure et non en get
									break;


								}
							}

						}else {

							t.ecrireDansConsole("[Marché] " + villageCandidat.getNom() + " est trop eloigné. ", true );
						}



					}
				}
			}
		}catch (Exception e){t.ecrireDansConsole("echec approPetitVillage", true);}
		t.ecrireDansConsole("[Marché] ApproPetitVillage Fin", true);

	}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//TODO ajouter un horodate ou une lecture du marché avant d'envoyer trop de ressources 
	//Ici on ne prends pas les village en negatif
	public void approUrgenceFamine(Travian t, Village village, ArrayList<Village> listeDeVillages){
		t.ecrireDansConsole("[Marché] approUrgenceFamine Début", true);
		try {
			boolean tokenNPC = false;
			if (village.getEnNegatif()==true){
				totalRessourcesEnvoyees = 0; // TODO attention bug par default pour pas reprendre l'ancienne valeur sil y a eu un echec
				int pourcentageApproPetitVillage = t.bot.pourcentageApproUrgenceFamine;
				int ressourcesMiniSurVillageSource = t.bot.ressourcesMiniSurVillageSourceApproUrgenceFamine;
				int DepotMiniPourAider = t.bot.depotMiniPourFonctionnerApproUrgenceFamine;
				int nbreMarchandsMiniPourFonctionner = t.bot.marchandsMinPourFonctionnerApproUrgenceFamine;
				boolean continuer = true;

				boolean manqueC = true; //  village.getCereales() <= village.getMaxStockSilo()/100*1


				int manqC = village.getMaxStockSilo() - village.getCereales();


				if(manqueC){
					t.randomsleep.court();
					if (village != t.villageEnCours()){
						t.getCompte().getDriver().findElement(By.xpath("//*[contains(@href,'?" + village.getId() + "&')]")).click();
						t.randomsleep.court();
					}
					//on va sur le marché
					allerDansLeMarché(t);
					t.randomsleep.court();
					changementOngletMarche(t, village, 0, "Envoi");
					t.randomsleep.court();
					int arrivageInt = lireArrivageMarche(t, village, 3, 15900, 0); //cereales 1h59minutes entrant 
					 
					 
					int pourcentage = 90;
					while(continuer == true) {
						t.ecrireDansConsole("[Marché] ApproUrgenceFamine recherche les villages ayant les silos remplis à " + pourcentage + " % et + ", true );
					
					for (Village villageCandidat : listeDeVillages) {
						if(villageCandidat.getNom().equals(village.getNom()) || villageCandidat.getCereales() <= villageCandidat.getMaxStockSilo()/100*pourcentage) {
							//t.ecrireDansConsole("[Marché] "+ villageCandidat.getNom() + " exclu à ce tour, ApproUrgenceFamine recherche les villages ayant les silos remplis à " + pourcentage + " % et +  ", true );
							continue;
						}
						//Check de la distance 
						double distance = t.calculs.calculDeDistance(villageCandidat.getX(), villageCandidat.getY(), village.getX(), village.getY(),false);
						double	distanceMax = t.bot.distanceMaxPourMarchandsApproUrgenceFamine; //en cases
						if(distance < distanceMax ){

							if (villageCandidat.getMaxStockDepot() > DepotMiniPourAider && villageCandidat.getNombreDeMarchands() > nbreMarchandsMiniPourFonctionner && villageCandidat.getEnNegatif() == false){ //TODO verifier de ne pas prendre le meme village 
								if(villageCandidat.getCereales() > ressourcesMiniSurVillageSource ){

		
									int marchandsMaxAllouesParRessource = villageCandidat.getNombreDeMarchands();
									int mC = marchandsMaxAllouesParRessource;


									t.randomsleep.court();
									t.getCompte().getDriver().findElement(By.xpath("//*[contains(@href,'?" + villageCandidat.getId() + "&')]")).click();
								//	t.getCompte().getDriver().get(villageCandidat.getUrl());
									t.randomsleep.court();
									//on va sur le marché
									allerDansLeMarché(t);
									changementOngletMarche(t, villageCandidat, 0, "Envoi");
									t.randomsleep.court();
									updateQuantiteMaxTransporteParMarchand(t, villageCandidat, 0);
									// marchands arrivants  //*[@id="merchantsOnTheWay"]/table[1]/tbody/tr[2]/td/span/text()[5]  partants : //*[@id="merchantsOnTheWay"]/table[2]/tbody/tr[2]/td/span/text()[4]
								
									
									
									
								/*	
									// lire arrivage cc
									List<WebElement> listeMarchandsArrivants = t.getCompte().getDriver().findElements(By.xpath("//*[@id=\"merchantsOnTheWay\"]/table"));
									int i = 0;
									int arrivageInt = 0;
									for(WebElement arrivage : listeMarchandsArrivants) {
										int delaisAvantArrivage  = Integer.parseInt(arrivage.findElement(By.xpath("./tbody/tr[1]/td/div[1]/span")).getText().replaceAll(":", ""));
										if(!arrivage.getText().contains("Transport vers")  && delaisAvantArrivage < 5900) { //TODO trouver un meilleur systeme 4500 = 45 minutes 0 seconde 
										 arrivageInt = arrivageInt + Integer.parseInt(arrivage.findElement(By.xpath("./tbody/tr[2]/td/span[1]")).getText().split(" ")[3].trim()); 
										}
										
										//./tbody/tr[2]/td/span/text()[5]
									}	

									*/
									
									
									
									 
									 
									 
									 
									 
									////Cereales
									if(manqueC){
										while(mC*villageCandidat.getQuantiteMaxTransporteeParMarchands() > manqC - arrivageInt){
											mC--;
										}
										if(mC*villageCandidat.getQuantiteMaxTransporteeParMarchands() < manqC  && arrivageInt == 0  && mC < 1 ){ // 
											mC++;
											}
									}
									
									int compteurCereales = 0;
									
									//Cereales
									if(manqueC){
										for(int clic=0; clic < mC; clic++){
											t.getCompte().getDriver().findElement(By.xpath("//*[@id=\"addRessourcesLink4\"]")).click();
											compteurCereales =  mC*villageCandidat.getQuantiteMaxTransporteeParMarchands();
											t.randomsleep.tcourt();
										}}
									//corection calcul en mode flemmard , à changer :
									if((villageCandidat.getCereales() < compteurCereales) && mC > 0){
										compteurCereales = villageCandidat.getCereales();												
									}
									
									
									if(envoyerMarchands(t, village.getNom())){
										t.ecrireDansConsole("[Marché][approUrgenceFamine] "+ t.villageEnCours().getNom() + " envoi : " +compteurCereales + " Cereales "+ " sur "  +village.getNom(), true);
										continuer = false;
										village.memoireMarcheDeLaRotation[3] =	village.memoireMarcheDeLaRotation[3] + compteurCereales;
									}
									updateNombreDeMarchandsDispo(t, villageCandidat);
									t.randomsleep.court();
									t.getCompte().getDriver().findElement(By.xpath("//*[contains(@href,'?" + village.getId() + "&')]")).click();
								//	t.getCompte().getDriver().get(village.getUrl());
									t.randomsleep.court();

									//TODO Changement de page a changer en mode secure et non en get
									break;


								}
							}

						}else {

							t.ecrireDansConsole("[Marché] " + villageCandidat.getNom() + " est trop eloigné. ", true );
						}



						}
					if(continuer == true) {
						pourcentage = pourcentage - 10;
						}else {
							
						break;
					}
					if (pourcentage < 0) {
						 tokenNPC = true;
					/*	if (t.bot.augmenterRayonDeRechercheApproUrgenceFamine == true) {
					 * 
							
						}
					*/
						break;
					
					}
					}//fin while
				}
			}
		}catch (Exception e){t.ecrireDansConsole("echec approUrgenceFamine", true);}
		t.ecrireDansConsole("[Marché] approUrgenceFamine Fin", true);

	}

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	//sens
	//0 PourArrivage 
	//1 PourEnSortie
	public int lireArrivageMarche(Travian t, Village village, int typeRessourceALire, int dureeRestanteAvantArriveeLimite, int sens) {
		String ressourceString="Aucun arrivage";
		String sensString = "";
		String EnArrivage = "Transport vers";
		String EnSortie = "Transport de";
		if(sens == 0) {
			sensString = EnArrivage;
		}else {
			sensString = EnSortie;
		}
		
		// typeRessourceALire : 0 bois 1 argile 2 Fer 3 cereale
		// lire arrivage
		List<WebElement> listeMarchandsArrivants = t.getCompte().getDriver().findElements(By.xpath("//*[@id=\"merchantsOnTheWay\"]/table"));
		
		int arrivageInt = 0;
		for(WebElement arrivage : listeMarchandsArrivants) {
			int dureeRestanteAvantArrivage  = Integer.parseInt(arrivage.findElement(By.xpath("./tbody/tr[1]/td/div[1]/span")).getText().replaceAll(":", ""));
			if(!arrivage.getText().contains(sensString)  && dureeRestanteAvantArrivage < dureeRestanteAvantArriveeLimite) { //TODO trouver un meilleur systeme 4500 = 45 minutes 0 seconde 
			 arrivageInt = arrivageInt + Integer.parseInt(arrivage.findElement(By.xpath("./tbody/tr[2]/td/span[1]")).getText().split(" ")[typeRessourceALire].trim()); 
			}
			
			//./tbody/tr[2]/td/span/text()[5]
			
			if(typeRessourceALire == 0) {ressourceString = "Bois";}
			if(typeRessourceALire == 1) {ressourceString = "Argile";}
			if(typeRessourceALire == 2) {ressourceString = "Fer";}
			if(typeRessourceALire == 3) {ressourceString = "Cereales";}
			
		}	
		t.ecrireDansConsole("[Marché] lire marché :   " + ressourceString + "  : "+ arrivageInt +"" , true);
		return arrivageInt;
	}
	
	
	
	
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	//TODO limiter les achats afin de ne pas causer un manque sur une autre ressource, bref pas compatible avec les petits villages
	// faire un limiteur par la taille du village, ou des depot, ou le calcul complet
	public void acheterAuMarché(Travian t, Village village){
		t.ecrireDansConsole("[Marché] acheterAuMarché Début ", true);
		int tempsMax = t.bot.tempsMax; // temps en heure
		//int marchandsMinPourAcheter = 10;
		int marchandsMinPourFonctionner = t.bot.marchandsMinPourFonctionner; //dans la boucle while plus bas 
		int marchandsAllouésPourAchat = village.getNombreDeMarchandsMax()/ t.bot.marchandsAllouésPourAchat ;//village.getNombreDeMarchandsMax()/4; // faire varier pour s'adapter a la taille du village //10 sur  gros compte
		int pourcentageDeclenchementAcheter = t.bot.pourcentageDeclenchementAcheter; // 75% de la moyenne du total des ressources
		int pourcentageDeclenchementAcheterContre = t.bot.pourcentageDeclenchementAcheterContre;
		int pourcentageDeclenchementAcheterContreMoyenne = t.bot.pourcentageDeclenchementAcheterContreMoyenne;
		int pourcentageDeclenchementAcheterContreVillage =t.bot.pourcentageDeclenchementAcheterContreVillage;
		int pourcentageCorrecteurSiVillageEnNegatif = t.bot.pourcentageCorrecteurSiVillageEnNegatif;
		int marchandsConsomés = 0;


		int totalBois = 0;
		int totalArgile = 0;
		int totalFer = 0;
		int totalCereales = 0;

		boolean acheterBois = false;
		boolean acheterArgile = false;
		boolean acheterFer = false;
		boolean acheterCereales = false;

		int besoinMarché= 0;

		long milliEcartDate = 0;

		ArrayList<Integer> tableauBesoin = new ArrayList<Integer>(); 
		ArrayList<Integer> tableauAcheterContre = new ArrayList<Integer>(); 


		// on calcule les totaux
		for (Village v : t.getListeDeVillages()){
			totalBois = totalBois + v.getBois();
			totalArgile = totalArgile + v.getArgile();
			totalFer = totalFer + v.getFer();
			totalCereales = totalCereales +v.getCereales();

		}
		
		// on corrige les jalons de vente des cereales en cas de negatifs
		int correctionSiVillageEnNegatif = 0;
		if(village.getEnNegatif() == true) {
		correctionSiVillageEnNegatif = pourcentageCorrecteurSiVillageEnNegatif;
		}
		/* 
		int moyenneB = (totalBois ) / t.getListeDeVillages().size();
		int moyenneA = (totalArgile) / t.getListeDeVillages().size();
		int moyenneF = (totalFer ) / t.getListeDeVillages().size();
		int moyenneC = (+ totalCereales) / t.getListeDeVillages().size();
		 */
		
		//on deteremine une mediane et on declare les besoins 
		int moyenne = (totalBois + totalArgile + totalFer + totalCereales) / 4;
		

		if((totalBois < (moyenne/100*pourcentageDeclenchementAcheter)) ){ //&& (village.getMaxStockDepot() > (moyenne) ) // && (village.getBois() < (moyenne))
			acheterBois = true;
			besoinMarché = 1;
			tableauBesoin.add(besoinMarché);
		}
		if((totalArgile < (moyenne/100*pourcentageDeclenchementAcheter))    ) {  //&& (village.getMaxStockDepot() > (moyenne) ) //&& (village.getArgile() < (moyenne))
			acheterArgile = true;
			besoinMarché = 2;
			tableauBesoin.add(besoinMarché);
		}
		if((totalFer < (moyenne/100*pourcentageDeclenchementAcheter)) ) { // && (village.getMaxStockDepot() > (moyenne) ) // && (village.getFer() < (moyenne) )
			acheterFer = true;
			besoinMarché = 3;
			tableauBesoin.add(besoinMarché);
		}
		if((totalCereales < (moyenne/100*pourcentageDeclenchementAcheter))) { //  && (village.getCereales() < (moyenne)  )
			acheterCereales = true;
			besoinMarché = 4;
			tableauBesoin.add(besoinMarché);
		}







		if(besoinMarché > 0 && village.getNombreDeMarchands() > 1 ){


			///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
			///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
			// TODO temporaire nobrain à refaire demain on refait un passage pour prendre le plus petit
			////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


			if(totalBois < totalArgile && totalBois < totalFer && totalBois < totalCereales){
				if(village.getMaxStockDepot() - village.getBois() > (marchandsAllouésPourAchat*village.getQuantiteMaxTransporteeParMarchands())) {
					besoinMarché = 1;
					//decalage en premiere position (ne suprime rien)
					tableauBesoin.remove(tableauBesoin.indexOf(1));
					tableauBesoin.add(0, besoinMarché);
				}else {
					t.ecrireDansConsole("totalBois pas de place", true);}
			}

			if(totalArgile < totalBois && totalArgile < totalFer && totalArgile < totalCereales){
				if(village.getMaxStockDepot() - village.getArgile() > (marchandsAllouésPourAchat*village.getQuantiteMaxTransporteeParMarchands())) {	
					besoinMarché = 2;
					tableauBesoin.remove(tableauBesoin.indexOf(2));
					tableauBesoin.add(0, besoinMarché);
				}else {
					t.ecrireDansConsole("totalArgiles pas de place", true);}
			}
			if(totalFer < totalBois && totalFer < totalArgile   && totalFer < totalCereales){
				if(village.getMaxStockDepot() - village.getFer() > (marchandsAllouésPourAchat*village.getQuantiteMaxTransporteeParMarchands())) {
					besoinMarché = 3;
					tableauBesoin.remove(tableauBesoin.indexOf(3));
					tableauBesoin.add(0, besoinMarché);
				}else {
					t.ecrireDansConsole("totalFer pas de place", true);}
			}
			if(totalCereales <  totalBois && totalCereales < totalArgile  && totalCereales < totalFer){
				if(village.getMaxStockSilo() - village.getCereales() > (marchandsAllouésPourAchat*village.getQuantiteMaxTransporteeParMarchands())) {
					besoinMarché = 4;
					tableauBesoin.remove(tableauBesoin.indexOf(4));
					tableauBesoin.add(0, besoinMarché);
				}else {
					t.ecrireDansConsole("totalCereales pas de place", true);}
			}

			//on deteremine les ressources au dessus d'un seuil 
			boolean acheterContreDuBois = false;
			boolean acheterContreDuArgile = false;
			boolean acheterContreDuFer = false;
			boolean acheterContreDuCereales = false;
			int acheterContre = 0;

			
			if(totalBois > (moyenne + (moyenne/100*pourcentageDeclenchementAcheterContreMoyenne) )){
				if(village.getBois() > (village.getMaxStockDepot()/100*pourcentageDeclenchementAcheterContreVillage)){
				acheterContreDuBois = true;
				acheterContre = 1;
				tableauAcheterContre.add(acheterContre);
			}
			}
			if(totalArgile > (moyenne + (moyenne/100*pourcentageDeclenchementAcheterContreMoyenne) )){
			if(totalArgile > (village.getMaxStockDepot()/100*pourcentageDeclenchementAcheterContreVillage)){
				acheterContreDuArgile = true;
				acheterContre = 2;
				tableauAcheterContre.add(acheterContre);
			}
		}
			if(totalFer > (moyenne + (moyenne/100*pourcentageDeclenchementAcheterContreMoyenne) )){
			if(totalFer > (village.getMaxStockDepot()/100*pourcentageDeclenchementAcheterContreVillage)){
				acheterContreDuFer = true;
				acheterContre = 3;
				tableauAcheterContre.add(acheterContre);
			}
	}
			if(totalCereales > (moyenne + (moyenne/100*pourcentageDeclenchementAcheterContreMoyenne) )){
			if(totalCereales > ( village.getMaxStockSilo()/100*(pourcentageDeclenchementAcheterContreVillage + correctionSiVillageEnNegatif) )){
				acheterContreDuCereales = true;
				acheterContre = 4;
				tableauAcheterContre.add(acheterContre);
			}
}


			///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
			///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////			
			///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////					




			// on verifie que les marchands soient revenu du dernier envoi
			boolean autorisationAchat = false;
			Date dateActuelle =  t.randomsleep.date(true);
			try{
				milliEcartDate = dateActuelle.getTime() - village.getMarchéLastDate().getTime();
				if (milliEcartDate > village.marchédureeDuDernierAchat){ 
					autorisationAchat = true;
				}
			}catch (Exception e){
				autorisationAchat = true; 
				t.ecrireDansConsole("Premier lancement probable : pas d'heure dans le village --> autorisation", true);
			}

			if(autorisationAchat == true){
				//on continue
				allerDansLeMarché(t);
				t.getCompte().getDriver().findElement(By.xpath("//*[@class='tabItem' and contains(., 'Acheter')]")).click(); //onlget acheter
				t.randomsleep.court();
				List<WebElement> ratio = t.getCompte().getDriver().findElements(By.xpath("//*[@id='ratio_select']//button")); 
				ratio.get(0).click(); // ratio 1:1
				t.randomsleep.court();

				int marchandsD = updateNombreDeMarchandsDispo(t, village); //9
				marchandsConsomés = 0;
				///////////////
				for(int b : tableauBesoin) { // selection du besoin
					if(marchandsConsomés >= marchandsAllouésPourAchat) {
						t.ecrireDansConsole("Tout les marchands alloués pour la tache ont été consommés break 1", true);	
					}else { 
						t.randomsleep.court();
						List<WebElement> ressources = t.getCompte().getDriver().findElements(By.xpath("//*[@id='search_select']/tbody/tr/td"));
						ressources.get(b-1).click(); 
					}
					/////////////////////////
					for(int p : tableauAcheterContre) { // acheter contre;
						if(marchandsConsomés >= marchandsAllouésPourAchat ) {
							t.ecrireDansConsole("Tout les marchands alloués pour la tache ont été consommés break 2", true);	
						}else {
							if( b != p ) { // on ne vend pas la meme ressource que l'on cherche
								t.randomsleep.court();
								List<WebElement> ressourcesDemandees = t.getCompte().getDriver().findElements(By.xpath("//*[@id=\"bid_select\"]/tbody/tr/td"));
								if( ressourcesDemandees.get(p-1).findElements(By.xpath(".//button[contains(@class, 'iconFilterActive')]")).isEmpty() ) {
									ressourcesDemandees.get(p-1).click();
								}
								/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
								marchandsConsomés = marchandsConsomés + accepterOffre(t, village, marchandsAllouésPourAchat, marchandsMinPourFonctionner, tempsMax, marchandsConsomés, marchandsD );
								/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
							}
						}
					}
				}
			}else {
				//milliEcartDate > village.marchédureeDuDernierAchat

				t.ecrireDansConsole("Attente du retour de tout les anciens marchands envoyé par cette fonction : "+(milliEcartDate/1000)/60 +" minutes écoulé sur : " + (village.marchédureeDuDernierAchat/1000)/60 + "minutes aproximativement", true );}
		}else {
			t.ecrireDansConsole("Pas de besoin ou pas de marchands : on ne vas pas sur l'onglet", true);
		}

		////*[@class='tabItem' and contains(., 'Acheter')]
		/*	if(ressourcesCompte < MoyenneReesources){
	//	if (village.getNombreDeMarchands() > marchandsMinPourAcheter){




		}



	}
		 */
		tableauBesoin.clear();
		tableauAcheterContre.clear();
		t.ecrireDansConsole("[Marché] acheterAuMarché Fin ", true);
	}//fin methode acheter au marché

	
	
	
	
	
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public int accepterOffre(Travian t, Village village, int marchandsAllouésPourAchat, int marchandsMinPourFonctionner, int tempsMax, int marchandsConsomés, int marchandsD) {
		boolean continuer = true;

		while(continuer == true){
			try {
				List<WebElement> offres = null;
				offres = t.getCompte().getDriver().findElements(By.xpath("//button[contains(., 'Accepter')]")); //offres   
				if(!offres.isEmpty()) {
				int i = 0;
				for(WebElement offre : offres) {
						offres = t.getCompte().getDriver().findElements(By.xpath("//button[contains(., 'Accepter')]"));

			updateNombreDeMarchandsDispo(t, village); //6
			marchandsConsomés = marchandsConsomés + (marchandsD - village.getNombreDeMarchands());
			if(marchandsConsomés < marchandsAllouésPourAchat){
				if(village.getNombreDeMarchands() >= marchandsMinPourFonctionner){ 
					
					
					
					try {
				
						
						
						
						
						
						
					
						String tempstrajet =	offres.get(i).findElement(By.xpath(".//../..//td[contains(@class, 'dur')]")).getText();//button[contains(., 'accepter')]/../..//td[contains(@class, 'dur')]     -------------------      //button[contains(., 'accepter')]//../..//td[contains(@class, 'dur')]
						if (tempstrajet.length() < 8){tempstrajet = "0"+tempstrajet;}
						String[] decoupage = tempstrajet.split(":");
						t.ecrireDansConsole("[Debug] String[] decoupage : "+ decoupage[0]+" "+decoupage[1]+" "+decoupage[2], true);
						int heures = Integer.parseInt(decoupage[0]);
						int minutes = Integer.parseInt(decoupage[1]);
						int secondes = Integer.parseInt(decoupage[2]);
						int durationEnMilli = (3600 * heures) *1000 + (60 * minutes)*1000 + (secondes)*1000;
						
						
						
						
						
						
						if(durationEnMilli <= (tempsMax*3600)*1000 ){
							
							
							boolean tokenBanj = true;
							try {
								String liste = t.getCompte().fichierProperties.getProperty("banmarchejoueur");
								ArrayList<String> banJ = new ArrayList<String>(Arrays.asList(liste.split(",")));
							for(String exclu : banJ) { //Ogodai
								//TODO Faire une listeNoire + gui
								if(!(offres.get(i).findElement(By.xpath(".//../..//td[contains(@class, 'pla')]")).getText().contains(exclu))) {  // Alphabet  Ogodai      .//../..//td[contains(@class, 'pla')]      //button[contains(., 'Accepter')]/../..//td[contains(@class, 'pla')]
								village.setMarchédureeDuDernierAchat(durationEnMilli*2); //on double le temps pour l'aller et le retour
								offres.get(i).click(); // on accepte loffre !
								t.ecrireDansConsole("1 achat effectué au marché", true);
								Date lastDate = t.randomsleep.date(true);
								village.setMarchéLastDate(lastDate);
								 tokenBanj = false;
								t.randomsleep.court();
								}else {
									t.ecrireDansConsole("Joueur en liste noire...", true);
									
								}
								}
							
							}catch(Exception e) {
								t.ecrireDansConsole("liste noire vide ou echec ===> on autorise par default", true);
								tokenBanj = true; // on autorise par default
							}
							
							if(tokenBanj = true) {
							village.setMarchédureeDuDernierAchat(durationEnMilli*2); //on double le temps pour l'aller et le retour
							offres.get(i).click(); // on accepte loffre !
							t.ecrireDansConsole("1 achat effectué au marché", true);
							Date lastDate = t.randomsleep.date(true);
							village.setMarchéLastDate(lastDate);

							t.randomsleep.court();
							}
							
						}else {
							t.ecrireDansConsole("offre trop eloignée : + de :" + tempsMax +" heure", true );
						}
						
						
						
						
						
				
						
						
						
						
						
						


						
						
						
						
						
						
						
						
						
						
						
						
						
						}catch (Exception e) {
						continuer = false;
						t.ecrireDansConsole("echec accepter offre", true);
					}
					
					
					
					
					
					
					
					
					
					
					
					

				}else {
					continuer = false;
					t.ecrireDansConsole("Plus assez de marchands dispo pour acheter", true);
				}
			}else {
				continuer = false;
				t.ecrireDansConsole("Tout les marchands alloués pour la tache ont été consommés", true);
			}
			
			
			
			
			i++;
			
				}
				continuer = false;
				t.ecrireDansConsole("fin du parcour des offres du marché", true);

			}else {
				continuer = false;
				t.ecrireDansConsole("pas d'offre trouvée", true);
			}
			}catch (Exception e) {
				continuer = false;
				t.ecrireDansConsole("echec accepter offre", true);
			}
			
			
		}
		return marchandsConsomés;

	}


private void eviterFamineSansNpc(Travian t, Village village) {
	if(village.getCropDeath() == true) {
	//t.donneesRessources.
		allerDansLeMarché(t);
	
		
		
	}
}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


public  void gererRouteDeCommerce(Travian t, Village village) {
	
	boolean trouver = false;
	/*
	for(RouteDeCommerce rdcACreer : village.getListeRouteDeCommerceACreer()) {
	for(RouteDeCommerce oldRdc : village.getListeRouteDeCommerce()) {
			
			if(oldRdc.getCible().equals(cibleString) && oldRdc.getHeureDepart() == intResult ) {
				trouver = true;
				break;
			}
		}
	}
	*/
	

/*
	// en attendant
	///////////////////////////////////////////////////
	for(Village v : t.getListeDeVillages()) {
		RouteDeCommerce rdcTest = new RouteDeCommerce();
		rdcTest.setCereales(2000);
		rdcTest.setCible("02 - Fluffy pas Plop");
		rdcTest.setHeureDepart(0);
		rdcTest.setIncrement(2);
		rdcTest.setRepetition(12);
		v.getListeRouteDeCommerceACreer().add(rdcTest);
		
	}
///////////////////////////////////////////////////
	
	*/
	if(village.routeDeCommerceDejaListeesAvecSucce == false) {
		allerDansLeMarché(t);
		changementOngletMarche(t, village, 0, "Gestion");
		t.randomsleep.court();
		listerRouteDeCommerce(t, village);
		
	} 
	
	for(RouteDeCommerce rdcACreer : village.getListeRouteDeCommerceACreer()) {
		int i= 0;
		
		int cereales = rdcACreer.getCereales() ;
		String cibleString = rdcACreer.getCible() ;                  //*[@id="r4"]
		int intBase  = rdcACreer.getHeureDepart();
		int increment = rdcACreer.getIncrement();
		int intResult = intBase;
		String h = String.valueOf(intResult);
		
		
		while(i < rdcACreer.getRepetition()) {
		
		trouver = false;

		
		
		
		
		
		for(RouteDeCommerce oldRdc : village.getListeRouteDeCommerce()) {
			
			if(oldRdc.getCible().equals(cibleString) && oldRdc.getHeureDepart() == intResult ) {
				trouver = true;
				break;
			}
		}
		
		
		
		
		
		
		
		
			if (trouver == false) {
				allerDansLeMarché(t);
				changementOngletMarche(t, village, 0, "Gestion");
				t.randomsleep.court();
				listerRouteDeCommerce(t, village);
		 creerRouteDeCommerce(t, cibleString, cereales, h);
		 i++;
		 intResult = intResult + increment;
		 h = String.valueOf(intResult);
		 t.randomsleep.court();
		 t.getCompte().getDriver().findElement(By.xpath("//*[@id=\"tradeSaveButton\"]/div/div[2]")).click();
		 t.randomsleep.court();
			}else {
				 i++;
				 intResult = intResult + increment;
				 h = String.valueOf(intResult);
			}
		 
			
			
			
			
			
			
	}	
			
		}
		

	
	
	
}



///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public void creerRouteDeCommerce(Travian t, String cibleString, int cereales, String h) {
	t.randomsleep.court();
	//listedestination selection
try {
	t.getCompte().getDriver().findElements(By.xpath("//*[@id=\"build\"]/p[2]/a")).get(0).click();  
}catch (Exception e) {
	 t.getCompte().getDriver().findElements(By.xpath("//*[@id=\"build\"]/p[3]/a")).get(0).click();
}
t.randomsleep.court();
List<WebElement> listeDestination = t.getCompte().getDriver().findElements(By.xpath("//*[@id=\"did_dest\"]/option"));
t.randomsleep.court();

for(WebElement option : listeDestination) {
if (option.getText().toLowerCase().contains(cibleString.toLowerCase()) == true) {
	option.click();	
}
}

t.randomsleep.court();

// ecriture dans textField
WebElement textFieldCereales = t.getCompte().getDriver().findElement(By.xpath("//*[@id=\"r4\"]"));//.click();
textFieldCereales.click();
t.randomsleep.court();
textFieldCereales.clear();
t.randomsleep.court();
textFieldCereales.sendKeys(String.valueOf(cereales));
t.randomsleep.court();


// Selection heure depart
List<WebElement> listeHeureDepart = t.getCompte().getDriver().findElements(By.xpath("//*[@id=\"userHour\"]/option"));
for(WebElement option : listeHeureDepart ) {
if (option.getText().toLowerCase().contentEquals(h)) {
	option.click();
	
	break;
}
}




}





///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public void listerRouteDeCommerce(Travian t, Village v) {
	String nameV = null;
	String heureV = null;
	int i = 0;
	ArrayList<RouteDeCommerce> tempListeRdc = new ArrayList<RouteDeCommerce>();

	
	List<WebElement> listeDeRoutesDuVillage =  t.getCompte().getDriver().findElements(By.xpath("//*[@id=\"trading_routes\"]/tbody/tr"));
	for(WebElement route : listeDeRoutesDuVillage) {
		nameV = null;
		heureV = null;
		boolean trouver = false;
		
		
		try {
			nameV =	route.findElement(By.xpath("../tr[1]/td[2]/a")).getText();
			heureV = route.findElement(By.xpath("../tr["+ (i + 1) +"]/td[3]")).getText().split(":")[0];
		}catch(Exception e) {
		//	if(listeDeRoutesDuVillage.size() > 0 && !(route.getText().toLowerCase().contains("aucune"))) {
		//		t.ecrireDansConsole("Echec lecture RDC ou pas de RDC", true);
		//		}
			}
		
		//remplir liste Temporaire
		RouteDeCommerce tempRdc = new RouteDeCommerce();
		tempRdc.setCible(nameV);
		tempRdc.setHeureDepart(Integer.parseInt(heureV));
		tempRdc.setSource(v);
		tempListeRdc.add(tempRdc);
		
		
		///////////////////////////////////////////////////////
		for(RouteDeCommerce oldRdc : v.getListeRouteDeCommerce()) {
			
			if(oldRdc.getCible().equals(nameV) && oldRdc.getHeureDepart() == Integer.parseInt(heureV) ) {
				trouver = true;
				t.ecrireDansConsole("[Marché] RDC : vers " + oldRdc.getCible() +" depart : " + oldRdc.getHeureDepart() +" h", true);
				break;
			}
		}
		
		
		if(trouver  == false){
		
		RouteDeCommerce newRdc = new RouteDeCommerce();
		newRdc.setCible(nameV);
		newRdc.setHeureDepart(Integer.parseInt(heureV));
		newRdc.setSource(v);
		v.getListeRouteDeCommerce().add(newRdc);
		t.ecrireDansConsole("[Marché] RDC : vers " +newRdc.getCible() +" depart : " + newRdc.getHeureDepart() +" h", true);
		
		}	
		
	i++;

	
	}
	
	
	//////////////////////////////////////////
	//////////////////////////////////////////
	//Suppression des listes non presentes
	for(RouteDeCommerce oldRdc : v.getListeRouteDeCommerce()) {
		boolean trouver = false;
		
		for(RouteDeCommerce tempRdc : tempListeRdc) {
			if(oldRdc.getSource().equals(tempRdc.getSource()) &&  oldRdc.getHeureDepart() == tempRdc.getHeureDepart() ) {
				trouver = true;
				continue;
			}
		}
		
		if(trouver == false) {
			v.getListeRouteDeCommerce().remove(oldRdc);

		}
		
	}
	
	
	tempListeRdc.clear();
	v.setRouteDeCommerceDejaListeesAvecSucce(true);
	
}





///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////









///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
















}// Fin de classe 







