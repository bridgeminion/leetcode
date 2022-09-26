import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class P329 {

    public boolean[][] vis = new boolean[205][205];
    public int[][] val = new int[205][205];
    public int[] dr = {-1, 0, 1, 0};
    public int[] dc = {0, -1, 0, 1};

//    public class State {
//        int r;
//        int c;
//        int v;
//
//        public State(int r, int c, int v) {
//            this.r = r;
//            this.c = c;
//            this.v = v;
//        }
//    }

    public int solve (int row, int col, int[][] matrix, int m, int n){
        if (vis[row][col]){
            return val[row][col];
        }
        vis[row][col] = true;
        int ans = 0;
        for (int i=0; i < 4; i++){
            int r = row + dr[i];
            int c = col + dc[i];
            if (r >= 0 && r < m && c >= 0 && c < n){
                if (matrix[row][col] < matrix[r][c]){
                    ans = Math.max(ans, solve (r, c, matrix, m, n));
                }
            }
        }
        val[row][col] = 1+ans;
        return val[row][col];
    }

    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
//        List<State> list = new ArrayList<>();
        int ans = 0;
        for (int i=0; i < m; i++){
            for (int j=0; j < n; j++){
//                list.add(new State (i, j, matrix[i][j]));
                ans = Math.max(ans, solve (i, j, matrix, m, n));
            }
        }
//        Collections.sort(list, new Comparator<State>() {
//            @Override
//            public int compare(State o1, State o2) {
//                return o1.v-o2.v;
//            }
//        });
//        for (State i : list){
//            ans = Math.max(ans, solve (i.r, i.c, matrix, m, n));
//        }
        return ans;
    }

    public static void main(String[] args) throws IOException {
        P329 test = new P329();
        int[][] a1 = {{3,4,5}, {3,2,6}, {2,2,1}};
        System.out.println(test.longestIncreasingPath(a1));
    }
}
