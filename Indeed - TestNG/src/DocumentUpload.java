import java.awt.AWTException;
import java.util.List;
import java.io.File;
import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.FindElements;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.jacob.com.LibraryLoader;

import autoitx4java.AutoItX;

public class DocumentUpload {

	public static void docupload(WebDriver driver) throws InterruptedException, AWTException, IOException
	{
	//	driver.findElement(By.className("fieldsetDiv")).getAttribute("value");	
		
	//	element = driver.find_element_by_id("fileUpload")
	//			element.send_keys("C:\myfile.txt")

		WebElement home=driver.findElement(By.id("lnkHome"));
		String txt=home.getText();
		//System.out.println("before assertion home page");
		Assert.assertEquals("Home",txt);
		//System.out.println("after assertion home page");
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class = 'sectionHeader ui-widget-header']")));

		String str =driver.findElement(By.xpath("//div[@class = 'sectionHeader ui-widget-header']")).getText();
		String[] toMandatory=str.split(" ");
					
		String Value=toMandatory[8].substring(0,toMandatory[8].lastIndexOf(","));
		Integer MandatoryDoc=Integer.parseInt(Value);
		System.out.println(MandatoryDoc);
		Thread.sleep(8000);
		

	
			
	//	driver.findElement(By.xpath("//*[@class=\"btnUploadDocument ui-button ui-widget ui-state-default ui-corner-all\"]")).click();
		
		


		
		for(int i=0; i<MandatoryDoc; i++)
		{
			if (i==0)
			{
				Thread.sleep(3000);
								
				String rootelement=	driver.findElement(By.id("requiredSortables")).findElements(By.tagName("li")).get(i).findElement(By.tagName("input")).getAttribute("doctypename");
				
				System.out.println(rootelement);
				//driver.findElement(By.id("requiredSortables")).findElements(By.tagName("li")).get(i).findElement(By.tagName("input")).click();
				driver.findElement(By.id("requiredSortables")).findElements(By.tagName("li")).get(i).findElements(By.tagName("input")).get(1).click();
				System.out.println("browing file");
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnSingleBrowseFiles")));
				driver.findElement(By.id("btnSingleBrowseFiles")).click();
				UploadFileUsingJacobDll();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnSingleStartUpload")));
				driver.findElement(By.id("btnSingleStartUpload")).click();
			}
			else {
				Thread.sleep(5000);
				
				//String rootelement=	driver.findElement(By.id("requiredSortables")).findElements(By.tagName("li")).get(i).findElement(By.tagName("input")).getAttribute("doctypename");
				String rc=driver.findElement(By.id("requiredSortables")).findElements(By.tagName("li")).get(i).findElements(By.tagName("input")).get(1).getAttribute("value");
				System.out.println(rc);
				driver.findElement(By.id("requiredSortables")).findElements(By.tagName("li")).get(i).findElements(By.tagName("input")).get(1).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnSingleBrowseFiles")));
				driver.findElement(By.id("btnSingleBrowseFiles")).click();
				UploadFileUsingJacobDll_all();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnSingleStartUpload")));
				driver.findElement(By.id("btnSingleStartUpload")).click();
				Thread.sleep(3000);
		}
		}
		
		
//	driver.findElement(By.xpath("//*[@class=\"btnUploadDocument ui-button ui-widget ui-state-default ui-corner-all\"]")).click();
				driver.findElement(By.cssSelector("input[value='Next']")).submit();
				//Proceed to payment
				
				


		
	}
	
	public static void UploadFileUsingJacobDll()
			throws InterruptedException {
 
		String workingDir = System.getProperty("user.dir");
 
		final String jacobdllarch = System.getProperty("sun.arch.data.model")
				.contains("32") ? "jacob-1.18-x86.dll" : "jacob-1.18-x64.dll";
		String jacobdllpath = workingDir + "\\lib\\" + jacobdllarch;
 
		File filejacob = new File(jacobdllpath);
		System.setProperty(LibraryLoader.JACOB_DLL_PATH,
				filejacob.getAbsolutePath());
		AutoItX uploadWindow = new AutoItX();
 
		String filepath = "d:\\Photo.jpg";
 
		Thread.sleep(1000);
 
		if (uploadWindow.winWaitActive("File Upload", "", 5)) {
			if (uploadWindow.winExists("File Upload")) {
				uploadWindow.sleep(100);
				uploadWindow.send(filepath);
				uploadWindow.controlClick("File Upload", "", "&Open");
 
			}
		}
	}
	public static void UploadFileUsingJacobDll_all()
			throws InterruptedException {
 
		String workingDir = System.getProperty("user.dir");
 
		final String jacobdllarch = System.getProperty("sun.arch.data.model")
				.contains("32") ? "jacob-1.18-x86.dll" : "jacob-1.18-x64.dll";
		String jacobdllpath = workingDir + "\\lib\\" + jacobdllarch;
 
		File filejacob = new File(jacobdllpath);
		System.setProperty(LibraryLoader.JACOB_DLL_PATH,
				filejacob.getAbsolutePath());
		AutoItX uploadWindow = new AutoItX();
 
		String filepath = "d:\\Sponsor Passport Page 1.jpg";
 
		Thread.sleep(1000);
 
		if (uploadWindow.winWaitActive("File Upload", "", 5)) {
			if (uploadWindow.winExists("File Upload")) {
				uploadWindow.sleep(100);
				uploadWindow.send(filepath);
				uploadWindow.controlClick("File Upload", "", "&Open");
 
			}
		}
	}
}
