package botpackage;

import java.awt.Color;
import java.awt.Font;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import javax.swing.JTextPane;
import javax.swing.plaf.ColorUIResource;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class ConsoleSwing extends Thread {
	JTextPane consoleColor;
	private boolean faireDefiler = false;
	Lancerbot bot;
	
	public ConsoleSwing(Lancerbot bot) {
		this.bot = bot;
		//consoleColored();
	}
	



public JTextPane consoleColored() throws IOException{
	
	consoleColor = new JTextPane();
	    consoleColor.setFont(new Font("monospaced",Font.PLAIN,12));
	    consoleColor.setBackground(Color.BLACK);
	    consoleColor.setForeground(Color.LIGHT_GRAY);
		//StyledDocument docColor = (StyledDocument) consoleColor.getDocument();
		//consoleColor.setStyledDocument(docColor);
		 // int end = docColor.getDefaultRootElement().getElement(0).getEndOffset();
		
	//  Define a keyword attribute

		SimpleAttributeSet keyWord = new SimpleAttributeSet();
		
		
		
		
		 ////////raw motor/////////////////////////////////////////////////////////////
	    System.setOut(new PrintStream(new OutputStream() {
	         private StringBuilder sb = new StringBuilder();
	         private StringBuilder sbRef = new StringBuilder();
	         

	      ///   
	        
	         @Override
	         public void write(int b) throws IOException { 
	        	 int end1 = consoleColor.getDocument().getEndPosition().getOffset(); //pour fin de fichier entier
	           sb.append((char)b);
	           sbRef.append((char)b);
	         
	      ////////////////////////////////////////////////////////////////////////////
	      
	         
	           
	       //ajout de la liste de syntaxe COUPAGE DE MOT CORRIGER, SI DEUX IDENTIQUE MOT DANS MEME PHRASE CA COUPE.
	       ArrayList<String> motsaTester = new ArrayList<String>();
	           String l1 [] = {"Attente", "echec", "Template Non Fini","Template Fini","Bois","Argile","Fer","Cereales","construireBatiment", "Fete"};
	            for(String l : l1){motsaTester.add(l);}
	           for (Village v : bot.travian.getListeDeVillages()){motsaTester.add(v.getNom());}
	        	 
	           ///on regarde si ya une nouvelle ligne ou espace
	              if (b == ' ' || b == '\t' || b == '\r' || b == '\n') {
	            	  
	            	  String str = sb.toString();
	            	  String sbReference = sbRef.toString();
	            	   
	            	  String str3 = "motimporbable";
	            	 // String str4 = "";
	            	  int i = 0;
	            	  for(String mot : motsaTester){
	            		
	            	/*  if(str.contains(mot+125)){
	            		  while (str.contains(mot)){
	            		  String str2 = str.split(mot)[0];
	            		   str3 = str.split(mot)[1];

	            		  try {
	            			  consoleColor.getDocument().insertString(consoleColor.getDocument().getLength() , str2, coloration(str2));
	            			  consoleColor.getDocument().insertString(consoleColor.getDocument().getLength() , mot, coloration(mot));
	            			 // consoleColor.getDocument().insertString(consoleColor.getDocument().getLength() , str3, coloration(str3));
	            			 str = str3;
	                   			} catch (BadLocationException e1) {e1.printStackTrace();System.out.println("erreur cas 1");}
	            		    sb.setLength(0);
	            		  } 
	            		  }*/
	            	  ////////////////////////////////
	            	  if( sbReference.contains(mot)){
	            		  i++;
	            		  while (sbReference.contains(mot)){
	            		  String sbReference2 = sbReference.split(mot)[0];
	            		   String sbReference3 = sbReference.split(mot)[1];

	            		  try {
	            			  consoleColor.getDocument().insertString(consoleColor.getDocument().getLength() , sbReference2, coloration(sbReference2));
	            			  consoleColor.getDocument().insertString(consoleColor.getDocument().getLength() , mot, coloration(mot));
	            			  consoleColor.getDocument().insertString(consoleColor.getDocument().getLength() , sbReference3, coloration(sbReference3));
	            			 sbReference = sbReference3;
	                   			} catch (BadLocationException e1) {e1.printStackTrace();System.out.println("erreur cas 3");}
	            		    sb.setLength(0);
	            		    sbRef.setLength(0);
	            		  }
	            	  }
	            	/*  else if (true) try {
							consoleColor.getDocument().insertString(consoleColor.getDocument().getLength() , str, coloration(str));
							sbReference = str; 
							sb.setLength(0);
							 
						} catch (BadLocationException e) {e.printStackTrace();System.out.println("erreur cas 2"); }*/
 
	            	  }

		           	if ( b == '\n'){
		            		try {
								consoleColor.getDocument().insertString(consoleColor.getDocument().getLength() , sbReference, coloration(sbReference));
								sb.setLength(0);
								sbRef.setLength(0);
							} catch (BadLocationException e) {e.printStackTrace();}
		            		
		            	}

	            		    
	            		    

	        			 
	            		    
	                   if(consoleColor.getDocument().getDefaultRootElement().getElementCount() > 48000){
	                	   int end = consoleColor.getDocument().getDefaultRootElement().getElement(0).getEndOffset(); // fin du premier element du fichier, on suprime un a un ;0
	                	try {
	            		consoleColor.getDocument().remove(0, end);
	                   		} catch (BadLocationException e) {e.printStackTrace();}
	                   } 
	                   
	                   if (isFaireDefiler()){
	                   consoleColor.setCaretPosition(consoleColor.getDocument().getLength());
	                   		}
	                   }
	              }
	         
	  
	    }));
	    
		return consoleColor;
}


private SimpleAttributeSet coloration(String str){
	SimpleAttributeSet couleur = new SimpleAttributeSet();
	StyleConstants.setForeground(couleur, Color.red);
	StyleConstants.setBold(couleur, true);
	
	if(str.contains("echec") || str.contains("En Negatif = true") || str.contains("Echec")){
	return couleur;}
	
	

	if( str.contains("En Negatif = false")){
		StyleConstants.setForeground(couleur, Color.GREEN);
		StyleConstants.setBold(couleur, false);
	return couleur;}
	

	if( str.contains("Attente")){
		StyleConstants.setForeground(couleur, Color.ORANGE);
		StyleConstants.setBold(couleur, false);
	return couleur;}
	
	if( str.contains("Template Non Fini")){
		StyleConstants.setForeground(couleur, Color.ORANGE);
		StyleConstants.setBold(couleur, false);
	return couleur;}
	if( str.contains("Template Fini")){
		StyleConstants.setForeground(couleur, Color.GREEN);
		StyleConstants.setBold(couleur, false);
	return couleur;}
	if( str.contains("Bois")){
		StyleConstants.setForeground(couleur, Color.pink);
		StyleConstants.setBold(couleur, false);
	return couleur;}
	if( str.contains("Argile")){
		StyleConstants.setForeground(couleur, Color.pink);
		StyleConstants.setBold(couleur, false);
	return couleur;}
	if( str.contains("Fer")){
		StyleConstants.setForeground(couleur, Color.pink);
		StyleConstants.setBold(couleur, false);
	return couleur;}
	if( str.contains("Cereales")){
		StyleConstants.setForeground(couleur, Color.pink);
		StyleConstants.setBold(couleur, false);
	return couleur;}
	
	if( str.contains("construireBatiment")){
		StyleConstants.setForeground(couleur, Color.yellow);
		StyleConstants.setBold(couleur, false);
	return couleur;}
	if( str.contains("Fete")){
		StyleConstants.setForeground(couleur, Color(214,0,233));
		StyleConstants.setBold(couleur, false);
	return couleur;}
	
	
	
	// ici la boucle pour le noms de villages  
	 for (Village v : bot.travian.getListeDeVillages()){
	if( str.contains(v.getNom())){
		StyleConstants.setForeground(couleur, ColorUIResource.cyan);
		StyleConstants.setBold(couleur, false);
	return couleur;}}

	
	return null;
	
	
}


private Color Color(int i, int j, int k) {
	Color color = new Color(i,j,k) ;
	
	return color;
}


public boolean isFaireDefiler() {
	return faireDefiler;
}


public void setFaireDefiler(boolean faireDefiler) {
	this.faireDefiler = faireDefiler;
}

}
