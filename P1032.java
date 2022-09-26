import java.util.*;

public class P1032 {

    class StreamChecker {

        Set<String> set = new HashSet<>();
        List<Character> list = new ArrayList<>();

        public StreamChecker(String[] words) {
            StringBuilder sb;
            for (int i=0; i < words.length; i++){
                sb = new StringBuilder();
                for (int j=0; j < words[i].length(); j++){
                    sb.append(words[i].charAt(words[i].length()-1-j));
                }
                set.add(sb.toString());
            }
        }

        public boolean query(char letter) {
            list.add(letter);
            int n = list.size();
            StringBuilder temp = new StringBuilder();
            for (int i=1; i <= Math.min(n, 2000); i++){
                temp.append(list.get(n-i));
                if (set.contains(temp.toString())) return true;
            }
            return false;
        }
    }
}
