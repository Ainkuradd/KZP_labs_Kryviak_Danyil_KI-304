package Lab2Project.Gruppa.Prizvische.Lab3;

/**
 * Клас, що описує Офісний центр.
 * Є підкласом {@link Budynok} і реалізує інтерфейс {@link Workable}.
 */
import java.io.FileWriter;
import java.io.IOException;

public class OfisnyjCentr extends Budynok implements Workable {
    private int numberOfOffices;
    private int employees;
    private FileWriter logWriter;

    public OfisnyjCentr(Room room, Door door, Window window, int numberOfOffices, int employees) {
        super(door, window);
        this.numberOfOffices = numberOfOffices;
        this.employees = employees;
        try {
            logWriter = new FileWriter("house_log.txt", true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        log("[LOG] Створено офісний центр із параметрами.");
    }

    public OfisnyjCentr() {
        super();
        this.numberOfOffices = 10;
        this.employees = 100;
        try {
            logWriter = new FileWriter("house_log.txt", true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        log("[LOG] Створено офісний центр за замовчуванням.");
    }

    protected void log(String message) {
        System.out.println(message);
        if (logWriter != null) {
            try {
                logWriter.write(message + "\n");
                logWriter.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void destroy() {
        log("Офісний центр закрито. Лог-файл закрито.");
        if (logWriter != null) {
            try {
                logWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void showInfo() {
        String info = "Офісний центр: кімната - " + room.getName() + " (" + room.getArea() + " м²), двері " +
                door.getType() + ", вікна " + window.getType() + " (" + window.getCount() +
                "), кількість офісів: " + numberOfOffices + ", працівників: " + employees;
        log(info);
        log("[LOG] Виведено інформацію: " + info);
    }

    @Override
    public void startWork() {
        log("[LOG] Робочий день у офісному центрі розпочато.");
        log("Офісний центр почав роботу!");
    }

    @Override
    public void endWork() {
        log("[LOG] Робочий день у офісному центрі завершено.");
        log("Офісний центр завершив роботу!");
    }

    public void addEmployees(int count) {
        this.employees += count;
        log("[LOG] Додано працівників: " + count + ". Загальна кількість: " + employees);
    }

    public void removeEmployees(int count) {
        this.employees -= count;
        if (employees < 0) employees = 0;
        log("[LOG] Звільнено працівників: " + count + ". Загальна кількість: " + employees);
    }
}