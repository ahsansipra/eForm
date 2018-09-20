import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class ApplicationManagement {

	public static void manage(WebDriver driver) throws InterruptedException
	{
		//Thread.sleep(5000);
		driver.findElement(By.linkText("Application Management")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("ApplicationNumber")).sendKeys("2017201035092",Keys.RETURN);
		Thread.sleep(3000);
		//driver.findElements(By.className("buttonsCustom searchApplication ui-button ui-widget ui-state-default ui-corner-all")).get(0).click();
		//	driver.findElement(By.className("buttonsCustom searchApplication ui-button ui-widget ui-state-default ui-corner-all")).click();
		driver.findElement(By.xpath("//*[@class=\"buttonsCustom searchApplication ui-button ui-widget ui-state-default ui-corner-all\"]")).click();
		Thread.sleep(5000);
		driver.findElement(By.linkText("Edit Documents")).click();
	
				
	}
}
