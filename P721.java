import java.io.IOException;
import java.util.*;

public class P721 {

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        Map<Integer, Set<String>> emails = new HashMap<>();
        for (int i=0; i < n; i++){
            emails.put(i, new HashSet<>());
            for (int j=1; j < accounts.get(i).size(); j++){
                emails.get(i).add(accounts.get(i).get(j));
            }
        }
        Map<Integer, Set<Integer>> adj = new HashMap<>();
        for (int i=0; i < n; i++){
            adj.put(i, new HashSet<>());
        }
        for (int i=0; i < n; i++){
            for (int j=0; j < n; j++){
                if (i != j){
                    for (String k : emails.get(i)){
                        if (emails.get(j).contains(k)){
                            adj.get(i).add(j);
                            adj.get(j).add(i);
                            break;
                        }
                    }
                }
            }
        }
        boolean[] vis = new boolean[n];
        List<List<String>> ans = new ArrayList<>();
        Set<String> set = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        for (int i=0; i < n; i++){
            if (!vis[i]){
                set.clear();
                q.clear();
                q.add(i);
                vis[i] = true;
                while (!q.isEmpty()){
                    int cur = q.remove();
                    set.addAll(emails.get(cur));
                    for (int j : adj.get(cur)){
                        if (!vis[j]){
                            vis[j] = true;
                            q.add(j);
                        }
                    }
                }
                List<String> list = new ArrayList<>();
                list.add(accounts.get(i).get(0));
                List<String> temp = new ArrayList<>(set);
                Collections.sort(temp);
                list.addAll(temp);
                ans.add(list);
            }
        }
        return ans;
    }

    public static void main(String[] args) throws IOException {
        P721 test = new P721();
        List<List<String>> accounts = new ArrayList<>();
        for (int i=0; i < 4; i++) accounts.add(new ArrayList<>());
        accounts.get(0).add("John");
        accounts.get(0).add("johnsmith@mail.com");
        accounts.get(0).add("john_newyork@mail.com");
        accounts.get(1).add("John");
        accounts.get(1).add("johnsmith@mail.com");
        accounts.get(1).add("john00@mail.com");
        accounts.get(2).add("Mary");
        accounts.get(2).add("mary@mail.com");
        accounts.get(3).add("John");
        accounts.get(3).add("johnnybravo@mail.com");
        System.out.println(test.accountsMerge(accounts));
    }
}
