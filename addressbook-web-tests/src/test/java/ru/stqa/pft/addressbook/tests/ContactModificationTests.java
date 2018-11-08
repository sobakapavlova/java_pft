package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {


    @Test
    public void testContactModification(){
    app.getNavigationHelper().gotoHomePage();
    app.getContactHelper().initContactUpdate();
    app.getContactHelper().fillContactForm(new ContactData("Nastya", "Sergeevna",
            "Shchegolkova", "sobakapavlova", "Ms", "HomeTesting",
            "Moscow, Marshala Timoshenko st.", "36", "891988854",
            "sobakapavlova@gmail.com", "1993", "Test", null), false);
    app.getContactHelper().submitUpdateContact();
    }

}
