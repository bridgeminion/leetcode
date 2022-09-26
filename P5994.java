import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class P5994 {

    public List<Integer> maxScoreIndices(int[] nums) {
        int n = nums.length;
        TreeMap<Integer, List<Integer>> tmap = new TreeMap<>();
        int cur = 0;
        for (int i=0; i < n; i++) {
            if (nums[i] == 1){
                cur++;
            }
        }
        tmap.putIfAbsent(cur, new ArrayList<>());
        tmap.get(cur).add(0);
        for (int j=0; j < n; j++){
            if (nums[j] == 0){
                cur++;
            }
            else {
                cur--;
            }
            tmap.putIfAbsent(cur, new ArrayList<>());
            tmap.get(cur).add(j+1);
        }
        return tmap.get(tmap.lastKey());
    }
}
