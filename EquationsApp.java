import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.Scanner; 
 
public class EquationsApp { 
  
  public static void main(String[] args)  
 { 
  try 
  { 
   out.print("Enter file name: "); 
   Scanner in = new Scanner(System.in); 
   String fName = in.nextLine(); 
   PrintWriter fout = new PrintWriter(new File(fName)); 
   try 
   { 
    try 
    {  
     Equations eq = new Equations(); 
     out.print("Enter X: "); 
     fout.print(eq.calculate(in.nextInt())); 
    } 
    finally 
    { 
     // Цей блок виконається за будь-яких обставин 
     fout.flush(); 
     fout.close(); 
    } 
   } 
   catch (CalcException ex) 
   { 
    // Блок перехоплює помилки обчислень виразу 
    out.print(ex.getMessage()); 
   } 
  } 
  catch (FileNotFoundException ex) 
  { 
// Блок перехоплює помилки роботи з файлом навіть якщо вони 
// виникли у блоці finally 
   out.print("Exception reason: Perhaps wrong file path"); 
  } 
 } 
}  
 
 

class CalcException extends ArithmeticException 
{ 
 public CalcException(){} 
 
 public CalcException(String cause) 
 { 
  super(cause); 
 } 
} 
 
class Equations 
{ 
 
 public double calculate(int x) throws CalcException 
 { 
  double y, rad; 
  rad = x * Math.PI / 180.0; 
 
  try 
  { 
   y = (Math.tan(rad) * Math.tan(rad)); 
   
   // Якщо результат не є числом, то генеруємо виключення 
   if (y==Double.NaN || y==Double.NEGATIVE_INFINITY || 
y==Double.POSITIVE_INFINITY || x==90 || x== -90) 
    throw new ArithmeticException(); 
  } 
  catch (ArithmeticException ex) 
  { 
// створимо виключення вищого рівня з поясненням причини 
// виникнення помилки 
   if (rad==Math.PI/2.0 || rad==-Math.PI/2.0) 
    throw new CalcException("Exception reason: Illegal value of X for tangent calculation"); 
   else if (x==0) 
    throw new CalcException("Exception reason: X = 0"); 
   else 
    throw new CalcException("Unknown reason of the exception during exception calculation"); 
  } 
   
  return y; 
 } 
}  
