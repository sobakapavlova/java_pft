package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase {

    @Test (enabled = false)
    public void testContactCreation() {
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getNavigationHelper().gotoAddNewPage();
        ContactData contact = new ContactData("Anastasija", "Sergeevna",
                "Shchegolkova", "sobakapavlova", "Ms", "HomeTesting",
                "Moscow, Marshala Timoshenko st.", "36", "891988854",
                "sobakapavlova@gmail.com", "1993", "Test", "test1");
        app.getContactHelper().createContact(contact, true);
        app.getNavigationHelper().gotoHomePage();
        before.add(contact);
        List<ContactData> after = app.getContactHelper().getContactList();
        Comparator<? super ContactData> ById = (g1, g2) -> Integer.compare(g1.getId(),g2.getId() );
        before.sort(ById);
        after.sort(ById);
        Assert.assertEquals(before, after);
        System.out.println(before);
        System.out.println(after);
    }
}
