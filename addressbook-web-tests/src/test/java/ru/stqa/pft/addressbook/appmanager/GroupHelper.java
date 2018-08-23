package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupHelper extends HelperBase{

    public GroupHelper(FirefoxDriver wd) {
        super(wd);
    }

    public void returnToGroupPage() {
        click(By.linkText("group page"));
    }

    public void submitGroupCreation() {
        click(By.name("submit"));
    }

    public void fillGroupForm(GroupData groupData) {
        type(By.name("group_name"), groupData.getName());
        type(By.name("group_name"), groupData.getHeader());
        type(By.name("group_name"), groupData.getFooter());
    }

    public void initGroupCreation() {
        click(By.name("new"));
    }

    //public void DeleteSelectedGroups() {
      //  click(By.xpath("//div[@id='content']/form/input[5]"));
    //}

    public void DeleteSelectedGroups() {
        click(By.name("delete"));
    }


    public void selectGroup() {
        click(By.name("selected[]"));
    }
}
