package ru.job4j.ood.isp.menu.actions;

public class ExitAction implements Action {
    public boolean execute() {
        System.out.println("Exit program selected");
        return false;
    }
}
