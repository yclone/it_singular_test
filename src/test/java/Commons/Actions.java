package Commons;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Actions extends JSWaiter {

	WebDriver driver;
	public static WebDriverWait wait;

	public Actions(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 30);
		setDriver(driver);
		waitForLoadPage();
	}
	
	public Actions digitar(WebElement item, String value) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(item));
			driver.switchTo().defaultContent();
			item.clear();
			item.sendKeys(value);
			item.sendKeys(Keys.TAB);
		} catch (NullPointerException e) {
			System.err.println(e);
		}
		return new Actions(driver);
	}
	
	
	public boolean validaResp(WebElement results, String resp) {
		driver.switchTo().defaultContent();
		wait.until(ExpectedConditions.visibilityOf(results));
		boolean textoColetado = results.getText().equals(resp);
		return textoColetado;
	}

	public Actions clicar(WebElement item) {
		wait.until(ExpectedConditions.elementToBeClickable(item));
		driver.switchTo().defaultContent();
		item.click();
		return new Actions(driver);
	}

}
