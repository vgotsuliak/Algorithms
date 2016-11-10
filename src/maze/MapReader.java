package maze;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MapReader {

    public static void main(String[] args) {
        List<AStar.Vertex> map = readMap("src/maze/map_round1.txt");
//        System.out.println(map);
    }

    public static List<AStar.Vertex> readMap(String mapName) {
        List<AStar.Vertex> field = new ArrayList<>();
        try {
            Scanner in = new Scanner(new FileReader(mapName));
            String line = null;
            int y = 0;
            int arrayDimension = 0;
            while (in.hasNextLine()) {
                line = in.nextLine();
                arrayDimension = line.length();
                int x = 0;
                for (char c : line.toCharArray()) {
                    AStar.Vertex vertex = new AStar.Vertex(x, y, symbolToNumber(c));
                    field.add(vertex);
                    x++;
                }
                y++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return field;
    }

    public static int symbolToNumber(char c) {
        if (String.valueOf(c).equals("*")) {
            return 1;
        } else if (String.valueOf(c).equals("d")) {
            return -1;
        } else if (String.valueOf(c).equals("f")) {
            return -2;
        } else if (String.valueOf(c).equals(" ")) {
            return 0;
        }
        throw new IllegalArgumentException();
    }

}
