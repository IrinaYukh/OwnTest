package home.addressbook.helpers;

import home.addressbook.data.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GroupHelper extends HelperBase
{

    public GroupHelper(WebDriver driver) {
        super(driver);
    }

    public void initGroupCreation()
    {
        click(By.xpath("//*[@value='NEW_GROUP']"));
    }

    public void fillGroupForm(GroupData group)
    {
        type(By.name("group_name"), group.getName());
        type(By.name("group_header"), group.getHeader());
        type(By.name("group_footer"), group.getComment());
    }

    public void submitGroupCreation() {
        click(By.name("submit"));
    }

    public void returnToGroupPage() {
        click(By.xpath("//a[contains(text(),'group page')]"));
    }

    public int getGroupSize()
    {
        return driver.findElements(By.name("selected[]")).size();
    }

    public void selectGroup()
    {
        click(By.name("selected[]"));
    }

    public void initGroupModification()
    {
        click(By.xpath("//input[@value='EDIT_GROUP']"));
    }

    public void submitGroupModification()
    {
        click(By.xpath("//input[@value='UPDATE']"));
    }



    public boolean isGroupPresent()
    {
        return isElementPresent(By.name("selected[]"));
    }

    public void createGroup()
    {
        initGroupCreation();
        fillGroupForm(new GroupData().setName("default").setHeader("default").setComment("default"));
        submitGroupCreation();
        returnToGroupPage();
    }

    public void selectGroupByIndex(int index)
    {
        driver.findElements(By.name("selected[]")).get(index).click();
    }

    public void initGroupDeletion()
    {
        click(By.name("delete"));
    }

    public void goToGroupsPage() {
        if (!isElementPresent(By.xpath("//h1[contains(text(),'GROUPS')]"))&& !isElementPresent(By.name("new")))
        {
            click(By.xpath("//*[@href='group.php']"));
        }
    }

}
