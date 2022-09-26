public class P552 {

    public int checkRecord(int n) {
        long mod = 1000000007;
        long[][][] dp = new long[n+1][3][2]; // num days, num late in a row, num present
        dp[0][0][0] = 1;
        for (int i=0; i < n; i++){
            for (int j=0; j < 3; j++){
                // if k = 0, next day can be present, late, or absent
                long zeroAbsent = dp[i][j][0];
                dp[i+1][0][0] += zeroAbsent; // present
                dp[i+1][0][0] %= mod;
                if (j < 2){
                    dp[i+1][j+1][0] += zeroAbsent; // late
                    dp[i+1][j+1][0] %= mod;
                }
                dp[i+1][0][1] += zeroAbsent; // absent
                dp[i+1][0][1] %= mod;
                // if k = 1, next day can be present or late
                long oneAbsent = dp[i][j][1];
                dp[i][j][1] %= mod;
                dp[i+1][0][1] += oneAbsent;
                dp[i+1][0][1] %= mod;
                if (j < 2){
                    dp[i+1][j+1][1] += oneAbsent;
                    dp[i+1][j+1][1] %= mod;
                }
            }
        }
        long ans = 0;
        for (int j=0; j < 3; j++){
            for (int k=0; k < 2; k++){
                ans += dp[n][j][k];
                ans %= mod;
            }
        }
        return (int)ans;
    }
}
