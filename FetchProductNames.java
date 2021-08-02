package Folders;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class FetchProductNames {

	public static void main(String[] args) {
		
		
		 System.setProperty("webdriver.chrome.driver", "F://chromedriver.exe");
		 WebDriver driver=new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.get("https://www.flipkart.com/");
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 
		 // This action is need to close the banner alert by using actions class
		 Actions act=new Actions(driver);
		 Action sendEsc=act.sendKeys(Keys.ESCAPE).build();
		 sendEsc.perform();
		 
		 driver.findElement(By.name("q")).sendKeys("dell"); // Enter the  'searchBox' on dell 
		 driver.findElement(By.xpath("//button[@class='L0Z3Pu']")).click(); // Click on the search Box 
		 
		 // To find out the total number of rows in  the produts
		 String  xPathNoRows="//*[@class='col col-7-12']/div";
		 List<WebElement> listTotal=driver.findElements(By.xpath(xPathNoRows));
		// System.out.println("Total no of rows in products "+ listTotal.size());
		 
		 for(int i=1;i<=listTotal.size();i++) {
			 
			 String xpathColu="//*[@class='_3pLy-c row']/div[1]/div[@class='_4rR01T']["+i+"]";
			 List<WebElement> listCol=driver.findElements(By.xpath(xpathColu));
			// System.out.println( "Number of columns are " + listCol.size());
			 
			                                              //  //*[@class='col col-7-12']/div["+i+"]/div["+j+"]/div
			 for(int j=1;j<=listCol.size();j++) {
				 String xpathCo="//*[@class='_3pLy-c row']/div[1]/div[@class='_4rR01T']["+i+"]/div["+j+"]/div";
				 WebElement listCo=driver.findElement(By.xpath(xpathCo));
				 System.out.println( "Number of columns are " + listCo.getText());
			 }
		 }
		 
		 System.out.println("*************************************************************");
		 

	}

}
