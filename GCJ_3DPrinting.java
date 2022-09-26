import java.io.*;
import java.util.StringTokenizer;

public class GCJ_3DPrinting {

    public static void solve (int[][] arr){
        int total = 0;
        int[] ans = new int[4];
        for (int i=0; i < 4; i++){
            int min = 1000000;
            for (int j=0; j < 3; j++){
                min = Math.min(min, arr[j][i]);
            }
            min = Math.min(min, (1000000-total));
            total += min;
            ans[i] = min;
        }
        if (total < 1000000){
            System.out.println(" IMPOSSIBLE");
            return;
        }
        for (int i=0; i < 4; i++){
            System.out.print(" " + ans[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        for (int i=1; i <= t; i++){
            int[][] arr = new int[3][4];
            for (int j=0; j < 3; j++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int k=0; k < 4; k++){
                    arr[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            System.out.print("Case #" + i + ":");
            solve (arr);
        }
    }
}
