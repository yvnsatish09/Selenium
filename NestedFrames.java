package Folders;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class NestedFrames { 
	
	public static WebDriver driver;

	public static void main(String[] args) {
		
		

		 System.setProperty("webdriver.chrome.driver", "F://chromedriver.exe");
		 driver=new ChromeDriver();
		 driver.get("https://chercher.tech/practice/frames");
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 
		 int totalFrames=driver.findElements(By.tagName("iframe")).size();
		 System.out.println(" Total frames in the webpage "+ totalFrames);
		 
		 //switch to name of the frame1
		 driver.switchTo().frame("iamframe");
		 System.out.println("switched to the frame1");
		 driver.findElement(By.xpath("//*[@type='text']")).sendKeys("Enter text");
		 
		// Switch to 2nd frame
		 driver.switchTo().frame("frame3");
		 System.out.println("switched to the frame2");
		 driver.findElement(By.xpath("//*[@type='checkbox']")).click();
		 
		 // switch back to  1st frame and clear the data
		 driver.switchTo().defaultContent();
		 driver.switchTo().frame("iamframe");
		 WebElement data=driver.findElement(By.xpath("//*[@type='text']"));
		 data.clear();
		 
		 driver.switchTo().defaultContent();
		 
		 // Switch back to the frame2 go to the dropdown and clicking that dropdown
		 driver.switchTo().frame("frame2");
		 Select dropDown=new Select(driver.findElement(By.xpath("//*[@class='col-lg-3']")));
		 dropDown.selectByIndex(2);
		 dropDown.selectByValue("avatar");
		 dropDown.selectByVisibleText("Big Baby Cat");
		 
		 //    //*[@class='DayPicker DayPicker--en']/div[2]/div[@class='DayPicker-Caption'] --- Xpath for Month and clicking the date 
		 
		 
		 
	}

}
