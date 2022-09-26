public class P410 {

    public static boolean works (int x, int[] nums, int m){
        int cur = 0;
        int groups = 1;
        for (int i : nums){
            if (i > x) return false;
            if (cur+i <= x){
                cur += i;
            }
            else {
                cur = i;
                groups++;
            }
            if (groups > m) return false;
        }
        return true;
    }

    public int splitArray(int[] nums, int m) {
        int low = 0;
        int high = Integer.MAX_VALUE;
        int ans = Integer.MAX_VALUE;
        while (low <= high){
            int mid = (low+high)/2;
            System.out.println(mid);
            if (works (mid, nums, m)){
                high = mid-1;
                ans = Math.min(ans, mid);
            }
            else {
                low = mid+1;
            }
        }
        return ans;
    }
}
