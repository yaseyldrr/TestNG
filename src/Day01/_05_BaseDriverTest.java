package Day01;

import Utility.BaseDriver;
import Utility.Tools;
import org.testng.annotations.Test;

public class _05_BaseDriverTest extends BaseDriver {
    @Test
    public void Test1() {
        driver.get("https://www.google.com/");
        Tools.Wait(2);
    }
}
