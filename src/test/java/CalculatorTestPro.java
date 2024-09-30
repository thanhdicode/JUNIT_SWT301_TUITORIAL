import static org.junit.jupiter.api.Assertions.*;
import org.example.Math.Calculator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class tests the functionality of the Calculator class using
 * parameterized tests. It reads input values and operation types from a CSV file,
 * performs the specified operation using the Calculator, and compares the result
 * with expected values, logging all the steps.
 */
public class CalculatorTestPro {

    // Logger for logging the steps
    private static final Logger logger = LoggerFactory.getLogger(CalculatorTest.class);

    // Instance of the Calculator class that will be tested
    private Calculator calculator = new Calculator();

    /**
     * Tests the functionality of the Calculator class for multiple operations.
     * It reads values and operation type from a CSV file, performs the specified
     * operation, and asserts that the result matches the expected result.
     *
     * @param operation the type of operation to be performed (add, subtract, multiply, divide)
     * @param a         the first operand (read from the CSV file)
     * @param b         the second operand (read from the CSV file)
     * @param result    the expected result of the operation (read from the CSV file)
     */
    @ParameterizedTest
    @CsvFileSource(resources = "/calculator_data.csv", numLinesToSkip = 1)
    public void testCalculatorFromFile(String operation, int a, int b, int result) {
        logger.info("Starting test: operation={}, a={}, b={}, expected result={}", operation, a, b, result);

        if ("divide".equals(operation) && b == 0) {
            logger.warn("Testing division by zero, expecting ArithmeticException");
            assertThrows(ArithmeticException.class, () -> calculator.divide(a, b));
            logger.info("Division by zero threw ArithmeticException as expected");
        } else {
            int actualResult = 0;

            // Determine which operation to perform based on the operation parameter
            switch (operation) {
                case "add":
                    logger.debug("Performing addition: {} + {}", a, b);
                    actualResult = calculator.add(a, b);
                    break;
                case "subtract":
                    logger.debug("Performing subtraction: {} - {}", a, b);
                    actualResult = calculator.subtract(a, b);
                    break;
                case "multiply":
                    logger.debug("Performing multiplication: {} * {}", a, b);
                    actualResult = calculator.multiply(a, b);
                    break;
                case "divide":
                    logger.debug("Performing division: {} / {}", a, b);
                    actualResult = calculator.divide(a, b);
                    break;
                default:
                    logger.error("Unknown operation: {}", operation);
                    fail("Unknown operation: " + operation);
            }

            logger.info("Actual result: {}, Expected result: {}", actualResult, result);
            assertEquals(result, actualResult);
            logger.info("Test passed successfully.");
        }
    }
}
