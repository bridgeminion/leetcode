import java.util.*;

public class P939 {

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

    public int minAreaRect(int[][] points) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        int n = points.length;
        for (int i=0; i < n; i++){
            map.putIfAbsent(points[i][0], new HashSet<>());
            map.get(points[i][0]).add(points[i][1]);
        }
        boolean found = false;
        int ans = Integer.MAX_VALUE;
        for (int i=0; i < n; i++){
            for (int j=i+1; j < n; j++){
                Point p3 = new Point (points[i][0], points[j][1]);
                Point p4 = new Point (points[j][0], points[i][1]);
                if (map.get(p3.x).contains(p3.y) && map.get(p4.x).contains(p4.y)){
                    int area = Math.abs(points[i][0]-points[j][0])*Math.abs(points[i][1]-points[j][1]);
                    System.out.println(i + " " + j + " " + area);
                    if (area > 0){
                        found = true;
                        ans = Math.min(ans, area);
                    }
                }
            }
        }
        if (!found) return 0;
        return ans;
    }
}
