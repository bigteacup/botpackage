package botpackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Village {





	public String getNom() {
		return nom;
	}

	public String getUrl() {
		return url;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getBois() {
		return bois;
	}

	public int getArgile() {
		return argile;
	}

	public int getFer() {
		return fer;
	}

	public int getCereales() {
		return cereales;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setX(int x) {

		this.x = x/* .substring(1) */;
	}

	public void setY(int y) {
		this.y = y;
		// this.y = y.substring(0,y.length()-1);
		/* y= y.substring(0, y.length()); */

	}
	/*
	 * public void setBatiments(List<WebElement> batiments) { this.batiments =
	 * batiments; } public List<WebElement> getBatiments() { return batiments; }
	 */

	public void setBois(int bois) {
		this.bois = bois;
	}

	public void setArgile(int argile) {
		this.argile = argile;
	}

	public void setFer(int fer) {
		this.fer = fer;
	}

	public void setCereales(int cereales) {
		this.cereales = cereales;
	}

	public int getConstructionsEnCours() { 
		return constructionsEnCours;
	}

	public void setConstructionsEnCours(int constructionsEnCours) {
		this.constructionsEnCours = constructionsEnCours;
	}

	public double getLevelPlaceTournoi() {
		return levelPlaceTournoi;
	}

	public void setLevelPlaceTournoi(double levelPlaceTournoi) {
		this.levelPlaceTournoi = levelPlaceTournoi;
	}

	public boolean getChampsFinis() {
		return champsFinis;
	}

	public void setChampsFinis(boolean champsFinis) {
		this.champsFinis = champsFinis;
	}

	public int getMaxStockDepot() {
		return maxStockDepot;
	}

	public void setMaxStockDepot(int maxStockDepot) {
		this.maxStockDepot = maxStockDepot;
	}

	public int getMaxStockSilo() {
		return maxStockSilo;
	}

	public void setMaxStockSilo(int maxStockSilo) {
		this.maxStockSilo = maxStockSilo;
	}

	public int getManqueDeBois() {
		return manqueDeBois;
	}

	public void setManqueDeBois(int manqueDeBois) {
		this.manqueDeBois = manqueDeBois;
	}

	public int getManqueDeArgile() {
		return manqueDeArgile;
	}

	public void setManqueDeArgile(int manqueDeArgile) {
		this.manqueDeArgile = manqueDeArgile;
	}

	public int getManqueDeFer() {
		return manqueDeFer;
	}

	public void setManqueDeFer(int manqueDeFer) {
		this.manqueDeFer = manqueDeFer;
	}

	public int getManqueDeCereales() {
		return manqueDeCereales;
	}

	public void setManqueDeCereales(int manqueDeCereales) {
		this.manqueDeCereales = manqueDeCereales;
	}

	public void setBesoinDeFete(int besoinDeFete) {
		this.besoinDeFete = besoinDeFete;
	}

	public int getBesoinDeFete() {
		return besoinDeFete;
	}

	public void setVillagePillage(boolean villagePillage) {
		this.villagePillage = villagePillage;
	}

	public boolean getVillagePillage() {
		return villagePillage;
	}

	public void setVillageCapitale(boolean villageCapitale) {
		this.villageCapitale = villageCapitale;
	}

	public boolean getVillageCapitale() {
		return villageCapitale;
	}

	public void setBesoinDeNpc(boolean besoinDeNpc) {
		this.besoinDeNpc = besoinDeNpc;
	}

	public boolean getBesoinDeNpc() {
		return besoinDeNpc;
	}

	// public void NombreDeMarchands (){}
	public void setBatiments(List<Batiment> batiments) {
		this.batiments = batiments;
	}

	public List<Batiment> getBatiments() {
		return batiments;
	}

	public void setCropDeath(boolean cropDeath) {
		this.cropDeath = cropDeath;
	}

	public boolean getCropDeath() {
		return cropDeath;
	}

	public boolean getBesoinDeConstruction() {
		return besoinDeConstruction;
	}

	public void setBesoinDeConstruction(boolean besoinDeConstruction) {
		this.besoinDeConstruction = besoinDeConstruction;
	}

	public List<Batiment> getTemplateDuVillage() {
		return batimentsDuTemplateDuVillage;
	}

	public void setTemplateDuVillage(List<Batiment> template) {
		this.batimentsDuTemplateDuVillage = template;
	}

	public boolean getBesoinMarche() {
		return besoinMarche;
	}

	public void setBesoinMarche(boolean besoinMarche) {
		this.besoinMarche = besoinMarche;
	}

	public List<Batiment> getBatimentsDuTemplateDuVillage() {
		return batimentsDuTemplateDuVillage;
	}

	public void setBatimentsDuTemplateDuVillage(List<Batiment> batimentsDuTemplateDuVillage) {
		this.batimentsDuTemplateDuVillage = batimentsDuTemplateDuVillage;
	}

	public int getChampMin() {
		return champMin;
	}

	public void setChampMin(Travian t, Village village,int champMin) {
		this.champMin = champMin;
		//if (champMin <= 10 ){

		List<Batiment> tem = template.etablirTemplatePourUnVillage(village, champMin);
		t.ecrireDansConsole("Template choisi : "+village.getTemplate().getNomDuTemplate(), true);

		setTemplateDuVillage(tem);
		// }
	}

	public int getNombreDeMarchands() {
		return NombreDeMarchands;
	}

	public void setNombreDeMarchands(int nombreDeMarchands) {
		NombreDeMarchands = nombreDeMarchands;
	}

	public int getNombreDeMarchandsMax() {
		return NombreDeMarchandsMax;
	}

	public void setNombreDeMarchandsMax(int nombreDeMarchandsMax) {
		NombreDeMarchandsMax = nombreDeMarchandsMax;
	}

	public int getPhalanges() {
		return phalanges;
	}

	public void setPhalanges(int phalanges) {
		this.phalanges = phalanges;
	}

	public int getEpees() {
		return epees;
	}

	public void setEpees(int epees) {
		this.epees = epees;
	}

	public int getSpy() {
		return spy;
	}

	public void setSpy(int spy) {
		this.spy = spy;
	}

	public int getToutatis() {
		return toutatis;
	}

	public void setToutatis(int toutatis) {
		this.toutatis = toutatis;
	}

	public int getHeduins() {
		return heduins;
	}

	public void setHeduins(int heduins) {
		this.heduins = heduins;
	}

	public int getDruides() {
		return druides;
	}

	public void setDruides(int druides) {
		this.druides = druides;
	}

	public int getColons() {
		return colons;
	}

	public void setColons(int colons) {
		this.colons = colons;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	public boolean getExclureVillage() {
		return exclureVillage;
	}

	public void setExclureVillage(boolean exclureVillage) {
		this.exclureVillage = exclureVillage;
	}



	public int getVillageSlot() {
		return villageSlot;
	}

	public void setVillageSlot(int villageSlot) {
		this.villageSlot = villageSlot;
	}


	public ArrayList<Ordre> getListeCoordoneesPourColoniser() {
		return listeVillageCoordoneesPourColoniser;
	}

	public void setListeCoordoneesPourColoniser(ArrayList<Ordre> listeCoordoneesPourColoniser) {
		this.listeVillageCoordoneesPourColoniser = listeCoordoneesPourColoniser;
	}
	public List<Batiment> getListeDeBatimentsEnCoursDeConstruction() {
		return listeDeBatimentsEnCoursDeConstruction;
	}

	public void setListeDeBatimentsEnCoursDeConstruction(List<Batiment> listeDeBatimentsEnCoursDeConstruction) {
		this.listeDeBatimentsEnCoursDeConstruction = listeDeBatimentsEnCoursDeConstruction;
	}
	public int getTypeBatimentsEnConstruction() {
		return typeBatimentsEnConstruction;
	}

	public void setTypeBatimentsEnConstruction(int typeBatimentsEnConstruction) {
		this.typeBatimentsEnConstruction = typeBatimentsEnConstruction;
	}

	public int getTypeChampsEnConstruction() {
		return typeChampsEnConstruction;
	}

	public void setTypeChampsEnConstruction(int typeChampsEnConstruction) {
		this.typeChampsEnConstruction = typeChampsEnConstruction;
	}


	// TODO maxstock de base a corriger
	public int[] memoireMarcheDeLaRotation = { 0, 0, 0, 0 };
	public ArrayList<Ordre> listeOrdresMarcheDeLaRotation = new ArrayList<Ordre>();
	public ArrayList<Ordre> listeVillageCoordoneesPourColoniser = new ArrayList<Ordre>();



	private int manqueDeBois;
	private int manqueDeArgile;
	private int manqueDeFer;
	private int manqueDeCereales;
	private int maxStockDepot = 800;
	private int maxStockSilo = 800;
	private String nom;
	private String url;
	private String id;
	private int x;
	private int y;
	// private List<WebElement> batiments;
	private List<Batiment> batiments = new ArrayList<Batiment>();
	private int bois;
	private int argile;
	private int fer;
	private int cereales;
	public int villageSlot = 0;




	private int constructionsEnCours;

	public boolean exclureVillage= false;

	private double levelPlaceTournoi;
	private boolean champsFinis;
	private int besoinDeFete;
	private boolean villagePillage;
	private boolean villageCapitale;
	private boolean besoinDeNpc;
	private boolean besoinMarche;
	private int NombreDeMarchands;
	private int NombreDeMarchandsMax;
	public int QuantiteMaxTransporteeParMarchands;
	private int phalanges;
	private int epees;
	private int spy;
	private int toutatis;
	private int heduins;
	private int druides;
	private int colons;
	private boolean cropDeath;
	private boolean enNegatif;
	private boolean debordement;

	public boolean listeBatimentsVideDejaVerifiee = false; 
	public boolean routeDeCommerceDejaListeesAvecSucce = false;



	private boolean besoinDeConstruction;
	private List<Batiment> batimentsDuTemplateDuVillage = new ArrayList<Batiment>();
	private List<Batiment> listeDeBatimentsEnCoursDeConstruction = new ArrayList<Batiment>();
	public int typeBatimentsEnConstruction = 0;
	public int typeChampsEnConstruction = 0;



	private int champMin;
	private int champMax;
	public ArrayList<Integer> listeLevelsChampsBois = new ArrayList<Integer>();
	public ArrayList<Integer> listeLevelsChampsArgile = new ArrayList<Integer>();
	public ArrayList<Integer> listeLevelsChampsFer = new ArrayList<Integer>();
	public ArrayList<Integer> listeLevelsChampsCereales = new ArrayList<Integer>();

	//regime
	public boolean regimeGeneral = true;
	public int regimeMarcheBoisMax = 80;
	public int regimeMarcheArgileMax = 80;
	public int regimeMarcheFerMax = 80;
	public int regimeMarcheCerealesMax = 80;
	public int regimeMarcheBoisMin = 20;
	public int regimeMarcheArgileMin = 20;
	public int regimeMarcheFerMin = 20;
	public int regimeMarcheCerealesMin = 20;

	public boolean regimeDecalageCereales = true;
	public boolean regimePillage = true;
	public boolean regimeFete= true;
	public boolean regimeConstruction = true;
	public boolean regimeMonterChamps = true;
	public boolean regimeNPC = true;
	public boolean regimeAcheterAuMarché = true;


	//fin regime

    public static String xpathVillage1 = "" ;
    public static String xpathVillage2 = "" ;
    public static String xpathVillage3 = "" ;
    public static String xpathVillage4 = "" ;
    public static String xpathVillage5 = "" ;
    public static String xpathVillage6 = "" ;
    public static String xpathVillage7 = "" ;
    public static String xpathVillage8 = "" ;
    public static String xpathVillage9 = "" ;
    public static String xpathVillage10 = "" ;
    public static String xpathVillage11 = "" ;
    public static String xpathVillage12 = "" ;
    public static String xpathVillage13 = "" ;

    

	public Date marchéLastDate;
	public int marchédureeDuDernierAchat=0;
	public Date heureDeGuet;
	public List<AttaqueEntrante> attaquesSubies = new ArrayList<AttaqueEntrante>();
	public boolean bloquerConstructionBatiment = false;
	public int slotBatimentsLibres = 22;
	public ArrayList<RouteDeCommerce> listeRouteDeCommerce = new ArrayList<RouteDeCommerce>();
	public ArrayList<RouteDeCommerce> listeRouteDeCommerceACreer = new ArrayList<RouteDeCommerce>();

	public boolean isRouteDeCommerceDejaListeesAvecSucce() {
		return routeDeCommerceDejaListeesAvecSucce;
	}

	public void setRouteDeCommerceDejaListeesAvecSucce(boolean routeDeCommerceDejaListeesAvecSucce) {
		this.routeDeCommerceDejaListeesAvecSucce = routeDeCommerceDejaListeesAvecSucce;
	}


	public ArrayList<RouteDeCommerce> getListeRouteDeCommerceACreer() {
		return listeRouteDeCommerceACreer;
	}

	public void setListeRouteDeCommerceACreer(ArrayList<RouteDeCommerce> listeRouteDeCommerceACreer) {
		this.listeRouteDeCommerceACreer = listeRouteDeCommerceACreer;
	}

	public ArrayList<RouteDeCommerce> getListeRouteDeCommerce() {
		return listeRouteDeCommerce;
	}

	public void setListeRouteDeCommerce(ArrayList<RouteDeCommerce> listeRouteDeCommerce) {
		this.listeRouteDeCommerce = listeRouteDeCommerce;
	}

	public int getSlotBatimentsLibres() {
		return slotBatimentsLibres;
	}

	public void setSlotBatimentsLibres(int slotBatimentsLibres) {
		this.slotBatimentsLibres = slotBatimentsLibres;
	}
	public boolean getListeBatimentsVideDejaVerifiee() {
		return listeBatimentsVideDejaVerifiee;
	}

	public void setListeBatimentsVideDejaVerifiee(boolean listeBatimentsVideDejaVerifiee) {
		this.listeBatimentsVideDejaVerifiee = listeBatimentsVideDejaVerifiee;
	}

	//Liste de Templates du village
	public ArrayList<TemplatesDeVillages> listeDeTemplates = new ArrayList<TemplatesDeVillages>();

	//template direct a voir si on garde
	public TemplatesDeVillages template = new TemplatesDeVillages();





	public Village() {
		listeDeTemplates.add(template);

		TemplatesDeVillages templateParDefault1 = new TemplatesDeVillages();
		TemplatesDeVillages templateParDefault2 = new TemplatesDeVillages();
		TemplatesDeVillages templateParDefault3 = new TemplatesDeVillages();
		TemplatesDeVillages templateParDefault4 = new TemplatesDeVillages();

		templateParDefault1.setListeDeBatiments(templateParDefault1.listeDeBatimentsDuTemplateParDefault1);
		templateParDefault1.setNomDuTemplate("listeDeBatimentsDuTemplateParDefault1");
		templateParDefault1.setOperateur1("<=");
		templateParDefault1.setChampMin1(4);
		templateParDefault1.setOperateur2("");
		templateParDefault1.setChampMin2(0);


		templateParDefault2.setListeDeBatiments(templateParDefault2.listeDeBatimentsDuTemplateParDefault2);
		templateParDefault2.setNomDuTemplate("listeDeBatimentsDuTemplateParDefault2");
		templateParDefault2.setOperateur1("<=");
		templateParDefault2.setChampMin1(8);
		templateParDefault2.setOperateur2(">");
		templateParDefault2.setChampMin2(4);


		templateParDefault3.setListeDeBatiments(templateParDefault3.listeDeBatimentsDuTemplateParDefault3);
		templateParDefault3.setNomDuTemplate("listeDeBatimentsDuTemplateParDefault3");
		templateParDefault3.setOperateur1("<");
		templateParDefault3.setChampMin1(10);
		templateParDefault3.setOperateur2(">");
		templateParDefault3.setChampMin2(7);


		templateParDefault4.setListeDeBatiments(templateParDefault4.listeDeBatimentsDuTemplateParDefault4);
		templateParDefault4.setNomDuTemplate("listeDeBatimentsDuTemplateParDefault4");
		templateParDefault4.setOperateur1(">=");
		templateParDefault4.setChampMin1(10);
		templateParDefault4.setOperateur2("");
		templateParDefault4.setChampMin2(0);

		listeDeTemplates.add(templateParDefault1);
		listeDeTemplates.add(templateParDefault2);
		listeDeTemplates.add(templateParDefault3);
		listeDeTemplates.add(templateParDefault4);

		//	if (champMin <= 4 ){return listeDeBatimentsDuTemplateParDefault1;}
		//	if (champMin <= 8 && champMin >4){return listeDeBatimentsDuTemplateParDefault2;}
		//	if (champMin < 10 && champMin > 7){return listeDeBatimentsDuTemplateParDefault3;}
		//	if (champMin == 10){return listeDeBatimentsDuTemplateParDefault4;}
		//	if (champMin > 10){return listeDeBatimentsDuTemplateParDefault4;}
	}








	public Village(String nom, String url, int x, int y, ArrayList<Batiment> batiments, int bois, int argile, int fer,
			int cereales, int ConstructionsEnCours, double levelPlaceTournoi, boolean champsFinis, int maxStockDepot, int maxStockSilo, int constructionsEnCours) {
		super();
		this.nom = nom;
		this.url = url;
		this.x = x;
		this.y = y;
		this.batiments = batiments;
		this.bois = bois;
		this.argile = argile;
		this.fer = fer;
		this.cereales = cereales;
		this.constructionsEnCours = constructionsEnCours;
		this.levelPlaceTournoi = levelPlaceTournoi;
		this.champsFinis = champsFinis;
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public ArrayList<Integer> getListeLevelsChampsBois() {
		return listeLevelsChampsBois;
	}

	public void setListeLevelsChampsBois(ArrayList<Integer> listeLevelsChampsBois) {
		this.listeLevelsChampsBois = listeLevelsChampsBois;
	}

	public ArrayList<Integer> getListeLevelsChampsArgile() {
		return listeLevelsChampsArgile;
	}

	public void setListeLevelsChampsArgile(ArrayList<Integer> listeLevelsChampsArgile) {
		this.listeLevelsChampsArgile = listeLevelsChampsArgile;
	}

	public ArrayList<Integer> getListeLevelsChampsFer() {
		return listeLevelsChampsFer;
	}

	public void setListeLevelsChampsFer(ArrayList<Integer> listeLevelsChampsFer) {
		this.listeLevelsChampsFer = listeLevelsChampsFer;
	}

	public ArrayList<Integer> getListeLevelsChampsCereales() {
		return listeLevelsChampsCereales;
	}

	public void setListeLevelsChampsCereales(ArrayList<Integer> listeLevelsChampsCereales) {
		this.listeLevelsChampsCereales = listeLevelsChampsCereales;
	}

	public TemplatesDeVillages getTemplate() {
		return template;
	}

	public void setTemplate(TemplatesDeVillages template) {
		this.template = template;
	}

	public boolean getEnNegatif() {
		return enNegatif;
	}

	public void setEnNegatif(boolean enNegatif) {
		this.enNegatif = enNegatif;
	}

	public boolean getDebordement() {
		return debordement;
	}

	public void setDebordement(boolean debordement) {
		this.debordement = debordement;
	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public ArrayList<TemplatesDeVillages> getListeDeTemplates() {
		return listeDeTemplates;
	}

	public void setListeDeTemplates(ArrayList<TemplatesDeVillages> listeDeTemplates) {
		this.listeDeTemplates = listeDeTemplates;
	}

	public boolean getRegimePillage() {
		return regimePillage;
	}

	public void setRegimePillage(boolean regimePillage) {
		this.regimePillage = regimePillage;
	}

	public boolean getRegimeFete() {
		return regimeFete;
	}

	public void setRegimeFete(boolean regimeFete) {
		this.regimeFete = regimeFete;
	}

	public boolean getRegimeConstruction() {
		return regimeConstruction;
	}

	public void setRegimeConstruction(boolean regimeConstruction) {
		this.regimeConstruction = regimeConstruction;
	}

	public boolean getRegimeMonterChamps() {
		return regimeMonterChamps;
	}

	public void setRegimeMonterChamps(boolean regimeMonterChamps) {
		this.regimeMonterChamps = regimeMonterChamps;
	}

	public boolean getRegimeNPC() {
		return regimeNPC;
	}

	public void setRegimeNPC(boolean regimeNPC) {
		this.regimeNPC = regimeNPC;
	}

	public boolean getRegimeAcheterAuMarché() {
		return regimeAcheterAuMarché;
	}

	public void setRegimeAcheterAuMarché(boolean regimeAcheterAuMarché) {
		this.regimeAcheterAuMarché = regimeAcheterAuMarché;
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


	public int getMarchédureeDuDernierAchat() {
		return marchédureeDuDernierAchat;
	}

	public void setMarchédureeDuDernierAchat(int marchédureeDuDernierAchat) {
		this.marchédureeDuDernierAchat = marchédureeDuDernierAchat;
	}

	public Date getMarchéLastDate() {
		return marchéLastDate;
	}

	public void setMarchéLastDate(Date marchéLastDate) {
		this.marchéLastDate = marchéLastDate;
	}

	public boolean getRegimeGeneral() {
		return regimeGeneral;
	}

	public void setRegimeGeneral(boolean regimeGeneral) {
		this.regimeGeneral = regimeGeneral;
	}

	public int getRegimeMarcheBoisMax() {
		return regimeMarcheBoisMax;
	}

	public void setRegimeMarcheBoisMax(int regimeMarcheBoisMax) {
		this.regimeMarcheBoisMax = regimeMarcheBoisMax;
	}

	public int getRegimeMarcheArgileMax() {
		return regimeMarcheArgileMax;
	}

	public void setRegimeMarcheArgileMax(int regimeMarcheArgileMax) {
		this.regimeMarcheArgileMax = regimeMarcheArgileMax;
	}

	public int getRegimeMarcheFerMax() {
		return regimeMarcheFerMax;
	}

	public void setRegimeMarcheFerMax(int regimeMarcheFerMax) {
		this.regimeMarcheFerMax = regimeMarcheFerMax;
	}

	public int getRegimeMarcheCerealesMax() {
		return regimeMarcheCerealesMax;
	}

	public void setRegimeMarcheCerealesMax(int regimeMarcheCerealesMax) {
		this.regimeMarcheCerealesMax = regimeMarcheCerealesMax;
	}

	public int getRegimeMarcheBoisMin() {
		return regimeMarcheBoisMin;
	}

	public void setRegimeMarcheBoisMin(int regimeMarcheBoisMin) {
		this.regimeMarcheBoisMin = regimeMarcheBoisMin;
	}

	public int getRegimeMarcheArgileMin() {
		return regimeMarcheArgileMin;
	}

	public void setRegimeMarcheArgileMin(int regimeMarcheArgileMin) {
		this.regimeMarcheArgileMin = regimeMarcheArgileMin;
	}

	public int getQuantiteMaxTransporteeParMarchands() {
		return QuantiteMaxTransporteeParMarchands;
	}

	public void setQuantiteMaxTransporteeParMarchands(int quantiteMaxTransporteeParMarchands) {
		QuantiteMaxTransporteeParMarchands = quantiteMaxTransporteeParMarchands;
	}

	public int getRegimeMarcheFerMin() {
		return regimeMarcheFerMin;
	}

	public void setRegimeMarcheFerMin(int regimeMarcheFerMin) {
		this.regimeMarcheFerMin = regimeMarcheFerMin;
	}

	public int getRegimeMarcheCerealesMin() {
		return regimeMarcheCerealesMin;
	}

	public void setRegimeMarcheCerealesMin(int regimeMarcheCerealesMin) {
		this.regimeMarcheCerealesMin = regimeMarcheCerealesMin;
	}

	void updateRessources(Travian t) {

		Village village = t.villageEnCours();

		String bois;
		int stockBois;
		String argile ;
		int stockArgile ;
		String fer;
		int stockFer;
		String cereales;
		int stockCereales;

		try {
			village = t.villageEnCours();
			bois = t.getCompte().getDriver().findElement(By.xpath("//*[@id=\"l1\"]")).getText().replaceAll("[\\u202D\\u202C.]", "").replace(".", "").replace(" ", "");
			stockBois = Integer.parseInt(bois);
			argile = t.getCompte().getDriver().findElement(By.xpath("//*[@id=\"l2\"]")).getText().replaceAll("[\\u202D\\u202C.]", "").replace(".", "").replace(" ", "");
			stockArgile = Integer.parseInt(argile);
			fer = t.getCompte().getDriver().findElement(By.xpath("//*[@id=\"l3\"]")).getText().replaceAll("[\\u202D\\u202C.]", "").replace(".", "").replace(" ", "");
			stockFer = Integer.parseInt(fer);
			cereales = t.getCompte().getDriver().findElement(By.xpath("//*[@id=\"l4\"]")).getText().replaceAll("[\\u202D\\u202C.]", "").replace(".", "").replace(" ", "");
			stockCereales = Integer.parseInt(cereales);

		}catch(Exception e) {
			village = t.villageEnCours();
			//Methode ancienne, gardée pour voir sil change regulierement ce code pour deranger les bots
			bois = t.getCompte().getDriver().findElement(By.xpath("//*[@id=\"l1\"]")).getText().replace(" ", "");
			stockBois = Integer.parseInt(bois);
			argile = t.getCompte().getDriver().findElement(By.xpath("//*[@id=\"l2\"]")).getText().replace(" ", "");
			stockArgile = Integer.parseInt(argile);
			fer = t.getCompte().getDriver().findElement(By.xpath("//*[@id=\"l3\"]")).getText().replace(" ", "");
			stockFer = Integer.parseInt(fer);
			cereales = t.getCompte().getDriver().findElement(By.xpath("//*[@id=\"l4\"]")).getText().replace(" ", "");
			stockCereales = Integer.parseInt(cereales);
		}

		village.setBois(stockBois);
		village.setArgile(stockArgile);
		village.setFer(stockFer);
		village.setCereales(stockCereales);  





		String maxDepot;
		int maxStockDepot;
		try {
			village = t.villageEnCours();
			maxDepot = t.getCompte().getDriver().findElement(By.xpath("//*[@id=\"stockBarWarehouse\"]")).getText().replaceAll("[\\u202D\\u202C.]", ""); // code correspondant au whitespace causé par left to right \\u202D \\u202C
			maxDepot = maxDepot.replace(" ", "");
			maxDepot = maxDepot.replaceAll("\\W", "");
			maxDepot = maxDepot.trim();
			maxStockDepot = Integer.parseInt(maxDepot);
		}catch(Exception e) {
			village = t.villageEnCours();
			//Methode ancienne, gardée pour voir sil change regulierement ce code pour deranger les bots
			maxDepot = t.getCompte().getDriver().findElement(By.xpath("//*[@id=\"stockBarWarehouse\"]")).getText().replace(" ", "");
			maxStockDepot = Integer.parseInt(maxDepot);
		}


		String maxSilo;
		int maxStockSilo;
		try {
			village = t.villageEnCours();
			maxSilo = t.getCompte().getDriver().findElement(By.xpath("//*[@id=\"stockBarGranary\"]")).getText().replaceAll("[\\u202D\\u202C.]", "");
			maxSilo = maxSilo.replace(" ", "");
			maxSilo = maxSilo.replaceAll("\\W", "");
			maxSilo = maxSilo.trim();
			maxStockSilo = Integer.parseInt(maxSilo);
		}catch (Exception e) {
			village = t.villageEnCours();
			//Methode ancienne, gardée pour voir sil change regulierement ce code pour deranger les bots
			maxSilo = t.getCompte().getDriver().findElement(By.xpath("//*[@id=\"stockBarGranary\"]")).getText().replace(" ", "");
			maxStockSilo = Integer.parseInt(maxSilo);
		}


		village.setMaxStockDepot(maxStockDepot);
		village.setMaxStockSilo(maxStockSilo);

		t.ecrireDansConsole("Update Ressources de : " + village.getNom(), true);

	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void voirListeDeConstruction(Travian t) {
		Village village = t.villageEnCours();


		//////////////////////////////////////////////////////
		// se replacer sur la bonne page si un module est reste ailleur
		String urlTest = null;
		try {
			urlTest = t.getCompte().getDriver().getCurrentUrl().split(".php")[0].split(".fr/")[1];
		} catch (Exception e) {
			t.ecrireDansConsole("echec urlTest1 ", true);
		}

		if (!urlTest.contains("dorf1") && !urlTest.contains("dorf2")) {
			t.getCompte().getDriver().get(t.getCompte().getServer() + "dorf1.php");
			t.randomsleep.court();
		}
		//////////////////////////////////////////////////////


		List<WebElement> test = null;
		int constructionEnCours = 0;

		try {
			test = t.getCompte().getDriver().findElements(By.xpath("//*[@id=\"content\"]/div[2]/div[10]/ul/li"));

			if (test.size() < 1) {
				village.setConstructionsEnCours(constructionEnCours);
				t.ecrireDansConsole("Pas de construction en cours ", true);
			}

			if (test.size() >= 1) { // (test != null)
				t.ecrireDansConsole(test.size() + " Constructions deja en cours", true);
				constructionEnCours = test.size();
				village.setConstructionsEnCours(constructionEnCours);
				try {
					voirListeDeConstructionAnalyse(t, test);
				}catch (Exception e2) {
					t.ecrireDansConsole("Echec analyse precise ! ", true);
				}
			}
		} catch (Exception e) {
			village.setConstructionsEnCours(constructionEnCours);
		}
	}








	public void voirListeDeConstructionAnalyse(Travian t, List<WebElement> listeTest) {

		//////////////////////////////////////////////////////
		// se replacer sur la bonne page si un module est reste ailleur
		String urlTest = null;
		try {
			urlTest = t.getCompte().getDriver().getCurrentUrl().split(".php")[0].split(".fr/")[1];
		} catch (Exception e) {
			t.ecrireDansConsole("echec urlTest1 ", true);
		}

		if (!urlTest.contains("dorf1") && !urlTest.contains("dorf2")) {
			t.getCompte().getDriver().get(t.getCompte().getServer() + "dorf1.php");
			t.randomsleep.court();
		}
		//////////////////////////////////////////////////////

		Village village = t.villageEnCours();
		village.getListeDeBatimentsEnCoursDeConstruction().clear();
		try {

			for (WebElement element : listeTest) {
				String nomBat =	element.findElement(By.xpath("./*[@class=\"name\"]")).getText().split("Niveau")[0].trim(); //Batiment.determinerType(nomBat)
				village.getListeDeBatimentsEnCoursDeConstruction().add(new Batiment(nomBat));

			}

			analyseTypeDesConstructionsEnCours(t, village);


		} catch (Exception e) {
			t.ecrireDansConsole("echec analyse precise : findelement ", true);
		}
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void analyseTypeDesConstructionsEnCours(Travian t, Village village) {
		int typeChamps = 0;
		int typeBatiment = 0;
		for (Batiment batTest : village.getListeDeBatimentsEnCoursDeConstruction()) {


			if ( 	   batTest.getNomBatiment().contains(TemplatesDeVillages.ChampsBucheron) 
					|| batTest.getNomBatiment().contains(TemplatesDeVillages.ChampsCarriereDArgile) 
					|| batTest.getNomBatiment().contains(TemplatesDeVillages.ChampsMineDeFer) 
					|| batTest.getNomBatiment().contains(TemplatesDeVillages.ChampsFerme)) {
				typeChamps++;

			}else {
				typeBatiment++;

			}
		}
		village.setTypeBatimentsEnConstruction(typeBatiment) ;
		village.setTypeChampsEnConstruction(typeChamps);

		t.ecrireDansConsole("Batiments en cours : "+typeBatiment, true);
		t.ecrireDansConsole("Champs en cours : "+typeChamps, true);
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


	public void voirTroupesDuVillage(Travian t) {
		voirTroupesOffDuVillage(t);
		voirTroupesCivilesDuVillage(t);
	}




	public void voirTroupesOffDuVillage(Travian t) {

		//////////////////////////////////////////////////////
		// se replacer sur la bonne page si un module est resté ailleurs
		String urlTest = null;
		try {
			urlTest = t.getCompte().getDriver().getCurrentUrl().split(".php")[0].split(".fr/")[1];
		} catch (Exception e) {
			t.ecrireDansConsole("echec urlTest1 ", true);
		}

		if (!urlTest.contains("dorf1")) {
			t.getCompte().getDriver().get(t.getCompte().getServer() + "dorf1.php");
			t.randomsleep.court();
		}


		// compte.getDriver().get("http://ts4.travian.fr/dorf1.php?newdid=6681&");
		Village village = t.villageEnCours();
		boolean troupesAQuai = false;

		try {
			List<WebElement> troupesDuVillage = t.getCompte().getDriver().findElements(By.xpath("//*[@id=\"troops\"]/tbody/tr"));
			for (WebElement typeTroupe : troupesDuVillage) {
				boolean troupesPresentes = false; 
				String tableauTroupes[] = {"Imperians", "Caesaris", "éclairs de Toutatis", "Combattants à l'épée",  "Légionnaire", "Légionnaires", "Imperatoris", "Gourdin", "Hache", "Teuton" };

				for (int i = 0; i < tableauTroupes.length; i++){
					if ( typeTroupe.findElement(By.className("un")).getText().toLowerCase().contains(tableauTroupes[i].toLowerCase())){

						troupesPresentes = true;
						int nombreTroupesPresentes = Integer.parseInt(typeTroupe.findElement(By.className("num")).getText());
						t.ecrireDansConsole("Type : "+tableauTroupes[i] +"--> "+ nombreTroupesPresentes, true );

						if (troupesPresentes == true ) {
							village.setVillagePillage(true);
						}
						if (troupesPresentes && nombreTroupesPresentes >= 8) {
							troupesAQuai = true;
						}
					}
				}



			} // fin for
		} catch (Exception e) {
		} // fin Try
		if (troupesAQuai) {

			t.pillage();

		} else {
			t.ecrireDansConsole("Pas de Troupes -> pas de pillages", true);
		}

	}// fin
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void voirTroupesCivilesDuVillage(Travian t) {

		//////////////////////////////////////////////////////
		// se replacer sur la bonne page si un module est resté ailleurs
		String urlTest = null;
		try {
			urlTest = t.getCompte().getDriver().getCurrentUrl().split(".php")[0].split(".fr/")[1];
		} catch (Exception e) {
			t.ecrireDansConsole("echec urlTest1 ", true);
		}

		if (!urlTest.contains("dorf1")) {
			t.getCompte().getDriver().get(t.getCompte().getServer() + "dorf1.php");
			t.randomsleep.court();
		}


		Village village = t.villageEnCours();
		boolean troupesAQuai = false;

		try {
			List<WebElement> troupesDuVillage = t.getCompte().getDriver().findElements(By.xpath("//*[@id=\"troops\"]/tbody/tr"));
			for (WebElement typeTroupe : troupesDuVillage) {
				boolean troupesPresentes = false; 
				String tableauTroupes[] = { "Colon"   };

				for (int i = 0; i < tableauTroupes.length; i++){
					if ( typeTroupe.findElement(By.className("un")).getText().contains(tableauTroupes[i])){

						if(typeTroupe.findElement(By.className("un")).getText().toLowerCase().contains("colon")) {
							village.setColons(Integer.parseInt(typeTroupe.findElement(By.className("num")).getText()));

						}



						troupesPresentes = true;
						int nombreTroupesPresentes = Integer.parseInt(typeTroupe.findElement(By.className("num")).getText());
						t.ecrireDansConsole("Type : "+tableauTroupes[i] +"--> "+ nombreTroupesPresentes, true );

					}
				}



			} // fin for
		} catch (Exception e) {
		} // fin Try


	}// fin

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void commanderTroupes(Travian t, Village v) {
		int nombreACommander;
		String typeDUniteeACommander;
		allerDansUnBatiment(t, "caserne");
		allerDansUnBatiment(t, "ecurie");



	}


	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void commanderColon(Travian t, Village v) {
		if(true) {
			allerDansUnBatiment(t, TemplatesDeVillages.residence );
			changementOnglet(t, v, 0, "Gestion");
		}
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////




	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////





	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////






	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	void chargerChamps(Travian t) {

		Village village = t.villageEnCours(); // pas utilisee ici

		//////////////////////////////////////////////////////
		// se replacer sur la bonne page si un module est reste ailleur
		String urlTest = null;
		try {
			urlTest = t.getCompte().getDriver().getCurrentUrl().split(".php")[0].split(".fr/")[1];
		} catch (Exception e) {
			t.ecrireDansConsole("echec urlTest1 ", true);
		}

		if (!urlTest.contains("dorf1")) {
			t.getCompte().getDriver().get(t.getCompte().getServer() + "dorf1.php");
			t.randomsleep.court();
		}
		//////////////////////////////////////////////////////

		List<WebElement> listeWebelementChamps = t.getCompte().getDriver().findElements(By.xpath("//*[@id=\"rx\"]/area"));
		ArrayList<Integer> listeLevelsChamps = new ArrayList<Integer>();
		ArrayList<Integer> listeLevelsChampsBois = new ArrayList<Integer>();
		ArrayList<Integer> listeLevelsChampsArgile = new ArrayList<Integer>();
		ArrayList<Integer> listeLevelsChampsFer = new ArrayList<Integer>();
		ArrayList<Integer> listeLevelsChampsCereales = new ArrayList<Integer>();
		ArrayList<String> listeNomsChamps = new ArrayList<String>();

		// On verifie que lon est sur la page des champs de ressources
		if (t.getCompte().getDriver().getCurrentUrl().contains("dorf1.php")) {

			// On liste les elements necesaires a la comparaison des champs
			int i = 0;
			while (i < 18) {

				String typeChamp = listeWebelementChamps.get(i).getAttribute("alt").split("Niveau ")[0].trim();
				listeNomsChamps.add(typeChamp);
				int levelChamp = Integer.parseInt(listeWebelementChamps.get(i).getAttribute("alt").split("Niveau ")[1]);
				listeLevelsChamps.add(levelChamp);


				if(typeChamp.toLowerCase().contains("cheron")) {
					listeLevelsChampsBois.add(levelChamp);
				}				
				if(typeChamp.toLowerCase().contains("argile")) {
					listeLevelsChampsArgile.add(levelChamp);

				}
				if(typeChamp.toLowerCase().contains("fer") && !typeChamp.toLowerCase().contains("ferme")) {
					listeLevelsChampsFer.add(levelChamp);
				}
				if(typeChamp.toLowerCase().contains("ferme") || typeChamp.contains("cereales")) {
					listeLevelsChampsCereales.add(levelChamp);

				}

				i++;
				if (i == 18) {
					t.ecrireDansConsole("Liste des " + i + " champs : " + listeLevelsChamps + "", true);
				}
			}

			// on envoi les liste au village
			village.setListeLevelsChampsBois(listeLevelsChampsBois);
			village.setListeLevelsChampsArgile(listeLevelsChampsArgile);
			village.setListeLevelsChampsFer(listeLevelsChampsFer);
			village.setListeLevelsChampsCereales(listeLevelsChampsCereales);

			// On determine le niveau des champs le plus petit
			t.randomsleep.court();
			champMin = Collections.min(listeLevelsChamps);
			champMax = Collections.max(listeLevelsChamps);
			village.setChampMin(t, village , champMin);
			if (champMin >= 10 ) {
				village.setChampsFinis(true);
			} else {
				village.setChampsFinis(false);
			}
			if (champMax > 10) {
				village.setVillageCapitale(true);
			} else {
				village.setVillageCapitale(false);
			}
			t.ecrireDansConsole("Min val: " + champMin +" Max val: "+champMax, true);
		}
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void chargerBatiments(Travian t) {
		//ancienne version
		int slotTemp = 0;
		t.ecrireDansConsole("Debut chargerBatiment", true);

		if (!t.getCompte().getDriver().getCurrentUrl().contains("dorf2.php")) {
			t.randomsleep.court();
			t.getCompte().getDriver().get(t.getCompte().getServer() + "dorf2.php");
			t.randomsleep.court();
		}

		Village village = t.villageEnCours();
		//	village.setSlotBatimentsLibres(22);// remise à zero
		List<WebElement> listeDesBatiments = t.getCompte().getDriver().findElements(By.xpath("//*[@id=\"clickareas\"]/area"));
		// on cree une liste temporaire pour l envoyer au village une fois la liste complete.
		List<Batiment> listeDesBatimentsVillage = new ArrayList<Batiment>();

		for (WebElement webBatiment : listeDesBatiments) {
			// on intialise les variables
			String nomBatiment = null;
			int levelBatiment = 0;
			String slotBatiment = null;
			boolean trouver = false;

			// on les rempli
			try {
				nomBatiment = webBatiment.getAttribute("alt").split(" <span")[0].replace("&#39;", "'"); //&#39;

				levelBatiment = Integer.parseInt(webBatiment.getAttribute("alt").split("<span class=\"level\">Niveau ")[1].split("</span>")[0]);
				// reperer conctructions en cours
				if (webBatiment.getAttribute("alt").contains("Amélioration en cours")) {
					int enCoursVersLevel = Integer.parseInt(webBatiment.getAttribute("alt").split("Amélioration en cours vers le niveau ")[1].split("</span>")[0]);
					levelBatiment = enCoursVersLevel;

				}
				slotBatiment = webBatiment.getAttribute("href").split("id=")[1];
				// si un slot est vide : on le nomme
			} catch (Exception e) {

				slotTemp++; 
				nomBatiment = webBatiment.getAttribute("alt");
				levelBatiment = 0;
				slotBatiment = webBatiment.getAttribute("href").split("id=")[1];
			}

			// pour chaque batiment du village on regarde si le batiment y est.
			// Sil y est on ne fait rien et on passe au suivant
			try {

				for (Batiment batiment : village.getBatiments()) {

					if (batiment.getNomBatiment().equals(nomBatiment) && batiment.getSlotBatiment().equals(slotBatiment)) {
						trouver = true;
						batiment.setLevelBatiment(levelBatiment);
						break;

					}
				}

			} catch (Exception e) {
				trouver = false;
			}
			// si le batiment ny est pas on le met dans la liste temporaire
			if (trouver == false) {
				Batiment newBatiment = new Batiment();
				newBatiment.setNomBatiment(nomBatiment);
				newBatiment.setSlotBatiment(slotBatiment);
				newBatiment.setLevelBatiment(levelBatiment);
				listeDesBatimentsVillage.add(newBatiment);

				// on envois la liste terminee au village concerne
				village.setBatiments(listeDesBatimentsVillage);

			}
		}
		village.setSlotBatimentsLibres( slotTemp);
		if(village.getBatiments().isEmpty()) {
			village.setListeBatimentsVideDejaVerifiee(true);
		}else {
			village.setListeBatimentsVideDejaVerifiee(false);
		}
		t.ecrireDansConsole("Slot libre : " + slotTemp, true);
		t.ecrireDansConsole("Fin chargerBatiment", true);
		
		 chargerBatiments2(t);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void chargerBatiments2(Travian t) {
		int slotTemp = 0;
		List<WebElement> listeDesBatiments = null;
		List<Batiment> listeDesBatimentsVillage = null;
		Village village = null;
		int g = 18;
		
		t.ecrireDansConsole("Debut chargerBatiment2", true);
try {
		if (!t.getCompte().getDriver().getCurrentUrl().contains("dorf2.php")) {
			t.randomsleep.court();
			t.getCompte().getDriver().get(t.getCompte().getServer() + "dorf2.php");
			t.randomsleep.court();
		}

		village = t.villageEnCours();
		//	village.setSlotBatimentsLibres(22);// remise à zero
		listeDesBatiments = t.getCompte().getDriver().findElements(By.xpath("//*[@id=\"village_map\"]/div"));  //*[@id="village_map"]/div //*[@id="village_map"]/div[23]
		// on cree une liste temporaire pour l envoyer au village une fois la liste complete.
		listeDesBatimentsVillage = new ArrayList<Batiment>();
		
	//	for (WebElement webBatiment : listeDesBatiments) {

}catch(Exception e) {
	t.ecrireDansConsole("Echec chargerBatiment2 partie 1", true);
	}				
			
			
			while (g < 41) {
				// on intialise les variables
				String nomBatiment = null;
				int levelBatiment = 0;
				String slotBatiment = null;
				int boisPourNiveauSuivant = 0;
				int argilePourNiveauSuivant = 0;
				int ferPourNiveauSuivant = 0;
				int cerealePourNiveauSuivant = 0;
				boolean trouver = false;
				List<WebElement> donnees = null;
				String donneeComplete = null;
				
				try {
				donnees = listeDesBatiments.get(g).findElements(By.xpath("//*[@id=\"mainLayout\"]/body/div[3]/div/div/div[10]/div[2]")); // /div[1] //*[@id="mainLayout"]/body/div[3]/div/div/div[10]/div[2]/div
				donneeComplete =  donnees.get(0).getText().toString();
				}catch(Exception e) {
					donnees = listeDesBatiments.get(g).findElements(By.xpath("//*[@id=\"village_map\"]/div")); //*[@id="village_map"]/div; //*[@id="village_map"]/div
					donneeComplete =  donnees.get(0).getText().toString();
					t.ecrireDansConsole("Echec chargerBatiment2 While partie 1 g = " + g , true);
					}	
				
				
				Actions builder = new Actions(t.getCompte().getDriver());
				
				if(listeDesBatiments.get(g).getAttribute("class").contains("g0")) {
					 nomBatiment = "Site de construction";
					 levelBatiment = 0;
					 slotBatiment = String.valueOf(g+1);
					 slotTemp++; 
					
				}
				else {
			
			
			try {
				//builder.moveToElement(listeDesBatiments.get(g+18)); //g+1  	WebElement cible =  t.getCompte().getDriver().findElement(By.xpath("//area[@*[contains(., \"id="+ (g + 1) +"\")]]"));
				WebElement wb = t.getCompte().getDriver().findElement(By.xpath("//*[@id=\"village_map\"]/div[" + (g+1) + "]"));
				builder.moveToElement(wb); //g+1  	WebElement cible =  t.getCompte().getDriver().findElement(By.xpath("//area[@*[contains(., \"id="+ (g + 1) +"\")]]"));
				}catch (Exception e1){
					
				}

			builder.perform();
			
			t.randomsleep.tcourt(); 

				//Passage 1
			try {
				//reset de secu
				boisPourNiveauSuivant = 0;
				argilePourNiveauSuivant = 0;
				ferPourNiveauSuivant = 0;
				cerealePourNiveauSuivant = 0;
			
				try {
					nomBatiment = listeDesBatiments.get(g).findElement(By.xpath("//*[@id=\"mainLayout\"]/body/div[3]/div/div/div[10]/div[1]")).getText().split("Niveau")[0].toString().trim() ;//   /div[1]
				 levelBatiment = Integer.parseInt(listeDesBatiments.get(g+1).findElement(By.xpath("//*[@id=\"mainLayout\"]/body/div[3]/div/div/div[10]/div[1]")).getText().split("Niveau")[1].toString().trim());
				 slotBatiment = String.valueOf(g+1);
				}catch(Exception e1) {
		
					}
				
				
			
			try { // on chope les cout du niveau suivant si possible
				boisPourNiveauSuivant = Integer.parseInt(donneeComplete.split("\n")[0].trim());
				argilePourNiveauSuivant = Integer.parseInt(donneeComplete.split("\n")[1].trim());
				ferPourNiveauSuivant = Integer.parseInt(donneeComplete.split("\n")[2].trim());
				cerealePourNiveauSuivant = Integer.parseInt(donneeComplete.split("\n")[3].trim());
			}catch(Exception e2) {
				t.ecrireDansConsole("Echec chargerBatiment2 ParseInt", true);	
			}
			
			//	boisPourNiveauSuivant = Integer.parseInt(donneeComplete.split(":")[1].split("\n")[1].trim());
			//	argilePourNiveauSuivant = Integer.parseInt(donneeComplete.split(":")[1].split("\n")[2].trim());
			//	ferPourNiveauSuivant = Integer.parseInt(donneeComplete.split(":")[1].split("\n")[3].trim());
			//	cerealePourNiveauSuivant = Integer.parseInt(donneeComplete.split(":")[1].split("\n")[4].trim());
			
			
			}catch(Exception e) {
				//seconde tentative
		
		
				
			}
			
			

			}


			// pour chaque batiment du village on regarde si le batiment y est.
			// Sil y est on ne fait rien et on passe au suivant
			try {

				for (Batiment batiment : village.getBatiments()) {

					if (batiment.getNomBatiment().equals(nomBatiment) && batiment.getSlotBatiment().equals(slotBatiment)) {
						trouver = true;
						batiment.setBoisPourNiveauSuivant(boisPourNiveauSuivant);
						batiment.setArgilePourNiveauSuivant(argilePourNiveauSuivant);
						batiment.setFerPourNiveauSuivant(ferPourNiveauSuivant);
						batiment.setCerealePourNiveauSuivant(cerealePourNiveauSuivant);
						batiment.setLevelBatiment(levelBatiment);
						listeDesBatimentsVillage.add(batiment);
						break;

					}
				}

			} catch (Exception e) {
				trouver = false;
			}
			// si le batiment ny est pas on le met dans la liste temporaire
			if (trouver == false && nomBatiment.length() > 0) {
				Batiment newBatiment = new Batiment();
				newBatiment.setNomBatiment(nomBatiment);
				newBatiment.setSlotBatiment(slotBatiment);
				newBatiment.setLevelBatiment(levelBatiment);
				newBatiment.setBoisPourNiveauSuivant(boisPourNiveauSuivant);
				newBatiment.setArgilePourNiveauSuivant(argilePourNiveauSuivant);
				newBatiment.setFerPourNiveauSuivant(ferPourNiveauSuivant);
				newBatiment.setCerealePourNiveauSuivant(cerealePourNiveauSuivant);

				
				
				listeDesBatimentsVillage.add(newBatiment);


			}
			
			// on envois la liste terminee au village concerne
			village.setBatiments(listeDesBatimentsVillage);

			g++;
		//	trouver = false;
			builder.moveByOffset(0, 0);
			builder.perform();
			t.randomsleep.tcourt(); 
		}//fin while
			
			
			
			
			
		village.setSlotBatimentsLibres( slotTemp);
		if(village.getBatiments().isEmpty()) {
			village.setListeBatimentsVideDejaVerifiee(true);
		}else {
			village.setListeBatimentsVideDejaVerifiee(false);
		}
		
		
	//	}
		village.nettoyerListeDeBatiments(t);
		for(Batiment bat : village.getBatiments()) {
			t.ecrireDansConsole("-> " + bat.getNomBatiment() , true);
		}
		
		t.ecrireDansConsole("Slot libre : " + slotTemp, true);
		t.ecrireDansConsole("Fin chargerBatiment2", true);
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public int monterChamps(Travian t, int g) {
		try {
			t.ecrireDansConsole("Debut monterChamps", true);

			Village village = t.villageEnCours();
			int valchampMinBaf = champMin;
			List<WebElement> listeWebelementChamps = t.getCompte().getDriver().findElements(By.xpath("//*[@id=\"rx\"]/area"));
			List<WebElement> listeWebelementChampsBis = t.getCompte().getDriver().findElements(By.xpath("//*[@id=\"village_map\"]/div"));
			//*[@id="village_map"]/div
			int construEnCours = village.getConstructionsEnCours();

			if (construEnCours < t.limiteDeConstruction && village.getTypeChampsEnConstruction() < 2) {
				//try { // secu anti rechargement
				// Lancer construction champs
				// trouver lien du premier plus petit
				//int g = 0;
				boolean decalageToken = false;
				while (g < 18) {



					// on met a jour le token apres une eventuelle construction
					village.voirListeDeConstruction(t);
					construEnCours = village.getConstructionsEnCours();
					// on reverifie le token pour pas boucler plus que
					// necessaire


					if (construEnCours < t.limiteDeConstruction && village.getTypeChampsEnConstruction() < 2 ) { //|| t.getCompte().getTribut().equals("Romains") && token < 3
						// On recharge la liste apres un eventuel rechargement
						listeWebelementChamps = t.getCompte().getDriver().findElements(By.xpath("//*[@id=\"rx\"]/area"));
						listeWebelementChampsBis = t.getCompte().getDriver().findElements(By.xpath("//*[@id=\"village_map\"]/div"));
						int lien = Integer.parseInt(listeWebelementChamps.get(g).getAttribute("alt").split("Niveau ")[1]); // bug
						String type = listeWebelementChamps.get(g).getAttribute("alt").split("Niveau ")[0].trim();



						if (t.bot.decalageCereales == true) {
							if (regimeDecalageCereales == true) {
								int decalageCerealesLevelDebut = t.bot.decalageCerealesLevelDebut;
								int decalageCerealesLevelFin = t.bot.decalageCerealesLevelFin;
								//t.bot.decalageCereales == true

								//TODO Decalage faire un systeme plus clair et parametrable

								ArrayList<Integer> baf = new ArrayList<Integer>();
								baf.addAll(village.getListeLevelsChampsBois() ); // 
								baf.addAll(village.getListeLevelsChampsArgile() );
								baf.addAll(village.getListeLevelsChampsFer() );
								valchampMinBaf = Collections.min(baf);

								int a = Collections.max(village.getListeLevelsChampsBois());
								if (a >= 10) {a = 0;
								}
								int b = Collections.max(village.getListeLevelsChampsFer());
								if (b >= 10) {b = 0;
								}
								int c = Collections.max(village.getListeLevelsChampsArgile());
								if (c >= 10) {c = 0;
								}
								int d = Collections.max(village.getListeLevelsChampsCereales());


								int e = a + b + c;


								if(lien >= decalageCerealesLevelDebut && valchampMinBaf < decalageCerealesLevelFin && valchampMinBaf >= decalageCerealesLevelDebut && (e > 0)) { // decalage
									t.ecrireDansConsole("Decalage Cereales actif", true);
									decalageToken = true;


								}


								if(type.toLowerCase().contains("ferme")) {
									if(lien >= decalageCerealesLevelDebut && valchampMinBaf < decalageCerealesLevelFin && valchampMinBaf >= decalageCerealesLevelDebut && (e > 0)) { // decalage
										t.ecrireDansConsole("Decalage Cereales effectué", true);
										g++;
										continue;

									}

								}

							}
						}
						/// test
						/// ressources///////////////////////////////////////////////////////////////////////

						WebElement tagUnderConstruction = null;
						try {
							tagUnderConstruction = t.getCompte().getDriver().findElement(By.xpath("//*[@id=\"village_map\"]/div[" + (g + 1)+ "][contains(@class, 'underConstruction')]"));
						} catch (Exception e) {
						}
						if ((lien == champMin && tagUnderConstruction == null) || decalageToken == true && lien ==  valchampMinBaf && tagUnderConstruction == null) {

							boolean retrytoken = false;
							int boisNecessaire = 0;
							int argileNecessaire = 0;
							int ferNecessaire = 0;
							int cerealesNecessaire = 0;
							t.ecrireDansConsole("try lien==chamPmin : lien : " + lien + "   champMin : " + champMin + "    valchampMinBaf : " + valchampMinBaf, true);

							// survol souris du champs = a champMin
							Actions builder = new Actions(t.getCompte().getDriver());
							try {
								//builder.moveToElement(listeWebelementChampsBis.get(g+1));
								builder.moveToElement(listeWebelementChampsBis.get(g)); //g+1  	WebElement cible =  t.getCompte().getDriver().findElement(By.xpath("//area[@*[contains(., \"id="+ (g + 1) +"\")]]"));

							}catch (Exception e1){
								builder.moveToElement(listeWebelementChamps.get(g+1));
								}

							builder.perform();


							t.randomsleep.court();

							// choper le tableau des ressources necessaires pour
							// le champs en cours
							List<WebElement> ressourcesNecessaires = listeWebelementChamps.get(1).findElements(By.xpath("//*[@id=\"mainLayout\"]/body/div[3]/div/div/div[10]/div[2]/div/div/span")); // //*[@class='showCosts']/span    //*[@id="mainLayout"]/body/div[2]   ////*[@class='showCosts']/span   //*[@id="mainLayout"]/body/div[3]/div/div/div[10]/div[2]/div
							//List<WebElement> ressourcesNecessaires2 = listeWebelementChamps.get(g).findElements(By.xpath("//*[@id=\"mainLayout\"]/body/div[3]/div/div/div[10]/div[2]/div"));
								if (ressourcesNecessaires.size() == 0) {   // if (ressourcesNecessaires.size()==0)
									ressourcesNecessaires = listeWebelementChamps.get(g).findElements(By.xpath("//*[@id=\"mainLayout\"]/body/div[3]/div/div/div[10]/div[2]/div/div/span"));
								}
							
							
							// correction bug de MouseHover REVISION 2017 deconne, à surveiller
							
							if ( ressourcesNecessaires.size()==0 || ressourcesNecessaires.get(0).getText().isEmpty()) {   // if (ressourcesNecessaires.size()==0)
								retrytoken = true;
							}
						
							
							if (retrytoken == true) {
								t.ecrireDansConsole("Retry hover", true);

								Actions retry = new Actions(t.getCompte().getDriver());
								retry.moveToElement(listeWebelementChampsBis.get(g), 0, 0); //retry.moveToElement(listeWebelementChamps.get(g+1), 0, 0);
								retry.perform();

								t.randomsleep.court();

								

								retrytoken = false;
							}

							if (retrytoken == false) {
								// Parse
								boisNecessaire = Integer.parseInt(ressourcesNecessaires.get(0).getText());
								argileNecessaire = Integer.parseInt(ressourcesNecessaires.get(1).getText());
								ferNecessaire = Integer.parseInt(ressourcesNecessaires.get(2).getText());
								cerealesNecessaire = Integer.parseInt(ressourcesNecessaires.get(3).getText());
								t.ecrireDansConsole("parse ok : "+ boisNecessaire +" "+ argileNecessaire +" "+ferNecessaire +" "+ cerealesNecessaire, true);
							}
							// On fait la comparaison des ressources avec le
							// stock du village en cours
							// Village2 village = villageEnCours();
							village.updateRessources(t);
							int stockBois = village.getBois();
							int stockArgile = village.getArgile();;
							int stockFer = village.getFer();
							int stockCereales = village.getCereales();

							// si ressources ok
							if (stockBois >= boisNecessaire && stockArgile >= argileNecessaire && stockFer >= ferNecessaire && stockCereales >= cerealesNecessaire) {
								t.ecrireDansConsole("ressource ok", true);
								// go la page si //*[@id="stockBarFreeCrop"]

								listeWebelementChamps.get(g).click();

								t.randomsleep.court();
								// trouver le bouton vert
								WebElement bouttonvert = null;
								try {
									bouttonvert = t.getCompte().getDriver().findElement(By.xpath("//button[@class=\"green build\"]"));
								} catch (Exception e) {
									t.ecrireDansConsole("Bouton vert non present => Batiment en cour probable ou pas de cereales dispo pour la construction", true);
									t.getCompte().getDriver().get(t.getCompte().getServer() + "dorf1.php");
									t.randomsleep.classic();
									int cropSlot = Integer.parseInt(t.getCompte().getDriver().findElement(By.xpath("//*[@id=\"stockBarFreeCrop\"]")).getText().replaceAll("\\W", "").replaceAll("[\\u202D\\u202C.]", "").replace(".", "").replace(" ", "").trim());
									if (cropSlot > 3) {
										break;// non teste
									}
								}
								// cliquer sur le bouton vert
								t.randomsleep.classic();
								if (bouttonvert != null) {
									bouttonvert.click();
									t.ecrireDansConsole("Lancement d'un Champ de (valeur g) " + g + " (g-1) sur le Slot " + (g + 1) + "", true);
									t.randomsleep.court();
								}

							} else {
								t.ecrireDansConsole("ressource manquante", true);
							}
						} // fin if lien== champMin
						g++;

					} // fin if token de verification
					else {
						t.ecrireDansConsole(construEnCours +"construction en cours dont "+village.getTypeChampsEnConstruction()+ " champs", true);
						decalageToken = false;
						break;
					}
					decalageToken = false;
				} // fin while g <18
				//	} catch (Exception e) {
				//		t.ecrireDansConsole("echec monterChamps");
				//		return g;
				//	}
			} // fin if token <2
			village.voirListeDeConstruction(t);
		}catch (Exception e) {
			t.ecrireDansConsole("Erreur", true);
			return g;
		}
		t.ecrireDansConsole("fin monterChamps", true);
		return -1;
	}// fin monterchamps

	/* } */

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void parcourtChamps(Travian t, int g, Village village, int valchampMinBaf, List<WebElement> listeWebelementChamps, List<WebElement> listeWebelementChampsBis, int construEnCours, boolean decalageToken ) {}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public boolean trouverBatiment(Travian t, Village village, String nomBatiment) {

		boolean estPresent = false;
		for	(Batiment bat : village.getBatiments()) {
			if (bat.getNomBatiment().toLowerCase().equals(nomBatiment.toLowerCase()) ) {
				estPresent = true;
				break;
			}

		}
		return estPresent;
	}


	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void allerDansUnBatiment(Travian t, String batiment){
		t.ecrireDansConsole("allerDansUnBatiment début", true); 
		//ancienne version
		
	
		try {// on vas sur le marché
			WebElement titre;
			String titreString = "";
			try {
				titre = t.getCompte().getDriver().findElement(By.xpath("//*[@id=\"content\"]/h1"));
				titreString = titre.getText().trim();
			}catch (Exception ea) {

			}
			if(!titreString.toLowerCase().contains(batiment.toLowerCase())) {
				t.ecrireDansConsole("Nous ne sommes pas déja dans le "+ batiment +" --> on y va...", true);
				//  passer par les raccourcis en cas de compte plus
				if (batiment.toLowerCase().contains(TemplatesDeVillages.marche.toLowerCase())) {
					t.getCompte().getDriver().findElement(By.xpath("//*[contains(@class, 'marketWhite')]")).click();
					t.randomsleep.court();
				}
				else if (batiment.toLowerCase().contains(TemplatesDeVillages.caserne.toLowerCase())) {
					t.getCompte().getDriver().findElement(By.xpath("//*[contains(@class, 'barracksWhite')]")).click();
					t.randomsleep.court();
				}
				else if (batiment.toLowerCase().contains(TemplatesDeVillages.ecurie.toLowerCase())) {
					t.getCompte().getDriver().findElement(By.xpath("//*[contains(@class, 'stableWhite')]")).click();
					t.randomsleep.court();
				}
				else if (batiment.toLowerCase().contains(TemplatesDeVillages.atelier.toLowerCase())) {
					t.getCompte().getDriver().findElement(By.xpath("//*[contains(@class, 'workshopWhite')]")).click();
					t.randomsleep.court();
				}
				else if (true) {

					try {//on va sur une page contenant le batiment
						if (!t.getCompte().getDriver().getCurrentUrl().contains("dorf2.php")) {
							t.randomsleep.court();
							t.getCompte().getDriver().get(t.getCompte().getServer() + "dorf2.php");
							t.randomsleep.court();
						}
						
						
						WebElement boutton = t.getCompte().getDriver().findElement(By.xpath("//area[@alt[contains(.,'"+ batiment +"')]]"));
						boutton.click();
						t.randomsleep.court();
					}catch (Exception e3){
						t.ecrireDansConsole(" Version 1 : Pas de "+ batiment +" :(", true); // Ancienne version
						
						allerDansUnBatiment2(t,  batiment, 0); // nouvelle version
						
					}
				}
			}else {
				t.ecrireDansConsole("Nous sommes déja dans le " + batiment, true);
			}


		} catch (Exception eb) {
			t.ecrireDansConsole("Pas de compte + ou pas de " + batiment +" Passage en force", true);

			try{
				t.getCompte().getDriver().findElement(By.xpath("//*[@id='dialogCancelButton']")).click();	//*[@id="dialogCancelButton"]

			}catch (Exception e1) {t.ecrireDansConsole("echec evitement de la pub Travian+ ---> normal code mort  mais laisser pour garder le code pour autre chose", true);}

			try {//bon bah on va sur une page contenant le batiment
				if (!t.getCompte().getDriver().getCurrentUrl().contains("dorf2.php")) {
					t.randomsleep.court();
					t.getCompte().getDriver().get(t.getCompte().getServer() + "dorf2.php");
					t.randomsleep.court();
				}
				WebElement boutton = t.getCompte().getDriver().findElement(By.xpath("//area[@alt[contains(.,'"+ batiment +"')]]"));
				boutton.click();
				t.randomsleep.court();
			}catch (Exception e3){
				t.ecrireDansConsole("Pas de "+ batiment +" :(", true); // Ancienne version
				allerDansUnBatiment2(t,  batiment, 0); //nouvelle version
			}
		}	


		
		

		
		t.ecrireDansConsole("allerDansUnBatiment fin", true); 
	}
	
	
	
	public void allerDansUnBatiment2(Travian t, String batiment, int slotBatimentATrouver){
		t.ecrireDansConsole("allerDansUnBatiment2 Début", true); 
			WebElement titre;
			String titreString = "";


					try {//on va sur une page contenant le batiment
						if (!t.getCompte().getDriver().getCurrentUrl().contains("dorf2.php")) {
							t.randomsleep.court();
							t.getCompte().getDriver().get(t.getCompte().getServer() + "dorf2.php");
							t.randomsleep.court();
						}
						
						
						
						Village village = t.villageEnCours();
						//	village.setSlotBatimentsLibres(22);// remise à zero
						List<WebElement> listeDesBatiments = t.getCompte().getDriver().findElements(By.xpath("//*[@id=\"village_map\"]/div")); 
						// on cree une liste temporaire pour l envoyer au village une fois la liste complete.
						
						int g = 18 -1;
						if (slotBatimentATrouver > 0) {
							g = slotBatimentATrouver -1 ;
						}
						
						
						boolean trouver = false;
						for (WebElement webBatiment : listeDesBatiments) {
							if (trouver == true) {
								break;
							}
							// on intialise les variables
							String nomBatiment = null;
							int levelBatiment = 0;
							String slotBatiment = null;
								
							
							
	
						while (g < 41) {//*[@id="village_map"]/div[40]/div
							Actions builder = new Actions(t.getCompte().getDriver());
							
							//methode 1
							try {//builder.moveToElement(listeWebelementChampsBis.get(g+1));
								builder.moveToElement(listeDesBatiments.get(g)); //g+1  	WebElement cible =  t.getCompte().getDriver().findElement(By.xpath("//area[@*[contains(., \"id="+ (g + 1) +"\")]]"));
							}catch (Exception e1){
								// builder.moveToElement(listeDesBatiments.get(g-1));
								 }
							builder.perform();
							t.randomsleep.tcourt();
							List<WebElement> donnees = listeDesBatiments.get(g).findElements(By.xpath("//*[@id=\"mainLayout\"]/body/div[3]/div/div/div[10]")); // /div[1] //*[@id="mainLayout"]/body/div[3]/div/div/div[10]
							String donneeComplete =  donnees.get(0).getText().toString();//   /div[1]
							 nomBatiment = donneeComplete.split("Niveau")[0].toString().trim() ;//   /div[1]
							 if(nomBatiment.toLowerCase().contains(batiment.toLowerCase())) {
									WebElement boutton = listeDesBatiments.get(g);
									boutton.click();
									trouver = true;
									t.randomsleep.court();
									break;
										 }
							 
							 try { 
							 //methode 2
							 //en cas de mur ou de batiment de soucis de clickage
							 if(nomBatiment.isEmpty() || nomBatiment == null) {
							     WebElement wb = t.getCompte().getDriver().findElement(By.xpath("//*[@id=\"village_map\"]/div["+ (g+1) +"]/div"));
								 builder.moveToElement(wb);
								 builder.perform();
								 t.randomsleep.court();
									donnees = listeDesBatiments.get(g).findElements(By.xpath("//*[@id=\"mainLayout\"]/body/div[3]/div/div/div[10]")); 
									donneeComplete =  donnees.get(0).getText().toString();//   /div[1]
									nomBatiment = donneeComplete.split("Niveau")[0].toString().trim() ;
									 if(nomBatiment.toLowerCase().contains(batiment.toLowerCase())) {
											//WebElement boutton = listeDesBatiments.get(g);
											 builder.click(wb);
											 builder.perform();
											trouver = true;
											t.randomsleep.court();
											break;
												 }
						}
							 }catch (Exception e1){} 
	
							 
							 g++;
						}
							
						}
						if (trouver == false) {
						t.ecrireDansConsole(" Version 2 : Pas de "+ batiment +" :(", true); 
						}
					}catch(Exception e) {
						t.ecrireDansConsole(" Version 2 : echec allerDansUnBatiment", true);
					}
						


					t.ecrireDansConsole("allerDansUnBatiment2 Fin", true); 
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


	public void changementOnglet(Travian t,Village village, int token, String titreOnglet) {
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
			t.ecrireDansConsole("echec changementOnglet  "  + token, true); 
		}

	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



	public boolean construireBatiments(String batimentAConstruire, int levelVoulu, Travian t, boolean besoinMiseAJour, int slotBatimentATrouver) {
		t.ecrireDansConsole("debut construireBatiments", true);
		//t.randomsleep.court();

		// if (!compte.getDriver().getCurrentUrl().contains("dorf2.php"))
		// {compte.getDriver().get(compte.getServer() + "dorf2.php");}
		// randomsleep.court();
		Village village = t.villageEnCours();
		//updateRessources(t);

		int boisNecessaire = 0;
		int argileNecessaire = 0;
		int ferNecessaire = 0;
		int cerealesNecessaire = 0;
		boolean reussite = false;
		/*
		if (village.getBois() >= boisNecessaire && village.getArgile() >= argileNecessaire && village.getFer() >= ferNecessaire && village.getCereales() >= cerealesNecessaire) {
			t.ecrireDansConsole("[construireBatiment] Ressources ok", true);
			// go la page
		}
		*/
		if(true) {
		allerDansUnBatiment2(t,  batimentAConstruire, slotBatimentATrouver); //TODO mettre slot pour construire les doublon
		//TODO  en faire un Objet          
		// si cest un marche ou autre cliquer le bon                         //*[contains(@class, 'subNavi')]//div[contains(@class, 'container')]
		// tab			                                                     //*[contains(@class, 'favorActive')] //*[contains(@class, 'tabItem')]
		try {
			List<WebElement> listeDesTabs = t.getCompte().getDriver().findElements(By.xpath("//*[contains(@class, 'container')] //*[not(contains(@class,'favorActive'))] //*[contains(@class, 'tabItem')]"));  //*[@class=\"tabItem\"]
			for (WebElement tabGestion : listeDesTabs) {

				if (tabGestion.getText().contains("Gestion")) {      
					tabGestion.click();
					t.randomsleep.court();
					break;
				}

			}
		} catch (Exception e) {
			t.ecrireDansConsole("bug :)", true);
		}

		// cliquer sur le bouton vert
		WebElement bouttonvert = null;
		try {
			bouttonvert = t.getCompte().getDriver().findElement(By.xpath("//button[@class=\"green build\"]"));
		} catch (Exception e) {
			WebElement errorMessage = null;
			String errorMessageString = "";
			try {
				errorMessage= t.getCompte().getDriver().findElement(By.xpath("//*[@id=\"contract\"]/div/div/div/div[1]/div[1]"));
				errorMessageString = errorMessage.getText().toLowerCase();
			}catch(Exception e1){

			}
			if(errorMessageString.contains("ameliorez") || errorMessageString.contains("améliorez") || errorMessageString.contains("abord")){
				t.ecrireDansConsole("[construireBatiment] Bouton vert non present => prérequis manquant / silo / depot", true);
			}else {
			t.ecrireDansConsole("[construireBatiment] Bouton vert non present => Champ en cour probable => WorkAround Construction Bloquée pour ce tour", true); //=> WORKAROUND on ajoute des token
			//village.setConstructionsEnCours(t.limiteDeConstruction); //WORKAROUND on ajoute des token
			//village.bloquerConstructionBatiment = true;
			reussite = false;
			}
			t.getCompte().getDriver().get(t.getCompte().getServer() + "dorf2.php");
			t.randomsleep.classic();
		//	break;
		}

		if (bouttonvert != null) {
			bouttonvert.click();
			t.ecrireDansConsole("[construireBatiment] Lancement " + batimentAConstruire, true);
			reussite = true;
			t.randomsleep.court();
			
		}
		}else {
			//ancienne version//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		

		List<WebElement> listeDesBatiments = t.getCompte().getDriver().findElements(By.xpath("//*[@id=\"clickareas\"]/area"));
		List<Batiment> batimentsDeLaPage = new ArrayList<Batiment>(); //TODO verifier que ca n'add pas des villages sur la meme liste au court des rotation et session

		// WebElement areaBatiment;
//TODO a corriger pour la nouvelle version
		for (WebElement webBatiment : listeDesBatiments) {
			try {
				String nom = webBatiment.getAttribute("alt").split(" <span")[0].replace("&#39;", "'");
				int level = Integer.parseInt(webBatiment.getAttribute("alt").split("<span class=\"level\">Niveau ")[1].split("</span>")[0]);

				// on corrige le level si un level est en cour de consrtuction
				try {
					int levelSuivantDispo = 0;
					levelSuivantDispo = Integer.parseInt(webBatiment.getAttribute("alt").split("Coût pour le niveau ")[1].split(":<br")[0]);
					level = (levelSuivantDispo - 1); //level en cours
				}catch(Exception e){/* t.ecrireDansConsole("Echec levelSuivantDispo de construire batiment");*/} //Cout pour le niveau 8:

				String slot = webBatiment.getAttribute("href").split("id=")[1];

				Batiment batiment = new Batiment(nom, level, slot);
				batimentsDeLaPage.add(batiment);

			} catch (Exception e) { //on catch les slot libre
				String nom = webBatiment.getAttribute("alt");
				int level = 0;
				String slot = webBatiment.getAttribute("href").split("id=")[1];
				String alt = webBatiment.getAttribute("alt");

				Batiment batiment = new Batiment(nom, level, slot, alt);
				batimentsDeLaPage.add(batiment);
			}

		}
		////////////////////////////////////////////

		for (Batiment construire1 : batimentsDeLaPage) {
			// listeDesBatiments =
			// compte.getDriver().findElements(By.xpath("//*[@id=\"clickareas\"]/area"));
			if (construire1.getNomBatiment().contains(batimentAConstruire)) {
				int level = construire1.getLevelBatiment();

				if (level < levelVoulu && village.getConstructionsEnCours() < t.limiteDeConstruction) {

					// Parse
					try {

						listeDesBatiments = t.getCompte().getDriver().findElements(By.xpath("//*[@id=\"clickareas\"]/area"));
						for (WebElement as : listeDesBatiments) {//////////////////////////////// ici

							//////////////////////////////// go
							//////////////////////////////// to
							//////////////////////////////// stale,
							//////////////////////////////// recgargement
							//////////////////////////////// de
							//////////////////////////////// page
							//////////////////////////////// souci

							// voirListeDeConstruction(t);

							if (as.getAttribute("alt").replace("&#39;", "'").contains(construire1.getNomBatiment())
									&& as.getAttribute("href").split("id=")[1].contains(construire1.getSlotBatiment())
									&& village.getConstructionsEnCours() < t.limiteDeConstruction) {
								boisNecessaire = Integer.parseInt(as.getAttribute("alt").split("r1\" src=\"img/x.gif\" />")[1].split("</span>")[0].trim());
								argileNecessaire = Integer.parseInt(as.getAttribute("alt").split("r2\" src=\"img/x.gif\" />")[1].split("</span>")[0].trim());
								ferNecessaire = Integer.parseInt(as.getAttribute("alt").split("r3\" src=\"img/x.gif\" />")[1].split("</span>")[0].trim());
								cerealesNecessaire = Integer.parseInt(as.getAttribute("alt").split("r4\" src=\"img/x.gif\" />")[1].split("</span>")[0].trim());
								t.ecrireDansConsole("[construireBatiment]parse ok", true);

								// on fais la comparaison des ressources avec le
								// stock du village en cours
								if(besoinMiseAJour== true) {
									updateRessources(t);
								}
								int stockBois = village.getBois();
								int stockArgile = village.getArgile();
								int stockFer = village.getFer();
								int stockCereales = village.getCereales();
								// si ressources ok
								if (stockBois >= boisNecessaire && stockArgile >= argileNecessaire && stockFer >= ferNecessaire && stockCereales >= cerealesNecessaire) {
									t.ecrireDansConsole("[construireBatiment] Ressources ok", true);
									// go la page

									if(as.getAttribute("alt").contains("Mur")) { //TODO rendre compatible les races
										Actions action = new Actions(t.getCompte().getDriver());
										action.moveToElement(as, 320, 440).click().perform();
										//as.getAttribute("href");;
									}	
									else {

										as.click();
										t.randomsleep.court();
									}


									//	t.randomsleep.court();

									//TODO  en faire un Objet          
									// si cest un marche ou autre cliquer le bon                         //*[contains(@class, 'subNavi')]//div[contains(@class, 'container')]
									// tab			                                                     //*[contains(@class, 'favorActive')] //*[contains(@class, 'tabItem')]
									try {
										List<WebElement> listeDesTabs = t.getCompte().getDriver().findElements(By.xpath("//*[contains(@class, 'container')] //*[not(contains(@class,'favorActive'))] //*[contains(@class, 'tabItem')]"));  //*[@class=\"tabItem\"]
										for (WebElement tabGestion : listeDesTabs) {

											if (tabGestion.getText().contains("Gestion")) {      
												tabGestion.click();
												t.randomsleep.court();
												break;
											}

										}
									} catch (Exception e) {
										t.ecrireDansConsole("bug :)", true);
									}

									// cliquer sur le bouton vert
									WebElement bouttonvert = null;
									try {
										bouttonvert = t.getCompte().getDriver().findElement(By.xpath("//button[@class=\"green build\"]"));
									} catch (Exception e) {
										t.ecrireDansConsole("[construireBatiment] Bouton vert non present => Champ en cour probable => WorkAround Construction Bloquée pour ce tour", true); //=> WORKAROUND on ajoute des token
										//village.setConstructionsEnCours(t.limiteDeConstruction); //WORKAROUND on ajoute des token
										village.bloquerConstructionBatiment = true;
										reussite = false;
										t.getCompte().getDriver().get(t.getCompte().getServer() + "dorf2.php");
										t.randomsleep.classic();
										break;
									}

									if (bouttonvert != null) {
										bouttonvert.click();
										t.ecrireDansConsole("[construireBatiment] Lancement " + batimentAConstruire, true);
										reussite = true;
										t.randomsleep.court();
										listeDesBatiments = t.getCompte().getDriver().findElements(By.xpath("//*[@id=\"clickareas\"]/area"));
										break;
									}
								} else {
									t.ecrireDansConsole("[construireBatiment] Pas assez de Ressources pour faire un/une "+ batimentAConstruire, true);
								}
							}

						} // break;}
					} catch (Exception e) {
						t.ecrireDansConsole(" echec modifier ce commentaire : [construireBatiment] Batiment de niveau deja en construction ou deja au level demande "+ batimentAConstruire, true);
						voirListeDeConstruction(t);
					}

				} else {
					t.ecrireDansConsole("[construireBatiment] " + batimentAConstruire + " deja a "+levelVoulu, true);
					reussite = false;
				}

			}

		}
		}
		//voirListeDeConstruction(t);
		t.ecrireDansConsole("fin construireBatiments", true);
		return reussite;

	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void lancerFete(Travian t) { // a modifier : regarder avant les recap
		// pour voir si une fete est deja
		// lancee... sinon ca clic pour rien
		t.randomsleep.court();
		t.getCompte().getDriver().get(t.getCompte().getServer() + "dorf2.php");
		t.randomsleep.court();

		try {
			/*
			while (g < 18) {
				Actions builder = new Actions(t.getCompte().getDriver());
				try {
					//builder.moveToElement(listeWebelementChampsBis.get(g+1));
					builder.moveToElement(listeDesBatiments.get(g+18)); //g+1  	WebElement cible =  t.getCompte().getDriver().findElement(By.xpath("//area[@*[contains(., \"id="+ (g + 1) +"\")]]"));

				}catch (Exception e1){
					 builder.moveToElement(listeDesBatiments.get(g+17));
					 }

				builder.perform();
				
				t.randomsleep.tcourt();
				List<WebElement> donnees = listeDesBatiments.get(g+18).findElements(By.xpath("//*[@id=\"mainLayout\"]/body/div[2]/div/div/div[10]")); // /div[1]
				String donneeComplete =  donnees.get(0).getText().toString();//   /div[1]
				nomBatiment = listeDesBatiments.get(g+18).findElement(By.xpath("//*[@id=\"mainLayout\"]/body/div[2]/div/div/div[10]/div[1]")).getText().split("Niveau")[0].toString().trim() ;//   /div[1]
		*/
			List<WebElement> listeDesBatiments = t.getCompte().getDriver().findElements(By.xpath("//*[@id=\"clickareas\"]/area"));
			int hotelNonPresent = 1;

			allerDansUnBatiment2(t, TemplatesDeVillages.hotel_de_ville, 0);
				t.bot.getTemplateLancerBot();

					t.randomsleep.court();

					// on fait une liste des boutons de lancement de fete
					List<WebElement> boutons = null;
					try {
						boutons = t.getCompte().getDriver().findElements(By.xpath("//*[@value=\"Organiser\"]"));
					} catch (Exception e) {
						t.ecrireDansConsole("[Fete] Erreure de listage des boutons Fete ", true);
					}

					// on verifie si des boutons de lancement de fetes sont
					// present
					if (boutons.size() > 0) {
						// on tente une grande fete d'abord
						try {
							if (boutons.get(1).getText().contains("Organiser")) {
								boutons.get(1).click();
								t.ecrireDansConsole("[Fete] Grande fete lancee", true);
								t.randomsleep.court();
							}
						} catch (Exception e) {
						}
						// puis sinon on tente une ptite fete
						try {
							if (boutons.get(0).getText().contains("Organiser")) {
								boutons.get(0).click();
								t.ecrireDansConsole("[Fete] Petite fete lancee", true);
								t.randomsleep.court();
							}
						} catch (Exception e) {
						}

					} else {
						t.ecrireDansConsole("[Fete] Une Fete Est Deja en cours", true);
					}

					
				

		/*
			if (hotelNonPresent == 1) {
				t.ecrireDansConsole("[Fete] Pas D'hotel de ville", true);
			}
			*/
		} catch (Exception e) {
			t.ecrireDansConsole("[Fete] echec lancer fete interne", true);
		}

		// on retourne sur la page des champs pour le village suivant
		t.randomsleep.court();
		t.getCompte().getDriver().get(t.getCompte().getServer() + "dorf1.php");
		t.randomsleep.court();

	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// switch regime
	public boolean switchRegimeGeneral() {
		if (regimeGeneral == false) {
			regimeGeneral = true;
		} else {
			regimeGeneral = false;
		}
		return regimeGeneral;
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void EssayerConstruireBatiments(Travian t, Village village) {

		if(t.bot.monterChamps == true || village.getVillageCapitale() && t.bot.monterChampsCapitale == true ) {

			if (t.bot.monterChampsCapitale == false){t.ecrireDansConsole("Monter champs Capitale > 10 désactivé... ", true);}

			if (champMin < 10 || village.getVillageCapitale() && t.bot.monterChampsCapitale == true) {


				int erreurChamps = 0;
				int g = 0;
				if ( village.getRegimeMonterChamps() == true ) {
					while( g >= 0 && erreurChamps < 30) {
						g = monterChamps(t, g);
						erreurChamps++;

					}
					t.ecrireDansConsole("erreurChamps : " + erreurChamps + " g : " + g, true);
				}else {
					t.ecrireDansConsole("monterChamps desactivé par le regime du village...", true);
				}


			}
		}else {
			t.ecrireDansConsole("monterChamps desactivé sur le compte...", true);
		}


		if ( t.bot.construireBatiments == true ) {
			if ( village.getRegimeConstruction() == true ) {

				/*	if (village.getConstructionsEnCours() < t.limiteDeConstruction && village.getTypeBatimentsEnConstruction() < 2 && village.getChampMin() <= 10
						|| village.getConstructionsEnCours() < t.limiteDeConstruction && village.getTypeBatimentsEnConstruction() < 2 && village.getVillageCapitale() == true) {*/
				if (village.getConstructionsEnCours() < t.limiteDeConstruction && village.getTypeBatimentsEnConstruction() < 2) {
					chargerBatiments(t);
					// try {

					// avant de monter on pose les village du template des que possible
					if(village.bloquerConstructionBatiment == false) {
						if(village.getTemplate().getAutoriserAPoserBatiment() == true) {
							creationBatiment(t, village); 
						}else {t.ecrireDansConsole("Ce Stade n'a pas le droit de poser lui meme les batiments...", true);}
					}

					
					
					
					// upgrade de batiment déjà posés :
					for (int i = 0; i <= 1 && village.getConstructionsEnCours() < t.limiteDeConstruction  && village.getTypeBatimentsEnConstruction() < 2; i++) { // pour faire 2 fois le meme batiment au cas ou
						t.ecrireDansConsole("Tour de construction : "+ (i+1) , true);

						
						
							//Pour chaque batiment du village on va le faire evoluer s'il est dans le template du village : (cela permet de faire evoluer les batiment en doublon dans systeme suplémentaire)
						for (Batiment batimentDuVillage : village.getBatiments()) {
					//	for (Batiment batimentDuTemplate : village.getTemplateDuVillage()) {
							boolean trouver = false;
							boolean besoinMiseAJour = false;
							// on se remet sur la page au cas ou un echec des boucles
							// plus bas
							if (!t.getCompte().getDriver().getCurrentUrl().contains("dorf2.php")) {
								t.randomsleep.court();
								t.getCompte().getDriver().get(t.getCompte().getServer() + "dorf2.php");
								t.randomsleep.court();
							}


							//on regarde dans le template si le batiment est present  et on le lance si cest le cas.
							for (Batiment batimentDuTemplate : village.getTemplateDuVillage()) {
								
						//	for (Batiment batimentDuVillage : village.getBatiments()) {
								if (batimentDuVillage.getNomBatiment().equals(batimentDuTemplate.getNomBatiment())) {
									trouver = true;
									
		
									if (village.getConstructionsEnCours() < t.limiteDeConstruction && village.getTypeBatimentsEnConstruction() < 2 && village.bloquerConstructionBatiment  == false) {

										if (batimentDuVillage.getLevelBatiment() < batimentDuTemplate.getLevelBatiment()) {
										
											//test de ressources
											boolean ressourceOk = false;
											if (village.getBois() >= batimentDuVillage.boisPourNiveauSuivant && village.getArgile() >= batimentDuVillage.argilePourNiveauSuivant && village.getFer() >= batimentDuVillage.ferPourNiveauSuivant && village.getCereales() >= batimentDuVillage.cerealePourNiveauSuivant) {
												t.ecrireDansConsole("[construireBatiment] "+ batimentDuVillage.getNomBatiment() +" Ressources ok", true);
												ressourceOk = true;
											}
											
										if(ressourceOk == true && village.getTypeBatimentsEnConstruction() < 2) {
											// on lance la construction
											if(construireBatiments(batimentDuTemplate.getNomBatiment(), batimentDuTemplate.getLevelBatiment(), t, besoinMiseAJour, Integer.parseInt(batimentDuVillage.getSlotBatiment()))) {
												besoinMiseAJour = true;
												if(besoinMiseAJour== true) {
													updateRessources(t);
												//	voirListeDeConstruction(t);
												}
											}
											voirListeDeConstruction(t);
										}else {
											t.ecrireDansConsole("[construireBatiment] "+ batimentDuVillage.getNomBatiment() +" Slot : " +batimentDuVillage.getSlotBatiment() + " Ressources insuffisantes", true);
										}

										}

									}else {	t.ecrireDansConsole("Upgrade batiment impossible... "+village.getConstructionsEnCours()  + " constructions en cours dont " +village.getTypeBatimentsEnConstruction()+ " batiments", true);}
								}
								
								
								
							}


						}

						// village.getTemplateDuVillage()){
						// }catch (Exception e) {t.ecrireDansConsole(": Batiment absent
						// sur palier 1");}
					}						//Enfin si le batiment n'est pas present dans le template, on le note dans la console 
					for (Batiment batimentDuTemplateTest : village.getTemplateDuVillage()) {// pour noter dans la console les batiments non present
						boolean trouver = false;
						for (	Batiment batimentDuVillageTest : village.getBatiments()) {
							if (batimentDuVillageTest.getNomBatiment().equals(batimentDuTemplateTest.getNomBatiment())) {
								trouver = true;
						t.ecrireDansConsole(batimentDuTemplateTest.getNomBatiment() + " ---> Trouvé ", true);
							}
					}
						if(trouver == false) {
						t.ecrireDansConsole(batimentDuTemplateTest.getNomBatiment() + " ---> pas trouve (Attendre qu'il soit posé, ou le faire manuellement)", true);// PAS
						}
						} 
				}else {
					t.ecrireDansConsole("construction Desactivees... "+village.getConstructionsEnCours()  + " constructions en cours dont " +village.getTypeBatimentsEnConstruction()+ " batiments", true);
				}
				// on pose les batiment apres les upgrade
				//creationBatiment(t, village);  // 1/10/2017
			}else {
				t.ecrireDansConsole("construction Desactivees... Par le regime du village", true);
			}
		}else {
			t.ecrireDansConsole("construction de batiments Desactivees sur le compte...", true);
		}
	}

	///////////////////////////////////////////////////////////////////////////// creationBatiment(t,
	///////////////////////////////////////////////////////////////////////////// village,
	///////////////////////////////////////////////////////////////////////////// batimentDuTemplate);
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// creationBatiment(t,
	///////////////////////////////////////////////////////////////////////////// village,
	///////////////////////////////////////////////////////////////////////////// batimentDuTemplate);
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private void creationBatiment(Travian t, Village village) {
		t.ecrireDansConsole("creationBatiment début :", true);
		//	chargerBatiments(t);
		int tokenDeChangement = 0;
		if(village.getConstructionsEnCours() < t.limiteDeConstruction){
			t.ecrireDansConsole("Essai de création de batiments :", true);
			boolean trouver = false;
			boolean slotDispo = false;
			String nomBat = null;

			/////
			for(Batiment slot : village.getBatiments()){
				// on regarde si un slot est dispo pour plus tard, au cas ou. 
				if (slot.getNomBatiment().contains("Site de construction")) {
					slotDispo = true;	
					t.ecrireDansConsole("Slot libre = oui", true);
				}
			}


			// on parcour les batiments du template et on les commpare aux batiments du village pour etablir les batiments present
			for(Batiment batimentDuTemplate : village.getBatimentsDuTemplateDuVillage()){
				trouver = false;
				nomBat = batimentDuTemplate.getNomBatiment() ;

				if (tokenDeChangement > 0){
					tokenDeChangement = 0;
					chargerBatiments(t);
					voirListeDeConstruction(t);
				}

				for (Batiment batimentDuVillage : village.getBatiments()){
					if(nomBat.equals(batimentDuVillage.getNomBatiment())){
						trouver = true;
					}
				}


				if(trouver == true){
					t.ecrireDansConsole(nomBat+" trouvé dans le village.", true);
					batimentDuTemplate.setPresent(true);
				}

			}




			// on regarde la necessité d'essayer de contruire un nouveau batiment

			boolean possibleDePoserUnBatiment = false;
			for(Batiment batimentDuTemplate :  batimentsDuTemplateDuVillage){


				nomBat = batimentDuTemplate.getNomBatiment() ;
				// on test les cas problematique
				if( nomBat.equals(TemplatesDeVillages.tailleur)|| nomBat.contains(TemplatesDeVillages.grandSilo) || nomBat.contains(TemplatesDeVillages.grandDepot) || nomBat.contains(TemplatesDeVillages.cdt)|| nomBat.contains(TemplatesDeVillages.palais) ){ //nomBat.equals("Résidence") || nomBat.equals("Palais") ||  
					t.ecrireDansConsole(nomBat+" trouvé dans le template. -> ne rien faire", true);				
				}else {
					if(batimentDuTemplate.getPresent() == false  ){
						// on test les cas *Beta*


						if( (batimentDuTemplate.getNeedCapitale() == true && village.getVillageCapitale() == true) || (batimentDuTemplate.getNeedArtefact() == true &&  t.getCompte().getPossedeUnArtefactGDGS() == true) ) {

						}


						int nombreConditionsRequises =  batimentDuTemplate.prerequisBatiment.size();
						if(batimentDuTemplate.getNeedCapitale() == true) {nombreConditionsRequises++;}
						if(batimentDuTemplate.getNeedArtefact() == true) {nombreConditionsRequises++;}
						int nombreConditionsRemplies = 0 ;
						//test pour les batiments
						for(Batiment batRequis : batimentDuTemplate.prerequisBatiment) {
							for(Batiment batVillage : village.getBatiments()) { //batVillage.equals(batRequis)
								if(  (batVillage.getLevelBatiment() >= batRequis.getLevelBatiment()) && (batVillage.getNomBatiment().toLowerCase().contains(batRequis.getNomBatiment().toLowerCase()) )  ) {
									nombreConditionsRemplies++;		
								}
							}
						}
						//test pour les champs
						for(Batiment batRequis : batimentDuTemplate.prerequisBatiment) {
							if(batRequis.getLevelBatiment() <=  Collections.max(village.listeLevelsChampsArgile) && batRequis.getNomBatiment().contains(TemplatesDeVillages.ChampsCarriereDArgile)) {
								nombreConditionsRemplies++;		
							}
							if(batRequis.getLevelBatiment() <=  Collections.max(village.listeLevelsChampsFer) && batRequis.getNomBatiment().contains(TemplatesDeVillages.ChampsMineDeFer)) {
								nombreConditionsRemplies++;		
							}
							if(batRequis.getLevelBatiment() <=  Collections.max(village.listeLevelsChampsBois) && batRequis.getNomBatiment().contains(TemplatesDeVillages.ChampsBucheron)) {
								nombreConditionsRemplies++;		
							}
							if(batRequis.getLevelBatiment() <=  Collections.max(village.listeLevelsChampsCereales) && batRequis.getNomBatiment().contains(TemplatesDeVillages.ChampsFerme)) {
								nombreConditionsRemplies++;		
							}
						}
						if(nombreConditionsRemplies == nombreConditionsRequises) {
							t.ecrireDansConsole(nomBat+" Conditions remplies : " +nombreConditionsRemplies+" sur "+ nombreConditionsRequises, true);	

							possibleDePoserUnBatiment = true;
						}else {
							t.ecrireDansConsole(nomBat+" Conditions non remplies : " +nombreConditionsRemplies+" sur "+ nombreConditionsRequises, true);
						}

					}
				}
			}



			// on confirme la necessité et on continue
			if ( possibleDePoserUnBatiment == true && slotDispo == true){
				// on se place sur le village si on a un slot dispo
				if (!t.getCompte().getDriver().getCurrentUrl().contains("dorf2.php")) {
					t.randomsleep.court();
					t.getCompte().getDriver().get(t.getCompte().getServer() + "dorf2.php");
					t.randomsleep.court();
				}
				//on choisi un slot 
				Batiment leSlot = null;
				for (Batiment batimentDuVillage : village.getBatiments()){
					if(batimentDuVillage.getNomBatiment().contains("Site de construction") && Integer.parseInt(batimentDuVillage.getSlotBatiment())<= 38){
						leSlot = batimentDuVillage; // 39 = pr // 40 = mur

					}

				}
				try {
				// on clique sur le slot libre 
				WebElement leBat = t.getCompte().getDriver().findElement(By.xpath("//*[@id=\"village_map\"]/div["+  leSlot.getSlotBatiment() +"]//*[name()='g']")); //*[@id=\"village_map\"]/div["+ (g+19) +"]//*[name()='g']//*[name()='g']                      //*[@href=\"build.php?id=" + leSlot.getSlotBatiment() + "\"]
				Actions builder = new Actions(t.getCompte().getDriver());
				builder.click(leBat).build().perform();
			//	leBat.click();
				
				t.randomsleep.court();
					}catch(Exception e) {
						try {
						//second essai
						WebElement leBat = t.getCompte().getDriver().findElement(By.xpath("//*[@id=\"village_map\"]/div["+  leSlot.getSlotBatiment() +"]//*[name()='g']")); //*[@id=\"village_map\"]/div["+ (g+19) +"]//*[name()='g']//*[name()='g']                      //*[@href=\"build.php?id=" + leSlot.getSlotBatiment() + "\"]
						leBat.click();
						t.randomsleep.court();
						}catch(Exception e1) {
					t.ecrireDansConsole(" Echec :  clic sur Slot libre numero : " + leSlot.getSlotBatiment() + "", true);
						}
				}






				boolean	batimentPosé = false;
				// on va chercher si un batiment peut etre construit 
				List<WebElement> listOngletsBats = t.getCompte().getDriver().findElements(By.xpath("//*[@class=\"tabItem\"]"));
				int i2 = 1;
				if( possibleDePoserUnBatiment == true){
					while (i2 <= listOngletsBats.size()){


						if (possibleDePoserUnBatiment == true) {
							if(i2> 1 && i2 <= listOngletsBats.size()){
								listOngletsBats.get(i2-1).click();
								t.ecrireDansConsole("---------Changement d'onglet---------", true);
								//on recharge les onglets de la nouvelle page
								listOngletsBats = t.getCompte().getDriver().findElements(By.xpath("//*[@class=\"tabItem\"]"));
							} 


							for(Batiment batimentDuTemplate : village.getBatimentsDuTemplateDuVillage()){
								nomBat = batimentDuTemplate.getNomBatiment();
								if( nomBat.equals(TemplatesDeVillages.tailleur)|| nomBat.contains(TemplatesDeVillages.grandSilo) || nomBat.contains(TemplatesDeVillages.grandDepot) || nomBat.contains(TemplatesDeVillages.cdt)|| nomBat.contains(TemplatesDeVillages.palais) ){ //nomBat.equals("Résidence") || nomBat.equals("Palais") ||
									t.ecrireDansConsole(nomBat+" trouvé dans le template. -> ne rien faire 2 ", true); 

								}else {

									if(batimentDuTemplate.getPresent() == false){

										List<WebElement> listWebBats = t.getCompte().getDriver().findElements(By.xpath("//*[@class=\"buildingWrapper\"]"));


										for (WebElement webBat : listWebBats) {

											if(possibleDePoserUnBatiment == false){break;}

											String titre = webBat.getText().split("\\n")[0]; 
											if (titre.toLowerCase().contains(nomBat.toLowerCase())) {
												t.ecrireDansConsole(nomBat+" ////////// tentative pour contruction", true); 
												try {
													WebElement boutton = webBat.findElement(By.xpath("//*[@class='buildingWrapper' and contains(., 'Construire') and contains(., \""+ titre +"\")]//div[@class='contractLink']//button")); // //div[@class='button-content'] //*[@class='buildingWrapper' and contains(., 'Construire le bâtiment.') and contains(., \""+ titre +"\")]//div[@class='button-content']"

													if (boutton.getText().contains("Construire")) {
														t.randomsleep.court();
														boutton.click();
														possibleDePoserUnBatiment = false;
														t.ecrireDansConsole(nomBat +" lancé. Debug : Par titre", true);
														break;
													}

												}catch (Exception e) {
													t.ecrireDansConsole("Echec par Titre", true);
													try {
														WebElement boutton = webBat.findElement(By.xpath("//*[@class='buildingWrapper' and contains(., 'Construire') and contains(., \""+ nomBat +"\")]//div[@class='contractLink']"));// //*[@class='buildingWrapper' and contains(., 'Construire le bâtiment.') and contains(., \""+ nomBat +"\")]//div[@class='button-content']"
														if (boutton.getText().contains("Construire")) {
															t.randomsleep.court();
															boutton.click();
															possibleDePoserUnBatiment = false;
															t.ecrireDansConsole(nomBat +" lancé. Debug : Par nomBat", true);
															break;
														}
													}catch (Exception e1) {
														t.ecrireDansConsole("Echec par nomBat", true);
														t.ecrireDansConsole(nomBat + " --> echec Pas dispo a la construction sur page manque ressources ou prerequis "+ i2 +" Debug info : "+" nomBat ="+nomBat+" Titre.toLowerCase ="+ titre.toLowerCase() +" Titre normal ="+ titre, true );
													}
												}//fin catch
											}else {t.ecrireDansConsole(nomBat +" pas dispo sur ce webB ", true);} //fin if

										} //fin for webBat
										if (possibleDePoserUnBatiment == true){t.ecrireDansConsole(nomBat +" pas dispo sur l'onglet "+i2, true);}
										//if(trouver == true){break;}

									} //else {t.ecrireDansConsole(nomBat +" pas dispo sur les 3 onglets");}
								}
							} //fin for batdutempalte
							i2++;
							//	}	//fin if(i2> 0 && i2 < listOngletsBats.size())
							//	else {
							//		break;
							//	} 
						} //fin if trouver = false 
						else {

							break;
						}
						//	if(trouver == false ) {

						//		}
					} // fin while
					if (possibleDePoserUnBatiment == true && i2>=4){ // si trouver ==false  on quitte la fenetre pour se remmetre sur la page batiments du village pour les autre fonctions
						t.ecrireDansConsole("Aucun batiments dispo sur les 3 onglets", true);
						// on se remet sur la page du village pour les autre fonctions
						try {
							t.getCompte().getDriver().findElement(By.xpath("//*[@id='closeContentButton']")).click();//*[@id="closeContentButton"]
						}catch (Exception e){ t.ecrireDansConsole("Echec //*[@id='closeContentButton'] ", true);}
					} else {t.ecrireDansConsole("Terminé", true);}
				}//fin if  trouver == false
				//on reset le trouver pour les autre batiments du template
				possibleDePoserUnBatiment = true;


			} // fin if (trouver == false && slotDispo == true){




		} // fin if token < 2
		//	else {break;}
		t.ecrireDansConsole("creationBatiment Fin", true);
	} //fin




	public void creerNouveauTemplate(String nom) {
		TemplatesDeVillages newTemplate = new TemplatesDeVillages();
		newTemplate.setNomDuTemplate(nom);
		listeDeTemplates.add(newTemplate);
	}
	public TemplatesDeVillages trouverTemplate(String nom) {
		for(TemplatesDeVillages temT : listeDeTemplates ) {
			if(temT.getNomDuTemplate().equals(nom)) {
				return temT;
			}
		}
		return null;
	}


	public ArrayList<Ordre> getListeOrdresMarcheDeLaRotation() {
		return listeOrdresMarcheDeLaRotation;
	}

	public void setListeOrdresMarcheDeLaRotation(ArrayList<Ordre> listeOrdresMarcheDeLaRotation) {
		this.listeOrdresMarcheDeLaRotation = listeOrdresMarcheDeLaRotation;
	}

	public void nettoyerListeDeBatiments(Travian t) {
		//netoyage de liste de batiments.
		for(Village village : t.getListeDeVillages()) {
		Iterator<Batiment> liste = village.getBatiments().iterator();
				while (liste.hasNext()) {
				Batiment bat =	liste.next();	
					if(bat.getNomBatiment().length() == 0) {
						liste.remove();
					}
			
			
		
		}
		}
		
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

}
