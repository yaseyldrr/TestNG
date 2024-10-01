package Day05;

import Utility.BaseDriverParameter;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Bir önceki taskı PARAMETERDRIVER ile yapınız
 * sonrasında farklı tarayıcılar ile çalıştırınız. (crossbrowser)
 * sonrasında paralel çalıştırınız.(parallel)
 */

public class _04_Question_2 extends BaseDriverParameter {

    @Test(dataProvider = "getData")
    public void SearchFunction(String text)
    {
        WebElement searchInput=driver.findElement(By.name("search"));
        searchInput.clear();
        searchInput.sendKeys(text+ Keys.ENTER);

        List<WebElement> captions=driver.findElements(By.cssSelector("[class='caption']>h4"));

        for(WebElement e : captions)
            Assert.assertTrue(e.getText().toLowerCase().contains(text.toLowerCase()),
                    "Not found");
    }


    @DataProvider
    Object[] getData()
    {
        Object[] data={"mac","ipod","samsung"};
        return  data;
    }
}
