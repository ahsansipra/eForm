import java.awt.AWTException;
import java.io.IOException;
import org.apache.log4j.xml.DOMConfigurator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.config.Configurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;

import logging.ProjectLog;
import jxl.read.biff.BiffException;
public class indeed {
	
	//public WebDriver driver;

	public static void rewmain(String[] args) throws BiffException, IOException, InterruptedException, AWTException {
		
			System.setProperty("webdriver.gecko.driver",
			"D:\\SeleniumGecko\\geckodriver.exe");
			//logging-------------------------------------------
			DOMConfigurator.configure("log4j.xml");
			Configurator.setLevel("logging.ProjectLog", Level.ALL);
			ProjectLog.startTestCase("testCase1");

			WebDriver driver=new FirefoxDriver();
			AppLaunch launch=new AppLaunch();
			
		
			
//application launch
AppLaunch.luanchapplication(driver);

//application login
AppLaunch.login(driver);


//Select Service
//ServiceSelection sselect=new ServiceSelection();
//sselect.service(driver);

//Sponsor Search
//SponsorSearch sr=new SponsorSearch();
//sr.spnsrsearch(driver);

//Applicant data
//ApplicantInfo appl=new ApplicantInfo();
//appl.appli_detail(driver);

ApplicationManagement am=new ApplicationManagement();
ApplicationManagement.manage(driver);

DocumentUpload du=new DocumentUpload();
//ProjectLog.endTestCase("EndTC1");
DocumentUpload.docupload(driver);
Payment pay=new Payment();
pay.pay_fee(driver);
//ProjectLog.endTestCase("EndTC1");

		
     //   driver.findElement(By.id("SubCategoryId")).sendKeys(subval,Keys.RETURN);
		
	
}
	
		
	


	

}
