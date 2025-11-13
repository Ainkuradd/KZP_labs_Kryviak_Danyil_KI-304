package Lab2Project.Gruppa.Prizvische.Lab2;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Budynok {
    private List<Room> rooms;
    private Door door;
    private Window window;
    private FileWriter logWriter;

    public Budynok() {
        this.rooms = new ArrayList<>();
        this.door = new Door("Дерев’яні");
        this.window = new Window("Пластикове", 2);
        initLog();
        log("Створено будинок за замовчуванням.");
    }

    public Budynok(Door door, Window window) {
        this.rooms = new ArrayList<>();
        this.door = door;
        this.window = window;
        initLog();
        log("Створено будинок з вказаними дверима та вікнами.");
    }

    private void initLog() {
        try {
            logWriter = new FileWriter("house_log.txt", true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void log(String message) {
        try {
            logWriter.write(LocalDateTime.now() + " - " + message + "\n");
            logWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addRoom(Room room) {
        rooms.add(room);
        log("Додано кімнату: " + room.getName());
    }

    public void openDoor() {
        door.open();
        log("Двері відкрито.");
    }

    public void closeDoor() {
        door.close();
        log("Двері закрито.");
    }

    public void openWindow() {
        window.open();
        log("Вікна відкрито.");
    }

    public void closeWindow() {
        window.close();
        log("Вікна закрито.");
    }

    public void showInfo() {
        for (Room room : rooms) {
            String info = "Будинок має: " + room.getName() + " (" + room.getArea() + " м²), двері "
                    + door.getType() + ", вікна " + window.getType() + " (" + window.getCount() + ")";
            System.out.println(info);
            log("Виведено інформацію: " + info);
        }
    }

    public void finalizeHouse() {
        try {
            if (logWriter != null) {
                logWriter.close();
                System.out.println("Файл журналу закрито.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
