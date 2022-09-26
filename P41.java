public class P41 {

    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i=0; i < n; i++){
            int cur = nums[i];
            while (cur >= 1 && cur <= n && nums[cur-1] != cur){
                int temp = cur;
                cur = nums[cur-1];
                nums[temp-1] = temp;
            }
        }
        for (int i=0; i < n; i++){
            if (nums[i] != i+1) return i+1;
        }
        return n+1;
    }
}
