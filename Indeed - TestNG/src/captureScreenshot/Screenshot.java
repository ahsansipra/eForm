package captureScreenshot;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot {

	public static void captureshot(WebDriver driver,String name) throws IOException
	{
		driver.manage().window().maximize();
	//	driver.findElement(By.id(id));
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src,new File("./Screenshot/"+name+".png"));
		System.out.println("screenshot taken");
	}
}
