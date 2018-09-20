import java.io.FileInputStream;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import logging.*;

public class SponsorSearch {
	public static void spnsrsearch(WebDriver driver) throws BiffException, IOException
	{
	//	WebDriverWait wait = new WebDriverWait(driver, 30);
	//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txtSearchSponsorTypeId")));
		ProjectLog.info("starting sponsor search");
		FileInputStream fileinput = new FileInputStream("D:\\SeleniumGecko\\Parameter.xls");
		Workbook wbook=Workbook.getWorkbook(fileinput);
		Sheet sheet=wbook.getSheet(0);
		driver.findElement(By.id("txtSearchSponsorTypeId")).sendKeys(sheet.getCell(5,1).getContents(),Keys.RETURN);
		//driver.findElement(By.id("tdSearchSponsorTypes")).sendKeys(sheet.getCell(5,1).getContents(),Keys.RETURN);
		
		driver.findElement(By.id("txtSearchEstDeptNo")).sendKeys("2");
		driver.findElement(By.id("txtSearchEstTypeNo")).sendKeys("1");
		driver.findElement(By.id("txtSearchEstablishmentNo")).sendKeys("300481");
		WebElement fromDateBox=driver.findElement(By.id("txtSearchEstablishmentExpiry"));
		fromDateBox.clear();
		fromDateBox.sendKeys("15/02/2019");
		driver.findElements(By.xpath(".//*[@class='ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only']")).get(0).click();
		
	}

}
