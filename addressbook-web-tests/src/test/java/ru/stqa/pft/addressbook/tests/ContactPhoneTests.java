package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactPhoneTests extends TestBase {


    ///TODO домашка 10,11 из 5 леккции
    @Test
    public void testContactPhones() {
        app.getNavigationHelper().gotoHomePage();
        ContactData contact = app.getContactHelper().all().iterator().next();
        ContactData contactInfoFromEditForm = app.getContactHelper().infoFromEditForm(contact);
        assertThat(contact.getAllPhones(), equalTo(mergedPhones(contactInfoFromEditForm)));
    }

    private static String cleaned(String phone) {
        return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
    }

    private String mergedPhones(ContactData contact) {
        return Arrays.asList(contact.getHomePhone() + contact.getMobilePhone() + contact.getWorkPhone())
                .stream().filter((s) -> !s.equals(""))
                .map(ContactPhoneTests::cleaned)
     ///TODO почему-то оно игнорируется \_(ツ)_/¯
                .collect(Collectors.joining("\n"));
    }
}
