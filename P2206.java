import java.util.HashMap;
import java.util.Map;

public class P2206 {

    public boolean divideArray(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int i : nums){
            count.putIfAbsent(i, 0);
            count.put(i, count.get(i)+1);
        }
        for (int i : count.keySet()){
            if (count.get(i)%2 != 0) return false;
        }
        return true;
    }
}
