import java.util.Comparator;
import java.util.PriorityQueue;

public class P2233 {

    public int maximumProduct(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        for (int i : nums) pq.add(i);
        for (int i=0; i < k; i++){
            pq.add(pq.poll()+1);
        }
        long ans = 1;
        long mod = 1000000007;
        for (int i : pq){
            ans *= i;
            ans %= mod;
        }
        return (int)ans;
    }
}
