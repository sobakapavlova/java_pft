package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class ContactDeletingTests extends TestBase{


    @Test
    public void testContactDeleting(){
        app.getNavigationHelper().gotoHomePage();
        app.getContactHelper().checkContacts();
        app.getContactHelper().submitDelete();
    }
}
