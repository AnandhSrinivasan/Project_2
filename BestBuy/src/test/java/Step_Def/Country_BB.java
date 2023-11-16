package Step_Def;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Country_BB {
	
	public static WebDriver driver ;
	public static WebDriverWait wait ; 

	@Given("the user is on the BestBuy page")
	public void the_user_is_on_the_best_buy_page() {
		driver = new ChromeDriver();
		driver.navigate().to("https://www.bestbuy.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		System.out.println(driver.getTitle());
		
	}


	@And("the user clicks the country")
	public void the_user_clicks_the_country() {
		
		WebElement choosecanada= driver.findElement(By.xpath("(//img[@alt='Canada'])[1]"));
		choosecanada.click();
	}

	@Then("the user should be successfully step into HOMEPAGE")
	public void the_user_should_be_successfully_step_into_homepage() {
		WebElement clickacc= driver.findElement(By.xpath("(//span[@class='accountLabel_2-flX accountLabel_1xE3m'])[1]"));
		System.out.println(clickacc.getText());
	}

         //Given URL 
		 String urlToCheck = "https://www.bestbuy.com";

		 // Navigate to the URL
		 driver.get(urlToCheck);
		 List<WebElement> links = driver.findElements(By.tagName("a"));
 
		 System.out.println("Total links on the page: " + links.size());
 
		 // Iterate through each link and check if it broken
		 for (WebElement link : links) {
			 String href = link.getAttribute("href");
			 if (href != null && !href.isEmpty()) {
				 // Check if the URL is valid
				 if (isLinkBroken(new URL(href))) {
					 System.out.println("Broken Link: " + href);
				 } else {
					 System.out.println("Valid Link: " + href);
				 }
			 }
		 }
 
		 
	 }
 
	 // Function to check if a link is broken
	 public static boolean isLinkBroken(URL url) {
		 try {
			 HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			 connection.connect();
			 int responseCode = connection.getResponseCode();
			 connection.disconnect();
			 return (responseCode >= 400);
		 } catch (Exception e) {
			 e.printStackTrace();
			 return true;
		 }
	 }
	 
 

}
