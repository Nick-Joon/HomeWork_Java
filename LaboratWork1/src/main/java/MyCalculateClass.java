import java.util.Date;
import java.util.Scanner;

public class MyCalculateClass {
    public static void main(String[] args) 
    {
       MyCalculateClass laba1 = new MyCalculateClass();
       laba1.Run();
    }
        
    public double a = 0.7;
    public double b = 0.05;
    public double x = 0.5;
    
    public double R = 0; 
    public double S = 0;
    
    private void Calculate_R()
    {
        R = (Math.pow(x, 2)*(x + 1))/b - Math.sin(Math.sin(x + a));
    }
    
    private void Calculate_S()
    {
        S = Math.sqrt((x * b)/a) + Math.pow(Math.cos(Math.pow((x + b),3)),2);
    }
    
    private void DisplayData()
    {
        System.out.println("Входные данные:");
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("x = " + x);
        
        System.out.println("Результаты:");
        System.out.println("R = " + R);
        System.out.println("S = " + S);
    }
    
    private void DateShow()
    {
        System.out.printf("%1$ty-%1$tm-%1$td", new Date());
    }
    
    private void DataEnter()
    {
       Scanner scanner = new Scanner(System.in);
       System.out.print("Введите a: ");
       a = scanner.nextDouble();
       System.out.print("Введите b: ");
       b = scanner.nextDouble();
       System.out.print("Введите x: ");
       x = scanner.nextDouble();
    }
    
    private void Run()
    {
        DataEnter();
        Calculate_R();
        Calculate_S();
        DisplayData();
        DateShow();
    }
}
