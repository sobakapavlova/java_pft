package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

//
//    public void setUp() throws Exception {
//        app.getSessionHelper().login("admin", "secret");
//    }


    @Test
    public void testContactCreation() {
        app.getNavigationHelper().gotoAddNewPage();
        app.getContactHelper().initAddNew();
        app.getContactHelper().fillContactForm(new ContactData("Anastasija", "Sergeevna",
                "Shchegolkova", "sobakapavlova", "Ms", "HomeTesting",
                "Moscow, Marshala Timoshenko st.", "36", "891988854",
                "sobakapavlova@gmail.com", "1993", "Test", "test1"), true);
        app.getContactHelper().submitAddNew();
    }
//
//    public void tearDown() {
//        app.getSessionHelper().stop();
//    }

}
