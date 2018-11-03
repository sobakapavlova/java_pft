package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.FormData;

public class ContactDeletingTests extends TestBase{


    @Test
    public void testContactDeleting(){
        app.getNavigationHelper().gotoHomePage();
        app.getContactHelper().checkContacts();
        app.getContactHelper().submitDelete();
    }
}
