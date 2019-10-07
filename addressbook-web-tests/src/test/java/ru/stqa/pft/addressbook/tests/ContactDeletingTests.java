package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactDeletingTests extends TestBase {


    @Test (enabled = true)
    public void testContactDeleting() {
        ContactData contact = new ContactData().withFirstName("Anastasija").withMiddleName("Sergeevna")
                .withSurname("Shchegolkova").withNickName("sobakapavlova").withTitle("Ms").withCompany("HomeTesting")
                .withAddress("Moscow, Marshala Timoshenko st.").withHome("36").withMobilePhone("891988854")
                .withEmail("sobakapavlova@gmail.com").withbirthYear("1993")
                .withNotes("Test").withGroup("test1");
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
