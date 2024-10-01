import static org.junit.jupiter.api.Assertions.*;

import org.example.Math.Calculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatorAdditionalTest {

    private Calculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void testAdditionWithNegativeNumbers() {
        assertEquals(-1, calculator.add(-2, 1));
        assertEquals(0, calculator.add(-1, 1));
        assertEquals(-3, calculator.add(-1, -2));
    }

    @Test
    public void testSubtractionWithNegativeNumbers() {
        assertEquals(-3, calculator.subtract(-2, 1));
        assertEquals(1, calculator.subtract(1, 0));
        assertEquals(1, calculator.subtract(-1, -2));
    }

    @Test
    public void testMultiplicationWithNegativeNumbers() {
        assertEquals(-6, calculator.multiply(-2, 3));
        assertEquals(2, calculator.multiply(-1, -2));
        assertEquals(0, calculator.multiply(0, 5));
    }

    @Test
    public void testDivisionWithNegativeNumbers() {
        assertEquals(-2, calculator.divide(-6, 3));
        assertEquals(2, calculator.divide(-6, -3));
        assertThrows(ArithmeticException.class, () -> calculator.divide(1, 0));
    }

    @Test
    public void testLargeNumbers() {
        assertEquals(1000000000, calculator.add(500000000, 500000000));
        assertEquals(0, calculator.subtract(500000000, 500000000));
        assertEquals(6, calculator.multiply(2, 3)); // Changed first argument to long
        assertEquals(2, calculator.divide(1000000000, 500000000));
    }
}