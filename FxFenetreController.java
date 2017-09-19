package botpackage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import org.fxmisc.flowless.VirtualizedScrollPane;
import org.fxmisc.richtext.StyleClassedTextArea;


import javafx.application.Platform;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.effect.Bloom;
import javafx.scene.effect.BoxBlur;

import javafx.scene.effect.Glow;
import javafx.scene.effect.Lighting;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import javafx.scene.layout.FlowPane;

import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


//fx:controller="botpackage.FxFenetreController"
public class FxFenetreController extends ScrollPane {
	public Lancerbot bot;
	
	FxFenetreController fxFenetreController;
	// FxConsole console;
	// FxConsoleSimple console;
	fxConsoleExperimentale console;
	VirtualizedScrollPane<StyleClassedTextArea> vtScroll;
	GestionnaireDeComptes gestionnaireDeComptes = new GestionnaireDeComptes();
	
	String compteSelectionne = null;



    @FXML
    private ResourceBundle resources;

	@FXML
	private URL location;
	
	@FXML
	private TilePane comptesTilePane;

	@FXML
	private ScrollPane rootScrollpane;

	@FXML
	private BorderPane borderPane;

	@FXML
	public Button boutonOn;

	@FXML
	public Button boutonOff;

	@FXML
	private Button bypassPause;



	@FXML
	private FlowPane lesCheckBoxs;

	@FXML
	private CheckBox casePillage;

	@FXML
	private CheckBox caseFetes;

	@FXML
	private CheckBox caseConstruireBatiment;
	
	@FXML
	private CheckBox monterChampCapitale;

	@FXML
	private CheckBox caseEvacuerRessGrosVillages;

	@FXML
	private CheckBox caseApproPetitsVillages;

	@FXML
	private CheckBox caseNpc;

	@FXML
	private CheckBox caseOptimiserProdHero;
	
	@FXML
	private CheckBox caseFaireAventures;

	@FXML
	private TabPane tabbedPane;

	@FXML
	public ScrollPane fxConsolescrollpane;

	@FXML
	public VBox vbox;

	@FXML
	private CheckBox caseFaireDefiler;

	@FXML
	private CheckBox caseRotationVillage;

	// village
	@FXML
	public VBox villageAnchorPane;

	// l'include

	@FXML
	private FxOngletParametresController fxOngletParametresController;
	
	@FXML
	private TroisChampsDeSaisieController troisChampsDeSaisieController;

	/////
	@FXML
	void initialize() throws IOException {
		this.fxFenetreController = this;
		assert rootScrollpane != null : "fx:id=\"rootScrollpane\" was not injected: check your FXML file 'fxFenetre.fxml'.";
		assert borderPane != null : "fx:id=\"borderPane\" was not injected: check your FXML file 'fxFenetre.fxml'.";
		assert boutonOn != null : "fx:id=\"boutonOn\" was not injected: check your FXML file 'fxFenetre.fxml'.";
		assert boutonOff != null : "fx:id=\"boutonOff\" was not injected: check your FXML file 'fxFenetre.fxml'.";
		assert bypassPause != null : "fx:id=\"bypassPause\" was not injected: check your FXML file 'fxFenetre.fxml'.";
		
		assert lesCheckBoxs != null : "fx:id=\"lesCheckBoxs\" was not injected: check your FXML file 'fxFenetre.fxml'.";
		assert casePillage != null : "fx:id=\"casePillage\" was not injected: check your FXML file 'fxFenetre.fxml'.";
		assert caseFetes != null : "fx:id=\"caseFetes\" was not injected: check your FXML file 'fxFenetre.fxml'.";
		assert caseConstruireBatiment != null : "fx:id=\"caseConstruireBatiment\" was not injected: check your FXML file 'fxFenetre.fxml'.";
		assert caseEvacuerRessGrosVillages != null : "fx:id=\"vbox\" was not injected: check your FXML file 'fxFenetre.fxml'.";
		assert caseApproPetitsVillages != null : "fx:id=\"caseFaireDefiler\" was not injected: check your FXML file 'fxFenetre.fxml'.";
		assert tabbedPane != null : "fx:id=\"tabbedPane\" was not injected: check your FXML file 'fxFenetre.fxml'.";
		assert fxConsolescrollpane != null : "fx:id=\"fxConsolescrollpane\" was not injected: check your FXML file 'fxFenetre.fxml'.";
		assert vbox != null : "fx:id=\"vbox\" was not injected: check your FXML file 'fxFenetre.fxml'.";
		assert caseFaireDefiler != null : "fx:id=\"caseFaireDefiler\" was not injected: check your FXML file 'fxFenetre.fxml'.";
		assert comptesTilePane != null : "fx:id=\"comptesTilePane\" was not injected: check your FXML file 'fxFenetre.fxml'.";

		
		console = new fxConsoleExperimentale(fxFenetreController); // console.start();
		bot = new Lancerbot();
		bot.setConsole(console);
		bot.setfxFenetreController(this);
		fxConsolescrollpane();
		casesInit();
		fxOngletParametresController.setBot(bot);
		

		

	}

	@FXML
	private void casesInit() {
		if (bot.pillage == true) {
			// casePillage.isSelected();
			casePillage.setSelected(true);
		} else
			casePillage.setSelected(false);

		if (bot.faireFete == true) {
			// casePillage.isSelected();
			caseFetes.setSelected(true);
		} else
			caseFetes.setSelected(false);

		if (bot.construireBatiments == true) {
			// casePillage.isSelected();
			caseConstruireBatiment.setSelected(true);
		} else
			caseConstruireBatiment.setSelected(false);

		if (bot.evacuerSurplusRessources == true) {
			caseEvacuerRessGrosVillages.setSelected(true);
		} else
			caseEvacuerRessGrosVillages.setSelected(false);

		if (bot.approPetitsVillages == true) {
			caseApproPetitsVillages.setSelected(true);
		} else
			caseApproPetitsVillages.setSelected(false);

		if (bot.optimiserProdHero == true) {
			caseOptimiserProdHero.setSelected(true);
		} else
			caseOptimiserProdHero.setSelected(false);

		if (bot.rotationVillage == true) {
			caseRotationVillage.setSelected(true);
		} else
			caseRotationVillage.setSelected(false);

		if (bot.npc == true) {
			// casePillage.isSelected();
			caseNpc.setSelected(true);
		} else
			caseNpc.setSelected(false);

		if (bot.faireDefiler == true) {
			// casePillage.isSelected();
			caseFaireDefiler.setSelected(true);
		} else
			caseFaireDefiler.setSelected(false);
		
		if (bot.monterChampsCapitale == true) {
			// casePillage.isSelected();
			monterChampCapitale.setSelected(true);
		} else
			monterChampCapitale.setSelected(false);
		
		if (bot.faireAventures == true) {
			// casePillage.isSelected();
			caseFaireAventures.setSelected(true);
		} else
			caseFaireAventures.setSelected(false);
		
	}
	
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////LOGIN SERVER  ETC 
	

