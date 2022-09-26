import com.sun.source.tree.Tree;

import java.io.IOException;
import java.util.*;

public class P850 {

    public class Point {
        int v;
        boolean start;

        public Point(int v, boolean start) {
            this.v = v;
            this.start = start;
        }
    }

//    public int calc (List<Point> list){
//        Collections.sort(list, new Comparator<Point>() {
//            @Override
//            public int compare(Point o1, Point o2) {
//                if (o1.v == o2.v){
//                    if (o2.start){
//                        return 1;
//                    }
//                }
//                return o1.v-o2.v;
//            }
//        });
//        int res = 0;
//        int d = 0;
//        int last = -1;
//        for (Point i : list){
//            if (last != -1 && d > 0){
//                res += i.v-last;
//            }
//            if (i.start){
//                d++;
//            }
//            else {
//                d--;
//            }
//            last = i.v;
//        }
//        return res;
//    }

    public static int calc (TreeMap<Integer, Integer> tmap){
        int res = 0;
        int d = 0;
        int last = -1;
        for (int i : tmap.keySet()){
            if (last != -1 && d > 0){
                res += i-last;
            }
            d += tmap.get(i);
            last = i;
        }
        return res;
    }

    public int rectangleArea(int[][] rectangles) {
        long mod = 1000000007;
        int n = rectangles.length;
        TreeMap<Integer, Integer> count = new TreeMap<>();
        TreeMap<Integer, List<Point>> start = new TreeMap<>();
        TreeMap<Integer, List<Point>> end = new TreeMap<>();
        for (int i=0; i < n; i++){
            int x1 = rectangles[i][0];
            int y1 = rectangles[i][1];
            int x2 = rectangles[i][2];
            int y2 = rectangles[i][3];
            count.putIfAbsent(x1, 0);
            count.put(x1, count.get(x1)+1);
            count.putIfAbsent(x2, 0);
            count.put(x2, count.get(x2)-1);
            start.putIfAbsent(x1, new ArrayList<>());
            end.putIfAbsent(x2, new ArrayList<>());
            start.get(x1).add(new Point (y1, true));
            start.get(x1).add(new Point (y2, false));
            end.get(x2).add(new Point (y1, true));
            end.get(x2).add(new Point (y2, false));
        }
        long ans = 0;
        long last = -1;
        TreeMap<Integer, Integer> cur = new TreeMap<>();
        int h = -1;
        int d = 0;
        for (int i : count.keySet()){
            if (last != -1 && d > 0){
                ans += (i-last)*h;
                ans %= mod;
            }
            if (start.containsKey(i)){
                for (Point j : start.get(i)){
                    if (j.start){
                        cur.putIfAbsent(j.v, 0);
                        cur.put(j.v, cur.get(j.v)+1);
                    }
                    else {
                        cur.putIfAbsent(j.v, 0);
                        cur.put(j.v, cur.get(j.v)-1);
                    }
                }
            }
            if (end.containsKey(i)){
                for (Point j : end.get(i)){
                    if (j.start){
                        cur.putIfAbsent(j.v, 0);
                        cur.put(j.v, cur.get(j.v)-1);
                    }
                    else {
                        cur.putIfAbsent(j.v, 0);
                        cur.put(j.v, cur.get(j.v)+1);
                    }
                    if (cur.get(j.v) == 0){
                        cur.remove(j.v);
                    }
                }
            }
            d += count.get(i);
            h = calc (cur);
            last = i;
        }
        return (int)ans;
    }

    public static void main(String[] args) throws IOException {
        P850 test = new P850();
        int[][] t1 = {{0,0,2,2},{1,0,2,3},{1,0,3,1}};
        int[][] t2 = {{25,20,70,27},{68,80,79,100},{37,41,66,76}};
        System.out.println(test.rectangleArea(t1));
        System.out.println(test.rectangleArea(t2));
    }

}
