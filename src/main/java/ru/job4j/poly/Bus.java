package ru.job4j.poly;

public class Bus implements Transport{
    /**
     * вывод сообщения
     */
    @Override
    public void drive() {
        System.out.println("Bus is drive");
    }

    /**
     * @param numbers - число пассажиров
     */
    @Override
    public void passengers(int numbers) {
        System.out.println("В автобусе " + numbers + " пассажиров");
    }

    /**
     * @param fuel - принимает кол-во топлива
     * @return - возвращает цену
     */
    @Override
    public int fillUp(int fuel) {
        int price = 15;
        return fuel * price;
    }
}
