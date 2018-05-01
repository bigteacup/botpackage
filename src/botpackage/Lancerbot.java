package botpackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Properties;

import org.openqa.selenium.WebDriver;





	public class Lancerbot  {

		private static Randomsleep randomsleep = new Randomsleep();
		public static boolean actif = true;
		static WebDriver driver;
		static Attaque attaque = new Attaque();
		static ArrayList<Attaque> listeAttaques = new ArrayList<Attaque>();
	Travian travian;
	FxFenetreController fxFenetreController;
	
	
	//console
	FxConsoleExperimentale console;
	public void setConsole(FxConsoleExperimentale console) {
		this.console = console;
	}

	
	
	
	/// reglages recupérés par le bot et l'interface
	boolean faireDefiler = true;

	public int delaisAventures = 150;
	public int rythmePillage = 1;
	public int evacuerAPartirDe = 80;
	public int pourcentageNePasLaisserLeVillageSourceEnDessousDe = 20;
	public int champMinFx = 9;
	
	public int pourcentageApproPetitVillageFx = 30;
	public int ressourcesMiniSurVillageSourceFx = 5000;
	public int distanceMaxPourMarchands = 24; 
	public int vitesseMarchands = 16; //gaulois = 24 romains = 16 germains = 12
	public int DepotMiniPourAiderFx = 5000;
	
	//ApproUrgenceFamine
	public int pourcentageApproUrgenceFamine = 15;
	public int ressourcesMiniSurVillageSourceApproUrgenceFamine = 10000;
	public int depotMiniPourFonctionnerApproUrgenceFamine = 30000;
	public int distanceMaxPourMarchandsApproUrgenceFamine = 10;
	public int marchandsMinPourFonctionnerApproUrgenceFamine = 10;
	
	//decalageCereales
	public int decalageCerealesLevelDebut = 8 ;
	public int decalageCerealesLevelFin = 10 ;
	
	
	//achetermarché
	int tempsMax = 6; // temps en heure
	//int marchandsMinPourAcheter = 10;
	int marchandsMinPourFonctionner = 1; //dans la boucle while plus bas 
	int marchandsAllouésPourAchat =  2;//village.getNombreDeMarchandsMax()/2; 
	int pourcentageDeclenchementAcheter = 75; // 75% de la moyenne du total des ressources
	int pourcentageDeclenchementAcheterContre = 50;
	int pourcentageDeclenchementAcheterContreMoyenne = 50;
	int pourcentageDeclenchementAcheterContreVillage = 25;
	
	
	boolean decalageCereales = true;
	boolean pillage = true;
	boolean faireFete = true;
	boolean evacuerSurplusRessources = true;
	boolean approUrgenceFamine = true;
	boolean approPetitsVillages = true;
	boolean construireBatiments = true;
	public boolean optimiserProdHero = true;
	public boolean faireAventures = true;
	public boolean monterChampsCapitale = true;
	public boolean monterChamps = true;
	public boolean npc = true;
	public boolean rotationVillage = true;
	public boolean acheterAuMarché = true;
	
	public boolean afficherAttente = false;
	public ArrayList<File> listeFichiers = new ArrayList<File>();
	public Properties fichierTemplatesProperties;
	
	public String idDeLaListeDePillage = "1076";
	public String motCleListeDePillage1 = "listedepillage1";
	public String motCleListeDesPertes = "perte";
	
	public ArrayList<TemplatesDeVillages> listeDeTemplates = new ArrayList<TemplatesDeVillages>();
	public TemplatesDeVillages templateLancerBot;
	
	GestionnaireDeComptes gestionnaireDeComptes = new GestionnaireDeComptes();















/*
public void faireUnTemplateDeCompte(int i) {
	//listeDeTemplates.clear();
	this.templates = new TemplatesDeVillages(i);
	listeDeTemplates.add(templates);
}

*/

		public  Lancerbot() {
			
			templateLancerBot = new TemplatesDeVillages();
		//	faireUnTemplateDeCompte(0);
			
			listeDeTemplates.add(templateLancerBot);
			

			 chargerTemplate();
			
			
			 System.out.println("Encodage : "+System.getProperty("file.encoding"));
			
			
			//this.bot = bot;
			//console = new fxConsoleExperimentale(bot); console.start();
		//	this.bot = bot;
			//try {
			//	tfenetre = new Fenetre(bot);
			//	fxFenetre = new FxFenetre();

			//	fxFenetre.main();
			//	fxFenetre.setBot(bot);

		  //      new JFXPanel();
		   //     Platform.runLater(() -> {
		    //        try {
		   //             fxFenetre = new FxFenetre(bot);
		                
		    //        } catch (Exception ex) {Logger.getLogger(Lancerbot.class.getName()).log(Level.SEVERE, null, ex);    }	        });


			//} catch (IOException e) {travian.ecrireDansConsole("IO exeption tocard");}

		}

		public  Lancerbot(FxFenetreController fxFenetreController, FxConsoleExperimentale console) {
			 
			setConsole(console);
			setfxFenetreController(fxFenetreController);
			templateLancerBot = new TemplatesDeVillages();
			listeDeTemplates.add(templateLancerBot);
			 chargerTemplate();
			
		}
		public  Lancerbot(FxFenetreController fxFenetreController) {
			 
			
			setfxFenetreController(fxFenetreController);
			templateLancerBot = new TemplatesDeVillages();
			listeDeTemplates.add(templateLancerBot);
		}





	public static void main(String[] args)  {
		//Lancerbot botStart = new Lancerbot();
	//	botStart.lancerbot(botStart);

				}

	
	
	public void chargerTemplate() {
		listeDeTemplates.clear();
		listeFichiers = gestionnaireDeComptes.listerFichiers("templates", "template");
		
		if(listeFichiers.isEmpty()== false) {
			for(File f :listeFichiers) {
			fichierTemplatesProperties = loadTemplatesProperties(f.getName());
			TemplatesDeVillages newTemplate = new TemplatesDeVillages();
			
			for(String batKey : fichierTemplatesProperties.stringPropertyNames()) {
				Batiment newBat = new Batiment(batKey, Integer.parseInt(fichierTemplatesProperties.getProperty(batKey)));
				newTemplate.getListeDeBatiments().add(newBat);
				newTemplate.setNomDuTemplate(f.getName());
				
			}
			listeDeTemplates.add(newTemplate);
				}
			}
		
		
	}
	
	
	



	
	
	
	
	
	
	
	
	public TemplatesDeVillages trouverTemplate(String nom) {
		for(TemplatesDeVillages temT : listeDeTemplates ) {
		
			try {
			if(temT.getNomDuTemplate().equals(nom)) {
				return temT;
			}
			}catch(Exception e) {
				
			}
		}
		return null;
	}






public static void arreter(){
	actif = false;

}



public WebDriver setDriver(WebDriver driver) {
	driver = this.driver;
	return driver;


}




public void setfxFenetreController(FxFenetreController fxFenetreController){
	this.fxFenetreController = fxFenetreController;
	

	
}

public TemplatesDeVillages getTemplateLancerBot() {
return templateLancerBot;
}




public void setTemplateLancerBot(TemplatesDeVillages templateLancerBot) {
	this.templateLancerBot = templateLancerBot;
}










public void lancerTravian(String nomDeCompte, String serveur, String userName, String motDePasse){
	
/*	try {
		Thread.sleep(30000);
	} catch (InterruptedException e) {e.printStackTrace();
	}
*/	
	if (travian == null){
	//if (!travian.isAlive()){
		travian = new Travian(this, nomDeCompte , serveur, userName, motDePasse);
		travian.setFxFenetreController(fxFenetreController);
		travian.start();
		travian.allume = true;
		travian.ecrireDansConsole(travian.getName(), true);
	    travian.ecrireDansConsole(travian.getState().toString(), true);
//	}
	    

	}
	else {
		if (!travian.isAlive() ){
		travian = new Travian(this, nomDeCompte, serveur, userName, motDePasse);
		travian.setFxFenetreController(fxFenetreController);
		travian.start();
		travian.allume = true;
		travian.ecrireDansConsole(travian.getName(), true);
	    travian.ecrireDansConsole(travian.getState().toString(), true);} //if (!travian.isAlive()){
	}
	
	//else {	travian.allume = true; travian.notify();}
	/*else {travian= new Travian();
	travian.start();
	travian.ecrireDansConsole(travian.getName());
    travian.ecrireDansConsole(travian.getState());
}*/


}

public void reprendreTravian(){
		travian.ecrireDansConsole(travian.getName(), true);
    travian.ecrireDansConsole(travian.getState().toString(), true);

		travian.resume();
		travian.ecrireDansConsole(travian.getName(), true);
	    travian.ecrireDansConsole(travian.getState().toString(), true);

	}
public synchronized void pause(){
	
	travian.pause();
	/*if (travian.enPause == true){
		travian.enPause = false;*/
		
	/*	synchronized(travian) {
		 travian.notify();
		}*/
	
	//}
}
public void annulerPause(){
	if (travian != null){
	if (travian.isAlive()){
		if (travian.randomsleep.enAttente == true){
			travian.interrupt();
		}
		}}
}

public void eteindreTravian(){
//	if (travian != null){
//	if (travian.isAlive()){
try {
		travian.allume = false;
	if (travian.isAlive() == true) {console.flux.envoyer(fxFenetreController, "********* Arret Demande ************ Arret Demande ************** Arret Demande *************", true);}
	else {console.flux.envoyer(fxFenetreController, "Rien n'est lancé...", true);}
	
}catch(Exception e) {
	try {console.flux.envoyer(fxFenetreController, "Travian non lancé", true);}catch(Exception e1) {}
	System.out.println("Travian non lancé");}		


//	}}





}

/*
public void attaque(){
	try {Thread.sleep(20000);} catch (InterruptedException e) {e.printStackTrace();}
	 travian.suspend();

	Verifierdate verifDate = new Verifierdate(travian, attaque, listeAttaques);
verifDate.start();

travian.ecrireDansConsole(verifDate.getName());
travian.ecrireDansConsole(verifDate.getState());


//	randomsleep.court();
try {
Attaque attaque1 = new Attaque(travian,verifDate);
attaque1.start();
listeAttaques.add(attaque1);
 //try {Thread.sleep(20000);} catch (InterruptedException e) {e.printStackTrace();}

		 	randomsleep.court();
Attaque attaque2 = new Attaque(travian,verifDate);
attaque2.start();
listeAttaques.add(attaque2);
// try {Thread.sleep(20000);} catch (InterruptedException e) {e.printStackTrace();}

randomsleep.court();
Attaque attaque3 = new Attaque(travian,verifDate);
attaque3.start();
listeAttaques.add(attaque3);
// try {Thread.sleep(20000);} catch (InterruptedException e) {e.printStackTrace();}


randomsleep.court();
Attaque attaque4 = new Attaque(travian,verifDate);
attaque4.start();
listeAttaques.add(attaque4);
// try {Thread.sleep(20000);} catch (InterruptedException e) {e.printStackTrace();}

Attaque attaque5 = new Attaque(travian,verifDate);
attaque5.start();
listeAttaques.add(attaque5);
 //try {Thread.sleep(20000);} catch (InterruptedException e) {e.printStackTrace();}

randomsleep.court();
Attaque attaque6 = new Attaque(travian,verifDate);
attaque6.start();
listeAttaques.add(attaque6);
// try {Thread.sleep(20000);} catch (InterruptedException e) {e.printStackTrace();}

randomsleep.court();
Attaque attaque7 = new Attaque(travian,verifDate);
attaque7.start();
listeAttaques.add(attaque7);
// try {Thread.sleep(20000);} catch (InterruptedException e) {e.printStackTrace();}


randomsleep.court();
Attaque attaque8 = new Attaque(travian,verifDate);
attaque8.start();
listeAttaques.add(attaque8);
// try {Thread.sleep(20000);} catch (InterruptedException e) {e.printStackTrace();}
}catch (Exception e){}

//	randomsleep.court();

//	for(Attaque attaque : listeAttaques){
	//	attaque.bouttons.get(0).submit();

//	}


}

*/

////////////////////////////////////////////////////////////////////////
//charger les configs précédentes
public Properties loadTemplatesProperties(String nomTemplate){
	
String path = System.getProperty("user.home")+"\\botpackage\\templates\\"+nomTemplate;		//System.getProperty("user.home") + "\\botpackage\\comptes"; +\".properties"
Properties properties = new Properties();
FileInputStream input = null;
InputStreamReader i= null;
try {
	input = new FileInputStream(path);
} catch (FileNotFoundException e) {e.printStackTrace();} 

try {
	 i =new InputStreamReader(input,"UTF-8");
} catch (UnsupportedEncodingException e1) {	e1.printStackTrace();}


try{
properties.load(i);

} catch (IOException e) {e.printStackTrace();}
finally{
	try {
		if(i !=null)
		i.close();
	}  

	catch (IOException e) {e.printStackTrace();}//
	try {
		if(input !=null)
		input.close();
	}  

	catch (IOException e) {e.printStackTrace();}
		
}
return properties;	
	
}



















public Properties getFichierProperties() {
return fichierTemplatesProperties;
}

public void setFichierProperties(Properties fichierTemplatesProperties) {
this.fichierTemplatesProperties = fichierTemplatesProperties;
} 













public static void copyFullRecursive(File source, File dest) throws IOException
{
    if (source.isDirectory())
    {
        File dir = new File(dest, source.getName());
        dir.mkdir();

        File[] list = source.listFiles();
        if (list != null)
            for (File fic : list)
                copyFullRecursive(fic, dir);
    }
    else
    {
        Files.copy(source.toPath(), new File(dest, source.getName()).toPath());
    }
}

	/** copie le fichier source dans le fichier resultat
	 * retourne vrai si cela réussit
	 */
	public static boolean copyFile(File source, File dest){
		try{
			// Declaration et ouverture des flux
			java.io.FileInputStream sourceFile = new java.io.FileInputStream(source);

			try{
				java.io.FileOutputStream destinationFile = null;

				try{
					destinationFile = new FileOutputStream(dest);

					// Lecture par segment de 0.5Mo
					byte buffer[] = new byte[512 * 1024];
					int nbLecture;

					while ((nbLecture = sourceFile.read(buffer)) != -1){
						destinationFile.write(buffer, 0, nbLecture);
					}
				} finally {
					destinationFile.close();
				}
			} finally {
				sourceFile.close();
			}
		} catch (IOException e){
			e.printStackTrace();
			return false; // Erreur
		}

		return true; // Résultat OK

}


	}
