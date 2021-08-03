package ru.job4j.ood.lsp;

public class WrongExample3 {

    static class Account {

        public int capital;

        public void setCapital(int money) {
            if (money < 0) {
                System.out.println("Нельзя положить на счет меньше 0");
            } else {
                this.capital = money;
            }
        }
    }

    static class MicroAccount extends Account {

        @Override
        public void setCapital(int money) {
            if (money < 0) {
                System.out.println("Нельзя положить на счет меньше 0");
            } else if (money > 100) {
                System.out.println("Нельзя положить на счет больше 100"); // Усилили предусловие
            } else {
                this.capital = money;
            }
        }
    }

    public static void initAccount(Account account) {
        account.setCapital(200);
        System.out.println(account.capital);
    }

    public static void main(String[] args) {
        Account acc = new MicroAccount();
        initAccount(acc);
        // Пополняли Account на 200 руб без верхнего порога,
        // а получили ошибку от MicroAccount за превышение порога в 100 руб
    }

}
