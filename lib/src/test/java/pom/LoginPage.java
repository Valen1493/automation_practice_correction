package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends Base{
	
	By siginLocator = By.linkText("Sign in");
	By emailLocator = By.id("email");
	By passwordLocator = By.id("passwd");
	By myAccountLocator = By.id("my-account");
	By submitLoginLocator = By.id("SubmitLogin");
	
	Persona persona = Persona.getInstance("valentina", "1234");
	public LoginPage(WebDriver webDriver) {
		super(webDriver);
		// TODO Auto-generated constructor stub
	}
	
	public Boolean loginUser(Boolean isCheckout) throws InterruptedException{
		if(!isCheckout){
			click(siginLocator);
		}
		
		Thread.sleep(2000);
		type(VariablesUtil.email,emailLocator);
		Thread.sleep(2000);
		type(VariablesUtil.password,passwordLocator);
		Thread.sleep(2000);
		click(submitLoginLocator);
		if(!isCheckout && isDisplayed(myAccountLocator)){
			Thread.sleep(2000);
			return true;
		}else if (isCheckout){
			return true;
		}
		return false;
	}

}
