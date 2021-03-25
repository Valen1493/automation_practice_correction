package automation_practice_test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import pom.Base;
import pom.RegisterPage;
import pom.VariablesUtil;

public class RegisterTest {

	private WebDriver webDriver;
	RegisterPage registerPage;
	private static final String url = "http://automationpractice.com/index.php";
	@Before
	public void setUp() throws InterruptedException{
		webDriver = Base.setUp(VariablesUtil.url);
		registerPage = new RegisterPage(webDriver);
		
		registerPage.visit(VariablesUtil.url);
		
	}
	@Test
	public void register() throws InterruptedException {
		assertTrue(registerPage.registerUser(false));
		
	}
	
	@After
	public void tearDown(){
		webDriver.close();
	}

}
