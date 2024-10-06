package Day07;

import Utility.BaseDriverGeneral;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class _01_Elements {

    public _01_Elements() {
        PageFactory.initElements(BaseDriverGeneral.driver,this);
    }

    @FindBy(xpath = "//span[text()='Add to Cart']")
    public List<WebElement> productListAddCart;

    @FindBy(css = "[class='caption'] >h4")
    public List<WebElement> productListCaption;

    @FindBy(xpath = "//table[@class='table table-bordered']//td[@class='text-left']/a")
    public List<WebElement> productListBasket;

    @FindBy(xpath = "//button[@data-original-title='Add to Wish List']/i")
    public List<WebElement> productListAddWish;

    @FindBy(linkText = "wish list")
    public WebElement wishList;

    @FindBy(css = "[class='table table-bordered table-hover'] td[class='text-left']>a")
    public List<WebElement> productListWish;


}
