package ru.stqa.pft.addressbook.appmanager;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;


public class ContactHelper extends HelperBase {

    ContactHelper(WebDriver wd) {
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
        type((By.name("email")), contactData.getEmail());
        if (!wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[6]")).isSelected()) {
            wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[6]")).click();
        }
        if (!wd.findElement(By.xpath("//div[@id='content']/form/select[2]//option[2]")).isSelected()) {
            wd.findElement(By.xpath("//div[@id='content']/form/select[2]//option[2]")).click();
        }
        type(By.name("byear"), contactData.getBirthYear());
        type(By.name("notes"), contactData.getNotes());
        type(By.name("home"), contactData.getHomePhone());
        type(By.name("work"), contactData.getWorkPhone());
        type(By.name("mobile"), contactData.getMobilePhone());
    }


    private void initAddNew() {
        click(By.name("firstname"));
    }

    public void initContactUpdate(int index) {
        wd.findElements(By.xpath(".//td[8]")).get(index).click();
        //click(By.xpath(".//td[8]"));
    }


    public void submitUpdateContact() {
        click(By.xpath("//*[@id=\"content\"]/form[1]/input[22]"));
    }

    public void checkContacts(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();

    }

    public void submitDelete() {
        click(By.xpath("//*[@id=\"content\"]/form[2]/div[2]/input"));
        wd.switchTo().alert().accept();
    }

    private void submitAddNew() {
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
            ContactData contact = new ContactData().withFirstName(firstname).withId(Integer.valueOf(id)).withSurname(surname);
            contacts.add(contact);
        }
        return contacts;
    }


    public Set<ContactData> all() {
        Set<ContactData> contacts = new HashSet<ContactData>();
        List<WebElement> rows = wd.findElements(By.name("entry"));
        for (WebElement row : rows) {
            List<WebElement> cells = wd.findElements(By.tagName("td"));
            String firstname = cells.get(1).getText();
            String surname = cells.get(2).getText();
            String phones = cells.get(5).getText();
            String id = row.findElement(By.tagName("input")).getAttribute("id");
            contacts.add(new ContactData().withId(Integer.valueOf(id)).withFirstName(firstname).withSurname(surname).withAllPhones(phones));
        }
        return contacts;
    }


    public ContactData infoFromEditForm(ContactData contact) {
        initContactModificationById(contact.getId());
        String firstName = wd.findElement(By.name("firstname")).getAttribute("value");
        String lastName = wd.findElement(By.name("lastname")).getAttribute("value");
        String home = wd.findElement(By.name("home")).getAttribute("value");
        String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
        String work = wd.findElement(By.name("work")).getAttribute("value");
        wd.navigate().back();
        return new ContactData().withId(contact.getId()).withFirstName(firstName)
                .withHomePhone(home).withMobilePhone(mobile).withWorkPhone(work);
    }

    private void initContactModificationById(int id) {
        WebElement checkbox = wd.findElement(By.cssSelector(String.format("input[value='%s']", id)));
        WebElement row = checkbox.findElement(By.xpath("./../.."));
        List<WebElement> cells = row.findElements(By.tagName("td"));
        cells.get(7).findElement(By.tagName("a")).click();
    }


}
