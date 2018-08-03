package home.addressbook;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactModify extends Stock {

    @Test
    public void contactModificationTest()
    {
        if (!app.getContactHelper().isContactPresent())
        {
            app.getContactHelper().createContact();
        }
        int before = app.getContactHelper().getContactSize();
        app.getContactHelper().selectContact();
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillContactForm(new ContactData()
                .setFirstName("modify name")
                .setLastName("modify lastname")
                .setNickname("modify nick")
                .setAddress("modify address")
                .setCellPhone("modify phone")
                .setEmail("modify email"));
        app.getContactHelper().submitContactModification();
        int after = app.getContactHelper().getContactSize();

        Assert.assertEquals(after,before);
    }

    @Test
    public void contactModificationByIndexTest()
    {
        if(!app.getContactHelper().isContactPresent())
        {
            app.getContactHelper().createContact();
        }
        int before = app.getContactHelper().getContactSize();
        app.getContactHelper().selectContactByIndex(before-1);
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillContactForm(new ContactData()
                .setFirstName("indexModify name")
                .setLastName("indexModify lastname")
                .setNickname("indexModify nick")
                .setAddress("indexModify address")
                .setCellPhone("indexModify cellPhone")
                .setEmail("indexModify email"));
        app.getContactHelper().submitContactModification();
        int after = app.getContactHelper().getContactSize();

        Assert.assertEquals(after,before);
    }
}
