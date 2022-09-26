import java.util.ArrayList;
import java.util.List;

public class P2178 {

    public long calc (int n){
        return (long)n*(n+1);
    }

    public List<Long> maximumEvenSplit(long finalSum) {
        if (finalSum % 2 == 1) return new ArrayList<>();
        int num = 0;
        while (finalSum >= calc (num)){
            num++;
        }
        num--;
        List<Long> ans = new ArrayList<>();
        for (int i=1; i <= num-1; i++){
            ans.add((long)i*2);
            finalSum -= i*2;
        }
        ans.add(finalSum);
        return ans;
    }
}
