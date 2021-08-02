package Folders;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class HandleWindow {

	public static void main(String[] args) throws InterruptedException {
		
		
		 System.setProperty("webdriver.chrome.driver", "F://chromedriver.exe");
		 WebDriver driver=new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
		 driver.findElement(By.id("newWindowBtn")).click();
		 String parentHandle=driver.getWindowHandle(); // To get the name of the parentWindow
		 Set<String>handles=driver.getWindowHandles();
		 
		 for(String handle: handles) {
			 System.out.println("Child window is "+ handle);
			 if(!handle.equals(parentHandle)) {
				 
				 // switch to the child window and enter the firstname and lastname
				 driver.switchTo().window(handle);
				 driver.findElement(By.name("fName")).sendKeys("API Testing");
				 driver.findElement(By.name("lName")).sendKeys("Selenium");
				 Thread.sleep(3000);
				 driver.close(); 
			 }
		 }
		 Thread.sleep(2000);
		 driver.switchTo().window(parentHandle);
		 driver.findElement(By.xpath("//*[@class='whTextBox']")).sendKeys("Training Session");
		 driver.quit();
		 
		 
		 
		 

	}

}