	///////////////////////////////////////////////////////////////////////////////////////////////////////////////// caseRotationVillage  
	@FXML
	private void casePillage() {
		if (bot.pillage == true) {
			bot.pillage = false;
		} else {
			bot.pillage = true;
		}
	}

	@FXML
	private void caseFetes() {
		if (bot.faireFete == true) {
			bot.faireFete = false;
		} else {
			bot.faireFete = true;
		}
	}

	@FXML
	private void caseConstruireBatiment() {
		if (bot.construireBatiments == true) {
			bot.construireBatiments = false;
		} else {
			bot.construireBatiments = true;
		}

	}
	
	@FXML
	private void caseMonterChampCapitale(){
		if (bot.monterChampsCapitale == true){
			bot.monterChampsCapitale = false;
		}else {
			bot.monterChampsCapitale = true;
			}
		}
		
	

	@FXML
	private void caseEvacuerRessGrosVillages() {
		if (bot.evacuerSurplusRessources == true) {
			bot.evacuerSurplusRessources = false;
		} else {
			bot.evacuerSurplusRessources = true;
		}
	}

	@FXML
	private void caseNpc() {
		if (bot.npc == true) {
			bot.npc = false;
		} else {
			bot.npc = true;
		}
	}

	@FXML
	private void caseApproPetitsVillages() {
		if (bot.approPetitsVillages == true) {
			bot.approPetitsVillages = false;
		} else {
			bot.approPetitsVillages = true;
		}
	}

	@FXML
	private void caseOptimiserProdHero() {
		if (bot.optimiserProdHero == true) {
			bot.optimiserProdHero = false;
		} else
			bot.optimiserProdHero = true;
	}

	@FXML
	private void caseRotationVillage() {
		if (bot.rotationVillage == true) {
			bot.rotationVillage = false;
		} else
			bot.rotationVillage = true;
	}

	@FXML
	private void npc() {
		if (bot.pillage == true) {
			bot.pillage = false;
		} else {
			bot.pillage = true;
		}
	}
	
	@FXML
	private void caseFaireAventures(){
		if (bot.faireAventures == true) {
			bot.faireAventures = false;
		}else
			bot.faireAventures = true;
	}
	
	

	@FXML
	private void bypassPause() {
		bot.annulerPause();
	}

