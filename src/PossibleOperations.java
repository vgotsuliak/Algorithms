public class PossibleOperations {

    public static void main(String[] args) {
        int operationsCount = 0;
        for (int a = 0; a < 9; a++) {
            for (int b = 0; b < 9; b++) {
                for (int operation = 0; operation < 4; operation++) {
                    if (calculate(a, b, operation) == 5) {
                        printOperation(a, b, operation);
                        operationsCount++;
                    }
                }
            }
        }
        System.out.println("\nOperations: " + operationsCount);
    }

    public static int calculate(int a, int b, int operation) {
        int result = 0;
        if (operation == 0) {
            result =  a + b;
        } else if (operation == 1) {
            result = a - b;
        } else if (operation == 2) {
            result = a * b;
        } else {
            if (b != 0) {
                result = a / b;
            }
        }
        return result;
    }

    public static void printOperation(int a, int b, int operation) {
        if (operation == 0) {
            System.out.println(a + " + " + b + " = " + (a + b));
        } else if (operation == 1) {
            System.out.println(a + " - " + b + " = " + (a - b));
        } else if (operation == 2) {
            System.out.println(a + " * " + b + " = " + (a * b));
        } else {
            System.out.println(a + " / " + b + " = " + (a / b));
        }
    }

}
