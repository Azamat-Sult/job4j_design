package ru.job4j.ood.isp.menu;

import ru.job4j.ood.isp.menu.actions.*;
import java.util.Scanner;

public class TreeMenuUsage {

    public static void main(String[] args) {

        Menu menu = new TreeMenu();

        menu.addMenuItem(new TreeMenuItem("Create new document", new CreateAction()));
        menu.getMenuItem(0).addSubMenuItem(new TreeMenuItem("Edit document", new EditAction()));
        menu.getMenuItem(0).getSubMenuItem(0).addSubMenuItem(new TreeMenuItem("Rename document", new RenameAction()));
        menu.getMenuItem(0).getSubMenuItem(0).addSubMenuItem(new TreeMenuItem("Convert document", new ConvertAction()));
        menu.getMenuItem(0).addSubMenuItem(new TreeMenuItem("Save document", new SaveAction()));
        menu.addMenuItem(new TreeMenuItem("Send document", new SendAction()));
        menu.getMenuItem(1).addSubMenuItem(new TreeMenuItem("Exit", new ExitAction()));

        Scanner scanner = new Scanner(System.in);
        boolean run = true;
        while (run) {
            menu.showAllMenuItems();
            System.out.print("Select: ");
            String select = scanner.nextLine();
            run = menu.getActionByItemNumber(select).execute();
        }
    }
}
