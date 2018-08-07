package home.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactDelete extends Stock
{
    @Test
    public void deleteContactTest()
    {
        if (! app.getContactHelper().isContactPresent())
        {
            app.getContactHelper().createContact();
        }
        int before = app.getContactHelper().getContactSize();
        app.getContactHelper().selectContact();
        app.getContactHelper().submitContactDeletion();
        app.getContactHelper().comfirmDeletion();
        int after = app.getContactHelper().getContactSize();

        Assert.assertEquals(after, before-1);
    }

    @Test
    public void deleteAllContactsTest()
    {
        if (! app.getContactHelper().isContactPresent())
        {
            app.getContactHelper().createContact();
        }
        app.getContactHelper().selectAllContacts();
        app.getContactHelper().submitContactDeletion();
        app.getContactHelper().comfirmDeletion();

    }

    @Test
    public void deleteContactByIndexTest()
    {
        if (! app.getContactHelper().isContactPresent())
        {
            app.getContactHelper().createContact();
        }
        int before = app.getContactHelper().getContactSize();
        app.getContactHelper().selectContactByIndex(before-1);
        app.getContactHelper().submitContactDeletion();
        app.getContactHelper().comfirmDeletion();
        int after = app.getContactHelper().getContactSize();

        Assert.assertEquals(after, before-1);
    }
}
