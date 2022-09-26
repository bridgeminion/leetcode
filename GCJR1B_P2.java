import java.io.*;
import java.util.StringTokenizer;

public class GCJR1B_P2 {

    public static void solve (int n, long[][] pos){
        long sum = 0;
        for (int i=0; i < n; i++){
            sum += pos[i][1]-pos[i][0];
        }
        long[][] dp = new long[n][2];
        dp[0][0] = pos[0][0];
        dp[0][1] = pos[0][1];
        for (int i=1; i < n; i++){
            for (int j=0; j < 2; j++){
                dp[i][j] = Long.MAX_VALUE;
            }
        }
        for (int i=1; i < n; i++){
            dp[i][0] = Math.min(dp[i-1][0]+Math.abs(pos[i-1][1]-pos[i][0]), dp[i-1][1]+Math.abs(pos[i-1][0]-pos[i][0]));
            dp[i][1] = Math.min(dp[i-1][0]+Math.abs(pos[i-1][1]-pos[i][1]), dp[i-1][1]+Math.abs(pos[i-1][0]-pos[i][1]));
        }
        long ans = Math.min(dp[n-1][0], dp[n-1][1]);
        ans += sum;
        System.out.print(ans);
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        for (int i=1; i <= t; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            long[][] pos = new long[n][2];
            for (int j=0; j < n; j++){
                int min = Integer.MAX_VALUE;
                int max = Integer.MIN_VALUE;
                st = new StringTokenizer(br.readLine());
                for (int k=0; k < p; k++){
                    int cur = Integer.parseInt(st.nextToken());
                    min = Math.min(min, cur);
                    max = Math.max(max, cur);
                }
                pos[j][0] = min;
                pos[j][1] = max;
            }
            System.out.print("Case #" + i + ": ");
            solve (n, pos);
        }
    }
}
