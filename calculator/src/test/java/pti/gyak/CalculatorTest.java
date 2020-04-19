package pti.gyak;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculatorTest {
    @Test
    public void testResult() {
        assertEquals(6.0, (new Calculator()).enter(5).enter(Operation.ADD).enter(1).getResult());
    }

    @Test
    public void testHistory() {
        assertEquals("5 + 1 = 6", (new Calculator()).enter(5).enter(Operation.ADD).enter(1).getHistory());
    }
    @Test
    public void testClear() {
        assertEquals(0, (new Calculator().enter(Operation.CLEAR).getResult()));
    }

    @Test
    public void testOperators() {
        assertEquals(3.0, (new Calculator().enter(9).enter(Operation.SQRT).getResult()));
        assertEquals(3.0, (new Calculator()).enter(6).enter(Operation.SUBSTRACT).enter(3).getResult());
        assertEquals(9.0, (new Calculator()).enter(3).enter(Operation.MULTIPLY).enter(3).getResult());
        assertEquals(2.0, (new Calculator()).enter(6).enter(Operation.DIVIDE).enter(3).getResult());
        assertEquals(0.0, (new Calculator()).enter(6).enter(Operation.REMAINDER).enter(3).getResult());
        assertEquals(8.0, (new Calculator()).enter(2).enter(Operation.POWER).enter(3).getResult());
    }
    
    @Test
    public void testPositive(){
        assertEquals(Double.POSITIVE_INFINITY,new Calculator().enter(4).enter(Operation.DIVIDE).enter(0).getResult());
    }

    @Test
    public void testNegative(){
        assertEquals(Double.NEGATIVE_INFINITY,new Calculator().enter(-4).enter(Operation.DIVIDE).enter(0).getResult());
    }

    @Test
    public void testNumberNull(){
        assertEquals(0,new Calculator().enter((Number) null).getResult());
    }
}