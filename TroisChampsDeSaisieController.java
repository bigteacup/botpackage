package botpackage;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
public class TroisChampsDeSaisieController {
	public Lancerbot bot;
	




	
    @FXML
     ResourceBundle resources;

    @FXML
     URL location;

	@FXML
	TextField userName;

	@FXML
	 PasswordField motDePasse;

	@FXML TextField serveur;

   
    @FXML
    void initialize() {
    	 assert serveur!= null : "fx:id=\"serveur\" was not injected: check your FXML file 'troisChampsDeSaisies.fxml'.";
         assert motDePasse != null : "fx:id=\"motDePasse\" was not injected: check your FXML file 'troisChampsDeSaisie.fxml'.";
         assert userName != null : "fx:id=\"userName\" was not injected: check your FXML file 'troisChampsDeSaisie.fxml'.";
         
    }

    @FXML
	private void userName() {
		userName.setText("login");
	/*	if (bot.pillage == true) {
			bot.pillage = false;
		} else {
			bot.pillage = true;
		}*/
	}
	@FXML
	private void server() {
		serveur.setText("serveur");
	/*	if (bot.pillage == true) {
			bot.pillage = false;
		} else {
			bot.pillage = true;
		}*/
	}
	@FXML
	private void motDePasse() {
		motDePasse.setText("mdp");
	/*	if (bot.pillage == true) {
			bot.pillage = false;
		} else {
			bot.pillage = true;
		}*/
	}
    
    public void setBot(Lancerbot bot){
    	this.bot = bot;
    }
    
    
}












