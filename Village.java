package botpackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Village {

	public Village(String nom, String url, int x, int y, ArrayList batiments, int bois, int argile, int fer,
			int cereales, int tokenconstruction, ArrayList constructionsEnCour, ArrayList batimentsEnFileDAttente,
			double levelPlaceTournoi, boolean champsFinis, int maxStockDepot, int maxStockSilo) {
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
		this.constructionsEnCour = constructionsEnCour;
		this.batimentsEnFileDAttente = batimentsEnFileDAttente;
		this.tokenconstruction = tokenconstruction;
		this.levelPlaceTournoi = levelPlaceTournoi;
		this.champsFinis = champsFinis;
	}

	public Village() {
		super();
	}

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

	public ArrayList getConstructionsEnCour() {
		return constructionsEnCour;
	}

	public ArrayList getBatimentsEnFileDAttente() {
		return batimentsEnFileDAttente;
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

	public void setConstructionsEnCour(ArrayList constructionsEnCour) {
		this.constructionsEnCour = constructionsEnCour;
	}

	public void setBatimentsEnFileDAttente(ArrayList batimentsEnFileDAttente) {
		this.batimentsEnFileDAttente = batimentsEnFileDAttente;
	}

	public int getTokenconstruction() {
		return tokenconstruction;
	}

	public void setTokenconstruction(int tokenconstruction) {
		this.tokenconstruction = tokenconstruction;
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

	public void setChampMin(int champMin) {
		this.champMin = champMin;
		// if (champMin <= 10 ){
		TeamplatesDeVillages template = new TeamplatesDeVillages();
		List<Batiment> tem = template.etablirTeamplatePourUnVillage(champMin);
		this.setTemplateDuVillage(tem);
		// }
	}

	public int getNombreDeMarchands() {
		return NombreDeMarchands;
	}

	public void setNombreDeMarchands(int nombreDeMarchands) {
		NombreDeMarchands = nombreDeMarchands;
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

	// TODO maxstock de base a corriger
	public int[] memoireMarcheDeLaRotation = { 0, 0, 0, 0 };
	public ArrayList<Ordre> listeOrdresMarcheDeLaRotation = new ArrayList<Ordre>();
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
	private ArrayList constructionsEnCour;
	private int tokenconstruction;
	private ArrayList batimentsEnFileDAttente;
	private double levelPlaceTournoi;
	private boolean champsFinis;
	private int besoinDeFete;
	private boolean villagePillage;
	private boolean villageCapitale;
	private boolean besoinDeNpc;
	private boolean besoinMarche;
	private int NombreDeMarchands;
	public int QuantiteMaxTransporteeParMarchands;
	private int phalanges;
	private int epees;
	private int spy;
	private int toutatis;
	private int heduins;
	private int druides;
	private int colons;
	private boolean cropDeath;
	private boolean besoinDeConstruction;
	private List<Batiment> batimentsDuTemplateDuVillage = new ArrayList<Batiment>();
	private int champMin;
	private int champMax;
	public boolean regimeGeneral = true;
	public int regimeMarcheBoisMax = 80;
	public int regimeMarcheArgileMax = 80;
	public int regimeMarcheFerMax = 80;
	public int regimeMarcheCerealesMax = 80;
	public int regimeMarcheBoisMin = 20;
	public int regimeMarcheArgileMin = 20;
	public int regimeMarcheFerMin = 20;
	public int regimeMarcheCerealesMin = 20;
	public Date marchéLastDate;
	public int marchédureeDuDernierAchat=0;
	public Date heureDeGuet;
	public List<AttaqueEntrante> attaquesSubies = new ArrayList<AttaqueEntrante>();
	
	
	

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
			
		 bois = t.getCompte().getDriver().findElement(By.xpath("//*[@id=\"l1\"]")).getText().replaceAll("[\\u202D\\u202C.]", "").replace(".", "").replace(" ", "");
		 stockBois = Integer.parseInt(bois);
		 argile = t.getCompte().getDriver().findElement(By.xpath("//*[@id=\"l2\"]")).getText().replaceAll("[\\u202D\\u202C.]", "").replace(".", "").replace(" ", "");
		 stockArgile = Integer.parseInt(argile);
		 fer = t.getCompte().getDriver().findElement(By.xpath("//*[@id=\"l3\"]")).getText().replaceAll("[\\u202D\\u202C.]", "").replace(".", "").replace(" ", "");
		 stockFer = Integer.parseInt(fer);
		 cereales = t.getCompte().getDriver().findElement(By.xpath("//*[@id=\"l4\"]")).getText().replaceAll("[\\u202D\\u202C.]", "").replace(".", "").replace(" ", "");
		 stockCereales = Integer.parseInt(cereales);
			
		}catch(Exception e) {
			
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
		 maxDepot = t.getCompte().getDriver().findElement(By.xpath("//*[@id=\"stockBarWarehouse\"]")).getText().replaceAll("[\\u202D\\u202C.]", ""); // code correspondant au whitespace causé par left to right \\u202D \\u202C
		 maxStockDepot = Integer.parseInt(maxDepot);
		}catch(Exception e) {
			//Methode ancienne, gardée pour voir sil change regulierement ce code pour deranger les bots
			maxDepot = t.getCompte().getDriver().findElement(By.xpath("//*[@id=\"stockBarWarehouse\"]")).getText().replace(" ", "");
			maxStockDepot = Integer.parseInt(maxDepot);
			}
		 

		String maxSilo;
		int maxStockSilo;
		try {
		 maxSilo = t.getCompte().getDriver().findElement(By.xpath("//*[@id=\"stockBarGranary\"]")).getText().replaceAll("[\\u202D\\u202C.]", "");
		 maxStockSilo = Integer.parseInt(maxSilo);
		}catch (Exception e) {
			//Methode ancienne, gardée pour voir sil change regulierement ce code pour deranger les bots
			maxSilo = t.getCompte().getDriver().findElement(By.xpath("//*[@id=\"stockBarGranary\"]")).getText().replace(" ", "");
			maxStockSilo = Integer.parseInt(maxSilo);
		}
		 

		village.setMaxStockDepot(maxStockDepot);
		village.setMaxStockSilo(maxStockSilo);

		t.ecrireDansConsole("Update Ressources de : " + village.getNom());

	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	void voirListeDeConstruction(Travian t) {
		Village village = t.villageEnCours();

		
		//////////////////////////////////////////////////////
		// se replacer sur la bonne page si un module est rester ailleur
		String urlTest = null;
		try {
			urlTest = t.getCompte().getDriver().getCurrentUrl().split(".php")[0].split(".fr/")[1];
		} catch (Exception e) {
			t.ecrireDansConsole("echec urlTest1 ");
		}

		if (!urlTest.contains("dorf1") && !urlTest.contains("dorf2")) {
			t.getCompte().getDriver().get(t.getCompte().getServer() + "dorf1.php");
			t.randomsleep.court();
		}
		
		
		
		List<WebElement> test = null;
		int constructionEnCours = 0;
		
		try {
			test = t.getCompte().getDriver().findElements(By.xpath("//*[@id=\"content\"]/div[2]/div[10]/ul/li"));

			if (test.size() < 1) {
				village.setTokenconstruction(constructionEnCours);
				t.ecrireDansConsole("Pas de construction en cours ");
			}

			if (test.size() >= 1) { // (test != null)
				t.ecrireDansConsole(test.size() + " Construction de  deja en cours");
				constructionEnCours = test.size();
				village.setTokenconstruction(constructionEnCours);
			}
		} catch (Exception e) {
			village.setTokenconstruction(constructionEnCours);
		}
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void voirTroupesDuVillage(Travian t) {
		
		//////////////////////////////////////////////////////
		// se replacer sur la bonne page si un module est rester ailleur
		String urlTest = null;
		try {
			urlTest = t.getCompte().getDriver().getCurrentUrl().split(".php")[0].split(".fr/")[1];
		} catch (Exception e) {
			t.ecrireDansConsole("echec urlTest1 ");
		}

		if (!urlTest.contains("dorf1")) {
			t.getCompte().getDriver().get(t.getCompte().getServer() + "dorf1.php");
			t.randomsleep.court();
		}
		
		
		// compte.getDriver().get("http://ts4.travian.fr/dorf1.php?newdid=6681&");
		Village village = t.villageEnCours();
		boolean troupesAQuai = false;
		//// *[@contains, "éclairs de Toutatis"]
		try {
			List<WebElement> troupesDuVillage = t.getCompte().getDriver().findElements(By.xpath("//*[@id=\"troops\"]/tbody/tr"));
			for (WebElement typeTroupe : troupesDuVillage) {
				boolean troupesPresentes = false; 
				String tableauTroupes[] = {"Imperians", "Equites Caesaris", "éclairs de Toutatis", "Combattants à l'épée"   };

				for (int i = 0; i < tableauTroupes.length; i++){
					if ( typeTroupe.findElement(By.className("un")).getText().contains(tableauTroupes[i])){
						troupesPresentes = true;

						int nombreTroupesPresentes = Integer.parseInt(typeTroupe.findElement(By.className("num")).getText());
						t.ecrireDansConsole("Type : "+tableauTroupes[i] +"--> "+ nombreTroupesPresentes );
						
						if (troupesPresentes == true) {
							village.setVillagePillage(true);
						}
						if (troupesPresentes && nombreTroupesPresentes >= 200) {
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
			t.ecrireDansConsole("Pas de Troupes -> pas de pillages");
		}

	}// fin

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	void chargerChamps(Travian t) {

		Village village = t.villageEnCours(); // pas utilisee ici

		//////////////////////////////////////////////////////
		// se replacer sur la bonne page si un module est rester ailleur
		String urlTest = null;
		try {
			urlTest = t.getCompte().getDriver().getCurrentUrl().split(".php")[0].split(".fr/")[1];
		} catch (Exception e) {
			t.ecrireDansConsole("echec urlTest1 ");
		}

		if (!urlTest.contains("dorf1")) {
			t.getCompte().getDriver().get(t.getCompte().getServer() + "dorf1.php");
			t.randomsleep.court();
		}
		//////////////////////////////////////////////////////

		List<WebElement> listeWebelementChamps = t.getCompte().getDriver()
				.findElements(By.xpath("//*[@id=\"rx\"]/area"));
		ArrayList<Integer> listeLevelsChamps = new ArrayList<Integer>();
		ArrayList<String> listeNomsChamps = new ArrayList<String>();

		// On verifie que lon est sur la page des champs de ressources
		if (t.getCompte().getDriver().getCurrentUrl().contains("dorf1.php")) {

			// On liste les elements necesaires a la comparaison des champs
			int i = 0;
			while (i < 18) {

				String nomChamp = listeWebelementChamps.get(i).getAttribute("alt");
				listeNomsChamps.add(nomChamp);
				listeLevelsChamps
				.add(Integer.parseInt(listeWebelementChamps.get(i).getAttribute("alt").split("Niveau ")[1]));
				i++;
				if (i == 18) {
					t.ecrireDansConsole("Liste des " + i + " champs : " + listeLevelsChamps + "");
				}
			}

			// On determine le niveau des champs le plus petit
			t.randomsleep.court();
			champMin = Collections.min(listeLevelsChamps);
			champMax = Collections.max(listeLevelsChamps);
			village.setChampMin(champMin);
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
			t.ecrireDansConsole("Min val: " + champMin +" Max val: "+champMax);
		}
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void chargerBatiments(Travian t) {

		if (!t.getCompte().getDriver().getCurrentUrl().contains("dorf2.php")) {
			t.randomsleep.court();
			t.getCompte().getDriver().get(t.getCompte().getServer() + "dorf2.php");
			t.randomsleep.court();
		}

		Village village = t.villageEnCours();
		List<WebElement> listeDesBatiments = t.getCompte().getDriver().findElements(By.xpath("//*[@id=\"clickareas\"]/area"));
		// on cree une lsite temporaire poure lenvoyer au village une fois la
		// liste complete.
		List<Batiment> listeDesBatimentsVillage = new ArrayList();

		for (WebElement webBatiment : listeDesBatiments) {
			// on intialise les varible
			String nomBatiment = null;
			int levelBatiment = 0;
			String slotBatiment = null;
			boolean trouver = false;

			// on les remplis
			try {
				nomBatiment = webBatiment.getAttribute("alt").split(" <span")[0];
				levelBatiment = Integer.parseInt(webBatiment.getAttribute("alt").split("<span class=\"level\">Niveau ")[1].split("</span>")[0]);
				// reperer conctructions en cours
				if (webBatiment.getAttribute("alt").contains("Amélioration en cours")) {
					int enCoursVersLevel = Integer.parseInt(webBatiment.getAttribute("alt").split("Amélioration en cours vers le niveau ")[1].split("</span>")[0]);
					levelBatiment = enCoursVersLevel;

				}
				slotBatiment = webBatiment.getAttribute("href").split("id=")[1];
				// si un slot est vide : on le nomme
			} catch (Exception e) {
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
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void monterChamps(Travian t) {

		Village village = t.villageEnCours();

		List<WebElement> listeWebelementChamps = t.getCompte().getDriver().findElements(By.xpath("//*[@id=\"rx\"]/area"));
		List<WebElement> listeWebelementChampsBis = t.getCompte().getDriver().findElements(By.xpath("//*[@id=\"village_map\"]/div"));
		//*[@id="village_map"]/div
		int token = village.getTokenconstruction();

		if (token < 2) {
			try { // secu anti rechargement
				// Lancer construction champs
				// trouver lien du premier plus petit
				int g = 0;
				while (g < 18) {
					// on met a jour le token apres une eventuelle construction
					village.voirListeDeConstruction(t);
					token = village.getTokenconstruction();
					// on reverifie le token pour pas boucler plus que
					// necessaire
					if (token < 2) {
						// On recharge la liste apres un eventuel rechargement
						listeWebelementChamps = t.getCompte().getDriver().findElements(By.xpath("//*[@id=\"rx\"]/area"));
						int lien = Integer.parseInt(listeWebelementChamps.get(g).getAttribute("alt").split("Niveau ")[1]); // bug
						// ici
						// au
						// retour
						// String lienNom =
						// listeWebelementChamps.get(g).getAttribute("alt").split("Niveau
						// ")[0];

						// t.ecrireDansConsole("valeur g : " + g);

						/// test
						/// ressources///////////////////////////////////////////////////////////////////////
						WebElement tagUnderConstruction = null;
						try {
							tagUnderConstruction = t.getCompte().getDriver().findElement(By.xpath("//*[@id=\"village_map\"]/div[" + (g + 1)+ "][contains(@class, 'underConstruction')]"));
						} catch (Exception e) {
						}
						if (lien == champMin && tagUnderConstruction == null) {
							boolean retrytoken = false;
							int boisNecessaire = 0;
							int argileNecessaire = 0;
							int ferNecessaire = 0;
							int cerealesNecessaire = 0;
							t.ecrireDansConsole("try lien==chamPmin : " + lien + " et : " + champMin);

							// survol souris du champs = a champMin
							Actions builder = new Actions(t.getCompte().getDriver());
							try {
							builder.moveToElement(listeWebelementChampsBis.get(g+1));
							}catch (Exception e1){
								builder.moveToElement(listeWebelementChamps.get(g+1));}

							builder.perform();
							t.randomsleep.court();

							// choper le tableau des ressources necessaires pour
							// le champs en cours
							List<WebElement> ressourcesNecessaires = listeWebelementChamps.get(g + 1).findElements(By.xpath("//*[@class='showCosts']/span")); ////*[@id="mainLayout"]/body/div[2]   ////*[@class='showCosts']/span

							// t.ecrireDansConsole("valeur ressourcesnecessaire
							// "+ ressourcesNecessaires.get(0).getText());
							// t.ecrireDansConsole("valeur ressourcesnecessaire
							// "+ ressourcesNecessaires.get(1).getText());
							// t.ecrireDansConsole("valeur ressourcesnecessaire
							// "+ ressourcesNecessaires.get(2).getText());
							// t.ecrireDansConsole("valeur ressourcesnecessaire
							// "+ ressourcesNecessaires.get(3).getText());

							// correction bug de MouseHover
							if (ressourcesNecessaires.size()==0) {   // if (ressourcesNecessaires.get(0).getText().isEmpty())
								retrytoken = true;
							}
							if (retrytoken == true) {
								t.ecrireDansConsole("Retry hover");
								Actions retry = new Actions(t.getCompte().getDriver());
								retry.moveToElement(listeWebelementChamps.get(g));
								retry.perform();
								t.randomsleep.court();
								ressourcesNecessaires = listeWebelementChamps.get(g).findElements(By.xpath("//*[@class='showCosts']/span"));
								// t.ecrireDansConsole("valeur
								// ressourcesnecessaire "+
								// ressourcesNecessaires.get(0).getText());
								// t.ecrireDansConsole("valeur
								// ressourcesnecessaire "+
								// ressourcesNecessaires.get(1).getText());
								// t.ecrireDansConsole("valeur
								// ressourcesnecessaire "+
								// ressourcesNecessaires.get(2).getText());
								// t.ecrireDansConsole("valeur
								// ressourcesnecessaire "+
								// ressourcesNecessaires.get(3).getText());
								retrytoken = false;
							}

							if (retrytoken == false) {
								// Parse
								boisNecessaire = Integer.parseInt(ressourcesNecessaires.get(0).getText());
								argileNecessaire = Integer.parseInt(ressourcesNecessaires.get(1).getText());
								ferNecessaire = Integer.parseInt(ressourcesNecessaires.get(2).getText());
								cerealesNecessaire = Integer.parseInt(ressourcesNecessaires.get(3).getText());
								t.ecrireDansConsole("parse ok");
							}
							// On fait la comparaison des ressources avec le
							// stock du village en cours
							// Village2 village = villageEnCours();
							village.updateRessources(t);
							int stockBois = village.getBois();
							int stockArgile = village.getArgile();
							int stockFer = village.getFer();
							int stockCereales = village.getCereales();

							// si ressources ok
							if (stockBois >= boisNecessaire && stockArgile >= argileNecessaire && stockFer >= ferNecessaire && stockCereales >= cerealesNecessaire) {
								t.ecrireDansConsole("ressource ok");
								// go la page si //*[@id="stockBarFreeCrop"]

								listeWebelementChamps.get(g).click();
								t.randomsleep.court();
								// trouver le bouton vert
								WebElement bouttonvert = null;
								try {
									bouttonvert = t.getCompte().getDriver().findElement(By.xpath("//button[@class=\"green build\"]"));
								} catch (Exception e) {
									t.ecrireDansConsole("Bouton vert non present => Batiment en cour probable ou pas de cereales dispo pour la construction");
									t.getCompte().getDriver().get(t.getCompte().getServer() + "dorf1.php");
									t.randomsleep.classic();
									int cropSlot = Integer.parseInt(t.getCompte().getDriver().findElement(By.xpath("//*[@id=\"stockBarFreeCrop\"]")).getText().trim());
									if (cropSlot > 3) {
										break;// non teste
									}
								}
								// cliquer sur le bouton vert
								t.randomsleep.classic();
								if (bouttonvert != null) {
									bouttonvert.click();
									t.ecrireDansConsole("Lancement d'un Champs de (valeur g) " + g + " (g-1) sur le Slot " + (g + 1) + "");
									t.randomsleep.court();
								}

							} else {
								t.ecrireDansConsole("ressource manquante");
							}
						} // fin if lien== champMin
						g++;
					} // fin if token de verification
					else {
						t.ecrireDansConsole("2 Champs lance");
						break;
					}
				} // fin while g <18
			} catch (Exception e) {
				t.ecrireDansConsole("Les Retours Pillage cause un echec");
			}
		} // fin if token <2
		village.voirListeDeConstruction(t);

	}// fin monterchamps

	/* } */

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
	public boolean construireBatiments(String batimentAConstruire, int levelVoulu, Travian t) {
		t.randomsleep.court();

		// if (!compte.getDriver().getCurrentUrl().contains("dorf2.php"))
		// {compte.getDriver().get(compte.getServer() + "dorf2.php");}
		// randomsleep.court();
		Village village = t.villageEnCours();
		updateRessources(t);

		int boisNecessaire = 0;
		int argileNecessaire = 0;
		int ferNecessaire = 0;
		int cerealesNecessaire = 0;
		boolean possibleOuPas = true;

		List<WebElement> listeDesBatiments = t.getCompte().getDriver().findElements(By.xpath("//*[@id=\"clickareas\"]/area"));
		List<Batiment> batimentsDeLaPage = new ArrayList<Batiment>(); //TODO verifier que ca n'add pas des villages sur la meme liste au court des rotation et session
	
		// WebElement areaBatiment;

		for (WebElement webBatiment : listeDesBatiments) {
			try {
				String nom = webBatiment.getAttribute("alt").split(" <span")[0];
				int level = Integer.parseInt(webBatiment.getAttribute("alt").split("<span class=\"level\">Niveau ")[1].split("</span>")[0]);
				
				// on corrige le level si un level est en cour de consrtuction
				try {
					int levelSuivantDispo = 0;
					levelSuivantDispo = Integer.parseInt(webBatiment.getAttribute("alt").split("Coût pour le niveau ")[1].split(":<br")[0]);
					level = (levelSuivantDispo - 1); //level en cours
				}catch(Exception e){/* t.ecrireDansConsole("Echec levelSuivantDispo de construire batiment");*/} //Coét pour le niveau 8:
				
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

				if (level < levelVoulu && village.getTokenconstruction() < 2) {

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

							if (as.getAttribute("alt").contains(construire1.getNomBatiment())
									&& as.getAttribute("href").split("id=")[1].contains(construire1.getSlotBatiment())
									&& village.getTokenconstruction() < 2) {
								boisNecessaire = Integer.parseInt(
										as.getAttribute("alt").split("r1\" src=\"img/x.gif\" />")[1].split("</span>")[0]
												.trim());
								argileNecessaire = Integer.parseInt(
										as.getAttribute("alt").split("r2\" src=\"img/x.gif\" />")[1].split("</span>")[0]
												.trim());
								ferNecessaire = Integer.parseInt(
										as.getAttribute("alt").split("r3\" src=\"img/x.gif\" />")[1].split("</span>")[0]
												.trim());
								cerealesNecessaire = Integer.parseInt(
										as.getAttribute("alt").split("r4\" src=\"img/x.gif\" />")[1].split("</span>")[0]
												.trim());
								t.ecrireDansConsole("[construireBatiment]parse ok");

								// on fais la comparaison des ressources avec le
								// stock du village en cours
								updateRessources(t);
								int stockBois = village.getBois();
								int stockArgile = village.getArgile();
								int stockFer = village.getFer();
								int stockCereales = village.getCereales();
								// si ressources ok
								if (stockBois >= boisNecessaire && stockArgile >= argileNecessaire
										&& stockFer >= ferNecessaire && stockCereales >= cerealesNecessaire) {
									t.ecrireDansConsole("[construireBatiment] Ressources ok");
									// go la page
									as.click();
									t.randomsleep.court();

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
										t.ecrireDansConsole("bug :)");
									}

									// cliquer sur le bouton vert
									WebElement bouttonvert = null;
									try {
										bouttonvert = t.getCompte().getDriver().findElement(By.xpath("//button[@class=\"green build\"]"));
									} catch (Exception e) {
										t.ecrireDansConsole("[construireBatiment] Bouton vert non present => Champ en cour probable");
										possibleOuPas = false;
										t.getCompte().getDriver().get(t.getCompte().getServer() + "dorf2.php");
										t.randomsleep.classic();
										break;
									}

									if (bouttonvert != null) {
										bouttonvert.click();
										t.ecrireDansConsole("[construireBatiment] Lancement " + batimentAConstruire);
										possibleOuPas = true;
										t.randomsleep.court();
										listeDesBatiments = t.getCompte().getDriver().findElements(By.xpath("//*[@id=\"clickareas\"]/area"));
										break;
									}
								} else {
									t.ecrireDansConsole("[construireBatiment] Pas assez de Ressources pour faire un/une "+ batimentAConstruire);
								}
							}
						} // break;}
					} catch (Exception e) {
						t.ecrireDansConsole("[construireBatiment] Batiment de niveau deja en construction ou deja au level demande "+ batimentAConstruire);
						voirListeDeConstruction(t);
					}

				} else {
					t.ecrireDansConsole("[construireBatiment] " + batimentAConstruire + " deja a 20");
					possibleOuPas = false;
				}

			}

		}
		voirListeDeConstruction(t);
		return possibleOuPas;

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
			List<WebElement> listeDesBatiments = t.getCompte().getDriver()
					.findElements(By.xpath("//*[@id=\"clickareas\"]/area"));
			int hotelNonPresent = 1;

			for (WebElement batiment : listeDesBatiments) {
				if (batiment.getAttribute("alt").contains("Hôtel de Ville")) {
					hotelNonPresent = 0;
					batiment.click();

					t.randomsleep.court();

					// on fait une liste des boutons de lancement de fete
					List<WebElement> boutons = null;
					try {
						boutons = t.getCompte().getDriver().findElements(By.xpath("//*[@value=\"Organiser\"]"));
					} catch (Exception e) {
						t.ecrireDansConsole("[Fete] Erreure de listage des boutons Fete ");
					}

					// on verifie si des boutons de lancement de fetes sont
					// present
					if (boutons.size() > 0) {
						// on tente une grande fete d'abord
						try {
							if (boutons.get(1).getText().contains("Organiser")) {
								boutons.get(1).click();
								t.ecrireDansConsole("[Fete] Grande fete lancee");
								t.randomsleep.court();
							}
						} catch (Exception e) {
						}
						// puis sinon on tente une ptite fete
						try {
							if (boutons.get(0).getText().contains("Organiser")) {
								boutons.get(0).click();
								t.ecrireDansConsole("[Fete] Petite fete lancee");
								t.randomsleep.court();
							}
						} catch (Exception e) {
						}

					} else {
						t.ecrireDansConsole("[Fete] Une Fete Est Deja en cours");
					}

					break;
				}

			}
			if (hotelNonPresent == 1) {
				t.ecrireDansConsole("[Fete] Pas D'hotel de ville");
			}
		} catch (Exception e) {
			t.ecrireDansConsole("[Fete] echec lancer fete interne");
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
		if (t.bot.monterChampsCapitale == false){t.ecrireDansConsole("Monter champs Capitale > 10 désactivé... ");}
		if (champMin < 10 || village.getVillageCapitale() && t.bot.monterChampsCapitale == true) {
			monterChamps(t);
		}

		if (village.getTokenconstruction() < 2 && village.getChampMin() <= 10
				|| village.getTokenconstruction() < 2 && village.getVillageCapitale() == true) {
			chargerBatiments(t);
			// try {
			for (int i = 0; i <= 1 && village.getTokenconstruction() < 2; i++) {

				// chargerBatiments(t);
				for (Batiment batimentDuTemplate : village.getTemplateDuVillage()) {
					boolean trouver = false;
					// on se remet sur la page au cas ou un echec des boucles
					// plus bas
					if (!t.getCompte().getDriver().getCurrentUrl().contains("dorf2.php")) {
						t.randomsleep.court();
						t.getCompte().getDriver().get(t.getCompte().getServer() + "dorf2.php");
						t.randomsleep.court();
					}
					for (Batiment batimentDuVillage : village.getBatiments()) {
						if (village.getTokenconstruction() < 2) {
							if (batimentDuVillage.getNomBatiment().equals(batimentDuTemplate.getNomBatiment())) {
								trouver = true;
								if (batimentDuVillage.getLevelBatiment() < batimentDuTemplate.getLevelBatiment()) {
									construireBatiments(batimentDuTemplate.getNomBatiment(),
											batimentDuTemplate.getLevelBatiment(), t);

								}
							}
						}

					}
					////// TODO Module de construction de batiments du template
					////// inexistant sur le village

					if (trouver == false) {
						t.ecrireDansConsole(batimentDuTemplate.getNomBatiment() + " ---> pas trouve");// PAS

					} // fin trouver == false
				} // fin du for (Batiment batimentDuteamplate :
				// village.getTemplateDuVillage()){
				// }catch (Exception e) {t.ecrireDansConsole(": Batiment absent
				// sur palier 1");}
			}
		}
		creationBatiment(t, village);
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
		int tokenDeChangement = 0;
		if(village.getTokenconstruction() < 2){
			t.ecrireDansConsole("Essai de création de batiments :");
			boolean trouver = false;
			boolean slotDispo = false;
			String nomBat = null;

			/////
			for(Batiment slot : village.getBatiments()){
				// on regarde si un slot est dispo pour plus tard, au cas ou. 
				if (slot.getNomBatiment().contains("Site de construction")) {
					slotDispo = true;	
					t.ecrireDansConsole("Slot libre = oui");
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
					t.ecrireDansConsole(nomBat+" trouvé dans le village.");
					batimentDuTemplate.setPresent(true);
				}

			}




			// on regarde la necessité d'essayer de contruire un nouveau batiment
			trouver = true;
			for(Batiment batimentDuTemplate :  batimentsDuTemplateDuVillage){

				nomBat = batimentDuTemplate.getNomBatiment() ;
				// on test les cas problematique
				if(nomBat.equals("Résidence") || nomBat.equals("Palais") || nomBat.equals("Tailleur de Pierres")|| nomBat.contains("Grand silo de céréales") || nomBat.contains("Grand dépôt de ressources") || nomBat.contains("Chambre aux trésors")){
					t.ecrireDansConsole(nomBat+" trouvé dans le template. -> ne rien faire");				
				}else {
					if(batimentDuTemplate.getPresent() == false ){
						trouver = false;
					}
				}
			}



			// onconfirme la necessité et on continue
			if (trouver == false && slotDispo == true){
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

				// on clique sur le slot libre 
				WebElement leBat = t.getCompte().getDriver().findElement(By.xpath("//*[@href=\"build.php?id=" + leSlot.getSlotBatiment() + "\"]"));
				leBat.click();
				t.randomsleep.court();








				// on va chercher si un batiment peut etre construit 
				List<WebElement> listOngletsBats = t.getCompte().getDriver().findElements(By.xpath("//*[@class=\"tabItem\"]"));
				int i2 = 1;
				if(trouver == false){
					while (i2 <= listOngletsBats.size()){


						if (trouver == false) {
							if(i2> 1 && i2 <= listOngletsBats.size()){
								listOngletsBats.get(i2-1).click();
								t.ecrireDansConsole("---------Changement d'onglet---------");
								//on recharge les onglets de la nouvelle page
								listOngletsBats = t.getCompte().getDriver().findElements(By.xpath("//*[@class=\"tabItem\"]"));
							} 


							for(Batiment batimentDuTemplate : village.getBatimentsDuTemplateDuVillage()){
								nomBat = batimentDuTemplate.getNomBatiment();
								if(nomBat.equals("Résidence") || nomBat.equals("Palais") || nomBat.equals("Tailleur de Pierres")|| nomBat.contains("Grand silo de céréales") || nomBat.contains("Grand dépôt de ressources") || nomBat.contains("Chambre aux trésors")){
									t.ecrireDansConsole(nomBat+" trouvé dans le template. -> ne rien faire 2 "); 

								}else {

									if(batimentDuTemplate.getPresent() == false){

										List<WebElement> listWebBats = t.getCompte().getDriver().findElements(By.xpath("//*[@class=\"buildingWrapper\"]"));


										for (WebElement webBat : listWebBats) {

											if(trouver == true){break;}

											String titre = webBat.getText().split("\\n")[0]; 
											if (titre.toLowerCase().contains(nomBat.toLowerCase())) {
												t.ecrireDansConsole(nomBat+" ////////// tentative pour contruction"); 
												try {
													WebElement boutton = webBat.findElement(By.xpath("//*[@class='buildingWrapper' and contains(., 'Construire le bâtiment.') and contains(., '"+ titre +"')]//div[@class='button-content']"));

													if (boutton.getText().contains("Construire le bâtiment.")) {
														t.randomsleep.court();
														boutton.click();
														trouver = true;
														t.ecrireDansConsole(nomBat +" lancé. Debug : Par titre");
														break;
													}

												}catch (Exception e) {
													t.ecrireDansConsole("Echec par Titre");
													try {
													WebElement boutton = webBat.findElement(By.xpath("//*[@class='buildingWrapper' and contains(., 'Construire le bâtiment.') and contains(., '"+ nomBat +"')]//div[@class='button-content']"));
													if (boutton.getText().contains("Construire le bâtiment.")) {
														t.randomsleep.court();
														boutton.click();
														trouver = true;
														t.ecrireDansConsole(nomBat +" lancé. Debug : Par nomBat");
														break;
													}
													}catch (Exception e1) {
													t.ecrireDansConsole("Echec par nomBat");
													t.ecrireDansConsole(nomBat + " --> echec Pas dispo a la construction sur page manque ressources ou prerequis "+ i2 +" Debug info : "+" nomBat ="+nomBat+" Titre.toLowerCase ="+ titre.toLowerCase() +" Titre normal ="+ titre );
													}
												}//fin catch
											}else {t.ecrireDansConsole(nomBat +" pas dispo sur ce webB ");} //fin if

										} //fin for webBat
										if (trouver == false){t.ecrireDansConsole(nomBat +" pas dispo sur l'onglet "+i2);}
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
					if (trouver == false && i2>=4){ // si trouver ==false  on quitte la fenetre pour se remmetre sur la page batiments du village pour les autre fonctions
						t.ecrireDansConsole("Aucun batiments dispo sur les 3 onglets");
						// on se remet sur la page du village pour les autre fonctions
						try {
							t.getCompte().getDriver().findElement(By.xpath("//*[@id='closeContentButton']")).click();//*[@id="closeContentButton"]
						}catch (Exception e){ t.ecrireDansConsole("Echec //*[@id='closeContentButton'] ");}
					} else {t.ecrireDansConsole("Terminé");}
				}//fin if  trouver == false
				//on reset le trouver pour les autre batiments du template
				trouver = false;


			} // fin if (trouver == false && slotDispo == true){




		} // fin if token < 2
		//	else {break;}
	} //fin

	/*
	t.ecrireDansConsole(batimentDuTemplate.getNomBatiment() + " ---> boucle CreationBatiment");// PAS
	// TROUVE);
	// if (batimentDuteamplate.getNomBatiment().equals("Résidence") &&
	// village.getVillageCapitale() == true){}
	for (Batiment bat : village.getBatiments()) {
		if (!t.getCompte().getDriver().getCurrentUrl().contains("dorf2.php")) {
			t.randomsleep.court();
			t.getCompte().getDriver().get(t.getCompte().getServer() + "dorf2.php");
			t.randomsleep.court();
		}
		if (bat.getNomBatiment().contains("Site de construction")) {
			WebElement leBat = t.getCompte().getDriver()
					.findElement(By.xpath("//*[@href=\"build.php?id=" + bat.getSlotBatiment() + "\"]"));
			leBat.click();// t.getCompte().getDriver().get
			t.randomsleep.court();
			List<WebElement> listOngletsBats = t.getCompte().getDriver().findElements(By.xpath("//*[@class=\"tabItem\"]"));
			List<WebElement> listWebBats = t.getCompte().getDriver().findElements(By.xpath("//*[@class=\"buildingWrapper\"]"));

			for (WebElement webBat : listWebBats) {
				String titre = webBat.getText(); 
				if (titre.contains(nomBat)) {
					List<WebElement> listDeBoutton = webBat.findElements(By.xpath("//*[@class=\"buildingWrapper\"]"));
				}

				// Les choix de la page de construction :
				// TODO charger les onglets plutot que les parcourir un a un et
				// faire un systeme qui sait ou le batiment est.
				// bien relire

				int i2 = 0;
				while (trouver == false) {
					i2++;
					List<WebElement> listOngletsBats = t.getCompte().getDriver().findElements(By.xpath("//*[@class=\"tabItem\"]"));
					List<WebElement> listWebBats = t.getCompte().getDriver().findElements(By.xpath("//*[@class=\"buildingWrapper\"]"));
					for (WebElement webBat : listWebBats) {
						// on recharge.
						listOngletsBats = t.getCompte().getDriver().findElements(By.xpath("//*[@class=\"tabItem\"]"));
						listWebBats = t.getCompte().getDriver()
								.findElements(By.xpath("//*[@class=\"buildingWrapper\"]"));

						// *[@class="buildingWrapper" and contains(.,
						// 'construire le bâtiment.') and contains(., 'Silo')]
						// // // //*[@class="buildingWrapper" and contains(.,
						// 'construire le bâtiment.') and contains(., 'Silo')]
						String titre = webBat.getText(); // t.getCompte().getDriver().findElement(By.xpath(""));
						// //*[@class="buildingWrapper"]//div[@class="button-content"]
						if (titre.contains(batimentDuTemplate.getNomBatiment())) {
							List<WebElement> listDeBoutton = webBat
									.findElements(By.xpath("//*[@class=\"buildingWrapper\"]")); // prends
							// le
							// premier
							// bouton,
							// a
							// preciser
							// via
							// la
							// recherche
							// du
							// texte
							// du
							// boutton
							for (WebElement boutton : listDeBoutton) {
								if (boutton.getText().contains("construire le bâtiment.")) {
									t.randomsleep.court();
									boutton.click();
									trouver = true;
									t.randomsleep.court();

									chargerBatiments(t);
									voirListeDeConstruction(t);
									t.ecrireDansConsole("[construireBatiment] ->  Creation Batiment : "
											+ batimentDuTemplate.getNomBatiment());

									break;
								}
							}
						}
					}
					if (trouver == false && i2 < listOngletsBats.size()) {
						listOngletsBats.get(i2).click();
						t.ecrireDansConsole("---------Changement d'onglet---------");
					} else {
						t.ecrireDansConsole("Debug : break 1");
						break;

					}

					// *[@value="construire le bétiment."]

				}
			}
			t.ecrireDansConsole("Debug : break 2");
			// break;

		}

	 */


	public ArrayList<Ordre> getListeOrdresMarcheDeLaRotation() {
		return listeOrdresMarcheDeLaRotation;
	}

	public void setListeOrdresMarcheDeLaRotation(ArrayList<Ordre> listeOrdresMarcheDeLaRotation) {
		this.listeOrdresMarcheDeLaRotation = listeOrdresMarcheDeLaRotation;
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

}
