package Day01;

import org.testng.annotations.Test;

public class _01_Introduction {
    @Test
    public void DriverStarted() { System.out.println("Test-1 is created.");
    }
    @Test
    public void NavigateWebsite() { System.out.println("Navigate to the website.");
    }
    @Test
    public void LoginTest() { System.out.println("Execute the login test.");
    }
    @Test
    public void BasketTest() { System.out.println("Execute the basket test.");
    }
    @Test
    public void TearDown() { System.out.println("Close the driver.");
    }
}
