package automation_practice_test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import pom.Base;
import pom.LoginPage;
import pom.StorePage;
import pom.VariablesUtil;

public class StoreTest {
	private WebDriver webDriver;
	private StorePage storePage;
	@Before
	public void setUp() throws Exception {
		webDriver = Base.setUp(VariablesUtil.url);
		storePage = new StorePage(webDriver);
		storePage.visit(VariablesUtil.url);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void addCartTest() throws InterruptedException {
		assertTrue(storePage.addCart());
	}
	
	@Test
	public void checkoutCartLoginTest() throws InterruptedException {
		storePage.addCart();
		assertTrue(storePage.checkoutCartLogin(webDriver));
	}
	
	@Test
	public void checkoutCartRegisterTest() throws InterruptedException {
		storePage.addCart();
		assertTrue(storePage.checkoutCartRegister(webDriver));
	}

}
