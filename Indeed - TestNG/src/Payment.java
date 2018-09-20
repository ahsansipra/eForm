import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Payment {
	
	public static void pay_fee(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.partialLinkText("Proceed to Payment")));
		driver.findElement(By.partialLinkText("Proceed to Payment")).click();
		
		driver.findElement(By.id("PaymentType")).sendKeys("Virtual Payment",Keys.RETURN);
		driver.findElement(By.id("IBANNumber")).sendKeys("234235324333333333333",Keys.RETURN);
		driver.findElement(By.className("chkAgree")).click();
		driver.findElement(By.partialLinkText("View")).click();
		driver.findElement(By.partialLinkText("close")).click();
		
		
		
		
	}

}
