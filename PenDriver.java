
public class PenDriver {
    public static void main(String[] args) {
        Penal<? super Item> penal = new Penal<Item>();

        penal.addItem(new Pen("Pilot", 14.5));
        penal.addItem(new Pencil("Faber-Castell", 17.2));
        penal.addItem(new Pen("Bic", 13.0));
        penal.addItem(new Pencil("Koh-I-Noor", 2));

        Item minItem = penal.findMin();
        System.out.println("\nНайменший предмет у пеналі:");
        minItem.print();
    }
}
