package Utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class Tools {
    public static void Wait(int sn) {
        try {
            Thread.sleep(sn * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public static void SuccessMessageValidation() {
        WebElement success= BaseDriver.driver.findElement(By.xpath("//*[@id='account-account']/div[1]"));
        Assert.assertTrue(success.getText().contains("Success"), "Error 404");
    }

    public static int randomGenerator(int range){
        return (int)(Math.random()*range);
    }

    public static boolean listContainsString(List<WebElement> list, String searchWord ){
        boolean productFound=false;
        for(WebElement product : list)
        {
            if (product.getText().equals(searchWord)) {
                productFound = true;
                break;
            }
        }
        return  productFound;
    }
}
