package pack;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Test_runner {
	WebDriver driver;
  @Test
  public void f() {
	  driver.get("http://ec2-18-219-199-137.us-east-2.compute.amazonaws.com:8090/TestWebapp/");
		System.out.println("TDD : Website loaded---------------------------------------------------");
	 
  }
  @BeforeTest
  public void beforeTest() {
	 
		
		 String loc = "c:\\gecko\\geckodriver.exe";
		  System.setProperty("webdriver.gecko.driver",loc);
			driver=new FirefoxDriver();
			System.out.println("TDD : Driver loaded---------------------------------------------------");
  }

  @AfterTest
  public void afterTest() {
	  driver.findElement(By.xpath("/html/body/form/div[2]/input[1]")).sendKeys("admin");
		driver.findElement(By.xpath("/html/body/form/div[2]/input[2]")).sendKeys("pass");
		String expected="admin";
		String actual=driver.findElement(By.xpath("/html/body/form/div[2]/input[1]")).getAttribute("value");
		System.out.println("TDD : Details entered---------------------------------------------------");
		driver.findElement(By.xpath("/html/body/form/div[2]/button")).click();
		Assert.assertEquals(actual, expected);
		System.out.println("TDD : Assert passed---------------------------------------------------");
		driver.close();
		System.out.println("TDD : Driver closed---------------------------------------------------");
  }

}
