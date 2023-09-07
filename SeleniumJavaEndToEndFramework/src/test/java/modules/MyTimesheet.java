package modules;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import base.BaseTest;

public class MyTimesheet {
	
	
	WebDriver driver3;
	
	////button[@title='My Timesheet']
	
	MyTimesheet() throws IOException
	{
		
		BaseTest bt = new BaseTest();
		driver3=bt.applicationLogin();
		
		
	}
	
	
	@Test
	public void clickOnMyTimeSheet()
	{
		
		
		driver3.findElement(By.xpath("//button[@title='My Timesheet']")).click();
	}
	
	
	@AfterClass
	public void closeBrowser()
	{
		
		driver3.close();
		}

}
