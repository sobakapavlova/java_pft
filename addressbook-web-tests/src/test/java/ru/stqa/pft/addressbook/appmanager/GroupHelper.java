package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GroupHelper extends HelperBase {

    GroupHelper(WebDriver wd) {
        super(wd);
    }

    private void returnToGroupPage() {
        click(By.linkText("group page"));
    }

    private void submitGroupCreation() {
        click(By.name("submit"));
    }

    private void fillGroupForm(GroupData groupData) {
        type(By.name("group_name"), groupData.getName());
        type(By.name("group_header"), groupData.getHeader());
        type(By.name("group_footer"), groupData.getFooter());
    }

    private void initGroupCreation() {
        click(By.name("new"));
    }


    private void delete() {
        click(By.name("delete"));
    }


    private void select(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
    }

    private void initModification() {
        click(By.name("edit"));
    }

    private void submitGroupModification() {
        click(By.name("update"));
    }

    private Groups groupCache = null;

    public void create(GroupData group) {
        initGroupCreation();
        fillGroupForm(group);
        submitGroupCreation();
        groupCache = null;
        returnToGroupPage();
    }

    public void modify(GroupData group) {
        selectByGroupId(group.getId());
        initModification();
        fillGroupForm(group);
        submitGroupModification();
        groupCache = null;
        returnToGroupPage();
    }


    public boolean isThereAGroup() {
        return isElementPresent(By.name("selected[]"));
    }

    public int count() {
        return wd.findElements(By.name("selected[]")).size();
    }


    public Groups all() {
        if (groupCache != null) {
            return new Groups(groupCache);
        } else {
            groupCache = new Groups();
            List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
            for (WebElement element : elements) {
                String name = element.getText();
                String id = element.findElement(By.tagName("input")).getAttribute("value");
                groupCache.add(new GroupData().withName(name).withId(Integer.parseInt(id)));
            }
            return new Groups(groupCache);
        }
    }

    public void delete(int index) {
        select(index);
        delete();
        returnToGroupPage();
    }

    public void delete(GroupData deletedGroup) {
        selectByGroupId(deletedGroup.getId());
        delete();
        groupCache = null;
        returnToGroupPage();
    }

    private void selectByGroupId(int id) {
        wd.findElement(By.cssSelector("input[value= '" + id + "']")).click();

    }
}
