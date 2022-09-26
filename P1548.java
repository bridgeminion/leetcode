import java.io.IOException;
import java.util.*;

public class P1548 {

//    public class State {
//        List<Integer> list = new ArrayList<>();
//        int v;
//        int cost;
//        int len;
//
//        public State(int v, int cost, int len) {
//            this.v = v;
//            this.cost = cost;
//            this.len = len;
//        }
//    }
//
//    public List<Integer> mostSimilar(int n, int[][] roads, String[] names, String[] targetPath) {
//        Map<Integer, Set<Integer>> adj = new HashMap<>();
//        for (int i=0; i < n; i++){
//            adj.put(i, new HashSet<>());
//        }
//        for (int i=0; i < roads.length; i++){
//            adj.get(roads[i][0]).add(roads[i][1]);
//        }
//        Queue<State> q = new LinkedList<>();
//        boolean[][] vis = new boolean[n][targetPath.length+1];
//        for (int i=0; i < n; i++){
//            q.add(new State (i, 0, 1));
//        }
//        while (true){
//            int min = Integer.MAX_VALUE;
//            State cur = new State(-1, -1, -1);
//            for (State i : q){
//                if (i.cost < min){
//                    min = i.cost;
//                    cur = i;
//                }
//            }
//            if (cur.len == targetPath.length){
//                return cur.list;
//            }
//            for (int next : adj.get(cur.v)){
//                int add = 0;
//                String a = names[cur.len];
//                if (!a.equals(targetPath[cur.len])){
//                    add = 1;
//                }
//                if (!vis[])
//            }
//        }
//    }

    public List<Integer> mostSimilar(int n, int[][] roads, String[] names, String[] targetPath) {
        Map<Integer, Set<Integer>> adj = new HashMap<>();
        for (int i=0; i < n; i++){
            adj.put(i, new HashSet<>());
        }
        for (int i=0; i < roads.length; i++){
            adj.get(roads[i][0]).add(roads[i][1]);
            adj.get(roads[i][1]).add(roads[i][0]);
        }
        int len = targetPath.length;
        int[][] dp = new int[len+1][n];
        int[][] prev = new int[len+1][n];
        for (int i=0; i <= len; i++){
            for (int j=0; j < n; j++){
                dp[i][j] = Integer.MAX_VALUE;
                prev[i][j] = -1;
            }
        }
        for (int i=0; i < n; i++){
            if (!names[i].equals(targetPath[0])){
                dp[1][i] = 1;
            }
            else {
                dp[1][i] = 0;
            }
        }
        for (int i=1; i < len; i++){
            for (int j=0; j < n; j++){
                if (dp[i][j] != Integer.MAX_VALUE){
                    for (int k : adj.get(j)){
                        int cost = 0;
                        if (!names[k].equals(targetPath[i])){
                            cost = 1;
                        }
                        if (dp[i][j] + cost < dp[i+1][k]){
                            dp[i+1][k] = dp[i][j] + cost;
                            prev[i+1][k] = j;
                        }
                    }
                }
            }
        }
        int min = Integer.MAX_VALUE;
        int last = -1;
        for (int j=0; j < n; j++){
            if (dp[len][j] < min){
                min = dp[len][j];
                last = j;
            }
        }
        List<Integer> rev = new ArrayList<>();
        rev.add(last);
        for (int i=len; i > 1; i--){
            rev.add(prev[i][last]);
            last = prev[i][last];
        }
        List<Integer> ans = new ArrayList<>();
        for (int i=0; i < len; i++){
            ans.add(rev.get(len-1-i));
        }
        return ans;
    }

    public static void main(String[] args) throws IOException {
        P1548 test = new P1548();
        int[][] roads1 = {{0,2},{0,3},{1,2},{1,3},{1,4},{2,4}};
        String[] names1 = {"ATL","PEK","LAX","DXB","HND"};
        String[] target1 = {"ATL","DXB","HND","LAX"};
        System.out.println(test.mostSimilar(5, roads1, names1, target1));

    }
}
