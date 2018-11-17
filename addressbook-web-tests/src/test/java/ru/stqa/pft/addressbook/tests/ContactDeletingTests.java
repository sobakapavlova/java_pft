package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

public class ContactDeletingTests extends TestBase {


    @Test (enabled = false)
    public void testContactDeleting() {
        ContactData contact = new ContactData("Anastasija", "Sergeevna",
                "Shchegolkova", "sobakapavlova", "Ms", "HomeTesting",
                "Moscow, Marshala Timoshenko st.", "36", "891988854",
                "sobakapavlova@gmail.com", "1993", "Test", "test1");
        if (!app.getContactHelper().isThereAContact()) {
            app.getContactHelper().gotoAddNewPage();
            app.getContactHelper().createContact(contact, true);
        }
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getNavigationHelper().gotoHomePage();
        app.getContactHelper().checkContacts(before.size() - 1);
        app.getContactHelper().submitDelete();
        app.getNavigationHelper().gotoHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(before.size() - 1, after.size());
        contact.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
        Comparator<? super ContactData> ById = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.remove(before.size() - 1);
        before.sort(ById);
        after.sort(ById);
        System.out.println(before);
        System.out.println(after);
        Assert.assertEquals(before, after);
    }
}
