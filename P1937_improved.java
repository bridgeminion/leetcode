import java.io.IOException;
import java.util.TreeMap;

public class P1937_improved {

    public long maxPoints(int[][] points) {
        int m = points.length;
        int n = points[0].length;
        long[][] dp = new long[m][n];
        for (int i=0; i < m; i++){
            for (int j=0; j < n; j++){
                dp[i][j] = Long.MIN_VALUE;
            }
        }
        for (int j=0; j < n; j++){
            dp[0][j] = points[0][j];
        }
        for (int i=1; i < m; i++){
           long[] left = new long[n];
           long[] right = new long[n];
           left[0] = dp[i-1][0];
           for (int j=1; j < n; j++){
               left[j] = Math.max(left[j-1]-1, dp[i-1][j]);
           }
           right[n-1] = dp[i-1][n-1];
           for (int j=n-2; j >= 0; j--){
               right[j] = Math.max(right[j+1]-1, dp[i-1][j]);
           }
           for (int j=0; j < n; j++){
               dp[i][j] = Math.max(left[j], right[j]) + points[i][j];
           }
        }
        long ans = 0;
        for (int j=0; j < n; j++){
            ans = Math.max(ans, dp[m-1][j]);
        }
        return ans;
    }
    public static void main(String[] args) throws IOException {
        P1937_improved test = new P1937_improved();
        int[][] points1 = {{1,2,3},{1,5,1},{3,1,1}};
        int[][] points2 = {{0,3,0,4,2},{5,4,2,4,1},{5,0,0,5,1},{2,0,1,0,3}};
        System.out.println(test.maxPoints(points1));
        System.out.println(test.maxPoints(points2));
    }


}
