package parallel;



//package steps;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;

import com.pages.ContactUsPage;
import com.qa.factory.DriverFactory;
import com.qa.util.ExcelReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ContactUsSteps {
	
	
	 private ContactUsPage contactUsPage = new ContactUsPage(DriverFactory.getDriver()); //private ContactUsPage class object
																						// pass the driver and get the driver from Driverfactory
	
	@Given("user navigates to contact us page")
	public void user_navigates_to_contact_us_page() {
		
		DriverFactory.getDriver().get("https://naveenautomationlabs.com/opencart/index.php?route=information/contact");// using driverfactory , navigate to the URL
		
		
	    
	}

	@When("user fills the form from given sheetname {string} and rownumber {int}")
	public void user_fills_the_form_from_given_sheetname_and_rownumber(String sheetName, Integer rowNumber) {
		
		ExcelReader reader = new ExcelReader();
		try {
			List<Map<String,String>> testData = reader.getData("C:\\Automation\\ContactAutomation.xlsx", sheetName);
			String Yourname = testData.get(rowNumber).get("Yourname");
			String Email = testData.get(rowNumber).get("Email");
			String Enquiry = testData.get(rowNumber).get("Enquiry");
			contactUsPage.fillContactUsPageform(Yourname, Email, Enquiry);
			
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//ContactUsPage.fillContactUsPageform(Yourname, Email, Enquiry);
		
	
		
		
		
	   
	}

	@When("user clicks on send button")
	public void user_clicks_on_send_button() throws InterruptedException  {
		
		contactUsPage.clickSubmit();
	  
	}

	@Then("it shows a successful message {string}")
	public void it_shows_a_successful_message(String expectedMessage) throws InterruptedException {
		
	String actualMessage =	contactUsPage.getSuccessMesssage();
	Assert.assertEquals(actualMessage, expectedMessage);
		

	
	}


}
