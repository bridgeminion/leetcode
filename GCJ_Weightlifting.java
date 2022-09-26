import java.io.*;
import java.util.StringTokenizer;

public class GCJ_Weightlifting {

    public static void solve (int e, int w, long[][] weights){
        long[][] c = new long[e][e];
        for (int i=0; i < e; i++){
            long[] start = new long[w];
            for (int j=0; j < w; j++){
                start[j] = weights[i][j];
                c[i][i] += weights[i][j];
            }
            for (int j=i+1; j < e; j++){
                for (int k=0; k < w; k++){
                    start[k] = Math.min(start[k], weights[j][k]);
                    c[i][j] += start[k];
                }
            }
        }
        long[][] dp = new long[e][e];
        for (int i=0; i < e; i++){
            for (int j=0; j < e; j++){
                if (i != j) dp[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int len=2; len <= e; len++){
            for (int i=0; i <= e-len; i++){
                for (int x=i; x < i+len-1; x++){
                    dp[i][i+len-1] = Math.min(dp[i][i+len-1], dp[i][x]+2*(c[i][x]-c[i][i+len-1])+dp[x+1][i+len-1]+2*(c[x+1][i+len-1]-c[i][i+len-1]));
                }
            }
        }
        long ans = dp[0][e-1] + 2*c[0][e-1];
        System.out.print(ans);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        for (int i=1; i <= t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            long[][] weights = new long[e][w];
            for (int j=0; j < e; j++){
                st = new StringTokenizer(br.readLine());
                for (int k=0; k < w; k++){
                    weights[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            System.out.print("Case #" + i + ": ");
            solve (e, w, weights);
            System.out.println();
        }
    }
}
