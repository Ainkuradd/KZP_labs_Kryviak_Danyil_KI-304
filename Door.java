package Lab2Project.Gruppa.Prizvische.Lab2;

public class Door {
    private String type;
    private boolean isOpen;

    public Door(String type) {
        this.type = type;
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

    public boolean isOpen() {
        return isOpen;
    }
}
