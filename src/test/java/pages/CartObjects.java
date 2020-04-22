package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartObjects {
	private static WebDriver driver = null;
	By allproducts_select = By.cssSelector("h4.product-name");
	By product_select = By.xpath("//*[contains(text(),'Cucumber')]/ancestor::div[@class='product']");
	
	public CartObjects(WebDriver driver) {
		this.driver = driver;
	}
	public void findItem() {
		WebElement element =driver.findElement(product_select);
		element.findElement(By.xpath(".//div[@class='product-action']/button")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
