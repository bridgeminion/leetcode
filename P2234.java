import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class P2234 {

    public boolean works (int x, List<Integer> list, long newFlowers, long[] prefix, int nf){
        int index = Collections.binarySearch(list, x);
        if (index < 0){
            index = -(index+1);
            index--;
        }
        index = Math.min(index, list.size()-nf-1);
        return newFlowers >= ((long) x *(index+1)) - prefix[index+1];
    }

    public long maxPartial (List<Integer> list, long newFLowers, int target, long[] prefix, int nf){
        int hi = target-1;
        int lo = 0;
        int ans = 0;
        while (lo <= hi){
            int mid = (lo+hi)/2;
            if (works (mid, list, newFLowers, prefix, nf)){
                ans = Math.max(ans, mid);
                lo = mid+1;
            }
            else {
                hi = mid-1;
            }
        }
        return ans;
    }

    public long maximumBeauty(int[] flowers, long newFlowers, int target, int full, int partial) {
        int n = flowers.length;
        int nf = 0;
        List<Integer> list = new ArrayList<>();
        for (int i : flowers) list.add(i);
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        for (int i=0; i < n; i++){
            if (list.get(i) >= target) nf++;
        }
        long[] prefix = new long[n+1];
        for (int i=1; i <= n; i++){
            prefix[i] = prefix[i-1] + list.get(i-1);
        }
        long ans = (long) nf *full;
        if (nf < n) {
            ans += maxPartial(list, newFlowers, target, prefix, nf) * partial;
        }
        for (int i=n-nf-1; i >= 0; i--){
            newFlowers -= target-list.get(i);
            if (newFlowers < 0) break;
            long cur = (long) (n-i)*full;
            if (i > 0){
                cur += maxPartial(list, newFlowers, target, prefix, n-i) * partial;
            }
            ans = Math.max(ans, cur);
        }
        return ans;
    }

    public static void main(String[] args) {
        P2234 test = new P2234();
        int[] f = {2, 4, 5, 3};
        int[] f2 = {18, 16, 10, 10, 5};
        int[] f3 = {5,5,15,1,9};

        System.out.println(test.maximumBeauty(f, 10, 5, 2, 6));
        System.out.println(test.maximumBeauty(f2, 10, 3, 15, 4));
        System.out.println(test.maximumBeauty(f3, 36, 12, 9, 2));
    }

}
