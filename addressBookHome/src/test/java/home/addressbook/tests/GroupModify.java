package home.addressbook.tests;

import home.addressbook.data.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupModify extends Stock
{
    @Test
    public void groupModificationTest(){
      app.getGroupHelper().goToGroupsPage();

      if (!app.getGroupHelper().isGroupPresent())
      {
          app.getGroupHelper().createGroup();
      }
      int before = app.getGroupHelper().getGroupSize();
      app.getGroupHelper().selectGroup();
      app.getGroupHelper().initGroupModification();
      app.getGroupHelper().fillGroupForm(new GroupData().setName("modifyName")
              .setHeader("modifyHeader")
              .setComment("modifyComment"));
      app.getGroupHelper().submitGroupModification();
      app.getGroupHelper().returnToGroupPage();
      int after = app.getGroupHelper().getGroupSize();

        Assert.assertEquals(after, before);

    }

    @Test
    public void modifyGroupByIndexTest()
    {
        app.getGroupHelper().goToGroupsPage();
        if (!app.getGroupHelper().isGroupPresent())
        {
            app.getGroupHelper().createGroup();
        }
        int before = app.getGroupHelper().getGroupSize();
        app.getGroupHelper().selectGroupByIndex(before-1);
        app.getGroupHelper().initGroupModification();
        app.getGroupHelper().fillGroupForm(new GroupData().setName("modifyNameIndex")
                .setHeader("modifyHeaderIndex")
                .setComment("modifyCommentIndex"));
        app.getGroupHelper().submitGroupModification();
        app.getGroupHelper().returnToGroupPage();
        int after = app.getGroupHelper().getGroupSize();

        Assert.assertEquals(after, before);
    }




}
