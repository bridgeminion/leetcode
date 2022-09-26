import java.io.IOException;
import java.util.TreeMap;

public class P6003_fail {

    public int minimumTime(String s) {
        int n = s.length();
        boolean[] bad = new boolean[n];
        for (int i=0; i < n; i++){
            bad[i] = s.charAt(i) == '1';
        }
        TreeMap<Integer, Integer> tmap = new TreeMap<>();
        tmap.put(n, 1);
        int numbad = 0;
        int[] val = new int[n+1];
        val[0] = n;
        for (int i=0; i < n; i++){
            if (bad[i]){
                numbad++;
            }
            int cur = numbad*2 + (n-1-i);
            tmap.putIfAbsent(cur, 0);
            tmap.put(cur, tmap.get(cur)+1);
            val[i+1] = cur;
        }
        int ans = tmap.firstKey();
        int delta = 0;
        for (int i=0; i < n; i++){
            if (bad[i]){
                delta--;
            }
            else {
                delta++;
            }
            if (!bad[i]){
                continue;
            }
            int rem = val[i];
            tmap.put(rem, tmap.get(rem)-1);
            if (tmap.get(rem)==0){
                tmap.remove(rem);
            }
            int temp = tmap.firstKey()+delta;
            ans = Math.min(ans, temp);
        }
        return ans;
    }

    public static void main(String[] args) throws IOException {
        P6003_fail test = new P6003_fail();
        String s1 = "0111001110";
        System.out.println(test.minimumTime(s1));
    }
}
