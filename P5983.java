import java.util.Arrays;
import java.util.LinkedList;
import java.util.TreeMap;

public class P5983 {

    public long maxRunTime(int n, int[] batteries) {
        TreeMap<Long, Integer> tmap = new TreeMap<>();
        Arrays.sort(batteries);
        for (int i=0; i < n; i++){
            tmap.putIfAbsent((long)batteries[n-1-i], 0);
            tmap.put((long)batteries[n-1-i], tmap.get((long)batteries[n-1-i])+1);
        }
        int index = batteries.length-n-1;
        long ans = 0;
        while (index >= 0){
            long low = tmap.firstKey();
            ans = Math.max(ans, low);
            tmap.put(low, tmap.get(low)-1);
            if (tmap.get(low) == 0){
                tmap.remove(low);
            }
            long next = low + batteries[index];
            tmap.putIfAbsent(next, 0);
            tmap.put(next, tmap.get(next)+1);
            index--;
        }
        return ans;
    }
}
