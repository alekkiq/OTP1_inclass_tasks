package TemperatureConverter;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

class TemperatureConverterTest {
    TemperatureConverter converter = new TemperatureConverter();

    @Test
    @DisplayName("F to C: happy path (basic values)")
    void fahrenHeitToCelsius_happyPath() {
        double value1 = 32.0;
        double value2 = 0.0;
        double value3 = -25.7;

        double result1 = this.converter.fahrenHeitToCelsius(value1);
        double result2 = this.converter.fahrenHeitToCelsius(value2);
        double result3 = this.converter.fahrenHeitToCelsius(value3);

        assertEquals(0, result1, "32F should be 0C");
        assertEquals(-17.78, result2, 0.01, "0F should be approximately -17.7778C");
        assertEquals(-32.05, result3, 0.01, "-25.7F should be approximately -32.0556C");
    }

    @Test
    @DisplayName("C to F: happy path (basic values)")
    void celsiusToFahrenheit_happyPath() {
        double value1 = 0.0;
        double value2 = 100.0;
        double value3 = -40.0;

        double result1 = this.converter.celsiusToFahrenheit(value1);
        double result2 = this.converter.celsiusToFahrenheit(value2);
        double result3 = this.converter.celsiusToFahrenheit(value3);

        assertEquals(32, result1, 0.01, "0C should be 32F");
        assertEquals(212, result2, 0.01, "100C should be 212F");
        assertEquals(-40, result3, 0.01, "-40C should be -40F");
    }

    @Test
    @DisplayName("Extreme temps: happy path (basic values)")
    void isExtremeTemperature() {
        double value1 = -50.0;
        double value2 = 20.0;
        double value3 = 60.0;

        boolean result1 = this.converter.isExtremeTemperature(value1);
        boolean result2 = this.converter.isExtremeTemperature(value2);
        boolean result3 = this.converter.isExtremeTemperature(value3);

        assertTrue(result1, "-50C should be extreme");
        assertFalse(result2, "20C should not be extreme");
        assertTrue(result3, "60C should be extreme");
    }

    @Test
    @DisplayName("F to C: edge cases")
    void fahrenHeitToCelsius_edgeCases() {
        double value1 = -459.67;    // absolute zero in F
        double value2 = 212.0;      // boiling point of water in F

        double result1 = this.converter.fahrenHeitToCelsius(value1);
        double result2 = this.converter.fahrenHeitToCelsius(value2);

        assertEquals(-273.15, result1, 0.01, "-459.67F should be approximately -273.15C");
        assertEquals(100.0, result2, 0.01, "212F should be 100C");
    }

    @Test
    @DisplayName("C to F: edge cases")
    void celsiusToFahrenheit_edgeCases() {
        double value1 = -273.15;    // absolute zero in C
        double value2 = 100.0;      // boiling point of water in C

        double result1 = this.converter.celsiusToFahrenheit(value1);
        double result2 = this.converter.celsiusToFahrenheit(value2);

        assertEquals(-459.67, result1, 0.01, "-273.15C should be approximately -459.67F");
        assertEquals(212.0, result2, 0.01, "100C should be 212F");
    }

    @Test
    @DisplayName("Extreme temps: edge cases")
    void isExtremeTemperature_edgeCases() {
        double value1 = -40.0;
        double value2 = 50.0;
        double value3 = -40.01;
        double value4 = 50.01;

        boolean result1 = this.converter.isExtremeTemperature(value1);
        boolean result2 = this.converter.isExtremeTemperature(value2);
        boolean result3 = this.converter.isExtremeTemperature(value3);
        boolean result4 = this.converter.isExtremeTemperature(value4);

        assertFalse(result1, "-40C should not be extreme");
        assertFalse(result2, "50C should not be extreme");
        assertTrue(result3, "-40.01C should be extreme");
        assertTrue(result4, "50.01C should be extreme");
    }
}