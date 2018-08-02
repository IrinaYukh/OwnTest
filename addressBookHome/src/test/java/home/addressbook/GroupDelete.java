package home.addressbook;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupDelete extends Stock
{

    @Test
    public void deletionGroupTest()
    {
        goToGroupPage();
        if (!app.getGroupHelper().isGroupPresent())
        {
            app.getGroupHelper().createGroup();
        }
        int before = app.getGroupHelper().getGroupSize();
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().initGroupDeletion();
        app.getGroupHelper().returnToGroupPage();
        int after = app.getGroupHelper().getGroupSize();

        Assert.assertEquals(after, before-1);
    }

    @Test
    public void deletionGroupByIndexTest()
    {
        goToGroupPage();
        if (!app.getGroupHelper().isGroupPresent())
        {
            app.getGroupHelper().createGroup();
        }
        int before = app.getGroupHelper().getGroupSize();
        app.getGroupHelper().selectGroupByIndex(before-1);
        app.getGroupHelper().initGroupDeletion();
        app.getGroupHelper().returnToGroupPage();
        int after = app.getGroupHelper().getGroupSize();

        Assert.assertEquals(after, before-1);
    }



}
