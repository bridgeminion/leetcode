import java.util.HashMap;
import java.util.Map;

public class P6050 {

    public long appealSum(String s) {
        int n = s.length();
        long[] dp = new long[n];
        dp[0] = 1;
        Map<Character, Integer> last = new HashMap<>();
        last.put(s.charAt(0), 0);
        for (int i=1; i < n; i++){
            if (!last.containsKey(s.charAt(i))){
                dp[i] = dp[i-1] + i + 1;
            }
            else {
                dp[i] = dp[i-1] + i - last.get(s.charAt(i));
            }
            last.put(s.charAt(i), i);
        }
        long ans = 0;
        for (int i=0; i < n; i++){
            System.out.println(i + " " + dp[i]);
            ans += dp[i];
        }
        return ans;
    }
}
