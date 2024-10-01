package Day05;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class _03_DataProvider_MultipleDimension {

    @Test(dataProvider = "UserData")
    void UserNamePasswordTest(String userName, String password)
    {
        System.out.println(userName+" "+password);
    }

    @DataProvider
    Object[][] UserData()
    {
        Object[][] userPass={
                {"Merve","123457a"},
                {"Ümmet","12dd7a"},
                {"Betül","1vvv57a"},
                {"Halil","1xxx7a"},
        };

        return userPass;
    }



}
