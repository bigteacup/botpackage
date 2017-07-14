package botpackage;


import java.math.RoundingMode;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;


public class CalculsTravian {

	Travian t;
	public CalculsTravian() {

	}
	//setter
	public void setTravian(Travian t){
		this.t = t;
	}

	public static void main(String[] args) throws ParseException {
		/*
			CalculsTravian2 c = new CalculsTravian2() ;
			
			double dist = c.calculDeDistance(76, -2, 75, -3, true);
			//double dist = c.calculDeDistance(76, -2, 75, -3,true);
			//double dist = c.calculDeDistance(53, -56, 55, -55);
			//Double distCorrigee = c.arrondirADeuxChiffres(dist);
			
			double vitesse = 0.202033;
			double place = 110;
			double arte = 0;
			double bottes = 0;
			
			
			c.tempsDeTrajet(dist, vitesse, place, arte, bottes,true);


		 */	


	}


	////Calcul de distance entre deux coordonnes
	public double calculDeDistance(double xa,double ya,double xb,double yb, boolean verbose ) throws ParseException {

		double distance = Math.sqrt((xa - xb)*(xa - xb)+(ya - yb)*(ya - yb));
		if(verbose ==true){	t.ecrireDansConsole("Raw Distance = "+distance);}
		arrondirADeuxChiffres(distance,verbose);
		return distance;
	}
	///Arrondit a deux chiffres
	public double arrondirADeuxChiffres(double x,boolean verbose) throws ParseException{
		DecimalFormat df = new DecimalFormat();
		df.setRoundingMode(RoundingMode.HALF_EVEN);
		df.setMaximumFractionDigits (2); //arrondi é 2 chiffres apres la virgules
		df.setMinimumFractionDigits (2);
		String y = df.format(x); //Le nombre sera arrondi

		//besoin de formater pour enlever la virgule
		NumberFormat nf = NumberFormat.getInstance();
		double number = nf.parse(y).doubleValue();
		if(verbose ==true){   t.ecrireDansConsole("Distance Arrondie = "+number);}

		return number;



	}

	///////////////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////////////
	///////Calcul temps de trajet format String
	public double tempsDeTrajet(double distance, double vitesseTroupe, double placeTournoi, double artefact, double bottes, boolean verbose) throws ParseException{
		double a;
		if (artefact <= 1){artefact = 1;}else{}
		if (placeTournoi <= 1){placeTournoi = 100;}else{}
		//if (bottes <=1){bottes = 100;}else{bottes=100+bottes;}
		//Partie calculs
		if (distance>20){ 
			a = ((20*60.0)/(vitesseTroupe*artefact)) + (((distance-20)*60.0)/((((vitesseTroupe)*(((placeTournoi+bottes)/100.0))))*(artefact))) ;
		}
		else {a = (distance*60.0)/(vitesseTroupe*artefact) ;}

		//on regle les heures minutes et secondes 
		long heures = (long) a/60; //heures
		long minutes = (long) a - (heures*60) ; //minutes
		double secondesDouble =  (a - (heures*60)-(minutes))*60 ; //secondes avec virgule pour arrondir plus tard si besoin
		long secondes = (long) secondesDouble; //secondes sans virgule

		//on chope les secondes et leur dizieme/centieme/millieme
		long secPlus =((Long.parseLong( (String.valueOf(secondesDouble).split("\\.")[1].substring(0, 1))))); // on chope les diziemes
		//long secPlus2 =((Long.parseLong( (String.valueOf(secondesDouble).split("\\.")[1].substring(0, 1)))));

		//on arrondi la seconde si besoin et on incremente l'essemble de l'heure
		if (secPlus >=5){secondes++;} //On ajoute une seconde pour arrondir si le dizieme  > 5
		if (secondes == 60) { secondes = 0; minutes++;}
		if (minutes == 60 ){minutes = 0; heures++;}


		//Partie Mise en forme

		String heuresString = null;
		String minutesString = null;
		String secondesString = null;
		if(heures <=9 ){heuresString = "0"+heures;} else {heuresString = ""+heures;}	
		if(minutes <=9 ){minutesString = "0"+minutes;} else {minutesString = ""+minutes;}
		if(secondes <=9 ){secondesString = "0"+secondes;} else {secondesString = ""+secondes;}

		String heureTravian = heuresString +":"+ minutesString +":"+ secondesString ;
		if(verbose ==true){	t.ecrireDansConsole("Temps de trajet : "+heureTravian+"   et chriffre de base : "+a);}

		return a;



	}
	///save de merde
	//on arrondi la seconde si besoin et on incremente l'essemble de l'heure
	/*	if (secPlus >=5){secondes++;} //On ajoute une seconde pour arrondir si le dizieme  > 5
if (secondes == 59 && secPlus >=5) {minutes++;}
if (minutes ==59 && secondes == 59 && secPlus <=5){heures++;}
	 */
	///////////////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////////////























