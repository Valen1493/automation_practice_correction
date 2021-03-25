package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StorePage extends Base {
	By menuLocator = By.linkText(VariablesUtil.nameMenu);
	By selectProductLocator = By.linkText("Faded Short Sleeve T-shirts");
	By quantityPlusLocator = By.id("quantity_wanted");
	By colorLocator = By.id("color_14");
	By submitCart = By.name("Submit");
	By sizeLocator = By.id("product");
	By checkoutLocator = By.className("icon-ok");
	By proceedCheckOutLocator = By.linkText("Proceed to checkout");
	By addressLocator = By.className("page-heading");
	By aceptTerms = By.name("cgv");
	By shipingAreaLocator = By.id("carrier_area");
	By paymentBlockLocator = By.className("paiement_block");
	By bankWireLocator = By.className("bankwire");
	By confirmOrderLocator = By.cssSelector("button[class='button btn btn-default button-medium']");
	By orderConfirmationLocator = By.id("center_column");
	By siginLocator = By.linkText("Sign in");
	By emailLocator = By.id("email");
	By passwordLocator = By.id("passwd");
	By myAccountLocator = By.id("my-account");
	By submitLoginLocator = By.id("SubmitLogin");
	By processAddressLocator = By.name("processAddress");
	By processCarrierLocator = By.name("processCarrier");
	public StorePage(WebDriver webDriver) {
		super(webDriver);
		
		// TODO Auto-generated constructor stub
	}

	public Boolean addCart() throws InterruptedException{
		click(menuLocator);
		Thread.sleep(2000);
		if(getTitle().equals(VariablesUtil.titleWomenStore)){
			click(selectProductLocator);
			Thread.sleep(2000);
			clear(findElement(quantityPlusLocator));
			type("2",quantityPlusLocator);
			click(colorLocator);
			selectOption(sizeLocator,"M");
			click(submitCart);
			Thread.sleep(2000);
			if(isDisplayed(checkoutLocator)){
				return true;
			}
		} else{
			System.out.println("No se pudo cargar la tienda");
		}
		return false;
	}
	
	public Boolean checkoutCartLogin(WebDriver webDriver) throws InterruptedException{
		LoginPage loginPage = new LoginPage(webDriver);
		click(checkoutLocator);
		Thread.sleep(2000);
		if(isDisplayed(proceedCheckOutLocator)){
			click(proceedCheckOutLocator);
			Thread.sleep(2000);
			click(proceedCheckOutLocator);
			if(loginPage.loginUser(true)){
				Thread.sleep(2000);
				if(isDisplayed(addressLocator)){
					click(processAddressLocator);
					Thread.sleep(2000);
					if(isDisplayed(shipingAreaLocator)){
						click(aceptTerms);
						click(processCarrierLocator);
						Thread.sleep(2000);
						if(isDisplayed(paymentBlockLocator)){
							click(bankWireLocator);
							Thread.sleep(2000);
							Thread.sleep(2000);
							if(isDisplayed(confirmOrderLocator)){
								click(confirmOrderLocator);
								
							}
						
							Thread.sleep(2000);
							if(isDisplayed(orderConfirmationLocator)){
								return true;
							}
						}
					}
				}
				
			}
			
		}
		return false;
	}
	
	
	public Boolean checkoutCartRegister(WebDriver webDriver) throws InterruptedException{
		RegisterPage registerPage = new RegisterPage(webDriver);
		click(checkoutLocator);
		Thread.sleep(2000);
		if(isDisplayed(proceedCheckOutLocator)){
			click(proceedCheckOutLocator);
			Thread.sleep(2000);
			click(proceedCheckOutLocator);
			if(registerPage.registerUser(true)){
				Thread.sleep(2000);
				if(isDisplayed(addressLocator)){
					click(processAddressLocator);
					Thread.sleep(2000);
					if(isDisplayed(shipingAreaLocator)){
						click(aceptTerms);
						click(processCarrierLocator);
						Thread.sleep(2000);
						if(isDisplayed(paymentBlockLocator)){
							click(bankWireLocator);
							Thread.sleep(2000);
							Thread.sleep(2000);
							if(isDisplayed(confirmOrderLocator)){
								click(confirmOrderLocator);
								
							}
						
							Thread.sleep(2000);
							if(isDisplayed(orderConfirmationLocator)){
								return true;
							}
						}
					}
				}
				
			}
			
		}
		return false;
	}
	
	
}
