package botpackage;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;

import javax.swing.filechooser.FileNameExtensionFilter;

public class GestionnaireDeComptes {
	// les variables
	ArrayList<File> listeFichiers = new ArrayList<File>();
	private FileReader in = null;
	private FileWriter out = null;

	// constructeur
	public GestionnaireDeComptes() {

		creerDossier();
		listeFichiers = listerFichiers("comptes", "comptetravian");
		File chrome = new File(System.getProperty("user.home") + "\\botpackage\\chromedriver.exe");
		
         URL url;
         
         
		try {
			url = new URL("https://chromedriver.storage.googleapis.com/2.32/chromedriver_win32.zip");
	         String fileName = System.getProperty("user.home") + "\\botpackage\\chromedriver_win32.zip";
	         try {
	        	if(!chrome.exists()) { 
				telechargeChromeDriver(url,fileName);
				extractZip(System.getProperty("user.home") + "\\botpackage\\chromedriver_win32.zip");
	        	}
	         } catch (IOException e) {e.printStackTrace();}
		} catch (MalformedURLException e) {e.printStackTrace();}

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
	
	public ArrayList<File> getListeFichiers() {
		listerFichiers("comptes", "comptetravian");
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
	/////////////////////////////////////////////////////////////////////////////////////
	public ArrayList<File> listerFichiers(String dossier, String extention) {
		extention = "comptetravian";
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
	public void creerFichierCompte(String nomDeCompte, String dossier, String extention) {
		String userPath = System.getProperty("user.home") + "\\botpackage" + dossier + nomDeCompte + extention;
		File newFichierCompte = new File(userPath);

		try {
			boolean isCreated = newFichierCompte.createNewFile();
			System.out.println("Création d'un fichier compte " + userPath + " : " + isCreated);
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		

	}
	/////////////////////////////////////////////////////////////////////////////////////
	public void suprimerFichierCompte(String nomDeCompte, String dossier, String extention) {
		String userPath = System.getProperty("user.home") + "\\botpackage" + dossier + nomDeCompte + extention;
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
			writer.close();
		} catch (FileNotFoundException e) {e.printStackTrace();}
		
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

