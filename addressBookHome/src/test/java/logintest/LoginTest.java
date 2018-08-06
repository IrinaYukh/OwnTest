package logintest;

import home.addressbook.Stock;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest extends Stock {

    @BeforeTest
    public void precondition()
    {
        app.getSessionHelper().logout();
    }

    @Test
    public void loginPositiveTest()
    {
        app.getSessionHelper().login("admin","secret");

        Assert.assertTrue(app.getGroupHelper().isElementPresent(By.xpath("//a[contains(text(),'LOGOUT')]")));
    }

    @Test
    public void loginNegativeTest1()
    {
        app.getSessionHelper().login("admin","pups");

        Assert.assertFalse(app.getGroupHelper().isElementPresent(By.xpath("//a[contains(text(),'LOGOUT')]")));
    }

    @Test
    public void loginNegativeTest2()
    {
        app.getSessionHelper().login("","pups");

        Assert.assertFalse(app.getGroupHelper().isElementPresent(By.xpath("//a[contains(text(),'LOGOUT')]")));
    }
}
