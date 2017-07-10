package botpackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class GestionnaireDeComptes {

	

	//TODO develloper le chargeur de compte
	//TODO creer un dossier sil n'existe pas 
	//charger les configs des comptes
	public Properties loadConfigComptes(){
		
	String path = System.getProperty("user.home")+"\\travianfx.properties";		
	Properties properties = new Properties();
	FileInputStream input = null;

	try {
		input = new FileInputStream(path);
	} catch (FileNotFoundException e) {e.printStackTrace();} 

	try{
	properties.load(input);

	} catch (IOException e) {e.printStackTrace();}
	finally{
		try {
			input.close();
		} catch (IOException e) {e.printStackTrace();}
	}
	return properties;	
		
	}


	
	
}
