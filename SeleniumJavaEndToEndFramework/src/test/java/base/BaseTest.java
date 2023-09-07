package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	//Login functionality
	
	// we shouldn't hardcode these values
	// External file is - Properties File
	
	//String browser="edge";
	
	WebDriver driver;
	
	@Test
	public WebDriver applicationLogin() throws IOException
	{
		
		FileInputStream  fis = new FileInputStream("C:\\TestingProjects\\SeleniumJavaEndToEndFramework\\resources\\config.properties");
		
		//Properties class will help us to read any properties file
		Properties prop = new Properties();
		
		prop.load(fis);
		
		
		if(prop.getProperty("browser").equalsIgnoreCase("chrome"))
		{
			 driver= new ChromeDriver();
			WebDriverManager.chromedriver().setup();
			 driver.manage().window().maximize();
			 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
			 
			 driver.get(prop.getProperty("url"));
	         driver.findElement(By.name("username")).sendKeys(prop.getProperty("username"));
	         driver.findElement(By.name("password")).sendKeys(prop.getProperty("password"));
	         driver.findElement(By.xpath("//button[@type='submit']")).click();
			
		}
		else if(prop.getProperty("browser").equalsIgnoreCase("edge"))
		{
			
			driver= new EdgeDriver();
			WebDriverManager.edgedriver().setup();
			 driver.manage().window().maximize();
			 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
			 
			 driver.get(prop.getProperty("url"));
	         driver.findElement(By.name("username")).sendKeys(prop.getProperty("username"));
	         driver.findElement(By.name("password")).sendKeys(prop.getProperty("password"));
	         driver.findElement(By.xpath("//button[@type='submit']")).click();
		}
		else if(prop.getProperty("browser").equalsIgnoreCase("firefox"))
		{
			driver= new FirefoxDriver();
			WebDriverManager.firefoxdriver().setup();
			 driver.manage().window().maximize();
			 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
			 
			 driver.get(prop.getProperty("url"));
	         driver.findElement(By.name("username")).sendKeys(prop.getProperty("username"));
	         driver.findElement(By.name("password")).sendKeys(prop.getProperty("password"));
	         driver.findElement(By.xpath("//button[@type='submit']")).click();
		}
		
		
         return driver;
	}

}
