package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

public class ContactDeletingTests extends TestBase{


    @Test
    public void testContactDeleting(){
        if(! app.getContactHelper().isThereAContact()) {
            app.getContactHelper().gotoAddNewPage();
            app.getContactHelper().createContact(new ContactData("Anastasija", "Sergeevna",
                    "Shchegolkova", "sobakapavlova", "Ms", "HomeTesting",
                    "Moscow, Marshala Timoshenko st.", "36", "891988854",
                    "sobakapavlova@gmail.com", "1993", "Test", "test1"), true);
        }
        app.getNavigationHelper().gotoHomePage();
        app.getContactHelper().checkContacts();
        app.getContactHelper().submitDelete();
    }
}
