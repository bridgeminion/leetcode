import java.io.IOException;
import java.util.*;

public class P6049 {

    public Set<String> set = new HashSet<>();

    public boolean valid (int start, int end, int[] nums, int k, int p, String s, List<Integer> spaces){
        int len = end-start+1;
        int count = 0;
        for (int i=start; i <= end; i++){
            if (nums[i]%p == 0) count++;
        }
        if (count > k) return false;
        boolean ans = false;
        if (!set.contains(s.substring(spaces.get(start), spaces.get(end+1)))){
            ans = true;
        }
        set.add(s.substring(spaces.get(start), spaces.get(end+1)));
        return ans;
    }

    public int countDistinct(int[] nums, int k, int p) {
        set.clear();
        int ans = 0;
        int n = nums.length;
        StringBuilder sb = new StringBuilder();
        for (int i=0; i < n; i++){
            sb.append(' ');
            sb.append(nums[i]);
        }
        String s = sb.toString();
        System.out.println("S is " + s);
        List<Integer> spaces = new ArrayList<>();
        for (int i=0; i < s.length(); i++){
            if (s.charAt(i) == ' ') spaces.add(i);
        }
        spaces.add(s.length());
        for (int i=0; i < n; i++){
            for (int j=i; j < n; j++){
                if (valid (i, j, nums, k, p, s, spaces)){
                    ans++;
                }
            }
        }
        for (String i : set) System.out.println(i);
        return ans;
    }

    public static void main(String[] args) {
        P6049 test = new P6049();
        int[] n1 = {2, 3, 3, 2, 2};
        int[] n2 = {6, 20, 5, 18};
        System.out.println(test.countDistinct(n1, 2, 2));
        System.out.println(test.countDistinct(n2, 3, 14));
        System.out.println();
    }
}
