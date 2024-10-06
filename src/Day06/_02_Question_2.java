package Day06;

import Utility.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _02_Question_2 extends BaseDriver {
    @Test
    public void _02_Question() {
        searchForProduct("ipod");
        addItemToCart();
        proceedToCheckout();
        fillCheckoutDetails();
        confirmOrder();
    }

    private void searchForProduct(String productName) {
        WebElement searchBox = driver.findElement(By.xpath("//*[@id='search']/input"));
        searchBox.sendKeys(productName + Keys.ENTER);
        wait.until(ExpectedConditions.urlContains("search=" + productName));
    }

    private void addItemToCart() {
        WebElement product = driver.findElement(By.cssSelector("button[onclick*='cart.add']")); // Assuming product add to cart has unique onclick handler
        product.click();

        WebElement cart = driver.findElement(By.xpath("//*[@id='top-links']/ul/li[4]/a/span")); // Improved locator using id
        cart.click();
        wait.until(ExpectedConditions.urlContains("checkout/cart"));
    }

    private void proceedToCheckout() {
        WebElement checkout = driver.findElement(By.linkText("Checkout")); // Assuming checkout link has "Checkout" as visible text
        checkout.click();
        wait.until(ExpectedConditions.urlContains("checkout/checkout"));
    }

    private void fillCheckoutDetails() {
        clickButtonById("button-payment-address");
        clickButtonById("button-shipping-address");
        clickButtonById("button-shipping-method");

        WebElement checkBox = driver.findElement(By.xpath("//*[@id='collapse-payment-method']/div/div[3]/div/input[1]"));
        checkBox.click();
        clickButtonById("button-payment-method");
    }

    private void clickButtonById(String buttonId) {
        WebElement button = driver.findElement(By.id(buttonId));
        button.click();
        //wait.until(ExpectedConditions.elementToBeClickable(button)); // Optional: wait for the button to become clickable
    }

    private void confirmOrder() {
        wait.until(ExpectedConditions.elementToBeClickable(By.id("button-confirm")));
        WebElement confirmOrder = driver.findElement(By.id("button-confirm"));
        confirmOrder.click();

        WebElement message = driver.findElement(By.xpath("//div[@id='content']/h1"));
        Assert.assertEquals(message.getText(), "Your order has been placed!","Doesn't match");
    }
}
