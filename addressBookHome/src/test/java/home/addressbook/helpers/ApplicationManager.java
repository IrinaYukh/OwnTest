package home.addressbook.helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    SessionHelper sessionHelper;
    GroupHelper groupHelper;
    ContactHelper contactHelper;

    private WebDriver driver;


    public void start() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        sessionHelper = new SessionHelper(driver);
        sessionHelper.url("http://localhost/addressbook/");
        sessionHelper.login("admin", "secret");
        groupHelper = new GroupHelper(driver);
        contactHelper = new ContactHelper(driver);
    }

    public void stop() {
        driver.quit();
    }


    public GroupHelper getGroupHelper() {
        return groupHelper;
    }

    public SessionHelper getSessionHelper() {
        return sessionHelper;
    }

    public ContactHelper getContactHelper()
    {
        return contactHelper;
    }

}
