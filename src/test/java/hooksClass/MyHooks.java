package hooksClass;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MyHooks {
	public static WebDriver driver;
	@Before
	public void setUp() {
		WebDriverManager.chromedriver().setup();
	    driver=new ChromeDriver();
	    driver.get("https://online.actitime.com/xlh/login.do");
	}
	
	@After
	public void tearDown(Scenario s) {
		if(s.isFailed()) {
			byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			s.attach(screenshot, "image/png", "image");
		}
		
	}

}
