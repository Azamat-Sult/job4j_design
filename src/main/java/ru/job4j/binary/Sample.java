package ru.job4j.binary;

public class Sample {
    public static void main(String[] args) {
        int x = 342;
        int y = ~x;
        System.out.println("~ - побитовый оператор “НЕ”");
        System.out.println(String.format("%32s", Integer.toBinaryString(x)).replace(' ', '0'));
        System.out.println(String.format("%32s", Integer.toBinaryString(y)).replace(' ', '0'));

        x = 342;
        y = 265;
        System.out.println("& - побитовый оператор “И”");
        System.out.println(String.format("%32s", Integer.toBinaryString(x)).replace(' ', '0'));
        System.out.println(String.format("%32s", Integer.toBinaryString(y)).replace(' ', '0'));
        System.out.println(String.format("%32s", Integer.toBinaryString(x & y)).replace(' ', '0'));

        x = 342;
        y = 265;
        System.out.println("| - побитовое “ИЛИ”");
        System.out.println(String.format("%32s", Integer.toBinaryString(x)).replace(' ', '0'));
        System.out.println(String.format("%32s", Integer.toBinaryString(y)).replace(' ', '0'));
        System.out.println(String.format("%32s", Integer.toBinaryString(x | y)).replace(' ', '0'));

        x = 342;
        y = 265;
        System.out.println("^ - побитовое исключающее “ИЛИ” (также известно как XOR)");
        System.out.println(String.format("%32s", Integer.toBinaryString(x)).replace(' ', '0'));
        System.out.println(String.format("%32s", Integer.toBinaryString(y)).replace(' ', '0'));
        System.out.println(String.format("%32s", Integer.toBinaryString(x ^ y)).replace(' ', '0'));

        x = 343;
        y = 5;
        System.out.println("<< - сдвиг битов влево");
        System.out.println(String.format("%32s", Integer.toBinaryString(x)).replace(' ', '0'));
        System.out.println(String.format("%32s", Integer.toBinaryString(x << y)).replace(' ', '0'));

        x = 343;
        y = 3;
        System.out.println(">> - сдвиг битов вправо");
        System.out.println(String.format("%32s", Integer.toBinaryString(x)).replace(' ', '0'));
        System.out.println(String.format("%32s", Integer.toBinaryString(x >> y)).replace(' ', '0'));
    }
}
