package ru.job4j.generic;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

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

    @Test
    public void whenReplaceNonExistThenFalse() {
        RoleStore roleStore = new RoleStore();
        Role role = new Role("second", "Tester");
        assertFalse(roleStore.replace("first", role));
    }

    @Test
    public void whenReplaceExistElementThenTrue() {
        RoleStore roleStore = new RoleStore();
        Role role1 = new Role("first", "admin");
        Role role2 = new Role("second", "tester");
        roleStore.add(role1);
        assertTrue(roleStore.replace("first", role2));
    }

    @Test
    public void whenRemoveNonExistElementThenFalse() {
        RoleStore roleStore = new RoleStore();
        assertFalse(roleStore.delete("first"));
    }

    @Test
    public void whenRemoveExistElementThenTrue() {
        RoleStore roleStore = new RoleStore();
        Role user = new Role("first", "admin");
        roleStore.add(user);
        assertTrue(roleStore.delete("first"));
    }
}