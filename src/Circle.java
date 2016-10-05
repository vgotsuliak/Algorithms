import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 * Created by viacheslav on 9/29/16.
 */
public class Circle {

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        generateCircle(11);
    }

    private static void generateCircle(int n) throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter writer = new PrintWriter("circle.html", "UTF-8");
        writer.println("<table style=\"width: 200px; height: 200px; border-spacing: 0\">");

        double radius;
        double cx;
        double cy;
        if (n % 2 == 0) {
            radius = n / 2.0 - 1;
            cx = n / 2.0 - 0.0001;
            cy = n / 2.0 - 0.0001;
        } else {
            radius = n / 2.0 - 0.5;
            cx = n / 2.0 - 0.5;
            cy = n / 2.0 - 0.5;
        }

        System.out.println(cx);
        System.out.println(cy);
        System.out.println(radius);

        for (int y = 0; y < n; y++) {
            writer.println("<tr>");
            for (int x = 0; x < n; x++) {
                double d = Math.sqrt(Math.pow((x - cx), 2) + Math.pow((y - cy), 2));
                if (Math.round(d) == Math.floor(radius)) {
                    writer.println("<td style=\"background-color: green\">" + d +  "</td>");
                } else if (Math.round(d) < radius) {
                    writer.println("<td style=\"background-color: aqua\">" + d + "</td>");
                } else {
                    writer.println("<td style=\"background-color: white\">" + d + "</td>");
                }
            }
            writer.println("</tr>");
        }
        writer.println("</table>");
        writer.close();
    }

}
