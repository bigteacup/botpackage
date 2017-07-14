package botpackage;

import java.io.IOException;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.ScrollPane;
import javafx.scene.effect.Bloom;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;


public class FxFenetre extends Application {
	//fx:controller="botpackage.FxFenetreController"
	//Le constructeur JAVAFX doit avoir un construteur sans parametre, et utiliser un "getconfig" de ce style dans la classe appelante.
						// public static Lancerbot getConfig() {
						// 	return new Lancerbot();
    					//	}
  //  public FxFenetre() {

    //    this.bot = Lancerbot.getBot();
      //  bot.lancerTravian("http://ts2.travian.fr/", "Drap-housse", "6dst5rhx");

  //  }
 

	  Lancerbot bot;
	  Travian t;
	  
	    public  FxFenetreController controller;
	   


	  public void setBot(Lancerbot bot){
		  this.bot = bot;

	  }



	  @Override
	  public void start(Stage primaryStage) {


	        	primaryStage.setTitle("TimTools lite");
	        	controller = new FxFenetreController();

		  

		

	        
	

	     
	        

	        FXMLLoader loader = new FXMLLoader(getClass().getResource("fxFenetre.fxml"));
	        loader.setController(controller);
	      //  loader.setLocation(getClass().getResource("fxFenetre.fxml"));//getClass().getResource("FxFenetre.fxml")
	        Parent myPane = null;
			try {
				myPane = (Parent) loader.load();
			} catch (IOException e) {e.printStackTrace();
			}
	        Scene myScene = new Scene(myPane);

	        myScene.getStylesheets().add(FxFenetre.class.getResource("fxconsole.css").toExternalForm());
	        
	       
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


	      //TODO investiguer les possibilitées :  fenetre de question type etesvoussur? ou autre 

	        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {

	            @Override
	            public void handle(WindowEvent event) {
	            			controller.bot.eteindreTravian();
	            			
	                    //	 event.consume();  //genial mais pas utile ici


	                        System.out.println("Application fermée par croix rouge (X)");

	                       // System.exit(5000);
	                    }
	                });
	            
	   
	         
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	        
	        
	        
	        
	        
	        primaryStage.setScene(myScene);
	        //this.initStyle(StageStyle.TRANSPARENT);
	       
	        primaryStage.show();
	        
	    }




    public static void main(String[] args) {
    	launch(args);
    	

    }








 /*   public void allumer(){
    	System.out.println("on");
    	try {
			if (bot.travian.allume == false){
				String serveur = serveurj.getText();

				String userName = userNamej.getText();
				String motDePasse = motDePassej.getText();
				bot.lancerTravian(serveur, userName, motDePasse );
			}
		}catch (Exception e1){
			String serveur = serveurj.getText();
			String userName = userNamej.getText();
			String motDePasse = motDePassej.getText();
			bot.lancerTravian(serveur, userName, motDePasse );}

				String nomDeCompte = nomDeComptej.getText();
				String motDePasse = motDePassej.getText();
				bot.lancerTravian(serveur, nomDeCompte, motDePasse );
			}
		}catch (Exception e1){
			String serveur = serveurj.getText();
			String nomDeCompte = nomDeComptej.getText();
			String motDePasse = motDePassej.getText();
			bot.lancerTravian(serveur, nomDeCompte, motDePasse );}

		//	System.out.println(bot.getName());
		//    System.out.println(bot.getState());
    	}
*/
 
    
  ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////  
    /*
     * 
    ////override methode Stop du Stage
    @Override
  public void stop(){
    	
    	//consume();
    	controller.resize(25.0, 25.0);
    	//System.exit(50000);
        // Platform.exit());
       // System.exit(5000);
        System.out.println("Stage is closing");
    }
    
    
  */  
    
    
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////  
}





