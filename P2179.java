
public class P2179 {

    public static class BinaryIndexedTree {

        static int[] BIT;
        static int n;

        public BinaryIndexedTree (int[] arr){
            n = arr.length;
            BIT = new int[n+1];
            for (int i = 0; i < n; i++)
                updateBIT(i, arr[i]);
        }

        int getSum(int index) {
            int sum = 0;
            index = index + 1;
            while (index > 0) {
                sum += BIT[index];
                index -= index & (-index);
            }
            return sum;
        }

        void updateBIT(int index, int val) { // val is delta
            index = index + 1;
            while (index <= n) {
                BIT[index] += val;
                index += index & (-index);
            }
        }

    }


    public long goodTriplets(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] pos2 = new int[n];
        for (int i=0; i < n; i++){
            pos2[nums2[i]] = i;
        }
        BinaryIndexedTree b1 = new BinaryIndexedTree(new int[n]);
        int[] left = new int[n];
        for (int i=1; i < n; i++){
            int pos = pos2[nums1[i-1]];
            b1.updateBIT(pos, 1);
            left[nums1[i]] = b1.getSum(pos2[nums1[i]]);
//            System.out.println(left[nums1[i]]);
        }
        BinaryIndexedTree b2 = new BinaryIndexedTree(new int[n]);
        int[] right = new int[n];
        for (int i=n-2; i >= 0; i--){
            int pos = pos2[nums1[i+1]];
            b2.updateBIT(pos, 1);
            right[nums1[i]] = b2.getSum(n-1) - b2.getSum(pos2[nums1[i]]);
        }
        long ans = 0;
        for (int i=0; i < n; i++){
            ans += (long)left[i] * right[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        P2179 test = new P2179();
        int[] a1 = {13,14,10,2,12,3,9,11,15,8,4,7,0,6,5,1};
        int[] a2 = {8,7,9,5,6,14,15,10,2,11,4,13,3,12,1,0};
        System.out.println(test.goodTriplets(a1, a2));
    }
}
