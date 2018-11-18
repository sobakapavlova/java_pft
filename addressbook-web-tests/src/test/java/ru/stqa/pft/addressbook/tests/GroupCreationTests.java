package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class GroupCreationTests extends TestBase {


    @Test
    public void testGroupCreationTests() {
        app.getNavigationHelper().gotoGroupPage();
        Set<GroupData> before = app.group().all();
        GroupData group = new GroupData().withName("test1");
        app.group().create(group);
        Set<GroupData> after = app.group().all();
        Assert.assertEquals(before.size() + 1, after.size());

        group.withId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
        before.add(group);

        group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt());
        Assert.assertEquals(before, after);

    }

}
