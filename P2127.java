import java.io.IOException;
import java.util.*;

public class P2127 {

    public int process (int cur, Map<Integer, Set<Integer>> rev){
        if (!rev.containsKey(cur)){
            return 0;
        }
        int ans = 0;
        for (int i : rev.get(cur)){
            ans = Math.max(ans, 1+process (i, rev));
        }
        return ans;
    }

    public int maximumInvitations(int[] favorite) {
        int n = favorite.length;
        int ans = 0;
        boolean[] vis = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        for (int i=0; i < n; i++){
            if (!vis[i]){
                Map<Integer, Integer> found = new HashMap<>();
                int cur = i;
                int count = 1;
                while (!vis[cur]){
                    vis[cur] = true;
                    found.put(cur, count);
                    cur = favorite[cur];
                    count++;
                }
                if (found.containsKey(cur)){
                    int len = count-found.get(cur);
                    ans = Math.max(ans, len);
                    if (len == 2){
                        q.add(cur);
                    }
                }
            }
        }
        Map<Integer, Set<Integer>> rev = new HashMap<>();
        for (int i=0; i < n; i++){
            if (favorite[favorite[i]] != i){
                rev.putIfAbsent(favorite[i], new HashSet<>());
                rev.get(favorite[i]).add(i);
            }
        }
        int ans2 = 0;
        while (!q.isEmpty()){
            int cur = q.remove();
            ans2 += 2+process(cur, rev)+process(favorite[cur], rev);
        }
        return Math.max(ans, ans2);
    }

    public static void main(String[] args) throws IOException {
        P2127 test = new P2127();
        int[] fav1 = {2, 2, 1, 2};
        int[] fav2 = {1, 2, 0};
        int[] fav3 = {3,0,1,4,1};
        int[] fav4 = {1,0,0,2,1,4,7,8,9,6,7,10,8};
        int[] fav5 = {1,0,3,2,5,6,7,4,9,8,11,10,11,12,10};
        System.out.println(test.maximumInvitations(fav1));
        System.out.println(test.maximumInvitations(fav2));
        System.out.println(test.maximumInvitations(fav3));
        System.out.println(test.maximumInvitations(fav4));
        System.out.println(test.maximumInvitations(fav5));
    }

}
