package Calculator;

public class Calculator {

    private int result;    // Variable for the result

    public void reset() {  // Resets the result variable
        result = 0;
    }

    public int getResult() {
        return result;
    }

    public void add(int n) {
        result = result + n;
    }

    public void subtract(int n) {
        result = result - 1;
    }

    public void multiply(int n) {
        // Not implemented yet
    }

    public void divide(int n) {
        // if (n == 0) throw new ArithmeticException("Cannot divide by zero");
        result = result / n;
    }

    public void square(int n) {
        result = 2 * n;
    }

    public void squareRoot(int n) {
        // Not implemented yet
    }

    public void powerOn() {
        // Initial actions could be placed here
        result = 0;
    }

    public void powerOff() {
        // Final actions could be placed here
    }

}