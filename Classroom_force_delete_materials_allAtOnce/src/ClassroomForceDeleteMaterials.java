import java.util.List;

import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


/**
 * @author Hussein Hazimeh
 *
 */
public class ClassroomForceDeleteMaterials {
public static void main(String [] args) throws InterruptedException{
	
	//replece with the path of your webdriver
	System.setProperty("webdriver.chrome.driver","C:\\users\\Hussein\\desktop\\chromedriver_win32\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	
    String baseUrl = "https://forms.google.com/";
    
    driver.get(baseUrl);
    driver.findElement(By.name("identifier")).sendKeys("hussein.hazimeh@mu.edu.lb");

    driver.findElement(By.className("VfPpkd-RLmnJb")).click();
    Thread.sleep(5000);
    driver.findElement(By.name("password")).sendKeys("your_password");
    
    driver.findElement(By.className("VfPpkd-RLmnJb")).click();
    
    //replace with your google classroom class link
    String classroom = "https://classroom.google.com/u/3/w/Mjc5MzAwNzk5OTI0/t/all";
    
    driver.get(classroom);
    
    Thread.sleep(1000); 
    driver.get(classroom);
     
    Thread.sleep(6000);
      
    List<WebElement> _els = driver.findElements(By.xpath(".//*[@class='SFCE1b']"));
    
    System.out.println("total materials inside your class are: " + _els.size());
    
    for(int i = 1; i<_els.size(); i++){
    	//adjust the thread sleeping time based on your internet speed (more time if you have slower connection)
	    Thread.sleep(2000);
	    Thread.sleep(2000);
	    
	    Actions action = new Actions(driver);
	    
	    action.moveToElement
	    (driver.
	    		findElement(By.xpath("(.//*[@class='jWCzBe QRiHXd idtp4e u73Apc'])[" + i + "]"))).click().build().perform();
	    
	    //increment i by n to prevent deleting the classroom sections (n) 
	    //is the number of sections do you want skip 
	    driver.
	    findElement(By.xpath("(.//*[@class='Lw7GHd snByac'])[" + (i+3) + "]")).click();
	    
	    Thread.sleep(1000);
	    Thread.sleep(1000);
	    
	    driver.
	    findElement(By.xpath("//span[contains(@aria-label, 'Delete')]")).click();
	    Thread.sleep(1500);
	    
	    driver.
	    findElement(By.xpath("(.//*[@class='uArJ5e UQuaGc kCyAyd l3F1ye ARrCac HvOprf evJWRb M9Bg4d'])")).click();
    }
  }
}
