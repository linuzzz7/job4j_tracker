package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student1 = new Student();
        student1.setName("Alex Petrov");
        student1.setGroup(15);
        student1.setCreated(new Date(1982, 10,10));
        System.out.println("Name student: " + student1.getName() + System.lineSeparator() +
                           "Group: " + student1.getGroup() + System.lineSeparator() +
                           "Date created: " + student1.getCreated());
    }
}
