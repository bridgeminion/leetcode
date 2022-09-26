import java.util.*;

public class P2115 {

    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        int n = recipes.length;
        Set<String> supply_set = new HashSet<>(Arrays.asList(supplies));
        List<String> ans = new ArrayList<>();
        Map<String, Integer> map1 = new HashMap<>();
        for (int i=0; i < n; i++){
            map1.put(recipes[i], i);
        }
        Map<Integer, Set<Integer>> reqs = new HashMap<>();
        Map<Integer, Set<Integer>> needsMe = new HashMap<>();
        for (int i=0; i < n; i++){
            needsMe.put(i, new HashSet<>());
        }
        for (int i=0; i < n; i++){
            reqs.put(i, new HashSet<>());
            for (String j : ingredients.get(i)){
                if (map1.containsKey(j)){
                    reqs.get(i).add(map1.get(j));
                    needsMe.get(map1.get(j)).add(i);
                }
            }
        }
        boolean[] vis = new boolean[n];
        while (true){
            int cur = -1;
            for (int i=0; i < n; i++){
                if (!vis[i] && reqs.get(i).size() == 0){
                    cur = i;
                    vis[i] = true;
                    break;
                }
            }
            if (cur == -1) break;
            System.out.println(cur);
            System.out.println(recipes[cur]);
            boolean works = true;
            for (String j : ingredients.get(cur)){
                if (!map1.containsKey(j) && !supply_set.contains(j)) {
                    System.out.println("missing " + j);
                    works = false;
                    break;
                }
            }
            if (works){
                ans.add(recipes[cur]);
                for (int i : needsMe.get(cur)){
                    reqs.get(i).remove(cur);
                }
            }
        }
        return ans;
    }
}
