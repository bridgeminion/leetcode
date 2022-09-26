import com.sun.security.jgss.GSSUtil;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class P1263 {

    public class State {
        int r1; // person
        int c1; // person
        int r2; // block
        int c2; // block

        public State(int r1, int c1, int r2, int c2) {
            this.r1 = r1;
            this.c1 = c1;
            this.r2 = r2;
            this.c2 = c2;
        }
    }

    public int[] dr = {-1, 0, 1, 0};
    public int[] dc = {0, -1, 0, 1};

    public int minPushBox(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int pr = 0, pc = 0, br = 0, bc = 0;
        for (int i=0; i < m; i++){
            for (int j=0; j < n; j++){
                char c = grid[i][j];
                if (c == 'S'){
                    pr = i;
                    pc = j;
                }
                else if (c == 'B'){
                    br = i;
                    bc = j;
                }
            }
        }
        boolean[][][][] vis = new boolean[m][n][m][n];
        Queue<State> q = new LinkedList<>();
        Queue<State> next = new LinkedList<>();
        State start = new State (pr, pc, br, bc);
        int ans = 0;
        q.add(start);
        vis[pr][pc][br][bc] = true;
        while (!q.isEmpty()){
            while (!q.isEmpty()){
                State cur = q.remove();
                if (grid[cur.r2][cur.c2] == 'T'){
                    return ans;
                }
                boolean adj = false;
                int dir = -1;
                for (int i=0; i < 4; i++){
                    int nr = cur.r1+dr[i];
                    int nc = cur.c1+dc[i];
                    if (nr == cur.r2 && nc == cur.c2){
                        adj = true;
                        dir = i;
                    }
                    if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] != '#' && (nr != cur.r2 || nc != cur.c2) && !vis[nr][nc][cur.r2][cur.c2]){
                        vis[nr][nc][cur.r2][cur.c2] = true;
                        q.add(new State (nr, nc, cur.r2, cur.c2));
                    }
                }
                if (adj){
                    int nbr = cur.r2+dr[dir];
                    int nbc = cur.c2+dc[dir];
                    if (nbr >= 0 && nbr < m && nbc >= 0 && nbc < n && grid[nbr][nbc] != '#' && !vis[cur.r2][cur.c2][nbr][nbc]){
                        vis[cur.r2][cur.c2][nbr][nbc] = true;
                        next.add(new State (cur.r2, cur.c2, nbr, nbc));
                    }
                }
            }
            ans++;
            q.addAll(next);
            next.clear();
        }
        return -1;
    }

    public static void main(String[] args) {
        P1263 test = new P1263();
        String[][] strings = {{"#","#","#","#","#","#"},
                {"#","T","#","#","#","#"},
        {"#",".",".","B",".","#"},
            {"#",".","#","#",".","#"},
                {"#",".",".",".","S","#"},
                    {"#","#","#","#","#","#"}};
        char[][] grid = new char[6][6];
        for (int i=0; i < 6; i++){
            for (int j=0; j < 6; j++){
                grid[i][j] = strings[i][j].charAt(0);
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
        System.out.println(test.minPushBox(grid));
    }

}
