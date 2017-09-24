package botpackage;

import java.util.ArrayList;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Verifierdate extends Thread {
	private Date date =  new Date(); 
String heurePc;
WebDriver driver;
Compte compte;
Travian travian;
String heureCible = "21:05:29";
Attaque attaque;
int itsTime;
ArrayList<Attaque>listeAttaques;

public Verifierdate(Travian travian, Attaque attaque, ArrayList<Attaque> listeAttaques) {
		//this.driver = travian.driverEnCour();
		//this.compte = travian.getCompte();
		this.travian = travian;
		this.compte = travian.getCompte();
		//this.heureCible = attaque.heureCible(attaque);
		this.attaque = attaque;
		this.listeAttaques = listeAttaques;
		
		
	}
	
	public void run() {
		while (true){
		heureServeur();
	}}

	public static void main(String[] args) {
		
	

	}
	public String heureServeur() {
	/*	try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
		
			e.printStackTrace();
		}*/
		int count = 0;
		itsTime = 0;
		String heureTravian = compte.getDriver().findElement(By.xpath("//*[@id=\"tp1\"]")).getText();
		String heureTravianOld = heureTravian;
		while (true){
		while(true) {
		try {
			
			
			heureTravian = compte.getDriver().findElement(By.xpath("//*[@id=\"tp1\"]")).getText();
			Thread.sleep (10);
			
			if(heureTravian.equals(heureCible)){
				itsTime = 1;
				 /*for (Attaque a : listeAttaques){
					 a.go();
					 
					 
				 }*/
				
				 //listeAttaques.resume();
				//compte.getDriver().findElement(By.xpath("//*[@id=\"btn_ok\"]/div/div[2]")).click();
				System.out.println(date);
				
				//attaque.lancerAttaque();			
				
			}
	
			/*if (heureTravian.equals(heureTravianOld) ){
				count++;
			}
			else {
				heureTravianOld = heureTravian;
			//	System.out.print("compteur : " + count);
				count = 0;
			}*/
			
			} catch (Exception e) {
			try {Thread.sleep(10);} catch (InterruptedException e1) {}
			this.compte = travian.getCompte();
			
		}
		}
		
		//return heureTravian;
		}
	
		
	}
	
	public void setHeureCible(String heureCible){
		this.heureCible = heureCible;
		
		
	}

	public boolean itsTime(){
		while(true){
		try {Thread.sleep (10);} catch (InterruptedException e) {}
		if (itsTime == 1){
		
		return (true);}
		}
	}
}
