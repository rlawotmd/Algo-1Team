package week_11.rlawotmd;

import java.util.HashSet;
import java.util.Objects;

class Point {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "X : " + x + ", Y : " + y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}

class Line {
    Point start_point;
    Point end_point;

    Line(Point start_point, Point end_point) {
        this.start_point = start_point;
        this.end_point = end_point;
    }

    @Override
    public String toString() {
        return "Start : " + start_point.toString() + ", End : " + end_point.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Line line = (Line) obj;
        return start_point.equals(line.start_point) && end_point.equals(line.end_point);
    }

    @Override
    public int hashCode() {
        return Objects.hash(start_point, end_point);
    }
}

public class PGS_방의개수 {

    static Point movePoint(Point loc, int arrow) {
        int x = loc.x;
        int y = loc.y;
        if (arrow <= 1 || arrow == 7) y -= 1;
        if (arrow >= 1 && arrow <= 3) x += 1;
        if (arrow >= 3 && arrow <= 5) y += 1;
        if (arrow >= 5 && arrow <= 7) x -= 1;
        return new Point(x, y);
    }

    static int solution(int[] arrows) {
        int answer = 0;

        Point loc = new Point(0, 0);

        HashSet<Point> points = new HashSet<>();
        HashSet<Line> lines = new HashSet<>();
        points.add(loc);

        for (int i = 0; i < arrows.length; i++) {
            int cur = arrows[i];
            Point toPoint = movePoint(loc, cur);
            Point endPoint = movePoint(toPoint, cur);
            Line newLine = new Line(loc, endPoint);
            Line newLine2 = new Line(endPoint, loc);
            loc = endPoint;

            if (!lines.contains(newLine) || !lines.contains(newLine2)) {
                lines.add(newLine);
                lines.add(newLine2);
                if (points.contains(toPoint)) answer++;
                else points.add(toPoint);
                if (points.contains(endPoint)) answer++;
                else points.add(endPoint);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
//        int[] arrows = new int[]{6, 6, 6, 4, 4, 4, 2, 2, 2, 0, 0, 0, 1, 6, 5, 5, 3, 6, 0}; // 3
        int[] arrows = new int[]{0, 6, 4, 2, 7, 2, 5}; // 4
        System.out.println(solution(arrows));
    }
}
