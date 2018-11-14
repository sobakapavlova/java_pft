package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.ArrayList;
import java.util.List;


public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void fillContactForm(ContactData contactData, boolean creation) {
        type(By.name("firstname"), contactData.getFirstname());
        type(By.name("middlename"), contactData.getMiddlename());
        type(By.name("lastname"), contactData.getSurname());
        type(By.name("nickname"), contactData.getNickname());
        type(By.name("title"), contactData.getTitle());
        type(By.name("company"), contactData.getCompany());
        type(By.name("address"), contactData.getAddress());
        type(By.name("home"), contactData.getHome());
        type(By.name("mobile"), contactData.getMobile());
        type((By.name("email")), contactData.getEmail());
        if (!wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[6]")).isSelected()) {
            wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[6]")).click();
        }
        if (!wd.findElement(By.xpath("//div[@id='content']/form/select[2]//option[2]")).isSelected()) {
            wd.findElement(By.xpath("//div[@id='content']/form/select[2]//option[2]")).click();
        }
        type(By.name("byear"), contactData.getBirthYear());
        type(By.name("notes"), contactData.getNotes());
    }


    public void initAddNew() {
        click(By.name("firstname"));
    }

    public void initContactUpdate() {
        click(By.xpath("//*[@id=\"maintable\"]/tbody/tr[2]/td[8]/a/img"));
    }


    public void submitUpdateContact() {
        click(By.xpath("//*[@id=\"content\"]/form[1]/input[22]"));
    }

    public void checkContacts() {
        click(By.name("selected[]"));
    }

    public void submitDelete() {
        click(By.xpath("//*[@id=\"content\"]/form[2]/div[2]/input"));
        wd.switchTo().alert().accept();
    }

    public void submitAddNew() {
        wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
    }


    public void gotoAddNewPage() {
        wd.findElement(By.linkText("add new")).click();
    }

    public void createContact(ContactData contact, boolean b) {
        initAddNew();
        fillContactForm(contact, true);
        submitAddNew();
    }

    public boolean isThereAContact() {
        return isElementPresent(By.name("selected[]"));
    }


    public List<ContactData> getContactList() {
        List<ContactData> contacts = new ArrayList<ContactData>();
        List<WebElement> elements = wd.findElements(By.name("entry"));
        for (WebElement element : elements) {
            String firstname = element.findElement(By.xpath(".//td[3]")).getText();
            String surname = element.findElement(By.xpath(".//td[2]")).getText();
            String id = element.findElement(By.tagName("input")).getAttribute("id");
            ContactData contact = new ContactData(Integer.parseInt(id), firstname, null, surname,
                    null, null, null, null, null, null,
                    null, null, null, null);
            contacts.add(contact);
        }
        return contacts;
    }
}
