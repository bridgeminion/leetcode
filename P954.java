import java.util.*;

public class P954 {

    public boolean canReorderDoubled(int[] arr) {
        int n = arr.length;
        TreeMap<Integer, Integer> negCount = new TreeMap<>();
        TreeMap<Integer, Integer> posCount = new TreeMap<>();
        int nc = 0;
        int zc = 0;
        int pc = 0;
        for (int i=0; i < n; i++){
            if (arr[i] < 0){
                nc++;
                int cur = -arr[i];
                negCount.putIfAbsent(cur, 0);
                negCount.put(cur, negCount.get(cur)+1);
            }
            else if (arr[i] == 0) zc++;
            else{
                pc++;
                int cur = arr[i];
                posCount.putIfAbsent(cur, 0);
                posCount.put(cur, posCount.get(cur)+1);
            }
        }
        if (nc%2 != 0 || zc%2 != 0 || pc%2 != 0) return false;
        for (int i=0; i < nc/2; i++){
            int cur = negCount.firstKey();
            if (!negCount.containsKey(cur*2)) return false;
            negCount.putIfAbsent(cur, 0);
            negCount.put(cur, negCount.get(cur)-1);
            if (negCount.get(cur) == 0) negCount.remove(cur);
            negCount.putIfAbsent(cur*2, 0);
            negCount.put(cur*2, negCount.get(cur*2)-1);
            if (negCount.get(cur*2) == 0) negCount.remove(cur*2);
        }
        for (int i=0; i < pc/2; i++){
            int cur = posCount.firstKey();
            if (!posCount.containsKey(cur*2)) return false;
            posCount.putIfAbsent(cur, 0);
            posCount.put(cur, posCount.get(cur)-1);
            if (posCount.get(cur) == 0) posCount.remove(cur);
            posCount.putIfAbsent(cur*2, 0);
            posCount.put(cur*2, posCount.get(cur*2)-1);
            if (posCount.get(cur*2) == 0) posCount.remove(cur*2);
        }
        return true;
    }
}
