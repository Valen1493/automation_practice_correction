package automation_practice_test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import pom.Base;
import pom.LoginPage;
import pom.RegisterPage;
import pom.VariablesUtil;

public class LoginTest {
	private WebDriver webDriver;
	
	LoginPage loginPage;
	@Before
	public void setUp() throws InterruptedException{
		webDriver = Base.setUp(VariablesUtil.url);
		loginPage = new LoginPage(webDriver);
		loginPage.visit(VariablesUtil.url);
	}
	@After
	public void tearDown() throws Exception {
		//webDriver.close();
	}

	@Test
	public void test() throws InterruptedException {
		assertTrue(loginPage.loginUser(false));
	}

}
