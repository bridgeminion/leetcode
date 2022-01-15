import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class P269 {

    Map<Character, Set<Character>> after = new HashMap<>();
    Map<Character, Integer> count = new HashMap<>();
    boolean invalid = false;

    public void process (String s1, String s2){
        int index = 0;
        while (index < s1.length() && index < s2.length() && s1.charAt(index) == s2.charAt(index)){
            index++;
        }
        if (index < s1.length() && index < s2.length()){
            char c1 = s1.charAt(index);
            char c2 = s2.charAt(index);
            if (after.get(c2).contains(c1)){
                invalid = true;
                return;
            }
            after.get(c1).add(c2);
        }
        else if (s1.length() > s2.length()){
            invalid = true;
        }
    }

    public String alienOrder(String[] words) {
        int n = words.length;
        for (String i : words){
            for (int j=0; j < i.length(); j++){
                after.putIfAbsent(i.charAt(j), new HashSet<>());
                after.get(i.charAt(j)).add(i.charAt(j));
            }
        }
        for (int i=0; i < n; i++){
            for (int j=i+1; j < n; j++){
                process (words[j], words[i]);
                if (invalid){
                    return "";
                }
            }
        }
        for (char c : after.keySet()){
            count.put(c, after.get(c).size());
        }
        StringBuilder ans = new StringBuilder();
        int num = count.keySet().size();
        for (int i=0; i < num; i++){
            for (char c : count.keySet()){
                if (count.get(c) == 1){
                    ans.append(c);
                    for (char temp : after.keySet()){
                        if (count.containsKey(temp) && after.get(temp).contains(c)){
                            count.put(temp, count.get(temp)-1);
                        }
                    }
                }
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) throws IOException {
        P269 Cl = new P269();
        String[] words = {"wrt","wrf","er","ett","rftt"};
        System.out.println(Cl.alienOrder (words));
    }

}
