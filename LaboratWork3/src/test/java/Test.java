import static org.junit.Assert.*;
import static java.lang.Math.*;

public class Test {
    @org.junit.Test
    public void TestConst(){
        Function a = new ConstFunction(6);
        Function b = new ConstFunction(14);

        assertEquals(a.calculate(0),6.0,0.00001);
        assertEquals(b.calculate(1),14.0,0.00001);

        assertEquals(a.derivative().calculate(1), 0,0.00001);
        assertEquals(b.derivative().calculate(0), 0,0.00001);

    }
    @org.junit.Test
    public void TestLinear(){
        Function a = new LinearFunction(10);
        Function b = new LinearFunction(8);

        assertEquals(a.calculate(10),100.0,0.00001);
        assertEquals(b.calculate(5),40.0,0.00001);

        assertEquals(a.derivative().calculate(10), 10.0,0.00001);
        assertEquals(b.derivative().calculate(25), 8.0,0.00001);

    }
    @org.junit.Test
    public void TestSin(){
        Function a = new ConstFunction(0);
        Function a1 = new LinearFunction(2);
        Function b = new SinFunction(a);
        Function b1 = new SinFunction(a1);

        assertEquals(b.calculate(10),sin(0),0.00001);
        assertEquals(b1.calculate(10),sin(20),0.00001);


        assertEquals(b.derivative().calculate(10), 0,0.00001);
        assertEquals(b1.derivative().calculate(10), cos(20)*2,0.00001);
    }
    @org.junit.Test
    public void TestCos(){
        Function a = new ConstFunction(0);
        Function a1 = new LinearFunction(48);
        Function b = new CosFunction(a);
        Function b1 = new CosFunction(a1);

        assertEquals(b.calculate(10),cos(0),0.00001);
        assertEquals(b1.calculate(10),cos(480),0.00001);

        assertEquals(b.derivative().calculate(10), -sin(0),0.00001);
        assertEquals(b1.derivative().calculate(10), -sin(480)*48,0.00001);
    }
    @org.junit.Test
    public void TestPower(){
        Function a = new ConstFunction(10);
        Function a1 = new LinearFunction(2);
        Function b = new PowerFunction(3, a);
        Function b1 = new PowerFunction(3, a1);

        assertEquals(b.calculate(10),1000,0.00001);
        assertEquals(b1.calculate(10),8000,0.00001);


        assertEquals(b.derivative().calculate(10), 0,0.00001);
        assertEquals(b1.derivative().calculate(10), 2*3*pow(20,2),0.00001);
    }
    @org.junit.Test
    public void TestMult(){
        Function a = new ConstFunction(3);
        Function c = new LinearFunction(2);
        Function b = new MultFunction(a, c);
        Function b1 = new MultFunction(c, c);

        assertEquals(b.calculate(10),60,0.00001);
        assertEquals(b1.calculate(10),400,0.00001);

        assertEquals(b.derivative().calculate(10), 2*3,0.00001);
        assertEquals(b1.derivative().calculate(10), 2*20+20*2,0.00001);
    }
    @org.junit.Test
    public void TestSum(){
        Function a = new ConstFunction(9);
        Function c = new LinearFunction(3);
        Function b = new SumFunction(a, c);
        Function b1 = new SumFunction(c, c);

        assertEquals(b.calculate(10),39,0.00001);
        assertEquals(b1.calculate(10),60,0.00001);

        assertEquals(b.derivative().calculate(10), 3,0.00001);
        assertEquals(b1.derivative().calculate(10), 3+3,0.00001);
    }
    @org.junit.Test
    public void TestFrac(){
        Function a = new ConstFunction(8);
        Function c = new LinearFunction(7);
        Function b = new FracFunction(a, c);
        Function b1 = new FracFunction(c, c);

        assertEquals(b.calculate(10),8.0/70,0.00001);
        assertEquals(b1.calculate(10),70.0/70,0.00001);

        assertEquals(b.derivative().calculate(10), -8.0/700,0.00001);
        assertEquals(b1.derivative().calculate(10), 0,0.00001);
    }
    @org.junit.Test
    public void TestDiff(){
        Function a = new ConstFunction(7);
        Function c = new LinearFunction(3);
        Function c1 = new LinearFunction(9);
        Function b = new DiffFunction(a, c);
        Function b1 = new DiffFunction(c1, c);


        assertEquals(b.calculate(10),-23,0.00001);
        assertEquals(b1.calculate(10),60,0.00001);

        assertEquals(b.derivative().calculate(10), -3,0.00001);
        assertEquals(b1.derivative().calculate(10), 6,0.00001);
    }
}
