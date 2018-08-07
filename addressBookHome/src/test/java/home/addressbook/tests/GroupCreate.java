package home.addressbook.tests;

import home.addressbook.data.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupCreate extends Stock
{
    @Test
    public void groupCreationTest1()
    {
        app.getGroupHelper().goToGroupsPage();

        int before = app.getGroupHelper().getGroupSize();
        app.getGroupHelper().initGroupCreation();
        app.getGroupHelper().fillGroupForm(new GroupData().setName("group1").setHeader("header1").setComment("comment1"));
        app.getGroupHelper().submitGroupCreation();
        app.getGroupHelper().returnToGroupPage();
        int after = app.getGroupHelper().getGroupSize();

        Assert.assertEquals(after,before+1);
    }

    @Test
    public void groupCreationTestLongName()
    {
        app.getGroupHelper().goToGroupsPage();

        int before = app.getGroupHelper().getGroupSize();
        app.getGroupHelper().initGroupCreation();
        app.getGroupHelper().fillGroupForm(new GroupData().setName("LoooooooooooooooooooooooooooooooooooongNaaaaaaaaaaaaaaaame")
                .setHeader("headerForLongName").setComment("comment"));
        app.getGroupHelper().submitGroupCreation();
        app.getGroupHelper().returnToGroupPage();
        int after = app.getGroupHelper().getGroupSize();

        Assert.assertEquals(after, before+1);
    }

    @Test
    public void groupCreationTestEmptyName()
    {
        app.getGroupHelper().goToGroupsPage();

        int before = app.getGroupHelper().getGroupSize();
        app.getGroupHelper().initGroupCreation();
        app.getGroupHelper().fillGroupForm(new GroupData().setName("")
                .setHeader("").setComment(""));
        app.getGroupHelper().submitGroupCreation();
        app.getGroupHelper().returnToGroupPage();
        int after = app.getGroupHelper().getGroupSize();

        Assert.assertEquals(after, before+1);
    }
}
