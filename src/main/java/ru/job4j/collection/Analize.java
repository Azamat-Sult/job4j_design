package ru.job4j.collection;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Analize {
    public Info diff(List<User> previous, List<User> current) {
        int addedCount = 0;
        int changedCount = 0;
        int deletedCount = 0;
        int notChangedCount = 0;

        Map<Integer, String> previousConvertedToMap = new HashMap<>();

        for (User previousUser : previous) {
            previousConvertedToMap.put(previousUser.id, previousUser.name);
        }

        for (User currentUser : current) {
            if (!previousConvertedToMap.containsKey(currentUser.id)) {
                addedCount++;
            }
            if (previousConvertedToMap.containsKey(currentUser.id)
                    && !previousConvertedToMap.get(currentUser.id).equals(currentUser.name)) {
                changedCount++;
            }
            if (previous.contains(currentUser)) {
                notChangedCount++;
            }
        }

        deletedCount = previous.size() - changedCount - notChangedCount;

        return new Info(addedCount, changedCount, deletedCount);
    }

    public static class User {
        int id;
        String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            User user = (User) o;
            return id == user.id && Objects.equals(name, user.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name);
        }
    }

    public static class Info {
        int added;
        int changed;
        int deleted;

        public Info(int added, int changed, int deleted) {
            this.added = added;
            this.changed = changed;
            this.deleted = deleted;
        }
    }
}
