package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import org.hamcrest.MatcherAssert;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class GroupCreationTests extends TestBase {


    @Test
    public void testGroupCreationTests() {
        app.getNavigationHelper().gotoGroupPage();
        Groups before = app.group().all();
        GroupData group = new GroupData().withName("test1");
        app.group().create(group);
        Groups after = app.group().all();
        assertThat(before.size() + 1, equalTo(after.size()));

        assertThat(after, equalTo(before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));

    }

}
