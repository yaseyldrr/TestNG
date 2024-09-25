package Day01;

import Utility.BaseDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _07_Assertions {
    @Test
    public void equals() {
        String s1 = "Hello World";
        String s2 = "Hello World";
        Assert.assertEquals(s1, s2, "Failed"); // Are actual and expected equal?
    }

    @Test
    public void notEquals() {
        String s1 = "Hello World";
        String s2 = "Hello World";
        Assert.assertNotEquals(s1, s2, "Same"); // I expect that the values are different.
    }
    @Test
    public void True() {
        String s1 = "Hello World";
        String s2 = "Hello World";
        Assert.assertTrue(s1.equals(s2), "Same"); // Values are different. (Expected and Actual)
    }
    @Test
    public void Null() {
        String s = null;
        Assert.assertNull(s,"Value isn't null");
    }
    @Test
    public void Fail() {
        int s1 = 56;
        if (s1 != 56)
            Assert.fail();
    }
     @Test
    public void False() {
        int s1 = 5;
        int s2 = 7;
        Assert.assertFalse(s1 == s2,"Not same");
    }
}
