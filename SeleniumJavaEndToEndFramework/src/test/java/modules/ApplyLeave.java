package modules;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestListener;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import base.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ApplyLeave  {
	
	
	////button[@title='Apply Leave']
	
	
	WebDriver driver;

	ApplyLeave() throws IOException
	{
		
		BaseTest bt = new BaseTest();
		driver=	bt.applicationLogin();
		

	}
	
	@Test
	public void clickOnApplyLeave()
	{
		
		
	   	driver.findElement(By.xpath("//button[@title='Apply Leave']")).click();
		
	}
	
	
	@AfterClass
	public void closeBrowser()
	{
		
		driver.close();
		}

}
