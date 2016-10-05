package loops;

public class PossibleOperations2 {

    public static void main(String[] args) {
        int operationsCount = 0;
        for (int a = 0; a < 9; a++) {
            for (int b = 0; b < 9; b++) {
                for (int c = 0; c < 9; c++) {
                    for (int operation1 = 0; operation1 < 4; operation1++) {
                        for (int operation2 = 0; operation2 < 4; operation2++) {
                            int result;
                            if (operation2 == 2 || operation2 == 3) {
                                int part2 = calculate(b, c, operation2);
                                result = calculate(a, part2, operation1);
                            } else {
                                int part1 = calculate(a, b, operation1);
                                result = calculate(part1, c, operation2);
                            }
                            if (result == 5) {
                                printOperation(a, b, c, operation1, operation2, result);
                                operationsCount++;
                            }
                        }
                    }
                }
            }
        }
        System.out.println("\n Operations count: " + operationsCount);
    }

    public static int calculate(int a, int b, int operation) {
        int result = 0;
        if (operation == 0) {
            result = a + b;
        } else if (operation == 1) {
            result = a - b;
        } else if (operation == 2) {
            result = a * b;
        } else {
            if (b == 0) {
                return 99999;
            }
            result = a / b;
            if (a % b != 0) {
                result = 99999;
            }
        }
        return result;
    }

    public static void printOperation(int a, int b, int c, int operation1, int operation2, int result) {
        String stringOperation1 = getOperation(operation1);
        String stringOperation2 = getOperation(operation2);
        System.out.println(a + " " + stringOperation1 + " " + b + " " + stringOperation2 + " " + c + " = " + result);
    }

    public static String getOperation(int code) {
        switch (code) {
            case 0:
                return "+";
            case 1:
                return "-";
            case 2:
                return "*";
            case 3:
                return "/";
        }
        throw new IllegalArgumentException();
    }

}
