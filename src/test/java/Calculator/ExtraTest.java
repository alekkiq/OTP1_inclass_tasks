package Calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ExtraTest extends AbstractParent {

    private static Calculator calculator = new Calculator();
    private final double DELTA = 0.001;

    @BeforeAll
    public static void testPowerOn() {
        System.out.println("@BeforeAll Power ON (before the first test)");
        calculator.powerOn();
    }

    @AfterAll
    public static void testPowerOff() {
        System.out.println("@AfterAll Power OFF (all tests executed).");
        calculator.powerOff();
        calculator = null;
    }

    @BeforeEach
    public void testReset() {
        System.out.println("  Reset calculator.");
        calculator.reset();
        assertEquals(0, calculator.getResult(), DELTA, "Reset failed");
    }

    @ParameterizedTest
    @CsvSource({
        "2, 4",
        "4, 16",
        "5, 25"
    })
    @DisplayName("Test square with multiple values")
    public void testSquare(double input, double expected) {
        calculator.square(input);
        assertEquals(expected, calculator.getResult(), DELTA, "Squaring number " + input + " is incorrect");
    }

    @ParameterizedTest
    @CsvSource({
        "2, 1.414",
        "4, 2",
        "9, 3",
        "16, 4"
    })
    @DisplayName("Test square root with multiple values")
    public void testSquareRoot(double input, double expected) {
        calculator.squareRoot(input);
        assertEquals(expected, calculator.getResult(), DELTA, "Square root of " + input + " is incorrect");
    }

    @ParameterizedTest
    @CsvSource({
        "-1",
        "-4",
        "-100"
    })
    @DisplayName("Test negative square root throws exception")
    public void testSquareRootNegative(double input) {
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.squareRoot(input);
        }, "Square root of negative number should throw IllegalArgumentException");
    }
}
