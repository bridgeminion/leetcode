import java.util.TreeMap;

public class P2208 {

    public int halveArray(int[] nums) {
        TreeMap<Double, Integer> tmap = new TreeMap<>();
        double sum = 0;
        for (int i : nums){
            tmap.putIfAbsent((double)i, 0);
            tmap.put((double)i, tmap.get((double)i)+1);
            sum += i;
        }
        double target = sum/2;
        double cur = 0;
        int ans = 0;
        while (cur < target){
            double big = tmap.lastKey();
            cur += big/2;
            tmap.put(big, tmap.get(big)-1);
            if (tmap.get(big) == 0) tmap.remove(big);
            double next = big/2;
            tmap.putIfAbsent(next, 0);
            tmap.put(next, tmap.get(next)+1);
            ans++;
        }
        return ans;
    }
}
