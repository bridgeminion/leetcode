import java.util.*;

public class P1345 {

    public int minJumps(int[] arr) {
        int n = arr.length;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i=0; i < n; i++){
            map.putIfAbsent(arr[i], new HashSet<>());
            map.get(arr[i]).add(i);
        }
        boolean[] vis = new boolean[n];
        boolean[] vis2 = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        vis[0] = true;
        int ans = 0;
        while (!q.isEmpty()){
            int size = q.size();
            for (int i=0; i < size; i++){
                int cur = q.remove();
                if (cur == n-1) return ans;
                int forw = cur+1;
                int back = cur-1;
                if (forw >= 0 && forw < n && !vis[forw]){
                    vis[forw] = true;
                    q.add(forw);
                }
                if (back >= 0 && back < n && !vis[back]){
                    vis[back] = true;
                    q.add(back);
                }
                if (map.containsKey(arr[cur])){
                    for (int j : map.get(arr[cur])){
                        if (!vis[j]){
                            vis[j] = true;
                            q.add(j);
                        }
                    }
                    map.remove(arr[cur]);
                }
            }
            ans++;
        }
        return ans;
    }

}
