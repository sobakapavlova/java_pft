package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.FormData;

public class ContactCreationTests extends TestBase {

//
//    public void setUp() throws Exception {
//        app.getSessionHelper().login("admin", "secret");
//    }


    @Test
    public void testContactCreation() {
        app.getNavigationHelper().gotoAddNewPage();
        app.getContactHelper().initAddNew();
        app.getContactHelper().fillAddNewForm(new FormData("Anastasija", "Sergeevna", "Shchegolkova", "sobakapavlova", "Ms", "HomeTesting", "Moscow, Marshala Timoshenko st.", "36", "891988854", "sobakapavlova@gmail.com", "1993", "Test"));
        app.getContactHelper().submitAddNew();
    }
//
//    public void tearDown() {
//        app.getSessionHelper().stop();
//    }

}
