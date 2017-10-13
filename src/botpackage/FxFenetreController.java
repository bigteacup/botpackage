package botpackage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import org.fxmisc.flowless.VirtualizedScrollPane;
import org.fxmisc.richtext.StyleClassedTextArea;


import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.CacheHint;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.effect.Bloom;
import javafx.scene.effect.BoxBlur;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.effect.Glow;
import javafx.scene.effect.Lighting;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import javafx.scene.layout.FlowPane;

import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.StringConverter;


//fx:controller="botpackage.FxFenetreController"
public class FxFenetreController extends ScrollPane {
	public Lancerbot bot;

	FxFenetreController fxFenetreController;
	// FxConsole console;
	// FxConsoleSimple console;
	FxConsoleExperimentale console;
	VirtualizedScrollPane<StyleClassedTextArea> vtScroll;
	GestionnaireDeComptes gestionnaireDeComptes = new GestionnaireDeComptes();

	String compteSelectionne = null;



	@FXML
	private ResourceBundle resources;

	@FXML
	private VBox fxTemplate;


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

	@FXML
	private CheckBox caseAcheterAuMarché;
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
		assert caseAcheterAuMarché != null : "fx:id=\"comptesTilePane\" was not injected: check your FXML file 'fxFenetre.fxml'.";
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


		console = new FxConsoleExperimentale(fxFenetreController); // console.start();
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

		if (bot.acheterAuMarché == true) {
			caseAcheterAuMarché.setSelected(true);
		} else
			caseAcheterAuMarché.setSelected(false);

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
	private void caseAcheterAuMarché(){
		if (bot.acheterAuMarché == true) {
			bot.acheterAuMarché = false;
		}else
			bot.acheterAuMarché = true;
	}
	//les regimes speciaux de village
	private void switcherCaseRegimePillage(Village village){
		if (village.getRegimePillage() == true) {
			village.setRegimePillage(false)  ;
		}else
			village.setRegimePillage(true);
	}
	private void switcherCaseRegimeConstruction(Village village){
		if (village.getRegimeConstruction() == true) {
			village.setRegimeConstruction(false)  ;
		}else
			village.setRegimeConstruction(true);
	}
	private void switcherCaseRegimeFete(Village village){
		if (village.getRegimeFete() == true) {
			village.setRegimeFete(false)  ;
		}else
			village.setRegimeFete(true);
	}
	private void switcherCaseRegimeNPC(Village village){
		if (village.getRegimeNPC() == true) {
			village.setRegimeNPC(false)  ;
		}else
			village.setRegimeNPC(true);
	}
	private void switcherCaseRegimeAcheterAuMarché(Village village){
		if (village.getRegimeAcheterAuMarché() == true) {
			village.setRegimeAcheterAuMarché(false)  ;
		}else
			village.setRegimeAcheterAuMarché(true);
	}

	@FXML
	private void bypassPause() {
		bot.annulerPause();
	}

