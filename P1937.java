import java.io.IOException;
import java.util.TreeMap;

public class P1937 {

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
            TreeMap<Long, Integer> left = new TreeMap<>();
            TreeMap<Long, Integer> right = new TreeMap<>();
            for (int j=0; j < n; j++){
                right.putIfAbsent(dp[i-1][j]-j, 0);
                right.put(dp[i-1][j]-j, right.get(dp[i-1][j]-j)+1);
            }
            for (int j=0; j < n; j++){
                right.put(dp[i-1][j]-j, right.get(dp[i-1][j]-j)-1);
                if (right.get(dp[i-1][j]-j) == 0){
                    right.remove(dp[i-1][j]-j);
                }
                dp[i][j] = Math.max(dp[i][j], dp[i-1][j]);
                if (left.size() > 0){
                    dp[i][j] = Math.max(dp[i][j], left.lastKey()-j);
                }
                if (right.size() > 0){
                    dp[i][j] = Math.max(dp[i][j], right.lastKey()+j);
                }
                left.putIfAbsent(dp[i-1][j]+j, 0);
                left.put(dp[i-1][j]+j, left.get(dp[i-1][j]+j)+1);
                dp[i][j] += points[i][j];
            }
        }
        long ans = 0;
        for (int j=0; j < n; j++){
            ans = Math.max(ans, dp[m-1][j]);
        }
        return ans;
    }

    public static void main(String[] args) throws IOException {
        P1937 test = new P1937();
        int[][] points1 = {{1,2,3},{1,5,1},{3,1,1}};
        int[][] points2 = {{0,3,0,4,2},{5,4,2,4,1},{5,0,0,5,1},{2,0,1,0,3}};
        System.out.println(test.maxPoints(points1));
        System.out.println(test.maxPoints(points2));

    }

}
