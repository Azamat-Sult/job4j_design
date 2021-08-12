package ru.job4j.ood.isp.menu.actions;

public class NotFoundAction implements Action {
    public boolean execute() {
        System.out.println("Such menu item not found...");
        return true;
    }
}
