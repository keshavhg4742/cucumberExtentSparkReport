package stepdefination;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import hooksClass.MyHooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MyStef {
	
	WebDriver driver;
	public MyStef() {
		this.driver=MyHooks.driver;
	}
	

	@When("user enters username as {string} and password as {string}")
	public void user_enters_username_as_and_password_as(String usn, String pwd) throws Exception {
	    driver.findElement(By.name("username")).sendKeys(usn);
	    driver.findElement(By.name("pwd")).sendKeys(pwd);
	    Thread.sleep(3000);
	    driver.findElement(By.id("loginButton")).click();
	  //  Assert.assertTrue(false);
	    
	}

	@Then("home page should be display")
	public void home_page_should_be_display() {
		System.out.println(driver.getTitle());
		driver.close();
	    
	}

}
