package botpackage;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Properties;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;

public class GestionnaireDeComptes {
	// les variables
	ArrayList<File> listeFichiers = new ArrayList<File>();
	private FileReader in = null;
	private FileWriter out = null;
	
	public Properties fichierTemplatesProperties;

	// constructeur
	public GestionnaireDeComptes() {

		creerDossier();
		listeFichiers = listerFichiers("comptes", "comptetravian");
		File chrome = new File(System.getProperty("user.home") + "\\botpackage\\chromedriver.exe");
		
         URL url;
         
         
		try {
			url = new URL("https://chromedriver.storage.googleapis.com/2.37/chromedriver_win32.zip");
	         String fileName = System.getProperty("user.home") + "\\botpackage\\chromedriver_win32.zip";
	         try {
	        	if(!chrome.exists()) { 
				telechargeChromeDriver(url,fileName);
				extractZip(System.getProperty("user.home") + "\\botpackage\\chromedriver_win32.zip");
	        	}
	         } catch (IOException e) {e.printStackTrace();}
		} catch (MalformedURLException e) {e.printStackTrace();}
		
		creerDossierTemplates();
		listeFichiers = listerFichiers("templates", "templates");
		

	}



	/////////////////////////////////////////////////////////////////////////////////////	 
	  static void telechargeChromeDriver(URL url, String file) throws IOException {
	        System.out.println("ouverture connection");
	        InputStream in = url.openStream();
	        FileOutputStream fos = new FileOutputStream(new File(file));

	        System.out.println("Lecture du fichier...");
	        int length = -1;
	        byte[] buffer = new byte[2048];// buffer   https://chromedriver.storage.googleapis.com/2.32/chromedriver_win32.zip
	        
	        while ((length = in.read(buffer)) > -1) {
	            fos.write(buffer, 0, length);
	        }


	        fos.close();
	        in.close();
	        System.out.println("Fichier telecharge");
	    }
	
		/////////////////////////////////////////////////////////////////////////////////////	
	
	public ArrayList<File> getListeFichiers (String dossier, String extension) {
		listerFichiers(dossier, extension);
		return listeFichiers;

	}
	/////////////////////////////////////////////////////////////////////////////////////
	// methodes

