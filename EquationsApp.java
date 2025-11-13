import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class EquationsApp { 
    public static void main(String[] args) throws FileNotFoundException, IOException { 
        Equations obj = new Equations(); 
        Scanner s = new Scanner(System.in); 
        System.out.print("Enter data: "); 
        double data = s.nextDouble(); 
        s.close();

        obj.calculate(data); 
        System.out.println("Result is: " + obj.getResult()); 

        obj.writeResTxt("textRes.txt"); 
        obj.writeResBin("BinRes.bin"); 

        obj.readResBin("BinRes.bin"); 
        System.out.println("Result (from bin): " + obj.getResult()); 

        obj.readResTxt("textRes.txt"); 
        System.out.println("Result (from txt): " + obj.getResult()); 
    } 
}
