package ru.job4j.ood.isp.menu;

import ru.job4j.ood.isp.menu.actions.Action;

public interface Menu {
    void addMenuItem(MenuItem newItem);
    MenuItem getMenuItem(int index);
    void showAllMenuItems();
    Action getActionByItemNumber(String menuItemNumber);
}
