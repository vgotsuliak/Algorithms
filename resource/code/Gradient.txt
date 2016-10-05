import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class Gradient {

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        generateGradient(100);
    }

    private static void generateGradient(int n) throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter writer = new PrintWriter("gradient.html", "UTF-8");
        writer.println("<table style=\"width: 200px; height: 200px; border-spacing: 0\">");
        for (int i = n; i > 0; i--) {
            writer.println("<tr>");
            for (int j = 0; j < n; j++) {
                double horizontalOpacity = (0.0 + (i * (1.0 / n)));
                double verticalOpacity = (0.0 + (j * (1.0 / n)));
                double opacity = horizontalOpacity / 2 + verticalOpacity / 2;
                writer.println("<td style=\"background-color: rgba(0,0,0," + opacity + ")\"></td>");
            }
            writer.println("</tr>");
        }
        writer.println("</table>");
        writer.close();
    }

}
