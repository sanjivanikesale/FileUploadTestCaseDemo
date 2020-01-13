package fileuploadcode;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import webAutomation.FileUpload.base.TestUtilities;

public class FileSelectCode extends TestUtilities
{
	@Parameters({ "filepath"})
	@Test(priority = 1)
	public  void uploadFile(String filepath) throws IOException 
	{	
		log.info("Starting File upload test");
		
		String filename = System.getProperty("user.dir") + "//src//main//Files/demo.txt";
		
		driver.findElement(By.xpath("//*[@id=\"file-upload\"]")).sendKeys(filename);
				
		driver.findElement(By.xpath("//*[@id=\"file-submit\"]")).click();
		
		takeScreenshot("file1");
	}
}