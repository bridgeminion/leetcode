import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class GCJ_d1000000 {

    public static void solve (int[] arr){
        Arrays.sort(arr);
        int ans = 0;
        for (int i : arr){
            if (i > ans){
                ans++;
            }
        }
        System.out.print(" " + ans);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        for (int i=1; i <= t; i++){
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[n];
            for (int j=0; j < n; j++){
                arr[j] = Integer.parseInt(st.nextToken());
            }
            System.out.print("Case #" + i + ":");
            solve (arr);
            System.out.println();
        }
    }
}
