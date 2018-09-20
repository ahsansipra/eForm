import java.io.FileInputStream;
import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import captureScreenshot.*;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import logging.*;

public class AppLaunch {

	public static void luanchapplication(WebDriver driver) throws InterruptedException
	{
		//WebDriver driver=new FirefoxDriver(WebDriver driver);
		driver.get("http://eform4portal.eform.ae");
//		driver.get("http://10.155.20.196:9080/visioncore/index.jsp");
		Thread.sleep(2000);
		driver.findElement(By.className("en-GB")).sendKeys("English");
		driver.findElement(By.linkText("English")).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void login(WebDriver driver) throws BiffException, IOException, InterruptedException
	{
		FileInputStream fileinput = new FileInputStream("D:\\SeleniumGecko\\Parameter.xls");
		Workbook wbook=Workbook.getWorkbook(fileinput);
		Sheet sheet=wbook.getSheet(0);

		//driver.findElement(By.id("LoginId")).sendKeys("eform_dev_22");
		
		driver.findElement(By.id("LoginId")).sendKeys(sheet.getCell(0,2).getContents());
		driver.findElement(By.id("Password")).sendKeys("P@ss12345");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		//System.out.println("total rows are: "+sheet.getRows());
		//System.out.println("1nd colum value: "+sheet.getColumn(4).length);
	
		//take screen shot
	//	Screenshot.captureshot(driver, "Before Login");
		
		Thread.sleep(3000);
				
		WebElement objwelcome = null;
		try {
		objwelcome=driver.findElement(By.className("qmitem-m"));
			} catch(NoSuchElementException exeption) {
				ProjectLog.error("Login failed in app launch");
			//System.out.println("Element not found");
		}
		
			if (objwelcome !=null)
				
				driver.findElement(By.id("btnNotificationCancel")).click();
			else
			{
				
		//take error screen shot
		Screenshot.captureshot(driver, "login error");
		ProjectLog.warn("next iteration");
		driver.findElement(By.id("LoginId")).clear();
		driver.findElement(By.id("LoginId")).sendKeys(sheet.getCell(0, 1).getContents());
		driver.findElement(By.id("Password")).sendKeys("P@ss12345");
		//after login
	//	Screenshot.captureshot(driver, "after Login");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
	//	WebElement em=driver.findElement(By.id("btnNotificationCancel"));
	
	//	Assert.assertEquals(true, em.isDisplayed());
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnNotificationCancel")));
	//	wait.until(ExpectedConditions.elementToBeClickable(By.id("btnNotificationCancel")));
		driver.findElement(By.id("btnNotificationCancel")).click();
		Thread.sleep(5000);
			}
	}
}
