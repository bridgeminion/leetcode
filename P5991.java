import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P5991 {

    public List<Integer> findLonely(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> count = new HashMap<>();
        for (int i : nums){
            count.putIfAbsent(i, 0);
            count.put(i, count.get(i)+1);
        }
        List<Integer> ans = new ArrayList<>();
        for (int i : count.keySet()){
            if (count.get(i) == 1 && !count.containsKey(i-1) && !count.containsKey(i+1)){
                ans.add(i);
            }
        }
        return ans;
    }
}
