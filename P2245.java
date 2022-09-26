public class P2245 {

    public int s2 (int n){
        int ans = 0;
        while (n%2 == 0){
            n /= 2;
            ans++;
        }
        return ans;
    }

    public int s5 (int n){
        int ans = 0;
        while (n%5 == 0){
            n /= 5;
            ans++;
        }
        return ans;
    }

    public int maxTrailingZeros(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] twos = new int[m+1][n+1];
        int[][] fives = new int[m+1][n+1];
        for (int i=1; i <= m; i++){
            for (int j=1; j <= n; j++){
                twos[i][j] = s2 (grid[i-1][j-1]);
                fives[i][j] = s5 (grid[i-1][j-1]);
            }
        }
        int[][] hor2 = new int[m+1][n+1];
        int[][] hor5 = new int[m+1][n+1];
        int[][] ver2 = new int[m+1][n+1];
        int[][] ver5 = new int[m+1][n+1];
        for (int i=1; i <= m; i++){
            hor2[i][1] = twos[i][1];
            hor5[i][1] = fives[i][1];
            for (int j=2; j <= n; j++){
                hor2[i][j] = hor2[i][j-1] + twos[i][j];
                hor5[i][j] = hor5[i][j-1] + fives[i][j];
            }
        }
        for (int j=1; j <= n; j++){
            ver2[1][j] = twos[1][j];
            ver5[1][j] = fives[1][j];
            for (int i=2; i <= m; i++){
                ver2[i][j] = ver2[i-1][j] + twos[i][j];
                ver5[i][j] = ver5[i-1][j] + fives[i][j];
            }
        }
        int ans = 0;
        for (int i=1; i <= m; i++){
            for (int j=1; j <= n; j++){
                int left2 = hor2[i][j-1];
                int left5 = hor5[i][j-1];
                int right2 = hor2[i][n] - hor2[i][j];
                int right5 = hor5[i][n] - hor5[i][j];
                int up2 = ver2[i-1][j];
                int up5 = ver5[i-1][j];
                int down2 = ver2[m][j] - ver2[i][j];
                int down5 = ver5[m][j] - ver5[i][j];
                int v1 = Math.min(left2+up2+twos[i][j], left5+up5+fives[i][j]);
                int v2 = Math.min(left2+down2+twos[i][j], left5+down5+fives[i][j]);
                int v3 = Math.min(right2+up2+twos[i][j], right5+up5+fives[i][j]);
                int v4 = Math.min(right2+down2+twos[i][j], right5+down5+fives[i][j]);
                int cur = Math.max(v1, Math.max(v2, Math.max(v3, v4)));
                ans = Math.max(ans, cur);
            }
        }
        return ans;
    }
}
