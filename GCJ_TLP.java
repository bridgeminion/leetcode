import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.StringTokenizer;

public class GCJ_TLP {

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
                Map<Integer, Integer> smap = new HashMap<>();
                Map<Integer, Integer> bmap = new HashMap<>();
                for (int j=0; j < k; j++){
                    st = new StringTokenizer(br.readLine());
                    int r = Integer.parseInt(st.nextToken());
                    int p = Integer.parseInt(st.nextToken());
                    if (j%2 == 0){
                        smap.put(r, p);
                        vis[r] = true;
                        System.out.println("W");
                    }
                    else {
                        bmap.put(r, p);
                        vis[r] = true;
                        Random rand = new Random();
                        int randomNum = rand.nextInt(n) + 1;
                        while (vis[randomNum]){
                            randomNum = rand.nextInt(n) + 1;
                        }
                        System.out.println("T " + randomNum);
                    }
                }
                st = new StringTokenizer(br.readLine());
                int r = Integer.parseInt(st.nextToken());
                int p = Integer.parseInt(st.nextToken());
                smap.put(r, p);
                long ssum = 0;
                long bsum = 0;
                for (int j : smap.keySet()){
                    ssum += smap.get(j);
                }
                for (int j : bmap.keySet()){
                    if (!smap.containsKey(j)){
                        bsum += bmap.get(j);
                    }
                }
                double e = ssum + (double)ssum/4001*n + bsum;
                System.out.println("E " + (long)(e/2));
            }
        }
    }
}
