import java.util.HashMap;
import java.util.Map;

public class P1218 {

    public int longestSubsequence(int[] arr, int difference) {
        int ans = 1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr){
            int cur = 1;
            if (map.containsKey(i)){
                cur = Math.max(cur, map.get(i));
            }
            if (map.containsKey(i-difference)){
                cur = Math.max(cur, map.get(i-difference)+1);
            }
            map.put(i, cur);
            ans = Math.max(ans, cur);
        }
        return ans;
    }

}
