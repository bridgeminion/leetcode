import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P5989 {

    public int countElements(int[] nums) {
        int n = nums.length;
        if (n == 1){
            return 0;
        }
        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums){
            map.putIfAbsent(i, 0);
            map.put(i, map.get(i)+1);
        }
        int ans;
        if (nums[0] != nums[n-1]){
            ans = n-map.get(nums[0])-map.get(nums[n-1]);
        }
        else {
            ans = n-map.get(nums[0]);
        }
        return ans;
    }
}
