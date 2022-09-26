import java.util.HashMap;
import java.util.Map;

public class P2244 {

    public int solve (int x){
        return (x+2)/3;
    }

    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : tasks){
            map.putIfAbsent(i, 0);
            map.put(i, map.get(i)+1);
        }
        int ans = 0;
        for (int i : map.keySet()){
            if (map.get(i) == 1) return -1;
            ans += solve (map.get(i));
        }
        return ans;
    }
}
