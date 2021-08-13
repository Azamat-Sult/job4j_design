package ru.job4j.ood.dip;

public class Example3 {

    // Результат работы метода doSomeAction - экземпляр конкретного класса Result вместо интерфейса Result

    public class Result {

    }

    public Result doSomeAction(String command) {
        return new Result();
    }

}
