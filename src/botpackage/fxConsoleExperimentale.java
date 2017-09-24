package botpackage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.fxmisc.flowless.VirtualizedScrollPane;
import org.fxmisc.richtext.StyleClassedTextArea;

import javafx.collections.ListChangeListener;
import javafx.scene.Node;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.scene.web.WebView;


public class fxConsoleExperimentale  { //extends Thread
		
		Lancerbot bot;
		FxFenetreController fxFenetreController;
		FxConsoleFlux flux;
		boolean faireDefiler = true;
		

		public fxConsoleExperimentale(FxFenetreController fxFenetreController) {
			this.fxFenetreController = fxFenetreController;
			flux = new FxConsoleFlux(fxFenetreController);
			//FxConsoleFlux flux = new FxConsoleFlux(bot);
			
		}

		public void run() {
		//	flux = new FxConsoleFlux(fxFenetreController);

		//		flux.start();
				
				
			}
		
		

		ArrayList<String> motsaTester = new ArrayList<String>();
		String l1 [] = {"Attente", "echec", "Template Non Fini","Template Fini","Bois","Argile","Fer","Cereales","construireBatiment", "Fete","En Negatif = true",
						"Echec", "En Negatif = false", "Marché", "Marchands Dispos", "Ordre", "En Debordement" , "Debug", "gestionHeroProd", "Aventure"};
		
		volatile	StyleClassedTextArea ligne = new StyleClassedTextArea();
		volatile	 TextArea ligne2 = new  TextArea ();
	//	volatile	 TextFlow  ligne2 = new  TextFlow();
		boolean  ready = true;
		
		
	/*	
		public 
	boolean trouver = false;
			String mota = "null";
			
			for(String l : l1){if (fxFenetreController.bot.travian == null ){ motsaTester.add(l);}}
			if(fxFenetreController.bot.travian != null){
				for (Village v : fxFenetreController.bot.travian.getListeDeVillages()){
					mota = v.getNom();
					for(String motM : motsaTester){
				
					
						
							if (motM.equals(mota)){
							trouver = true;
							
							} 
							
						
						}	
				if (trouver == false){
					if (!mota.equals("null"))
					motsaTester.add(mota);
				}

				  }
				
			
			}

		*/
		//////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////
		//TODO console textFlow
		public TextArea fxConsoleTextArea(FxFenetreController fxFenetreController, String flux){
			ligne2.getStyleClass().add("consoleVBox");
			faireDefiler = fxFenetreController.bot.faireDefiler;
			boolean trouver = false;
			String mota = "null";
			Text node = new Text(flux);
		//	ligne2.setStyle("consoleVBox");
			
			
			ligne2.appendText(flux); //getChildren().add(node);
		//	if (ligne2.getChildren().size() == 1){ligne2.getStyleClass().add("consoleVBox"); }
			//ligne2.getStyleClass().add("x");
	//ligne2.setStyle("x"); //.scroll-bar{ -fx-backgrouolor: rgb(96,96,96); -fx-background-radius: 2em;}
			
			if (faireDefiler){

		                	
		               	fxFenetreController.fxConsolescrollpane.layout();
		//                fxFenetreController.fxConsolescrollpand-cne.setVvalue(1.0);
		                }
				fxFenetreController.fxConsolescrollpane.setContent(ligne2);
					
				

			
			
			
			
			
			
		/*	
			
			if (isFaireDefiler() == true ){
				
				ligne2.getChildren().addListener(
		                (ListChangeListener<Node>) ((change) -> {
		                	ligne2.layout();
		                	fxFenetreController.fxConsolescrollpane.layout();
		                	fxFenetreController.fxConsolescrollpane.setVvalue(1.0f);
		                }));
				fxFenetreController.fxConsolescrollpane.setContent(ligne2);
					
				}
		*/	
			///////////////                     originale
		/*
			for(String l : l1){if (fxFenetreController.bot.travian == null ){ motsaTester.add(l);}}
			if(fxFenetreController.bot.travian != null){
				for (Village v : fxFenetreController.bot.travian.getListeDeVillages()){
					mota = v.getNom();
					for(String motM : motsaTester){
				
					
						
							if (motM.equals(mota)){
							trouver = true;
							
							} 
					}	
				if (trouver == false){
					if (!mota.equals("null"))
					motsaTester.add(mota);
				}
			  }
			}
			
			int textSizeBefore = ligne2.getAccessibleText().length();
		if (ligne2.getAccessibleText().length() ==0){ligne2.getStyleClass().add("consoleVBox"); }

			
		//	javafx.application.Platform.runLater( () ->{   
				int end = flux.length();
				int c = textSizeBefore;
				
					ligne2.appendText(flux); 
					ligne2.setStyleClass(c , ligne2.getText().length(), "sbr3");
				

					/// matcher dans un range de fin, ou trouver debut derniere ligne, ou bah trouve duglandu  ou paragraphs
						try {
							if (motsaTester == null){
								System.out.println("liste mot null");}
						for(  String  mot : motsaTester){
							
							
							Pattern pattern = Pattern.compile(mot);
							Matcher matcher = pattern.matcher(flux);
							
							////////////////////////////////
							if(flux.contains(mot)){
																//int c = textSizeBefore;
								while(matcher.find()){
									int from = matcher.start();
						    		int to = matcher.end();
						    		
						    			ligne.setStyleClass(c+from, c+to, coloration (mot));
							}}
							
								}
						}catch (Exception e) {
							System.out.println("liste vide");}
		//	});
				
						if (isFaireDefiler() == false){
						//	bot.console.ligne.
						//	bot.fxFenetre.controller.vbox.snapPosition(ligne.getDocument().length());
							bot.fxFenetreController.fxConsolescrollpane.setVvalue(bot.fxFenetreController.fxConsolescrollpane.getVmax());
						}
			*/
			return ligne2;
			
			
		}
		///////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////// RICH TEXT 
///////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////
		
