import java.util.Arrays;

public class P5983_improved {

    public long maxRunTime(int n, int[] batteries) {
        long tot = 0;
        for (int i : batteries){
            tot += i;
        }
        Arrays.sort(batteries);
        for (int i=batteries.length-1; i >= 0; i--){
            if ((long)batteries[i]*n > tot){
                tot -= batteries[i];
                n--;
            }
            else {
                return tot/n;
            }
        }
        return 0;
    }
}
