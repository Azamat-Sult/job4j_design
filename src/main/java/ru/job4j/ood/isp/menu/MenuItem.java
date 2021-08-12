package ru.job4j.ood.isp.menu;

import ru.job4j.ood.isp.menu.actions.Action;

public interface MenuItem {
    void addSubMenuItem(MenuItem subMenuItem);
    MenuItem getSubMenuItem(int index);
    void setPrefix(String prefix);
    void setMenuItemNumber(String menuItemNumber);
    String getMenuItemNumber();
    Action getAction();
    void showSubMenu();
    Action getActionByItemNumber(String menuItemName);
}
