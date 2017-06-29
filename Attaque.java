package botpackage;

import java.awt.AWTException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;


import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class Attaque extends Thread {
	private WebDriver driver;
	private Compte compte;
	private ArrayList<Village> listeDeVillages;
	//private String heure;
	private Date date =  new Date();  
	private static Randomsleep randomsleep = new Randomsleep();
	//private String heureCible = "23:01:41"; 
	//private String heureCibleVerif;  
	Verifierdate verifDate;
	List<WebElement> bouttons = new ArrayList<WebElement>();
	 ArrayList<String> tabs2= null;
	
	public Attaque() {
		
		
	}
	
	public void run() {
		while (true){
			try {Thread.sleep (10);} catch (InterruptedException e) {}
		if (verifDate.itsTime()== true){
			go();
			
		}
		}
	}
	

	
	public Attaque(Travian travian, Verifierdate verifDate) throws AWTException {
		
		///// POUR PROFIL CHROME
	//	ChromeOptions options = new ChromeOptions();
		//options.addArguments("user-data-dir=/ProfilChromePourBot/profil");
		WebDriver driver = new ChromeDriver();//options
		//C:/Users/timseven/AppData/Local/Google/Chrome/User Data/
		
		this.listeDeVillages = travian.getListeDeVillages();
		//WebDriver driver = new ChromeDriver();
		this.driver = driver;
		this.verifDate = verifDate;
		
		driver.get("http://ts4.travian.fr");
	/*	Set<Cookie> cookies = travian.getCookies();
		try
		   {
		      for(Cookie cookie:cookies)
		  {
		driver.manage().addCookie(cookie);
		 }
		   }
		catch(Throwable e)
		   {
		System.err.println("Error While setting Cookies: "+ e.getMessage());
		   }
		   
		   
		   */
		travian.bootDriver(driver);
				 
		
		
		attaque();
		
		
		
	/*	
		for(Village2 village : listeDeVillages ){
			if (village.getNom().equals("Village")){
				driver.get(village.getUrl());
			}
		}
		
		driver.get("http://ts4.travian.fr/build.php?tt=2&id=39");
		randomsleep.tcourt();			  //  compte.getDriver().switchTo().window(tabs2.get(i));
	    WebElement casex = driver.findElement(By.xpath("//*[@id=\"xCoordInput\"]"));
	    randomsleep.tcourt();
	    casex.sendKeys("54");
	    WebElement casey = driver.findElement(By.xpath("//*[@id=\"yCoordInput\"]"));
	    randomsleep.tcourt();
	    casey.sendKeys("-56");
	randomsleep.tcourt();
	WebElement case1; case1 = driver.findElement(By.xpath("//*[@id=\"troops\"]/tbody/tr[2]/td[1]/input")); 
	case1.click();
	randomsleep.tcourt();
	case1.sendKeys("1");
	randomsleep.tcourt();
	driver.findElement(By.xpath("//*[@id=\"btn_ok\"]/div/div[2]")).click();
	randomsleep.tcourt();
	WebElement boutton = driver.findElement(By.xpath("//*[@id=\"btn_ok\"]/div/div[2]"));
	bouttons.add(boutton);
	randomsleep.tcourt();
	try {
		this.wait(0);
	} catch (InterruptedException e) {
		
		e.printStackTrace();
	}
	bouttons.get(0).submit();*/
	}
		
	



		
		
		
		
/*	public Attaque(Travian2 travian, Verifierdate verifDate) throws AWTException {
		this.compte = travian.getCompte();
		this.listeDeVillages = travian.getListeDeVillages();
		this.heure = heure;
		System.out.println(date);
		int i = 0;
		int itab=0;
		List<WebElement> bouttons = new ArrayList<WebElement>();
		for(Village2 village : listeDeVillages ){
		if (village.getNom().equals("Village")){
			compte.getDriver().get(village.getUrl());
		}
		}
		
		compte.getDriver().get("http://ts4.travian.fr/build.php?tt=2&id=39");
/*		while (itab<7){
		Robot robot1 = new Robot();
			
			robot1.delay(500);
			robot1.keyPress(KeyEvent.VK_CONTROL);
			robot1.keyPress(KeyEvent.VK_T);
			robot1.delay(500);
			robot1.keyRelease(KeyEvent.VK_CONTROL);
			robot1.keyRelease(KeyEvent.VK_T);
			robot1.delay(500);
			/////////////////////////////////////////
			List<WebElement> tabItem = compte.getDriver().findElements(By.xpath("//*[@class=\"tabItem\"]"));
			randomsleep.tcourt();
			Actions builder = new Actions(compte.getDriver());
			 	WebElement lien = tabItem.get(2);
				builder.moveToElement(lien);
				builder.keyDown(Keys.CONTROL);
				//builder.keyDown(KeyEvent.VK_T);
				//builder.keyDown(Keys.SHIFT);
				//builder.keyDown(Ke);//(+ "t" )	;
				//builder.keyUp(Keys.CONTROL);
				builder.click(lien);
				builder.keyUp(Keys.CONTROL);
				//builder.keyUp(Keys.SHIFT);
				builder.perform();
			
			itab++;
		}*/
		
	/*	while (i < 4){
			if(i>=1){
				List<WebElement> tabItem = compte.getDriver().findElements(By.xpath("//*[@class=\"tabItem\"]"));
				WebElement lien = tabItem.get(2);
				Actions builder = new Actions(compte.getDriver());
				builder.keyDown(Keys.CONTROL);
				builder.click(lien);
				builder.keyUp(Keys.CONTROL);
				builder.perform();
				randomsleep.tcourt();
			}
			 ArrayList<String> tabs2 = new ArrayList<String> (compte.getDriver().getWindowHandles());
			 randomsleep.tcourt();
			    compte.getDriver().switchTo().window(tabs2.get(i));
			    randomsleep.tcourt();
			   
			    randomsleep.tcourt();			  //  compte.getDriver().switchTo().window(tabs2.get(i));
			    WebElement casex = compte.getDriver().findElement(By.xpath("//*[@id=\"xCoordInput\"]"));
			    randomsleep.tcourt();
			    casex.sendKeys("54");
			    WebElement casey = compte.getDriver().findElement(By.xpath("//*[@id=\"yCoordInput\"]"));
			    randomsleep.tcourt();
			    casey.sendKeys("-56");
			randomsleep.tcourt();
			WebElement case1; case1 = compte.getDriver().findElement(By.xpath("//*[@id=\"troops\"]/tbody/tr[2]/td[1]/input")); 
			case1.click();
			randomsleep.tcourt();
			case1.sendKeys(""+(i+1));
			randomsleep.tcourt();
			compte.getDriver().findElement(By.xpath("//*[@id=\"btn_ok\"]/div/div[2]")).click();
			randomsleep.tcourt();
			WebElement boutton = compte.getDriver().findElement(By.xpath("//*[@id=\"btn_ok\"]/div/div[2]"));
			bouttons.add(boutton);
			randomsleep.tcourt();
			i++;
		}
		int n=0;
		for (WebElement b : bouttons){
			ArrayList<String> tabs2 = new ArrayList<String> (compte.getDriver().getWindowHandles());
			tabs2.get(n);
			b.submit();
			n++;
		}
		/*	randomsleep.tcourt();	
			
			List<WebElement> tabItem = compte.getDriver().findElements(By.xpath("//*[@class=\"tabItem\"]"));
			randomsleep.tcourt();
			Actions builder = new Actions(compte.getDriver());
			 	WebElement lien = tabItem.get(2);
				builder.moveToElement(lien);
				builder.keyDown(Keys.CONTROL);
				//builder.keyDown(KeyEvent.VK_T);
				//builder.keyDown(Keys.SHIFT);
				//builder.keyDown(Ke);//(+ "t" )	;
				//builder.keyUp(Keys.CONTROL);
				builder.click(lien);
				builder.keyUp(Keys.CONTROL);
				//builder.keyUp(Keys.SHIFT);
				builder.perform();
			*/	 
			/*
		List<WebElement> tabItem = compte.getDriver().findElements(By.xpath("//*[@class=\"tabItem\"]"));
		randomsleep.tcourt();*/
		
		/*	
			Robot robot1 = new Robot();
			
			robot1.delay(500);
			robot1.keyPress(KeyEvent.VK_CONTROL);
			robot1.keyPress(KeyEvent.VK_T);
			robot1.delay(500);
			robot1.keyRelease(KeyEvent.VK_CONTROL);
			robot1.keyRelease(KeyEvent.VK_T);
			robot1.delay(500);
		*/	
/*		Actions builder = new Actions(compte.getDriver());
		 
	//	WebElement lien = tabItem.get(2);
		//builder.moveToElement(lien);
		builder.keyDown(Keys.CONTROL);
		builder.keyDown(KeyEvent.VK_T);
		//builder.keyDown(Keys.SHIFT);
		//builder.keyDown(Ke);//(Keys.CONTROL + "t" )	;
		builder.keyUp(Keys.CONTROL);
		//builder.click(lien);
		builder.keyUp(Keys.CONTROL);
		//builder.keyUp(Keys.SHIFT);
		builder.perform();
		//compte.getDriver().get("http://ts4.travian.fr/build.php?tt=2&id=39");
	*/	
		
		
	 /*  
	    randomsleep.tcourt();*/
	/*	i++;
		}*/
	/*	i=0;
		ArrayList<String> tabs2 = new ArrayList<String> (compte.getDriver().getWindowHandles());
		List<WebElement> bouttons = new ArrayList<WebElement>();
		for(String tab : tabs2){
			compte.getDriver().switchTo().window(tab);
			
			//compte.getDriver().manage().timeouts().implicitlyWait(100, TimeUnit.MILLISECONDS);
			
			WebElement boutton=compte.getDriver().findElement(By.xpath("//*[@id=\"btn_ok\"]/div/div[2]"));
			bouttons.add(boutton);  //    #btn_ok > div > div.button-content
			//compte.getDriver().findElement(By.linkText(linkText)).click();
			//compte.getDriver().manage().timeouts().implicitlyWait(100, TimeUnit.MILLISECONDS);
		}*/
	/*	
		ArrayList<String> tabs3 = new ArrayList<String> (compte.getDriver().getWindowHandles());
		int n =0;
		while(n < tabs3.size()){
		 randomsleep.tcourt();
		compte.getDriver().switchTo().window(tabs3.get(n));
		Actions b = new Actions(compte.getDriver());
		WebElement d = compte.getDriver().findElement(By.xpath("//*[@id=\"btn_ok\"]/div/div[2]"));
		randomsleep.tcourt();	
		b.clickAndHold(d);
		randomsleep.tcourt();	
		b.moveByOffset(100, 100);
		randomsleep.tcourt();	
		b.perform();
		n++;
		}
		
		int o=0;
		ArrayList<String> tabs2 = new ArrayList<String> (compte.getDriver().getWindowHandles());
		 randomsleep.tcourt();
		compte.getDriver().switchTo().window(tabs2.get(0));
		 randomsleep.tcourt();
		//for(String tab : tabs2){
			Robot robot = new Robot();
			while(o<8){
			
			robot.delay(100);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_TAB);
			robot.delay(100);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_TAB);
			robot.delay(100);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.delay(100);
			robot.keyPress(KeyEvent.VK_ENTER);
			

			//compte.getDriver().switchTo().window(tab);
			
			//bouttons.get(o).click();
		o++;
		//	}
		}
	/*	while (i < 8){
		compte.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
		compte.getDriver().switchTo().window(tabs2.get(i));
		//try {Thread.sleep(10);} catch (InterruptedException e) {}
		compte.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
		compte.getDriver().findElement(By.xpath("//*[@id=\"btn_ok\"]/div/div[2]")).click();
		compte.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
		i++;
		}*/
		//compte.getDriver().findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");

		

	
		
	
	
	
	
	private  void attaque() throws AWTException {
		randomsleep.tcourt();
		for(Village village : listeDeVillages ){
			if (village.getNom().equals("1 Village")){
				driver.get(village.getUrl());
			}
		}
		
		
			
		
			   
		randomsleep.tcourt();
		driver.get("http://ts4.travian.fr/build.php?tt=2&id=39");
		randomsleep.tcourt();			  //  compte.getDriver().switchTo().window(tabs2.get(i));
	    WebElement casex = driver.findElement(By.xpath("//*[@id=\"xCoordInput\"]"));
	    randomsleep.tcourt();
	    casex.sendKeys("54");
	    WebElement casey = driver.findElement(By.xpath("//*[@id=\"yCoordInput\"]"));
	    randomsleep.tcourt();
	    casey.sendKeys("-56");
	randomsleep.tcourt();
	WebElement case1; case1 = driver.findElement(By.xpath("//*[@id=\"troops\"]/tbody/tr[2]/td[1]/input")); 
	case1.click();
	randomsleep.tcourt();
	case1.sendKeys("1");
	randomsleep.tcourt();
	driver.findElement(By.xpath("//*[@id=\"btn_ok\"]/div/div[2]")).click();
	randomsleep.tcourt();
	WebElement boutton = driver.findElement(By.xpath("//*[@id=\"btn_ok\"]/div/div[2]"));
	bouttons.add(boutton);
	randomsleep.tcourt();

		
		
		}
	
	//bouttons.get(0).submit();
	
	public void go() {
		
		try{

		bouttons.get(0).submit();
		
			}catch (StaleElementReferenceException e1) {}
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public static void main(String[] args) {
		

	}

	
	
	public void lancerAttaque() {

		
		//if (heureCible == heureCibleVerif){
		compte.getDriver().findElement(By.xpath("//*[@id=\"btn_ok\"]/div/div[2]")).click();
		System.out.println(date);
	//	randomsleep.classic();
		//}

		
	}
	
	public void heureCible(Verifierdate verifDate){
		this.verifDate = verifDate;

		
	}

/*	public void setHeureCible(Attaque attaque) {
		verifDate.setHeureCible(heureCible);
		System.out.println(date);
		
	}*/
	
	public void switchWindow() throws NoSuchWindowException{
	       try {
	           Set<String> handles = compte.getDriver().getWindowHandles();
	           String current = compte.getDriver().getWindowHandle();
	           handles.remove(current);
	           String newTab = handles.iterator().next();
	           compte.getDriver().switchTo().window(newTab);
	        } catch( Exception e ) { 
	           
	        }
	}
	
	
	
	
	
	
}
