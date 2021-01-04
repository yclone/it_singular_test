package runnerFiles;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


public class DriverFactory {

	DesiredCapabilities capability;
	static String resp = "";
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	static String gridAddress = "localhost:4444";

	public static WebDriver getDriver() {
		return driver.get();
	}

	public static void closeDriver() {
		driver.get().quit();
		driver.remove();
	}

	public static void setDriver(int i) {
		RemoteWebDriver rd = null;
		switch (i) {
		case 1:
			FirefoxOptions optionsF = new FirefoxOptions();
			DesiredCapabilities capabilitiesF = new DesiredCapabilities();
			optionsF.addArguments("--start-maximized");
//			optionsF.addArguments("--headless");
			optionsF.setCapability("marionette", true);
			capabilitiesF.setBrowserName("firefox");
			capabilitiesF.setCapability("enableVNC", true);
			capabilitiesF.setCapability("enableVideo", false);
			capabilitiesF.setCapability(FirefoxOptions.FIREFOX_OPTIONS, optionsF);
			try {
				rd = new RemoteWebDriver(new URL("http://" + gridAddress + "/wd/hub"), capabilitiesF);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
			driver.set(rd);
			break;
		case 2:
			DesiredCapabilities capabilitiesC = new DesiredCapabilities();
			ChromeOptions optionsC = new ChromeOptions();
//			 optionsC.addArguments("--headless");
			optionsC.addArguments("--start-maximized");
			optionsC.addArguments("use-fake-ui-for-media-stream");
			capabilitiesC.setCapability("enableVNC", true);
			capabilitiesC.setCapability("enableVideo", false);
			capabilitiesC.setCapability(ChromeOptions.CAPABILITY, optionsC);
			try {
				rd = new RemoteWebDriver(new URL("http://" + gridAddress + "/wd/hub"), capabilitiesC);
//				RemoteWebDriver driver = new RemoteWebDriver(
//					    URI.create("http://" + gridAddress + "/wd/hub").toURL(), 
//					    capabilities
//					);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
			driver.set(rd);
			break;
		default:
			break;
		}
	}
}
