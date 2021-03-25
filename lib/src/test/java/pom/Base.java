package pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
	private WebDriver webDriver;
	
	public Base(WebDriver webDriver){
		this.webDriver = webDriver;
	}
	
	public static WebDriver setUp(String url) throws InterruptedException{
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		return driver;
	}
	
	public WebElement findElement(By locator){
		return webDriver.findElement(locator);		
	}
	
	public List<WebElement> findElements(By locator){
		return webDriver.findElements(locator);
	}

	public String getText(WebElement webElement){
		return webElement.getText();
	}
	
	public String getText(By locator){
		return webDriver.findElement(locator).getText();
	}
	
	public void type(String inputText,By locator){
		webDriver.findElement(locator).sendKeys(inputText);
	}
	
	public void click(By locator){
		webDriver.findElement(locator).click();
	}
	
	public void click(WebElement webElement){
		webElement.click();
	}
	
	public Boolean isDisplayed(By locator){
		try{
			return webDriver.findElement(locator).isDisplayed();
		}catch (org.openqa.selenium.NoSuchElementException e ){
			return false;
		}
		
	}
	
	public void visit(String url){
		webDriver.get(url);
	}
	
	public void submit(By locator){
		webDriver.findElement(locator).submit();
		
	}
	
	public void selectOption(By locator,String option){
		WebElement listDays = findElement(locator);
		List<WebElement> optionsDays = listDays.findElements(By.tagName("option"));
		for(int i = 0; i < optionsDays.size();i++){
			if(getText(optionsDays.get(i)).equals(option)){
				click(optionsDays.get(i));
			}
		}
	}
	
	public void clear(WebElement webElement){
		webElement.clear();
	}
	
	public void selectMenu(String nameMenu){
		
	}
	
	public String getTitle(){
		return webDriver.getTitle();
	}
}
