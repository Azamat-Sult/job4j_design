package ru.job4j.ood.lsp;

public class WrongExample1 {

    public class Bird {
        public void fly() { }
    }

    public class Duck extends Bird { }

    public class Ostrich extends Bird { }  // Страус - птица, у которой есть метод fly(), но она не умеет летать

}
