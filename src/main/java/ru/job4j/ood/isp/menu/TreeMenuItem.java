package ru.job4j.ood.isp.menu;

import ru.job4j.ood.isp.menu.actions.Action;
import java.util.ArrayList;

public class TreeMenuItem implements MenuItem {

    private String prefix = "-";
    private final String menuItemName;
    private String menuItemNumber;
    private final Action action;
    private final ArrayList<MenuItem> subMenu = new ArrayList<>();

    public TreeMenuItem(String menuItemName, Action action) {
        this.menuItemName = menuItemName;
        this.action = action;
    }

    public void addSubMenuItem(MenuItem subMenuItem) {
        subMenuItem.setPrefix(prefix + "---");
        subMenuItem.setMenuItemNumber(menuItemNumber + "." + (subMenu.size() + 1));
        this.subMenu.add(subMenuItem);
    }

    public MenuItem getSubMenuItem(int index) {
        return subMenu.get(index);
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public void setMenuItemNumber(String menuItemNumber) {
        this.menuItemNumber = menuItemNumber;
    }

    public String getMenuItemNumber() {
        return menuItemNumber;
    }

    public Action getAction() {
        return action;
    }

    public void showSubMenu() {
        System.out.println(prefix + " " + menuItemName + " " + menuItemNumber);
        for (MenuItem menuItem : subMenu) {
            menuItem.showSubMenu();
        }
    }

    public Action getActionByItemNumber(String menuItemNumber) {
        Action rsl = null;
        if (getMenuItemNumber().equals(menuItemNumber)) {
            rsl = getAction();
        } else {
            for (MenuItem menuItem : subMenu) {
                rsl = menuItem.getActionByItemNumber(menuItemNumber);
                if (rsl != null) {
                    break;
                }
            }
        }
        return rsl;
    }

}
