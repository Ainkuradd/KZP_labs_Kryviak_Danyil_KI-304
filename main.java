import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Програма будує квадратну матрицю із символів
 * і виводить заштриховану нижню праву половину (трикутник під діагоналлю).
 *
 * @author  Danyil Kryviak
 * @version 1.2
 */
public class main {
    public static void main(String[] args) throws FileNotFoundException {
        int nRows;            // розмір квадратної матриці
        String filler;        // символ-заповнювач

        Scanner in = new Scanner(System.in);     // для зчитування з консолі
        File dataFile = new File("MyFile.txt"); // файл для збереження результату
        PrintWriter fout = new PrintWriter(dataFile);

        // зчитування розміру матриці
        System.out.print("Введіть розмір квадратної матриці: ");
        nRows = in.nextInt();
        in.nextLine(); // зчитуємо залишковий \n після числа

        // зчитування символу-заповнювача
        System.out.print("Введіть символ-заповнювач: ");
        filler = in.nextLine();

        // перевірка, що введений тільки один символ
        if (filler.length() != 1) {
            System.out.println("Потрібно ввести рівно один символ!");
            fout.close();
            return;
        }

        // беремо символ із рядка
        char symbol = filler.charAt(0);

        // головний цикл: перебираємо рядки
        for (int i = 0; i < nRows; i++) {
            // внутрішній цикл: перебираємо стовпці
            for (int j = 0; j < nRows; j++) {
                // умова для нижнього правого трикутника
                if (j >= nRows - 1 - i) {
                    System.out.print(symbol + " ");  // друкуємо символ на екран
                    fout.print(symbol + " ");        // друкуємо символ у файл
                } else {
                    System.out.print("  ");          // пробіли для вирівнювання на екран
                    fout.print("  ");                // пробіли у файл
                }
            }
            System.out.println();  // новий рядок на екрані
            fout.println();        // новий рядок у файлі
        }

        fout.flush();   // записати все у файл
        fout.close();   // закрити файл
        System.out.println("Результат збережено у файл MyFile.txt");
    }
}