	// TODO develloper le chargeur de compte
	/////////////////////////////////////////////////////////////////////////////////////
	// charger les configs des comptes
	public void creerDossier() {
		String userPath = System.getProperty("user.home") + "\\botpackage\\comptes";
		File dossierComptes = new File(userPath);
		boolean isCreated = dossierComptes.mkdirs();
		System.out.println("Création du dossier" + userPath + " : " + isCreated);

	}
	////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////
public void creerDossierTemplates() {
String userPath = System.getProperty("user.home") + "\\botpackage\\templates";
File dossierComptes = new File(userPath);
boolean isCreated = dossierComptes.mkdirs();
System.out.println("Création du dossier" + userPath + " : " + isCreated);

}
	/////////////////////////////////////////////////////////////////////////////////////
	public ArrayList<File> listerFichiers(String dossier, String extention) {
		String userPath = System.getProperty("user.home") + "\\botpackage\\" + dossier; // \\comptes
		File chemin = new File(userPath);
		File[] list = chemin.listFiles();
		try {
			listeFichiers.clear();
		} catch (Exception e) {

		}
		for (File t : list) {
			if (t.getName().toLowerCase().endsWith(extention)) // properties
			{
				listeFichiers.add(t);
				System.out.println(t.toString());
			}
		}
		return listeFichiers;
	}
	/////////////////////////////////////////////////////////////////////////////////////
	public void creerFichier(String nomDefichier, String dossier, String extention) {
		
		String userPath = System.getProperty("user.home") + "\\botpackage" + dossier +"\\"+ nomDefichier + extention;
		File newFichierCompte = new File(userPath);
		boolean trouver=false;
	//	newFichierCompte.

		try {
			for(File file : listerFichiers(dossier, extention)) {
				String strFile="";
				try {
					strFile = file.getName().split(extention)[0];
					} catch (Exception e) {}
				
				
				if((strFile.equals(nomDefichier)) ) { //&& (strFile.equals(null))
					trouver= true;
				}
				
				
				
				
			}
			if (trouver == false){
				boolean isCreated = newFichierCompte.createNewFile();
				System.out.println("Création d'un fichier compte " + userPath + " : " + isCreated);
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		

	}
	/////////////////////////////////////////////////////////////////////////////////////
	public void suprimerFichier(String nomDefichier, String dossier, String extention) {
		String userPath = System.getProperty("user.home") + "\\botpackage" + dossier + nomDefichier + extention;
		File newFichierCompte = new File(userPath);

		boolean isCreated = newFichierCompte.delete();
		System.out.println("Supression d'un fichier compte " + userPath + " : " + isCreated);

		

	}
	/////////////////////////////////////////////////////////////////////////////////////
	public void ecrireDansFichier(String dossier, String nomFichier, String userName, String server , String motDePasse, String race ) {
		
		PrintWriter writer;
		try {
			writer = new PrintWriter(System.getProperty("user.home") + "\\botpackage\\" + dossier+"\\" + nomFichier);

			writer.println("server="+ server);
			writer.println("login="+ userName);
			writer.println("password="+ motDePasse);
			writer.println("race="+ race);
			writer.println("banmarchejoueur=");
			writer.println("banmarcheinterieur=");
			writer.close();
		} catch (FileNotFoundException e) {e.printStackTrace();}
		
	}
	
	/////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////
	public void ecrireDansFichierTemplate(String dossier, String nomFichier, TemplatesDeVillages templateDeVillage ) {
		 System.out.println("Encodage : "+System.getProperty("file.encoding"));
		PrintWriter writer;
		try {
		//	writer = new PrintWriter(new OutputStreamWriter(csocket.getOutputStream(), StandardCharsets.UTF_8), true);
		//	OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(PROPERTIES_FILE), StandardCharsets.UTF_8);
			// PrintWriter writer = new PrintWriter(new File("C:\\abc.xml"), "UTF-8");
			try {
				writer = new PrintWriter(new File (System.getProperty("user.home") + "\\botpackage\\" + dossier+"\\" + nomFichier), "UTF-8");

			for(Batiment bat : templateDeVillage.getListeDeBatiments()) {
		//	writer.println(encoding(bat.getNomBatiment().replaceAll("\\s", "\\\\ ")+ "="+ bat.getLevelBatiment()));
			
				writer.println(bat.getNomBatiment().replaceAll("\\s", "\\\\ ")+ "="+ bat.getLevelBatiment());
			
}	
			
			writer.close();
		} catch (FileNotFoundException e) {e.printStackTrace();}
	
		} catch (UnsupportedEncodingException e) {
			
			e.printStackTrace();
		}
		
	}
	/////////////////////////////////////////////////////////////////////////////////////
	
	
	public StringBuilder encoding(String src) {
	//    final  = "Hallo äöü"; // this has to be read with the right encoding
	    final CharsetEncoder asciiEncoder = Charset.forName("US-ASCII").newEncoder();
	    final StringBuilder result = new StringBuilder();
	    for (final Character character : src.toCharArray()) {
	        if (asciiEncoder.canEncode(character)) {
	            result.append(character);
	        } else {
	            result.append("\\u");
	            result.append(Integer.toHexString(0x10000 | character).substring(1).toUpperCase());
	        }
	    }
	    return result ;
	 }
	
	
	
	/////////////////////////////////////////////////////////////////////////////////////
	static public void extractZip(String fichierZip) throws ZipException, IOException 
	{
	    System.out.println(fichierZip);
	    int BUFFER = 2048;

	    ZipFile zip = new ZipFile(fichierZip);
	    String dossierDeDestination =System.getProperty("user.home") + "\\botpackage\\";

	   
	    Enumeration zipFileEntries = zip.entries();

	    // faire chaque entree
	    while (zipFileEntries.hasMoreElements())
	    {
	        //prendre une entree dans le zip
	        ZipEntry entry = (ZipEntry) zipFileEntries.nextElement();
	        String currentEntry = entry.getName();
	        File destFile = new File(dossierDeDestination, currentEntry);


	        if (!entry.isDirectory())
	        {
	            BufferedInputStream is = new BufferedInputStream(zip.getInputStream(entry));
	            int currentByte;
	            // faire un buffer pour ecrire le fichier
	            byte data[] = new byte[BUFFER];

	            // ecrire le fichier sur le disque
	            FileOutputStream fos = new FileOutputStream(destFile);
	            BufferedOutputStream dest = new BufferedOutputStream(fos, BUFFER);

	            // lire et ecrire jusque le dernier byte soit atteind
	            while ((currentByte = is.read(data, 0, BUFFER)) != -1) {
	                dest.write(data, 0, currentByte);
	            }
	            dest.flush();
	            dest.close();
	            is.close();
	          // zip.close(); 
	        }

	        if (currentEntry.endsWith(".zip"))
	        {
	            // si on trouve un zip on l'ouvre aussi
	            extractZip(destFile.getAbsolutePath());
	        }
	    }
	}

}

