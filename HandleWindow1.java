package Folders;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class HandleWindow1 {

	public static void main(String[] args) throws Throwable {

		 System.setProperty("webdriver.chrome.driver", "F://chromedriver.exe");
		 WebDriver driver=new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.get("https://www.facebook.com/");
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
		 driver.findElement(By.xpath("//*[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
		 driver.findElement(By.xpath("//a[@id='privacy-link']")).click();
		 
		 String parentWindow=driver.getWindowHandle();
		 Set<String> childWindow = driver.getWindowHandles();
	
		 // using Enhanced ForLoop:
	/*	 for(String handles:childWindow) {
			 
			 if(!handles.equals(parentWindow)) {
				 driver.switchTo().window(handles);
				 System.out.println("child Window title  is " + driver.getTitle());
				 driver.findElement(By.xpath("//*[@data-testid='royal_email']")).sendKeys("test@123");
				 driver.findElement(By.xpath("//*[@data-testid='royal_pass']")).sendKeys("test@123");
				 Thread.sleep(2000);
				 driver.close();
				 
			 }
		 }
		 driver.switchTo().window(parentWindow);
		 System.out.println("Parent window title is "+ driver.getTitle());
		 driver.findElement(By.xpath("//*[@class='_8idr img']")).click();
		
		 System.out.println("Current page of the title is " + driver.getTitle()); */
		 
		 
		 
	// Logic 2 : using iterator
		 
/*	System.out.println("****************Logic using Iterator*************************************");
	
	 Iterator<String> it=childWindow.iterator();
	 while(it.hasNext()) {
		 driver.switchTo().window( it.next());
		 Thread.sleep(3000);
		 if(driver.getTitle().contains("Data Policy")) {
			 
			 
			    System.out.println("child Window title  is " + driver.getTitle());
			    Thread.sleep(3000);
			    driver.findElement(By.xpath("//*[@data-testid='royal_email']")).sendKeys("test@123");
			    driver.findElement(By.xpath("//*[@data-testid='royal_pass']")).sendKeys("test@123");
			    Thread.sleep(2000);
			    driver.close();
			 
		
		 } 
		 
	 }
	 
	    driver.switchTo().window(parentWindow);
	    System.out.println("Parent window title is "+ driver.getTitle());
	    driver.findElement(By.xpath("//*[@class='_8idr img']")).click();
	    System.out.println("Current page of the title is " + driver.getTitle());   */
		 
		 
	//	Logic 3:  Using single dimensional Array 
		 
	    System.out.println("**************Logic using Single dimensional Array*****************");
	    
	    Object[] ele = childWindow.toArray();
	    for(int i=0;i<ele.length;i++) {
	    	 driver.switchTo().window(ele[i].toString());
	    	       
	    	           if(driver.getTitle().contains("Policy")) {
				 
				 
				       System.out.println("child Window title  is " + driver.getTitle());
				       Thread.sleep(3000);
				       driver.findElement(By.xpath("//*[@data-testid='royal_email']")).sendKeys("test@123");
				       driver.findElement(By.xpath("//*[@data-testid='royal_pass']")).sendKeys("test@123");
				       Thread.sleep(2000);
				        driver.close();
	    	          }
	  
	              }
	    
	    driver.switchTo().window(parentWindow);
	    System.out.println("Parent window title is "+ driver.getTitle());
	    driver.findElement(By.xpath("//*[@class='_8idr img']")).click();
	    System.out.println("Current page of the title is " + driver.getTitle());
	
	    
	    
	    
	}

}
