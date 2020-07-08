package ru.job4j.oop;

public class DummyDic {

    public String engToRus(String eng) {
        String rus = "Неизвестное слово. " + eng;
        return rus;
    }

    public static void main(String[] args) {
        DummyDic dic = new DummyDic();
        System.out.println(dic.engToRus("Unknown word"));
    }
}
