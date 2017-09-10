package botpackage;

import java.util.Date;
import java.util.Random;

////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////
public class Randomsleep {

	Travian t;
	// WebDriver driver;
	// WebDriverWait wait = new WebDriverWait(driver,120);

	public boolean enAttente = false;

	public Randomsleep(Travian t) {
		this.t = t;
	}

	public Randomsleep() {

	}

	// heure /date
	public Date date(boolean verbose) {
		Date maDate = new Date();
	
		// affichage:
		if (verbose == true){t.ecrireDansConsole(maDate.toString());}
		return maDate;
	}

	/*
	 * if(enPause == true){ synchronized (mon) { try { // while (enPause){
	 * mon.wait(); // } } catch (InterruptedException e) {e.printStackTrace(); }
	 * } }
	 * 
	 */

	// classic
	private int MIN_VALUE1 = 1588;
	private int MAX_VALUE1 = 5655;

	public void classic() {
		Random random = new Random();
		int myRandomNumber = random.nextInt(MAX_VALUE1 - MIN_VALUE1) + MIN_VALUE1;
		if (t.bot.afficherAttente == true) {
			t.ecrireDansConsole("[Attente classic :" + myRandomNumber + "]");
		}
		try {
			enAttente = true;
			Thread.sleep(myRandomNumber);
			enAttente = false;
		} catch (InterruptedException e) {
			t.ecrireDansConsole("Pause annulee");
			enAttente = false;
		}
	}

	// trescourt

	private int MIN_VALUE5 = 348;
	private int MAX_VALUE5 = 814;

	public void tcourt() {
		Random random = new Random();
		int myRandomNumber = random.nextInt(MAX_VALUE5 - MIN_VALUE5) + MIN_VALUE5;
		if (t.bot.afficherAttente == true) {
			t.ecrireDansConsole("[Attente :" + myRandomNumber + "]");
		}
		try {
			enAttente = true;
			Thread.sleep(myRandomNumber);
			enAttente = false;
		} catch (InterruptedException e) {
			t.ecrireDansConsole("Pause annulee");
			enAttente = false;
		}
	}

	// court
	private int MIN_VALUE2 = 945; //0.945 seconde
	private int MAX_VALUE2 = 2789; //0.2700 secondes

	public boolean court() {

		Random random = new Random();
		int myRandomNumber = random.nextInt(MAX_VALUE2 - MIN_VALUE2) + MIN_VALUE2;
			try{t.detectionAttaqueSimple(false);}catch(Exception e) {t.ecrireDansConsole("echec detection attaquesimple");}
		if (t.bot.afficherAttente == true) {
			t.ecrireDansConsole("[Attente :" + myRandomNumber + "]");
		}

		try {
			enAttente = true;
			Thread.sleep(myRandomNumber);
			enAttente = false;
		} catch (InterruptedException e) {
			t.ecrireDansConsole("Pause annulee");
			enAttente = false;
			return true;
		}
		return false;
	}

	// lent
	private int MIN_VALUE3 = 60000 * 4;// 4min
	private int MAX_VALUE3 = 60000 * 11;// 11 min

	public void lent() {
		Random random = new Random();
		int myRandomNumber = random.nextInt(MAX_VALUE3 - MIN_VALUE3) + MIN_VALUE3;
		date(true);
		t.ecrireDansConsole("Attente de : " + myRandomNumber / 1000 / 60 + "minutes "
				+ (myRandomNumber / 1000 - (myRandomNumber / 1000 / 60) * 60)
				+ "sec. et le chiffre de base en milliseconde " + myRandomNumber);
		try {
			enAttente = true;
			Thread.sleep(myRandomNumber);
			enAttente = false;
		} catch (InterruptedException e) {
			t.ecrireDansConsole("Pause annulee");
			enAttente = false;
		}
	}

	// treslent
	private int MIN_VALUE4 = 60000 * 19;  // anciennes valeurs : 25 min é 50 minutes ici 19 et 38 // 16/07/2016
	private int MAX_VALUE4 = 60000 * 38;

	public void treslent() {
		Random random = new Random();
		int myRandomNumber = random.nextInt(MAX_VALUE4 - MIN_VALUE4) + MIN_VALUE4;
		
		t.ecrireDansConsole("Attente :" + myRandomNumber / 1000 / 60 + "minutes "
				+ (myRandomNumber / 1000 - (myRandomNumber / 1000 / 60) * 60)
				+ "sec. et le chiffre de base en milliseconde " + myRandomNumber);
		try {
			enAttente = true;
			Thread.sleep(myRandomNumber);
			enAttente = false;
		} catch (InterruptedException e) {
			t.ecrireDansConsole("Pause annulee");
			enAttente = false;
		}
	}

	// Special
	// classic
	private int MIN_VALUE6 = 5233;
	private int MAX_VALUE6 = 9123;

	public void specialclassic() {
		Random random = new Random();
		int myRandomNumber = random.nextInt(MAX_VALUE1 - MIN_VALUE1) + MIN_VALUE1;
		t.ecrireDansConsole("[Attente :" + myRandomNumber + "]");
		try {
			enAttente = true;
			Thread.sleep(myRandomNumber);
			enAttente = false;
		} catch (InterruptedException e) {
			t.ecrireDansConsole("Pause annulee");
			enAttente = false;
		}
	}

	////////////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////

}
