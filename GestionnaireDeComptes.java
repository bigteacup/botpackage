package botpackage;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

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

	}

	public ArrayList<File> getListeFichiers() {
		listerFichiers("comptes", "comptetravian");
		return listeFichiers;

	}
	// methodes

	// TODO develloper le chargeur de compte

	// charger les configs des comptes
	public void creerDossier() {
		String userPath = System.getProperty("user.home") + "\\botpackage\\comptes";
		File dossierComptes = new File(userPath);
		boolean isCreated = dossierComptes.mkdirs();
		System.out.println("Création du dossier" + userPath + " : " + isCreated);

	}

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
	public void ecrireDansFichier(String dossier, String nomFichier, String userName, String server , String motDePasse, String race ) {
		
		PrintWriter writer;
		try {
			writer = new PrintWriter(System.getProperty("user.home") + "\\botpackage\\" + dossier+"\\" + nomFichier);

			writer.println("server="+ server);
			writer.println("login="+ userName);
			writer.println("password="+ motDePasse);
			writer.println("race="+ race);
			writer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

