public class Calculator {

    // Method with return (Java)
    public int add(int a, int b) {
        int sum = a + b;
        return sum;
    }

    public static void main(String[] args) {
        // Creating an instance of the Calculator class
        Calculator calculator = new Calculator();

        // Using the add method to perform addition
        int result = calculator.add(5, 7);
        int sum = result;

        // Printing the result of the addition
        System.out.println("The sum is 1: " + result);
        System.out.println("the variable sum is " + sum);
    }
}