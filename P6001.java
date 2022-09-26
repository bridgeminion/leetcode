import java.util.*;

public class P6001 {

    public long getLargest (long num){
        if (num == 0) return 0;
        List<Long> digits = new ArrayList<>();
        while (num > 0){
            digits.add(num%10);
            num /= 10;
        }
        Collections.sort(digits, new Comparator<Long>() {
            @Override
            public int compare(Long o1, Long o2) {
                return Long.compare(o2, o1);
            }
        });
        long ans = 0;
        for (Long i : digits){
            ans *= 10;
            ans += i;
        }
        return ans;
    }

    public long getSmallest (long num){
        if (num == 0) return 0;
        List<Long> digits = new ArrayList<>();
        while (num > 0){
            digits.add(num%10);
            num /= 10;
        }
        Collections.sort(digits);
        long ans = 0;
        int nonzero = 0;
        while (digits.get(nonzero) == 0){
            nonzero++;
        }
        ans = digits.get(nonzero);
        for (int i=0; i < nonzero; i++){
            ans *= 10;
        }
        for (int i=nonzero+1; i < digits.size(); i++){
            ans *= 10;
            ans += digits.get(i);
        }
        return ans;
    }

    public long smallestNumber(long num) {
        if (num < 0){
            return -getLargest(-num);
        }
        return getSmallest(num);
    }
}
