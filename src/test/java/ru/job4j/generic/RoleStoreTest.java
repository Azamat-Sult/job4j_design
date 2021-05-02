package ru.job4j.generic;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class RoleStoreTest {

    @Test
    public void whenAddThenFindByID() {
        RoleStore roleStore = new RoleStore();
        Role role1 = new Role("first", "Administrator");
        roleStore.add(role1);
        assertThat(roleStore.findById("first"), is(role1));
    }

    @Test
    public void whenReplaceAdminToUser() {
        RoleStore roleStore = new RoleStore();
        Role oldRole = new Role("first", "Administrator");
        roleStore.add(oldRole);
        Role newRole = new Role("first", "User");
        roleStore.replace("first", newRole);
        assertThat(roleStore.findById("first").getUserRole(), is("User"));
    }

    @Test
    public void whenFindByIDDeletedRoleThenNull() {
        RoleStore roleStore = new RoleStore();
        Role role1 = new Role("first", "Tester");
        roleStore.add(role1);
        roleStore.delete("first");
        assertNull(roleStore.findById("first"));
    }
}