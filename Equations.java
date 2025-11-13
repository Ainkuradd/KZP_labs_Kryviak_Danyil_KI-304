import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

class Equations 
{ 
    private double result;

    public void writeResTxt(String fName) throws FileNotFoundException { 
        PrintWriter f = new PrintWriter(fName); 
        f.printf("%f ", result); 
        f.close(); 
    } 
  
    public void readResTxt(String fName) { 
        try { 
            File f = new File(fName); 
            if (f.exists()) { 
                Scanner s = new Scanner(f); 
                result = s.nextDouble(); 
                s.close(); 
            } else { 
                throw new FileNotFoundException("File " + fName + " not found"); 
            } 
        } catch (FileNotFoundException ex) { 
            System.out.print(ex.getMessage()); 
        } 
    } 
  
    public void writeResBin(String fName) throws IOException { 
        DataOutputStream f = new DataOutputStream(new FileOutputStream(fName)); 
        f.writeDouble(result); 
        f.close(); 
    } 
   
    public void readResBin(String fName) throws IOException { 
        DataInputStream f = new DataInputStream(new FileInputStream(fName)); 
        result = f.readDouble(); 
        f.close(); 
    } 
  
    public double calculate(double x) throws IOException { 
        double y, rad; 
        rad = x * Math.PI / 180.0; 
  
        try { 
            y = Math.tan(rad) * Math.tan(rad); 
   
            if (Double.isNaN(y) || Double.isInfinite(y) || x == 90 || x == -90)  
                throw new ArithmeticException(); 
        } 
        catch (ArithmeticException ex) { 
            if (rad == Math.PI / 2.0 || rad == -Math.PI / 2.0) 
                throw new IOException("Exception reason: Illegal value of X for tangent calculation"); 
            else if (x == 0) 
                throw new IOException("Exception reason: X = 0"); 
            else 
                throw new IOException("Unknown reason of the exception during calculation"); 
        } 
   
        result = y;
        return y; 
    } 
  
    public double getResult() { 
        return result; 
    } 
}
