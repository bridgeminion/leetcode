import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class GCJR1B_P1 {

    public static void solve (int n, int[] d){
        Deque<Integer> deq = new LinkedList<>();
        for (int i : d) deq.add(i);
        int ans = 0;
        int max = 0;
        while (!deq.isEmpty()){
            if (deq.size() == 1){
                if (deq.peek() >= max) ans++;
                break;
            }
            int a = deq.peekFirst();
            int b = deq.peekLast();
            if (a < b){
                int rem = deq.pollFirst();
                if (rem >= max){
                    max = rem;
                    ans++;
                }
            }
            else {
                int rem = deq.pollLast();
                if (rem >= max){
                    max = rem;
                    ans++;
                }
            }
        }
        System.out.print(ans);
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        for (int i=1; i <= t; i++){
            int n = Integer.parseInt(br.readLine());
            int[] d = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j < n; j++){
                d[j] = Integer.parseInt(st.nextToken());
            }
            System.out.print("Case #" + i + ": ");
            solve (n, d);
        }
    }
}
