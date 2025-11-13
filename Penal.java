
import java.util.ArrayList;

public class Penal<T extends Item> {
    private ArrayList<T> items;

    public Penal() {
        items = new ArrayList<T>();
    }

    public void addItem(T item) {
        items.add(item);
        System.out.print("Додано предмет: ");
        item.print();
    }

    public void removeItem(int i) {
        items.remove(i);
    }

    // Пошук мінімального елемента (оскільки варіант парний)
    public T findMin() {
        if (!items.isEmpty()) {
            T min = items.get(0);
            for (int i = 1; i < items.size(); i++) {
                if (items.get(i).compareTo(min) < 0) {
                    min = items.get(i);
                }
            }
            return min;
        }
        return null;
    }
}
