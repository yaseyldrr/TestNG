package Day01;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class _03_Annotations {
    @Test
    public void Test1() { System.out.println("Test1 is executed.");
    }
    @Test
    public void Test2() { System.out.println("Test2 is executed.");
    }
    @BeforeClass // Class ın içindekiler çalışmadan önce çalışır
    public void BeforeClass() {
        System.out.println("BeforeClass is executed.");
    }
    @AfterClass
    public void AfterClass() { // Class ın içindekiler çalıştıktan sonra çalışır
        System.out.println("AfterClass is executed.");
    }


}
