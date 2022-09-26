import java.io.IOException;
import java.util.Objects;
import java.util.TreeMap;

public class P726 {

    public long convert (String num){
        if (Objects.equals(num, "")) return 1;
        long ans = 0;
        for (int i=0; i < num.length(); i++){
            ans *= 10;
            ans += num.charAt(i)-'0';
        }
        return ans;
    }

    public void solve (String s, TreeMap<String, Long> map, long factor){
        int n = s.length();
        int index=0;
        while (index < n){
            char c = s.charAt(index);
            if (c == '('){
                int right = -1;
                int net = 0;
                for (int i=index+1; i < n; i++){
                    if (s.charAt(i) == '(') net++;
                    if (s.charAt(i) == ')') net--;
                    if (net == -1){
                        right = i;
                        break;
                    }
                }
                int ni = right+1;
                while (ni < n && Character.isDigit(s.charAt(ni))){
                    ni++;
                }
                solve (s.substring(index+1, right), map, convert(s.substring(right+1, ni))*factor);
                index = ni;
            }
            else if (Character.isUpperCase(c)){
                int start = index;
                index++;
                while (index < n && Character.isLowerCase(s.charAt(index))){
                    index++;
                }
                String name = s.substring(start, index);
                int ni = index;
                while (ni < n && Character.isDigit(s.charAt(ni))){
                    ni++;
                }
                long count = convert (s.substring(index, ni))*factor;
                map.putIfAbsent(name, 0L);
                map.put(name, map.get(name)+count);
                System.out.println("Added " + count + " to " + name + " factor = " + factor);
                index = ni;
            }
        }
    }

    public String countOfAtoms(String formula) {
        TreeMap<String, Long> map = new TreeMap<>();
        solve (formula, map, 1);
        StringBuilder sb = new StringBuilder();
        for (String i : map.keySet()){
            sb.append(i);
            if (map.get(i) > 1){
                sb.append(map.get(i));
            }
        }
        String ans = sb.toString();
        return ans;
    }

    public static void main(String[] args) {
        P726 test = new P726();
        System.out.println(test.countOfAtoms("K4(ON(SO3)2)2"));
    }
}
