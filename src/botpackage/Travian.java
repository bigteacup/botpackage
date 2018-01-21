package botpackage;

import java.awt.AWTException;


import java.io.File;
import java.io.IOException;

import java.util.ArrayList;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.Cookie;



import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;


public class Travian extends Thread {
	Object mon =  new Object();

	Travian t = this;
	private Compte compte;

	private ArrayList<Village> listeDeVillages = new ArrayList<Village>();
	private ArrayList<Village> listeDeVillagesPerdus = new ArrayList<Village>();
	
	Randomsleep randomsleep = new Randomsleep(t);
	Date memDate;
	private Marche marche = new Marche();
	boolean enPause = false;
	int compteurDeBoot = 1;
	int echecDeBoot;
	List<WebElement> donneesGlobales;
	List<WebElement> donneesRessources;
	List<WebElement> donneesRessourcesPourcentage;
	List<WebElement> donneesPointsDeCulture;
	int numeroDePhoto = 0;
	CalculsTravian calculs = new CalculsTravian();
	public boolean allume = false;
	Lancerbot bot;	
	FxFenetreController fxFenetreController;
	private  AtomicReference<Thread> currentThread = new AtomicReference<Thread>();
	public int tokenForcerMarcheDeLaRotation = 0;
	int limiteDeConstruction = 2;
	private WebDriver driver;
	
	Hero hero = new Hero();


	public void setFxFenetreController(FxFenetreController fxFenetreController){
		this.fxFenetreController = fxFenetreController;

	}




		//TODO faire un gestionnaire de compte por simplifier et fiabiliser l'enssemble dy systeme de connexion 
	public Travian(Lancerbot bot, String nomDeCompte, String serveur, String userName, String motDePasse) {
		//super();
		this.bot = bot;
		compte = new Compte(nomDeCompte);
		if(serveur == null || userName== null || motDePasse == null ||serveur.length()==0 || userName.length()==0 || motDePasse.length()==0){
			
			compte.setServer( compte.fichierProperties.getProperty("server"));
			compte.setUserName(compte.fichierProperties.getProperty("login")); 
			compte.setPassWord(compte.fichierProperties.getProperty("password"));	
				
			
		}
		else{
		compte.setServer(serveur);
		compte.setUserName(userName);
		compte.setPassWord(motDePasse);
		
		}
		calculs.setTravian(t);




	}

	public void run() {
		t.fxFenetreController.boutonOn.getStyleClass().removeAll("ona");
		t.fxFenetreController.boutonOn.getStyleClass().removeAll("onb");
		t.fxFenetreController.boutonOn.getStyleClass().removeAll("onc"); 
		t.fxFenetreController.boutonOn.getStyleClass().add("onb");	
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.home") + "\\botpackage\\chromedriver.exe");
		driver = new ChromeDriver();
		compte.setDriver(driver);
		while (allume) {
			principale();
			ecrireDansConsole("dans le while");


		}
		t.fxFenetreController.boutonOn.getStyleClass().removeAll("ona");
		t.fxFenetreController.boutonOn.getStyleClass().removeAll("onb");
		t.fxFenetreController.boutonOn.getStyleClass().removeAll("onc"); 
		t.fxFenetreController.boutonOn.getStyleClass().add("onb");
		ecrireDansConsole("sortie du run");
		try {t.getCompte().getDriver().close();}catch (Exception e) {}
		try {t.getCompte().getDriver().quit();}catch (Exception e) {}

		ecrireDansConsole(t.getName());
		ecrireDansConsole(t.getState().toString());
		
		ecrireDansConsole("********* Bot eteind ************");
		System.out.println("********* Bot eteind ************");
		
		t.fxFenetreController.boutonOn.getStyleClass().removeAll("ona");
		t.fxFenetreController.boutonOn.getStyleClass().removeAll("onb");
		t.fxFenetreController.boutonOn.getStyleClass().removeAll("onc"); 
		t.fxFenetreController.boutonOn.getStyleClass().add("onc"); 
			
		

		
		//  ecrireDansConsole("********* Bot eteind ************");

	}

	public void ecrireDansConsole(String string){
		try {fxFenetreController.console.flux.envoyer(fxFenetreController, string);} catch (IOException e) {e.printStackTrace();}
	}


