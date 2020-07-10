package ru.job4j.io;

import java.util.Scanner;

public class Matches {

    public static int input(int gamer) {
        Scanner input = new Scanner(System.in);
        System.out.println("Игрок №" + gamer + " возьмите от 1 до 3 спичек");
        boolean game = true;
        int result = 0;
        while (game) {
            int select = Integer.parseInt(input.nextLine());
            if (select <= 3) {
                result = select;
                System.out.println("Игрок " + gamer + " взял " + select + " спичек");
                break;
            } else {
                System.out.println("Спичек можно взять только от 1 до 3");
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("Игра 11, игрок должен взять от 1 до 3 спичек победит тот кто возьмет последние");
        int match = 11;
        int gamer = 1;
        while (match > 0) {
            match -= input(gamer);
            if (match <= 0) {
                System.out.println("Победил " + gamer + " игрок");
                break;
            }
            if (gamer == 1) {
                gamer = 2;
            } else {
                gamer = 1;
            }
            System.out.println("На столе осталось " + match + " спичек");
        }
    }
}
