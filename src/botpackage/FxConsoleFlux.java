package botpackage;



import java.io.IOException;



public class FxConsoleFlux { // extends Thread 
	//private boolean faireDefiler = true;
	Lancerbot bot;
	FxFenetreController fxFenetreController;
	boolean enPause;

	public FxConsoleFlux(FxFenetreController fxFenetreController) {
		this.fxFenetreController = fxFenetreController;
		
	/*	try {
			flux(fxFenetreController);
		} catch (IOException e) {e.printStackTrace();
		}*/
		
	}

	public void run() {

	/*	while (true) {
			try {
				flux(fxFenetreController);
			} catch (IOException e) {e.printStackTrace();}
		}*/
		}

/*
public void flux(FxFenetreController fxFenetreController) throws IOException{
    StringBuilder sb = new StringBuilder();
        
    System.setOut(new PrintStream(new OutputStream() {

	         @Override
	         public void write(int b) throws IOException {
	           sb.append((char)b);
	          
	          if (b == '\n') { //b == ' ' || b == '\t' || b == '\r' || 
	        	  
	        	   	 envoyer(fxFenetreController, sb.toString());   
	        	   	 sb.setLength(0);
	        	   	 
	        	   	 
	          }
	         
	}
}));

	
 
  	 //sb.setLength(0);	
}
	
*/		

public void retour(String retour){
	
	
} 
public void envoyer(FxFenetreController fxFenetreController, String ligne) throws IOException{
	/*
	 * ArrayList<String> listeMotsCouleurfinal = null ;
		ArrayList<String> listeMotsCouleur ;

	listeMotsCouleur = fxFenetreController.console.chargerMotsAColorier();
	listeMotsCouleurfinal = listeMotsCouleur;

	
	*/
	//TODO precalculer la liste des mots a colorier.
	javafx.application.Platform.runLater( () ->{  	

	try { //TODO console textFlow 2
////	//	fxFenetreController.console.fxConsoleColored(fxFenetreController, ligne +"\n" );//listeMotsCouleurfinal
	/*	Lighting lighting = new Lighting();
		Bloom bloom = new Bloom();
		bloom.setThreshold(0.01);
		Glow glow = new Glow(0.9);
		
        DropShadow ds = new DropShadow();
        ds.setOffsetY(3.0);
        ds.setOffsetX(3.0);
        ds.setColor(Color.GRAY);
         Reflection r = new Reflection();
        r.setFraction(0.75);
*
*/
                fxFenetreController.console.fxConsoleColored(fxFenetreController, ligne +"\n"  );
                
      //  StyleClassedTextArea ligneeffet = fxFenetreController.console.fxConsoleColored(fxFenetreController, ligne +"\n"  );
      //  ligneeffet.setStyle(".scroll-bar{-fx-background-color: rgb(96,96,96);-fx-background-radius: 2em;}");
        //ligneeffet.setEffect(glow);
      //  ligneeffet.getStyleClass().clear();
   //    ligneeffet.getStyleClass().add("x");
       
      // ligne.getStyleClass().add("x");

	//	fxFenetreController.console.fxConsoleTextArea(fxFenetreController, ligne +"\n" );//listeMotsCouleurfinal 
	} catch (Exception e) {
	}
	});

	
	

	
}




public synchronized void pause(){
	enPause = true;
	
}
public synchronized void enleverpause(){
	enPause = false;
	

}
}
