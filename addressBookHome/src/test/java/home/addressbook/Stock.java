package home.addressbook;

import org.openqa.selenium.By;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class Stock {

    public static ApplicationManager app = new ApplicationManager();

    @BeforeSuite
    public void setUp() {
        app.start();
    }

    @AfterSuite
    public void tearDown() {
        app.stop();
    }

    public void goToGroupPage() {
        app.getGroupHelper().click(By.xpath("//a[contains(text(),'GROUPS')]"));
    }





}
