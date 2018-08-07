package home.addressbook.tests;

import home.addressbook.data.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactCreate extends Stock {

    @Test
    public void createContactTest() {
        app.getContactHelper().isOnContactPage();

        int before = app.getContactHelper().getContactSize();
        app.getContactHelper().createNewContact();
        app.getContactHelper().fillContactForm(new ContactData()
                .setFirstName("Look")
                .setLastName("Freeman")
                .setNickname("lucky")
                .setAddress("NYC, 56 West Street, apt.1605")
                .setCellPhone("1-617-856-2215")
                .setEmail("freeman007@aol.com"));
        app.getContactHelper().submitContactCreation();
        int after = app.getContactHelper().getContactSize();

        Assert.assertEquals(after, before + 1);

    }

    @Test
    public void createContactTestWithoutData()
    {
        app.getContactHelper().isOnContactPage();

        int before = app.getContactHelper().getContactSize();
        app.getContactHelper().createNewContact();
        app.getContactHelper().fillContactForm(new ContactData()
                .setFirstName("")
                .setLastName("")
                .setNickname("")
                .setAddress("")
                .setCellPhone("")
                .setEmail(""));
        app.getContactHelper().submitContactCreation();
        int after = app.getContactHelper().getContactSize();

        Assert.assertEquals(after, before + 1);
    }
}

