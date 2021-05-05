package ru.job4j.generic;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class UserStoreTest {

    @Test
    public void whenAddThenFindByID() {
        UserStore userStore = new UserStore();
        User user1 = new User("first", "Azamat");
        userStore.add(user1);
        assertThat(userStore.findById("first"), is(user1));
    }

    @Test
    public void whenReplaceAzamatToPetr() {
        UserStore userStore = new UserStore();
        User oldUser = new User("first", "Azamat");
        userStore.add(oldUser);
        User newUser = new User("first", "Petr");
        userStore.replace("first", newUser);
        assertThat(userStore.findById("first").getUserName(), is("Petr"));
    }

    @Test
    public void whenFindByIDDeletedUserThenNull() {
        UserStore userStore = new UserStore();
        User user1 = new User("first", "Azamat");
        userStore.add(user1);
        userStore.delete("first");
        assertNull(userStore.findById("first"));
    }

    @Test
    public void whenReplaceNonExistElementThenFalse() {
        UserStore userStore = new UserStore();
        User user = new User("second", "Ivan");
        assertFalse(userStore.replace("first", user));
    }

    @Test
    public void whenReplaceExistElementThenTrue() {
        UserStore userStore = new UserStore();
        User user1 = new User("first", "Azamat");
        User user2 = new User("second", "Petr");
        userStore.add(user1);
        assertTrue(userStore.replace("first", user2));
    }

    @Test
    public void whenRemoveNonExistElementThenFalse() {
        UserStore userStore = new UserStore();
        assertFalse(userStore.delete("first"));
    }

    @Test
    public void whenRemoveExistElementThenTrue() {
        UserStore userStore = new UserStore();
        User user = new User("first", "Azamat");
        userStore.add(user);
        assertTrue(userStore.delete("first"));
    }
}