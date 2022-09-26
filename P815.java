import java.util.HashMap;
import java.util.Map;

public class P815 {

    class Solution {
        public int findMaxLength(int[] nums) {
            int n = nums.length;
            int[] net = new int[n+1];
            for (int i=1; i <= n; i++){
                if (nums[i-1] == 1){
                    net[i] = net[i-1]+1;
                }
                else {
                    net[i] = net[i-1]-1;
                }
            }
            Map<Integer, Integer> firstPos = new HashMap<>();
            Map<Integer, Integer> lastPos = new HashMap<>();
            for (int i=0; i <= n; i++){
                if (!firstPos.containsKey(net[i])){
                    firstPos.put(net[i], i);
                }
            }
            for (int i=n; i >= 0; i--){
                if (!lastPos.containsKey(net[i])){
                    lastPos.put(net[i], i);
                }
            }
            int ans = 0;
            for (int i : firstPos.keySet()){
                ans = Math.max(ans, lastPos.get(i)-firstPos.get(i));
            }
            return ans;
        }
    }
}
