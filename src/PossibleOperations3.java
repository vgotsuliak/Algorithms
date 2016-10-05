public class PossibleOperations3 {

    public static void main(String[] args) {
        int operationsCount = 0;
        for (int a = 0; a < 9; a++) {
            for (int b = 0; b < 9; b++) {
                for (int c = 0; c < 9; c++) {
                    for (int d = 0; d < 9; d++) {
                        for (int operation1 = 0; operation1 < 4; operation1++) {
                            for (int operation2 = 0; operation2 < 4; operation2++) {
                                for (int operation3 = 0; operation3 < 4; operation3++) {
                                    int abcd = 0;
                                    if (operation2 == 2 || operation2 == 3) {
                                        if (operation1 == 2 || operation1 == 3) {
                                            int ab = calculate(a, b, operation1);
                                            int abc = calculate(ab, c, operation2);
                                            abcd = calculate(abc, d, operation3);
                                        } else {
                                            int bc = calculate(b, c, operation2);
                                            int bcd = calculate(bc, d, operation3);
                                            abcd = calculate(a, bcd, operation1);
                                        }
                                    } else {
                                        int ab = calculate(a, b, operation1);
                                        int cd = calculate(c, d, operation3);
                                        abcd = calculate(ab, cd, operation2);
                                    }
                                    if (abcd == 5) {
                                        printOperation(a, b, c, d, operation1, operation2, operation3, abcd);
                                        operationsCount++;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println("Operations count: " + operationsCount);
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

    public static void printOperation(int a, int b, int c, int d, int operation1, int operation2, int operation3, int result) {
        String stringOperation1 = getOperation(operation1);
        String stringOperation2 = getOperation(operation2);
        String stringOperation3 = getOperation(operation3);
        System.out.println(a + " " + stringOperation1 + " " + b + " " + stringOperation2 + " " + c + " " + stringOperation3 + " " + d + " = " + result + "<br>");
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
