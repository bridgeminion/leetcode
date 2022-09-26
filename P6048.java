import java.util.HashMap;
import java.util.Map;

public class P6048 {

    public int minimumCardPickup(int[] cards) {
        int n = cards.length;
        Map<Integer, Integer> lastIndex = new HashMap<>();
        int ans = -1;
        for (int i=0; i < n; i++){
            if (!lastIndex.containsKey(cards[i])){
                lastIndex.put(cards[i], i);
            }
            else {
                if (ans == -1){
                    ans = i-lastIndex.get(cards[i])+1;
                }
                else {
                    ans = Math.min(ans, i-lastIndex.get(cards[i])+1);
                }
                lastIndex.put(cards[i], i);
            }
        }
        return ans;
    }
}
