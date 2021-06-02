package ru.job4j.io;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleChat {
    private final String path;
    private final String botAnswers;
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";
    private final ArrayList<String> botAnswersBase = new ArrayList<>();
    private final ArrayList<String> dialogue = new ArrayList<>();

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() {
        botInit(botAnswers);
        chat();
        saveDialogueToFile(path);
    }

    private void botInit(String botAnswersFile) {
        try (BufferedReader in = new BufferedReader(new FileReader(botAnswersFile,
                Charset.forName("WINDOWS-1251")))) {
            String line;
            while ((line = in.readLine()) != null) {
                botAnswersBase.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void chat() {
        Scanner scanner = new Scanner(System.in);
        boolean botCanAnswer = true;
        boolean run = true;
        System.out.println("Доступные команды: \n"
                + "стоп - программа перестанет отвечать на ваши реплики. \n"
                + "продолжить - программа продолжит отвечать на ваши реплики. \n"
                + "закончить - программа закончит свою работу. \n"
                + "Давай поболтаем? \n");
        while (run) {
            System.out.print("Вы: ");
            String myInput = scanner.nextLine();
            dialogue.add("Вы: " + myInput);
            if (myInput.equals(OUT)) {
                run = false;
                continue;
            }
            if (myInput.equals(STOP)) {
                botCanAnswer = false;
                continue;
            }
            if (myInput.equals(CONTINUE)) {
                botCanAnswer = true;
            }
            if (botCanAnswer) {
                int randomIndex = (int) (Math.random() * (botAnswersBase.size() - 1));
                String botAnswer = "Бот: " + botAnswersBase.get(randomIndex);
                System.out.println(botAnswer);
                dialogue.add(botAnswer);
            }
        }
    }

    private void saveDialogueToFile(String filePath) {
        try (PrintWriter out = new PrintWriter(new FileWriter(filePath,
                Charset.forName("WINDOWS-1251"), true))) {
            dialogue.forEach(out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ConsoleChat cc = new ConsoleChat("./dialogue.txt", "./botDict.txt");
        cc.run();
    }
}
