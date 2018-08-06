package home.addressbook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactHelper extends HelperBase
{
    public ContactHelper(WebDriver driver) {
        super(driver);
    }

    public void createNewContact() {
        click(By.xpath("//a[contains(text(),'ADD_NEW')]"));
    }

    public void fillContactForm(ContactData contact) {
        type(By.name("firstname"), contact.getFirstName());
        type(By.name("lastname"), contact.getLastName());
        type(By.name("nickname"), contact.getNickname());
        type(By.name("address"), contact.getAddress());
        type(By.xpath("//input[@name='mobile']"), contact.getCellPhone());
        type(By.xpath("//input[@name='email']"), contact.getEmail());
    }

    public void submitContactCreation() {
        click(By.name("submit"));
    }

    public void selectContact() {
        click(By.name("selected[]"));
    }

    public void selectContactByIndex(int index) {
        driver.findElements(By.name("selected[]")).get(index).click();
    }

    public void initContactModification()
    {
        click(By.xpath("//img[@title='EDIT']"));
    }

    public void submitContactModification()
    {
        click(By.xpath("//input[@type='submit'][@name='update']"));
    }



    public boolean isElementsPresent(By locator)
    {
        return driver.findElements(locator).size()>0;
    }

    public boolean isContactPresent()
    {
        return isElementsPresent(By.name("selected[]"));
    }

    public void createContact()
    {
        createNewContact();
        fillContactForm(new ContactData()
                .setFirstName("default name")
                .setLastName("default lastname")
                .setNickname("default nick")
                .setAddress("default address")
                .setCellPhone("default cellphone")
                .setEmail("default email"));
        submitContactCreation();
    }

    public int getContactSize()
    {
        return driver.findElements(By.xpath("//*[@name='selected[]']")).size();
    }

    public void submitContactDeletion()
    {
        click(By.xpath("//*[@value='DELETE']"));
    }

    public void comfirmDeletion()
    {
        driver.switchTo().alert().accept();
    }

    public void dismissDeletion()
    {
        driver.switchTo().alert().dismiss();
    }

    public void selectAllcontacts()
    {
        click(By.cssSelector("#MassCB"));
    }



}
