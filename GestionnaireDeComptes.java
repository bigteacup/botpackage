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



	public GestionnaireDeComptes() {
		
		 creerDossier();
	}

	//TODO develloper le chargeur de compte
	//TODO creer un dossier sil n'existe pas 
	//charger les configs des comptes
	public void creerDossier(){
		String userPath = System.getProperty("user.home")+"\\botpackage\\comptes";
		File dossierComptes = new File(userPath);
		boolean isCreated = dossierComptes.mkdirs();
		System.out.println(" Création du dossier"+ userPath +" : " + isCreated);
		listerComptes();
		

		//établir le dossier 
	
	
	}

public ArrayList<File> listerComptes(){
	String userPath = System.getProperty("user.home")+"\\botpackage\\comptes";
	 File dossierComptes = new File(userPath);
	 File[] list = dossierComptes.listFiles();
	 ArrayList<File> listComptes = new ArrayList<>();
	 listComptes.clear();
	  for(File t : list ){
		        if (t.getName().toLowerCase().endsWith("properties"))
		        {
		        listComptes.add(t);
		        System.out.println(t.toString());
		        }
	
	 
}
	return listComptes;


	 }
	
public void creerFichierCompte(){
	
}
	
}
