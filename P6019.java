import java.util.*;

public class P6019 {

    public long gcd (long a, long b) {
        if (b==0) return a;
        return gcd(b,a%b);
    }

    public long LCM (long a, long b){
        long temp = a*b;
        temp /= gcd (a, b);
        return temp;
    }

    public List<Integer> replaceNonCoprimes(int[] nums) {
        Queue<Integer> q = new LinkedList<>();
        for (int i : nums) q.add(i);
        Stack<Long> stack = new Stack<>();
        while (!q.isEmpty()){
            long cur = q.remove();
            boolean go = true;
            while (go){
                go = false;
                while (!q.isEmpty() && gcd (cur, q.peek()) > 1){
                    go = true;
                    cur = LCM (cur, q.remove());
                }
                while (!stack.isEmpty() && gcd (cur, stack.peek()) > 1){
                    go = true;
                    cur = LCM (cur, stack.pop());
                }
            }
            stack.add(cur);
        }
        List<Integer> ans = new ArrayList<>();
        for (long i : stack){
            ans.add((int)i);
        }
        return ans;
    }
}