	public static String msToString(long ms) {
		long totalSecs = ms/1000;
		long hours = (totalSecs / 3600);
		long mins = (totalSecs / 60) % 60;
		long secs = totalSecs % 60;
		String minsString = (mins == 0)
				? "00"
						: ((mins < 10)
								? "0" + mins
										: "" + mins);
		String secsString = (secs == 0)
				? "00"
						: ((secs < 10)
								? "0" + secs
										: "" + secs);
		if (hours > 0)
			return hours + ":" + minsString + ":" + secsString;
		else if (mins > 0)
			return mins + ":" + secsString;
		else return ":" + secsString;
	}
}
//Math.sqrt(x) //racine carre de x





//String heureTravian = heures +":"+ minutes +":"+ secondes ;
//String str = String.valueOf(a/24/60) ;

/*	//temps total en milliseconde
		long b1 = Long.parseLong((String.valueOf(a).split("\\.")[0]));
		long b2 = Long.parseLong((String.valueOf(a).split("\\.")[1]));//avant virgule //Minutes
        double a2 = ((Double.parseDouble(String.valueOf(a).split("\\.")[1].substring(0, 3))*60.0)/100.0)/10;//apres virgule + calcul
		long b3 = (long) (a2*1000);

        long timeMs = TimeUnit.MINUTES.toMillis(b1);
    	long timeMs2 = b3;
    	long tempsEnMs = timeMs+timeMs2;

 */	

/*	
String a1 = (String.valueOf(a).split("\\.")[0]); //avant virgule //Minutes
long b1 = Long.parseLong((String.valueOf(a).split("\\.")[0]));
long b2 = Long.parseLong((String.valueOf(a).split("\\.")[1]));//avant virgule //Minutes
double a2 = ((Double.parseDouble(String.valueOf(a).split("\\.")[1].substring(0, 3))*60.0)/100.0)/10;//apres virgule + calcul
long b3 = (long) (a2*1000);
Time r = Time.valueOf("00:00:00");
//Time d = Time.parse(str) ;
String a5 = String.valueOf(a2); //Seconde
String dure = a1 + a5; //ici soucis XD

//long corec =Long.parseLong(apresVirgule);
//double cor = Math.round((corec/100*60)*100)/100;
	System.out.println("temps non arrondit : minutes : " + a1 + "  Secondes : " + a2);

	//double t = (a/100)*60;
    DecimalFormat df = new DecimalFormat();
    df.setRoundingMode(RoundingMode.HALF_EVEN);
    df.setMaximumFractionDigits (0); //arrondi é 2 chiffres apres la virgules
    df.setMinimumFractionDigits (0);
    String t = df.format(a2); //Le nombre sera arrondi
	int t1 = Integer.parseInt(t)*60;
	double concat = t1 +a2;

    //besoin de formater pour enlever la virgule
    NumberFormat nf = NumberFormat.getInstance();
    double number = nf.parse(t).doubleValue();
 /*   	
    double a2 = ((Double.parseDouble(String.valueOf(a).split("\\.")[1].substring(0, 3))*60.0)/100.0)/10;//apres virgule + calcul
	long b3 = (long) (a2*1000);
	long b1 = Long.parseLong((String.valueOf(a).split("\\.")[0]));
    long time = TimeUnit.MINUTES.toMillis(b1);
	long time2 = b3;
	long tempsEnMs = time+time2;

	long totalSecondes = tempsEnMs/1000;
	long heures1 = totalSecondes/3600;
	long minute = (totalSecondes/60) % 60;
	long secondes = totalSecondes % 60 ;
	//double time4 = TimeUnit.MILLISECONDS.toSeconds((time3%60.0));
 */	
//	String test = msToString(tempsEnMs);

//System.out.println("temps corrige : " + (test));