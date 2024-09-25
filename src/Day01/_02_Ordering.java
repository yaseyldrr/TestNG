package Day01;

import org.testng.annotations.Test;

public class _02_Ordering {
    @Test(priority = 1) // öncelik ayarı yapılmazsa alfabetik çalışır
    public void DriverStarted() { System.out.println("Test-1 is created.");
    }
    @Test(priority = 2) // priority verilmezse default 0'dır
    public void NavigateWebsite() { System.out.println("Navigate to the website.");
    }
    @Test(priority = 3)
    public void LoginTest() { System.out.println("Execute the login test.");
    }
    @Test(priority = 4)
    public void BasketTest() { System.out.println("Execute the basket test.");
    }
    @Test(priority = 5)
    public void TearDown() { System.out.println("Close the driver.");
    }
}
