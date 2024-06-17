package org.example;

public class Door {
    private String namberDoor;
    private boolean open = false;
    private String prize;

    public Door(String name, String prize) {
        this.namberDoor = name;
        this.prize = prize;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public String getNamberDoor() {
        return namberDoor;
    }

    public String getPrize() {
        return prize;
    }
}
