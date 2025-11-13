
public class Pencil implements Item {
    private String brand;
    private double length;

    public Pencil(String brand, double length) {
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
        System.out.println("Олівець: " + brand + ", довжина: " + length + " см");
    }
}