	@FXML
	private void boutonOn() {
		// System.out.println("on");
		String nomDeCompte = compteSelectionne;
	//	bot.setfxFenetreController(this); // redondant ? utile ?
		String s = troisChampsDeSaisieController.serveur.getText();
		String n = troisChampsDeSaisieController.userName.getText();
		String m = troisChampsDeSaisieController.motDePasse.getText();
		if(compteSelectionne != null){
		bot.lancerTravian(nomDeCompte, s, n, m);
		}else {try {
			console.flux.envoyer(fxFenetreController, "Pas de compte selectionne... Veuillez selectionner un compte.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}
	}

	@FXML
	private void boutonOff() {
		// System.out.println("off");
		bot.eteindreTravian();

	}

	@FXML
	private void caseFaireDefiler() {
		// console.
		if (bot.faireDefiler == true) {
			bot.faireDefiler = false;
		} else {
			bot.faireDefiler = true;
		}

	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void faireTuileDeCompte(File compte){
		
		 Platform.runLater(new Runnable() {
			 
			 public void run() {
				
				 
				 String textDeBoutton = "Selectionner";
				 boolean s = false;
				 try {
				 if(compteSelectionne.equals(compte.getName())) {
					 textDeBoutton = "En cours...";
					 s = true;
					 } 
				 
				 
				 }catch (Exception e) {}
				 
		 BorderPane  vpane = new BorderPane();
	       
		 Button button1 = new Button(textDeBoutton); //compteSelectionne=compte.getName()
		 button1.setOnAction(new EventHandler<ActionEvent>() {
			    @Override public void handle(ActionEvent e) {
			        button1.setText("En cours");
			        
			        
			        compteSelectionne = compte.getName();
			        //update de cochon
			        fxChargerComptes();
			        
			    }
			});
		 
		 Label titre = new Label(compte.getName());

	       // vpane.getChildren().add(button1);
	       // vpane.getChildren().add(titre);
	        titre.getStyleClass().add("ctitre");
	        button1.getStyleClass().add("cbutton1");
	      //  titre.setAlignment(Pos.TOP_LEFT); //setAlignment(Pos.CENTER);
	        vpane.setTop(titre);
	        vpane.setBottom(button1);
	        button1.setPadding(new Insets(5, 5, 5, 5));
	        BorderPane.setMargin(button1, new Insets(2, 2, 2, 2));
	        
	        //comptesTilePane.getChildren().add(button1);
	        comptesTilePane.getChildren().add(vpane);
			
	        comptesTilePane.setPadding(new Insets(10, 10, 10, 10));
			comptesTilePane.setVgap(5);
			comptesTilePane.setHgap(5);
			comptesTilePane.setPrefColumns(13);
			
			vpane.getStyleClass().clear();
	        if (s == true) {vpane.getStyleClass().add("ctuile");
		 	}else {vpane.getStyleClass().add("ctuileb");}
	        

			
	        vpane.setMinHeight(100);
			vpane.setMinWidth(150);
		//	ObservableList list = comptesTilePane.getChildren(); 
			//TilePane.setAlignment(vpane, Pos.BOTTOM_RIGHT);
			//	list.addAll(vpane);
			
			 }
		 });
		
	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public VBox stc() throws IOException {
		  FXMLLoader loader = new FXMLLoader(
		    getClass().getResource(
		      "troisChampsDeSaisie.fxml"
		    )
		  );  
		  //loader.setController(troisChampsDeSaisieController);
		     VBox p = loader.load();
		     troisChampsDeSaisieController = loader.getController();//setBot(bot);
			return p;
		}
		
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	@FXML
	private void fxFaireTuileDeCreation() {
		 Platform.runLater(new Runnable() {
			 
			 public void run() {
				
		

				 
		 BorderPane  vpane = new BorderPane();       
		 Button button1 = new Button("Ajouter"); 
		 button1.setOnAction(new EventHandler<ActionEvent>() {
			    @Override public void handle(ActionEvent e) {
			        button1.setText("En cours");
			        gestionnaireDeComptes.creerFichierCompte(troisChampsDeSaisieController.userName.getText(), "\\comptes\\",".comptetravian");
			        gestionnaireDeComptes.ecrireDansFichier(
			        		"comptes",
			        		troisChampsDeSaisieController.userName.getText()+".comptetravian",
			        		troisChampsDeSaisieController.userName.getText(),
			        		troisChampsDeSaisieController.serveur.getText(),
			        		troisChampsDeSaisieController.motDePasse.getText(),
			        		"racedefault"
			        		);
			        //update de cochon
			        fxChargerComptes();
			        
			    }
			});
		 
		 
		 
		 
		 Label titre = new Label("Nouveau Compte");
	        titre.getStyleClass().add("ctitre");
	        button1.getStyleClass().add("cbutton1");
	      //  titre.setAlignment(Pos.TOP_LEFT); //setAlignment(Pos.CENTER);
	        vpane.setTop(titre);
	        try {
				vpane.getChildren().add(stc());
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	        vpane.setBottom(button1);
	        button1.setPadding(new Insets(5, 5, 5, 5));
	        BorderPane.setMargin(button1, new Insets(2, 2, 2, 2));
	        
	        //comptesTilePane.getChildren().add(button1);
	        comptesTilePane.getChildren().add(vpane);
	        comptesTilePane.setPadding(new Insets(10, 10, 10, 10));
			comptesTilePane.setVgap(5);
			comptesTilePane.setHgap(5);
			comptesTilePane.setPrefColumns(13);
			
			vpane.getStyleClass().clear();
	        if ( true) {vpane.getStyleClass().add("ctuile");
		 	}else {vpane.getStyleClass().add("ctuileb");}
		
	        vpane.setMinHeight(100);
			vpane.setMinWidth(150);
			 }
		 });
		
	}
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	 @FXML
	 private void fxChargerComptes(){
		ArrayList<File> listeFichiers = gestionnaireDeComptes.getListeFichiers(); 
		 

					 
					try { 
					comptesTilePane.getChildren().clear();
					fxFaireTuileDeCreation();
					 for (File compte : listeFichiers){
					faireTuileDeCompte(compte);
					
					
				 }
					 }catch (Exception e){}
				 

		 //TODO charger les fichiers de configurations s'ils existent.
		 /*
		  * 
		 loadComptes();
		 listeDeComptes = comptes.getListeDeComptes;
	//	 for(){}
		 
		 
		 //TODO creer une ligne/tuile par compte trouvé.
		 
		 
		 //TODO afficher la ligne/tuile de création de compte
		 
		 
		 
		 */
		 
	 }

	/*
	 * public void ecrire(String flux, int c, int from, int to, String css ){
	 * javafx.application.Platform.runLater( ()
	 * ->{bot.fxFenetre.controller.console.ligne.appendText(flux); int p =
	 * bot.fxFenetre.controller.console.ligne.getText().length();
	 * bot.fxFenetre.controller.console.ligne.setStyleClass(c , p, css);});
	 * bot.fxFenetre.controller.console.ligne.setStyleClass(c+from, c+to, css);
	 * 
	 * }
	 */
	


	@FXML
	private void fxConsolescrollpane() throws IOException {
		// console = new FxConsole(bot); //ancienne
		 //console = new FxConsoleSimple(bot);// Vbox
		// Experimentale

		String firstText = "Console : " + '\n';
		ArrayList<String> listeMotsCouleurvide = null;
		// console.fxConsoleColored(bot, firstText);
		            // vbox.getChildren().remove(0);//clear();
		            // fxConsolescrollpane.setContent(vbox);
		// TODO console text Flow 1
		vtScroll = new VirtualizedScrollPane(console.fxConsoleColored(fxFenetreController, firstText)); 
		fxConsolescrollpane.setContent(vtScroll); // console qui marche
	//	fxConsolescrollpane.setContent(console.fxConsoleColored(fxFenetreController, firstText)); // console qui marche

		// experimentale
		
		
	//	 fxConsolescrollpane.setContent(console.fxConsoleTextArea(fxFenetreController, firstText));
	}

	int ia = 0;

	@FXML
	private void zzzpeupler(){ //debranché


		if(ia == 0){
			Thread t2 = new Thread(){
				public void run() {	
					while(true){     
						try {
							Thread.sleep(1000*10);//raffraichissement toute les 5 secondes
						} catch (InterruptedException e2) {e2.printStackTrace();	} 
						peupleractif();
					}}


			};
			t2.start();
			ia++;
		}
	}
	
	
	
	
	int ipeupler= 0; // pour charger la liste une seulle fois et ensuite mettrre a jours les variables
	@FXML
	private void peupleractif() {
		
		if(ipeupler == 0){
			ipeupler=1; // mode reconsctruction sur le chargement de l'onglet, pour develloper tranquille
		Platform.runLater(new Runnable() {
			
			public void run() {
				// code goes here.
				
			
				try {
					villageAnchorPane.getChildren().clear();
					//villageAnchorPane.getChildren().removeAll(getChildren());
					int i = 0;
					
					for (Village village : bot.travian.getListeDeVillages()) {
						StackPane  vpane = new StackPane();
						StackPane v1pane = new StackPane();
						
						vpane.setMinHeight(60);
						v1pane.setMinHeight(vpane.getMinHeight());
						v1pane.setMinWidth(500);
						
						if (i % 2 == 0) {
							v1pane.getStyleClass().add("v1");
						//		v1pane.setEffect(glow);
						  	
						} else {
							v1pane.getStyleClass().add("v2");
							
						//	v1pane.setEffect(lighting);
							
						}
						vpane = raffraichirVpane(village, vpane); //construit un vpane par village


						AnchorPane anchpane = new AnchorPane();
						anchpane.setLeftAnchor(vpane, 0.0);
						anchpane.setRightAnchor(vpane, 0.0);
						anchpane.setLeftAnchor(v1pane, 0.0);
						anchpane.setRightAnchor(v1pane, 0.0);
					
						anchpane.getChildren().addAll(v1pane, vpane);
						villageAnchorPane.getChildren().addAll(anchpane);
					//	villageAnchorPane.setEffect(lighting);
						i++;
						
						
					}

				} catch (Exception e) {
					try {
						console.flux.envoyer(fxFenetreController, "pas de village chargés");
						   ipeupler = 0;   
						
					} catch (IOException e1) {
						e1.printStackTrace();
						ipeupler = 0;
					}
				}

			}

			


		});
	
}
		ipeupler = 0;
	}
	private EventHandler<ActionEvent> setb(Village leVillage, int typeBAFC, String textfield) {
		
		if(typeBAFC == 0){leVillage.setRegimeMarcheBoisMax(Integer.parseInt(textfield));}
		if(typeBAFC == 1){leVillage.setRegimeMarcheArgileMax(Integer.parseInt(textfield));}
		if(typeBAFC == 2){leVillage.setRegimeMarcheFerMax(Integer.parseInt(textfield));}
		if(typeBAFC == 3){leVillage.setRegimeMarcheCerealesMax(Integer.parseInt(textfield));}
		
		if(typeBAFC == 4){leVillage.setRegimeMarcheBoisMin(Integer.parseInt(textfield));}
		if(typeBAFC == 5){leVillage.setRegimeMarcheArgileMin(Integer.parseInt(textfield));}
		if(typeBAFC == 6){leVillage.setRegimeMarcheFerMin(Integer.parseInt(textfield));}
		if(typeBAFC == 7){leVillage.setRegimeMarcheCerealesMin(Integer.parseInt(textfield));}
		peupleractif();
		return null;
	}
	
	
	
	
	
	//raffraichit un vpane avec les instrcution donnée
	private StackPane raffraichirVpane(Village village, StackPane vpane) {
		
		vpane.getChildren().clear();	
		FlowPane flowPaneMarche = new FlowPane();
		flowPaneMarche.getChildren().clear();
		//Les effets
		Lighting lighting = new Lighting(); 
		Glow glow = new Glow(0.8);// lighting
        Bloom bloom = new Bloom();
        bloom.setThreshold(0.7);
		

		

	

		String nomV = village.getNom();
		Label nomVLabel = new Label(nomV);
		Pane lp = new Pane(nomVLabel);
		nomVLabel.setPrefHeight(25);
		nomVLabel.setPadding(new Insets(5, 10, 5, 10));
		nomVLabel.setStyle("-fx-font: bold  14 arial;");

		
		//tableau ressources
		Pane paneMarche = new Pane();
		paneMarche.setPadding(new Insets(0,0,0,0));
		paneMarche.getStyleClass().add("m1");
		TextField t0 = new TextField(""+village.regimeMarcheBoisMax+"");t0.setPrefColumnCount(2);t0.getStyleClass().add("m2");t0.setOnAction((event) -> {setb(village, 0, t0.getText());});
		TextField t1 = new TextField(""+village.regimeMarcheArgileMax+""); t1.setPrefColumnCount(2);t1.getStyleClass().add("m2");t1.setOnAction((event) -> {setb(village, 1, t1.getText());});
		TextField t2 = new TextField(""+village.regimeMarcheFerMax+"");t2.setPrefColumnCount(2);t2.getStyleClass().add("m2");t2.setOnAction((event) -> {setb(village, 2, t2.getText());});
		TextField t3 = new TextField(""+village.regimeMarcheCerealesMax+"");t3.setPrefColumnCount(2);t3.getStyleClass().add("m2");t3.setOnAction((event) -> {setb(village, 3, t3.getText());});
		
		TextField t4 = new TextField(""+village.regimeMarcheBoisMin+"");t4.setPrefColumnCount(2);t4.getStyleClass().add("m2");t4.setOnAction((event) -> {setb(village, 4, t4.getText());});
		TextField t5 = new TextField(""+village.regimeMarcheArgileMin+""); t5.setPrefColumnCount(2);t5.getStyleClass().add("m2");t5.setOnAction((event) -> {setb(village, 5, t5.getText());});
		TextField t6 = new TextField(""+village.regimeMarcheFerMin+"");t6.setPrefColumnCount(2);t6.getStyleClass().add("m2");t6.setOnAction((event) -> {setb(village, 6, t6.getText());});
		TextField t7 = new TextField(""+village.regimeMarcheCerealesMin+"");t7.setPrefColumnCount(2);t7.getStyleClass().add("m2");t7.setOnAction((event) -> {setb(village, 7, t7.getText());});
		
		ArrayList<TextField> ts = new ArrayList<TextField>();
		ts.add(t0);ts.add(t1);ts.add(t2);ts.add(t3);ts.add(t4);ts.add(t5);ts.add(t6);ts.add(t7);
		
		for(TextField s : ts){ 
			s.setStyle("-fx-font: 12 arial;");
			s.setPadding(new Insets(0,0,0,0));
			s.setAlignment(Pos.CENTER);
		}
		
		FlowPane a = new FlowPane(t0,t1,t2, t3);
		FlowPane b = new FlowPane(t4,t5,t6, t7);
		a.setPadding(new Insets(0,0,0,0));
		b.setPadding(new Insets(12,0,0,0));
		
		
		VBox vm = new VBox(a,b);
		vm.setPrefSize(100, 50);
		vm.setPadding(new Insets(0,0,0,0));
		vm.setAlignment(Pos.CENTER);
 		StackPane p = new StackPane();
	    p.setMinWidth(vm.getWidth());
	    p.setMinHeight(vm.getHeight());
		StackPane vmp = new StackPane(vm,p);
		vm.setAlignment(Pos.CENTER);
		vmp.setAlignment(Pos.CENTER);
		p.setAlignment(Pos.CENTER);
		
        BoxBlur bb = new BoxBlur();
        bb.setWidth(1);
        bb.setHeight(2);
        bb.setIterations(3);
		

		
		
		
		//// boutton
		ToggleButton tb = new ToggleButton();
		tb.setOnAction((event) -> { 
			
			village.switchRegimeGeneral();
			raffraichirVpane(village, vpane); //rafraichit uniquement le vpane concerné par l'event handler
		
		
		
		
		}); 
		
		tb.getStyleClass().add("m3");
		tb.setEffect(lighting);
		tb.setMinHeight(45);
		tb.setPadding(new Insets(0,0,0,0));
		tb.setStyle("-fx-font: 10 arial;");
		
		VBox bvbox = new VBox();
		bvbox.setPadding(new Insets(0,3,0,4));//(0,3,0,4)
		Label bvbl1 = new Label(""); Label bvbl2 = new Label("B"); Label bvbl3 = new Label("U");
		
		// si on ou off
		if (village.getRegimeGeneral() == false){
			
		bvbl1.setText("O"); bvbl2.setText("N"); bvbl3.setText("");
		for(TextField s : ts){ 
			s.getStyleClass().remove("m2");
			s.getStyleClass().add("fake3"); 

			}
		}
		
		else {bvbl1.setText("O"); bvbl2.setText("F"); bvbl3.setText("F"); ;  
		for(TextField s : ts){ 
			s.getStyleClass().remove("m2");
			s.getStyleClass().add("off"); 
		//	a.setEffect(bb);
		//	b.setEffect(bb);
			
		}
		}
		
		
		bvbox.getChildren().addAll(bvbl1,bvbl2,bvbl3);
		if (village.regimeGeneral == false) {
			bvbox.getStyleClass().add("fake3");
		} else {
			bvbox.getStyleClass().add("off");
		}
		
		bvbox.setSpacing(-3);
		tb.setGraphic(bvbox); //TODO genial, set graphic : investiguer les dev possibles //.setEllipsisString("");
		tb.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);

		
		
		

		flowPaneMarche.getChildren().addAll(vm,tb); //vmp pour le P su besoin
		flowPaneMarche.setPadding(new Insets(0,20,0,20));
		//flowPaneMarche.getStyleClass().add("pink");
		flowPaneMarche.setMaxWidth(160);
		
		///cases a cocher
		FlowPane flowCases = new FlowPane();
		CheckBox c1 = new CheckBox("Pillage");
		CheckBox c2 = new CheckBox("Fetes");
		CheckBox c3 = new CheckBox("Constru");
		CheckBox c4 = new CheckBox("npc");
		CheckBox c5 = new CheckBox("");
		CheckBox c6 = new CheckBox("");
		ArrayList<CheckBox> cl = new ArrayList<CheckBox>();
		cl.add(c1);cl.add(c2);cl.add(c3);cl.add(c4);cl.add(c5);cl.add(c6);
		
		for(CheckBox c : cl){ 
			c.setSelected(true);
		//	c.setPadding(new Insets(0,0,0,0));
		//	c.setAlignment(Pos.CENTER);
			c.setPadding(new Insets(12,12,12,12));
			if(c.isSelected()){
				c.getStyleClass().add("fake3");
				c.setStyle(
					    "-fx-font-size: 20;"
					/*    + "-fx-border-color: lightblue; "
					    + "-fx-border-insets: -5; "
					    + "-fx-border-radius: 5;"
					    + "-fx-border-style: dotted;"
					    + "-fx-border-width: 2;"*/
					);
				}
			else {c.getStyleClass().add("off");}
		}
		
		flowCases.getChildren().addAll(c1, c2, c3, c4, c5, c6);
		flowCases.setOrientation(Orientation.VERTICAL);
		flowCases.setPrefSize(100, 50);
		flowCases.setHgap(10);
		flowCases.setVgap(10);
	//	flowCases.getStyleClass().add("fake3");
		flowCases.setAlignment(Pos.CENTER_LEFT);
		

		if (village.getVillageCapitale() == true) {
			nomVLabel.getStyleClass().remove("vLabel");
			nomVLabel.getStyleClass().add("vLabelcap");
		} else {
			if(village.getVillagePillage() == true){
				nomVLabel.getStyleClass().remove("vLabel");
				nomVLabel.getStyleClass().remove("vLabelcap");
				nomVLabel.getStyleClass().add("vLabelpillage");
			}else {
			nomVLabel.getStyleClass().add("vLabel");
			}
		}
		
		FlowPane bG = new FlowPane();
		bG.getChildren().addAll(lp ,flowPaneMarche, flowCases);
		vpane.getChildren().addAll(bG); //Maj du noeud ;)
		bG.setAlignment(Pos.CENTER_LEFT);
	//	bG.getStyleClass().add("pink");
		return vpane;



		
	}
	
	
	
	
	
	
	
}





















































































///////////save de 1 iere version


/*
 * 
 * 
 * 
 * //	p.setStyle("-fx-background-color:rgba(0, 100, 100, 0.2); -fx-background-radius: 1;");// -fx-background-radius: 10; rgba(0, 100, 100, 0.5)
 * 
 * 		//	a.getChildren().remove(p);
			//vm.getStyleClass().add("fake3"); //PANNEAU MARCHé
			//vm.setStyle("-fx-border-color: white; -fx-border-style: solid ;-fx-border-width: 0 1 0 1;");
			  
			  
			  
			  
			  
			 

@FXML
private void peupleractif() {

	Platform.runLater(new Runnable() {
		public void run() {
			// code goes here.

			villageAnchorPane.getChildren().clear();
			try {
				int i = 0;
				for (Village village : bot.travian.getListeDeVillages()) {
					FlowPane flowPaneMarche = new FlowPane();
					//Les effets
					Lighting lighting = new Lighting(); 
					Glow glow = new Glow(0.8);// lighting
			        Bloom bloom = new Bloom();
			        bloom.setThreshold(0.7);
					
					StackPane  vpane = new StackPane();
					StackPane v1pane = new StackPane();
					
					vpane.setMinHeight(60);
					v1pane.setMinHeight(vpane.getMinHeight());
					v1pane.setMinWidth(500);
					

					if (i % 2 == 0) {
						v1pane.getStyleClass().add("v1");
							v1pane.setEffect(glow);
					  	
					} else {
						v1pane.getStyleClass().add("v2");
						
						v1pane.setEffect(lighting);
						
					}

					String nomV = village.getNom();
					Label nomVLabel = new Label(nomV);
					Pane lp = new Pane(nomVLabel);
					nomVLabel.setPrefHeight(25);
					nomVLabel.setPadding(new Insets(5, 10, 5, 10));
					//.setStyle("-fx-effect: innershadow( three-pass-box , rgba(0,0,0,0.7) , 6, 0.0 , 0 , 2 )"); //("-fx-font: bold  10 arial;");
					nomVLabel.setStyle("-fx-font: bold  14 arial;");
					//nomVLabel.setFont(Font.font("Verdana", FontPosture.ITALIC, 20)); -fx-font-size: 32px;
					//nomVLabel.getStyleClass().add("-fx-font-family: Arial Black");
				//	nomVLabel.setStyle("-fx-font-size: 32px;");
			//		nomVLabel.setStyle("-fx-fill: #818181; -fx-font-size: 32px; -fx-effect: innershadow( three-pass-box , rgba(0,0,0,0.7) , 6, 0.0 , 0 , 2; ");
				//	nomVLabel.setStyle("-fx-effect: innershadow( three-pass-box , rgba(0,0,0,0.7) , 6, 0.0 , 0 , 2");
				//	nomVLabel.getStyleClass().add("wt");
					//   -fx-font-family: "Arial Black";
					//   -fx-fill: #818181;
				//	lp.setPadding(new Insets(10, 10, 10, 10));
				//	nomVLabel.setEffect(lighting);
				//	-fx-effect: innershadow( three-pass-box , rgba(0,0,0,0.7) , 6, 0.0 , 0 , 2 );
					
					//tableau ressources
					Pane paneMarche = new Pane();
					paneMarche.setPadding(new Insets(0,0,0,0));
					paneMarche.getStyleClass().add("m1");
					TextField t0 = new TextField(""+village.regimeMarcheBoisMax+"");t0.setPrefColumnCount(2);t0.getStyleClass().add("m2");t0.setOnAction((event) -> {setb(village, 0, t0.getText());});
					TextField t1 = new TextField(""+village.regimeMarcheArgileMax+""); t1.setPrefColumnCount(2);t1.getStyleClass().add("m2");t1.setOnAction((event) -> {setb(village, 1, t1.getText());});
					TextField t2 = new TextField(""+village.regimeMarcheFerMax+"");t2.setPrefColumnCount(2);t2.getStyleClass().add("m2");t2.setOnAction((event) -> {setb(village, 2, t2.getText());});
					TextField t3 = new TextField(""+village.regimeMarcheCerealesMax+"");t3.setPrefColumnCount(2);t3.getStyleClass().add("m2");t3.setOnAction((event) -> {setb(village, 3, t3.getText());});
					
					TextField t4 = new TextField(""+village.regimeMarcheBoisMin+"");t4.setPrefColumnCount(2);t4.getStyleClass().add("m2");t4.setOnAction((event) -> {setb(village, 4, t4.getText());});
					TextField t5 = new TextField(""+village.regimeMarcheArgileMin+""); t5.setPrefColumnCount(2);t5.getStyleClass().add("m2");t5.setOnAction((event) -> {setb(village, 5, t5.getText());});
					TextField t6 = new TextField(""+village.regimeMarcheFerMin+"");t6.setPrefColumnCount(2);t6.getStyleClass().add("m2");t6.setOnAction((event) -> {setb(village, 6, t6.getText());});
					TextField t7 = new TextField(""+village.regimeMarcheCerealesMin+"");t7.setPrefColumnCount(2);t7.getStyleClass().add("m2");t7.setOnAction((event) -> {setb(village, 7, t7.getText());});
					
					ArrayList<TextField> ts = new ArrayList<TextField>();
					ts.add(t0);ts.add(t1);ts.add(t2);ts.add(t3);ts.add(t4);ts.add(t5);ts.add(t6);ts.add(t7);
					
					for(TextField s : ts){ 
						s.setStyle("-fx-font: 12 arial;");
						s.setPadding(new Insets(0,0,0,0));
						s.setAlignment(Pos.CENTER);
					}
					
					FlowPane a = new FlowPane(t0,t1,t2, t3);
					FlowPane b = new FlowPane(t4,t5,t6, t7);
					a.setPadding(new Insets(0,0,0,0));
					b.setPadding(new Insets(12,0,0,0));
					
					VBox vm = new VBox(a,b);
					vm.setPrefSize(100, 20);
					vm.setPadding(new Insets(0,0,0,0));
				//	vm.getStyleClass().add("cyan");

					
					
					//// boutton
					ToggleButton tb = new ToggleButton();
					tb.setOnAction((event) -> { 
						
						village.switchRegimeGeneral();
						raffraichirVpane(village, vpane);
					
					
					
					
					}); //peupleractif()
					
					tb.getStyleClass().add("m3");
					tb.setEffect(lighting);
					tb.setMinHeight(45);
					//tb.setWrapText(true);
					//tb.setLineSpacing(0);
					tb.setPadding(new Insets(0,0,0,0));
					tb.setStyle("-fx-font: 10 arial;");
					
					VBox bvbox = new VBox();
					bvbox.setPadding(new Insets(0,3,0,4));//(0,3,0,4)
					Label bvbl1 = new Label(""); Label bvbl2 = new Label("B"); Label bvbl3 = new Label("U");
					
					if (village.getRegimeGeneral() == false){
					bvbl1.setText("O"); bvbl2.setText("N"); bvbl3.setText("");
					for(TextField s : ts){ 
						s.getStyleClass().remove("m2");
						s.getStyleClass().add("fake3"); 
						
					}
					}
					else {bvbl1.setText("O"); bvbl2.setText("F"); bvbl3.setText("F"); ;  
					for(TextField s : ts){ 
						s.getStyleClass().remove("m2");
						s.getStyleClass().add("off"); 
						
					}
					}
					
					
					bvbox.getChildren().addAll(bvbl1,bvbl2,bvbl3);
					if (village.regimeGeneral == false) {
						bvbox.getStyleClass().add("fake3");
					} else {
						bvbox.getStyleClass().add("off");
					}
					
					bvbox.setSpacing(-3);
					tb.setGraphic(bvbox); //TODO genial, set graphic : investiguer les dev possibles //.setEllipsisString("");
					tb.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
				//	tb.getStyleClass().add("cyan");
					////
					//bvbox.setPadding(new Insets(0,0,0,0));
					
					


					
					
					
					
					//flowPaneMarche.setPrefWrapLength(120);
					flowPaneMarche.getChildren().addAll(vm,tb);
				//	flowPaneMarche.setPadding(new Insets(0,0,0,0));
					flowPaneMarche.getStyleClass().add("pink");
				//	flowPaneMarche.setAlignment(Pos.CENTER);
					flowPaneMarche.setMaxWidth(120);
					

					//les event handler du marché
			//	    @FXML
				//    private void cc(ActionEvent event) {
				//    	bot.rythmePillage = Integer.parseInt(rythmePillage.getText()) ; 
				//    }
					
					
					
	
					
					
					///cases a cocher
					FlowPane flowCases = new FlowPane();
					CheckBox c1 = new CheckBox("Pillage");
					CheckBox c2 = new CheckBox("Fetes");
					CheckBox c3 = new CheckBox("Constru");
					CheckBox c4 = new CheckBox("npc");
					CheckBox c5 = new CheckBox("");
					CheckBox c6 = new CheckBox("");
					flowCases.getChildren().addAll(c1, c2, c3, c4, c5, c6);
					flowCases.setOrientation(Orientation.VERTICAL);
					flowCases.setPrefSize(125, 50);
					flowCases.getStyleClass().add("fake3");
					flowCases.setAlignment(Pos.CENTER);
					
					if (village.getVillageCapitale() == true) {
						nomVLabel.getStyleClass().remove("vLabel");
						nomVLabel.getStyleClass().add("vLabelcap");
					} else {
						nomVLabel.getStyleClass().add("vLabel");

					}
					FlowPane bG = new FlowPane();
				//	bG.getStyleClass().add("c"); //rouge
				//	bG.setPrefSize(Double.MAX_VALUE, Double.MAX_VALUE); //getHeight(
				//	bG.setPrefWrapLength(600);
					bG.getChildren().addAll(lp ,flowPaneMarche, flowCases);
					
					vpane.getChildren().addAll(bG);
					bG.setAlignment(Pos.CENTER_LEFT);
					//bG.setRowValignment(VPos.BOTTOM);


					AnchorPane anchpane = new AnchorPane();
					anchpane.setLeftAnchor(vpane, 0.0);
					anchpane.setRightAnchor(vpane, 0.0);
					anchpane.setLeftAnchor(v1pane, 0.0);
					anchpane.setRightAnchor(v1pane, 0.0);
				
					anchpane.getChildren().addAll(v1pane, vpane);
					villageAnchorPane.getChildren().addAll(anchpane);
				//	villageAnchorPane.setEffect(lighting);
					i++;
					

				}

			} catch (Exception e) {
				try {
					fxFenetreController.console.flux.envoyer(fxFenetreController, "pas de village chargés");
					      
					
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}

		}
*/


























//////save de seconde version

/*


int ipeupler= 0; // pour charger la liste une seulle fois et ensuite mettrre a jours les variables
@FXML
private void peupleractif() {
if(ipeupler == 0){
	Platform.runLater(new Runnable() {
		
		public void run() {
			// code goes here.
			
			villageAnchorPane.getChildren().clear();
			//villageAnchorPane.getChildren().removeAll(getChildren());
			try {
				int i = 0;
				
				for (Village village : bot.travian.getListeDeVillages()) {
					StackPane  vpane = new StackPane();
					StackPane v1pane = new StackPane();
					
					vpane.setMinHeight(60);
					v1pane.setMinHeight(vpane.getMinHeight());
					v1pane.setMinWidth(500);
					
					if (i % 2 == 0) {
						v1pane.getStyleClass().add("v1");
					//		v1pane.setEffect(glow);
					  	
					} else {
						v1pane.getStyleClass().add("v2");
						
					//	v1pane.setEffect(lighting);
						
					}
					vpane = raffraichirVpane(i, village, vpane);


					AnchorPane anchpane = new AnchorPane();
					anchpane.setLeftAnchor(vpane, 0.0);
					anchpane.setRightAnchor(vpane, 0.0);
					anchpane.setLeftAnchor(v1pane, 0.0);
					anchpane.setRightAnchor(v1pane, 0.0);
				
					anchpane.getChildren().addAll(v1pane, vpane);
					villageAnchorPane.getChildren().addAll(anchpane);
				//	villageAnchorPane.setEffect(lighting);
					i++;
					ipeupler++;

				}

			} catch (Exception e) {
				try {
					fxFenetreController.console.flux.envoyer(fxFenetreController, "pas de village chargés");
					      
					
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}

		}

		private StackPane raffraichirVpane(int i, Village village, StackPane vpane) {
			vpane.getChildren().clear();	
			FlowPane flowPaneMarche = new FlowPane();
			flowPaneMarche.getChildren().clear();
			//Les effets
			Lighting lighting = new Lighting(); 
			Glow glow = new Glow(0.8);// lighting
	        Bloom bloom = new Bloom();
	        bloom.setThreshold(0.7);
			

			

		

			String nomV = village.getNom();
			Label nomVLabel = new Label(nomV);
			Pane lp = new Pane(nomVLabel);
			nomVLabel.setPrefHeight(25);
			nomVLabel.setPadding(new Insets(5, 10, 5, 10));
			nomVLabel.setStyle("-fx-font: bold  14 arial;");

			
			//tableau ressources
			Pane paneMarche = new Pane();
			paneMarche.setPadding(new Insets(0,0,0,0));
			paneMarche.getStyleClass().add("m1");
			TextField t0 = new TextField(""+village.regimeMarcheBoisMax+"");t0.setPrefColumnCount(2);t0.getStyleClass().add("m2");t0.setOnAction((event) -> {setb(village, 0, t0.getText());});
			TextField t1 = new TextField(""+village.regimeMarcheArgileMax+""); t1.setPrefColumnCount(2);t1.getStyleClass().add("m2");t1.setOnAction((event) -> {setb(village, 1, t1.getText());});
			TextField t2 = new TextField(""+village.regimeMarcheFerMax+"");t2.setPrefColumnCount(2);t2.getStyleClass().add("m2");t2.setOnAction((event) -> {setb(village, 2, t2.getText());});
			TextField t3 = new TextField(""+village.regimeMarcheCerealesMax+"");t3.setPrefColumnCount(2);t3.getStyleClass().add("m2");t3.setOnAction((event) -> {setb(village, 3, t3.getText());});
			
			TextField t4 = new TextField(""+village.regimeMarcheBoisMin+"");t4.setPrefColumnCount(2);t4.getStyleClass().add("m2");t4.setOnAction((event) -> {setb(village, 4, t4.getText());});
			TextField t5 = new TextField(""+village.regimeMarcheArgileMin+""); t5.setPrefColumnCount(2);t5.getStyleClass().add("m2");t5.setOnAction((event) -> {setb(village, 5, t5.getText());});
			TextField t6 = new TextField(""+village.regimeMarcheFerMin+"");t6.setPrefColumnCount(2);t6.getStyleClass().add("m2");t6.setOnAction((event) -> {setb(village, 6, t6.getText());});
			TextField t7 = new TextField(""+village.regimeMarcheCerealesMin+"");t7.setPrefColumnCount(2);t7.getStyleClass().add("m2");t7.setOnAction((event) -> {setb(village, 7, t7.getText());});
			
			ArrayList<TextField> ts = new ArrayList<TextField>();
			ts.add(t0);ts.add(t1);ts.add(t2);ts.add(t3);ts.add(t4);ts.add(t5);ts.add(t6);ts.add(t7);
			
			for(TextField s : ts){ 
				s.setStyle("-fx-font: 12 arial;");
				s.setPadding(new Insets(0,0,0,0));
				s.setAlignment(Pos.CENTER);
			}
			
			FlowPane a = new FlowPane(t0,t1,t2, t3);
			FlowPane b = new FlowPane(t4,t5,t6, t7);
			a.setPadding(new Insets(0,0,0,0));
			b.setPadding(new Insets(12,0,0,0));
			
			VBox vm = new VBox(a,b);
			vm.setPrefSize(100, 20);
			vm.setPadding(new Insets(0,0,0,0));


			
			
			//// boutton
			ToggleButton tb = new ToggleButton();
			tb.setOnAction((event) -> { 
				
				village.switchRegimeGeneral();
				raffraichirVpane(i, village, vpane);
			
			
			
			
			}); 
			
			tb.getStyleClass().add("m3");
			tb.setEffect(lighting);
			tb.setMinHeight(45);
			tb.setPadding(new Insets(0,0,0,0));
			tb.setStyle("-fx-font: 10 arial;");
			
			VBox bvbox = new VBox();
			bvbox.setPadding(new Insets(0,3,0,4));//(0,3,0,4)
			Label bvbl1 = new Label(""); Label bvbl2 = new Label("B"); Label bvbl3 = new Label("U");
			
			if (village.getRegimeGeneral() == false){
			bvbl1.setText("O"); bvbl2.setText("N"); bvbl3.setText("");
			for(TextField s : ts){ 
				s.getStyleClass().remove("m2");
				s.getStyleClass().add("fake3"); 
				
			}
			}
			else {bvbl1.setText("O"); bvbl2.setText("F"); bvbl3.setText("F"); ;  
			for(TextField s : ts){ 
				s.getStyleClass().remove("m2");
				s.getStyleClass().add("off"); 
				
			}
			}
			
			
			bvbox.getChildren().addAll(bvbl1,bvbl2,bvbl3);
			if (village.regimeGeneral == false) {
				bvbox.getStyleClass().add("fake3");
			} else {
				bvbox.getStyleClass().add("off");
			}
			
			bvbox.setSpacing(-3);
			tb.setGraphic(bvbox); //TODO genial, set graphic : investiguer les dev possibles //.setEllipsisString("");
			tb.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);

			
			
			

			flowPaneMarche.getChildren().addAll(vm,tb);
			flowPaneMarche.getStyleClass().add("pink");
			flowPaneMarche.setMaxWidth(120);
			
			///cases a cocher
			FlowPane flowCases = new FlowPane();
			CheckBox c1 = new CheckBox("Pillage");
			CheckBox c2 = new CheckBox("Fetes");
			CheckBox c3 = new CheckBox("Constru");
			CheckBox c4 = new CheckBox("npc");
			CheckBox c5 = new CheckBox("");
			CheckBox c6 = new CheckBox("");
			flowCases.getChildren().addAll(c1, c2, c3, c4, c5, c6);
			flowCases.setOrientation(Orientation.VERTICAL);
			flowCases.setPrefSize(125, 50);
			flowCases.getStyleClass().add("fake3");
			flowCases.setAlignment(Pos.CENTER);
			
			if (village.getVillageCapitale() == true) {
				nomVLabel.getStyleClass().remove("vLabel");
				nomVLabel.getStyleClass().add("vLabelcap");
			} else {
				nomVLabel.getStyleClass().add("vLabel");

			}
			FlowPane bG = new FlowPane();
			bG.getChildren().addAll(lp ,flowPaneMarche, flowCases);
			
			vpane.getChildren().addAll(bG);
			bG.setAlignment(Pos.CENTER_LEFT);
			return vpane;



			
		}


	});
	
}

}

*/













/*
 	private StackPane obj(){
		StackPane v1pane = new StackPane();
		Lighting lighting = new Lighting();
		Bloom bloom = new Bloom();
		String nomV = null;
		Label nomVLabel = new Label(nomV);
		Pane lp = new Pane(nomVLabel);
		Pane paneMarche = new Pane();
		TextField t0 = new TextField();
		TextField t1 = new TextField();
		TextField t2 = new TextField();
		TextField t3 = new TextField();
		TextField t4 = new TextField();
		TextField t5 = new TextField();
		TextField t6 = new TextField();
		TextField t7 = new TextField();
		ArrayList<TextField> ts = new ArrayList<TextField>();
		FlowPane a = new FlowPane(t0,t1,t2, t3);
		FlowPane b = new FlowPane(t4,t5,t6, t7);
		VBox vm = new VBox(a,b);
		CheckBox c1 = new CheckBox("Pillage");
		CheckBox c2 = new CheckBox("Fetes");
		CheckBox c3 = new CheckBox("Constru");
		CheckBox c4 = new CheckBox("npc");
		CheckBox c5 = new CheckBox("");
		CheckBox c6 = new CheckBox("");
		FlowPane flowCases = new FlowPane(c1, c2, c3, c4, c5, c6);
		ToggleButton tb = new ToggleButton();
		VBox bvbox = new VBox();
		Label bvbl1 = new Label("B"); Label bvbl2 = new Label("G"); Label bvbl3 = new Label("G");
		FlowPane flowPaneMarche = new FlowPane(vm,tb);
		FlowPane bG = new FlowPane(lp ,flowPaneMarche, flowCases);
		StackPane  vpane = new StackPane(bG);
		AnchorPane anchpane = new AnchorPane(v1pane, vpane);

		if(ipeupler == 0){
			ts.add(t0);ts.add(t1);ts.add(t2);ts.add(t3);ts.add(t4);ts.add(t5);ts.add(t6);ts.add(t7);
			ipeupler = 1;
		}else {ts.set(0, t0);ts.set(1, t1); ts.set(2, t2);ts.set(3, t3);ts.set(4, t4);ts.set(5, t5);ts.set(6, t6);ts.set(7, t7);}
		
		return vpane;
		
		
	} 
  
  */
