package implementationFiles;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CalenderImplementation {

	WebDriver driver = new ChromeDriver();

	@Given("user launch url")
	public void user_launch_url() {
		WebDriverManager.chromedriver().setup();

		driver.manage().window().maximize();
		driver.get("https://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");

	}

	@When("user provide date")
	public void user_provide_date() {
		driver.findElement(By.id("datepicker")).click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("ui-datepicker-div")));

		String aMonth = driver.findElement(By.className("ui-datepicker-month")).getText();
		String aYear = driver.findElement(By.className("ui-datepicker-year")).getText();

		while (!(aMonth.equals("July") && aYear.equals("2024"))) {
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
			aMonth = driver.findElement(By.className("ui-datepicker-month")).getText();
			aYear = driver.findElement(By.className("ui-datepicker-year")).getText();

		}
		driver.findElement(By.xpath("//td[@data-handler='selectDay']/a[text()='23']")).click();
		
	}

	@Then("exacution done")
	public void exacution_done() {
		
		System.out.println("Succefully done");
	
	}

}
