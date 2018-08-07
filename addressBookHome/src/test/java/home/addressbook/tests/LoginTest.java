package home.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends Stock {

    @BeforeMethod
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

    @AfterMethod
    public void postCondition()
    {
        if (!app.getGroupHelper().isElementPresent(By.xpath("//a[contains(text(),'LOGOUT')]")))
        {
            app.getSessionHelper().login("admin", "secret");
        }
    }
}
