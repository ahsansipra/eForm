import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import logging.*;

public class ApplicantInfo {

	public static void appli_detail(WebDriver driver) throws InterruptedException
	{
		
		Thread.sleep(2000);
		ProjectLog.info("Applicant infor started");
		driver.findElement(By.xpath("//*[@id=\"SponsorRelationId\"]")).sendKeys("NOT RELATED",Keys.RETURN);
		driver.findElement(By.id("SponsorResidenceTypeId_1")).click();
		driver.findElement(By.id(("ApplicantName_FirstName"))).sendKeys("Selenium First",Keys.RETURN);
		driver.findElement(By.id("ApplicantName_LastName")).sendKeys("Demo",Keys.RETURN);
		driver.findElement(By.xpath("//*[@id=\"toArabic_Personal Information\"]")).click();
		driver.findElement(By.id("ApplicantName_FullName")).click();
		driver.findElement(By.id("NationalityId")).sendKeys("PAKISTAN",Keys.RETURN);
		driver.findElement(By.id("JobId")).sendKeys("BUSINESS",Keys.RETURN); //9800601
		driver.findElement(By.id("GenderId")).sendKeys("Male",Keys.RETURN);
		WebElement ele=driver.findElement(By.id("DateOfBirth"));
		ele.clear();
		ele.sendKeys("01/01/1980",Keys.RETURN);
		driver.findElement(By.id("AppPlaceOfBirth_PlaceofBirth")).sendKeys("Lahore",Keys.RETURN);
		driver.findElement(By.xpath("//*[@id=\"toPlaceofBirthArabic_Personal Information\"]")).click();
		driver.findElement(By.id("PassportNumber")).sendKeys("Demo0001",Keys.RETURN);
		driver.findElement(By.xpath("//*[@id=\"PassportTypeId\"]")).sendKeys("Normal");
		
		driver.findElement(By.id("AppPlaceOfIssue_PlaceofIssue")).sendKeys("Lahore",Keys.RETURN);
		driver.findElement(By.xpath("//*[@id=\"toPlaceofIssueArabic_Personal Information\"]")).click();
		WebElement doi=driver.findElement(By.id("DateOfIssue"));
		doi.clear();
		doi.sendKeys("01/01/2013",Keys.RETURN);
		WebElement doe=driver.findElement(By.id("ExpiryDate"));
		doe.clear();
		doe.sendKeys("01/01/2018",Keys.RETURN);
		ProjectLog.info("date information");
		
		
		driver.findElement(By.id("ReligionId")).sendKeys("MUSLIM",Keys.RETURN);
		driver.findElement(By.id("FaithId")).sendKeys("Sunni",Keys.RETURN);
		driver.findElement(By.id("MaritalStatusId")).sendKeys("MARRIED",Keys.RETURN);
		  
		driver.findElement(By.id("EducationLevelId")).sendKeys("UNIVERSITY DEGREE",Keys.RETURN);
		driver.findElement(By.id("AppMotherName_MotherName")).sendKeys("mother",Keys.RETURN);
		driver.findElement(By.xpath("//*[@id=\"toMotherArabic_Personal Information\"]")).click();
		
		driver.findElement(By.id("FirstLanguageId")).sendKeys("URDU",Keys.RETURN);
		driver.findElement(By.id("Submitter")).sendKeys("PRO / Delegate",Keys.RETURN);
		
		WebElement eida=driver.findElement(By.id("Submitterss_SubmitterEIDANumber"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].removeAttribute('readonly')",eida);
		eida.sendKeys("2432423",Keys.RETURN);
		
		driver.findElement(By.id("EmirateId")).sendKeys("DUBAI",Keys.RETURN);
		driver.findElement(By.id("CityId")).sendKeys("BUR DUBAI",Keys.RETURN);
		driver.findElement(By.id("RegionId")).sendKeys("AL BARSHA SECOND",Keys.RETURN);
		driver.findElement(By.id("Street")).sendKeys("12",Keys.RETURN);
		driver.findElement(By.id("Building")).sendKeys("12",Keys.RETURN);
		driver.findElement(By.id("PoBox")).sendKeys("12",Keys.RETURN);
		driver.findElement(By.id("POBoxEmiratesId")).sendKeys("DUBAI",Keys.RETURN);
		driver.findElement(By.id("ResidencePhone")).sendKeys("023432432",Keys.RETURN);
		driver.findElement(By.id("OfficePhone")).sendKeys("043325325",Keys.RETURN);
		driver.findElement(By.id("MobileNumber")).sendKeys("0502233445",Keys.RETURN);
		driver.findElement(By.id("AddressInsideUAEEmail")).sendKeys("abc@abc.com",Keys.RETURN);
		driver.findElement(By.id("IsReuseAddressInsideAddress")).click();
	//	driver.findElement(By.id("DeliveryAddressEmail")).sendKeys("abc@abc.com",Keys.RETURN);
		driver.findElement(By.id("SubmissionEmirateId")).sendKeys("DUBAI",Keys.RETURN);
	//	System.out.print("all done"); 
		driver.findElement(By.id("btnSaveAndAttach")).click();
		Thread.sleep(3000);
		
		
		 

		
	}
}
