package botpackage;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class FxOngletParametresController {
	public Lancerbot bot;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;



    @FXML
    private TextField delaisAventures;

    @FXML
    private TextField evacuerAPartirDe;

    @FXML
    private TextField pourcentageNePasLaisserLeVillageSourceEnDessousDe;

    @FXML
    private TextField champMinFx;

    @FXML
    private TextField pourcentageApproPetitVillageFx;

    @FXML
    private TextField ressourcesMiniSurVillageSourceFx;

    @FXML
    private TextField rythmePillage;

    @FXML 
    private TextField distanceMaxPourMarchands;
    
    @FXML
    private TextField vitesseMarchands; 
    
    @FXML
    private TextField idDeLaListeDePillage; 
    
    @FXML 
    private TextField motCleListeDesPertes;
    
    @FXML 
    private TextField motCleListeDePillage1;
    
    @FXML
    private TextField idTempsMax;

    @FXML 
    private TextField idMarchandsMinPourFonctionner;
    
    @FXML
    private TextField idMarchandsAllouésPourAchat; 
    
    @FXML
    private TextField idPourcentageDeclenchementAcheter; 
    
    @FXML 
    private TextField idPourcentageDeclenchementAcheterContre;
    
    @FXML 
    private TextField idPourcentageDeclenchementAcheterContreMoyenne;
    
    @FXML 
    private TextField idPourcentageDeclenchementAcheterContreVillage;
    
    
    // approUrgenceFamine :
    @FXML 
    private TextField distanceMaxPourMarchandsApproUrgenceFamineFx;
    
    @FXML
    private TextField pourcentageApproUrgenceFamineFx;

    @FXML
    private TextField ressourcesMiniSurVillageSourceApproUrgenceFamineFx;
    
    @FXML
    private TextField  depotMiniPourFonctionnerApproUrgenceFamineFx;
    
    @FXML
    private TextField  marchandsMinPourFonctionnerApproUrgenceFamine;
   
   
    //@FXML
 //   comptesVBox ;  

    @FXML
    void initialize() {
        assert delaisAventures != null : "fx:id=\"delaisAventures\" was not injected: check your FXML file 'fxOngletParametres.fxml'.";
        assert evacuerAPartirDe != null : "fx:id=\"evacuerAPartirDe\" was not injected: check your FXML file 'fxOngletParametres.fxml'.";
        assert pourcentageNePasLaisserLeVillageSourceEnDessousDe != null : "fx:id=\"pourcentageNePasLaisserLeVillageSourceEnDessousDe\" was not injected: check your FXML file 'fxOngletParametres.fxml'.";
        assert champMinFx != null : "fx:id=\"champMinFx\" was not injected: check your FXML file 'fxOngletParametres.fxml'.";
        assert pourcentageApproPetitVillageFx != null : "fx:id=\"pourcentageApproPetitVillageFx\" was not injected: check your FXML file 'fxOngletParametres.fxml'.";
        assert ressourcesMiniSurVillageSourceFx != null : "fx:id=\"ressourcesMiniSurVillageSourceFx\" was not injected: check your FXML file 'fxOngletParametres.fxml'.";
        assert rythmePillage != null : "fx:id=\"rythmePillage\" was not injected: check your FXML file 'fxOngletParametres.fxml'.";
        assert idTempsMax != null : "fx:id=\"pourcentageNePasLaisserLeVillageSourceEnDessousDe\" was not injected: check your FXML file 'fxOngletParametres.fxml'.";
        assert idMarchandsMinPourFonctionner != null : "fx:id=\"champMinFx\" was not injected: check your FXML file 'fxOngletParametres.fxml'.";
        assert idMarchandsAllouésPourAchat != null : "fx:id=\"pourcentageApproPetitVillageFx\" was not injected: check your FXML file 'fxOngletParametres.fxml'.";
        assert idPourcentageDeclenchementAcheter != null : "fx:id=\"ressourcesMiniSurVillageSourceFx\" was not injected: check your FXML file 'fxOngletParametres.fxml'.";
        assert idPourcentageDeclenchementAcheterContre != null : "fx:id=\"rythmePillage\" was not injected: check your FXML file 'fxOngletParametres.fxml'.";
        assert idPourcentageDeclenchementAcheterContreMoyenne  != null : "fx:id=\"rythmePillage\" was not injected: check your FXML file 'fxOngletParametres.fxml'.";
        assert idPourcentageDeclenchementAcheterContreVillage != null : "fx:id=\"rythmePillage\" was not injected: check your FXML file 'fxOngletParametres.fxml'.";
    }
    
    @FXML
    private void delaisAventures(ActionEvent event) {
    	bot.delaisAventures = Integer.parseInt(delaisAventures.getText()) ; 
    }
    @FXML
    private void evacuerAPartirDe(ActionEvent event) {
    	bot.evacuerAPartirDe = Integer.parseInt(evacuerAPartirDe.getText()) ; 
    }
    @FXML
    private void pourcentageNePasLaisserLeVillageSourceEnDessousDe(ActionEvent event) {
    	bot.pourcentageNePasLaisserLeVillageSourceEnDessousDe = Integer.parseInt(pourcentageNePasLaisserLeVillageSourceEnDessousDe.getText()) ; 
    }
    @FXML
    private void champMinFx(ActionEvent event) {
    	bot.champMinFx = Integer.parseInt(champMinFx.getText()) ; 
    }
    @FXML
    private void pourcentageApproPetitVillageFx(ActionEvent event) {
    	bot.pourcentageApproPetitVillageFx = Integer.parseInt(pourcentageApproPetitVillageFx.getText()) ; 
    }
    @FXML
    private void ressourcesMiniSurVillageSourceFx(ActionEvent event) {
    	bot.ressourcesMiniSurVillageSourceFx = Integer.parseInt(ressourcesMiniSurVillageSourceFx.getText()) ; 
    }
    @FXML
    private void rythmePillage(ActionEvent event) {
    	bot.rythmePillage = Integer.parseInt(rythmePillage.getText()) ; 
    }
    @FXML
    private void distanceMaxPourMarchands(ActionEvent event) {
    	bot.distanceMaxPourMarchands = Integer.parseInt(distanceMaxPourMarchands.getText()) ; 
    }
    @FXML
    private void vitesseMarchands(ActionEvent event) {
    	bot.vitesseMarchands = Integer.parseInt(vitesseMarchands.getText()) ; 
    }
    
    @FXML
    private void idDeLaListeDePillage(ActionEvent event) {
    	bot.idDeLaListeDePillage = idDeLaListeDePillage.getText() ; 
    }
    
    @FXML
    private void motCleListeDesPertes(ActionEvent event) {
    	bot.motCleListeDesPertes = motCleListeDesPertes.getText() ; 
    }
    @FXML
    private void motCleListeaLancer(ActionEvent event) {
    	bot.motCleListeDePillage1 = motCleListeDePillage1.getText() ; 
    }
    /////////
    @FXML
    private void idTempsMax(ActionEvent event) {
    	bot.tempsMax = Integer.parseInt(idTempsMax.getText()) ; 
    }
    @FXML
    private void idMarchandsMinPourFonctionner(ActionEvent event) {
    	bot.marchandsMinPourFonctionner = Integer.parseInt(idMarchandsMinPourFonctionner.getText()) ; 
    }
    @FXML
    private void idMarchandsAllouésPourAchat(ActionEvent event) {
    	bot.marchandsAllouésPourAchat = Integer.parseInt(idMarchandsAllouésPourAchat.getText()) ; 
    }
    
    @FXML
    private void idPourcentageDeclenchementAcheter(ActionEvent event) {
    	bot.pourcentageDeclenchementAcheter = Integer.parseInt(idPourcentageDeclenchementAcheter.getText()) ; 
    }
    
    @FXML
    private void idPourcentageDeclenchementAcheterContre(ActionEvent event) {
    	bot.pourcentageDeclenchementAcheterContre = Integer.parseInt(idPourcentageDeclenchementAcheterContre.getText()) ; 
    }
    
    @FXML
    private void idPourcentageDeclenchementAcheterContreMoyenne(ActionEvent event) {
    	bot.pourcentageDeclenchementAcheterContreMoyenne = Integer.parseInt(idPourcentageDeclenchementAcheterContreMoyenne.getText()) ; 
    }
    
    @FXML
    private void idPourcentageDeclenchementAcheterContreVillage(ActionEvent event) {
    	bot.pourcentageDeclenchementAcheterContreVillage = Integer.parseInt(idPourcentageDeclenchementAcheterContreVillage.getText()) ; 
    }
    
    //motCleListeDesPertes
   
    // approUrgenceFamine
    @FXML
    private void distanceMaxPourMarchandsApproUrgenceFamine(ActionEvent event) {
    	bot.distanceMaxPourMarchandsApproUrgenceFamine = Integer.parseInt(distanceMaxPourMarchandsApproUrgenceFamineFx.getText()) ; 
    }
    @FXML
    private void pourcentageApproUrgenceFamineFx(ActionEvent event) {
    	bot.pourcentageApproPetitVillageFx = Integer.parseInt(pourcentageApproUrgenceFamineFx.getText()) ; 
    }
    
    @FXML
    private void depotMiniPourFonctionnerApproUrgenceFamineFx(ActionEvent event) {
    	bot.depotMiniPourAiderApproUrgenceFamineFx = Integer.parseInt(depotMiniPourFonctionnerApproUrgenceFamineFx.getText()) ; 
    }
    
    @FXML
    private void ressourcesMiniSurVillageSourceApproUrgenceFamineFx(ActionEvent event) {
    	bot.ressourcesMiniSurVillageSourceApproUrgenceFamineFx = Integer.parseInt(ressourcesMiniSurVillageSourceApproUrgenceFamineFx.getText()) ; 
    }
    @FXML
    private void  marchandsMinPourFonctionnerApproUrgenceFamine(ActionEvent event) {
    	bot.marchandsMinPourFonctionnerApproUrgenceFamine = Integer.parseInt(marchandsMinPourFonctionnerApproUrgenceFamine.getText()) ; 
    }
   
    public void setBot(Lancerbot bot){
    	this.bot = bot;
    }
    
    
}



