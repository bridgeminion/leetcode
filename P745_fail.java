import java.util.*;

public class P745_fail {

    class WordFilter {

        Map<String, Set<Integer>> prefixMap = new HashMap<>();
        Map<String, List<Integer>> suffixMap = new HashMap<>();

        public WordFilter(String[] words) {
            for (int i=0; i < words.length; i++){
                for (int j=0; j < Math.min(10, words[i].length()); j++){
                    prefixMap.putIfAbsent(words[i].substring(0, j+1), new HashSet<>());
                    prefixMap.get(words[i].substring(0, j+1)).add(i);
                    int len = words[i].length();
                    suffixMap.putIfAbsent(words[i].substring(len-1-j), new ArrayList<>());
                    suffixMap.get(words[i].substring(len-1-j)).add(i);
                }
            }
        }

        public int f(String prefix, String suffix) {
            if (!prefixMap.containsKey(prefix) || !suffixMap.containsKey(suffix)) return -1;
            Set<Integer> l1 = prefixMap.get(prefix);
            List<Integer> l2 = suffixMap.get(suffix);
            for (int i=l2.size()-1; i >= 0; i--){
                if (l1.contains(l2.get(i))) return l2.get(i);
            }
            return -1;
        }
    }
}
