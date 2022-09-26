import java.io.*;
import java.util.*;

public class GCJ_ChainReactions {

    public static void solve (int n, int[] fun, int[] point){
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i=0; i < n; i++){
            map.putIfAbsent(i, new ArrayList<>());
        }
        for (int i=0; i < n; i++){
            if (point[i] != -1){
                map.get(point[i]).add(i);
            }
        }
        long[] val = new long[n];
        long ans = 0;
        for (int i=n-1; i >= 0; i--){
            if (map.get(i).size() == 0){
                val[i] = fun[i];
            }
            else {
                long min = 1000000000;
                long tot = 0;
                for (int j : map.get(i)){
                    if (i != j){
                        tot += val[j];
                        min = Math.min(min, val[j]);
                    }
                }
                ans += tot - min;
//                System.out.println(i + " " + ans);
                val[i] = Math.max(fun[i], min);
            }
            if (point[i] == i || point[i] == -1){
                ans += val[i];
            }
        }
        System.out.print(" " + ans);
//        System.out.println();
//        for (int i=0; i < n; i++){
//            System.out.println(i + " " + val[i]);
//        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        for (int i=1; i <= t; i++){
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] fun = new int[n];
            for (int j=0; j < n; j++){
                fun[j] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            int[] point = new int[n];
            for (int j=0; j < n; j++){
                point[j] = Integer.parseInt(st.nextToken())-1;
            }
            System.out.print("Case #" + i + ":");
            solve (n, fun, point);
            System.out.println();
        }
    }
}
