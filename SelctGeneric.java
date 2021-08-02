package Folders;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelctGeneric {

	static WebDriver driver;
	public static void main(String[] args) throws Throwable {
		
		
		System.setProperty("webdriver.chrome.driver", "F://chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
 
		
		WebElement EmployeeDropdown=driver.findElement(By.xpath("//*[@name='NoOfEmployees']"));
		WebElement industryDropdown =driver.findElement(By.xpath("//*[@name='Industry']")); //Multicity
		WebElement countryDropdown =driver.findElement(By.xpath("//*[@name='Country']"));
		
		
		selectDropdown(EmployeeDropdown,"401 - 450");
	
		Thread.sleep(2000);
		
		selectDropdown(industryDropdown,"Electronics");
		Thread.sleep(2000);
		
		selectDropdown(countryDropdown,"Zambia");
		
		
	}
	
	public static void selectDropdown(WebElement element, String value) {
		
		Select dropDown=new Select(element);
		List<WebElement> options=dropDown.getOptions();
		for(WebElement option: options) {
			if(option.getText().equals(value)) {
				option.click();
				break;
			}
		}
		
	}

}
