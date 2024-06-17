package org.example;

import java.util.*;

public class Programm {
    private Door door1;
    private Door door2;
    private Door door3;
    private Scanner scanner;
    private int countOpened = 0;

    public Programm() {
        List<String> listPrize = new LinkedList<>(Arrays.asList("Empty", "Empty", "Prize"));
        Collections.shuffle(listPrize);
        this.door1 = new Door("Door1", listPrize.get(0));
        this.door2 = new Door("Door2", listPrize.get(1));
        this.door3 = new Door("Door3", listPrize.get(2));
//        this.random = new Random();
    }

    public void checkExeption(Integer numValue) throws ExeptionDoor {
        if (numValue < 0 || numValue > 3) {
            throw new ExeptionDoor(scanner.nextInt());
        }
    }
    public void doorSelection(int number) {
        switch (number) {
            case 1:
                System.out.println("Вы выбрали 1 дверь: " + checkNumberPrize(door1));
                door1.setOpen(true);
                countOpened++;
                break;
            case 2:
                System.out.println("Вы выбрали 2 дверь: " + checkNumberPrize(door2));
                door2.setOpen(true);
                countOpened++;
                break;
            case 3:
                System.out.println("Вы выбрали 3 дверь: " + checkNumberPrize(door3));
                door3.setOpen(true);
                countOpened++;
                break;
        }
    }
    public String checkNumberPrize(Door door) {
        String result;
        if (door.getPrize() == "Empty") {
            return result = "Тут пусто";
        } else {
            return door.getPrize();
        }
    }
    public void start() {
        while (!door1.isOpen() || !door2.isOpen() || !door3.isOpen()) {
            try {
                System.out.println("Выберите дверь которую вы хотите открыть: 1,  2 или 3");
                scanner = new Scanner(System.in);
                int number = scanner.nextInt();
                if (scanner.hasNextLine()) scanner.nextLine();
                checkExeption(number);
                if (door1.isOpen() || door2.isOpen() || door3.isOpen() && countOpened < 3) {
                    countOpened++;
                    System.out.println("Вы хотите перевыбрать другую дверь?");
                    System.out.println("1 - Да");
                    System.out.println("2 - Нет");
                    int select = scanner.nextInt();
                    switch (select){
                        case 1:
                            System.out.println("Сделайте выбор еще раз: 1,  2 или 3");
                            number = scanner.nextInt();
                            if (scanner.hasNextLine()) scanner.nextLine();
                            checkExeption(number);
                            break;
                        case 2:
                            break;
                    }

                }
                System.out.println("Нажмите 0 для выхода");
                if (number < 0 || number > 3) throw new ExeptionDoor(number);
                if (number == 0) break;
                doorSelection(number);
            } catch (ExeptionDoor e) {
                throw new RuntimeException(e);
            }
        }
    }
}
