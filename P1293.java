import java.util.Comparator;
import java.util.PriorityQueue;

public class P1293 {

    public class State{
        int r;
        int c;
        int cost;
        int d;
        public State(int r, int c, int cost, int d) {
            this.r = r;
            this.c = c;
            this.cost = cost;
            this.d = d;
        }
    }

    public int[] dr = {-1, 0, 1, 0};
    public int[] dc = {0, -1, 0, 1};

    public int shortestPath(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        PriorityQueue<State> pq = new PriorityQueue<>(new Comparator<State>() {
            @Override
            public int compare(State o1, State o2) {
                return o1.cost - o2.cost;
            }
        });
        pq.add(new State (0, 0, 0, 0));
        int[][][] best = new int[m][n][k+1];
        for (int i=0; i < m; i++){
            for (int j=0; j < n; j++){
                for (int a=0; a <= k; a++){
                    best[i][j][a] = Integer.MAX_VALUE;
                }
            }
        }
        best[0][0][0] = 0;
        while (!pq.isEmpty()){
            State cur = pq.remove();
            for (int i=0; i < 4; i++){
                int nr = cur.r+dr[i];
                int nc = cur.c+dc[i];
                if (nr >= 0 && nr < m && nc >= 0 && nc < n){
                    int ncost = cur.cost + grid[nr][nc];
                    if (ncost <= k && cur.d+1 < best[nr][nc][ncost]){
                        best[nr][nc][ncost] = cur.d+1;
                        pq.add(new State (nr, nc, ncost, cur.d+1));
                    }
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i=0; i <= k; i++){
            ans = Math.min(ans, best[m-1][n-1][i]);
        }
        if (ans == Integer.MAX_VALUE) return -1;
        return ans;
    }
}
