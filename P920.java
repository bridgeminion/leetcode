public class P920 {

    public int numMusicPlaylists(int n, int goal, int k) {
        long[][] dp = new long[goal+1][n+1];
        long mod = 1000000007;
        dp[0][0] = 1;
        for (int i=1; i <= goal; i++){
            for (int j=1; j <= n; j++){
                dp[i][j] = dp[i-1][j-1] * (n-(j-1));
                dp[i][j] %= mod;
                if (j > k){
                    dp[i][j] += dp[i-1][j] * (j-k);
                    dp[i][j] %= mod;
                }
            }
        }
        return (int)(dp[goal][n]%mod);
    }
}
