import java.util.HashSet;
import java.util.Set;

public class P2179_fail {

    public long goodTriplets(int[] nums1, int[] nums2) {
        int n = nums1.length;
        Set<Integer> s1 = new HashSet<>();
        Set<Integer> s2 = new HashSet<>();
        int[] before = new int[n];
        int[] after = new int[n];
        s1.add(nums1[0]);
        s2.add(nums2[0]);
        Set<Integer> both = new HashSet<>();
        for (int i=1; i < n; i++){
            if (s2.contains(nums1[i-1])){
                both.add(nums1[i-1]);
            }
            if (s1.contains(nums2[i-1])){
                both.add(nums2[i-1]);
            }
            before[i] = both.size();
            s1.add(nums1[i]);
            s2.add(nums2[i]);
        }
        s1.clear();
        s2.clear();
        both.clear();
        s1.add(nums1[n-1]);
        s2.add(nums2[n-1]);
        for (int i=n-2; i >= 0; i--){
            if (s2.contains(nums1[i+1])){
                both.add(nums1[i+1]);
            }
            if (s1.contains(nums2[i+1])){
                both.add(nums2[i+1]);
            }
            after[i] = both.size();
            s1.add(nums1[i]);
            s2.add(nums2[i]);
        }
        for (int i=0; i < n; i++){
            System.out.println(i + " " + before[i]);
        }
        System.out.println();
        for (int i=0; i < n; i++){
            System.out.println(after[i]);
        }
        long ans = 0;
        for (int i=0; i < n; i++){
            ans += (long)before[i]*after[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        P2179_fail test = new P2179_fail();
        int[] a1 = {13,14,10,2,12,3,9,11,15,8,4,7,0,6,5,1};
        int[] a2 = {8,7,9,5,6,14,15,10,2,11,4,13,3,12,1,0};
        System.out.println(test.goodTriplets(a1, a2));
    }
}
