import java.util.HashMap;
import java.util.Map;

public class P2227 {

    class Encrypter {

        char[] keys;
        String[] values;
        String[] dic;
        Map<Character, Integer> map = new HashMap<>();
        Map<String, Integer> m2 = new HashMap<>();

        public Encrypter(char[] keys, String[] values, String[] dictionary) {
            this.keys = keys;
            this.values = values;
            dic = dictionary;
            for (int i=0; i < keys.length; i++){
                map.put(keys[i], i);
            }
            for (int i=0; i < values.length; i++){
                m2.put(values[i], i);
            }
        }

        public String encrypt(String word1) {
            StringBuilder sb = new StringBuilder();
            for (int i=0; i < word1.length(); i++){
                char c = word1.charAt(i);
                if (!map.containsKey(c)) return "";
                sb.append(values[map.get(c)]);
            }
            return sb.toString();
        }

        public int decrypt(String word2) {
            int ans = 0;
            for (String i : dic){
                if (i.length()*2 == word2.length()){
                    if (encrypt(i).equals(word2)){
                        ans++;
                    }
                }
            }
            return ans;
        }
    }
}
