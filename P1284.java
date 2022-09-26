public class P1284 {

    public void flip (int[][] mat, int m, int n, int r, int c){
        mat[r][c] = 1-mat[r][c];
        if (r > 0) mat[r-1][c] = 1-mat[r-1][c];
        if (c > 0) mat[r][c-1] = 1-mat[r][c-1];
        if (r < m-1) mat[r+1][c] = 1-mat[r+1][c];
        if (c < n-1) mat[r][c+1] = 1-mat[r][c+1];
    }

    public boolean isZero (int[][] mat, int m, int n){
        for (int i=0; i < m; i++){
            for (int j=0; j < n; j++){
                if (mat[i][j] != 0) return false;
            }
        }
        return true;
    }

    public int minFlips(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] original = new int[m][n];
        int ans = Integer.MAX_VALUE;
        for (int i=0; i < m; i++){
            for (int j=0; j < n; j++){
                original[i][j] = mat[i][j];
            }
        }
        for (int tot=0; tot < (1 << m*n); tot++){
            int numFlips = 0;
            for (int i=0; i < m; i++){
                for (int j=0; j < n; j++){
                    int cur = i*n + j;
                    if ((tot & (1 << cur)) > 0){
                        numFlips++;
                        flip (mat, m, n, i, j);
                    }
                }
            }
            if (isZero(mat, m, n)) ans = Math.min(ans, numFlips);
            for (int i=0; i < m; i++){
                for (int j=0; j < n; j++){
                    mat[i][j] = original[i][j];
                }
            }
        }
        if (ans == Integer.MAX_VALUE) ans = -1;
        return ans;
    }
}
