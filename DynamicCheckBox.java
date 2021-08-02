package Folders;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DynamicCheckBox {
 
	static WebDriver driver;
	
	public static void main(String[] args) throws Throwable {
		
		//B.How To Handle Dynamic Checkbox In Selenium Webdriver 
		
		System.setProperty("webdriver.chrome.driver", "F://chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
			
		selectCheckBox("ASIAN");
		
		Thread.sleep(3000);
		selectCheckBox("CAMPUS");
		
   }	
			
private static void selectCheckBox(String displayCheckbox) {
		
		WebElement searchBox=driver.findElement(By.name("field-keywords"));
		
		searchBox.sendKeys("shoes for men",Keys.ENTER);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	    WebElement input = driver.findElement(By.xpath("//li[@aria-label='"+ displayCheckbox +"']//input"));
	    
	    WebElement i  =   driver.findElement(By.xpath("//li[@aria-label='"+ displayCheckbox +"']//i"));
	    
	    boolean box=input.isSelected(); // before Clicking the checkBox
	    
	    System.out.println("Before useraction "+ box);
	    
	    if(!box) {
	    	
	        	i.click();
	    	
	    }                                     // AfterUseraction
	   
	      System.out.println(driver.findElement(By.xpath("//li[@aria-label='"+ displayCheckbox +"']//input")).isSelected());
	    	    
	}}	    
	   
	


