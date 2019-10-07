package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase {


    @Test(enabled = true)
    public void testContactModification() {
//        ContactData contact = new ContactData("Anastasija", "Sergeevna",
//                "Shchegolkova", "sobakapavlova", "Ms", "HomeTesting",
//                "Moscow, Marshala Timoshenko st.", "36", "891988854",
//                "sobakapavlova@gmail.com", "1993", "Test", "test1");
        ContactData contact = new ContactData().withFirstName("Anastasija").withMiddleName("Sergeevna")
                .withSurname("Shchegolkova").withNickName("sobakapavlova").withTitle("Ms").withCompany("HomeTesting")
                .withAddress("Moscow, Marshala Timoshenko st.").withHome("36").withMobilePhone("891988854")
                .withEmail("sobakapavlova@gmail.com").withbirthYear("1993")
                .withNotes("Test").withGroup("test1");

        if (!app.getContactHelper().isThereAContact()) {
            app.getContactHelper().gotoAddNewPage();
            app.getContactHelper().createContact(contact, true);
        }
        app.getNavigationHelper().gotoHomePage();
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().initContactUpdate(before.size() - 1);
        ContactData contactModificated = new ContactData().withId(before.get(before.size() - 1).getId())
                .withFirstName("Sergey").withMiddleName("Anastasivich").withSurname("Shchegolkov")
                .withNickName("sobakapavlova").withTitle("Ms").withCompany("HomeTesting")
                .withAddress("Moscow, Marshala Timoshenko st.").withHome("36").withMobilePhone("891988854")
                .withEmail("sobakapavlova@gmail.com").withbirthYear("1993")
                .withNotes("Test").withGroup("test1");
        app.getContactHelper().fillContactForm(contactModificated, false);
        app.getContactHelper().submitUpdateContact();
        before.remove(before.size() - 1);
        before.add(contactModificated);
        app.getNavigationHelper().gotoHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Comparator<? super ContactData> ById = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(ById);
        after.sort(ById);
        Assert.assertEquals(before, after);
        System.out.println(before);
        System.out.println(after);
    }

}
