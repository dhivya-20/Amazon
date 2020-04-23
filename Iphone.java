package Amazon;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;

public class Iphone {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get(
				"https://www.amazon.in/Apple-iPhone-XR-128GB-RED/dp/B07JHFK8R3/ref=sr_1_3?crid=1WMOE6RQEIW80&dchild=1&keywords=iphone+xr+128&qid=1587438396&s=hpc&sprefix=iphone+xr+128%2Chpc%2C626&sr=1-3-catcorr");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

		String p = driver.findElementById("title").getText();
		System.out.println("Size:" + p.substring(17, 22));
		System.out.println("Colour:" + p.substring(34, 37));

		// video
		driver.findElementByXPath("(//input[@class=\"a-button-input\"])[4]").click();
		
		//WebDriverWait wait = new WebDriverWait(driver,30);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"anonCarousel1\"]/ol/li[2]/div/a")));
        driver.findElementByXPath("//*[@id=\"anonCarousel1\"]/ol/li[2]/div/a").click();
        Thread.sleep(45000);
		System.out.println("Video played");
		driver.findElementByXPath("//*[@id='a-popover-2']/div/header/button").click();

		// Status
		String p3 = driver.findElementByXPath("//span[@class=\"a-size-medium a-color-price\"]").getText();
		System.out.println("Status:" + p3);

		// price
		driver.navigate().to(
				"https://www.google.com/search?q=apple+iphone+xr+128gb+red&source=lnms&sa=X&ved=0ahUKEwj2vrCd3fnoAhUe4jgGHQh9Bj4Q_AUICSgA&biw=1366&bih=651&dpr=1");
		String str1 = driver.findElementByXPath("(//span[@class=\"TsZoG\"])[1]").getText();
		System.out.println("Price:" + str1);
		driver.navigate().back();

		// location
		driver.findElementById("contextualIngressPtLabel_deliveryShortLine").click();
		driver.findElementById("GLUXZipUpdateInput").sendKeys("600083");
		driver.findElementByXPath("(//input[@class=\"a-button-input\"])[11]").click();
		String str2 = driver.findElementByXPath("//*[@id=\"contextualIngressPtLabel_deliveryShortLine\"]/span[2]")
				.getText();
		System.out.println("Location:" + str2);

		// Ratings
		driver.findElementById("acrCustomerReviewText").click();
		System.out.println(
				"Ratings:" + driver.findElementByXPath("//span[@class=\"a-size-medium a-color-base\"]").getText());

		// Add to wishlist
		driver.findElementByXPath("//a[@id='wishListMainButton-announce']").click();
		System.out.println("Added to Wishlist");
	}

}
