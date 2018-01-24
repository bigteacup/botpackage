package botpackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.ie.InternetExplorerDriver;

public class Compte {
	
	
	public Compte(String nomDeCompte) {
		
		fichierProperties = loadConfigComptes(nomDeCompte);
	}
	public Compte() {
		
		
	}
	
	public boolean PossedeUnArtefactGDGS = false;	
public boolean getPossedeUnArtefactGDGS() {
		return PossedeUnArtefactGDGS;
	}
	public void setPossedeUnArtefactGDGS(boolean possedeUnArtefactGDGS) {
		PossedeUnArtefactGDGS = possedeUnArtefactGDGS;
	}

public String nomDeCompte;	
public Properties	fichierProperties ;
public int limiteDeConstructionSimultanees;
public int SlotDeVillageDuCompte = 0;
public ArrayList<Ordre> listeCompteCoordoneesPourColoniser = new ArrayList<Ordre>();



private String server;
private String userName;
private String passWord;
private String tribut = "";


		

	//private WebDriver driver = new FirefoxDriver();
	//////////////////////////////////////////////

public int etablirLimiteDeConstructionSimultanees() {
	
	
	if (tribut.equals("Romains")) {
		limiteDeConstructionSimultanees = 3;
		
	}else {
		limiteDeConstructionSimultanees = 2;
	}
	return limiteDeConstructionSimultanees;
}

//comptePourCreation
public void comptePourCreation() {
	nomDeCompte= "Nouveau Compte";	
	server = "";
	userName ="";
	passWord="";
	tribut = "";
	
}


public void creerCompteManuellement() {
	 nomDeCompte= "Nouveau Compte";	
	//fichierProperties= ;

	server = "";
	userName ="";
	passWord="";
	tribut = "";
	
}


//charger les configs précédentes
public Properties loadConfigComptes(String nomDeCompte){
this.nomDeCompte = nomDeCompte;
String path = System.getProperty("user.home")+"\\botpackage\\comptes\\"+ nomDeCompte ;		//System.getProperty("user.home") + "\\botpackage\\comptes"; +\".properties"
Properties properties = new Properties();
FileInputStream input = null;

try {
	input = new FileInputStream(path);
} catch (FileNotFoundException e) {e.printStackTrace();} 

try{
properties.load(input);

} catch (IOException e) {e.printStackTrace();}
finally{
	try {
		input.close();
	} catch (IOException e) {e.printStackTrace();}
}
return properties;	
	
}

public Properties getFichierProperties() {
return fichierProperties;
}

public void setFichierProperties(Properties fichierProperties) {
this.fichierProperties = fichierProperties;
}      

	
	public String getTribut() {
		return tribut;
	}
	public void setTribut(String tribut) {
		
		this.tribut = tribut;
	}
	
	public int getSlotDeVillageDuCompte() {
		return SlotDeVillageDuCompte;
	}
	public void setSlotDeVillageDuCompte(int slotDeVillageDuCompte) {
		SlotDeVillageDuCompte = slotDeVillageDuCompte;
	}
	
	private WebDriver driver;
	
	public String getServer() {
		return server;
	}
	public String getUserName() {
		return userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public  WebDriver getDriver() {
		return driver;
	}
	public void setServer(String server) {
		this.server = server;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public  void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	public Compte(WebDriver driver) {
		super();
		// new Compte();
		// System.setProperty("webdriver.chrome.driver", "C:\\Selenium2.45\\chrome\\chromedriver.exe");
		// driver = new ChromeDriver();
		this.driver = driver;
	
		
	}

	
}
