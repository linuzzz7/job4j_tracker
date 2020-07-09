package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book muggle = new Book("Muugle", 130);
        Book cinderella = new Book("Cinderella", 150);
        Book spider = new Book("Clean code", 200);
        Book cat = new Book("Black cat", 222);
        Book[] lib = new Book[4];
        lib[0] = muggle;
        lib[1] = cinderella;
        lib[2] = spider;
        lib[3] = cat;
        for (int i = 0; i < lib.length; i++) {
            System.out.println(lib[i].getName() + " " + lib[i].getPages());
        }
        System.out.println();
        Book temp = lib[3];
        lib[3] = lib[0];
        lib[0] = temp;
        for (int i = 0; i < lib.length; i++) {
            System.out.println(lib[i].getName() + " " + lib[i].getPages());
        }
        System.out.println();
        for (int i = 0; i < lib.length; i++) {
            if (lib[i].getName().equals("Clean code")) {
                System.out.println(lib[i].getName() + " " + lib[i].getPages());
            }
        }
    }
}
