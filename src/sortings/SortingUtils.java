package sortings;

import java.io.*;
import java.util.Random;

public class SortingUtils {

    public static int[] getRandomArray(int size, int limit) {
        Random random = new Random();
        int[] randomArray = new int[size];
        for (int i = 0; i < size; i++) {
            double randomDouble = Math.abs(random.nextDouble());
            randomArray[i] = new Double(Math.round(randomDouble * limit)).intValue();
        }
        return randomArray;
    }

    public static void printArrayInHtml(int[] array, int maxNumber, String fileName, String divId) {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(new FileWriter(fileName, true));
            writer.println("<div id=\"" + divId + "\" style=\"width: 200px\"/>");
            writer.println("<table  style=\"width: 200px; height: 200px;\">");
            for (int j = 0; j <= maxNumber; j++) {
                writer.println("<tr>");
                for (int i = 0; i < array.length; i++) {
                    if (array[i] == j) {
                        writer.println("<td bgcolor=\"red\"/>");
                    } else {
                        writer.println("<td bgcolor=\"white\"/>");
                    }
                }
                writer.println("</tr>");
            }
            writer.println("</table>");
            writer.println("</div>");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
