package ru.job4j.ex;

public class Fact {
    public static void main(String[] args) {
        Fact test = new Fact();
        System.out.println(test.calc(5));
        System.out.println(test.calc(-1));
    }

    public int calc(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Параметр не может бытьменьше нуля");
        }
        int rsl = 1;
        for (int index = 1; index <= n; index++) {
            rsl *= index;
        }
        return rsl;
    }
}
