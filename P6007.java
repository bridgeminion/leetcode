public class P6007 {


    public int maximumANDSum(int[] nums, int numSlots) {
        int[] count = new int[16];
        int[] slots = new int[numSlots+1];
        int ans = 0;
        for (int i=0; i < nums.length; i++){
            if (nums[i] <= numSlots && slots[nums[i]] < 2){
                slots[nums[i]]++;
                ans += nums[i];
            }
            else {
                count[nums[i]]++;
            }
        }
        int[] order = {8, 9, 10, 11, 12, 13, 14, 15, 4, 5, 6, 7, 2, 3, 1};
        return 0;
    }
}
