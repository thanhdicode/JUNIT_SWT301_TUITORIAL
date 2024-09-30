import static org.junit.jupiter.api.Assertions.*;
import org.example.Math.Calculator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

/**
 * This class tests the functionality of the Calculator class using
 * parameterized tests. It reads input values from CSV files, performs
 * operations using the Calculator, and compares the result with expected values.
 */
public class CalculatorTest {

    // Instance of the Calculator class that will be tested
    private Calculator calculator = new Calculator();

    /**
     * Tests the addition functionality of the Calculator class.
     * It reads values from a CSV file and asserts that the addition result
     * matches the expected result from the file.
     *
     * @param a      the first operand (read from the CSV file)
     * @param b      the second operand (read from the CSV file)
     * @param result the expected result of adding a and b (read from the CSV file)
     */
    @ParameterizedTest
    @CsvFileSource(resources = "/addition_data.csv", numLinesToSkip = 1)
    public void testAdditionFromFile(int a, int b, int result) {
        // Assert that the sum of a and b matches the expected result from the CSV file
        assertEquals(result, calculator.add(a, b));
    }

    /**
     * Tests the multiplication functionality of the Calculator class.
     * It reads values from a CSV file and asserts that the multiplication result
     * matches the expected result from the file.
     *
     * @param a      the first operand (read from the CSV file)
     * @param b      the second operand (read from the CSV file)
     * @param result the expected result of multiplying a and b (read from the CSV file)
     */
    @ParameterizedTest
    @CsvFileSource(resources = "/multiplication_data.csv", numLinesToSkip = 1)
    public void testMultiplyFromFile(int a, int b, int result) {
        // Assert that the product of a and b matches the expected result from the CSV file
        assertEquals(result, calculator.multiply(a, b));
    }
}
