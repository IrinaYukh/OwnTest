package home.addressbook;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupCreate extends Stock
{
    @Test
    public void groupCreationTest1()
    {
        goToGroupPage();
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
        goToGroupPage();
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
        goToGroupPage();
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
