package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class GroupDeletingTests extends TestBase{


    @Test
    public void testGroupDeleting() {
        app.getNavigationHelper().gotoGroupPage();
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().DeleteSelectedGroups();
        app.getGroupHelper().returnToGroupPage();
    }

}

