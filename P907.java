import java.util.Stack;

public class P907 {

    public long numSubArray (int l, int r, int cur){
        return (long) (cur - l + 1) *(r-cur+1);
    }

    public class Pair {
        int a;
        int b;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int[] l = new int[n];
        int[] r = new int[n];
        Stack<Pair> up = new Stack<>();
        for (int i=0; i < n; i++){
            l[i] = i;
            Pair cur = new Pair (arr[i], i);
            while (!up.isEmpty() && arr[i] <= up.peek().a){
                l[i] = l[up.pop().b];
            }
            up.add(cur);
        }
        Stack<Pair> down = new Stack<>();
        for (int i=n-1; i >= 0; i--){
            r[i] = i;
            Pair cur = new Pair (arr[i], i);
            while (!down.isEmpty() && arr[i] < down.peek().a){
                r[i] = r[down.pop().b];
            }
            down.add(cur);
        }
        for (int i=0; i < n; i++){
            System.out.println(i + " " + l[i] + " " + r[i]);
        }
        long ans = 0;
        long mod = 1000000007;
        for (int i=0; i < n; i++){
            ans += arr[i] * numSubArray(l[i], r[i], i);
            ans %= mod;
        }
        return (int)ans;
    }
}
