package maze;

import java.util.ArrayList;
import java.util.List;

public class RobotManipulator {

    public static List<RouteSection> buildRoute(List<AStar.Vertex> points) {
        List<RouteSection> route = new ArrayList<>();
        for (int i = 0; i < points.size(); i++) {
            AStar.Vertex point = points.get(i);
            AStar.Vertex nextPoint = points.get(i);
            if (i + 1 < points.size()) {
                nextPoint = points.get(i + 1);
            }
            if (nextPoint.x != point.x) {
                if (nextPoint.x > point.x) {
                    RouteSection section = new RouteSection(Direction.EAST, 20, 50);
                    if (route.size() > 0 && route.get(route.size() - 1).equals(section)) {
                        route.get(route.size() - 1).setTime(route.get(route.size() - 1).getTime() + section.getTime());
                    } else {
                        route.add(section);
                    }
                } else {
                    RouteSection section = new RouteSection(Direction.WEST, 20, 50);
                    if (route.size() > 0 && route.get(route.size() - 1).equals(section)) {
                        route.get(route.size() - 1).setTime(route.get(route.size() - 1).getTime() + section.getTime());
                    } else {
                        route.add(section);
                    }
                }
            } else if (nextPoint.y != point.y) {
                if (nextPoint.y > point.y) {
                    RouteSection section = new RouteSection(Direction.SOUTH, 20, 50);
                    if (route.size() > 0 && route.get(route.size() - 1).equals(section)) {
                        route.get(route.size() - 1).setTime(route.get(route.size() - 1).getTime() + section.getTime());
                    } else {
                        route.add(section);
                    }
                } else {
                    RouteSection section = new RouteSection(Direction.NORTH, 20, 50);
                    if (route.size() > 0 && route.get(route.size() - 1).equals(section)) {
                        route.get(route.size() - 1).setTime(route.get(route.size() - 1).getTime() + section.getTime());
                    } else {
                        route.add(section);
                    }
                }
            }
        }
        return route;
    }

    public static class RouteSection {
        private Direction direction;
        private int time;
        private int speed;
        public RouteSection(Direction direction, int time, int speed) {
            this.direction = direction;
            this.time = time;
            this.speed = speed;
        }
        public Direction getDirection() {
            return direction;
        }
        public int getTime() {
            return time;
        }
        public void setDirection(Direction direction) {
            this.direction = direction;
        }
        public void setTime(int time) {
            this.time = time;
        }
        public void setSpeed(int speed) {
            this.speed = speed;
        }
        public int getSpeed() {
            return speed;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            RouteSection that = (RouteSection) o;

            return direction == that.direction;

        }

        @Override
        public int hashCode() {
            int result = direction != null ? direction.hashCode() : 0;
            result = 31 * result + time;
            result = 31 * result + speed;
            return result;
        }

        @Override
        public String toString() {
            return direction.code + "_" + time + "_" + speed;
        }
    }

    enum Direction {
        NORTH("N"), SOUTH("S"), EAST("E"), WEST("W");
        private String code;
        Direction(String code) {
            this.code = code;
        }
    }

}
