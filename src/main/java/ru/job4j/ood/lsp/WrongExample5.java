package ru.job4j.ood.lsp;

public class WrongExample5 {

    static class Account {

        int capital;

        public Account(int sum) {
            if (sum < 100) {
                System.out.println("Некорректная сумма");
            } else {
                this.capital = sum;
            }
        }

        public int getCapital() {
            return this.capital;
        }

        public void setCapital(int sum) {
            if (sum < 100) {
                System.out.println("Некорректная сумма");
            } else {
                this.capital = sum;
            }
        }
    }

    static class MicroAccount extends Account {

        public MicroAccount(int sum) {
            super(sum);
        }

        @Override
        public int getCapital() {
            return this.capital;
        }

        @Override
        public void setCapital(int sum) {
            this.capital = sum;
        }

    }

    public static void main(String[] args) {
        Account acc = new Account(-100); // Не получилось. Некорректная сумма
        Account mAcc = new MicroAccount(100);
        mAcc.setCapital(-100);
        System.out.println(mAcc.getCapital()); // Получилось)
    }

}
