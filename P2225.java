import java.util.*;

public class P2225 {

    public List<List<Integer>> findWinners(int[][] matches) {
        int n = matches.length;
        Map<Integer, Integer> nl = new HashMap<>();
        for (int i=0; i < n; i++){
            nl.putIfAbsent(matches[i][0], 0);
            nl.putIfAbsent(matches[i][1], 0);
            nl.put(matches[i][1], nl.get(matches[i][1])+1);
        }
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        ans.add(new ArrayList<>());
        for (int i : nl.keySet()){
            if (nl.get(i)==0) ans.get(0).add(i);
            if (nl.get(i)==1) ans.get(1).add(i);
        }
        Collections.sort(ans.get(0));
        Collections.sort(ans.get(1));
        return ans;
    }
}
