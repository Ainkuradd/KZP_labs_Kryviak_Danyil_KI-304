package Lab2Project.Gruppa.Prizvische.Lab2;

public class Main {
    public static void main(String[] args) {
        Budynok house = new Budynok();
        house.addRoom(new Room("Вітальня", 20));
        house.addRoom(new Room("Кухня", 15));
        house.showInfo();

        house.openDoor();
        house.closeDoor();
        house.openWindow();
        house.closeWindow();

        house.finalizeHouse();
    }
}

