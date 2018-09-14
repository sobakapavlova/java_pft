package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.FormData;


public class ContactHelper extends HelperBase{

    public ContactHelper(FirefoxDriver wd) {
        super(wd);
    }

    public void submitAddNew() {
        click(By.xpath("//div[@id='content']/form/input[21]"));
    }

    public void fillAddNewForm(FormData formData) {
        type(By.name("firstname"), formData.getFirstname());
        type(By.name("middlename"),formData.getMiddlename());
        type(By.name("lastname"),formData.getSurname());
        type(By.name("nickname"),formData.getNickname());
        type(By.name("title"),formData.getTitle());
        type(By.name("company"),formData.getCompany());
        type(By.name("address"),formData.getAddress());
        type(By.name("home"),formData.getHome());
        type(By.name("mobile"),formData.getMobile());
        type((By.name("email")), formData.getEmail());
        if (!wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[6]")).isSelected()) {
            wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[6]")).click();
        }
        if (!wd.findElement(By.xpath("//div[@id='content']/form/select[2]//option[2]")).isSelected()) {
            wd.findElement(By.xpath("//div[@id='content']/form/select[2]//option[2]")).click();
        }
        type(By.name("byear"),formData.getBirthYear());
        type(By.name("notes"),formData.getNotes());
    }

    public void initAddNew() {
        click(By.name("firstname"));
    }

    public void initContactUpdate() {
        click(By.xpath("//table[@id='maintable']/tbody/tr[3]/td[8]/a/img"));
    }

    public void submitUpdateContact() {
        click(By.xpath("//*[@id=\"content\"]/form[1]/input[22]"));
    }

    public void checkContacts() {
        click(By.xpath("//*[@id=\"3\"]"));
    }

    public void submitDelete() {
        click(By.xpath("//*[@id=\"content\"]/form[2]/div[2]/input"));
        wd.switchTo().alert().accept();
    }
}
