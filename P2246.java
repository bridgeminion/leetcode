import java.util.*;

public class P2246 {

    public boolean[] vis = new boolean[100005];
    public int[] val = new int[100005];

    public int len (int cur, Map<Integer, Set<Integer>> child, String s){
        if (!vis[cur]) vis[cur] = true;
        int ans = 1;
        for (int i : child.get(cur)){
            if (s.charAt(cur) != s.charAt(i)){
                ans = Math.max(ans, 1+len (i, child, s));
            }
        }
        val[cur] = ans;
        return val[cur];
    }

    public int longestPath(int[] parent, String s) {
        int n = parent.length;
        Map<Integer, Set<Integer>> child = new HashMap<>();
        for (int i=0; i < n; i++){
            child.put(i, new HashSet<>());
        }
        for (int i=1; i < n; i++){
            child.get(parent[i]).add(i);
        }
        List<Integer> list = new ArrayList<>();
        for (int i=0; i < n; i++){
            if (!vis[i]){
                len (i, child, s);
            }
        }
        for (int i=0; i < n; i++){
            System.out.println(val[i]);
        }
        int ans = 0;
        for (int i=0; i < n; i++){
            list.clear();
            for (int j : child.get(i)){
                if (s.charAt(i) != s.charAt(j)){
                    list.add(val[j]);
                }
            }
            Collections.sort(list, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2-o1;
                }
            });
            if (list.size() >= 2){
                int cur = list.get(0)+list.get(1)+1;
                ans = Math.max(ans, cur);
            }
            ans = Math.max(ans, val[i]);
        }
        return ans;
    }

}
