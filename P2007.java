import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P2007 {

    public int[] findOriginalArray(int[] changed) {
        int n = changed.length;
        if (n%2 == 1){
            return new int[]{};
        }
        Arrays.sort(changed);
        Map<Integer, Integer> count = new HashMap<>();
        for (int i : changed){
            count.putIfAbsent(i, 0);
            count.put(i, count.get(i)+1);
        }
        int index = 0;
        int[] ans = new int[n/2];
        if (count.containsKey(0)) {
            if (count.get(0) % 2 == 1) {
                return new int[]{};
            }
            for (int i = 0; i < count.get(0) / 2; i++) {
                ans[i] = 0;
            }
            index = count.get(0) / 2;
        }
        for (int i : changed){
            if (i == 0){
                continue;
            }
            if (count.containsKey(i)){
                if (count.containsKey(i*2)){
                    count.put(i*2, count.get(i*2)-1);
                    if (count.get(i*2) == 0){
                        count.remove(i*2);
                    }
                    count.put(i, count.get(i)-1);
                    if (count.get(i) == 0){
                        count.remove(i);
                    }
                    ans[index] = i;
                    index++;
                }
                else {
                    return new int[]{};
                }
            }
        }
        if (index == n/2){
            return ans;
        }
        return new int[]{};
    }

}
