package pom;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage extends Base{
	By registerEmailLocator = By.id("email_create");
	By siginLocator = By.linkText("Sign in");
	By authenticationLocator = By.id("authentication");
	By customerFirstNameLocator = By.name("customer_firstname");
	By customerLastNameLocator = By.name("customer_lastname");
	By firstNameLocator = By.name("firstname");
	By lastNameLocator = By.name("lastname");
	By genderTwoLocator = By.id("id_gender2");
	By passwordLocator = By.id("passwd");
	By birthdaysLocator = By.id("days");
	By birthMonthsLocator = By.id("months");
	By birthYearLocator = By.id("years");
	By receiveSpecialLocator = By.id("optin");
	By companyLocator = By.id("company");
	By address1Locator = By.id("address1");
	By address2Locator = By.id("address2");
	By cityLocator = By.id("city");
	By stateLocator = By.id("id_state");
	By postcodeLocator = By.id("postcode");
	By phoneMobileLocator = By.id("phone_mobile");
	By aliasLocator = By.id("alias");
	By submitAccountLocator = By.id("submitAccount");
	By myAccountLocator = By.id("my-account");
	String username = "vosorio";
	public RegisterPage(WebDriver webDriver) {
		super(webDriver);
		// TODO Auto-generated constructor stub
	}
	
	public Boolean registerUser(Boolean isCheckout) throws InterruptedException{
		if(!isCheckout){
			click(siginLocator);
		}
		Thread.sleep(2000);
		Random rand = new Random();
		String email = username + rand.nextInt(1000)+"@gmail.com";
		type(email,registerEmailLocator);
		submit(registerEmailLocator);
		Thread.sleep(2000);
		if(isDisplayed(authenticationLocator)){
			
			click(genderTwoLocator);
			type(VariablesUtil.firstName,customerFirstNameLocator);
			type(VariablesUtil.lastName,customerLastNameLocator);
			type(VariablesUtil.password,passwordLocator);
			selectOption(birthdaysLocator,"20  ");
			selectOption(birthMonthsLocator,"March ");
			selectOption(birthYearLocator,"1990  ");
			click(receiveSpecialLocator);
			type(VariablesUtil.company,companyLocator);
			type(VariablesUtil.address1,address1Locator);
			type(VariablesUtil.address2,address2Locator);
			type(VariablesUtil.city,cityLocator);
			selectOption(stateLocator,"California");
			type(VariablesUtil.postCode,postcodeLocator);
			type(VariablesUtil.phone_mobile,phoneMobileLocator);
			clear(findElement(aliasLocator));
			type(VariablesUtil.alias,aliasLocator);
			click(submitAccountLocator);
			
			Thread.sleep(2000);
			if(!isCheckout && isDisplayed(myAccountLocator)){
				return true;
			}else {
				return true;
			}
			
			
		} else{
			System.out.println("No se pudo realizar el registro");
		}
		return false;
	}

	
	
}
