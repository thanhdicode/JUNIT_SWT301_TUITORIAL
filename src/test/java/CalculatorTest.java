import static org.junit.jupiter.api.Assertions.*;

import org.example.Math.Calculator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class CalculatorTest {

    private Calculator calculator = new Calculator();

    @ParameterizedTest
    @CsvFileSource(resources = "/calculator_data.csv", numLinesToSkip = 1)
    public void testAdditionFromFile(int a, int b, int result) {
        assertEquals(result, calculator.add(a, b));
    }

    // You can add similar tests for subtraction, multiplication, and division
}
