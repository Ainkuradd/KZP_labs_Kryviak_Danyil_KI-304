package Lab2Project.Gruppa.Prizvische.Lab3;
/**
 * Клас-драйвер для демонстрації роботи офісного центру.
 */

public class Main {
    public static void main(String[] args) {
        OfisnyjCentr ofis = new OfisnyjCentr();
        ofis.showInfo();

        ofis.startWork();
        ofis.addEmployees(20);
        ofis.removeEmployees(5);
        ofis.showInfo();
        ofis.endWork();

       /* Room room = new Room("big (4)", 50.0);
        Door door = new Door("wooden (2)");
        Window window = new Window("plastic (6)", 4);
*/
        ofis.destroy(); // закриваємо лог-файл
         
    

   
}
    }

