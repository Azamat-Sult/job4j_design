package ru.job4j.experiment;

public class ReverseString {

    public static String reverse(String s) {
        StringBuilder rsl = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            rsl.append(s.charAt(i));
        }
        return String.valueOf(rsl);
    }

    public static void main(String[] args) {
        System.out.println(reverse("123456789"));
    }

}