	@FXML
	private void boutonOn() {
		//boutonOn.getStyleClass().clear();
		// System.out.println("on");
		String nomDeCompte = compteSelectionne;
		//	bot.setfxFenetreController(this); // redondant ? utile ?
		String s = troisChampsDeSaisieController.serveur.getText();
		String n = troisChampsDeSaisieController.userName.getText();
		String m = troisChampsDeSaisieController.motDePasse.getText();
		if(compteSelectionne != null){
			boutonOn.getStyleClass().removeAll("ona");
			boutonOn.getStyleClass().removeAll("onb");
			boutonOn.getStyleClass().removeAll("onc"); 
			boutonOn.getStyleClass().add("onb");
			bot.lancerTravian(nomDeCompte, s, n, m);
		}else {try {
			boutonOn.getStyleClass().removeAll("ona");
			boutonOn.getStyleClass().removeAll("onb");
			boutonOn.getStyleClass().removeAll("onc"); 
			//	boutonOn.getStyleClass().clear();
			boutonOn.getStyleClass().add("onc");
			console.flux.envoyer(fxFenetreController, "Pas de compte selectionne... Veuillez selectionner un compte.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}
	}

	public void ona(Travian t) {
		//t.fxFenetreController.boutonOn.getStyleClass().clear(); // bug ?
		t.fxFenetreController.boutonOn.getStyleClass().removeAll("ona");
		t.fxFenetreController.boutonOn.getStyleClass().removeAll("onb");
		t.fxFenetreController.boutonOn.getStyleClass().removeAll("onc"); 
		t.fxFenetreController.boutonOn.getStyleClass().add("ona"); 


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

				Button buttonDelete = new Button("Supr'");
				buttonDelete.setOnAction(new EventHandler<ActionEvent>() {
					@Override public void handle(ActionEvent e) {
						gestionnaireDeComptes.suprimerFichierCompte(compte.getName(), "\\comptes\\", "");
						fxChargerComptes();
					}

				});


				Label titre = new Label(compte.getName().split(".compte")[0]);

				// vpane.getChildren().add(button1);
				// vpane.getChildren().add(titre);
				titre.getStyleClass().add("ctitre");
				button1.getStyleClass().add("cbutton1");
				//  titre.setAlignment(Pos.TOP_LEFT); //setAlignment(Pos.CENTER);
				vpane.setTop(titre);
				vpane.setBottom(button1);
				button1.setPadding(new Insets(5, 5, 5, 5));
				BorderPane.setMargin(button1, new Insets(2, 2, 2, 2));

				buttonDelete.getStyleClass().add("buttonDelete");
				//  titre.setAlignment(Pos.TOP_LEFT); //setAlignment(Pos.CENTER);
				vpane.setTop(titre);
				vpane.setRight(buttonDelete);
				// buttonDelete.setPadding(new Insets(5, 5, 5, 5));
				BorderPane.setMargin(buttonDelete, new Insets(2, 2, 2, 2));

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
							v1pane.setMinWidth(750);

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
		StackPane lp = new StackPane(nomVLabel);
		lp.setAlignment(Pos.TOP_LEFT);
		nomVLabel.setPrefHeight(25);
		nomVLabel.setPadding(new Insets(5, 15, 5, 10));
		lp.setPadding(new Insets(5, 15, 5, 10));
		//	StackPane.setMargin(nomVLabel, new Insets(0,10,0,6));
		//	nomVLabel.setAlignment(Pos.TOP_LEFT);
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
		vm.setPrefSize(92, 50);
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
		flowPaneMarche.setPadding(new Insets(0,0,0,0));
		//flowPaneMarche.getStyleClass().add("pink");
		flowPaneMarche.setMaxWidth(120);

		///cases a cocher

		CheckBox c1 = new CheckBox("Pillage");
		CheckBox c2 = new CheckBox("Fetes");
		CheckBox c3 = new CheckBox("Construction");
		CheckBox c4 = new CheckBox("NPC");
		CheckBox c5 = new CheckBox("AcheterAuMarché");
		CheckBox c6 = new CheckBox("");

		FlowPane flowCases = new FlowPane();
		ArrayList<CheckBox> cl = new ArrayList<CheckBox>();

		if(village.getRegimePillage() == true) { c1.setSelected(true);}else {c1.setSelected(false);}
		if(village.getRegimeFete() == true) { c2.setSelected(true);}else {c2.setSelected(false);}
		if(village.getRegimeConstruction() == true) { c3.setSelected(true);}else {c3.setSelected(false);}
		if(village.getRegimeNPC() == true) { c4.setSelected(true);}else {c4.setSelected(false);}
		if(village.getRegimeAcheterAuMarché() == true) { c5.setSelected(true);}else {c5.setSelected(false);}




		c1.setOnAction(new EventHandler<ActionEvent>() { @Override public void handle(ActionEvent e) {
			switcherCaseRegimePillage(village);
			raffraichirCase (village, cl, flowCases);
		} }); 	

		c2.setOnAction(new EventHandler<ActionEvent>() { @Override public void handle(ActionEvent e) {
			switcherCaseRegimeFete(village);
			raffraichirCase (village, cl, flowCases);
		} }); 	

		c3.setOnAction(new EventHandler<ActionEvent>() { @Override public void handle(ActionEvent e) {
			switcherCaseRegimeConstruction(village);
			raffraichirCase (village, cl, flowCases);
		} }); 

		c4.setOnAction(new EventHandler<ActionEvent>() { @Override public void handle(ActionEvent e) {
			switcherCaseRegimeNPC(village);
			raffraichirCase (village, cl, flowCases);
		} }); 

		c5.setOnAction(new EventHandler<ActionEvent>() { @Override public void handle(ActionEvent e) {
			switcherCaseRegimeAcheterAuMarché(village);
			raffraichirCase (village, cl, flowCases);
		} }); 



		cl.add(c1);cl.add(c2);cl.add(c3);cl.add(c4);cl.add(c5);cl.add(c6);


		raffraichirCase (village, cl, flowCases);




		flowCases.getChildren().addAll(c1, c2, c3, c4, c5, c6);
		flowCases.setOrientation(Orientation.VERTICAL);
		flowCases.setPrefSize(100, 50);
		flowCases.setHgap(0);
		flowCases.setVgap(0);
		//	flowCases.getStyleClass().add("fake3");
		flowCases.setAlignment(Pos.CENTER_LEFT);
		//	flowCases.setOpacity(0.4);


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























	public void raffraichirCase (Village village, ArrayList<CheckBox> cl, FlowPane flowCases ){



		for(CheckBox c : cl){ 
			//c.setSelected(true);

			//	c.setPadding(new Insets(0,0,0,0));
			//	c.setAlignment(Pos.CENTER);
			c.setPadding(new Insets(12,12,12,12));
			if(c.isSelected()){
				c.getStyleClass().clear(); //suprime tout attention
				c.getStyleClass().add("fake3");

				//	c.setStyle(   "-fx-font-size: 20;"
				/*    + "-fx-border-color: lightblue; "
					    + "-fx-border-insets: -5; "
					    + "-fx-border-radius: 5;"
					    + "-fx-border-style: dotted;"
					    + "-fx-border-width: 2;"*/
				//	);
			}
			else {
				c.getStyleClass().clear(); //suprime tout attention
				c.getStyleClass().add("off");

			}
		}



		//

	}



























	@FXML 
	public void  faireOngletTemplate() {
		TabPane onglets = new TabPane();
		fxTemplate.getChildren().clear();
		VBox c = faireEditeurDeTemplate(bot.getTemplateLancerBot());
		fxTemplate.getChildren().add(c);
        c.setCache(true);
        c.setCacheHint(CacheHint.QUALITY);

		int i = 0;
		
		try {
			//village
			for(Village village : bot.travian.getListeDeVillages()) {
				Tab tab = new Tab();
				VBox v =  faireSelecteurDeTemplateDeVillage(village, i);
				
		        v.setCache(true);
		        v.setCacheHint(CacheHint.QUALITY);//  v.setCacheHint(CacheHint.QUALITY);
				ScrollPane sc=new ScrollPane();
				sc.setContent(v);
				 tab.setContent(sc);
				 sc.setFitToWidth(true);
				 tab.setText(village.getNom());
				 onglets.getTabs().add(tab);
				
				 i++;

			}
			 fxTemplate.getChildren().add(onglets);
		}catch (Exception e) {

		}


	}

















	public VBox faireSelecteurDeTemplateDeVillage(Village village, int i) {



		VBox vbv= new VBox();
		//village








		if (i % 2 == 0) {
			vbv.getStyleClass().remove("fake3");
			vbv.getStyleClass().remove("off");
			vbv.getStyleClass().add("ctemplateV1");

		} else {
			vbv.getStyleClass().remove("fake3");
			vbv.getStyleClass().remove("off");
			vbv.getStyleClass().add("ctemplateV2");



		}

		VBox e = selecteur(village, vbv, i);
		vbv.getChildren().add(e);

		return vbv;
	}
























	public VBox selecteur(Village village, VBox vbv,  int i  ) {
		VBox vbv2Creation= new VBox();

		ComboBox<TemplatesDeVillages> listeDeroulante  = new ComboBox<TemplatesDeVillages>();
		FlowPane nomVillage = new FlowPane();
		Label nomVLabel = new Label(village.getNom());
		nomVLabel.getStyleClass().add("vLabel");
		nomVLabel.setPrefHeight(25);
		nomVLabel.setPadding(new Insets(5, 15, 5, 15));

		vbv.setPadding(new Insets(15, 15, 15, 15));


		nomVillage.getChildren().addAll(nomVLabel,listeDeroulante);
		vbv.getChildren().add(nomVillage);

		//Liste deroulante
		/////////////////////////////////////////////////////////////////////////////////////////// Liste Deroulante

		final ObservableList<TemplatesDeVillages> listeDeroulanteData = FXCollections.observableArrayList();
		for(TemplatesDeVillages t :  bot.listeDeTemplates) {	
			listeDeroulanteData.add(t);
		}	
		listeDeroulante.setItems(listeDeroulanteData);
		//listeDeroulante.getSelectionModel().select(tem);
		listeDeroulante.setConverter(new StringConverter<TemplatesDeVillages>() {
			@Override
			public String toString(TemplatesDeVillages t) {
				if (t == null) {
					return null;
				} else {
					return t.getNomDuTemplate();
				}
			}
			@Override
			public TemplatesDeVillages fromString(String tString) {
				return null; // No conversion fromString needed.
			}
		});
		//Handle ComboBox event.

		listeDeroulante.setOnAction((event) -> {
			TemplatesDeVillages selectedTemplatesDeVillages = listeDeroulante.getSelectionModel().getSelectedItem();
			System.out.println("ComboBox Action (selected: " + selectedTemplatesDeVillages.toString() + ")");

			boolean trouver = false;
			for(TemplatesDeVillages temp : village.getListeDeTemplates()) {

				if(temp.getNomDuTemplate().equals(selectedTemplatesDeVillages.getNomDuTemplate()) ) {
					trouver = true;
				}	

			}
			if (trouver==false) {village.getListeDeTemplates().add(selectedTemplatesDeVillages);

			vbv2Creation.getChildren().clear();
			for(TemplatesDeVillages tem : village.getListeDeTemplates()) {
				if (!tem.getNomDuTemplate().equals("")) {
					VBox s = stade(village, vbv2Creation, i, tem);
					vbv2Creation.getChildren().add(s);
					faireOngletTemplate();
				}
			}
			}
		});

		/*          				
		 * if(i== 0) {
	bot.faireUnTemplateDeCompte(1);
	}*/

		//template



		for(TemplatesDeVillages tem : village.getListeDeTemplates()) {
			if (!tem.getNomDuTemplate().equals("")) {
				VBox s = stade(village, vbv2Creation, i, tem);
				vbv2Creation.getChildren().add(s);
			}
		}
		return vbv2Creation;






	}

	public void initAutoriserAPoserBatBox(TemplatesDeVillages tem, CheckBox autoriserAPoserBatBox){

		if (tem.getAutoriserAPoserBatiment() == true) {
			autoriserAPoserBatBox.setSelected(true);
		} else
			autoriserAPoserBatBox.setSelected(false);

		
	}




	private void switcherAutoriserAPoserBat(TemplatesDeVillages tem) {
		if (tem.getAutoriserAPoserBatiment() == true) {
			tem.setAutoriserAPoserBatiment(false) ;
		} else {
			tem.setAutoriserAPoserBatiment(true);
		}
	}
	public void raffraichirCase (Village village, FlowPane Fc , CheckBox c){


			if(c.isSelected()){
				c.getStyleClass().remove("off");
				c.getStyleClass().remove("fake3");
				c.getStyleClass().add("fake3");


			}
			else {
				c.getStyleClass().remove("off");
				c.getStyleClass().remove("fake3");
				c.getStyleClass().add("off");

			}
		}






	public VBox stade(Village village, VBox vbv2Creation,  int i, TemplatesDeVillages tem   ) {

		VBox vbv2= new VBox();
		Label nomTemLabel = new Label(tem.nomDuTemplate );
		FlowPane templateChooser = new FlowPane();
		FlowPane caseAutoriserBatFlowPane =new FlowPane();
		Label nomStade = new Label("   Quand le champs le plus petit est   ");
		//nomStade.setTextFill(Color.WHITE);
		TextField textStade1 = new TextField();
		textStade1.setPadding(new Insets(0, 0, 0, 0));
		textStade1.setPrefColumnCount(2);
		Label et = new Label(" et ");
		Label a1 = new Label(" à ");
		Label a2 = new Label(" à ");
		TextField textStade2 = new TextField();
		textStade2.setPadding(new Insets(0,0,0,0));
		textStade2.setPrefColumnCount(2);

		ChoiceBox<String> cb1 = new ChoiceBox<String>();
		ObservableList<String> obs =  FXCollections.observableArrayList("",  "<", "<=", "=", ">=", ">" );
		cb1.setItems(obs);
		cb1.getStyleClass().add("listeDeroulante");
		cb1.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observableValue, Number number, Number number2) {
				System.out.println(cb1.getItems().get((Integer) number2));
				tem.setOperateur1(cb1.getItems().get((Integer) number2));
			}
		});
		for (String it : obs) {
			if(tem.getOperateur1().equals(it)) {
				cb1.getSelectionModel().select(it);
			}
		}

		 textStade1.setText(String.valueOf(tem.getChampMin1()));
		textStade1.setOnAction((event) -> {
			tem.setChampMin1(Integer.parseInt(textStade1.getText()));
		});
		
		

		
		
		
		
		
		
		
		
		
		

		ChoiceBox<String> cb2 = new ChoiceBox<String>();
		cb2.setItems(FXCollections.observableArrayList(
				"", "<", "<=", "=", ">=", ">" 
				)
				);
		cb2.getStyleClass().add("listeDeroulante");
		cb2.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observableValue, Number number, Number number2) {
				System.out.println(cb2.getItems().get((Integer) number2));
				tem.setOperateur2(cb2.getItems().get((Integer) number2));
			}
		});
		for (String it : obs) {
			if(tem.getOperateur2().equals(it)) {
				cb2.getSelectionModel().select(it);
			}
		}
		
		 textStade2.setText(String.valueOf(tem.getChampMin2()));
		textStade2.setOnAction((event) -> {
			tem.setChampMin2(Integer.parseInt(textStade2.getText()));
		});
		

		/*


for(TemplatesDeVillages t :  bot.listeDeTemplates) {	
listeDeroulante.getItems().add(t.getNomDuTemplate());
listeDeroulante.setOnAction((e) -> {
System.out.println(listeDeroulante.getSelectionModel().getSelectedItem());
});
}
Button button = new Button("Select First");
button.setOnMouseClicked((e) -> {
listeDeroulante.getSelectionModel().selectFirst();
System.out.println("The button did it!");
});

		 */
		/////////////////////////////////////////////////////////////////////
		
		CheckBox autoriserAPoserBatBox = new CheckBox("Autoriser à poser Batiment ?");
		autoriserAPoserBatBox.setTextFill(Color.WHITE);
		caseAutoriserBatFlowPane.getChildren().add(autoriserAPoserBatBox);
		if(village.getTemplate().getAutoriserAPoserBatiment() == true) { autoriserAPoserBatBox.setSelected(true);}else {autoriserAPoserBatBox.setSelected(false);}
		autoriserAPoserBatBox.setOnAction(new EventHandler<ActionEvent>() { @Override public void handle(ActionEvent e) {
			switcherAutoriserAPoserBat( tem);
			 raffraichirCase(village, caseAutoriserBatFlowPane, autoriserAPoserBatBox);
		///	raffraichirCase (village, cl, flowCases);
		} }); 
		initAutoriserAPoserBatBox(tem, autoriserAPoserBatBox);
		 raffraichirCase(village,caseAutoriserBatFlowPane, autoriserAPoserBatBox);
		 
		 caseAutoriserBatFlowPane.setAlignment(Pos.CENTER_LEFT);
		 caseAutoriserBatFlowPane.setMaxWidth(82);
		 caseAutoriserBatFlowPane.setPadding(new Insets(0, 0, 0, 12));
		 
		 

		////////////////////////////////////////////////////////////////////////
		 FlowPane prioriteFlow = new FlowPane();
		 Label prioriteLabel = new Label("Priorité/ordre : ");
			TextField priorite = new TextField();
			
			prioriteFlow.getChildren().addAll(prioriteLabel, priorite);
			priorite.setText(String.valueOf(tem.getPriorite()));
			priorite.setPrefColumnCount(2);
			priorite.setPadding(new Insets(0, 0, 0, 0));
			prioriteLabel.setTextFill(Color.WHITE);
			prioriteFlow.setAlignment(Pos.CENTER_LEFT);
			prioriteFlow.setPadding(new Insets(0, 0, 0, 12));
			
			priorite.setOnAction((event) -> {
				tem.setPriorite(Integer.parseInt(priorite.getText()));
				tem.trierListe(village.getListeDeTemplates());
			});
		
		
		/////////////////////////////////////////////////////////////////////

		templateChooser.getChildren().addAll(nomTemLabel, nomStade, cb1, a1, textStade1, et, cb2, a2, textStade2, caseAutoriserBatFlowPane, prioriteFlow );


		FlowPane flowb = new FlowPane();

		templateChooser.getStyleClass().add("stade2");
		vbv2.getChildren().add(templateChooser);
		vbv2.getChildren().add(flowb);
		vbv2.getStyleClass().add("stade");

		///////////////////////////////////////////////////////////////

		///////////////////////////////////////////////////////////////
		ContextMenu contextMenu = new ContextMenu();
		flowb.addEventHandler(MouseEvent.MOUSE_CLICKED,new EventHandler<MouseEvent>() {
			@Override public void handle(MouseEvent e) {
				if (e.getButton() == MouseButton.SECONDARY)  {
					contextMenu.getItems().clear();
					for(Batiment bataj : village.getTemplate().listeDeBatimentDuJeu) { 
						MenuItem contextMenuItem = new MenuItem(bataj.getNomBatiment());
						contextMenu.getItems().add(contextMenuItem);
						contextMenuItem.setOnAction(new EventHandler<ActionEvent>() {
							public void handle(ActionEvent e) {
								tem.listeDeBatiments.add(bataj);

							}
						});
					}
					contextMenu.show(flowb, e.getScreenX(), e.getScreenY());
					e.consume();
				}
			}
		});
		
		
		///////////////////////////////////////////////////////////////////////////////
		
		ContextMenu contextMenuDelete = new ContextMenu();
		vbv2.addEventHandler(MouseEvent.MOUSE_CLICKED,new EventHandler<MouseEvent>() {
			@Override public void handle(MouseEvent e) {
				if (e.getButton() == MouseButton.SECONDARY)  {
					contextMenuDelete.getItems().clear();

					MenuItem contextMenuDeleteItem = new MenuItem("Supprimer ce Stade");
					contextMenuDelete.getItems().add(contextMenuDeleteItem);
					contextMenuDeleteItem.setOnAction(new EventHandler<ActionEvent>() {
						public void handle(ActionEvent e) {
							village.listeDeTemplates.remove(tem);
							vbv2Creation.getChildren().remove(vbv2);
						}
					});

					contextMenuDelete.show(vbv2, e.getScreenX(), e.getScreenY());
					e.consume();
				}
			}
		});
		

		///////////////////////////////////////////////////////////////////////////////	
		/*	flowb.setOnMouseClicked(new EventHandler<MouseEvent>() {

	            @Override
	            public void handle(MouseEvent event) {
	                MouseButton button = event.getButton();
	                if(button==MouseButton.PRIMARY){



	                }else if(button==MouseButton.SECONDARY){


	                }else if(button==MouseButton.MIDDLE){
	                  //  label.setText("MIDDLE button clicked on button");
	                }
	            }
	        });



		 */


		//bat

		/*	for(Batiment bat : tem.listeDeBatiments) {


		flowb.getChildren().add(paneBatimentVillages( bat,  tem));

		if (i % 2 == 0) {
			vbv.getStyleClass().remove("fake3");
			vbv.getStyleClass().remove("off");
			vbv.getStyleClass().add("fake3");

		} else {
			vbv.getStyleClass().remove("fake3");
			vbv.getStyleClass().remove("off");
			vbv.getStyleClass().add("off");

		}



	}*/
		for(Batiment bat : tem.listeDeBatiments) {
			Pane fta = paneBatimentVillages( bat,  tem);

			for(Batiment b : village.getBatiments()) {
				if(b.getNomBatiment().equals(bat.getNomBatiment()) && b.getLevelBatiment() >= bat.getLevelBatiment()) {
					fta.getChildren().get(0).getStyleClass().remove("lesBatsTemFaitGreen");
					fta.getChildren().get(0).getStyleClass().add("lesBatsTemFaitGreen");
					fta.getStyleClass().remove("pink");
					fta.getStyleClass().remove("lesBatsTem");
					fta.getStyleClass().add("lesBatsTemFait");

				}
			}

			flowb.getChildren().add(fta);
		}


		return vbv2;



	}











































	public VBox faireEditeurDeTemplate(TemplatesDeVillages templateSelectione) {


		int i = 0;
		VBox vbv= new VBox();
		//village





		int i2 = 0;
		i2++;

		if (i % 2 == 0) {
			vbv.getStyleClass().remove("fake3");
			vbv.getStyleClass().remove("off");
			vbv.getStyleClass().add("cEditeur");

		} else {
			vbv.getStyleClass().remove("fake3");
			vbv.getStyleClass().remove("off");
			vbv.getStyleClass().add("cEditeur");



		}

		VBox e = editeur(vbv , templateSelectione);
		vbv.getChildren().add(e);

		return vbv;
	}




















	public VBox editeur(VBox vbv, TemplatesDeVillages templateSelectione) {
		VBox vbv2Creation= new VBox();
		try{


			FlowPane flowb = new FlowPane();
			//template


			Label nomVLabel = new Label("Editeur de Template");
			nomVLabel.getStyleClass().add("vLabel");
			nomVLabel.setPrefHeight(25);
			nomVLabel.setPadding(new Insets(5, 15, 5, 15));
			
			vbv.setPadding(new Insets(15, 15, 15, 15));



			Label nomTemLabel = new Label(templateSelectione.nomDuTemplate  + " Nom Template : ");
			TextField nomDuTemplate1 = new TextField();
			nomDuTemplate1.setPadding(new Insets(0, 0, 0, 0));
			nomDuTemplate1.setPrefColumnCount(15);


			Button saveTemplate = new Button("Creer Template vide");
			FlowPane templateChooser = new FlowPane();


			/////////////////////////////////////////////////////////////////////////////////////////// Liste Deroulante
			ComboBox<TemplatesDeVillages> listeDeroulante  = new ComboBox<TemplatesDeVillages>();
			listeDeroulante.getSelectionModel().select(templateSelectione);
			final ObservableList<TemplatesDeVillages> listeDeroulanteData = FXCollections.observableArrayList();
			for(TemplatesDeVillages t :  bot.listeDeTemplates) {	
				listeDeroulanteData.add(t);


			}
			listeDeroulante.setItems(listeDeroulanteData);
			listeDeroulante.getSelectionModel().select(templateSelectione);
			listeDeroulante.setConverter(new StringConverter<TemplatesDeVillages>() {
				@Override
				public String toString(TemplatesDeVillages t) {
					if (t == null) {
						return null;
					} else {
						return t.getNomDuTemplate();
					}
				}
				@Override
				public TemplatesDeVillages fromString(String tString) {
					return null; // No conversion fromString needed.
				}
			});
			//Handle ComboBox event.
			listeDeroulante.setOnAction((event) -> {
				TemplatesDeVillages selectedTemplatesDeVillages = listeDeroulante.getSelectionModel().getSelectedItem();
				System.out.println("ComboBox Action (selected: " + selectedTemplatesDeVillages.toString() + ")");


				bot.getTemplateLancerBot().getListeDeBatiments().clear();
				for(Batiment b : selectedTemplatesDeVillages.listeDeBatiments){
					bot.getTemplateLancerBot().listeDeBatiments.add(b);

				}
				bot.getTemplateLancerBot().getListeDeBatiments().clear();
				vbv.getChildren().clear();


				vbv.getChildren().add(editeur(vbv,bot.trouverTemplate(selectedTemplatesDeVillages.nomDuTemplate)));
			});
			/*


 for(TemplatesDeVillages t :  bot.listeDeTemplates) {	
	listeDeroulante.getItems().add(t.getNomDuTemplate());
	listeDeroulante.setOnAction((e) -> {
        System.out.println(listeDeroulante.getSelectionModel().getSelectedItem());
   });
}
Button button = new Button("Select First");
button.setOnMouseClicked((e) -> {
	listeDeroulante.getSelectionModel().selectFirst();
    System.out.println("The button did it!");
});



			 */
			/////////////////////////////////////////////////////////////////////


			templateChooser.getChildren().addAll(nomVLabel, nomTemLabel, nomDuTemplate1,listeDeroulante,saveTemplate);




			saveTemplate.setOnAction(new EventHandler<ActionEvent>() {
				@Override public void handle(ActionEvent e) {

					if(bot.creerNouveauTemplate(nomDuTemplate1.getText())) {
						bot.trouverTemplate(nomDuTemplate1.getText()).listeDeBatiments.clear();
						saveTemplate.setText("save");

						for(Batiment b : bot.getTemplateLancerBot().listeDeBatiments) {


							bot.trouverTemplate(nomDuTemplate1.getText()).listeDeBatiments.add(b);



						}
						vbv.getChildren().clear();
						vbv.getChildren().add(editeur(vbv,bot.trouverTemplate(nomDuTemplate1.getText())));
						faireOngletTemplate();

					}

				}
			});



			flowb.setMinHeight(40);
			vbv2Creation.getChildren().add(templateChooser);
			vbv2Creation.getChildren().add(flowb);
			vbv2Creation.getStyleClass().add("lesCheckBoxs");

			///////////////////////////////////////////////////////////////
			ContextMenu contextMenu = new ContextMenu();
			flowb.addEventHandler(MouseEvent.MOUSE_CLICKED,new EventHandler<MouseEvent>() {
				@Override public void handle(MouseEvent e) {
					if (e.getButton() == MouseButton.SECONDARY)  {
						contextMenu.getItems().clear();
						for(Batiment bataj : bot.getTemplateLancerBot().listeDeBatimentDuJeu) { 
							MenuItem contextMenuItem = new MenuItem(bataj.getNomBatiment());
							contextMenu.getItems().add(contextMenuItem);
							contextMenuItem.setOnAction(new EventHandler<ActionEvent>() {
								public void handle(ActionEvent e) {
									templateSelectione.listeDeBatiments.add(bataj);

									flowb.getChildren().add( paneBatimentVillages( bataj,  templateSelectione));
								}
							});
						}
						contextMenu.show(flowb, e.getScreenX(), e.getScreenY());
						e.consume();
					}
				}
			});
			for(Batiment bat : templateSelectione.listeDeBatiments) {
				flowb.getChildren().add(paneBatimentVillages( bat,  templateSelectione));

			}



		}catch(Exception e) {

		}
		return vbv2Creation;

	}












	public Pane paneBatimentVillages(Batiment bat, TemplatesDeVillages templateSelectione) {
		FlowPane stackP  = new FlowPane();

		Label ta = new Label(bat.getNomBatiment());
		TextField tf = new TextField(String.valueOf(bat.getLevelBatiment()));

		tf.setPadding(new Insets(0,0,0,5));
		tf.setPrefColumnCount(2);
		ta.setPadding(new Insets(0,5,0,5));


		stackP.getChildren().addAll(ta,tf); 
		stackP.setMaxWidth(170);
		stackP.setMaxHeight(19);
		stackP.setMinHeight(19);


		Pane fta = new Pane();

		fta.getStyleClass().add("lesBatsTem"); //fta.getStyleClass().add("pink");


		fta.getChildren().add(stackP);


		ContextMenu contextMenuDelete = new ContextMenu();
		fta.addEventHandler(MouseEvent.MOUSE_CLICKED,new EventHandler<MouseEvent>() {
			@Override public void handle(MouseEvent e) {
				if (e.getButton() == MouseButton.SECONDARY)  {
					contextMenuDelete.getItems().clear();

					MenuItem contextMenuDeleteItem = new MenuItem("Suprimer "+bat.getNomBatiment());
					contextMenuDelete.getItems().add(contextMenuDeleteItem);
					contextMenuDeleteItem.setOnAction(new EventHandler<ActionEvent>() {
						public void handle(ActionEvent e) {
							templateSelectione.listeDeBatiments.remove(bat);
							fta.getChildren().remove(stackP);
						}
					});

					contextMenuDelete.show(fta, e.getScreenX(), e.getScreenY());
					e.consume();
				}
			}
		});


		tf.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {

				int level = Integer.parseInt(tf.getText());
				bat.setLevelBatiment(level);



			}






		});
		return fta;		

	}








}












