package Folders;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Helper {
	
	public static void highLightElement(WebDriver driver, WebElement element) {
		
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('style','background: yellow;  border: 2px dotted red;');", element);
		try {
			Thread.sleep(1000);
		}
		catch(InterruptedException e) {
			
			System.out.println(e.getMessage());
		}
		
		js.executeScript("arguments[0].setAttribute('style', 'border: 2px  white')",element);
		
		
		
		
		
	}

}
