import org.example.Math.Calculator;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.logging.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CalculatorTest {

    private static final Logger logger = Logger.getLogger(CalculatorTest.class.getName());
    private Calculator calculator;

    // Spring Boot 3-like colors
    private static final String CYAN_BOLD = "\033[1;36m";  // Bold Cyan
    private static final String YELLOW_BOLD = "\033[1;33m";  // Bold Yellow
    private static final String GREEN_BOLD = "\033[1;32m";  // Bold Green
    private static final String RED_BOLD = "\033[1;31m";    // Bold Red
    private static final String RESET = "\033[0m";          // Reset Color

    @BeforeAll
    public static void beforeAllTests() {
        logger.info(CYAN_BOLD + "=== Starting Calculator Tests ===" + RESET);
    }

    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
        logger.info(YELLOW_BOLD + ">>> Setting up test environment..." + RESET);
    }

    @Test
    @Order(1)
    public void testAddition() {
        logger.info(GREEN_BOLD + "Running test for Addition..." + RESET);
        assertEquals(5, calculator.add(2, 3));
    }

    @Test
    @Order(2)
    public void testSubtraction() {
        logger.info(GREEN_BOLD + "Running test for Subtraction..." + RESET);
        assertEquals(1, calculator.subtract(3, 2));
    }

    @Test
    @Order(3)
    public void testMultiplication() {
        logger.info(GREEN_BOLD + "Running test for Multiplication..." + RESET);
        assertEquals(6, calculator.multiply(2, 3));
    }

    @Test
    @Order(4)
    public void testDivision() {
        logger.info(GREEN_BOLD + "Running test for Division..." + RESET);
        assertEquals(2, calculator.divide(6, 3));
    }

    @Test
    @Order(5)
    public void testDivisionByZero() {
        logger.warning(RED_BOLD + "Running test for Division by Zero..." + RESET);
        assertThrows(ArithmeticException.class, () -> calculator.divide(6, 0));
    }

    @AfterEach
    public void tearDown() {
        logger.info(YELLOW_BOLD + ">>> Test complete, tearing down..." + RESET);
    }

    @AfterAll
    public static void afterAllTests() {
        logger.info(CYAN_BOLD + "=== All Calculator Tests Completed ===" + RESET);
    }
}
