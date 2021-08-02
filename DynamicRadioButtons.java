package Folders;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DynamicRadioButtons {
 
	static WebDriver driver;

  public static void main(String[] args) throws Throwable {
		
//How To Select Dynamic Radio Button In Selenium WebDriver | Java
	
			System.setProperty("webdriver.chrome.driver", "F://chromedriver.exe");
			WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get("https://www.facebook.com/");
			driver.findElement(By.xpath("//a[@role='button' and  @rel='async']")).click(); //  X-path for "Create Account" 
			
			selectRadioButton(driver,"Custom");
			
			selectRadioButton(driver,"Male");
			
			selectRadioButton(driver,"Female");
			
			
			driver.close();	
			
}
	
	
	public static void selectRadioButton(WebDriver driver, String value) {
		
		System.out.println("clicking on Value is: "+ value);                                 //Value=Female,Male, Custom
		WebElement rButton = driver.findElement(By.xpath("//span[@class='_5k_2 _5dba']/input[preceding-sibling::label[text()='"+value+"']]"));
	    System.out.println("Before " + rButton.isSelected());
	    
	     	if(!(rButton.isSelected())){  // it is not selected
			 rButton.click();
	     	}
	     	
		      driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		      System.out.println("After " + rButton.isSelected()); // after it is clicking
		
		
	}

}
