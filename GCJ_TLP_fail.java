import java.io.*;
import java.util.*;

public class GCJ_TLP_fail {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        for (int i=1; i <= t; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            boolean[] vis = new boolean[n+1];
            if (k >= n-1){
                long sum = 0;
                int index = 1;
                for (int j = 0; j < n; j++){
                    st = new StringTokenizer(br.readLine());
                    int r = Integer.parseInt(st.nextToken());
                    int p = Integer.parseInt(st.nextToken());
                    sum += p;
                    vis[r] = true;
                    while (index <= n && vis[index]){
                        index++;
                    }
                    if (j < n-1){
                        System.out.println("T " + index);
                    }
                    else {
                        long ans = sum/2;
                        System.out.println("E " + ans);
                    }
                }
            }
            else {
                long sum = 0;
                for (int j = 0; j < k+1; j++){
                    st = new StringTokenizer(br.readLine());
                    int r = Integer.parseInt(st.nextToken());
                    int p = Integer.parseInt(st.nextToken());
                    sum += p;
                    vis[r] = true;
                    Random rand = new Random();
                    int randomNum = rand.nextInt(n) + 1;
                    while (vis[randomNum]){
                        randomNum = rand.nextInt(n) + 1;
                    }
                    if (j < k){
                        System.out.println("T " + randomNum);
                    }
                    else {
                        long ans = sum*n;
                        ans /= 2;
                        ans /= k;
                        System.out.println("E " + ans);
                    }
                }
            }
        }
    }
}
