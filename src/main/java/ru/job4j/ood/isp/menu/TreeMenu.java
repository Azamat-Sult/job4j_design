package ru.job4j.ood.isp.menu;

import ru.job4j.ood.isp.menu.actions.*;
import java.util.ArrayList;

public class TreeMenu implements Menu {

    private final ArrayList<MenuItem> menu = new ArrayList<>();

    public void addMenuItem(MenuItem newItem) {
        newItem.setMenuItemNumber(String.valueOf(menu.size() + 1));
        menu.add(newItem);
    }

    public MenuItem getMenuItem(int index) {
        return menu.get(index);
    }

    public void showAllMenuItems() {
        System.out.println("------------ MENU ------------");
        for (MenuItem menuItem : menu) {
            menuItem.showSubMenu();
        }
    }

    public Action getActionByItemNumber(String menuItemNumber) {
        Action rsl = null;
        for (MenuItem menuItem : menu) {
            rsl = menuItem.getActionByItemNumber(menuItemNumber);
            if (rsl != null) {
                break;
            }
        }
        return rsl != null ? rsl : new NotFoundAction();
    }
}
