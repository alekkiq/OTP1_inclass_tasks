package TemperatureConverter;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

class TemperatureConverterTest {
    private final double DELTA = 0.01;

    TemperatureConverter converter = new TemperatureConverter();

    @Test
    @DisplayName("F to C: happy path (basic values)")
    void fahrenHeitToCelsius_happyPath() {
        assertEquals(0, this.converter.fahrenHeitToCelsius(32.0), "32F should be 0C");
        assertEquals(-17.78, this.converter.fahrenHeitToCelsius(0.0), DELTA, "0F should be approximately -17.7778C");
        assertEquals(-32.05, this.converter.fahrenHeitToCelsius(-25.7), DELTA, "-25.7F should be approximately -32.0556C");
    }

    @Test
    @DisplayName("C to F: happy path (basic values)")
    void celsiusToFahrenheit_happyPath() {
        assertEquals(32, this.converter.celsiusToFahrenheit(0.0), DELTA, "0C should be 32F");
        assertEquals(212, this.converter.celsiusToFahrenheit(100.0), DELTA, "100C should be 212F");
        assertEquals(-40, this.converter.celsiusToFahrenheit(-40.0), DELTA, "-40C should be -40F");
    }

    @Test
    @DisplayName("K to C: happy path (basic values)")
    void kelvinToCelcius_happyPath() {
        assertEquals(0, this.converter.kelvinToCelsius(273.15), DELTA, "273.15 Kelvin should be 0C");
        assertEquals(47.54, this.converter.kelvinToCelsius(320.69), DELTA, "320.69 Kelvin should be 47.54C");
        assertEquals(-273.15, this.converter.kelvinToCelsius(0), DELTA, "0 kelvin shuld be -273.15C");
        assertEquals(726.85, this.converter.kelvinToCelsius(1000), DELTA, "1000 kelvin should be 726.85C");
    }

    @Test
    @DisplayName("K to C: kelvin below 0 throws error")
    void kelvinToCelsius_kelvinBelowZeroThrowsException() {
        IllegalArgumentException e = assertThrows(
            IllegalArgumentException.class,
            () -> {this.converter.kelvinToCelsius(-5);}
        );
        assertEquals("Negative kelvins are not allowed.", e.getMessage());
    }

    @Test
    @DisplayName("Extreme temps: happy path (basic values)")
    void isExtremeTemperature() {
        assertTrue(this.converter.isExtremeTemperature(-50.0), "-50C should be extreme");
        assertFalse(this.converter.isExtremeTemperature(20.0), "20C should not be extreme");
        assertTrue(this.converter.isExtremeTemperature(60.0), "60C should be extreme");
    }

    @Test
    @DisplayName("F to C: edge cases")
    void fahrenHeitToCelsius_edgeCases() {
        assertEquals(-273.15, this.converter.fahrenHeitToCelsius(-459.67), DELTA, "-459.67F should be approximately -273.15C");
        assertEquals(100.0, this.converter.fahrenHeitToCelsius(212.0), DELTA, "212F should be 100C");
    }

    @Test
    @DisplayName("C to F: edge cases")
    void celsiusToFahrenheit_edgeCases() {
        assertEquals(-459.67, this.converter.celsiusToFahrenheit(-273.15), DELTA, "-273.15C should be approximately -459.67F");
        assertEquals(212.0, this.converter.celsiusToFahrenheit(100), DELTA, "100C should be 212F");
    }

    @Test
    @DisplayName("Extreme temps: edge cases")
    void isExtremeTemperature_edgeCases() {
        assertFalse(this.converter.isExtremeTemperature(-40.0), "-40C should not be extreme");
        assertFalse(this.converter.isExtremeTemperature(50.0), "50C should not be extreme");
        assertTrue(this.converter.isExtremeTemperature(-40.01), "-40.01C should be extreme");
        assertTrue(this.converter.isExtremeTemperature(50.01), "50.01C should be extreme");
    }
}