import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P539 {

    public int c2 (String s, int index){
        return s.charAt(index)-'0';
    }

    public int convert (String s){
        return 60*(10*c2(s, 0)+c2(s, 1))+10*c2 (s, 3)+c2 (s, 4);
    }

    public int findMinDifference(List<String> timePoints){
        List<Integer> list = new ArrayList<>();
        for (String s : timePoints){
            list.add(convert (s));
        }
        Collections.sort(list);
        for (int i : list){
            System.out.println(i);
        }
        int ans = Integer.MAX_VALUE;
        for (int i=0; i < list.size()-1; i++){
            ans = Math.min(ans, list.get(i+1)-list.get(i));
        }
        int ends = 24*60 - (list.get(list.size()-1)-list.get(0));
        ans = Math.min(ans, ends);
        return ans;
    }
}
