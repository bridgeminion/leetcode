public class P2216 {

    public int minDeletion(int[] nums) {
        int n = nums.length;
        int index = 0;
        int ans = 0;
        while (index < n){
            int r = index+1;
            while (r < n && nums[index] == nums[r]){
                r++;
                ans++;
            }
            index = r+1;
        }
        if ((n-ans)%2 == 1) ans++;
        return ans;
    }
}
