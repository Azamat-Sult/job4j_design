package ru.job4j.ood.isp.menu.actions;

public class SendAction implements Action {
    public boolean execute() {
        System.out.println("Send action selected");
        return true;
    }
}
