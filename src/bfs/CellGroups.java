package bfs;

import java.util.*;

public class CellGroups {

    public static final int ARRAY_DIMENSION = 20;
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

    public static List<Point> generateField() {
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < ARRAY_DIMENSION; i++) {
            for (int j = 0; j < ARRAY_DIMENSION; j++) {
                Point point = new Point(i, j, 0);
                points.add(point);
            }
        }
        return points;
    }

    public static Point getPoint(int x, int y, List<Point> field) {
        for (Point point : field) {
            if (point.x == x && point.y == y) {
                return point;
            }
        }
        throw new IllegalArgumentException();
    }

    public static List<Point> createIslands(List<Point> field) {
        for (Point point : field) {
            if (point.x == 3 && point.y == 3) {
                point.value = 1;
            }
            if (point.x == 4 && point.y == 3) {
                point.value = 1;
            }
            if (point.x == 5 && point.y == 3) {
                point.value = 1;
            }
            if (point.x == 3 && point.y == 4) {
                point.value = 1;
            }
            if (point.x == 14 && point.y == 15) {
                point.value = 1;
            }
            if (point.x == 14 && point.y == 14) {
                point.value = 1;
            }
        }

        return field;
    }

    public static void printField(List<Point> field) {
        for (Point point : field) {
            if (point.y == 0) {
                System.out.println();
            }
            System.out.print(point.value);
        }
    }

    public static List<Point> getPointNeighbors(List<Point> field, Point point, int islandNumber) {
        List<Point> neighbors = new ArrayList<>();
        int index = field.indexOf(point);
        int upper = index - ARRAY_DIMENSION;
        point.island = islandNumber;
        if (upper >= 0) { //upper neighbor
            if (field.get(upper).value == 1  && field.get(upper).island == 0) {
                neighbors.add(field.get(upper));
                field.get(upper).island = 1;
            }
        }
        int left = index - 1;
        if (left >= 0) { //left neighbor
            if (field.get(left).value == (1)  && field.get(left).island == 0) {
                neighbors.add(field.get(left));
                field.get(left).island = 1;
            }
        }
        int bottom = index + ARRAY_DIMENSION;
        if (bottom <= field.size()) { //bottom neighbor
            if (field.get(bottom).value == (1)  && field.get(bottom).island == 0) {
                neighbors.add(field.get(bottom));
                field.get(bottom).island = 1;
            }
        }
        int right = index + 1;
        if (right <= field.size()) { //right neighbor
            if (field.get(right).value == (1) && field.get(right).island == 0) {
                neighbors.add(field.get(right));
                field.get(right).island = 1;
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
        List<Point> field = generateField();
        List<Point> fieldWithIslands = createIslands(field);
        printField(fieldWithIslands);
        int islandNumber = 1;
        for (int i = 0; i < fieldWithIslands.size(); i++) {
            List<Point> allNeighbors = new ArrayList<>();
            if (fieldWithIslands.get(i).value == 1) {
                List<Point> pointNeighbors = getPointNeighbors(fieldWithIslands, Arrays.asList(fieldWithIslands.get(i)), islandNumber);
                while (!pointNeighbors.isEmpty()) {
                    allNeighbors.addAll(pointNeighbors);
                    pointNeighbors = getPointNeighbors(fieldWithIslands, pointNeighbors, islandNumber);
                }
                islandNumber++;
            }
            System.out.println(allNeighbors);
        }
    }

}
