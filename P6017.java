import java.util.*;

public class P6017 {

    public long minimalKSum(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums){
            set.add(i);
        }
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        long ans = 0;
        int index = 0;
        while (index < list.size() && list.get(index) <= k){
            index++;
            k++;
        }
        ans = (long)(k)*(k+1);
        ans /= 2;
        for (int i=0; i < index; i++){
            ans -= list.get(i);
        }
        return ans;
    }
}
