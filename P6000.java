import java.util.*;

public class P6000 {

    public int[] sortEvenOdd(int[] nums) {
        int n = nums.length;
        List<Integer> odd = new ArrayList<>();
        List<Integer> even = new ArrayList<>();
        for (int i=0; i < nums.length; i++){
            if (i % 2 == 0) {
                even.add(nums[i]);
            }
            else {
                odd.add(nums[i]);
            }
        }
        Collections.sort(even);
        Collections.sort(odd, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        int[] ans = new int[n];
        for (int i=0; i < n; i++){
            if (i%2 == 0){
                ans[i] = even.get(i/2);
            }
            else {
                ans[i] = odd.get(i/2);
            }
        }
        return ans;
    }
}
