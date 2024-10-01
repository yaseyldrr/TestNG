package Day05;

/*
  Senaryo;
  1- https://www.ebay.com/n/all-brands  menusune gidiniz.
  2- Burada her bir markanın üstünde yer alan harf ile başladığını doğrulayınız
*/

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.List;

public class _07_Question {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://www.ebay.com/n/all-brands");
    }

    @DataProvider(name = "brandData")
    public Object[][] dataProviderMethod() {
        // Returning an array of letters and their corresponding expected brand indices
        return new Object[][] {
                { "A", 0 },
                { "B", 10 }, // Adjust the index to match your brand positioning
                { "C", 20 }
        };
    }

    @Test(dataProvider = "brandData")
    public void verifyBrandsStartWithLetter(String letter, int brandIndex) {
        // Locate all brands under the corresponding letter
        List<WebElement> brands = driver.findElements(By.xpath("//div[@class='all-brands-col']/a"));

        // Check if the brand starts with the expected letter
        String actualBrand = brands.get(brandIndex).getText();
        Assert.assertTrue(actualBrand.startsWith(letter), "Brand verification failed for: " + actualBrand);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}

