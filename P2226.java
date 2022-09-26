public class P2226 {

    public boolean works (long x, int[] candies, long k){
        if (x == 0) return true;
        long tot = 0;
        for (int i : candies){
            tot += i/x;
        }
        return tot >= k;
    }

    public int maximumCandies(int[] candies, long k) {
        long sum = 0;
        for (int i : candies) sum += i;
        long hi = sum;
        long low = 0;
        long ans = 0;
        while (low <= hi){
            long mid = (low+hi)/2;
            if (works (mid, candies, k)){
                low = mid+1;
                ans = Math.max(ans, mid);
            }
            else {
                hi = mid-1;
            }
        }
        return (int)ans;
    }
}
