package ru.stqa.pft.addressbook.model;

import com.sun.xml.internal.bind.v2.TODO;

import java.util.Objects;

public class GroupData {
    private final String name;
    private final String header;
    private final String footer;
    private final String id;


    @Override
    public String toString() {
        return "GroupData{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupData groupData = (GroupData) o;
        return Objects.equals(name, groupData.name) &&
                Objects.equals(id, groupData.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }

    public String getId() {
        return id;
    }


    public GroupData(String name, String header, String footer) {
        this.name = name;
        this.id = null;
        this.header = header;
        this.footer = footer;
    }

    public GroupData(String name, String id, String header, String footer) {
        this.name = name;
        this.id = id;
        this.header = header;
        this.footer = footer;
    }

    public String getName() {
        return name;
    }

    public String getHeader() {
        return header;
    }

    public String getFooter() {
        return footer;
    }
}
