package ru.job4j.kiss;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiPredicate;

public class MaxMin {
    public <T> T max(List<T> value, Comparator<T> comparator) {
        return findByPredicate(value, (u1, u2) -> comparator.compare(u1, u2) < 0);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        return findByPredicate(value, (u1, u2) -> comparator.compare(u1, u2) > 0);
    }

    public <T> T findByPredicate(List<T> value, BiPredicate<T, T> predicate) {
        T rsl = value.get(0);
        for (T another : value) {
            if (predicate.test(rsl, another)) {
                rsl = another;
            }
        }
        return rsl;
    }

    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User(4, "Artemis", "qwerty@mail.ru"));
        users.add(new User(57, "Bob", "asdffgh@mail.ru"));
        users.add(new User(21, "Catrin", "zxcvbn@mail.ru"));
        users.add(new User(68, "Deny", "poiuyt@mail.ru"));

        MaxMin mm = new MaxMin();

        Comparator<User> comparator = Comparator.comparingInt(User::getId);

        System.out.println("User with Max Id: " + mm.max(users, comparator));
        System.out.println("User with Min Id: " + mm.min(users, comparator));
    }
}
