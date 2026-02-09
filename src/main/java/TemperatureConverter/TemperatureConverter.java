package TemperatureConverter;

public class TemperatureConverter {
    public double fahrenHeitToCelsius(double f) {
        return (f - 32) * 5 / 9;
    }

    public double celsiusToFahrenheit(double c) {
        return (c * 9 / 5) + 32;
    }

    public boolean isExtremeTemperature(double c) {
        return c < -40 || c > 50;
    }
}
