import java.io.IOException;
import java.util.TreeMap;

public class P6003 {

    public int minimumTime(String s) {
        int n = s.length();
        boolean[] bad = new boolean[n];
        for (int i=0; i < n; i++){
            bad[i] = s.charAt(i) == '1';
        }
        TreeMap<Integer, Integer> tmap = new TreeMap<>();
        int numbad = 0;
        int[] val = new int[n+1];
        val[0] = n;
        for (int i=0; i < n; i++){
            if (bad[i]){
                numbad++;
            }
            int cur = numbad*2 + (n-1-i);
            val[i+1] = cur;
        }
        int delta = 0;
        for (int i=0; i < n; i++){
            if (bad[i]){
                delta--;
            }
            else {
                delta++;
            }
        }
        int ans = val[n]+delta;
        tmap.put(val[n], 1);
        for (int i=n-1; i >= 0; i--){
            if (bad[i]){
                delta++;
            }
            else {
                delta--;
            }
            tmap.putIfAbsent(val[i], 0);
            tmap.put(val[i], tmap.get(val[i])+1);
            ans = Math.min(ans, tmap.firstKey()+delta);
        }
        return ans;
    }

    public static void main(String[] args) throws IOException {
        P6003 test = new P6003();
        String s1 = "0111001110";
        System.out.println(test.minimumTime(s1));
    }
}
