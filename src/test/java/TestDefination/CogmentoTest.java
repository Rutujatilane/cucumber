package TestDefination;

import java.time.Duration;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CogmentoTest {

	static WebDriver driver;
	
	
	@Given("user is on login page")
	public void user_is_on_login_page() {
	   driver=new ChromeDriver() ;
		   driver.get("https://ui.cogmento.com/");
		   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();

	}

	@When("user enters valid username and password")
	public void user_enters_valid_username_and_password() {
		driver.findElement(By.name("email")).sendKeys("prafulp1010@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Pr@ful0812");


	}

	@Then("user click on login button")
	public void user_click_on_login_button() {
	    
		driver.findElement(By.xpath("//div[text()='Login']")).click();
		
		
	}

	@When("user validate home page title")
	public void user_validate_home_page_url() {
		String title = driver.getTitle();
		Assertions.assertEquals(title, "Cogmento CRM");
	}

	@When("user validate url")
	public void user_validate_title() {
		boolean url = driver.getCurrentUrl().contains("cogmento");
		Assertions.assertEquals(url, true);
	   
	}

	@When("user validate home page Logo")
	public void user_validate_home_page_logo() {
		boolean Logo = driver.findElement(By.xpath("//div[@class='header item']")).isDisplayed();
		Assertions.assertEquals(Logo, true);
	}

	@When("user click on contact link")
	public void user_click_on_contact_link() {
	    driver.findElement(By.xpath("//span[text()='Contacts']")).click();
	}

	@When("click on create button")
	public void click_on_create_button() {
	    driver.findElement(By.xpath("//button[text()='Create']")).click();
	}

	@When("Enter first name, last name , email, select status")
	public void enter_first_name_last_name_email_select_status() {
	    
		driver.findElement(By.name("first_name")).sendKeys("Rutuja");
		driver.findElement(By.name("last_name")).sendKeys("Tilane");
driver.findElement(By.xpath("//input[@placeholder='Email address']")).sendKeys("abc@gmail.com");
driver.findElement(By.name("status")).click();
		
List<WebElement> ls = driver.findElements(By.xpath("//div[@name='status']"));
for (WebElement list : ls) {
	String status = list.getText();
	if (status.equalsIgnoreCase("On Hold")) {
		list.click();
		break;
	}
}
	}

	@Then("click on save button")
	public void click_on_save_button() {
		driver.findElement(By.xpath("//button[text()='Save']")).click();
	}

	@Then("delete the contact")
	public void delete_the_contact() {
		driver.findElement(By.xpath("//i[@class='trash icon']")).click();
		driver.findElement(By.xpath("//button[text()='Delete']")).click();
	}

	@When("user on logout")
	public void user_on_logout() {
	    driver.findElement(By.xpath("//div[@class='ui basic button floating item dropdown']")).click();
	}

	
	@Then("user will logout from application")
	public void user_will_logout_from_application() {
		driver.findElement(By.xpath("//span[text()='Log Out']")).click();
	}



}
