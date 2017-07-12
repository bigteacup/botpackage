package botpackage;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import javax.swing.filechooser.FileNameExtensionFilter;

public class GestionnaireDeComptes {
	// les variables
	ArrayList<File> listeFichiers = new ArrayList<File>();

	// constructeur
	public GestionnaireDeComptes() {

		creerDossier();
		listeFichiers = listerFichiers("\\comptes", "properties");

	}

	public ArrayList<File> getListeFichiers() {
		return listeFichiers;

	}
	// methodes

	// TODO develloper le chargeur de compte

	// charger les configs des comptes
	public void creerDossier() {
		String userPath = System.getProperty("user.home") + "\\botpackage\\comptes";
		File dossierComptes = new File(userPath);
		boolean isCreated = dossierComptes.mkdirs();
		System.out.println(" Création du dossier" + userPath + " : " + isCreated);

	}

	public ArrayList<File> listerFichiers(String dossier, String extention) {
		String userPath = System.getProperty("user.home") + "\\botpackage" + dossier; // \\comptes
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

	public void creerFichierCompte() {

	}

}
