import java.util.TreeMap;

public class P6006 {

    public long minimumRemoval(int[] beans) {
        long n = beans.length;
        long tot = 0;
        TreeMap<Integer, Integer> tmap = new TreeMap<>();
        for (int i : beans){
            tot += i;
            tmap.putIfAbsent(i, 0);
            tmap.put(i, tmap.get(i)+1);
        }
        long rem = 0;
        long less = 0;
        for (int i : tmap.keySet()){
            rem = Math.max(rem, i*(n-less));
            less += tmap.get(i);
        }
        return tot-rem;
    }
}
