package maze;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AStar {

    public static int ARRAY_DIMENSION = 24;

    public static void main(String[] args) {
        List<Vertex> roundMap = MapReader.readMap("src/maze/map_3");
        for (Vertex vertex : roundMap) {
            if (vertex.x == 0) {
                System.out.println();
            }
            System.out.print(String.format("%5d", vertex.value));
        }

        List<Vertex> route = aStar(roundMap, getStartingPosition(roundMap));
        for (Vertex vertex : roundMap) {
            if (vertex.x == 0) {
                System.out.println();
            }
            if (route.contains(vertex)) {
                System.out.print(String.format("%5s", "*"));
            } else if (vertex.value > 1 || vertex.value == 0) {
                System.out.print(String.format("%5s", " "));
            } else {
                System.out.print(String.format("%5d", vertex.value));
            }
        }


        for (Vertex vertex : roundMap) {
            if (vertex.x == 0) {
                System.out.println();
            }
            if (vertex.value != 1 && vertex.value >= 0) {
                System.out.print(String.format("%5s", " "));
            } else if (vertex.value < -1) {
                System.out.print(String.format("%5s", "*"));
            } else {
                System.out.print(String.format("%5d", vertex.value));
            }
        }
    }

    public static List<Vertex> getStartingPosition(List<Vertex> map) {
        List<Vertex> startingPoints = new ArrayList<>();
        for (Vertex vertex : map) {
            if (vertex.value == -1) {
                startingPoints.add(vertex);
            }
        }
        return startingPoints;
    }

    public static List<Vertex> aStar(List<Vertex> map, List<Vertex> startPoints) {
        int value = 2;
        List<Vertex> neighbors = startPoints;
        List<Vertex> route = new ArrayList<>();
        try {
            do {
                neighbors = getNeighbors(map, neighbors, value);
                value++;
            } while (!neighbors.isEmpty());
        } catch (FinishFoundException e) {
            Vertex nextStep = e.getVertex();
            try {
                while ((nextStep = getNextStep(nextStep, map)) != null) {
                    route.add(nextStep);
                }
            } catch (StartFoundException e1) {
                Collections.reverse(route);
//                List<RobotManipulator.RouteSection> vertexes = RobotManipulator.buildRoute(route);
//                for (RobotManipulator.RouteSection vertex : vertexes) {
//                    System.out.println(vertex);
//                }
            }
        }
        return route;
    }

    public static List<Vertex> getNeighbors(List<Vertex> map, List<Vertex> vertexes, int value) {
        List<Vertex> neighbors = new ArrayList<>();
        for (Vertex vertex : vertexes) {
            neighbors.addAll(getNeighbors(map, vertex, value));
        }
        return neighbors;
    }

    public static List<Vertex> getNeighbors(List<Vertex> map, Vertex vertex, int value) {
        List<Vertex> neighbors = new ArrayList<>();
        int index = map.indexOf(vertex);
        int upper = index - ARRAY_DIMENSION;
        if (upper >= 0) { //upper neighbor
            if (map.get(upper).value == 0 && map.get(upper).value == 0) {
                neighbors.add(map.get(upper));
                map.get(upper).value = value;
            } else if (map.get(upper).value == -2) {
                map.get(upper).value = value;
                throw new FinishFoundException(map.get(upper));
            }
        }
        int left = index - 1;
        if (vertex.x > 0 && left >= 0) { //left neighbor
            if (map.get(left).value == 0 && map.get(left).value == 0) {
                neighbors.add(map.get(left));
                map.get(left).value = value;
            } else if (map.get(upper).value == -2) {
                map.get(left).value = value;
                throw new FinishFoundException(map.get(left));
            }
        }
        int bottom = index + ARRAY_DIMENSION;
        if (bottom < map.size()) { //bottom neighbor
            if (map.get(bottom).value == 0 && map.get(bottom).value == 0) {
                neighbors.add(map.get(bottom));
                map.get(bottom).value = value;
            } else if (map.get(upper).value == -2) {
                map.get(bottom).value = value;
                throw new FinishFoundException(map.get(bottom));
            }
        }
        int right = index + 1;
        if (vertex.x < ARRAY_DIMENSION - 1 && right < map.size()) { //right neighbor
            if (map.get(right).value == 0 && map.get(right).value == 0) {
                neighbors.add(map.get(right));
                map.get(right).value = value;
            } else if (map.get(upper).value == -2) {
                map.get(right).value = value;
                throw new FinishFoundException(map.get(right));
            }
        }
        return neighbors;
    }

    public static Vertex getNextStep(Vertex vertex, List<Vertex> map) {
        int index = map.indexOf(vertex);
        int upper = index - ARRAY_DIMENSION;
        if (upper >= 0) { //upper neighbor
            if (map.get(upper).value != -2 && map.get(upper).value != 0 && map.get(upper).value != 1 && map.get(upper).value < vertex.value) {
                return map.get(upper);
            }
        }
        int left = index - 1;
        if (vertex.x > 0 && left >= 0) { //left neighbor
            if (map.get(left).value != -2 && map.get(left).value != 0 && map.get(left).value != 1 && map.get(left).value < vertex.value) {
                return map.get(left);
            }
        }
        int bottom = index + ARRAY_DIMENSION;
        if (bottom < map.size()) { //bottom neighbor
            if (map.get(bottom).value != -2 && map.get(bottom).value != 0 && map.get(bottom).value != 1 && map.get(bottom).value < vertex.value) {
                return map.get(bottom);
            }
        }
        int right = index + 1;
        if (vertex.x < ARRAY_DIMENSION - 1 && right < map.size()) { //right neighbor
            if (map.get(right).value != -2 && map.get(right).value != 0 && map.get(right).value != 1 && map.get(right).value < vertex.value) {
                return map.get(right);
            }
        }
        throw new StartFoundException();
    }

    public static class Vertex {
        public int x;
        public int y;
        public int value;

        public Vertex(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Vertex vertex = (Vertex) o;
            return x == vertex.x && y == vertex.y && value == vertex.value;

        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            result = 31 * result + value;
            return result;
        }

        @Override
        public String toString() {
            return value + "";
        }
    }

    public static class FinishFoundException extends RuntimeException {
        private Vertex vertex;
        public FinishFoundException(Vertex vertex) {
            this.vertex = vertex;
        }
        public Vertex getVertex() {
            return vertex;
        }
    }

    public static class StartFoundException extends RuntimeException {
    }

}
