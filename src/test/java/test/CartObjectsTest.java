package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.CartObjects;

public class CartObjectsTest {
	private static WebDriver driver = null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		setUp();
		findItemTest();
		tearDown();

	}
	public static void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
	//	driver.manage().window().maximize();
	}

	public static void findItemTest() {
		CartObjects cartObj = new CartObjects(driver);
		cartObj.findItem();
	}
	public static void tearDown() {
		driver.close();
		driver.quit();
	}

}
