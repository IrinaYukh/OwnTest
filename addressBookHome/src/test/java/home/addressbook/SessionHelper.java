package home.addressbook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends HelperBase{


    public SessionHelper(WebDriver driver) {
        super(driver);
    }

    public void url(String siteURL) {
        driver.navigate().to(siteURL);
    }

    public void login(String userName, String password)
    {
        type(By.name("user"), userName);
        type(By.name("pass"), password);
        loginSubmit();
    }

    public void loginSubmit() {
        click(By.xpath("//*[@value='LOGIN']"));
    }

    public void logout()
    {
        click(By.xpath("//a[contains(text(),'LOGOUT')]"));
    }



}
