
public class Pen implements Item {
    private String brand;
    private double length;

    public Pen(String brand, double length) {
        this.brand = brand;
        this.length = length;
    }

    public double getLength() {
        return length;
    }

    public int compareTo(Item other) {
        return Double.compare(this.length, other.getLength());
    }

    public void print() {
        System.out.println("Ручка: " + brand + ", довжина: " + length + " см");
    }
}
