package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartObjects {
	private static WebDriver driver = null;
	private static By product_select = null;
	private static WebElement element = null;
	private static WebDriverWait w= null;
	By cart_click = By.cssSelector("img[alt='Cart']");
	By checkout_click = By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]");
	By promocode_enter = By.cssSelector("input.promoCode");
	By applyPromo_click = By.cssSelector("button.promoBtn");
	By promoApply_check = By.cssSelector("span.promoInfo");
	
	public CartObjects(WebDriver driver) {
		this.driver = driver;
		
	}
	public void findItem(String[] itemsNeeded) {
		for (String itemToAdd: itemsNeeded) {
		product_select = By.xpath("//*[contains(text(),'"+itemToAdd+"')]/ancestor::div[@class='product']");
		element =driver.findElement(product_select);
		element.findElement(By.xpath(".//div[@class='product-action']/button")).click();
		
		}
	}
	
	public void checkout() {
		w= new WebDriverWait(driver, 5);
		driver.findElement(cart_click).click();
		driver.findElement(checkout_click).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));
		driver.findElement(promocode_enter).sendKeys("rahulshettyacademy");
		driver.findElement(applyPromo_click).click();
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
		System.out.println(driver.findElement(promoApply_check).getText());
	}
}
