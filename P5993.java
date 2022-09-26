import java.util.HashSet;
import java.util.Set;

public class P5993 {

    public int findFinalValue(int[] nums, int original) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums){
            set.add(i);
        }
        while (set.contains(original)){
            original *= 2;
        }
        return original;
    }
}
