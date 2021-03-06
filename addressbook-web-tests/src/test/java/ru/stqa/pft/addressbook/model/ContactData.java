package ru.stqa.pft.addressbook.model;

import java.io.File;
import java.util.Objects;

public class ContactData {
    private String firstname;
    private String middlename;
    private String surname;
    private String nickname;
    private String title;
    private String company;
    private String address;
    private String home;
    private String mobilePhone;
    private String email;
    private String birthYear;
    private String notes;
    private String group;
    private String homePhone;
    private String workPhone;
    private int id;
    private String allPhones;
    private File photo;

    public ContactData withPhoto(File photo) {
        this.photo = photo;
        return this;
    }


    public ContactData withAllPhones(String allPhones) {
        this.allPhones = allPhones;
        return this;
    }

    public ContactData withId(int id) {
        this.id = id;
        return this;
    }

    public ContactData withNickName(String nickname) {
        this.nickname = nickname;
        return this;
    }

    public ContactData withTitle(String title) {
        this.title = title;
        return this;
    }

    public ContactData withEmail(String email) {
        this.email = email;
        return this;
    }


    public ContactData withHome(String home) {
        this.home = home;
        return this;
    }


    public ContactData withGroup(String group) {
        this.group = group;
        return this;
    }


    public ContactData withNotes(String notes) {
        this.notes = notes;
        return this;
    }


    public ContactData withCompany(String company) {
        this.company = company;
        return this;
    }


    public ContactData withAddress(String address) {
        this.address = address;
        return this;
    }


    public ContactData withbirthYear(String birthYear) {
        this.birthYear = birthYear;
        return this;
    }


    public ContactData withFirstName(String firstname) {
        this.firstname = firstname;
        return this;
    }


    public ContactData withMiddleName(String middlename) {
        this.middlename = middlename;
        return this;
    }


    public ContactData withSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public ContactData withMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
        return this;
    }


    public ContactData withWorkPhone(String workPhone) {
        this.workPhone = workPhone;
        return this;
    }


    public ContactData withHomePhone(String homePhone) {
        this.homePhone = homePhone;
        return this;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public String getSurname() {
        return surname;
    }

    public String getNickname() {
        return nickname;
    }

    public String getTitle() {
        return title;
    }

    public String getCompany() {
        return company;
    }

    public String getAddress() {
        return address;
    }

    public String getHome() {
        return home;
    }

    public String getEmail() {
        return email;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public File getPhoto() {
        return photo;
    }

    public String getNotes() {
        return notes;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }


    public String getAllPhones() {
        return allPhones;
    }

    public String getGroup() {
        return group;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactData that = (ContactData) o;
        return Objects.equals(firstname, that.firstname) &&
                Objects.equals(surname, that.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstname, surname);
    }

    @Override
    public String toString() {
        return "ContactData{" +
                "firstname='" + firstname + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }

    public ContactData getContact(ContactData contact) {
        return contact;
    }


}
