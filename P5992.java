import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P5992 {

    public boolean test (boolean[] good, int[][] statements, int n){
        for (int i=0; i < n; i++){
            for (int j=0; j < n; j++){
                if (i != j){
                    if (good[i] && statements[i][j] != 2){
                        if (good[j] && statements[i][j] == 0){
                            return false;
                        }
                        if (!good[j] && statements[i][j] == 1){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public int maximumGood(int[][] statements) {
        int n = statements.length;
        int ans = 0;
        for (int i=(1<<n)-1; i >= 0; i--){
            boolean[] good = new boolean[n];
            int cur = 0;
            for (int j=0; j < n; j++){
                good[j] = (i & (1 << j)) > 0;
                if (good[j]){
                    cur++;
                }
            }
            if (cur <= ans){
                continue;
            }
            if (test (good, statements, n)){
                ans = Math.max(ans, cur);
            }
        }
        return ans;
    }

    public static void main(String[] args) throws IOException {
        P5992 test = new P5992();
        int[][] s1 = {{2,1,2}, {1,2,2}, {2,0,2}};
        System.out.println(test.maximumGood(s1));
    }

}
