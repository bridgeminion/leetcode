import java.util.*;

public class P2013 {

    public class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
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


    class DetectSquares {

        List<Point> list = new ArrayList<>();
        Map<Point, Integer> count = new HashMap<>();

        public DetectSquares() {

        }

        public void add(int[] point) {
            Point cur = new Point (point[0], point[1]);
            list.add(cur);
            count.putIfAbsent(cur, 0);
            count.put(cur, count.get(cur)+1);
        }

        public int count(int[] point) {
            int ans = 0;
            Point cur = new Point (point[0], point[1]);
            for (Point i : list){
                if (!i.equals(cur) && Math.abs(i.x-point[0]) == Math.abs(i.y-point[1])){
                    Point p1 = new Point (point[0], i.y);
                    Point p2 = new Point (i.x, point[1]);
                    if (count.containsKey(p1) && count.containsKey(p2)){
                        ans += count.get(p1)*count.get(p2);
                    }
                }
            }
            return ans;
        }
    }
}
