

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

public class EBayHome
{
  private WebDriver driver;

  @BeforeClass(alwaysRun = true)
  public void setUp()
  {
    driver = new FirefoxDriver();
    //driver.manage().window().maximize();
    driver.manage().window().fullscreen();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testEBayHome()
  {
    launch_ToTheSite();

    click_signInButton();

    fill_userIdField();

    fill_passwordField();

    click_signInFormButton();

    fill_SearchKeyField();

    chooseCellPhoneInCategoryMenu();

    clickOnSpecificButtons();

  }

  private void launch_ToTheSite()
  {
    driver.get("https://www.ebay.com/");
  }

  private void click_signInButton()
  {
    driver.findElement(By.linkText("Sign in")).click();
  }

  private void fill_userIdField()
  {
    driver.findElement(By.id("userid")).click();
    driver.findElement(By.id("userid")).clear();
    driver.findElement(By.id("userid")).sendKeys("iyukhnovetsky@gmail.com");
  }

  private void fill_passwordField()
  {
    driver.findElement(By.id("pass")).click();
    driver.findElement(By.id("pass")).clear();
    driver.findElement(By.id("pass")).sendKeys("iy3161");
  }

  private void click_signInFormButton()
  {
    driver.findElement(By.id("sgnBt")).click();
  }

  private void fill_SearchKeyField()
  {
    driver.findElement(By.id("gh-ac")).clear();
    driver.findElement(By.id("gh-ac")).sendKeys("huawei");
    driver.findElement(By.id("gh-cat")).click();
  }

  private void chooseCellPhoneInCategoryMenu()
  {
    new Select(driver.findElement(By.id("gh-cat"))).selectByVisibleText("Cell Phones & Accessories");
    driver.findElement(By.id("gh-cat")).click();
  }

  private void clickOnSpecificButtons()
  {
    driver.findElement(By.id("gh-btn")).click();
    driver.findElement(By.xpath("//div[@id='srp-river-results-query_answer1-w0-x-carousel-items']/ul/li[3]/div/a/div")).click();
    driver.findElement(By.xpath("//div[@id='srp-river-results-query_answer1-w0-x-carousel-items']/ul/li[3]/div/a/div")).click();
  }

  @AfterClass(alwaysRun = true)
  public void tearDown()
  {
    try
    {
      Thread.sleep(1000);
    }
    catch (InterruptedException e)
    {
      e.printStackTrace();
    }
    driver.quit();
  }

  private boolean isElementPresent(By by)
  {
    try
    {
      driver.findElement(by);
      return true;
    }
    catch (NoSuchElementException e)
    {
      return false;
    }
  }


}
