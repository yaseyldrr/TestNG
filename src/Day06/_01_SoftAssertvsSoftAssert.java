package Day06;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class _01_SoftAssertvsSoftAssert {
    @Test
    public void HardAssert() {
        String s1 = "Hello";
        Assert.assertEquals("Hello", s1, "Occured and the expected are not same");
    }
    @Test
    public void SoftAssert() {
        String strHomePage = "www.facebook.com/homepage";
        String strCartPage = "www.facebook.com/cartpage";
        String strEditAccount = "www.facebook.com/editaccountpage";

        SoftAssert _softAssert = new SoftAssert();
        _softAssert.assertEquals("www.facebook.com/homepage",strHomePage);
        _softAssert.assertEquals("www.facebook.com/profile",strCartPage); // has fail
        _softAssert.assertEquals("www.facebook.com/settings",strEditAccount); // has fail

        // hataları işleme koy
        _softAssert.assertAll(); // softtan harda geç

        System.out.println("soft AssertAll() sonrası ");
    }
}
