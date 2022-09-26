import java.util.*;

public class P990 {

    public boolean equationsPossible(String[] equations) {
        int n = equations.length;
        Map<Integer, Set<Integer>> same = new HashMap<>();
        for (int i=0; i < 26; i++){
            same.put(i, new HashSet<>());
        }
        for (int i=0; i < n; i++){
            if (equations[i].charAt(1) == '!') continue;
            int a = equations[i].charAt(0)-'a';
            int b = equations[i].charAt(3)-'a';
            same.get(a).add(b);
            same.get(b).add(a);
        }
        boolean[] vis = new boolean[26];
        Queue<Integer> q = new LinkedList<>();
        int[] ids = new int[26];
        int cur_id = 0;
        for (int i=0; i < 26; i++){
            if (!vis[i]){
                vis[i] = true;
                q.add(i);
                while (!q.isEmpty()){
                    int cur = q.remove();
                    ids[cur] = cur_id;
                    for (int j : same.get(cur)){
                        if (!vis[j]){
                            vis[j] = true;
                            q.add(j);
                        }
                    }
                }
                cur_id++;
            }
        }
        for (int i=0; i < n; i++){
            if (equations[i].charAt(1) == '!'){
                int a = equations[i].charAt(0)-'a';
                int b = equations[i].charAt(3)-'a';
                if (ids[a] == ids[b]) return false;
            }
        }
        return true;
    }
}
