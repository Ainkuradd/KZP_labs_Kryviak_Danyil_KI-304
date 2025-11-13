package Lab2Project.Gruppa.Prizvische.Lab3;

public class Window {
    private String type;
    private int count;
    private boolean isOpen;

    public Window(String type, int count) {
        this.type = type;
        this.count = count;
        this.isOpen = false;
    }

    public void open() {
        isOpen = true;
    }

    public void close() {
        isOpen = false;
    }

    public String getType() {
        return type;
    }

    public int getCount() {
        return count;
    }

    public boolean isOpen() {
        return isOpen;
    }
}
