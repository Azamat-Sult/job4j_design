package ru.job4j.ood.lsp;

public class WrongExample4 {

    static class Account {

        public int getInterest(int sum, int months, int rate) {

            int result = 0;

            if (sum < 0 || months > 12 || months < 1 || rate < 0) { // предусловие
                System.out.println("Некорректные данные");
            } else {
                result = sum;
                for (int i = 0; i < months; i++) {
                    result += result * rate  / 100;
                }
            }

            if (sum >= 1000) { // постусловие
                result += 100; // добавляем бонус
            }

            return result;
        }
    }

    static class MicroAccount extends Account {

        @Override
        public int getInterest(int sum, int months, int rate) {

            int result = 0;

            if (sum < 0 || months > 12 || months < 1 || rate < 0) { // предусловие
                System.out.println("Некорректные данные");
            } else {
                result = sum;
                for (int i = 0; i < months; i++) {
                    result += result * rate  / 100;
                }
            }

            // постусловие "забыли"

            return result;
        }
    }

    public static void calculateInterest(Account account) {
        int sum = account.getInterest(1000, 1, 10); // 1000 + 1000 * 10 / 100 + 100 (бонус)
        if (sum != 1200) { // ожидаем 1200
            System.out.println("Неожиданная сумма при вычислениях");
            System.out.println(sum); // получаем 1100 без "забытого" бонуса
        }
    }

    public static void main(String[] args) {
        Account acc = new MicroAccount();
        calculateInterest(acc);
    }

}