	///////////////////////////////////////////////////
	public synchronized void pause(){

		if (enPause == false){
			allume = false;
			enPause = true;
		}
		else {
			allume = true;
			enPause = false;
			synchronized (mon) {   mon.notify();   }	
		}





	}
	///////////////////////////////////////////////////////	
	public void arreter(){
		Thread.currentThread().interrupt();
	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public WebDriver driverEnCour() {
		WebDriver driverEnCour = compte.getDriver() ;
		return driverEnCour;

	}
	public Compte getCompte() {
		return compte;

	}
	public ArrayList<Village> getListeDeVillages(){
		return listeDeVillages;


	}

	private void principale()  {
		////pour PROFIL CHROME
		//	System.setProperty("webdriver.chrome.driver", "\\chromedriver.exe");
		//	ChromeOptions options = new ChromeOptions();
		//	options.addArguments("user-data-dir=/ProfilChromePourBot/MasterProfile");
		//C:/Users/timseven/AppData/Local/Google/Chrome/User Data/


		//System.setProperty("webdriver.chrome.driver", "C:\\Selenium2.45\\chrome\\chromedriver.exe");
		//		driver = new ChromeDriver();//new ChromeDriver();



		if (allume){
			try {
				boot();
			} catch (Exception e) {
				ecrireDansConsole("Echec boot");
				echecDeBoot++;
				restartSurErreure();
			}

			while (allume) {
				t.bot.fxFenetreController.ona(t);
				try {
					eviterSurvey();
				}catch (Exception e) {ecrireDansConsole("Echec eviterSurvey");
				}
				randomsleep.court();

				if (allume == false){break;}
				detectionTribut(); //ici pour le moment
				detectionSlotDeVillageDuCompte();
				limiteDeConstruction = t.getCompte().etablirLimiteDeConstructionSimultanees();
				try {
					listerVillages();
				} catch (Exception e) {
					ecrireDansConsole("Echec listerVillages");
					echecDeBoot++;
					restartSurErreure();

				}


				detectionAttaqueSimple(true);







				if (allume == false){break;}
				randomsleep.court();
				try {
					majVillagesPlus();
				} catch (Exception e) {ecrireDansConsole("Echec MajVillagePlus et NPC");
				fermerFenetre();
				t.ecrireDansConsole("Conclusion pas de compte + ou bug");
			   
				}

				randomsleep.court();
				if (allume == false){break;}
				
				

				//t.fonderVillage();
				/*	

		//	t.construireBatiments();


				 */		

				try {
					if (t.bot.rotationVillage == true){
						rotationVillage();			
					}else {t.ecrireDansConsole("Rotation désactivée");}
				} catch (Exception e) {ecrireDansConsole("Echec rotation");
				echecDeBoot++;
				restartSurErreure();
				}
				randomsleep.court();
				if (allume == false){break;}





				try {
					if(t.bot.optimiserProdHero == true){
						gestionHero();			
					}else {t.ecrireDansConsole("Optimisation Hero desactivée");}
				} catch (Exception e) {ecrireDansConsole("Echec gestionHero()");
				}
				randomsleep.court();
				if (allume == false){break;}	



				try {
					if (t.bot.faireAventures	 == true){
						aventureHero();			
					}else {t.ecrireDansConsole("Aventures désactivées");}
							
				} catch (Exception e) {ecrireDansConsole("Echec gestionHero2");
				}
				randomsleep.court();
				if (allume == false){break;}



				//	try {
				//		t.cadeaux();
				//		} catch (Exception e) {ecrireDansConsole("Echec cadeaux");}



				if (allume == false){break;}

				// Incrementation des compteurs apres un tour reussi
				compteurDeBoot++;
				echecDeBoot = 0;



				//Reset des memoires de rotation"
				// on suprime la liste des ordre du village a chaque tour de bot, //TODO verifier si cest bien placé en cas d'echec
				t.viderMemoireRotation();
			

				// Reglage de l'attente entre deux boucles
				//	randomsleep.lent();	
				
//				maDate.toString().split("")[0];
				Date lastDate = randomsleep.date(true);
				long milliEcartDate = lastDate.getTime() - memDate.getTime();
				
				t.ecrireDansConsole("Durée de la session :" + milliEcartDate / 1000 / 60 + "minutes "
						+ (milliEcartDate / 1000 - (milliEcartDate / 1000 / 60) * 60)
						+ "sec. et le chiffre de base en milliseconde " + milliEcartDate);
				
				fxFenetreController.console.ligne.getUndoManager().forgetHistory(); // on efface l'historique à la fin de la rotation
				randomsleep.treslent();
				//	randomsleep.court();

				ecrireDansConsole("******************************************************************************************************");
				ecrireDansConsole("**********REBOOT*******************REBOOT*******************REBOOT************************************");
				ecrireDansConsole("******************************************************************************************************");
				if (allume == false){break;}
				try {
					boot();
					ecrireDansConsole("Reboot : " + compteurDeBoot);
				} catch (Exception e) {ecrireDansConsole("Echec Reboot : " + compteurDeBoot);
				echecDeBoot++;
				restartSurErreure();}

				// t.clearListes();
			}

		}
	}

	public void viderMemoireRotation(){
		//Reset des memoires de rotation"
		// on suprime la liste des ordre du village a chaque tour de bot,
		int nI = 0;
		for (Village village :listeDeVillages){
			village.listeOrdresMarcheDeLaRotation.clear();
			village.memoireMarcheDeLaRotation[0] = 0;
			village.memoireMarcheDeLaRotation[1] = 0;
			village.memoireMarcheDeLaRotation[2] = 0;
			village.memoireMarcheDeLaRotation[3] = 0;
			village.bloquerConstructionBatiment=false;
			nI++;
		}
		t.tokenForcerMarcheDeLaRotation = 0;
		t.ecrireDansConsole("Fin du tour -------> " + nI +" Memoires epehemeres des rotations vidées et tokens vidés :"+ t.tokenForcerMarcheDeLaRotation +" Et bloquage des constructions levés");
	

	}

	public Set<Cookie> getCookies() {

		Set<Cookie> cookies=null;
		try
		{
			cookies=driver.manage().getCookies();
		}
		catch(Throwable e)
		{
			System.err.println("Error While getting Cookies: "+ e.getMessage());}
		return cookies;
	}






	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	private void boot() {

		 memDate = randomsleep.date(true); // afficher date
		// compte.getDriver().get(compte.getServer());
		// Open on passe par google au passage
	//	compte.getDriver().get("http://www.google.fr");
		randomsleep.court();
		compte.getDriver().get(compte.getServer()+"dorf1.php");
		randomsleep.court();
		try {
			// Name
			compte.getDriver().findElement(By.name("name")).clear();
			compte.getDriver().findElement(By.name("name")).sendKeys(compte.getUserName());
			randomsleep.court();
			// Pass
			compte.getDriver().findElement(By.name("password")).clear();
			compte.getDriver().findElement(By.name("password")).sendKeys(compte.getPassWord());
			randomsleep.court();
			// Clic
			compte.getDriver().findElement(By.name("s1")).click();
			randomsleep.court();

		} catch (Exception e) {
			ecrireDansConsole("deja connecte");


		}

	}
	public void bootDriver(WebDriver driver) {
		// compte.getDriver().get(compte.getServer());
		// Open

		t.ecrireDansConsole(t.getName());
	    t.ecrireDansConsole(t.getState().toString());
	   
		driver.get(compte.getServer()+"dorf1.php");
		randomsleep.court();
		try {
			// Name
			driver.findElement(By.name("name")).clear();
			driver.findElement(By.name("name")).sendKeys(compte.getUserName());
			randomsleep.court();
			// Pass
			driver.findElement(By.name("password")).clear();
			driver.findElement(By.name("password")).sendKeys(compte.getPassWord());
			randomsleep.court();
			// Clic
			driver.findElement(By.name("s1")).click();
			randomsleep.court();

		} catch (Exception e) {
			ecrireDansConsole("deja connecte");

		}
	}
	////////////////////////////////////////////////////////////// 

	public void redemarrerNavigateur(){
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.home") + "\\botpackage\\chromedriver.exe");
		driver = new ChromeDriver();
		compte.setDriver(driver);
		ecrireDansConsole("Rallumage du navigateur");

	}
	//////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////
	private void restartSurErreure() {
		t.viderMemoireRotation();
		prendrePhoto("restartSurErreure");

		randomsleep.court();


		try {
			compte.getDriver().close();
			compte.getDriver().quit();

			ecrireDansConsole("**************************************************************************");
			ecrireDansConsole("***************   BUG erreur 404 : REDEMARRAGE   *************************");
			ecrireDansConsole("**************  (Ou un boulet joue en meme temps que le bot) *************");
			ecrireDansConsole("**************************************************************************");
			t.ecrireDansConsole(t.getName());
		    t.ecrireDansConsole(t.getState().toString());
		    
			if(echecDeBoot <= 4){
				randomsleep.lent();}
			else {ecrireDansConsole("Ca merde trop --> Attente longue");randomsleep.treslent();}


			ecrireDansConsole("Reboot : " + compteurDeBoot);
			redemarrerNavigateur();
			principale();


		}catch (Exception e) {

			ecrireDansConsole("**************************************************************************");
			ecrireDansConsole("***************   BUG navigateur ferme ! : REDEMARRAGE   *****************");
			ecrireDansConsole("**************************************************************************");
			t.ecrireDansConsole(t.getName());
		    t.ecrireDansConsole(t.getState().toString());
		    
			if(echecDeBoot <= 4){
				randomsleep.court();}
			else {ecrireDansConsole("BUG navigateur ferme  --> Attente courte");randomsleep.court();}


			ecrireDansConsole("Reboot : " + compteurDeBoot);

			try{compte.getDriver().quit();}catch (Exception e1){t.ecrireDansConsole("echec : compte.getDriver().quit() 2");}
			redemarrerNavigateur();
			principale();


		}

	}
	// ////////////////////////////////////////////////////////////////////////
	// ////////////////////////////////////////////////////////////////////////
	// ////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


	// ////////////////////////////////////////////////////////////////////////
	// ////////////////////////////////////////////////////////////////////////
	// ////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



	// ////////////////////////////////////////////////////////////////////////
	// ////////////////////////////////////////////////////////////////////////
	// ////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	//TODO faire un lister village par le profil du joueur


	// ////////////////////////////////////////////////////////////////////////
	// ////////////////////////////////////////////////////////////////////////
	// ////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	//	TODO mettre par coordonnées
	// lister village par la liste de droite.
	private void listerVillages() {
		//	compte.getDriver().get(compte.getServer()+"dorf1.php"); //a virer apres correction de monter village echec

		List<WebElement> urls = compte.getDriver().findElements(By.xpath("//*[@id=\"sidebarBoxVillagelist\"]/div[2]/div[2]/ul/li/a"));
		List<WebElement> coordxy = compte.getDriver().findElements(By.cssSelector("span.coordinateX"));

		for (WebElement url : urls) {
			int coordX;
			int coordY;

			String stringUrl = url.getAttribute("href");

			//chargement des coordonnées
			//TODO derouler l element coordonnée sinon cest invisible ou passer par un autre site ou page
			String stringUrl2 ;
			try{
				stringUrl2 = url.findElement(By.xpath("span")).getText();//getText();  url.findElement(By.xpath("span")).getText();
				coordX = Integer.parseInt(stringUrl2.split("\\(")[1].split("\\|")[0].replaceAll("\\W", "")) ; //replaceAll("\\W", ""
				coordY = Integer.parseInt(stringUrl2.split("\\|")[1].split("\\)")[0].replaceAll("\\W", ""));
			}catch (Exception e){
				if (true){
					WebElement button = compte.getDriver().findElement(By.xpath("//*[@id=\"sidebarBoxVillagelist\"]/div[2]/div[1]/button[1]"));
					button.click();
					randomsleep.tcourt();
				}
				stringUrl2 = url.findElement(By.xpath("span")).getText();
				coordX = Integer.parseInt(stringUrl2.split("\\(")[1].split("\\|")[0].replaceAll("\\W", "")) ; //replaceAll("\\W", ""
				coordY = Integer.parseInt(stringUrl2.split("\\|")[1].split("\\)")[0].replaceAll("\\W", "")) ;

			}



			//chargement URL et noms
			boolean trouver = false;
			for (Village village : listeDeVillages) {
				String vUrl = village.getUrl();
				if (vUrl.split("\\?")[1].split("&")[0].equals(stringUrl.split("\\?")[1].split("&")[0])) {
					trouver = true;
					//si le nom a changé on le met a jour
					if(!village.getNom().equals(url.findElement(By.className("name")).getText())){
						village.setNom(url.findElement(By.className("name")).getText());	
					}
					break;
				}

			}
			//si on ne trouve pas l'url, on cree un nouveau village
			if (!trouver) {
				Village newVillage = new Village();
				newVillage.setUrl(stringUrl);
				newVillage.setNom(url.findElement(By.className("name")).getText());// .replaceAll("\n", "").replaceAll(" ",
				newVillage.setId(stringUrl.split("\\?")[1].split("&")[0]);
				newVillage.setX(coordX);
				newVillage.setY(coordY);
				// "").replaceAll ("\\s+$",""));

				listeDeVillages.add(newVillage);
				//TODO important --> gerer les comptes speed etc X2 X3 etc
				if (compte.getTribut().equals("Gaulois")) {newVillage.setQuantiteMaxTransporteeParMarchands(750);}
				if (compte.getTribut().equals("Romains")) {newVillage.setQuantiteMaxTransporteeParMarchands(500);}
				if (compte.getTribut().equals("Teutons")) {newVillage.setQuantiteMaxTransporteeParMarchands(1000);}

			}

		}
		
		///on suprime les villages perdus
		if(listeDeVillages.size() > urls.size()  ) {
			
			for(Village v : listeDeVillages) {
				boolean trouver = false;
				
				for (WebElement url : urls) {
				
					String stringUrl = url.getAttribute("href");
					String vUrl = v.getUrl();
					
						if (vUrl.split("\\?")[1].split("&")[0].equals(stringUrl.split("\\?")[1].split("&")[0])) {
						trouver = true;
						break;
							}
						}
				if (trouver == false) {
				
				 listeDeVillagesPerdus.add(v);
				
				}
				
			}
			
			
		}
		for(Village villagePerdu : listeDeVillagesPerdus) {
			 listeDeVillages.remove( villagePerdu);
		ecrireDansConsole("Village perdu ou detruit : " + villagePerdu.getNom() );
		}
		ecrireDansConsole("Nombre de Villages = " + listeDeVillages.size());
	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// ////////////////////////////////////////////////////////////////////////////////////////////////////





	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	///// ////// ////    ///// /////////// / ///////////////////////////////////////////////////////////////////////////////////////////////
	////// //// ////// /////// ////////// /// /////////////////////////////////////////////////////////////////////////////////////////////
	/////// // ////// //////// ///////// // // ////////////////////////////////////////////////////////////////////////////////////////////
	//////// //////    /////// / / / // /////// /////////////////////////////////////////////////////////////////////////////////////////////
	//On determine le village en cours.
	public Village villageEnCours() {
		//TODO faire un systeme par les ID et la comparaison des liste dispos, liste de village de la page et liste de village du bot
		boolean trouve = false;

		for (Village village : listeDeVillages) {
			String ici = compte.getDriver().findElement(By.xpath("//*[@id=\"villageNameField\"]")).getText();//
			String labas = village.getNom();
			if (labas.equals(ici)) {
				trouve = true;
				//ecrireDansConsole("Villages en cours : " + village.getNom());
				return village;
			}
		}
		//systeme doublé pour ne pas faire de traitement si ce nest pas necessaire
		if (trouve == false){
			t.listerVillages();
			for (Village village : listeDeVillages) {
				String ici = compte.getDriver().findElement(By.xpath("//*[@id=\"villageNameField\"]")).getText();//
				String labas = village.getNom();
				if (labas.equals(ici)) {
					trouve = true;
					//ecrireDansConsole("Villages en cours : " + village.getNom());
					return village;
				}
			}
		}

		return null;


	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// ///////////////////////////////////////////////////////////////////////////////////////


	public void rotationVillage() {
		for(Village village : listeDeVillages ){
			if(village.getExclureVillage() == false) {

			if (allume == false){break;}
			if (besoinDePasserSurLeVillage(village) == 1 ){
				randomsleep.classic();
				if (village != villageEnCours()){
					//compte.getDriver().get(village.getUrl());
					compte.getDriver().findElement(By.xpath("//*[contains(@href,'?" + village.getId() + "&')]")).click();
					ecrireDansConsole("=============================== Changement de village : "+village.getNom()+" ===============================");
					randomsleep.classic();
				}
				//TODO Remonter chargerchamp pour rendre le NPC effectif des la premiere co
				village.updateRessources(t); 
				if (allume == false){break;}
				
				

				village.voirTroupesCivilesDuVillage(t);
				if(t.getCompte().listeCompteCoordoneesPourColoniser.size() > 0) { //TODO Faire un bouton dans la GUI
					
					if(village.getVillageSlot() > 0 && t.compte.getSlotDeVillageDuCompte() > 0 && village.getColons() >= 3) {
				colonisationPlanifiee(village);
					}
				}
				
				if (allume == false){break;}
				village.voirListeDeConstruction(t);
				if (allume == false){break;}
				village.chargerChamps(t);
				if (allume == false){break;}
				

				
				try { 
					
					if (allume == false){break;}
					
					if(bot.pillage == true){
						if(village.getRegimePillage() == true){
						village.voirTroupesDuVillage(t);
						}else{ecrireDansConsole("Pillages Desactives... Par le regime du village");}
					}else{ecrireDansConsole("Pillages Desactives...");}
				}catch(Exception e){ecrireDansConsole("Echec pillage ");}
				
				

				
				if (allume == false){break;}
				
				if(t.bot.npc == true   ){ 
					if(village.getRegimeNPC() == true) {
					if (village.getBesoinDeNpc() == true && village.getVillageCapitale()==true  ){
						npcNegatif();
					}
					}else {t.ecrireDansConsole("NPC désactivé par le regime du village");}
				}else {t.ecrireDansConsole("NPC désactivé");}

				if (allume == false){break;}
				
			//	if ( bot.construireBatiments == true ) {
				//	if ( village.getRegimeConstruction() == true ) {
					if (village.getConstructionsEnCours() < limiteDeConstruction ){ 
						gestionBatiments();
					}else{ecrireDansConsole("Deja "+ limiteDeConstruction +" construction en cours");}
				//	}else {t.ecrireDansConsole("construction Desactivees... Par le regime du village");}
			//	}else {t.ecrireDansConsole("construction Desactivees...");}
				
				
				try {//si pas de compte plus, ou si echec prise de valeur dans le chargeur
				if(tokenForcerMarcheDeLaRotation == 1) {
					village.chargerBatiments(t);
					for (Batiment bat : village.getBatiments()) { 
						if(bat.getNomBatiment().toLowerCase().contains("march")) {
						village.setNombreDeMarchands(bat.getLevelBatiment());
						village.setNombreDeMarchandsMax(bat.getLevelBatiment());
						t.ecrireDansConsole("Forcage estimation nombre de marchand par level marché : "+ bat.getLevelBatiment());
						break;
						}
					}	
				}
				}catch(Exception e) {t.ecrireDansConsole("Echec Forcage estimation nombre de marchand par level marché");}


				if (allume == false){break;}
				
				marche.etablirBesoinEnRessources(t, village, listeDeVillages);

				if (allume == false){break;}
				
				if (bot.evacuerSurplusRessources == true){
					marche.evacuerSurplusRessources(t, village, listeDeVillages);
				}else{ecrireDansConsole("Evacuation ressources Desactives...");}

				if (allume == false){break;}
				
				if (bot.approPetitsVillages == true){
					marche.approPetitVillage(t, village, listeDeVillages);
				}else{ecrireDansConsole("Appro petits villages Desactives...");}

	

				try { 
					if (allume == false){break;}
					if(bot.faireFete == true){
						if(village.getRegimeFete() == true){
						if (village.getChampMin() >= 10 && village.getBesoinDeFete() == 1){ 
							if (village.getBois() >= 6400 && village.getArgile() >= 6650 && village.getFer() >= 5940 && village.getCereales() >= 1340 ){
								village.lancerFete(t);
							} else {ecrireDansConsole("[Fete] Pas assez de ressources pour faire une fete");}
						} else {ecrireDansConsole("[Fete] Pas besoin de fete ou pas d'hotel de ville");}
						}else {ecrireDansConsole("[Fete] fetes Desactivees... Par le regime du village.");}
					}else {ecrireDansConsole("[Fete] fetes Desactivees...");}
				}catch(Exception e){ecrireDansConsole("echec fete ");}
				
				//test
				if(bot.acheterAuMarché == true){
					if(village.getRegimeAcheterAuMarché() == true){
				marche.acheterAuMarché(t, village);
					}else {ecrireDansConsole("[Marché] acheterAuMarché Desactivees... Par le regime du village.");}
				}else {ecrireDansConsole("[Marché] acheterAuMarché Desactivees...");}
			}//fin for
		}else {ecrireDansConsole(village.getNom() + " Village Exclu de la rotation...");}
	  }
	}

	private int heureServer(){ //heure serveur non precise pour lancer les fetes sans spammer a chaque tour de bot
		int	heure = Integer.parseInt(compte.getDriver().findElement(By.xpath("//*[@id=\"tp1\"]")).getText().split(":")[0]);
		return heure;

	}
	//////////////////////////////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////////////////

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	

	private void gestionBatiments() {
		Village village =villageEnCours();
		village.EssayerConstruireBatiments(t, village);


	}	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////




	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////////trest//////////////////////////////

	private void gestionHero() {
		//Hero hero = new Hero();
		String heroSurVillage;
		WebElement lienHero = compte.getDriver().findElement(By.xpath("//*[@id=\"heroImageButton\"]"));
		Actions builder = new Actions(compte.getDriver());
		builder.moveToElement(lienHero);		
		builder.perform();
		randomsleep.court();
	
		try {
			heroSurVillage = compte.getDriver().findElement(By.xpath("//*[@class=\"tip-contents\"]")).getText().split("revient au village ")[1].split("\\.")[0]; //("rattachement de ")
			hero.setVillageAffecte(heroSurVillage);
		}catch (Exception e){
			t.ecrireDansConsole("[gestionHeroProd] Hero en mouvement ou echec lecture de l'infobulle : garde l'ancienne valeur -code 1");}
		
		try {
			heroSurVillage = compte.getDriver().findElement(By.xpath("//*[@class=\"tip-contents\"]")).getText().split("rattachement ")[1].split("\\.")[0]; //("rattachement de ")
			hero.setVillageAffecte(heroSurVillage);
		}catch (Exception e){
			t.ecrireDansConsole("[gestionHeroProd] Hero en mouvement ou echec lecture de l'infobulle : garde l'ancienne valeur -code 2");}

		
		
		
		
		String villageHero = hero.getVillageAffecte();


		for(Village villageCandidat : listeDeVillages){
			if(villageCandidat.getNom().equals(villageHero)){








				//updateRessources(); //update le village en cours : a develloper
				int stockbois = villageCandidat.getBois();
				int stockargile = villageCandidat.getArgile();
				int stockfer = villageCandidat.getFer();
				int stockcereales = villageCandidat.getCereales();

				HashMap<String, Integer> stockbafc = new HashMap<String, Integer>();
				stockbafc.put("bois", stockbois);
				stockbafc.put("argile", stockargile);
				stockbafc.put("fer", stockfer);
				stockbafc.put("cereales", stockcereales);

				/* ecrireDansConsole("Before Sorting:");
	      Set set = stockbafc.entrySet();
	      Iterator iterator = set.iterator();
	      while(iterator.hasNext()) {
	           Map.Entry me = (Map.Entry)iterator.next();
	           System.out.print(me.getKey() + ": ");
	           ecrireDansConsole(me.getValue());
	      }*/
				Map<String, Integer> map = sortByValues(stockbafc); 
				// ecrireDansConsole("After Sorting:");
				Set set1 = map.entrySet();
				Set set2 = map.entrySet();
				Iterator iterator1 = set1.iterator();
				Iterator iterator2 = set2.iterator();
				Map.Entry min = (Map.Entry)iterator2.next();
				String min2 = min.getKey().toString();


				////Si la prod du hero est differente, on la corrige
				if (!hero.getModeProduction().equals(min2)){
					hero.setModeProduction(min.getKey().toString());

					String token = hero.getModeProduction();
					String token2 = null;

					if (token.equals("bois")) {token2 = "1";}
					if (token.equals("argile")) {token2  = "2";}
					if (token.equals("fer")) { token2   = "3";}
					if (token.equals("cereales")) {token2  = "4";}

					compte.getDriver().get(compte.getServer()+"hero.php"); //hero_inventory.php
					randomsleep.court();
					compte.getDriver().findElement(By.xpath("//*[@class=\"openCloseSwitchBar\"]")).click();
					randomsleep.court();
					compte.getDriver().findElement(By.xpath("//*[@id=\"resourceHero"+token2 +"\"]")).click();
					randomsleep.court();
					compte.getDriver().findElement(By.xpath("//*[@id=\"saveHeroAttributes\"]/div/div[2]")).click();
					randomsleep.court();
					ecrireDansConsole("[gestionHeroProd] Hero boost : " + min.getKey().toString());
					while(iterator1.hasNext()) {
						Map.Entry me2 = (Map.Entry)iterator1.next();
						     t.ecrireDansConsole(("|" + me2.getKey() + ": " + me2.getValue() + "|")); 
					}
					//  ecrireDansConsole(""); 
					compte.getDriver().get(compte.getServer()+"dorf1.php");
					randomsleep.court(); 
				}else {ecrireDansConsole("[gestionHeroProd] Hero boost deja  la bonne ressource : " +hero.getModeProduction()) ;}

			}
		}

		//on replace le curseur sur une zone neutre
		Actions builder2 = new Actions(compte.getDriver());
		builder.moveByOffset(0, 50);		
		builder.perform();
	}



	private void aventureHero(){
		int aventureTempsRestant = bot.delaisAventures;
		//boolean estPresent;
		WebElement lienAventures;
		WebElement heroStatus;
		boolean heroEnDeplacement = false;
		int heure1 = 0;
		randomsleep.court();
		try {
			lienAventures = compte.getDriver().findElement(By.xpath("//*[contains(@class, 'adventureWhite')]"));//button-container addHoverClick//*[@class=\"speechBubbleContent\"]
		}catch  (Exception e) {
			lienAventures= null;
			ecrireDansConsole("[Aventure] Pas de quetes :( -code 0");} //deprecated
		try {
			heroStatus = compte.getDriver().findElement(By.xpath("//*[@id=\"sidebarBoxHero\"]/div[2]/div[2]/div[1]"));
			if (heroStatus.getText().contains("déplacement")){
				heroEnDeplacement = true;
			}
		}catch  (Exception e) {
			lienAventures= null;
			ecrireDansConsole("[Aventure] Pas de quetes :( -code 1");}
		

		if (lienAventures != null && heroEnDeplacement == false){ 
			randomsleep.court();
			//*[@class=\"layoutButton adventureWhite green  \"]
			WebElement bouttonQuete = compte.getDriver().findElement(By.xpath("//*[contains(@class, 'adventureWhite')]"));
			Actions hover = new Actions(compte.getDriver());
			hover.moveToElement(bouttonQuete);		
			hover.perform();
			randomsleep.court();
			try {
				heure1 = Integer.parseInt(compte.getDriver().findElement(By.xpath("//*[@class=\"text elementText\"]")).getText().split("dans ")[1].split(":")[0]);


				if (heure1 <= aventureTempsRestant){

					compte.getDriver().findElement(By.xpath("//*[contains(@class, 'adventureWhite')]")).click();
					randomsleep.court();
					WebElement heure;
					String h = null;
					try { 
						List<WebElement> listeHeure = compte.getDriver().findElements(By.xpath("//*[@class=\"timeLeft\"]//*[@class=\"timer\"]"));
						heure = listeHeure.get(0);
						h = heure.getText().split(":")[0];
						int h2 = Integer.parseInt(h);
						if (h2 <= aventureTempsRestant) {
							compte.getDriver().findElement(By.xpath("//*[@class=\"gotoAdventure arrow\"]")).click();
							randomsleep.court();
							compte.getDriver().findElement(By.xpath("//*[@class=\"green \"]")).click();
							ecrireDansConsole("[Aventure] Quete lance : dead line dans moins de " + h + " heures" );
							randomsleep.court();
						}
					}catch  (Exception e) {ecrireDansConsole("Quetes Annoncee non presente ou Hero Absent  : Echec ");}


				}
			}catch  (Exception e) {ecrireDansConsole("Pas de quetes :( -code 2");}
		}
		else {ecrireDansConsole("[Aventure] Hero en deplacement ou echec");}






	}



	////////////////////////////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////////////////
	private void fonderVillage() throws AWTException{ // resuce de voirttoupesduvillage
		/*boolean	colonAQuai = false;
		try {
			List<WebElement> colonsDuVillage = compte.getDriver().findElements(By.xpath("//*[@id=\"troops\"]/tbody/tr"));
			for(WebElement colon : colonsDuVillage) {
				boolean colonsPresents = colon.findElement(By.className("un")).getText().contains("Colon");//Colons
				int nombreColonsPresents = Integer.parseInt(colon.findElement(By.className("num")).getText());
				if (colonsPresents && nombreColonsPresents >=3){*/

		compte.getDriver().get(compte.getServer()+"karte.php");

		WebElement lienHero = compte.getDriver().findElement(By.xpath("//*[@id=\"heroImageButton\"]"));

		Actions builder = new Actions(compte.getDriver());
		builder.moveToElement(lienHero,400, 370);		
		builder.perform();
		builder.click();
		builder.perform();
		WebElement lienimage = compte.getDriver().findElement(By.xpath("//*[@id=\"tileDetails\"]/div[1]"));
		builder.moveToElement(lienimage,100, 270);
		builder.perform();
		builder.click();
		builder.perform();

		///builder.sendKeys()
		//Robot robot;
		//robot = new Robot();
		//robot.keyPress(KeyEvent.VK_ESCAPE);
		//System.in.read('\n');
		//lienimage.sendKeys(Keys.ESCAPE);



		/*			}
			}

		}catch (Exception e){ecrireDansConsole("FonderVillage echec");}*/
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////////////////
	//Module de chargement des frigos a chaque appel de la fonction

	public List<String> chargerfrigo(String motCleDeLaListe) {
		//On liste la liste principal de pillage
	//	String idListe = IdDeLaListe; // t.bot.idDeLaListeDePillage
		List<WebElement> frigosPremiereListe = compte.getDriver().findElements(By.xpath("//*[@class='listEntry' and contains(., '"+t.villageEnCours().getNom()+"')  and contains(., '"+motCleDeLaListe+"')]//tbody/tr")); //*[@id=\"list"+ idListe +"\"]//tbody/tr

		//on liste les IDs des frigo a cause du rechargement de page qui detruit des Webelements  
		List<String> frigoIds = new ArrayList<>();
		for (WebElement frigoId: frigosPremiereListe){
			if (frigoId.getAttribute("id").contains("slot-row")) {
				frigoIds.add(frigoId.getAttribute("id"));}}
		return frigoIds;
	}
	//*[@class='listEntry' and contains(., 't.villageEnCours().getNom()')  and contains(., 'perte')]
	//////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////
	//Tri et lancement des pillages sur les frigos
	public void pillage () {
		
		int rythmePillage = bot.rythmePillage;
		randomsleep.court(); 
		compte.getDriver().get(compte.getServer()+"build.php?tt=99&id=39");
		randomsleep.court(); 
		//todo : listes de listes de pillages
		//List<WebElement> raidListes = compte.getDriver().findElements(By.xpath("//*[@id=\"list568\"]"));  //*[@id=\"raidList\"]/div
		if (t.getCompte().getDriver().findElement(By.xpath("//*[@id=\"list"+t.bot.idDeLaListeDePillage+"\"]/form/div[1]")).getText().contains(t.villageEnCours().getNom())){//*[@id="list6025"]/form/div[1] //Depecrated

	

			//*[@class='listEntry' and contains(., 't.villageEnCours().getNom()')  and contains(., 'perte')]

		//On remet les IDs des frigo a jours a cause du rechargement de page
		for (String frigoIdString : chargerfrigo(t.bot.motCleListeDePillage1)){
			WebElement	frigo = compte.getDriver().findElement(By.xpath("//*[@id=\""+frigoIdString+"\"]"));

			//on recherche les croix rouge pour les enlever		
			try {
				if (!frigo.findElement(By.xpath("td[6]/img[1]")).getAttribute("alt").contains("sans perte.")){		 //[contains(@class, 'iReport')]
					frigo.findElement(By.xpath("td[7]")).click();
					randomsleep.court();
					frigo.findElement(By.xpath("//*[@id=\"lid\"]")).click();											//input[contains(@class, 'check')]         //input[@type= 'checkbox']
					randomsleep.court();
					List<WebElement> listeDoptions = frigo.findElements(By.xpath("//*[@id=\"lid\"]/option"));
					for (WebElement option : listeDoptions) {
						if (option.getText().contains(t.bot.motCleListeDesPertes)) { //Mot clée pour la liste des pertes
							option.click();
						}
					}
					randomsleep.court();
					frigo.findElement(By.xpath("//*[@id=\"save\"]/div/div[2]")).click();
					randomsleep.court();

				}
				//on catch les elememts vide
			}catch (Exception e) {/*System.out.print("un vide");*/}

		}
		//on click tout cocher
		compte.getDriver().findElement(By.xpath("//*[@class='listEntry' and contains(., '"+t.villageEnCours().getNom()+"')  and contains(., '"+t.bot.motCleListeDePillage1+"')]//div[@class='markAll']")).click(); //*[@class='markAll']  //*[@id=\"raidListMarkAll" + t.bot.idDeLaListeDePillage + "\"]
		randomsleep.court();


		if(compteurDeBoot % rythmePillage == 0){
			try { //   //*[@id="list1076"] //button //*[text()[contains( .,'pillage')  or contains( .,'lancer') or contains( .,'Lancer')  or contains( .,'Pillage')]]
			List<WebElement> btnLancerPillage = compte.getDriver().findElements(By.xpath("//*[@class='listEntry' and contains(., '" + t.villageEnCours().getNom() + "')  and contains(., '" + t.bot.motCleListeDePillage1 + "')] //button //*[text()[contains( .,'pillage')  or contains( .,'lancer') or contains( .,'Lancer')  or contains( .,'Pillage')]]"));
			ecrireDansConsole("Boutton-s trouvé-s : "+btnLancerPillage.size()+""); 
			btnLancerPillage.get(0).click();
			}catch (Exception e) {
				ecrireDansConsole("echec trouver ou cliquer bouton de pillage");
			}
		//	compte.getDriver().findElement(By.xpath("//*[text()[contains( .,'Lancer pillage')]]")).click();  //   Lancement
			ecrireDansConsole(compteurDeBoot + " --> Pillage --> MODE IMPRUDENT (Multiple de 1)"  );
		}

		else {
			//On decoche si il y a deja une attaque en cours : MODE PRUDENT
			int compteurDeFrigoSansAttaque=0;

			for (String frigoIdString : chargerfrigo(t.bot.motCleListeDePillage1)){
				try {
					if(compte.getDriver().findElement(By.xpath("//*[@id=\""+frigoIdString+"\"]//*[@class=\"attack att2\"]")).isDisplayed()){
						/*ecrireDansConsole("Deja une attaque sur " + frigoIdString);*/
						compte.getDriver().findElement(By.xpath("//*[@id=\""+frigoIdString+"\"]//*[@type=\"checkbox\"]")).click();
					}
				}catch (Exception e) {
					compteurDeFrigoSansAttaque++;
					//ecrireDansConsole("Pas dattaque en cours sur " + frigoIdString);
				}
			}

			if (compteurDeFrigoSansAttaque >= 6){
				//on lance la liste de pillage
				compte.getDriver().findElement(By.xpath("//*[text()[contains( .,'lancer pillage')]]")).click();        
				ecrireDansConsole("Lancement sur " + compteurDeFrigoSansAttaque + "Frigos");
				ecrireDansConsole(compteurDeBoot + " --> Pillage --> MODE prudent"  );
			}
		}
		randomsleep.court();

		}
		// On remet les croix verte dans la liste principale
		if (t.getCompte().getDriver().findElement(By.xpath("//*[@id=\"list"+t.bot.idDeLaListeDePillage+"\"]/form/div[1]")).getText().contains(t.villageEnCours().getNom())){//*[@id="list6025"]/form/div[1]

			//////////////////////////////////////////////////////////////////////
			//////////////////////////////////////////////////////////////////////
			//////////////////////////////////////////////////////////////////////
			//*[@class='listEntry' and contains(., 't.villageEnCours().getNom()')  and contains(., 'perte')]
			
			//On remet les IDs des frigo a jours a cause du rechargement de page
		for (String frigoIdString : chargerfrigo(t.bot.motCleListeDesPertes)){
			WebElement	frigo = compte.getDriver().findElement(By.xpath("//*[@id=\""+frigoIdString+"\"]"));

			//on recherche les croix rouge pour les enlever		
			try {
				if (frigo.findElement(By.xpath("td[6]/img[1]")).getAttribute("alt").contains("sans perte.")){		 //[contains(@class, 'iReport')]
					frigo.findElement(By.xpath("td[7]")).click();
					randomsleep.court();
					frigo.findElement(By.xpath("//*[@id=\"lid\"]")).click();											//input[contains(@class, 'check')]         //input[@type= 'checkbox']
					randomsleep.court();
					List<WebElement> listeDoptions = frigo.findElements(By.xpath("//*[@id=\"lid\"]/option"));
					for (WebElement option : listeDoptions) {
						if (option.getText().contains(t.bot.motCleListeDePillage1)) { //Mot clée pour la liste des pertes
							option.click();
						}
					}
					randomsleep.court();
					frigo.findElement(By.xpath("//*[@id=\"save\"]/div/div[2]")).click();
					randomsleep.court();
					
				}
				//on catch les elememts vide
			}catch (Exception e) {/*System.out.print("un vide");*/}

		}
		randomsleep.court();
	//	compte.getDriver().findElement(By.xpath("//*[@class='listEntry' and contains(., '"+t.villageEnCours().getNom()+"')  and contains(., '"+t.bot.motCleListeDesPertes+"')]//div[@class='markAll']")).click();  //Pour test de la selction des check box
		}


		/////////////////////////////////////////////////	
		//	MODE 1 lancement prudent puis un Imprudent :
		/*	
		//Si le compteur est impair on lance en mode prudent
		if(compteur % 2 != 0) {
		//On decoche si il y a deja une attaque en cours : MODE PRUDENT
		for (String frigoIdString : chargerfrigo()){
			try {
				if(compte.getDriver().findElement(By.xpath("//*[@id=\""+frigoIdString+"\"]//*[@class=\"attack att2\"]")).isDisplayed()){
					//ecrireDansConsole("Deja une attaque sur " + frigoIdString);
					compte.getDriver().findElement(By.xpath("//*[@id=\""+frigoIdString+"\"]//*[@type=\"checkbox\"]")).click();
				}
			}catch (Exception e) {ecrireDansConsole("Pas dattaque en cours sur " + frigoIdString);}
		 }
		//on lance la liste de pillage
		randomsleep.court();
		compte.getDriver().findElement(By.xpath("//*[text()[contains( .,'lancer pillage')]]")).click();
		ecrireDansConsole(compteur + " --> Pillage --> MODE PRUDENT (Impair)" );
		randomsleep.court();
		}

	//	//Si le compteur est pair on lance en Mode Imprudent
	//	if (compteur % 2 == 0){
	//		//On lance de force 
	//	}

		//on lance la liste de pillage
		else { 
		compte.getDriver().findElement(By.xpath("//*[text()[contains( .,'lancer pillage')]]")).click();
		ecrireDansConsole(compteur + " --> Pillage --> MODE IMPRUDENT (Pair)"  );
		randomsleep.court();
		}
		 */	
		/////////////////////////////////////////////////////////////////////////////////////////////////	

	}
	//////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////		
	/////////////////////////////////////////////////////////////////////////////////////////////////		
	/////////////////////////////////////////////////////////////////////////////////////////////////		
	private HashMap sortByValues(HashMap map) { 
		List list = new LinkedList(map.entrySet());
		// Defined Custom Comparator here
		Collections.sort(list, new Comparator() {
			public int compare(Object o1, Object o2) {
				return ((Comparable) ((Map.Entry) (o1)).getValue())
						.compareTo(((Map.Entry) (o2)).getValue());
			}
		});

		// Here I am copying the sorted list in HashMap
		// using LinkedHashMap to preserve the insertion order
		HashMap sortedHashMap = new LinkedHashMap();
		for (Iterator it = list.iterator(); it.hasNext();) {
			Map.Entry entry = (Map.Entry) it.next();
			sortedHashMap.put(entry.getKey(), entry.getValue());
		} 
		return sortedHashMap;
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////		
	/////////////////////////////////////////////////////////////////////////////////////////////////		
	/////////////////////////////////////////////////////////////////////////////////////////////////		
	/////////////////////////////////////////////////////////////////////////////////////////////////		
	/////////////////////////////////////////////////////////////////////////////////////////////////		

	private void cadeaux() {



		compte.getDriver().findElement(By.xpath("//*[@id=\"sidebarBoxQuestachievements\"]/div[2]/div[2]/form/div")).click();
		randomsleep.court();
		try{
			WebElement quete1Active = compte.getDriver().findElement(By.xpath("//*[@id=\"achievementRewardList\"]/div[3]"));//*[@id=\"achievementRewardList\"]/div[3]/a/div[1]//*[@id=\"achievementRewardList\"]/div[3]
			randomsleep.court();
			quete1Active.click();
			randomsleep.court();
			//WebElement  lien = compte.getDriver().findElement(By.className("button-content")).getText().contains("Récompense");//*[@id="button5533e89cab960"]/div/div[2]
		}catch (Exception e) {
			ecrireDansConsole("Pas de Cadeaux 1");} 

	}

	private void surveillanceHero(){


	}

	/////////////////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////

	private void majVillagesPlus(){
		Village village = villageEnCours();


		randomsleep.court();

		//donnees globlales
		// compte.getDriver().get("http://ts4.travian.fr/dorf3.php");
		try {
			compte.getDriver().findElements(By.xpath("//button[contains(@class, 'layoutButton overviewWhite green')]")).get(1).click();  // si dans une alliance
		}catch (Exception e){compte.getDriver().findElements(By.xpath("//button[contains(@class, 'layoutButton overviewWhite green')]")).get(0).click(); } //sans alliance
		randomsleep.court();
		donneesGlobales = compte.getDriver().findElements(By.xpath("//*[@id=\"overview\"]/tbody/tr"));
		randomsleep.court();
		try{determinerBesoinDeConstructions();}catch(Exception e) {t.ecrireDansConsole("Echec determinerBesoinDeConstructions");}
		try{updateMarchandSansComptePlus(t);//pour redonder en fonction de la possession du compte + ou non
		}catch(Exception e){
			t.ecrireDansConsole("Echec updateMarchandSansComptePlus => Estimation nombre Marchands par level de marche"); 
			t.tokenForcerMarcheDeLaRotation = 1;}
		
		
		// 	compte.getDriver().get("http://ts4.travian.fr/dorf3.php?s=2");
		//	donneesRessources = compte.getDriver().findElements(By.xpath("//*[@id=\"ressources\"]/tbody"));

		randomsleep.court();


		//donnees ressources
		// compte.getDriver().get("http://ts4.travian.fr/dorf3.php");
		 try {
		compte.getDriver().findElement(By.xpath("//a[contains(@id, 'villageOverViewTab2')]")).click();
		randomsleep.court();
		donneesRessources = compte.getDriver().findElements(By.xpath("//*[@id=\"ressources\"]/tbody/tr"));
		randomsleep.court();
		updateRessourcesPlus(t);} catch (Exception e) {t.ecrireDansConsole("Echec update ressources compte plus");
		 }

		// 	compte.getDriver().get("http://ts4.travian.fr/dorf3.php?s=2");
		//	donneesRessources = compte.getDriver().findElements(By.xpath("//*[@id=\"ressources\"]/tbody"));

		randomsleep.court();



		//donnees pourcentage

		//	compte.getDriver().get("http://ts4.travian.fr/dorf3.php?s=3");
		try {
		compte.getDriver().findElement(By.xpath("//a[contains(@id, 'villageOverViewTab3')]")).click();
		randomsleep.court();
		donneesRessourcesPourcentage = compte.getDriver().findElements(By.xpath("//*[@id=\"warehouse\"]/tbody/tr"));
		randomsleep.court();
		determinerBesoinDeNpc();
		} catch (Exception e) {t.ecrireDansConsole("Echec determinerBesoinDeNpc");}

		randomsleep.court();

		//donnees culturepoint

		//compte.getDriver().findElement(By.xpath("//button[contains(@class, 'layoutButton overviewWhite green  ')]")).click();
		try {
		randomsleep.court();
		compte.getDriver().findElement(By.xpath("//*[@id=\"villageOverViewTab4\"]")).click();
		randomsleep.court();
		donneesPointsDeCulture = compte.getDriver().findElements(By.xpath("//*[@id=\"culture_points\"]/tbody/tr"));

		randomsleep.court();

		determinerBesoinDeFetes();
		majSlot();
		} catch (Exception e) {t.ecrireDansConsole("Echec determinerBesoinDeFetes ou slot");
		//pour finir, fermer la fenetre de pub travian
		fermerFenetre();
		t.ecrireDansConsole("Conclusion pas de compte + ou bug");
		}




	}
	void  updateMarchandSansComptePlus(Travian t) {
		int i = 0;

		for (Village village	: listeDeVillages){
			boolean trouver = false;
			while(trouver == false){
				try {
				if (village.getUrl().contains(donneesGlobales.get(i).findElement(By.xpath("//*[@id=\"overview\"]/tbody/tr["+ (i+1) +"]/td[1]/a")).getAttribute("href").split("php")[1])){
					village.setNombreDeMarchands(Integer.parseInt(donneesGlobales.get(i).findElement(By.xpath("//*[@id=\"overview\"]/tbody/tr["+ (i+1) +"]/td[5]/a")).getText().split("/")[0].replaceAll("\\W", "")));
					village.setNombreDeMarchandsMax(Integer.parseInt(donneesGlobales.get(i).findElement(By.xpath("//*[@id=\"overview\"]/tbody/tr["+ (i+1) +"]/td[5]/a")).getText().split("/")[1].replaceAll("\\W", "")));

					ecrireDansConsole("[Debug] SANS COMPTE PLUS  Village: " +village.getNom()+ ":  Bois : " +village.getBois()+ " Argile : " +village.getArgile()+ " Fer : " +village.getFer()+ " Cereales : " +village.getCereales()+" Marchands Dispos : "+village.getNombreDeMarchands() + " sur " + village.getNombreDeMarchandsMax());

					trouver = true;
					i = 0;

				}
				else {i++;}
				}catch(Exception e) {
					village.setNombreDeMarchands(0);
					village.setNombreDeMarchandsMax(0);
					
					ecrireDansConsole("[Debug] SANS COMPTE PLUS  Village: " +village.getNom()+ ":  Bois : " +village.getBois()+ " Argile : " +village.getArgile()+ " Fer : " +village.getFer()+ " Cereales : " +village.getCereales()+" Marchands Dispos : "+village.getNombreDeMarchands() + " sur " + village.getNombreDeMarchandsMax());
					trouver = true;
					i = 0;
				}
			}
		}



	}

		

	void updateRessourcesPlus(Travian t) {
		int i = 0;

		for (Village village	: listeDeVillages){
			boolean trouver = false;
			while(trouver == false){
				if (village.getUrl().contains(donneesRessources.get(i).findElement(By.xpath("//*[@id=\"ressources\"]/tbody/tr["+ (i+1) +"]/td[1]/a")).getAttribute("href").split("php")[1])){

					village.setBois(Integer.parseInt(compte.getDriver().findElement(By.xpath("//*[@id=\"ressources\"]/tbody/tr["+ (i+1) +"]/td[2]")).getText().replaceAll("\\W", "").replaceAll("[\\u202D\\u202C.]", "").replace(".", "").replace(" ", "")));//replaceAll("\\W", "").replaceAll("[\\u202D\\u202C.]", "").replace(".", "").replace(" ", "");
					village.setArgile(Integer.parseInt(compte.getDriver().findElement(By.xpath("//*[@id=\"ressources\"]/tbody/tr["+ (i+1) +"]/td[3]")).getText().replaceAll("\\W", "").replaceAll("[\\u202D\\u202C.]", "").replace(".", "").replace(" ", "")));
					village.setFer(Integer.parseInt(compte.getDriver().findElement(By.xpath("//*[@id=\"ressources\"]/tbody/tr["+ (i+1) +"]/td[4]")).getText().replaceAll("\\W", "").replaceAll("[\\u202D\\u202C.]", "").replace(".", "").replace(" ", "")));
					village.setCereales(Integer.parseInt(compte.getDriver().findElement(By.xpath("//*[@id=\"ressources\"]/tbody/tr["+ (i+1) +"]/td[5]")).getText().replaceAll("\\W", "").replaceAll("[\\u202D\\u202C.]", "").replace(".", "").replace(" ", "")));
					village.setNombreDeMarchands(Integer.parseInt(compte.getDriver().findElement(By.xpath("//*[@id=\"ressources\"]/tbody/tr["+ (i+1) +"]/td[6]")).getText().split("/")[0].replaceAll("\\W", "").replaceAll("[\\u202D\\u202C.]", "").replace(".", "").replace(" ", "")));
					village.setNombreDeMarchandsMax(Integer.parseInt(compte.getDriver().findElement(By.xpath("//*[@id=\"ressources\"]/tbody/tr["+ (i+1) +"]/td[6]")).getText().split("/")[1].replaceAll("\\W", "").replaceAll("[\\u202D\\u202C.]", "").replace(".", "").replace(" ", "")));
					
					//String pageSource = compte.getDriver().findElement(By.id("lum")).getAttribute("innerHTML");
					//	String elemHtml = driver.findElement(By.className("clay")).getAttribute("innerHTML");
					//String pageSource = compte.getDriver().getPageSource() ;
					//String page1 = pageSource;//split("vil fc")[1];
					//ecrireDansConsole(""+ pageSource);
					//	JavascriptExecutor executor = (JavascriptExecutor)compte.getDriver();
					//	 String text= (String) executor.executeScript("document.getElementById('versionInfo').innerHTML");
					//village.setMaxStockDepot(Integer.parseInt(pageSource.split("80000")[0].toString()));
					ecrireDansConsole("Village: " +village.getNom()+ ":  Bois : " +village.getBois()+ " Argile : " +village.getArgile()+ " Fer : " +village.getFer()+ " Cereales : " +village.getCereales()+" Marchands Dispos : "+village.getNombreDeMarchands() + " sur " + village.getNombreDeMarchandsMax());

					trouver = true;
					i = 0;
					//TODO charger depot silot par pagesource et analyse de page ou par souris hover
					//	String maxDepot = t.getCompte().getDriver().findElement(By.xpath("/html/body/div[1]/div")).getText().replace(" ", "");
					//	int maxStockDepot = Integer.parseInt(maxDepot);

					/*		//survol souris du champs = a champMin
					Actions builder = new Actions(t.getCompte().getDriver());
					builder.moveToElement(listeWebelementChamps.get(g));		
					builder.perform();
					t.randomsleep.court();

					//choper le tableau des ressources necessaires pour le champs en cours
					List<WebElement> ressourcesNecessaires = listeWebelementChamps.get(g+1).findElements(By.xpath("//*[@class='showCosts']/span"));
esnecessaire "+ ressourcesNecessaires.get(1).getText());
					//	ecrireDansConsole("valeur ressourcesnecessaire "+ ressourcesNecessaires.get(2).getText());
					//	ecrireDansConsole("valeur ressourcesnecessaire "+ ressourcesNecessaires.get(3).getText());*/
					////////////////////////////////////
					////////////////////////////////////
					/*

					String maxDepot = t.getCompte().getDriver().findElement(By.xpath("//*[@id=\"stockBarWarehouse\"]")).getText().replace(" ", "");
					int maxStockDepot = Integer.parseInt(maxDepot);

					String maxSilo = t.getCompte().getDriver().findElement(By.xpath("
					//	ecrireDansConsole("valeur ressourcesnecessaire "+ ressourcesNecessaires.get(0).getText());
					//	ecrireDansConsole("valeur ressourc//*[@id=\"stockBarGranary\"]")).getText().replace(" ", "");
					int maxStockSilo = Integer.parseInt(maxSilo);

					village.setMaxStockDepot(maxStockDepot);
					village.setMaxStockSilo(maxStockSilo);

					ecrireDansConsole("Update Ressources de : " +village.getNom());

					 */



				}
				else {i++;}
			}
		}



	}


	private void detectionTribut(){
		try {
			String tribut = compte.getDriver().findElement(By.xpath("//*[@id=\"sidebarBoxHero\"]/div[2]/div[1]/div/a[1]/img")).getAttribute("alt");
			compte.setTribut(tribut);
			t.ecrireDansConsole("Tribut : " + tribut);
		}catch (Exception e){t.ecrireDansConsole("echec detection tribut");}
	}
	
	private void detectionSlotDeVillageDuCompte(){
		try {
			String slot = compte.getDriver().findElement(By.xpath("//*[@id=\"sidebarBoxVillagelist\"]/div[2]/div[1]/div[2]/div[1]")).getText();
			String txt1 = slot.split("/")[0].replaceAll("\\W", "").replaceAll("[\\u202D\\u202C.]", "").replace(".", "").replace(" ", "");;
			String txt2 = slot.split("/")[1].replaceAll("\\W", "").replaceAll("[\\u202D\\u202C.]", "").replace(".", "").replace(" ", "");;
			int intSlot1 = Integer.parseInt(txt1);
			int intSlot2 = Integer.parseInt(txt2);
			int result = intSlot2 - intSlot1;
			compte.setSlotDeVillageDuCompte(result);
			t.ecrireDansConsole("Slot de Village Du Compte: " + intSlot1 +" sur "+ intSlot2 + " Slot Libre : " +result);
		}catch (Exception e){t.ecrireDansConsole("echec detection slot De Village Du Compte");}
	}



	private void npcNegatif() {

		randomsleep.court();


		compte.getDriver().findElement(By.xpath("//button[contains(@class, 'marketWhite')]")).click(); //TODO metre le systeme de contournement du compte + 
		randomsleep.court();
		compte.getDriver().findElement(By.xpath("//div[contains(@class, 'favorKey0')]")).click();
		randomsleep.court();
		compte.getDriver().findElement(By.xpath("//button[contains(@value, 'Échange de ressources')]")).click();
		randomsleep.court();
		compte.getDriver().findElement(By.xpath("//*[@id=\"m2[3]\"]")).clear();
		compte.getDriver().findElement(By.xpath("//*[@id=\"m2[3]\"]")).sendKeys("1200000");
		randomsleep.court();
		compte.getDriver().findElement(By.xpath("//button[contains(@value, 'Distribuer les ressources restantes.')]")).click();
		randomsleep.court();
		//randomsleep.court();
		compte.getDriver().findElement(By.xpath("//button[contains(@id, 'npc_market_button')]")).click();
		ecrireDansConsole("Npc pour eviter la famine");
		randomsleep.court();






	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////////////////////
	private void determinerBesoinDeFetes() {
		int besoinDeFete = 0;
		int i = 0;


		for (Village village : listeDeVillages) {
			besoinDeFete = 0;
			boolean trouver = false;
			while(trouver == false){
				
					if (village.getUrl().contains(donneesPointsDeCulture.get(i).findElement(By.xpath("//*[@id=\"culture_points\"]/tbody/tr["+ (i+1) +"]/td[1]/a")).getAttribute("href").split("php")[1])) {
						try {
						if (donneesPointsDeCulture.get(i).findElement(By.xpath("//*[@id=\"culture_points\"]/tbody/tr["+ (i+1) +"]/td[3]/a/span")).getText().equals("•") ){
						besoinDeFete = 1;
						village.setBesoinDeFete(besoinDeFete);

						}else {village.setBesoinDeFete(besoinDeFete);} 
						
						trouver = true;
						i = 0;	
						}
						catch (Exception e) {trouver = true; i = 0; village.setBesoinDeFete(besoinDeFete);}
					t.ecrireDansConsole(village.getNom()+ " : " +" besoinFete == " + besoinDeFete);	
					}else {i++;}
				
			}
		}
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public void  majSlot(){
		int villageSlot = 0 ;
	
		int i = 0;


		for (Village village : listeDeVillages) {
		
			boolean trouver = false;
			while(trouver == false){
				
					if (village.getUrl().contains(donneesPointsDeCulture.get(i).findElement(By.xpath("//*[@id=\"culture_points\"]/tbody/tr["+ (i+1) +"]/td[1]/a")).getAttribute("href").split("php")[1])) {
						
						try {
							
						WebElement slotTxt = donneesPointsDeCulture.get(i).findElement(By.xpath("//*[@id=\"culture_points\"]/tbody/tr["+ (i+1) +"]/td[5]"));
						String txt1 = slotTxt.getText().split("/")[0].replaceAll("\\W", "").replaceAll("[\\u202D\\u202C.]", "").replace(".", "").replace(" ", "");
						String txt2 = slotTxt.getText().split("/")[1].replaceAll("\\W", "").replaceAll("[\\u202D\\u202C.]", "").replace(".", "").replace(" ", "");
						int intTxt1 = Integer.parseInt(txt1);
						int intTxt2 = Integer.parseInt(txt2);
						int result = intTxt2 - intTxt1;
						villageSlot = result;
						village.setVillageSlot(villageSlot);
			
						
						trouver = true;
						i = 0;	
						}catch (Exception e) {
							trouver = true;
							t.ecrireDansConsole("echec lecture des slots");
							i = 0;
							
							}
					t.ecrireDansConsole(village.getNom()+ " : " +" Slot de Village disponible == " + villageSlot );	
					}else {
						i++;
						}
				
			}
		}
	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private void determinerBesoinDeConstructions() {
		int i = 0;

		for (Village village : listeDeVillages) {
			boolean trouver = false;
			while(trouver == false){
				if (village.getUrl().contains(donneesGlobales.get(i).findElement(By.xpath("//*[@id=\"overview\"]/tbody/tr["+ (i+1) +"]/td[1]/a")).getAttribute("href").split("php")[1])){
					village.setConstructionsEnCours(donneesGlobales.get(i).findElements(By.xpath("//*[@id=\"overview\"]/tbody/tr["+ (i+1) +"]/td[3]/a/img")).size());

					t.ecrireDansConsole(village.getNom()+ " : " +" setConstructionsEnCours == " + donneesGlobales.get(i).findElements(By.xpath("//*[@id=\"overview\"]/tbody/tr["+ (i+1) +"]/td[3]/a/img")).size());
					trouver = true;
					i = 0;
				} else {i++;}

			}
		}
		int resteAConstruire = 0;
		for (Village village : listeDeVillages){
			resteAConstruire = 0;
			// village.setBesoinDeConstruction(true);// premiere connection pas de liste de batiment chargee... donc on autorise
			for (Batiment batiment : village.getBatiments()){

				for (Batiment tempBat : village.getTemplateDuVillage()){
					if (batiment.getNomBatiment().equals(tempBat.getNomBatiment())){
						if(batiment.getLevelBatiment() < tempBat.getLevelBatiment()){
							resteAConstruire++;
						}
					}
				}

			}
			
		//	if(village.getTemplateDuVillage().toString().equals("listeDeBatimentsDuTeamplate4") ){}
			if (resteAConstruire < 1 && !village.getBatiments().isEmpty() ){
				village.setBesoinDeConstruction(false);
				ecrireDansConsole(village.getNom()+" : Template Fini");
				resteAConstruire = 0;
			}else {
				village.setBesoinDeConstruction(true);
				ecrireDansConsole(village.getNom()+" : Template Non Fini");
				resteAConstruire = 0;
			}
		}
		/* if (resteAConstruire > 0){
			 village.setBesoinDeConstruction(true);
			 }else{
				 village.setBesoinDeConstruction(false);
				 }*/


	}


	/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	private void determinerBesoinDeNpc() {
		//npcNegatif();
		int delaisAvantFamineOuDebordement  = 9999;
		boolean enNegatif;
		int i = 0;
		String texte = "famine";



		for (Village village : listeDeVillages){

			boolean trouver = false;
			while(trouver == false){




				if ( village.getUrl().contains(donneesRessourcesPourcentage.get(i).findElement(By.xpath("//*[@id=\"warehouse\"]/tbody/tr["+(i+1)+"]/td[1]/a")).getAttribute("href").split("php")[1] ) ){

					try{ delaisAvantFamineOuDebordement  = Integer.parseInt(donneesRessourcesPourcentage.get(i).findElement(By.xpath("//*[@id=\"warehouse\"]/tbody/tr["+ (i+1) +"]/td[7]")).getText().split(":")[0]);
					try { enNegatif = donneesRessourcesPourcentage.get(i).findElement(By.xpath("//*[@id=\"warehouse\"]/tbody/tr[" +(i+1)+ "]/td[7]//*[contains(@class, 'crit')]")).isDisplayed();}catch (Exception e){
						enNegatif=false;}
					if (enNegatif==true){texte="Famine";}else{texte="Debordement";}
					if (delaisAvantFamineOuDebordement < 1 && enNegatif==true ) {
						village.setBesoinDeNpc(true);
						ecrireDansConsole(village.getNom() +": Delais avant "+texte+" : "+delaisAvantFamineOuDebordement+" En Negatif = "+enNegatif );
						i++;
					}else {
						village.setBesoinDeNpc(false);
						ecrireDansConsole(village.getNom() +": Delais avant "+texte+" : "+delaisAvantFamineOuDebordement+" En Negatif = "+enNegatif );
						i++;
					}
					}catch (Exception e) {
						String string100pourcent = donneesRessourcesPourcentage.get(i).findElement(By.xpath("//*[@id=\"warehouse\"]/tbody/tr["+ (i+1) +"]/td[6]")).getText().replaceAll("\\W", "");


						if (string100pourcent.contains("100")){
							texte="Debordement";
							enNegatif=false;
							village.setBesoinDeNpc(false);
							ecrireDansConsole(village.getNom() +": Delais avant "+texte+" : *En Debordement* En Negatif = "+enNegatif );
							i++;
						}
						else{
							texte="Famine Veritable";
							enNegatif=true;
							village.setBesoinDeNpc(true);
							village.setCropDeath(true);
							ecrireDansConsole(village.getNom() +": Delais avant "+texte+" : *En CropDeath* En Negatif = "+enNegatif );

							i++;
						}
					}



					trouver = true;
					i=0;
				}
				else {i ++;}
			}
		}
		//TODO fairele chargermnt des depot et silo par ici
		//String pageSource = compte.getDriver().findElement(By.id("lum")).getAttribute("innerHTML");//outerHTML //innerHTML
		//	String elemHtml = driver.findElement(By.className("hl")).getAttribute("innerHTML");// innerHTML
		//String pageSource = compte.getDriver().getPageSource() ; //outerHTML //innerHTML
		//	 String elemHtml = driver.findElement(By.xpath("//*")).getAttribute("outerHTML");
	}


	/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//determiner le besoin de se connecter au village
	private int besoinDePasserSurLeVillage(Village village) {
		int besoin = 0;
		int besoin2 = 0;
		
	
		//TODO Important! -> gerer si le village a besoin du marché pour evacuer	(apparement deja fait pour cereales)  
		if (village.getChampsFinis() == false && village.getConstructionsEnCours() < limiteDeConstruction 
				|| village.getVillageSlot() > 0 && t.compte.getSlotDeVillageDuCompte() > 0 && village.getColons() >= 3 && t.getCompte().listeCompteCoordoneesPourColoniser.size() > 0
				|| village.getBesoinDeFete() == 1 &&  bot.faireFete == true
				|| village.getVillageCapitale() == true 
				|| village.getVillagePillage() == true 
				|| village.getCropDeath() == true 
				|| village.getConstructionsEnCours() < limiteDeConstruction && village.getBesoinDeConstruction() == true
				|| village.getBois() >= village.getMaxStockDepot()*90/100 	
				|| village.getArgile() >= village.getMaxStockDepot()*90/100
				|| village.getFer() >= village.getMaxStockDepot()*90/100
				|| village.getCereales() >= village.getMaxStockSilo()*90/100 		
				|| compteurDeBoot == 1)	{
			besoin = 1;
		}

		if ( besoin == 1 ) {
			besoin2 = 1;
		}

		return besoin2 ;

	}



	/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	private void eviterSurvey() {
		try {
			prendrePhoto("Connexion");
			randomsleep.court();
			boolean boutonContinuer = compte.getDriver().findElement(By.xpath("//*[@id=\"sysmsg\"]/p[1]/a")).isDisplayed();
			randomsleep.court();
			if (boutonContinuer == true) {
				prendrePhoto("ifboutonContinueregaltrue");
				compte.getDriver().findElement(By.xpath("//*[@id=\"sysmsg\"]/p[1]/a")).click();
				ecrireDansConsole("Eviter Sondage fait");
			}
		}catch (Exception e) {
			ecrireDansConsole("Pas de sondage a eviter");
		}

	}

	private void prendrePhoto(String nom) {
		numeroDePhoto++;
		
		String userPath = System.getProperty("user.home") + "\\botpackage\\photos";
		File dossierPhotos = new File(userPath);
		boolean isCreated = dossierPhotos.mkdirs();
		try {
		String[] repertoire = new java.io.File(userPath).list();
		
		ecrireDansConsole(String.valueOf(repertoire.length)+ " Photos dans le dossier");
		
		////////////// desactivé
	/*
		for (int i=0; i<repertoire.length; i++)
		{
			// Afficher le nom de chaque élément
			ecrireDansConsole(repertoire[i]);
		}
		///////////
*/
		//trouver nom equivalent et incrementer
		for (int i=0; i<repertoire.length; i++)
		{
			// if (repertoire[i].split("\\.")[0].equals(nom)  || repertoire[i].split("\\.")[0].split("\\-")[0].equals(nom) && Integer.parseInt (repertoire[i].split("\\.")[0].split("\\-")[1]) <= numeroDePhoto  ) 
			{
				//	   numeroDePhoto = Integer.parseInt (repertoire[i].split("\\.")[0].split("\\-")[1]);
				//// numeroDePhoto++;
			}

			//if (Integer.parseInt (repertoire[i].split("\\.")[0].split("\\-")[1]) == numeroDePhoto) {numeroDePhoto++;}
			if (numeroDePhoto > 30) { numeroDePhoto = 0;
			/*   try {
	        		   FileUtils.forceDelete(new File("c:\\test\\"+nom+"-"+numeroDePhoto+".jpg"));}catch (Exception e) {
	   		  			ecrireDansConsole("supression ratee");
	   		  		}*/
			}
		}
	}catch (Exception e) {
		ecrireDansConsole("Dossier vide.");
	}

		////////////
		try {
			File scrFile = ((TakesScreenshot)compte.getDriver()).getScreenshotAs(OutputType.FILE); 
			FileUtils.copyFile(scrFile, new File(userPath + "\\"  +nom+"-"+numeroDePhoto+".jpg"));
		}catch (Exception e) {
			ecrireDansConsole("Photo ratee");
		}
	} 


	public void detectionAttaqueSimple(boolean verbose){

		 List<WebElement> croixRouges = t.getCompte().getDriver().findElements(By.xpath("//*[@id=\"sidebarBoxVillagelist\"]/div[2]/div[2]/ul/li[contains(@class, 'attack')]")); //*[@id=\"sidebarBoxVillagelist\"]/div[2]/div[2]/ul/li//[contains(@class, 'attack')]
		 ArrayList<String> lststrCroix = new ArrayList<String>() ;
		lststrCroix.clear();

		for(WebElement webCroix : croixRouges){
			if(croixRouges.size() > 0 ){
			String nomVCroix = webCroix.findElement(By.xpath("./a/div")).getText();
			lststrCroix.add(nomVCroix);
			}

		}	 ///a/div    not

		for(Village v : listeDeVillages){
			if(lststrCroix.size() > 0){
				
			for(String strCroix : lststrCroix){
				if(v.getNom().contains( strCroix )){ 
					//traitement pour v attaqué 
					t.ecrireDansConsole("Attaque sur "+ strCroix ); 
				}
				else{
					v.heureDeGuet = new Date(); 
					if (verbose == true ){
						t.ecrireDansConsole(v.getNom()+" : " + v.heureDeGuet);
			}

		}
				}
				
					}else{ // si liste null
						v.heureDeGuet = new Date(); 
						if (verbose == true){
							t.ecrireDansConsole(v.getNom()+" : " + v.heureDeGuet);
				}

			}

		}
	
				//WebElement croix = null;
				//try {croix = webCroix.findElement(By.xpath("self::li[contains(@class, 'attack')]"));}catch(Exception e){}
			//	if(!(croix==null)){  //[contains(@class, 'attack')]
					
					
								
				
				//t.ecrireDansConsole("Attaques detectées  : " + croixRouges.size() +" Villages attaqués");
			//for(WebElement croix : croixRouges){
			//t.ecrireDansConsole("Attaque sur "+croix.findElement(By.xpath("./a/div")).getText());  ///a/div
			//analyseAttaque();
		//}

			
			
		
		//pour les sans croix rouge
	/*	
		for(WebElement sc: sansCroix ){
			for(Village v : listeDeVillages){
				if(v.getNom().equals(sc.findElement(By.xpath("./a/div")).getText())){
					v.heureDeGuet = new Date(); 
					if (verbose == true ){t.ecrireDansConsole(v.getNom()+" : " + v.heureDeGuet);
				}
				}
				
			}
		}
*/


	
	}
	public void analyseAttaque(){
		//*[@id="sidebarBoxVillagelist"]/div[2]/div[2]/ul/li[@class=" attack"]
		
	}


	public void fermerFenetre() {
		try {
			t.driver.findElement(By.xpath("//*[@id=\"dialogCancelButton\"]")).click();
			ecrireDansConsole("fenetre fermée");
			randomsleep.court();
		}catch(Exception e ) {ecrireDansConsole("echec fermer fenetre");}
		}
	
	
	
	
	
	public void colonisationPlanifiee(Village village) {
		int x = t.compte.listeCompteCoordoneesPourColoniser.get(0).getX();// 41;
		int y = t.compte.listeCompteCoordoneesPourColoniser.get(0).getY();//-11;
		try {
			
			
			t.getCompte().getDriver().findElement(By.xpath("//*[contains(@href, 'karte.php')]")).click();
			randomsleep.court();
			t.getCompte().getDriver().get("https://ts1.travian.fr/position_details.php?x="+ x +"&y="+ y +"");
			randomsleep.court();
			WebElement btn = t.getCompte().getDriver().findElement(By.xpath("//a[contains(., 'fonder') or contains(., 'Fonder')] "));
			randomsleep.court();
			btn.click();
			randomsleep.court();
	        //   Actions builder = new Actions(t.getCompte().getDriver());
	        //    builder.contextClick(btn);
	        //    builder.perform();
			ecrireDansConsole("Colons lancés sur : "+ x +" " + y) ;
	            t.compte.listeCompteCoordoneesPourColoniser.remove(0);
	            village.setColons(0);
		}catch (Exception e) {
			ecrireDansConsole("echec lancement colons") ;
		}
	}

	///////////////////////////////////////////////////////////////////////////////////////////////////	
	///////////////////////////////////////////////////////////////////////////////////////////////////	
	///////////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////////	
	///////////////////////////////////////////////////////////////////////////////////////////////////	




}

