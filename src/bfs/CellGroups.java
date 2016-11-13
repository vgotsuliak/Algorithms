package bfs;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class CellGroups {

    public static final int ARRAY_DIMENSION = 19;
    public static Set<Point> processedPoints = new HashSet<>();

    private static class Point {
        int x;
        int y;
        int value;
        int island = 0;
        public Point(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Point point = (Point) o;

            if (x != point.x) return false;
            if (y != point.y) return false;
            return value == point.value;
        }

        @Override
        public String toString() {
            return String.valueOf(value + " - " + island);
        }
    }

    public static List<Point> getField() {
        List<Point> field = new ArrayList<>();
        try {
            Scanner in = new Scanner(new FileReader("src/bfs/field.txt"));
            String line = null;
            int y = 0;
            int arrayDimension = 0;
            while (in.hasNextLine()) {
                line = in.nextLine();
                arrayDimension = line.length();
                int x = 0;
                for (char c : line.toCharArray()) {
                    Point vertex = new Point(x, y, Integer.valueOf(String.valueOf(c)));
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

    public static void printField(List<Point> field) {
        for (Point point : field) {
            if (point.x == 0) {
                System.out.println();
            }
            System.out.print(point.island + " ");
        }
        System.out.println();
    }

    public static List<Point> getPointNeighbors(List<Point> field, Point point, int islandNumber) {
        List<Point> neighbors = new ArrayList<>();
        int index = field.indexOf(point);
        int upper = index - ARRAY_DIMENSION;
        point.island = islandNumber;
        if (upper >= 0) { //upper neighbor
            if (field.get(upper).value == 1  && field.get(upper).island == 0) {
                neighbors.add(field.get(upper));
                field.get(upper).island = islandNumber;
            }
        }
        int left = index - 1;
        if (left >= 0) { //left neighbor
            if (field.get(left).value == (1)  && field.get(left).island == 0) {
                neighbors.add(field.get(left));
                field.get(left).island = islandNumber;
            }
        }
        int bottom = index + ARRAY_DIMENSION;
        if (bottom <= field.size()) { //bottom neighbor
            if (field.get(bottom).value == (1)  && field.get(bottom).island == 0) {
                neighbors.add(field.get(bottom));
                field.get(bottom).island = islandNumber;
            }
        }
        int right = index + 1;
        if (right <= field.size()) { //right neighbor
            if (field.get(right).value == (1) && field.get(right).island == 0) {
                neighbors.add(field.get(right));
                field.get(right).island = islandNumber;
            }
        }
        return neighbors;
    }

    public static List<Point> getPointNeighbors(List<Point> field, List<Point> points, int islandNumber) {
        List<Point> allNeighbors = new ArrayList<>();
        for (Point point : points) {
            List<Point> pointNeighbors = getPointNeighbors(field, point, islandNumber);
            allNeighbors.addAll(pointNeighbors);
        }
        return allNeighbors;
    }

    public static void main(String[] args) {
        List<Point> field = getField();
        printField(field);
        int islandNumber = 0;
        List<Point> allNeighbors = new ArrayList<>();
        for (int i = 0; i < field.size(); i++) {
            if (field.get(i).value == 1 && field.get(i).island == 0) {
                islandNumber++;
                List<Point> pointNeighbors = getPointNeighbors(field, Arrays.asList(field.get(i)), islandNumber);
                while (!pointNeighbors.isEmpty()) {
                    allNeighbors.addAll(pointNeighbors);
                    pointNeighbors = getPointNeighbors(field, pointNeighbors, islandNumber);
                }
            }
        }
        System.out.println(allNeighbors);
        printField(field);
        System.out.println(field);
    }

}