		public StyleClassedTextArea fxConsoleColored(FxFenetreController fxFenetreController, String flux) throws IOException{ //, ArrayList<String> motaTestdelasession
			faireDefiler = fxFenetreController.bot.faireDefiler;
			
			boolean trouver = false;
			String mota = "null";
			
			for(String l : l1){
				if (fxFenetreController.bot.travian == null ){
					motsaTester.add(l);
					}
				}
			if(fxFenetreController.bot.travian != null){
				for (Village v : fxFenetreController.bot.travian.getListeDeVillages()){
					mota = v.getNom();
					for(String motM : motsaTester){
							trouver = false;
					
					
						
							if (motM.equals(mota)){
							trouver = true;
							break;
							
							} 
					}	
				if (trouver == false){
					if (!mota.equals("null"))
					motsaTester.add(mota);
				}
			  }
			}
			
			int textSizeBefore = ligne.getLength();
		if (ligne.getLength() ==0){ligne.getStyleClass().add("consoleVBox"); }

			
		//	javafx.application.Platform.runLater( () ->{   
				int end = flux.length();
				int c = textSizeBefore;
				
					ligne.appendText(flux); 
					ligne.setStyleClass(c , ligne.getText().length(), "sbr3");
					//ligne.setStyle("x");


					/// matcher dans un range de fin, ou trouver debut derniere ligne, ou bah trouve duglandu  ou paragraphs
						try {
							if (motsaTester == null){
								System.out.println("liste mot null");}
						for(  String  mot : motsaTester){
							
							
							Pattern pattern = Pattern.compile(mot);
							Matcher matcher = pattern.matcher(flux);
							
							////////////////////////////////
							if(flux.contains(mot)){
																//int c = textSizeBefore;
								while(matcher.find()){
									int from = matcher.start();
						    		int to = matcher.end();
						    		
						    			ligne.setStyleClass(c+from, c+to, coloration (mot));
							}}
							
								}
						}catch (Exception e) {
							System.out.println("liste vide");}
		//	});
				
						if (isFaireDefiler() == true){
						//	bot.console.ligne.
						//	ligne.caretPositionProperty().getValue();
						//	int index = ligne.caretPositionProperty().getValue();
						//	fxFenetreController.fxConsolescrollpane.viewportBoundsProperty().
						//	fxFenetreController.vtScroll.autosize();
							//	int index = ligne.getText().indexOf(flux);
							ligne.showParagraphAtBottom(ligne.getParagraphs().size() - 1);
						//	ligne.selectRange(index, index);
							//fxFenetre.controller.vbox.snapPosition(ligne.getDocument().length());
					//	fxFenetreController.fxConsolescrollpane.setVvalue(fxFenetreController.fxConsolescrollpane.getVmax());
					//	fxFenetreController.setVvalue(fxFenetreController.getVmin());
					//	fxFenetreController.vtScroll.setV
					//	fxFenetreController.vvalueProperty(); 
						//fxFenetreController.vbox.getBaselineOffset();
							
						}
						
						return ligne;	
						
		}
			
			
			
			
		
		
		
		
		
		
		
		
		
		
		
		



		
		
		
		
		
		

		public void setFaireDefiler(boolean faireDefiler) {
			this.faireDefiler = faireDefiler;
		}

		
		public boolean isFaireDefiler() {
			return faireDefiler;
		}

		
		
		
		
		
		
		
		
		private String coloration(String str){


			if(str.contains("echec") || str.contains("En Negatif = true") || str.contains("Echec") || str.contains("Debug")){
				String classeCss = "console0";
					return classeCss;}



			if( str.contains("En Negatif = false")){
				String classeCss = "console1";
					return classeCss;}


			if( str.contains("Attente")){
				String classeCss = "console2";
					return classeCss;}

			if( str.contains("Template Non Fini")){
				String classeCss = "console3";
					return classeCss;}
			
			if( str.contains("Template Fini")){
				String classeCss = "console4";
				return classeCss;}
			
			if( str.contains("Bois")){
				String classeCss = "console5";
				return classeCss;}
			
			if( str.contains("Argile")){
				String classeCss = "console5";
				return classeCss;}
			
			if( str.contains("Fer")){
				String classeCss = "console5";
				return classeCss;}
			
			if( str.contains("Cereales")){
				String classeCss = "console5";
				return classeCss;}
			

			if( str.contains("construireBatiment")){
				String classeCss = "console6";
				return classeCss;}
			
			if( str.contains("Fete")){
				String classeCss = "console7";
				return classeCss;}
			
			if( str.contains("Marché")){
				String classeCss = "console10";
				return classeCss;}
			
			if( str.contains("Marchands Dispos")){
				String classeCss = "console10";
				return classeCss;}
		
			if( str.contains("Ordre")){
				String classeCss = "console8";
				return classeCss;}
			
			if( str.contains("En Debordement")){
				String classeCss = "console12";
				return classeCss;}
			
			if( str.contains("gestionHeroProd")||str.contains("Aventure")){
				String classeCss = "console1";
				return classeCss;}

			// ici la boucle pour le noms de villages   
			if(fxFenetreController.bot.travian != null){
			 for (Village v : fxFenetreController.bot.travian.getListeDeVillages()){
			if( str.contains(v.getNom())){
				String classeCss = "console9";
				return classeCss;}}
			}

			else {
				String classeCss = "sbr3";
			
			}
			return null;


		}

	}


