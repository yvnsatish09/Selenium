package Folders;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class EbaySorting {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "F://chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.ebay.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement catDropdown=driver.findElement(By.xpath("//*[@id='gh-cat']"));
		
		Select drpSelect=new Select(catDropdown);
	    List<WebElement> options = drpSelect.getOptions();
	    
	    ArrayList originalList=new ArrayList();
	    ArrayList tempList=new ArrayList();
	    
	    for(WebElement option: options) {
	    	originalList.add(option.getText());
	    	tempList.add(option.getText());
	    }
	    System.out.println("original Text is " + originalList);
    	System.out.println("original Text is " + tempList);  // we are taking tempList 
    	
    	Collections.sort(tempList);
    	
    	 System.out.println("After Sorting original Text is " + originalList);
         System.out.println("After Sorting temp  Text is " + tempList);
         
         if(originalList.equals(tempList)) {
        	 System.out.println("Sorting technique used");
         }
         else {
        	 System.out.println("unsorted items found ");
        	 
         }

	}

}
