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
    void initialize() {
        assert delaisAventures != null : "fx:id=\"delaisAventures\" was not injected: check your FXML file 'fxOngletParametres.fxml'.";
        assert evacuerAPartirDe != null : "fx:id=\"evacuerAPartirDe\" was not injected: check your FXML file 'fxOngletParametres.fxml'.";
        assert pourcentageNePasLaisserLeVillageSourceEnDessousDe != null : "fx:id=\"pourcentageNePasLaisserLeVillageSourceEnDessousDe\" was not injected: check your FXML file 'fxOngletParametres.fxml'.";
        assert champMinFx != null : "fx:id=\"champMinFx\" was not injected: check your FXML file 'fxOngletParametres.fxml'.";
        assert pourcentageApproPetitVillageFx != null : "fx:id=\"pourcentageApproPetitVillageFx\" was not injected: check your FXML file 'fxOngletParametres.fxml'.";
        assert ressourcesMiniSurVillageSourceFx != null : "fx:id=\"ressourcesMiniSurVillageSourceFx\" was not injected: check your FXML file 'fxOngletParametres.fxml'.";
        assert rythmePillage != null : "fx:id=\"rythmePillage\" was not injected: check your FXML file 'fxOngletParametres.fxml'.";
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
    
    //motCleListeDesPertes
    
    
    
    
    public void setBot(Lancerbot bot){
    	this.bot = bot;
    }
    
    
}
