package Day06;

import Utility.BaseDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _04_Question_3 extends BaseDriver {
@Test
    public void ProceedToCheckout(){
        _03_PlaceOrderElements elements=new _03_PlaceOrderElements();

        elements.searchInput.sendKeys("ipod" + Keys.ENTER);
        elements.addToChart.click();
        elements.shoppingChart.click();
        elements.checkOut.click();

        wait.until(ExpectedConditions.elementToBeClickable(elements.continue1)).click();
        wait.until(ExpectedConditions.elementToBeClickable(elements.continue2)).click();
        wait.until(ExpectedConditions.elementToBeClickable(elements.continue3)).click();

        elements.agree.click();
        wait.until(ExpectedConditions.elementToBeClickable(elements.continue4)).click();
        elements.confirm.click();

        wait.until(ExpectedConditions.urlContains("success"));
        Assert.assertEquals(elements.ekranYazi.getText(), "Your order has been placed!", "Oluşan Mesajlar Eşleşmiyor");

    }
}
