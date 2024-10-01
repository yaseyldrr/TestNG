package Day05;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class _02_DataProvider {

    @Test(dataProvider="datalarim")
    public void UserNameTest(String userName)
    {
        System.out.println(userName);
    }

    @DataProvider
    Object[] datalarim(){
        Object[] userlar={"Ummuhan","Sefa","Merve","Halil"};

        return userlar;
    }

    @Test(dataProvider="datalarim2")
    public void UserIdler(int userId)
    {
        System.out.println(userId);
    }

    @DataProvider
    Object[] datalarim2(){
        Object[] userlar={1001,1002,1003,1003};

        return userlar;
    }


}

//Object Tip nedir ?
//
//int sayi=5;
//String ad="ismet";
//
//Object genelTip=5;
//Object genelTip="Mehmet";