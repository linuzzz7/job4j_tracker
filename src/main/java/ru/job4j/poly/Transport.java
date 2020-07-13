package ru.job4j.poly;

public interface Transport {
    /**
     * ехать
     */
    public void drive();

    /**
     * @param numbers - число пассажиров
     */
    public void passengers(int numbers);

    /**
     * @param fuel - принимает кол-во топлива
     * @return - возвращает цену
     */
    public int fillUp(int fuel);
}
