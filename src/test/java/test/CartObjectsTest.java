package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.CartObjects;

public class CartObjectsTest {
	private static WebDriver driver = null;
	private static String[] itemsNeeded = {"Cucumber", "Brocolli", "Beetroot"};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		setUp();
		findItemTest();
		checkoutTest();
		//tearDown();

	}
	public static void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		//	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.manage().window().maximize();
	}

	public static void findItemTest() {
		CartObjects cartObj = new CartObjects(driver);
		cartObj.findItem(itemsNeeded);
	}

	public static void checkoutTest() {
		CartObjects cartObj = new CartObjects(driver);
		cartObj.checkout();
	}
	public static void tearDown() {
		driver.close();
		driver.quit();
	}

}
