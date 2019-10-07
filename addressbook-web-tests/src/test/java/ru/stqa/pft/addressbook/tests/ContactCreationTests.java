package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.io.File;
import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase {

    @Test(enabled = true)
    public void testContactCreation() {
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getNavigationHelper().gotoAddNewPage();
        File photo = new File("src/test/resourses/pic.png");
        ContactData contact = new ContactData().withFirstName("Anastasija").withMiddleName("Sergeevna")
                .withSurname("Shchegolkova").withNickName("sobakapavlova").withTitle("Ms").withCompany("HomeTesting")
                .withAddress("Moscow, Marshala Timoshenko st.").withHome("36").withMobilePhone("891988854")
                .withEmail("sobakapavlova@gmail.com").withbirthYear("1993")
                .withNotes("Test").withGroup("test1").withPhoto(photo);
        app.getContactHelper().createContact(contact, true);
        app.getNavigationHelper().gotoHomePage();
        before.add(contact);
        List<ContactData> after = app.getContactHelper().getContactList();
        Comparator<? super ContactData> ById = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(ById);
        after.sort(ById);
        Assert.assertEquals(before, after);
        System.out.println(before);
        System.out.println(after);
    }
}
