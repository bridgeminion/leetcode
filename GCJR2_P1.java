import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class GCJR2_P1 {

    public static class Pair {
        int a;
        int b;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    public static List<Pair> ans = new ArrayList<>();
    public static boolean works = true;

    public static void solve (int n, int k, int add){
        if (n == 1) return;
        if (!(k%2 == 0 && k >= n-1 && k <= n*n-1)){
            System.out.println("IMPOSSIBLE");
            works = false;
            return;
        }
        if (k >= 4*(n-1)+n-3){
            solve (n-2, k-4*(n-1), add+4*(n-1));
        }
        else {
            k -= n-1;
            int q = k/(n-1);
            int r = k%(n-1);
            int start = (n+1)/2 + q*(n-1) + r/2;
            int end = start + 4*(n-1) - 1 - q*2;
            if (end-1 > start){
                ans.add(new Pair (start+add, end+add));
            }
            solve (n-2, end - 4*(n-1) - 1 + k - start + n-1, add+4*(n-1));
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        for (int i=1; i <= t; i++){
            ans.clear();
            works = true;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            System.out.print("Case #" + i + ": ");
            solve (n, k, 0);
            if (works){
                System.out.println(ans.size());
                for (int j=0; j < ans.size(); j++){
                    System.out.println(ans.get(j).a + " " + ans.get(j).b);
                }
            }
        }
    }
}
