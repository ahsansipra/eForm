//import org.apache.bcel.generic.Select;
import java.io.FileInputStream;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import captureScreenshot.*;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import logging.*;
public class ServiceSelection {

	public static void service(WebDriver driver) throws BiffException, IOException, InterruptedException
	{
		driver.findElement(By.linkText("Create Application")).click();
		
		Thread.sleep(4000);

	//	Select obj=new Select(driver.findElement(By.id("CategoryId")));
	//	List<WebElement>  ecount = obj.getOptions();
			
		ProjectLog.info("Staring service");
		FileInputStream fileinput = new FileInputStream("D:\\SeleniumGecko\\Parameter.xls");
		Workbook wbook=Workbook.getWorkbook(fileinput);
		Sheet sheet=wbook.getSheet(0);
		driver.findElement(By.id("CategoryId")).sendKeys(sheet.getCell(2,1).getContents(),Keys.RETURN);
		
		Thread.sleep(2000);
		driver.findElement(By.id("SubCategoryId")).sendKeys(sheet.getCell(3,1).getContents(),Keys.RETURN);
		Thread.sleep(2000);
		
		//take screen shot		
		Screenshot.captureshot(driver, "Service Selected");
		
		driver.findElement(By.id("Id")).sendKeys(sheet.getCell(4,1).getContents(),Keys.RETURN);
		driver.findElement(By.id("btnSubmit")).click();
	
		
		Thread.sleep(5000);
	
//				for (WebElement option : ecount) {
//				    option.click();
//				    driver.findElement(By.id("CategoryId")).equals(option);
//				    driver.findElement(By.id("CategoryId")).
//			//	   option.findElement(By.id("CategoryId")).sendKeys(sValue,Keys.RETURN);
//			//	    driver.findElement(By.id("CategoryId")).sendKeys(sValue,Keys.RETURN);
//				    int I=1;
//				    System.out.println(I);
//				    ecount.iterator().next();
//				    I++;
//				}
			
			
	}
}
			
	

