package testng.firstClass;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCases {

    @Test
    public void firstTestClass1() {
        String name = "hello";

        if (name.contains("hello1")) {

            System.out.println("pass");
        } else {
            System.out.println("fail");
        }

        System.out.println("Welcome Test Case");
    }

    @Test(enabled = false)
    public void firstTestClass2() {
        String name = "hello";
        Assert.assertEquals(name, "hello1");
        System.out.println("Welcome Test Case");
    }
}
