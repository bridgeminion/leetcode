import java.io.IOException;
import java.util.*;

public class P6005 {

    public class Pair {
        int a;
        int b;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    public int minimumOperations(int[] nums) {
        int n = nums.length;
        if (n == 1) return 0;
        Map<Integer, Integer> ec1 = new HashMap<>();
        Map<Integer, Integer> oc1 = new HashMap<>();
        List<Pair> even = new ArrayList<>();
        List<Pair> odd = new ArrayList<>();
        for (int i=0; i < n; i++){
            if (i%2 == 0){
                ec1.putIfAbsent(nums[i], 0);
                ec1.put(nums[i], ec1.get(nums[i])+1);
            }
            else {
                oc1.putIfAbsent(nums[i], 0);
                oc1.put(nums[i], oc1.get(nums[i])+1);
            }
        }
        for (int i : ec1.keySet()){
            even.add(new Pair (i, ec1.get(i)));
        }
        for (int i : oc1.keySet()){
            odd.add(new Pair (i, oc1.get(i)));
        }
        Collections.sort(even, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o2.b-o1.b;
            }
        });
        Collections.sort(odd, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o2.b-o1.b;
            }
        });
        if (even.get(0).a == odd.get(0).a){
            int en = 0;
            if (even.size() > 1){
                en = even.get(1).b;
            }
            int on = 0;
            if (odd.size() > 1){
                on = odd.get(1).b;
            }
            return Math.min(n-even.get(0).b-on, n-odd.get(0).b-en);
        }
        else {
            return n-even.get(0).b-odd.get(0).b;
        }
//        if (Objects.equals(even.lastKey(), odd.lastKey())){
//            int ec = even.lastEntry().getValue();
//            int oc = odd.lastEntry().getValue();
//            even.remove(even.lastKey());
//            odd.remove(odd.lastKey());
//            int en = 0;
//            if (even.size() > 0){
//                en = even.lastEntry().getValue();
//            }
//            int on = 0;
//            if (odd.size() > 0){
//                on = odd.lastEntry().getValue();
//            }
//            return Math.min(n-ec+on, n-oc+en);
//        }
//        else {
//            return n-even.lastEntry().getValue()-odd.lastEntry().getValue();
//        }
    }

    public static void main(String[] args) throws IOException {
        P6005 test = new P6005();
        int[] nums = {3,1,3,2,4,3};
        int[] nums2 = {69,91,47,74,75,94,22,100,43,50,82,47,40,51,90,27,98,85,47,14,55,82,52,9,65,90,86,45,52,52,95,40,85,3,46,77,16,59,32,22,41,87,89,78,59,78,34,26,71,9,82,68,80,74,100,6,10,53,84,80,7,87,3,82,26,26,14,37,26,58,96,73,41,2,79,43,56,74,30,71,6,100,72,93,83,40,28,79,24};
        System.out.println(test.minimumOperations(nums2));
    }
}
