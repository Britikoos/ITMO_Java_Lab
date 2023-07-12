package ru.britikos.Clients;

/**
 * Класс отвечает за персональные данные клиеты: Серия и номер паспорта.
 */
public class Passport {
    /**
     * Конструктор
     * @param number
     * @param series
     */
    public Passport(int number, int series){
        number = number;
        series = series;
    }
    public int number;
    public int series;
}
