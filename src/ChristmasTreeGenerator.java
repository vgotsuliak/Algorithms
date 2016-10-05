import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class ChristmasTreeGenerator {

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        generateChristmasTree(17);
    }

    public static void generateChristmasTree(int n) throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter writer = new PrintWriter("christmas-tree.html", "UTF-8");

        writer.println("<table  style=\"width: 200px; height: 200px;\">");
        for (int i = 0; i < n; i++) {

            writer.println("<tr>");

            for (int j = 0; j < n; j++) {

                int margin = n - (i + 1);

                if ((j >= margin && j <= (n - 1) - margin)) {
                    writer.println("<td bgcolor='green'></td>");
                } else if (n % 2 == 0 && (((j == n / 2 - 1)) || (j == n / 2))) {
                    writer.println("<td bgcolor='green'></td>");
                } else if (n % 2 != 0 && (j == n / 2)) {
                    writer.println("<td bgcolor='green'></td>");
                } else {
                    writer.println("<td bgcolor='white'></td>");
                }

            }

            writer.println("</tr>");

        }
        writer.println("</table>");
        writer.close();

    }

}
