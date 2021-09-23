package commonFunctions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import runner.*;

public class CommonUIFunctions {

	static JavascriptExecutor js = (JavascriptExecutor) TestRunner.driver;
	static Actions action = new Actions(TestRunner.driver);
	
	public static void implicitWait(int time) {
		TestRunner.driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}

	public static void explicitWait(WebElement element) {
		WebDriverWait wait = new WebDriverWait(TestRunner.driver, 3000);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	// To wait for element visible by xpath
	public static void waitWithXpath(String xpath) {
		try {
			WebDriverWait wait = new WebDriverWait(TestRunner.driver, 30);
			wait.until(ExpectedConditions.or(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))));
			System.out.println("Element is visible now : " + xpath);
		} catch (Exception e) {
			System.out.println("Element is not visible : " + xpath);
		}
	}

	// To wait for element visible by id
	public static void waitWithid(String id) {
		try {
			WebDriverWait wait = new WebDriverWait(TestRunner.driver, 30);
			wait.until(ExpectedConditions.or(ExpectedConditions.visibilityOfElementLocated(By.id(id))));
			System.out.println("Element is visible now : " + id);
		} catch (Exception e) {
			System.out.println("Element is not visible : " + id);
		}
	}

	// Count number of elements by xpath
	public static int countNumber(String xpath) {
		int count = TestRunner.driver.findElements(By.xpath(xpath)).size();
		return count;
	}
	
	//Scroll to element until visible
	public static void scrollToElementByXpath(String xpath) {
        // Scrolling down the page till the element is found		
        js.executeScript("arguments[0].scrollIntoView();", TestRunner.driver.findElement(By.xpath(xpath)));
	}
	
	//Scroll up by 1 inch 96 pixels
		public static void scrollUpOneinch() {
			// Scrolling up the page by 96 px		
			js.executeScript("window.scrollBy(0,-96)", "");
		}
		
	//Scroll down by 1 inch 96 pixels
		public static void scrollDownOneinch() {
			// Scrolling down the page by 96 px	
			js.executeScript("window.scrollBy(0,96)", "");
		}
		
	//Press control + enter key
		public static void pressCtrEnter() {
			action.keyDown(Keys.CONTROL).keyDown(Keys.ENTER).keyUp(Keys.CONTROL).keyUp(Keys.ENTER).perform();
		}
		
	//Press enter key
		public static void pressEnterKey() {
			action.sendKeys((Keys.chord(Keys.ENTER))).perform();
		}
		
	//Press down key
		public static void pressDownKey() {
			action.sendKeys((Keys.chord(Keys.DOWN))).perform();
		}	
	
	//move to element 
		public static void moveToElementByXpath(String xpath) {

			//Hovering on main menu
			action.moveToElement(TestRunner.driver.findElement(By.xpath(xpath)));
		}
		
	//move to element and click with xpath
		public static void moveToElementAndClickByXpath(String xpath) {

			//Hovering on main menu
			action.moveToElement(TestRunner.driver.findElement(By.xpath(xpath)));

			//build()- used to compile all the actions into a single step 
			action.click().build().perform();
		}
		
	// select function
		public static void selectAndClick(String xpath, int index) {
			Select drpDate = new Select(TestRunner.driver.findElement(By.xpath(xpath)));
			drpDate.selectByIndex(index);
		}
		
	// select function
		public static void refreshPage() {
			TestRunner.driver.navigate().refresh();
		}	
		
	// accept alert
		public static void acceptAlert() {
			TestRunner.driver.switchTo().alert().accept();

		}
}
