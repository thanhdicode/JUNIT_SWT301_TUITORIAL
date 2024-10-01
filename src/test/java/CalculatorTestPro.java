import static org.junit.jupiter.api.Assertions.*;
import org.example.Math.Calculator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class CalculatorTestPro {

    private static final Logger logger = LoggerFactory.getLogger(CalculatorTestPro.class);
    private final Calculator calculator = new Calculator();

    
    private static final String RESET = "\033[0m";
    private static final String GREEN = "\033[0;32m";  // For PASS/INFO
    private static final String RED = "\033[0;31m";    // For ERROR/FAIL
    private static final String YELLOW = "\033[0;33m"; // For WARN
    private static final String BLUE = "\033[0;34m";   // For DEBUG

    
    @ParameterizedTest
    @CsvFileSource(resources = "/calculator_data.csv", numLinesToSkip = 1)
    public void testCalculatorFromFile(String operation, int a, int b, int result) {
        logger.info(GREEN + "Starting test: operation={}, a={}, b={}, expected result={}" + RESET, operation, a, b, result);

        try {
            int actualResult = 0;

            switch (operation) {
                case "add":
                    logger.debug(BLUE + "Performing addition: {} + {}" + RESET, a, b);
                    actualResult = calculator.add(a, b);
                    break;
                case "subtract":
                    logger.debug(BLUE + "Performing subtraction: {} - {}" + RESET, a, b);
                    actualResult = calculator.subtract(a, b);
                    break;
                case "multiply":
                    logger.debug(BLUE + "Performing multiplication: {} * {}" + RESET, a, b);
                    actualResult = calculator.multiply(a, b);
                    break;
                case "divide":
                    if (b == 0) {
                        logger.warn(YELLOW + "Division by zero detected, expecting ArithmeticException" + RESET);
                        assertThrows(ArithmeticException.class, () -> calculator.divide(a, b));
                        logger.info(GREEN + "Division by zero threw ArithmeticException as expected" + RESET);
                        return;
                    } else {
                        logger.debug(BLUE + "Performing division: {} / {}" + RESET, a, b);
                        actualResult = calculator.divide(a, b);
                    }
                    break;
                default:
                    logger.error(RED + "Unknown operation: {}" + RESET, operation);
                    fail("Unknown operation: " + operation);
            }

            logger.info(GREEN + "Actual result: {}, Expected result: {}" + RESET, actualResult, result);
            assertEquals(result, actualResult);
            logger.info(GREEN + "Test passed successfully." + RESET);

        } catch (ArithmeticException ae) {
            logger.error(RED + "Caught ArithmeticException: {}" + RESET, ae.getMessage());
            fail("Test failed due to ArithmeticException: " + ae.getMessage());
        } catch (Exception e) {
            logger.error(RED + "Unexpected exception caught: {}" + RESET, e.getMessage());
            fail("Test failed due to an unexpected exception: " + e.getMessage());
        }
    }
}
