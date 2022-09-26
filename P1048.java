import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class P1048 {

    public boolean contains (String w1, String w2){
        if (w1.length() != w2.length()+1) return false;
        boolean bad = false;
        for (int i=0; i < w2.length(); i++){
            if (bad){
                if (w1.charAt(i+1) != w2.charAt(i)) return false;
            }
            else {
                if (w1.charAt(i) != w2.charAt(i)) {
                    bad = true;
                    if (w1.charAt(i+1) != w2.charAt(i)) return false;
                }
            }
        }
        return true;
    }

    public int longestStrChain(String[] words) {
        int n = words.length;
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        int[] val = new int[n];
        for (int i=0; i < n; i++) val[i] = 1;
        for (int i=0; i < n; i++){
            for (int j=0; j < i; j++){
                if (contains(words[i], words[j])){
                    val[i] = Math.max(val[i], val[j]+1);
                }
            }
        }
        int ans = 1;
        for (int i=0; i < n; i++) ans = Math.max(ans, val[i]);
        return ans;
    }
}
