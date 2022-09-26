import java.util.LinkedList;
import java.util.Queue;

public class P5990 {

    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        Queue<Integer> pos = new LinkedList<>();
        Queue<Integer> neg = new LinkedList<>();
        for (int i : nums){
            if (i > 0){
                pos.add(i);
            }
            else {
                neg.add(i);
            }
        }
        int[] ans = new int[n];
        for (int i=0; i < n/2; i++){
            ans[i*2] = pos.remove();
            ans[i*2+1] = neg.remove();
        }
        return ans;
    }
}
