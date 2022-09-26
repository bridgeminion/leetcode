import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class P2231 {

    public int largestInteger(int num) {
        List<Boolean> even = new ArrayList<>();
        List<Integer> ed = new ArrayList<>();
        List<Integer> od = new ArrayList<>();
        while (num > 0){
            int cur = num%10;
            if (cur%2 == 0){
                even.add(true);
                ed.add(cur);
            }
            else {
                even.add(false);
                od.add(cur);
            }
            num /= 10;
        }
        Collections.sort(ed, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        Collections.sort(od, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        int ans = 0;
        int eindex = 0;
        int oindex = 0;
        for (int i=even.size()-1; i >= 0; i--){
            ans *= 10;
            if (even.get(i)){
                ans += ed.get(eindex);
                eindex++;
            }
            else {
                ans += od.get(oindex);
                oindex++;
            }
        }
        return ans;
    }
}
