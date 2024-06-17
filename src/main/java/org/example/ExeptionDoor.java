package org.example;

public class ExeptionDoor extends Exception {

    public ExeptionDoor(int message) {
        System.out.println("Вы ввели неверное значение" + message + "\n Выберите дверь которую вы хотите открыть: 1,  2 или 3");
    }
}
