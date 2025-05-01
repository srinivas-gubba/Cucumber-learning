package parallel;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.pages.AccountPage;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.DataTableType;

public class AccountPageSteps {
	
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private  AccountPage accountPage;

	@Given("user has already logged in to application")
	public void user_has_already_logged_in_to_application(DataTable credentialsTable) {
		
		List<Map<String,String>> credList = credentialsTable.asMaps();
		String userName = credList.get(0).get("username");
		String passWord = credList.get(0).get("password");
		
		DriverFactory.getDriver().get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		accountPage = loginPage.doLogin(userName, passWord);
	}

	@Given("user is on Accounts page")
	public void user_is_on_accounts_page() {

		String accountPagetitle = accountPage.getAccountPageTitle();
		System.out.println("Account page title:" +accountPagetitle);
	}

	@Then("user gets accounts section")
	public void user_gets_accounts_section(DataTable SectionaTable) {
		
		List<String> expectedSectionlist = SectionaTable.asList();
		System.out.println("Expected section list:" +expectedSectionlist);
		
		List<String> actualSectionlist = accountPage.getAccountsectionList();
		System.out.println("Actual section list:" + actualSectionlist);
		
		Assert.assertTrue(expectedSectionlist.containsAll(actualSectionlist));
		
	    
	}

	@Then("accounts section count should be {int}")
	public void accounts_section_count_should_be(Integer expectedCount) {
		
		Assert.assertTrue(accountPage.getAccountSectionCount() == expectedCount);
	
	}

	
}
