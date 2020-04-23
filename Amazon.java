package Amazon;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
public class Amazon {
	
	public static void main(String args[]) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://amazon.in");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
        driver.findElementById("twotabsearchtextbox").sendKeys("sanitizers alcohol",Keys.ENTER);
        String Mainwindow=driver.getWindowHandle();
        driver.findElementByXPath("(//span[contains(text(),\"Dabur Sanitize Hand Sanitizer\")])[1]").click();
      
        Set<String> s=driver.getWindowHandles();
        Iterator<String> i=s.iterator();
        while(i.hasNext())
        {
        	String Childwindow=i.next();
        	if(!Mainwindow.equalsIgnoreCase(Childwindow))
        	{
        		driver.switchTo().window(Childwindow);
        		driver.findElementByXPath("//*[@id=\"add-to-cart-button\"]").click();
        		String p1=driver.findElementByXPath("//*[@id=\"huc-v2-order-row-confirm-text\"]/h1").getText();
        		String p2="Added To Cart";
        		if(p1.equalsIgnoreCase(p2))
        			System.out.println("Successfully added to cart");
        		else
        			System.out.println("Failed while addding to cart");
        	}
        }
        
      
        
        
    } 
}
