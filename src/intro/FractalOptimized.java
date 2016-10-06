package intro;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class FractalOptimized {

    public static void main(String[] args) {
        generateFractal(243);
    }

    private static void generateFractal(int n) {
        int[][] matrix = new int[n][n];
        int from = 0;
        int to = n - 1;
        matrix = fillCenter(matrix, from, to, from, to);
        printMatrixInHtml(matrix);
        printMatrix(matrix);
        findAllInners(matrix);
    }

    private static void findAllInners(int[][] matrix) {
        int innersCount = matrix.length / 3;
        System.out.println(innersCount);
    }

    private static int[][] fillCenter(int[][] matrix, int fromCol, int toCol, int fromRow, int toRow) {
        int margin = (toCol - fromCol + 1) / 3;
        for (int row = fromRow; row <= toRow; row++) {
            for (int col = fromCol; col <= toCol; col++) {
                if ((row - fromRow >= margin && row <= toRow - margin) && (col - fromCol >= margin && col <= toCol - margin)) {
                    matrix[row][col] = 1;
                }
            }
        }
        if (margin == 1) {
            return matrix;
        }

        int innerMatrixCount = (toCol - fromCol + 1) / ((toCol - fromCol + 1) / 3);
        int step = (toCol - fromCol + 1) / 3;
        if (innerMatrixCount > 1) {
            int currentFromRow = fromRow;
            int currentToRow = currentFromRow + step - 1;
            for (int row = 1; row <= innerMatrixCount; row++) {
                int currentFromCol = fromCol;
                int currentToCol = currentFromCol + step - 1;
                for (int col = 1; col <= innerMatrixCount; col++) {
                    fillCenter(matrix, currentFromCol, currentToCol, currentFromRow, currentToRow);
                    currentFromCol += step;
                    currentToCol += step;
                }
                currentFromRow += step;
                currentToRow += step;
            }
        }
        return matrix;
    }



    private static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            System.out.println();
            System.out.println();
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.printf("%5d", matrix[row][col]);
            }
        }
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
    }

    private static void printMatrixInHtml(int[][] matrix) {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter("fractal.html", "UTF-8");
            writer.println("<table  style=\"width: 200px; height: 200px;\">");
            for (int row = 0; row < matrix.length; row++) {
                writer.println("<tr>");
                for (int col = 0; col < matrix[row].length; col++) {
                    if (matrix[row][col] == 1) {
                        writer.println("<td bgcolor=\"blue\"></td>");
                    } else {
                        writer.println("<td bgcolor=\"white\"></td>");
                    }
                }
                writer.println("</tr>");
            }
            writer.println("</table>");
            writer.close();
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }


    }

}
