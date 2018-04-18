package com.paybank.maven.paybank.beneficiary;

//import static org.testng.Assert.assertTrue;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SeleniumTest {
	public static void main(String [] args) {
		try {
						
			String URL2 = "https://pay-bank-hello.cfapps.io/#/login";
			
			DesiredCapabilities dc = DesiredCapabilities.firefox();
			dc.setCapability("marionette", false);
			FirefoxOptions fo = new FirefoxOptions(dc);
						
			WebDriver driver = new RemoteWebDriver(new URL("Remote_SERVER_URL"), fo);

			driver.get(URL2);
			String response = driver.getPageSource();
			
			// get All functions

			System.out.println("PageSource " + response);
			
			driver.findElement(By.id("name")).sendKeys("username");
			System.out.println("Name entered");
			
			driver.findElement(By.id("pass")).sendKeys("pass");
			System.out.println("Password entered");
			driver.findElement(By.className("btn")).click();
			System.out.println("Btn clicked");
			Thread.sleep(1000);
			driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/li[2]/a")).click();
			
			System.out.println("Add beneficiary clicked");
			Thread.sleep(1000);
			driver.findElement(By.id("name")).sendKeys("Triveni");
			System.out.println(driver.findElement(By.id("name")).getAttribute("placeholder")); 
			System.out.println("Account name entered");
			Thread.sleep(1000);
			WebElement accNumber=driver.findElement(By.id("acNumber"));
			accNumber.sendKeys("100010103");
			//driver.findElement(By.xpath(".//*[@id='acNumber']")).sendKeys("100010103");	
			
			System.out.println("Number entered");
			Thread.sleep(1000);
			//driver.findElement(By.className("btn")).click();
			
			Thread.sleep(1000);
			List<WebElement> listAccountNumber;
			ArrayList<String> listAccNumString= new ArrayList<String>();

			listAccountNumber=driver.findElements(By.xpath("//table/tbody/tr"));
			System.out.println(listAccountNumber.size());
			for(int i=1;i<=listAccountNumber.size();i++)
			{
				String txt=(driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[2]")).getText());
				listAccNumString.add(txt);
				System.out.println(txt);
			}
			System.out.println(listAccNumString);
			if(listAccNumString.contains("100010103"))
			{
				System.out.println("Pass");
				assertTrue(listAccNumString.contains("100010103"));
			}
			else
				System.out.println("Fail");
			
			

			driver.quit();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
}