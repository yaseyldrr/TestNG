package Day07;


/*
    Senaryo ;
    1- Siteye gidiniz..

   1.Test;
   2- "ipod" ürününü aratınız."ipod" u xml den gönderiniz
   3- çıkan elamnlardan random bir elelamnı Add Wish butonuna tıklayınız.
   4- Daha sonra WishList e tıklatınız
   5- Burada çıkan ürünle tıklanan ürünün isminin aynı olup olmadığını doğrulayınız.
 */


import Day06._03_PlaceOrderElements;
import Utility.BaseDriver;
import Utility.Tools;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class _02_Question extends BaseDriver {

    @Test
    @Parameters("searchText")
    public void addToWishList(String productToSearch) {
        _03_PlaceOrderElements poe = new _03_PlaceOrderElements();
        _01_Elements sre = new _01_Elements();

        poe.searchInput.sendKeys(productToSearch + Keys.ENTER);

        int randomSelect= Tools.randomGenerator(sre.productListCaption.size());

        String productToClick=sre.productListCaption.get(randomSelect).getText();
        sre.productListAddWish.get(randomSelect).click();

        sre.wishList.click();

        boolean productFound = Tools.listContainsString(sre.productListWish, productToClick);
        Assert.assertTrue(productFound, "The chosen product was not found in Wishlist.");
    }


}













